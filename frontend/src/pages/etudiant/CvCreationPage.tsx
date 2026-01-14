// pages/CvCreationPage.tsx
import { useEffect, useState } from "react";
import { useLocation, useNavigate, useParams } from "react-router-dom";
import {
  Loader2,
  Eye,
  Save,
  Download,
  ChevronLeft,
  Edit2,
  User,
  Briefcase,
  GraduationCap,
  Code,
  Globe,
  Heart,
  Phone,
  Mail,
  MapPin,
  RefreshCw,
} from "lucide-react";
import { toast } from "react-hot-toast";
import templateService from "../../services/ms_cv_v2/template.service";
import cvService from "../../services/ms_cv_v2/cv.service";
import { TemplateResponseDTO, CvRequestDTO } from "../../api-ms-cv-v2/js-client";

const CvCreationPage = () => {
  const { templateId } = useParams();
  const location = useLocation();
  const navigate = useNavigate();
  const queryParams = new URLSearchParams(location.search);
  const initialTemplateId = queryParams.get('templateId');

  const [template, setTemplate] = useState<TemplateResponseDTO | null>(null);
  const [loading, setLoading] = useState(true);
  const [saving, setSaving] = useState(false);
  const [previewHtml, setPreviewHtml] = useState("");
  const [activeTab, setActiveTab] = useState<"form" | "preview">("form");

  // État du formulaire CV
  const [cvData, setCvData] = useState<CvRequestDTO>({
    templateId: parseInt(templateId || initialTemplateId || "0"),
    titreProfil: "",
    telephone: "",
    email: "",
    prenom: "",
    nom: "",
    adresse: "",
    resumeProfil: "",
    formations: [],
    experiences: [],
    competences: [],
    langues: [],
    interets: []
  });

  // ================= FETCH TEMPLATE =================
  useEffect(() => {
    const loadTemplate = async () => {
      try {
        setLoading(true);
        const id = templateId || initialTemplateId;
        if (id) {
          const templateData = await templateService.getTemplateById(parseInt(id));
          setTemplate(templateData);
          setCvData(prev => ({
            ...prev,
            templateId: parseInt(id)
          }));
        }
      } catch (err) {
        console.error(err);
        toast.error("Impossible de charger le template");
        navigate("/templates");
      } finally {
        setLoading(false);
      }
    };

    loadTemplate();
  }, [templateId, initialTemplateId, navigate]);

  // ================= UPDATE PREVIEW =================
  const updatePreview = async () => {
    try {  
      // Option 2: Génération simple côté client (exemple basique)
      generateClientPreview();
      
    } catch (err) {
      console.error("Preview update error:", err);
      // Fallback vers une prévisualisation simple
      generateClientPreview();
    }
  };

  const generateClientPreview = () => {
    const sections = template?.sections || [];
    const preview = `
      <div class="cv-preview">
        <h1>${cvData.prenom} ${cvData.nom}</h1>
        <p>${cvData.titreProfil}</p>
        <div class="contact-info">
          <p>📞 ${cvData.telephone}</p>
          <p>✉️ ${cvData.email}</p>
          <p>📍 ${cvData.adresse}</p>
        </div>
        <div class="sections">
          ${sections.map(section => `
            <div class="section">
              <h2>${section.type}</h2>
              <!-- Contenu dynamique selon le type de section -->
            </div>
          `).join('')}
        </div>
      </div>
    `;
    setPreviewHtml(preview);
  };

  // ================= HANDLERS =================
  const handleInputChange = (field: keyof CvRequestDTO, value: any) => {
    setCvData(prev => ({
      ...prev,
      [field]: value
    }));
  };

  const handleArrayChange = (
    field: 'formations' | 'experiences' | 'competences' | 'langues' | 'interets',
    index: number,
    subField: string,
    value: any
  ) => {
    setCvData(prev => ({
      ...prev,
      [field]: prev[field]?.map((item, i) => 
        i === index ? { ...item, [subField]: value } : item
      )
    }));
  };

  const addArrayItem = (field: 'formations' | 'experiences' | 'competences' | 'langues' | 'interets', defaultValue: any) => {
    setCvData(prev => ({
      ...prev,
      [field]: [...prev[field]!, defaultValue]
    }));
  };

  const removeArrayItem = (field: 'formations' | 'experiences' | 'competences' | 'langues' | 'interets', index: number) => {
    setCvData(prev => ({
      ...prev,
      [field]: prev[field]?.filter((_, i) => i !== index)
    }));
  };

  const handleSaveCv = async (isDraft = false) => {
    try {
      setSaving(true);
      await cvService.createCv({
        ...cvData
      });
      toast.success(isDraft ? "CV sauvegardé en brouillon" : "CV finalisé avec succès");
      navigate("/mes-cvs");
    } catch (err: any) {
      console.error("Save CV error:", err);
      toast.error(err?.response?.data?.message || "Erreur lors de la sauvegarde");
    } finally {
      setSaving(false);
    }
  };

  // ================= UI =================
  if (loading) {
    return (
      <div className="min-h-screen flex items-center justify-center">
        <Loader2 className="animate-spin text-blue-600" size={48} />
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-gray-50">
      {/* HEADER */}
      <header className="bg-white border-b shadow-sm sticky top-0 z-50">
        <div className="max-w-7xl mx-auto px-4 py-4 flex justify-between items-center">
          <div className="flex items-center gap-4">
            <button
              onClick={() => navigate("/templates")}
              className="p-2 hover:bg-gray-100 rounded"
            >
              <ChevronLeft size={20} />
            </button>
            <div>
              <h1 className="text-xl font-bold">Création de CV</h1>
              <p className="text-sm text-gray-600">
                Template: {template?.nom}
              </p>
            </div>
          </div>

          <div className="flex gap-3">
            <button
              onClick={() => setActiveTab(activeTab === "form" ? "preview" : "form")}
              className="flex items-center gap-2 px-4 py-2 bg-gray-100 hover:bg-gray-200 rounded-lg"
            >
              <Eye size={18} />
              {activeTab === "form" ? "Prévisualiser" : "Éditer"}
            </button>
            
            <button
              onClick={() => handleSaveCv(true)}
              disabled={saving}
              className="flex items-center gap-2 px-4 py-2 bg-blue-100 text-blue-700 hover:bg-blue-200 rounded-lg disabled:opacity-50"
            >
              {saving ? <Loader2 size={18} className="animate-spin" /> : <Save size={18} />}
              Sauvegarder
            </button>
            
            <button
              onClick={() => handleSaveCv(false)}
              disabled={saving}
              className="flex items-center gap-2 px-4 py-2 bg-blue-600 text-white hover:bg-blue-700 rounded-lg disabled:opacity-50"
            >
              {saving ? <Loader2 size={18} className="animate-spin" /> : <Download size={18} />}
              Finaliser le CV
            </button>
          </div>
        </div>
      </header>

      {/* MAIN CONTENT */}
      <div className="max-w-7xl mx-auto p-4">
        {activeTab === "form" ? (
          <div className="grid md:grid-cols-2 gap-6">
            {/* FORMULAIRE */}
            <div className="space-y-6">
              {/* INFORMATIONS PERSONNELLES */}
              <div className="bg-white rounded-xl shadow p-6">
                <div className="flex items-center gap-3 mb-4">
                  <div className="p-2 bg-blue-100 rounded-lg">
                    <User className="text-blue-600" size={20} />
                  </div>
                  <h2 className="text-lg font-bold">Informations Personnelles</h2>
                </div>
                
                <div className="grid md:grid-cols-2 gap-4">
                  <div>
                    <label className="block text-sm font-medium text-gray-700 mb-1">
                      Prénom *
                    </label>
                    <input
                      type="text"
                      value={cvData.prenom}
                      onChange={(e) => handleInputChange('prenom', e.target.value)}
                      className="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
                      placeholder="Votre prénom"
                    />
                  </div>
                  
                  <div>
                    <label className="block text-sm font-medium text-gray-700 mb-1">
                      Nom *
                    </label>
                    <input
                      type="text"
                      value={cvData.nom}
                      onChange={(e) => handleInputChange('nom', e.target.value)}
                      className="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
                      placeholder="Votre nom"
                    />
                  </div>
                  
                  <div>
                    <label className="block text-sm font-medium text-gray-700 mb-1">
                      Téléphone
                    </label>
                    <input
                      type="tel"
                      value={cvData.telephone}
                      onChange={(e) => handleInputChange('telephone', e.target.value)}
                      className="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
                      placeholder="+212 6 XX XX XX XX"
                    />
                  </div>
                  
                  <div>
                    <label className="block text-sm font-medium text-gray-700 mb-1">
                      Email *
                    </label>
                    <input
                      type="email"
                      value={cvData.email}
                      onChange={(e) => handleInputChange('email', e.target.value)}
                      className="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
                      placeholder="email@example.com"
                    />
                  </div>
                  
                  <div className="md:col-span-2">
                    <label className="block text-sm font-medium text-gray-700 mb-1">
                      Adresse
                    </label>
                    <input
                      type="text"
                      value={cvData.adresse}
                      onChange={(e) => handleInputChange('adresse', e.target.value)}
                      className="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
                      placeholder="Votre adresse complète"
                    />
                  </div>
                  
                  <div className="md:col-span-2">
                    <label className="block text-sm font-medium text-gray-700 mb-1">
                      Titre du profil
                    </label>
                    <input
                      type="text"
                      value={cvData.titreProfil}
                      onChange={(e) => handleInputChange('titreProfil', e.target.value)}
                      className="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
                      placeholder="Ex: Développeur Full Stack"
                    />
                  </div>
                  
                  <div className="md:col-span-2">
                    <label className="block text-sm font-medium text-gray-700 mb-1">
                      Résumé du profil
                    </label>
                    <textarea
                      value={cvData.resumeProfil}
                      onChange={(e) => handleInputChange('resumeProfil', e.target.value)}
                      className="w-full px-4 py-2 border rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-blue-500"
                      rows={4}
                      placeholder="Décrivez votre profil professionnel..."
                    />
                  </div>
                </div>
              </div>

              {/* FORMATIONS */}
              <div className="bg-white rounded-xl shadow p-6">
                <div className="flex justify-between items-center mb-4">
                  <div className="flex items-center gap-3">
                    <div className="p-2 bg-green-100 rounded-lg">
                      <GraduationCap className="text-green-600" size={20} />
                    </div>
                    <h2 className="text-lg font-bold">Formations</h2>
                  </div>
                  <button
                    onClick={() => addArrayItem('formations', {
                      diplome: '',
                      etablissement: '',
                      ville: '',
                      anneeDebut: new Date().getFullYear(),
                      anneeFin: new Date().getFullYear()
                    })}
                    className="px-3 py-1 bg-green-100 text-green-700 hover:bg-green-200 rounded-lg text-sm"
                  >
                    + Ajouter
                  </button>
                </div>
                
                {cvData?.formations?.map((formation, index) => (
                  <div key={index} className="mb-4 p-4 border rounded-lg">
                    <div className="flex justify-between mb-2">
                      <h3 className="font-medium">Formation #{index + 1}</h3>
                      <button
                        onClick={() => removeArrayItem('formations', index)}
                        className="text-red-600 hover:text-red-800 text-sm"
                      >
                        Supprimer
                      </button>
                    </div>
                    
                    <div className="grid md:grid-cols-2 gap-3">
                      <div>
                        <label className="block text-sm text-gray-600 mb-1">Diplôme</label>
                        <input
                          type="text"
                          value={formation.diplome}
                          onChange={(e) => handleArrayChange('formations', index, 'diplome', e.target.value)}
                          className="w-full px-3 py-1 border rounded"
                          placeholder="Master en Informatique"
                        />
                      </div>
                      
                      <div>
                        <label className="block text-sm text-gray-600 mb-1">Établissement</label>
                        <input
                          type="text"
                          value={formation.etablissement}
                          onChange={(e) => handleArrayChange('formations', index, 'etablissement', e.target.value)}
                          className="w-full px-3 py-1 border rounded"
                          placeholder="Université ..."
                        />
                      </div>
                      
                      <div>
                        <label className="block text-sm text-gray-600 mb-1">Ville</label>
                        <input
                          type="text"
                          value={formation.ville}
                          onChange={(e) => handleArrayChange('formations', index, 'ville', e.target.value)}
                          className="w-full px-3 py-1 border rounded"
                          placeholder="Ville"
                        />
                      </div>
                      
                      <div className="grid grid-cols-2 gap-2">
                        <div>
                          <label className="block text-sm text-gray-600 mb-1">Début</label>
                          <input
                            type="number"
                            value={formation.anneeDebut}
                            onChange={(e) => handleArrayChange('formations', index, 'anneeDebut', parseInt(e.target.value))}
                            className="w-full px-3 py-1 border rounded"
                            placeholder="2018"
                          />
                        </div>
                        
                        <div>
                          <label className="block text-sm text-gray-600 mb-1">Fin</label>
                          <input
                            type="number"
                            value={formation.anneeFin}
                            onChange={(e) => handleArrayChange('formations', index, 'anneeFin', parseInt(e.target.value))}
                            className="w-full px-3 py-1 border rounded"
                            placeholder="2022"
                          />
                        </div>
                      </div>
                    </div>
                  </div>
                ))}
              </div>

              {/* EXPÉRIENCES */}
              <div className="bg-white rounded-xl shadow p-6">
                <div className="flex justify-between items-center mb-4">
                  <div className="flex items-center gap-3">
                    <div className="p-2 bg-purple-100 rounded-lg">
                      <Briefcase className="text-purple-600" size={20} />
                    </div>
                    <h2 className="text-lg font-bold">Expériences Professionnelles</h2>
                  </div>
                  <button
                    onClick={() => addArrayItem('experiences', {
                      poste: '',
                      entreprise: '',
                      ville: '',
                      dateDebut: new Date().toISOString().split('T')[0],
                      dateFin: new Date().toISOString().split('T')[0],
                      description: ''
                    })}
                    className="px-3 py-1 bg-purple-100 text-purple-700 hover:bg-purple-200 rounded-lg text-sm"
                  >
                    + Ajouter
                  </button>
                </div>
                
                {cvData?.experiences?.map((experience, index) => (
                  <div key={index} className="mb-4 p-4 border rounded-lg">
                    <div className="flex justify-between mb-2">
                      <h3 className="font-medium">Expérience #{index + 1}</h3>
                      <button
                        onClick={() => removeArrayItem('experiences', index)}
                        className="text-red-600 hover:text-red-800 text-sm"
                      >
                        Supprimer
                      </button>
                    </div>
                    
                    <div className="space-y-3">
                      <div className="grid md:grid-cols-2 gap-3">
                        <div>
                          <label className="block text-sm text-gray-600 mb-1">Poste</label>
                          <input
                            type="text"
                            value={experience.poste}
                            onChange={(e) => handleArrayChange('experiences', index, 'poste', e.target.value)}
                            className="w-full px-3 py-1 border rounded"
                            placeholder="Développeur Full Stack"
                          />
                        </div>
                        
                        <div>
                          <label className="block text-sm text-gray-600 mb-1">Entreprise</label>
                          <input
                            type="text"
                            value={experience.entreprise}
                            onChange={(e) => handleArrayChange('experiences', index, 'entreprise', e.target.value)}
                            className="w-full px-3 py-1 border rounded"
                            placeholder="Nom de l'entreprise"
                          />
                        </div>
                      </div>
                      
                      <div className="grid md:grid-cols-3 gap-3">
                        <div>
                          <label className="block text-sm text-gray-600 mb-1">Ville</label>
                          <input
                            type="text"
                            value={experience.ville}
                            onChange={(e) => handleArrayChange('experiences', index, 'ville', e.target.value)}
                            className="w-full px-3 py-1 border rounded"
                            placeholder="Ville"
                          />
                        </div>
                        
                        <div>
                          <label className="block text-sm text-gray-600 mb-1">Date début</label>
                          <input
                            type="date"
                            value={experience.dateDebut}
                            onChange={(e) => handleArrayChange('experiences', index, 'dateDebut', e.target.value)}
                            className="w-full px-3 py-1 border rounded"
                          />
                        </div>
                        
                        <div>
                          <label className="block text-sm text-gray-600 mb-1">Date fin</label>
                          <input
                            type="date"
                            value={experience.dateFin}
                            onChange={(e) => handleArrayChange('experiences', index, 'dateFin', e.target.value)}
                            className="w-full px-3 py-1 border rounded"
                          />
                        </div>
                      </div>
                      
                      <div>
                        <label className="block text-sm text-gray-600 mb-1">Description</label>
                        <textarea
                          value={experience.description}
                          onChange={(e) => handleArrayChange('experiences', index, 'description', e.target.value)}
                          className="w-full px-3 py-1 border rounded"
                          rows={3}
                          placeholder="Décrivez vos responsabilités et réalisations..."
                        />
                      </div>
                    </div>
                  </div>
                ))}
              </div>
            </div>

            {/* COLONNE DROITE */}
            <div className="space-y-6">
              {/* COMPÉTENCES */}
              <div className="bg-white rounded-xl shadow p-6">
                <div className="flex justify-between items-center mb-4">
                  <div className="flex items-center gap-3">
                    <div className="p-2 bg-orange-100 rounded-lg">
                      <Code className="text-orange-600" size={20} />
                    </div>
                    <h2 className="text-lg font-bold">Compétences</h2>
                  </div>
                  <button
                    onClick={() => addArrayItem('competences', {
                      nom: '',
                      niveau: 'INTERMEDIAIRE'
                    })}
                    className="px-3 py-1 bg-orange-100 text-orange-700 hover:bg-orange-200 rounded-lg text-sm"
                  >
                    + Ajouter
                  </button>
                </div>
                
                {cvData?.competences?.map((competence, index) => (
                  <div key={index} className="mb-3 p-3 border rounded-lg">
                    <div className="flex justify-between mb-2">
                      <h3 className="font-medium">Compétence #{index + 1}</h3>
                      <button
                        onClick={() => removeArrayItem('competences', index)}
                        className="text-red-600 hover:text-red-800 text-sm"
                      >
                        Supprimer
                      </button>
                    </div>
                    
                    <div className="grid md:grid-cols-2 gap-3">
                      <div>
                        <label className="block text-sm text-gray-600 mb-1">Nom</label>
                        <input
                          type="text"
                          value={competence.nom}
                          onChange={(e) => handleArrayChange('competences', index, 'nom', e.target.value)}
                          className="w-full px-3 py-1 border rounded"
                          placeholder="Java Spring Boot"
                        />
                      </div>
                      
                      <div>
                        <label className="block text-sm text-gray-600 mb-1">Niveau</label>
                        <select
                          value={competence.niveau}
                          onChange={(e) => handleArrayChange('competences', index, 'niveau', e.target.value)}
                          className="w-full px-3 py-1 border rounded"
                        >
                          <option value="DEBUTANT">Débutant</option>
                          <option value="INTERMEDIAIRE">Intermédiaire</option>
                          <option value="AVANCE">Avancé</option>
                          <option value="EXPERT">Expert</option>
                        </select>
                      </div>
                    </div>
                  </div>
                ))}
              </div>

              {/* LANGUES */}
              <div className="bg-white rounded-xl shadow p-6">
                <div className="flex justify-between items-center mb-4">
                  <div className="flex items-center gap-3">
                    <div className="p-2 bg-blue-100 rounded-lg">
                      <Globe className="text-blue-600" size={20} />
                    </div>
                    <h2 className="text-lg font-bold">Langues</h2>
                  </div>
                  <button
                    onClick={() => addArrayItem('langues', {
                      nom: '',
                      niveau: 'INTERMEDIAIRE'
                    })}
                    className="px-3 py-1 bg-blue-100 text-blue-700 hover:bg-blue-200 rounded-lg text-sm"
                  >
                    + Ajouter
                  </button>
                </div>
                
                {cvData?.langues?.map((langue, index) => (
                  <div key={index} className="mb-3 p-3 border rounded-lg">
                    <div className="flex justify-between mb-2">
                      <h3 className="font-medium">Langue #{index + 1}</h3>
                      <button
                        onClick={() => removeArrayItem('langues', index)}
                        className="text-red-600 hover:text-red-800 text-sm"
                      >
                        Supprimer
                      </button>
                    </div>
                    
                    <div className="grid md:grid-cols-2 gap-3">
                      <div>
                        <label className="block text-sm text-gray-600 mb-1">Langue</label>
                        <input
                          type="text"
                          value={langue.nom}
                          onChange={(e) => handleArrayChange('langues', index, 'nom', e.target.value)}
                          className="w-full px-3 py-1 border rounded"
                          placeholder="Français"
                        />
                      </div>
                      
                      <div>
                        <label className="block text-sm text-gray-600 mb-1">Niveau</label>
                        <select
                          value={langue.niveau}
                          onChange={(e) => handleArrayChange('langues', index, 'niveau', e.target.value)}
                          className="w-full px-3 py-1 border rounded"
                        >
                          <option value="DEBUTANT">Débutant</option>
                          <option value="INTERMEDIAIRE">Intermédiaire</option>
                          <option value="COURANT">Courant</option>
                          <option value="MATERNELLE">Maternelle</option>
                        </select>
                      </div>
                    </div>
                  </div>
                ))}
              </div>

              {/* CENTRES D'INTÉRÊT */}
              <div className="bg-white rounded-xl shadow p-6">
                <div className="flex justify-between items-center mb-4">
                  <div className="flex items-center gap-3">
                    <div className="p-2 bg-pink-100 rounded-lg">
                      <Heart className="text-pink-600" size={20} />
                    </div>
                    <h2 className="text-lg font-bold">Centres d'intérêt</h2>
                  </div>
                  <button
                    onClick={() => addArrayItem('interets', {
                      libelle: ''
                    })}
                    className="px-3 py-1 bg-pink-100 text-pink-700 hover:bg-pink-200 rounded-lg text-sm"
                  >
                    + Ajouter
                  </button>
                </div>
                
                {cvData?.interets?.map((interet, index) => (
                  <div key={index} className="mb-3 p-3 border rounded-lg">
                    <div className="flex justify-between mb-2">
                      <h3 className="font-medium">Intérêt #{index + 1}</h3>
                      <button
                        onClick={() => removeArrayItem('interets', index)}
                        className="text-red-600 hover:text-red-800 text-sm"
                      >
                        Supprimer
                      </button>
                    </div>
                    
                    <div>
                      <label className="block text-sm text-gray-600 mb-1">Intérêt</label>
                      <input
                        type="text"
                        value={interet.libelle}
                        onChange={(e) => handleArrayChange('interets', index, 'libelle', e.target.value)}
                        className="w-full px-3 py-1 border rounded"
                        placeholder="Voyages, Lecture, Sport..."
                      />
                    </div>
                  </div>
                ))}
              </div>
            </div>
          </div>
        ) : (
          /* PRÉVISUALISATION */
          <div className="bg-white rounded-xl shadow-lg p-8">
            <div className="flex justify-between items-center mb-6">
              <h2 className="text-2xl font-bold">Prévisualisation du CV</h2>
              <button
                onClick={updatePreview}
                className="px-4 py-2 bg-blue-100 text-blue-700 hover:bg-blue-200 rounded-lg flex items-center gap-2"
              >
                <RefreshCw size={18} />
                Actualiser
              </button>
            </div>
            
            <div className="border rounded-lg overflow-hidden">
              {previewHtml ? (
                <div 
                  className="cv-preview-container p-8"
                  dangerouslySetInnerHTML={{ __html: previewHtml }}
                />
              ) : (
                <div className="p-12 text-center">
                  <p className="text-gray-500 mb-4">Remplissez le formulaire pour voir la prévisualisation</p>
                  <button
                    onClick={updatePreview}
                    className="px-4 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700"
                  >
                    Générer la prévisualisation
                  </button>
                </div>
              )}
            </div>
            
            <div className="mt-6 p-4 bg-blue-50 rounded-lg">
              <h3 className="font-bold text-blue-800 mb-2">💡 Conseils</h3>
              <ul className="text-sm text-blue-700 space-y-1">
                <li>• Vérifiez l'orthographe et la grammaire</li>
                <li>• Assurez-vous que toutes les informations sont à jour</li>
                <li>• Adaptez votre CV au poste visé</li>
                <li>• Utilisez des verbes d'action pour décrire vos expériences</li>
              </ul>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default CvCreationPage;