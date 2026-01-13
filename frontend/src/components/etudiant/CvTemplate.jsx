// frontend/src/components/etudiant/CvTemplate.jsx
import { Download } from 'lucide-react';

const CvTemplate = ({ data, onDownload }) => {
    const handleDownload = () => {
        if (onDownload && data.id) {
            onDownload(data.id, `${data.prenom}_${data.nom}_CV`);
        }
    };

    return (
        <div className="relative max-w-4xl mx-auto px-12 py-10 bg-white font-sans text-sm shadow-lg print:px-12 print:py-10 print:shadow-none">
            {/* Bouton de téléchargement (visible uniquement en mode preview) */}
            <div className="hidden print:block">
                {/* Masqué lors de l'impression */}
            </div>

            {/* Header */}
            <div className="flex items-start mb-8 pb-8 border-b-2 border-gray-200">
                <div className="w-28 h-28 bg-gray-200 rounded-full mr-8 flex items-center justify-center text-gray-500 overflow-hidden relative">
                    {data.photo ? (
                        <img
                            src={data.photo}
                            alt="Profil"
                            className="w-full h-full object-cover"
                        />
                    ) : (
                        <div className="text-center">
                            <span className="block text-xs">Photo</span>
                            <span className="block text-xs">Profil</span>
                        </div>
                    )}
                </div>
                <div className="flex-1 min-w-0">
                    <h1 className="text-3xl font-bold text-gray-900 truncate">
                        {data.nom} {data.prenom}
                    </h1>
                    <p className="text-xl text-blue-600 mt-1">
                        {data.titreProfil || 'Alumni UASZ'}
                    </p>
                    <div className="flex flex-wrap gap-4 mt-4 text-gray-600 text-sm">
                        {data.email && (
                            <span className="flex items-center">
                                <span className="font-medium mr-1">Email:</span>
                                {data.email}
                            </span>
                        )}
                        {data.telephone && (
                            <span className="flex items-center">
                                <span className="font-medium mr-1">Tél:</span>
                                {data.telephone}
                            </span>
                        )}
                        {data.linkedin && (
                            <span className="flex items-center">
                                <span className="font-medium mr-1">LinkedIn:</span>
                                {data.linkedin.replace(/https?:\/\/(www\.)?/, '')}
                            </span>
                        )}
                        {data.github && (
                            <span className="flex items-center">
                                <span className="font-medium mr-1">GitHub:</span>
                                {data.github.replace(/https?:\/\/(www\.)?/, '')}
                            </span>
                        )}
                        {data.portfolio && (
                            <span className="flex items-center">
                                <span className="font-medium mr-1">Portfolio:</span>
                                {data.portfolio}
                            </span>
                        )}
                    </div>
                    {data.adresse && (
                        <p className="mt-2 text-gray-500 italic">{data.adresse}</p>
                    )}
                </div>
            </div>

            {/* Profil Section */}
            {data.resumeProfil && (
                <section className="mb-10">
                    <h2 className="text-xl font-bold mb-3 text-gray-800 border-b border-gray-300 pb-2 uppercase tracking-wider">
                        Profil
                    </h2>
                    <p className="text-gray-700 leading-relaxed italic">
                        {data.resumeProfil}
                    </p>
                </section>
            )}

            <div className="grid lg:grid-cols-2 gap-12">
                {/* Colonne gauche */}
                <div>
                    {/* Formations */}
                    {data.formations?.length > 0 && (
                        <section className="mb-12">
                            <h2 className="text-xl font-bold mb-6 text-gray-800 border-b border-gray-300 pb-3 uppercase tracking-wider">
                                Formation
                            </h2>
                            {data.formations.map((f, i) => (
                                <div
                                    key={i}
                                    className="mb-6 pb-4 border-b border-gray-100 last:border-b-0"
                                >
                                    <h3 className="font-bold text-base mb-1">{f.diplome}</h3>
                                    <p className="text-gray-600 mb-1">
                                        {f.etablissement} {f.ville && `• ${f.ville}`}
                                    </p>
                                    <p className="text-sm text-gray-500">
                                        {f.anneeDebut} - {f.anneeFin || 'Présent'}
                                    </p>
                                </div>
                            ))}
                        </section>
                    )}

                    {/* Compétences */}
                    {data.competences?.length > 0 && (
                        <section className="mb-12">
                            <h2 className="text-xl font-bold mb-6 text-gray-800 border-b border-gray-300 pb-3 uppercase tracking-wider">
                                Compétences
                            </h2>
                            <div className="flex flex-wrap gap-2">
                                {data.competences.map((c, i) => (
                                    <div
                                        key={i}
                                        className="bg-blue-50 text-blue-800 px-3 py-1 rounded-md text-xs font-semibold border border-blue-200 uppercase flex items-center"
                                    >
                                        {c.nom}
                                        {c.niveau && (
                                            <span className="ml-2 text-xs text-blue-600 font-normal">
                                                ({c.niveau})
                                            </span>
                                        )}
                                    </div>
                                ))}
                            </div>
                        </section>
                    )}

                    {/* Langues */}
                    {data.langues?.length > 0 && (
                        <section>
                            <h2 className="text-xl font-bold mb-6 text-gray-800 border-b border-gray-300 pb-3 uppercase tracking-wider">
                                Langues
                            </h2>
                            {data.langues.map((l, i) => (
                                <div key={i} className="mb-4">
                                    <div className="flex justify-between items-center mb-1">
                                        <span className="font-semibold text-gray-700">
                                            {l.nom}
                                        </span>
                                        <span className="text-xs text-gray-500 uppercase">
                                            {l.niveau}
                                        </span>
                                    </div>
                                    <div className="w-full bg-gray-100 rounded-full h-1.5">
                                        <div
                                            className="bg-blue-500 h-1.5 rounded-full"
                                            style={{
                                                width:
                                                    l.niveau === 'NATIF' || l.niveau === 'COURANT'
                                                        ? '100%'
                                                        : l.niveau === 'AVANCE'
                                                            ? '80%'
                                                            : l.niveau === 'INTERMEDIAIRE'
                                                                ? '60%'
                                                                : '30%',
                                            }}
                                        ></div>
                                    </div>
                                </div>
                            ))}
                        </section>
                    )}
                </div>

                {/* Colonne droite */}
                <div>
                    {/* Expériences */}
                    {data.experiences?.length > 0 && (
                        <section className="mb-12">
                            <h2 className="text-xl font-bold mb-6 text-gray-800 border-b border-gray-300 pb-3 uppercase tracking-wider">
                                Expériences
                            </h2>
                            {data.experiences.map((e, i) => (
                                <div key={i} className="mb-8">
                                    <h3 className="font-bold text-base mb-1">{e.poste}</h3>
                                    <p className="text-blue-600 font-semibold mb-1 text-sm">
                                        {e.entreprise} {e.ville && `• ${e.ville}`}
                                    </p>
                                    <p className="text-xs text-gray-500 mb-3">
                                        {e.dateDebut} - {e.dateFin || 'Présent'}
                                    </p>
                                    <p className="text-sm text-gray-700 whitespace-pre-wrap">
                                        {e.description}
                                    </p>
                                </div>
                            ))}
                        </section>
                    )}

                    {/* Centres d'intérêt */}
                    {data.interets?.length > 0 && (
                        <section>
                            <h2 className="text-xl font-bold mb-6 text-gray-800 border-b border-gray-300 pb-3 uppercase tracking-wider">
                                Centres d'intérêt
                            </h2>
                            <div className="flex flex-wrap gap-2">
                                {data.interets.map((it, i) => (
                                    <span
                                        key={i}
                                        className="bg-gray-50 text-gray-700 px-3 py-1 rounded-md text-xs font-medium border border-gray-200 underline decoration-blue-200 decoration-2 underline-offset-4"
                                    >
                                        {it.libelle}
                                    </span>
                                ))}
                            </div>
                        </section>
                    )}
                </div>
            </div>

            <footer className="mt-16 pt-8 border-t border-gray-200 text-center text-[10px] text-gray-400 uppercase tracking-widest">
                CV généré via Plateforme Alumni UASZ • {new Date().getFullYear()}
            </footer>
        </div>
    );
};

export default CvTemplate;