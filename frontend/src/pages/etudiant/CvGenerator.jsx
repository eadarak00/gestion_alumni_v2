import { useState, useRef, useEffect, useCallback } from 'react';
import { useReactToPrint } from 'react-to-print';
import { Plus, Trash2, Download, User, GraduationCap, Briefcase, Code2, Languages, Heart, Save } from 'lucide-react';
import CvTemplate from '../../components/etudiant/CvTemplate';
import { cvService } from '../../services/msCV/cvService';
import { useAuth } from '../../hooks/useAuth';
import { useToast } from '../../hooks/useToast';

export const CvGenerator = () => {
    const { user } = useAuth();
    const { toast } = useToast();
    const [cvId, setCvId] = useState(null);
    const [loading, setLoading] = useState(false);

    const [data, setData] = useState({
        templateId: 1,
        titreProfil: '',
        nom: '',
        prenom: '',
        email: '',
        telephone: '',
        adresse: '',
        resumeProfil: '',
        formations: [{ diplome: '', etablissement: '', ville: '', anneeDebut: '', anneeFin: '' }],
        experiences: [{ poste: '', entreprise: '', ville: '', dateDebut: '', dateFin: '', description: '' }],
        competences: [{ nom: '', niveau: 'INTERMEDIAIRE' }],
        langues: [{ nom: 'FRANCAIS', niveau: 'DEBUTANT' }],
        interets: [{ libelle: '' }],
        // Champs hors contrat v2 mais utiles pour l'UI
        linkedin: '',
        github: '',
        portfolio: '',
        photo: ''
    });

    /* CHARGEMENT DES DONNEES */
    const loadCv = useCallback(async () => {
        if (!user) return;
        setLoading(true);
        try {
            const cv = await cvService.getStudentCv();
            if (cv) {
                setCvId(cv.id);
                const fullCv = await cvService.getFullCv(cv.id);

                setData(prev => ({
                    ...prev,
                    templateId: fullCv.templateId || 1,
                    titreProfil: fullCv.titreProfil || '',
                    nom: fullCv.nom || user.nom || '',
                    prenom: fullCv.prenom || user.prenom || '',
                    email: fullCv.email || user.email || '',
                    telephone: fullCv.telephone || '',
                    adresse: fullCv.adresse || '',
                    resumeProfil: fullCv.resumeProfil || '',

                    experiences: fullCv.experiences?.map(e => ({
                        poste: e.poste || '',
                        entreprise: e.entreprise || '',
                        ville: e.ville || '',
                        dateDebut: e.dateDebut || '',
                        dateFin: e.dateFin || '',
                        description: e.description || ''
                    })) || [],

                    formations: fullCv.formations?.map(f => ({
                        diplome: f.diplome || '',
                        etablissement: f.etablissement || '',
                        ville: f.ville || '',
                        anneeDebut: f.anneeDebut || '',
                        anneeFin: f.anneeFin || ''
                    })) || [],

                    competences: fullCv.competences?.map(c => ({
                        nom: c.nom || '',
                        niveau: c.niveau || 'INTERMEDIAIRE'
                    })) || [],

                    langues: fullCv.langues?.map(l => ({
                        nom: l.nom || '',
                        niveau: l.niveau || 'DEBUTANT'
                    })) || [],

                    interets: fullCv.interets?.map(i => ({
                        libelle: i.libelle || ''
                    })) || []
                }));
            } else {
                setData(prev => ({
                    ...prev,
                    nom: user.nom || '',
                    prenom: user.prenom || '',
                    email: user.email || ''
                }));
            }
        } catch (error) {
            console.error("Erreur chargement CV", error);
            toast.error("Impossible de charger votre CV.");
        } finally {
            setLoading(false);
        }
    }, [user, toast]);

    useEffect(() => {
        loadCv();
    }, [loadCv]);

    /* SAUVEGARDE */
    /* HELPERS FORMATTAGE */
    const formatPhone = (phone) => {
        if (!phone) return '';
        const cleaned = phone.replace(/\s+/g, '');
        if (cleaned.startsWith('+221') && cleaned.length === 13) return cleaned;
        if (cleaned.startsWith('221') && cleaned.length === 12) return '+' + cleaned;
        if (cleaned.length === 9) return '+221' + cleaned;
        return cleaned; // Retourne tel quel si format inconnu, le backend validera
    };


    /* SAUVEGARDE */
    const handleSave = async () => {
        if (!user) return;
        setLoading(true);
        try {
            const payload = {
                templateId: data.templateId || 1,
                titreProfil: data.titreProfil || `CV de ${data.prenom} ${data.nom}`,
                nom: data.nom,
                prenom: data.prenom,
                email: data.email,
                telephone: formatPhone(data.telephone),
                adresse: data.adresse,
                resumeProfil: data.resumeProfil,
                formations: data.formations.filter(f => f.diplome).map(f => ({
                    diplome: f.diplome,
                    etablissement: f.etablissement,
                    ville: f.ville,
                    anneeDebut: f.anneeDebut,
                    anneeFin: f.anneeFin
                })),
                experiences: data.experiences.filter(e => e.poste).map(e => ({
                    poste: e.poste,
                    entreprise: e.entreprise,
                    ville: e.ville,
                    dateDebut: e.dateDebut,
                    dateFin: e.dateFin,
                    description: e.description
                })),
                competences: data.competences.filter(c => c.nom).map(c => ({
                    nom: c.nom,
                    niveau: c.niveau
                })),
                langues: data.langues.filter(l => l.nom).map(l => ({
                    nom: l.nom,
                    niveau: l.niveau
                })),
                interets: data.interets.filter(i => i.libelle).map(i => ({
                    libelle: i.libelle
                }))
            };

            if (cvId) {
                await cvService.updateCv(cvId, payload);
            } else {
                const newCv = await cvService.createCv(payload);
                setCvId(newCv.id);
            }

            toast.success("CV sauvegardé avec succès !");
            loadCv(); // Recharger pour avoir les nouveaux IDs/Données propres
 
        } catch (error) {
            console.error("Erreur sauvegarde CV:", error);

            // Gestion différenciée selon le type d'erreur
            let msg = "Erreur lors de la sauvegarde.";

            if (error.response) {
                // Le serveur a répondu avec un code d'erreur (4xx, 5xx)
                msg = error.response.data?.message || `Erreur serveur (${error.response.status})`;
            } else if (error.request) {
                // La requête a été envoyée mais pas de réponse reçue
                msg = "Impossible de contacter le serveur. Vérifiez que le backend est démarré.";
            } else {
                // Erreur lors de la configuration de la requête
                msg = error.message || "Erreur inconnue";
            }

            toast.error(msg);
        } finally {
            setLoading(false);
        }
    };

    const componentRef = useRef(null);

    // CORRECTION ICI : Utiliser content au lieu de contentRef
    const reactToPrintFn = useReactToPrint({
        contentRef: componentRef,  // ← contentRef pour v3
        documentTitle: `CV_${data.nom}_${data.prenom}`,
        onAfterPrint: () => toast.success("Le document a été généré."),
    });

    const handlePrint = () => {
        reactToPrintFn();
    };

    const updateSimple = (field, value) => {
        setData({ ...data, [field]: value });
    };

    const updateArrayField = (section, index, field, value) => {
        const copy = [...data[section]];
        copy[index][field] = value;
        setData({ ...data, [section]: copy });
    };

    const addItem = (section) => {
        const templates = {
            formations: { diplome: '', etablissement: '', ville: '', anneeDebut: '', anneeFin: '' },
            competences: { nom: '', niveau: 'INTERMEDIAIRE' },
            experiences: { poste: '', entreprise: '', ville: '', dateDebut: '', dateFin: '', description: '' },
            interets: { libelle: '' },
            langues: { nom: '', niveau: 'DEBUTANT' }
        };
        setData({ ...data, [section]: [...data[section], templates[section]] });
    };

    const removeItem = (section, index) => {
        if (data[section].length <= 1) return;
        setData({
            ...data,
            [section]: data[section].filter((_, i) => i !== index),
        });
    };

    return (
        <div className="py-12 px-4 max-w-7xl mx-auto">
            <div className="text-center mb-12">
                <h1 className="text-4xl font-black bg-gradient-to-r from-blue-600 to-indigo-600 bg-clip-text text-transparent">
                    Générateur de CV UASZ
                </h1>
                <p className="text-lg mt-3 text-gray-600">
                    Saisis tes informations à gauche, ton CV se met à jour à droite.
                </p>
                <button
                    onClick={() => {
                        if (!componentRef.current) {
                            toast.error("L'aperçu du CV n'est pas encore prêt.");
                            return;
                        }
                        toast.info("Génération du document en cours...");
                        setTimeout(() => {
                            handlePrint();
                        }, 500);
                    }}
                    className="mt-4 inline-flex items-center px-6 py-2 rounded-full bg-green-600 text-white font-semibold hover:bg-green-700"
                >
                    <Download className="w-4 h-4 mr-2" />
                    Télécharger en PDF
                </button>
                <button
                    onClick={handleSave}
                    disabled={loading}
                    className="mt-4 ml-4 inline-flex items-center px-6 py-2 rounded-full bg-blue-600 text-white font-semibold hover:bg-blue-700 disabled:opacity-50"
                >
                    <Save className="w-4 h-4 mr-2" />
                    {loading ? 'Sauvegarde...' : 'Sauvegarder'}
                </button>
            </div>

            <div className="grid lg:grid-cols-2 gap-10 items-start">
                {/* FORMULAIRE */}
                <div className="space-y-8 max-h-[80vh] overflow-y-auto pr-2">
                    {/* Infos personnelles */}
                    <section className="bg-white p-6 rounded-2xl shadow">
                        <h2 className="text-xl font-bold mb-4 flex items-center">
                            <User className="w-5 h-5 mr-2 text-blue-600" />
                            Informations personnelles & Profil
                        </h2>
                        <div className="grid md:grid-cols-2 gap-3">
                            <input
                                className="p-3 border rounded-lg md:col-span-2"
                                placeholder="Titre du Profil (ex: Développeur Fullstack React/Spring)"
                                value={data.titreProfil}
                                onChange={(e) => updateSimple('titreProfil', e.target.value)}
                            />
                            <input
                                className="p-3 border rounded-lg"
                                placeholder="Nom"
                                value={data.nom}
                                onChange={(e) => updateSimple('nom', e.target.value)}
                            />
                            <input
                                className="p-3 border rounded-lg"
                                placeholder="Prénom"
                                value={data.prenom}
                                onChange={(e) => updateSimple('prenom', e.target.value)}
                            />
                            <input
                                className="p-3 border rounded-lg md:col-span-2"
                                placeholder="Email"
                                type="email"
                                value={data.email}
                                onChange={(e) => updateSimple('email', e.target.value)}
                            />
                            <input
                                className="p-3 border rounded-lg md:col-span-2"
                                placeholder="Téléphone"
                                value={data.telephone}
                                onChange={(e) => updateSimple('telephone', e.target.value)}
                            />
                            <input
                                className="p-3 border rounded-lg md:col-span-2"
                                placeholder="Lien LinkedIn (https://www.linkedin.com/in/...)"
                                value={data.linkedin}
                                onChange={(e) => updateSimple('linkedin', e.target.value)}
                            />
                            <input
                                className="p-3 border rounded-lg md:col-span-2"
                                placeholder="Lien GitHub (https://github.com/...)"
                                value={data.github}
                                onChange={(e) => updateSimple('github', e.target.value)}
                            />
                            <input
                                className="p-3 border rounded-lg md:col-span-2"
                                placeholder="Lien Portfolio"
                                value={data.portfolio}
                                onChange={(e) => updateSimple('portfolio', e.target.value)}
                            />
                            <input
                                className="p-3 border rounded-lg md:col-span-2"
                                placeholder="Adresse physique"
                                value={data.adresse}
                                onChange={(e) => updateSimple('adresse', e.target.value)}
                            />
                            <input
                                className="p-3 border rounded-lg md:col-span-2"
                                placeholder="URL de votre photo (https://...)"
                                value={data.photo}
                                onChange={(e) => updateSimple('photo', e.target.value)}
                            />
                            <textarea
                                className="p-3 border rounded-lg md:col-span-2"
                                rows="4"
                                placeholder="Résumé du profil / Accroche"
                                value={data.resumeProfil}
                                onChange={(e) => updateSimple('resumeProfil', e.target.value)}
                            />
                        </div>
                    </section>

                    {/* Formations */}
                    <section className="bg-white p-6 rounded-2xl shadow">
                        <h2 className="text-xl font-bold mb-4 flex items-center">
                            <GraduationCap className="w-5 h-5 mr-2 text-green-600" />
                            Formations
                        </h2>
                        {data.formations.map((f, i) => (
                            <div key={i} className="border rounded-xl p-4 mb-3">
                                <div className="flex justify-between items-center mb-2">
                                    <span className="font-semibold">Formation {i + 1}</span>
                                    {data.formations.length > 1 && (
                                        <button
                                            type="button"
                                            onClick={() => removeItem('formations', i)}
                                            className="text-red-500 hover:text-red-700"
                                        >
                                            <Trash2 className="w-4 h-4" />
                                        </button>
                                    )}
                                </div>
                                <input
                                    className="p-2 border rounded mb-2 w-full"
                                    placeholder="Diplôme (ex: Licence Informatique)"
                                    value={f.diplome}
                                    onChange={(e) =>
                                        updateArrayField('formations', i, 'diplome', e.target.value)
                                    }
                                />
                                <input
                                    className="p-2 border rounded mb-2 w-full"
                                    placeholder="Établissement (ex: Université Assane Seck)"
                                    value={f.etablissement}
                                    onChange={(e) =>
                                        updateArrayField('formations', i, 'etablissement', e.target.value)
                                    }
                                />
                                <input
                                    className="p-2 border rounded mb-2 w-full"
                                    placeholder="Ville"
                                    value={f.ville}
                                    onChange={(e) =>
                                        updateArrayField('formations', i, 'ville', e.target.value)
                                    }
                                />
                                <div className="grid grid-cols-2 gap-2">
                                    <input
                                        className="p-2 border rounded w-full"
                                        placeholder="Année début (ex: 2022)"
                                        value={f.anneeDebut}
                                        onChange={(e) =>
                                            updateArrayField('formations', i, 'anneeDebut', e.target.value)
                                        }
                                    />
                                    <input
                                        className="p-2 border rounded w-full"
                                        placeholder="Année fin (ou Présent)"
                                        value={f.anneeFin}
                                        onChange={(e) =>
                                            updateArrayField('formations', i, 'anneeFin', e.target.value)
                                        }
                                    />
                                </div>
                            </div>
                        ))}
                        <button
                            type="button"
                            onClick={() => addItem('formations')}
                            className="mt-2 inline-flex items-center text-sm text-blue-600"
                        >
                            <Plus className="w-4 h-4 mr-1" /> Ajouter une formation
                        </button>
                    </section>

                    {/* Compétences */}
                    <section className="bg-white p-6 rounded-2xl shadow">
                        <h2 className="text-xl font-bold mb-4 flex items-center">
                            <Code2 className="w-5 h-5 mr-2 text-purple-600" />
                            Compétences
                        </h2>
                        {data.competences.map((c, i) => (
                            <div key={i} className="flex flex-col mb-4 border-b pb-4 last:border-0 hover:bg-gray-50 transition-colors p-2 rounded">
                                <div className="flex items-center mb-2">
                                    <input
                                        className="p-2 border rounded w-full"
                                        placeholder="Compétence (ex: React, Spring Boot...)"
                                        value={c.nom}
                                        onChange={(e) => updateArrayField('competences', i, 'nom', e.target.value)}
                                    />
                                    {data.competences.length > 1 && (
                                        <button
                                            type="button"
                                            onClick={() => removeItem('competences', i)}
                                            className="ml-2 text-red-500 hover:text-red-700"
                                        >
                                            <Trash2 className="w-4 h-4" />
                                        </button>
                                    )}
                                </div>
                                <select
                                    className="p-2 border rounded text-sm bg-white"
                                    value={c.niveau}
                                    onChange={(e) => updateArrayField('competences', i, 'niveau', e.target.value)}
                                >
                                    <option value="DEBUTANT">Débutant</option>
                                    <option value="INTERMEDIAIRE">Intermédiaire</option>
                                    <option value="AVANCE">Avancé</option>
                                    <option value="EXPERT">Expert</option>
                                </select>
                            </div>
                        ))}
                        <button
                            type="button"
                            onClick={() => addItem('competences')}
                            className="mt-2 inline-flex items-center text-sm text-blue-600"
                        >
                            <Plus className="w-4 h-4 mr-1" /> Ajouter une compétence
                        </button>
                    </section>

                    {/* Expériences */}
                    <section className="bg-white p-6 rounded-2xl shadow">
                        <h2 className="text-xl font-bold mb-4 flex items-center">
                            <Briefcase className="w-5 h-5 mr-2 text-orange-500" />
                            Expériences
                        </h2>
                        {data.experiences.map((e, i) => (
                            <div key={i} className="border rounded-xl p-4 mb-3">
                                <div className="flex justify-between items-center mb-2">
                                    <span className="font-semibold">Expérience {i + 1}</span>
                                    {data.experiences.length > 1 && (
                                        <button
                                            type="button"
                                            onClick={() => removeItem('experiences', i)}
                                            className="text-red-500 hover:text-red-700"
                                        >
                                            <Trash2 className="w-4 h-4" />
                                        </button>
                                    )}
                                </div>
                                <input
                                    className="p-2 border rounded mb-2 w-full"
                                    placeholder="Poste (ex: Développeur stagiaire)"
                                    value={e.poste}
                                    onChange={(ev) =>
                                        updateArrayField('experiences', i, 'poste', ev.target.value)
                                    }
                                />
                                <input
                                    className="p-2 border rounded mb-2 w-full"
                                    placeholder="Entreprise / Organisation"
                                    value={e.entreprise}
                                    onChange={(ev) =>
                                        updateArrayField('experiences', i, 'entreprise', ev.target.value)
                                    }
                                />
                                <input
                                    className="p-2 border rounded mb-2 w-full"
                                    placeholder="Ville"
                                    value={e.ville}
                                    onChange={(ev) =>
                                        updateArrayField('experiences', i, 'ville', ev.target.value)
                                    }
                                />
                                <div className="grid grid-cols-2 gap-2 mb-2">
                                    <input
                                        className="p-2 border rounded w-full"
                                        placeholder="Date début"
                                        value={e.dateDebut}
                                        onChange={(ev) =>
                                            updateArrayField('experiences', i, 'dateDebut', ev.target.value)
                                        }
                                    />
                                    <input
                                        className="p-2 border rounded w-full"
                                        placeholder="Date fin (ou Présent)"
                                        value={e.dateFin}
                                        onChange={(ev) =>
                                            updateArrayField('experiences', i, 'dateFin', ev.target.value)
                                        }
                                    />
                                </div>
                                <textarea
                                    className="p-2 border rounded w-full text-sm"
                                    rows="3"
                                    placeholder="Description des missions et réalisations..."
                                    value={e.description}
                                    onChange={(ev) => updateArrayField('experiences', i, 'description', ev.target.value)}
                                />
                            </div>
                        ))}
                        <button
                            type="button"
                            onClick={() => addItem('experiences')}
                            className="mt-2 inline-flex items-center text-sm text-blue-600"
                        >
                            <Plus className="w-4 h-4 mr-1" /> Ajouter une expérience
                        </button>
                    </section>

                    {/* Centres d'intérêt */}
                    <section className="bg-white p-6 rounded-2xl shadow">
                        <h2 className="text-xl font-bold mb-4 flex items-center">
                            <Heart className="w-5 h-5 mr-2 text-red-500" />
                            Centres d'intérêt
                        </h2>
                        {data.interets.map((it, i) => (
                            <div key={i} className="flex items-center mb-2">
                                <input
                                    className="p-2 border rounded w-full"
                                    placeholder="Loisir, Sport, Passion..."
                                    value={it.libelle}
                                    onChange={(ev) =>
                                        updateArrayField('interets', i, 'libelle', ev.target.value)
                                    }
                                />
                                {data.interets.length > 1 && (
                                    <button
                                        type="button"
                                        onClick={() => removeItem('interets', i)}
                                        className="ml-2 text-red-500 hover:text-red-700"
                                    >
                                        <Trash2 className="w-4 h-4" />
                                    </button>
                                )}
                            </div>
                        ))}
                        <button
                            type="button"
                            onClick={() => addItem('interets')}
                            className="mt-2 inline-flex items-center text-sm text-blue-600"
                        >
                            <Plus className="w-4 h-4 mr-1" /> Ajouter un centre d'intérêt
                        </button>
                    </section>

                    {/* Langues */}
                    <section className="bg-white p-6 rounded-2xl shadow">
                        <h2 className="text-xl font-bold mb-4 flex items-center">
                            <Languages className="w-5 h-5 mr-2 text-teal-600" />
                            Langues
                        </h2>
                        {data.langues.map((l, i) => (
                            <div key={i} className="flex items-center mb-2 gap-2">
                                <select
                                    className="p-2 border rounded mb-2 w-full md:mb-0"
                                    value={l.nom}
                                    onChange={(ev) =>
                                        updateArrayField('langues', i, 'nom', ev.target.value)
                                    }
                                >
                                    <option value="FRANCAIS">Français</option>
                                    <option value="ANGLAIS">Anglais</option>
                                    <option value="ESPAGNOL">Espagnol</option>
                                    <option value="ALLEMAND">Allemand</option>
                                    <option value="ITALIEN">Italien</option>
                                    <option value="PORTUGAIS">Portugais</option>
                                    <option value="ARABE">Arabe</option>
                                    <option value="CHINOIS">Chinois</option>
                                    <option value="AUTRE">Autre</option>
                                </select>
                                <select
                                    className="p-2 border rounded w-1/2"
                                    value={l.niveau}
                                    onChange={(ev) =>
                                        updateArrayField('langues', i, 'niveau', ev.target.value)
                                    }
                                >
                                    <option value="DEBUTANT">Débutant</option>
                                    <option value="INTERMEDIAIRE">Intermédiaire</option>
                                    <option value="AVANCE">Avancé</option>
                                    <option value="COURANT">Courant</option>
                                    <option value="NATIF">Natif</option>
                                </select>
                                {data.langues.length > 1 && (
                                    <button
                                        type="button"
                                        onClick={() => removeItem('langues', i)}
                                        className="text-red-500 hover:text-red-700"
                                    >
                                        <Trash2 className="w-4 h-4" />
                                    </button>
                                )}
                            </div>
                        ))}
                        <button
                            type="button"
                            onClick={() => addItem('langues')}
                            className="mt-2 inline-flex items-center text-sm text-blue-600"
                        >
                            <Plus className="w-4 h-4 mr-1" /> Ajouter une langue
                        </button>
                    </section>
                </div>

                {/* PREVIEW CV */}
                <div ref={componentRef} className="bg-gray-100 p-4 rounded-2xl shadow-inner">
                    <CvTemplate data={data} />
                </div>
            </div>
        </div>
    );
};