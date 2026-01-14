import React, { useState, useEffect } from 'react';
import { Eye, Plus, Calendar, User, Briefcase, FileText, Trash2, Edit } from 'lucide-react';
import { CvResponseDTO } from '../../api-ms-cv-v2/js-client';
import cvService from '../../services/ms_cv_v2/cv.service';

const MesCvs: React.FC = () => {
  const [cvs, setCvs] = useState<CvResponseDTO[]>([]);
  const [selectedCv, setSelectedCv] = useState<CvResponseDTO | null>(null);
  const [loading, setLoading] = useState(true);
  const [showPreview, setShowPreview] = useState(false);

  useEffect(() => {
    loadCvs();
  }, []);

  const loadCvs = async () => {
    setLoading(true);
    try {
      // Remplacer par votre appel API réel
      const data = await cvService.getMyCvs();
      setTimeout(() => {
        setCvs(data);
        setLoading(false);
      }, 500);
    } catch (error) {
      console.error('Erreur lors du chargement des CVs:', error);
      setLoading(false);
    }
  };

  const formatDate = (dateString?: string) => {
    if (!dateString) return '';
    return new Date(dateString).toLocaleDateString('fr-FR', {
      day: '2-digit',
      month: 'long',
      year: 'numeric'
    });
  };

  const handlePreview = (cv: CvResponseDTO) => {
    setSelectedCv(cv);
    setShowPreview(true);
  };

  const handleClosePreview = () => {
    setShowPreview(false);
    setSelectedCv(null);
  };

  if (loading) {
    return (
      <div className="flex items-center justify-center min-h-screen bg-gray-50">
        <div className="text-center">
          <div className="w-16 h-16 border-4 border-blue-600 border-t-transparent rounded-full animate-spin mx-auto mb-4"></div>
          <p className="text-gray-600">Chargement de vos CVs...</p>
        </div>
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-gray-50 p-6">
      <div className="max-w-7xl mx-auto">
        {/* En-tête */}
        <div className="mb-8">
          <h1 className="text-3xl font-bold text-gray-900 mb-2">Mes CVs</h1>
          <p className="text-gray-600">Gérez et prévisualisez tous vos CV</p>
        </div>

        {/* Bouton Créer un nouveau CV */}
        <button className="mb-6 flex items-center gap-2 bg-blue-600 text-white px-6 py-3 rounded-lg hover:bg-blue-700 transition-colors shadow-md">
          <Plus className="w-5 h-5" />
          Créer un nouveau CV
        </button>

        {/* Liste des CVs */}
        {cvs.length === 0 ? (
          <div className="bg-white rounded-lg shadow-md p-12 text-center">
            <FileText className="w-16 h-16 text-gray-400 mx-auto mb-4" />
            <h3 className="text-xl font-semibold text-gray-900 mb-2">Aucun CV trouvé</h3>
            <p className="text-gray-600 mb-6">Commencez par créer votre premier CV</p>
            <button className="bg-blue-600 text-white px-6 py-2 rounded-lg hover:bg-blue-700 transition-colors">
              Créer mon CV
            </button>
          </div>
        ) : (
          <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
            {cvs.map((cv) => (
              <div
                key={cv.id}
                className="bg-white rounded-lg shadow-md hover:shadow-xl transition-all duration-300 overflow-hidden border border-gray-200"
              >
                {/* En-tête de la carte */}
                <div className="bg-gradient-to-r from-blue-600 to-blue-700 text-white p-4">
                  <div className="flex items-start justify-between mb-2">
                    <div className="flex-1">
                      <h3 className="font-bold text-lg truncate">
                        {cv.prenom} {cv.nom}
                      </h3>
                      <p className="text-blue-100 text-sm truncate">{cv.titreProfil}</p>
                    </div>
                    <span className="bg-white/20 text-xs px-2 py-1 rounded">
                      {cv.templateNom}
                    </span>
                  </div>
                </div>

                {/* Contenu de la carte */}
                <div className="p-4">
                  <div className="space-y-3 mb-4">
                    <div className="flex items-center gap-2 text-sm text-gray-600">
                      <Briefcase className="w-4 h-4 text-blue-600" />
                      <span>{cv.experiences?.length || 0} expérience(s)</span>
                    </div>
                    <div className="flex items-center gap-2 text-sm text-gray-600">
                      <User className="w-4 h-4 text-blue-600" />
                      <span>{cv.competences?.length || 0} compétence(s)</span>
                    </div>
                    <div className="flex items-center gap-2 text-sm text-gray-600">
                      <Calendar className="w-4 h-4 text-blue-600" />
                      <span>Modifié le {formatDate(cv.updatedAt)}</span>
                    </div>
                  </div>

                  {/* Résumé */}
                  {cv.resumeProfil && (
                    <p className="text-sm text-gray-600 line-clamp-2 mb-4">
                      {cv.resumeProfil}
                    </p>
                  )}

                  {/* Actions */}
                  <div className="flex gap-2 pt-4 border-t border-gray-200">
                    <button
                      onClick={() => handlePreview(cv)}
                      className="flex-1 flex items-center justify-center gap-2 bg-blue-50 text-blue-600 px-4 py-2 rounded-lg hover:bg-blue-100 transition-colors"
                    >
                      <Eye className="w-4 h-4" />
                      Prévisualiser
                    </button>
                    <button className="flex items-center justify-center gap-2 bg-gray-100 text-gray-700 px-4 py-2 rounded-lg hover:bg-gray-200 transition-colors">
                      <Edit className="w-4 h-4" />
                    </button>
                    <button className="flex items-center justify-center gap-2 bg-red-50 text-red-600 px-4 py-2 rounded-lg hover:bg-red-100 transition-colors">
                      <Trash2 className="w-4 h-4" />
                    </button>
                  </div>
                </div>
              </div>
            ))}
          </div>
        )}

        {/* Modal de prévisualisation */}
        {showPreview && selectedCv && (
          <div className="fixed inset-0 bg-black/50 flex items-center justify-center p-4 z-50">
            <div className="bg-white rounded-lg max-w-4xl w-full max-h-[90vh] overflow-y-auto">
              {/* En-tête du modal */}
              <div className="sticky top-0 bg-white border-b border-gray-200 px-6 py-4 flex items-center justify-between">
                <h2 className="text-2xl font-bold text-gray-900">Prévisualisation du CV</h2>
                <button
                  onClick={handleClosePreview}
                  className="text-gray-500 hover:text-gray-700 text-2xl font-bold"
                >
                  ×
                </button>
              </div>

              {/* Contenu du CV */}
              <div className="p-8 bg-gray-50">
                <div className="bg-white rounded-lg shadow-lg p-8">
                  {/* En-tête du CV */}
                  <div className="text-center mb-8 pb-6 border-b-2 border-blue-600">
                    <h1 className="text-4xl font-bold text-gray-900 mb-2">
                      {selectedCv.prenom} {selectedCv.nom}
                    </h1>
                    <p className="text-xl text-blue-600 mb-4">{selectedCv.titreProfil}</p>
                    <div className="flex flex-wrap justify-center gap-4 text-sm text-gray-600">
                      <span>{selectedCv.email}</span>
                      <span>•</span>
                      <span>{selectedCv.telephone}</span>
                      <span>•</span>
                      <span>{selectedCv.adresse}</span>
                    </div>
                  </div>

                  {/* Résumé profil */}
                  {selectedCv.resumeProfil && (
                    <div className="mb-6">
                      <h2 className="text-xl font-bold text-gray-900 mb-3 border-b-2 border-gray-200 pb-2">
                        Profil
                      </h2>
                      <p className="text-gray-700">{selectedCv.resumeProfil}</p>
                    </div>
                  )}

                  {/* Expériences */}
                  {selectedCv.experiences && selectedCv.experiences.length > 0 && (
                    <div className="mb-6">
                      <h2 className="text-xl font-bold text-gray-900 mb-3 border-b-2 border-gray-200 pb-2">
                        Expériences Professionnelles
                      </h2>
                      <div className="space-y-4">
                        {selectedCv.experiences.map((exp, index) => (
                          <div key={index} className="pl-4 border-l-2 border-blue-600">
                            <h3 className="font-bold text-gray-900">{exp.poste}</h3>
                            <p className="text-blue-600">{exp.entreprise}</p>
                            <p className="text-sm text-gray-600">
                              {exp.dateDebut} - {exp.dateFin || 'Présent'}
                            </p>
                            {exp.description && (
                              <p className="text-gray-700 mt-2">{exp.description}</p>
                            )}
                          </div>
                        ))}
                      </div>
                    </div>
                  )}

                  {/* Formations */}
                  {selectedCv.formations && selectedCv.formations.length > 0 && (
                    <div className="mb-6">
                      <h2 className="text-xl font-bold text-gray-900 mb-3 border-b-2 border-gray-200 pb-2">
                        Formation
                      </h2>
                      <div className="space-y-4">
                        {selectedCv.formations.map((form, index) => (
                          <div key={index} className="pl-4 border-l-2 border-blue-600">
                            <h3 className="font-bold text-gray-900">{form.diplome}</h3>
                            <p className="text-blue-600">{form.etablissement}</p>
                            <p className="text-sm text-gray-600">
                              {form.anneeDebut} - {form.anneeFin}
                            </p>
                          </div>
                        ))}
                      </div>
                    </div>
                  )}

                  {/* Compétences */}
                  {selectedCv.competences && selectedCv.competences.length > 0 && (
                    <div className="mb-6">
                      <h2 className="text-xl font-bold text-gray-900 mb-3 border-b-2 border-gray-200 pb-2">
                        Compétences
                      </h2>
                      <div className="flex flex-wrap gap-2">
                        {selectedCv.competences.map((comp, index) => (
                          <span
                            key={index}
                            className="bg-blue-100 text-blue-800 px-3 py-1 rounded-full text-sm"
                          >
                            {comp.nom} {comp.niveau && `- ${comp.niveau}`}
                          </span>
                        ))}
                      </div>
                    </div>
                  )}

                  {/* Langues */}
                  {selectedCv.langues && selectedCv.langues.length > 0 && (
                    <div className="mb-6">
                      <h2 className="text-xl font-bold text-gray-900 mb-3 border-b-2 border-gray-200 pb-2">
                        Langues
                      </h2>
                      <div className="flex flex-wrap gap-4">
                        {selectedCv.langues.map((langue, index) => (
                          <span key={index} className="text-gray-700">
                            <strong>{langue.nom}:</strong> {langue.niveau}
                          </span>
                        ))}
                      </div>
                    </div>
                  )}

                  {/* Centres d'intérêt */}
                  {selectedCv.interets && selectedCv.interets.length > 0 && (
                    <div>
                      <h2 className="text-xl font-bold text-gray-900 mb-3 border-b-2 border-gray-200 pb-2">
                        Centres d'intérêt
                      </h2>
                      <div className="flex flex-wrap gap-2">
                        {selectedCv.interets.map((interet, index) => (
                          <span
                            key={index}
                            className="bg-gray-100 text-gray-800 px-3 py-1 rounded-full text-sm"
                          >
                            {interet.libelle}
                          </span>
                        ))}
                      </div>
                    </div>
                  )}
                </div>
              </div>

              {/* Pied du modal */}
              <div className="sticky bottom-0 bg-white border-t border-gray-200 px-6 py-4 flex gap-3 justify-end">
                <button
                  onClick={handleClosePreview}
                  className="px-6 py-2 border border-gray-300 rounded-lg text-gray-700 hover:bg-gray-50 transition-colors"
                >
                  Fermer
                </button>
                <button className="px-6 py-2 bg-blue-600 text-white rounded-lg hover:bg-blue-700 transition-colors">
                  Télécharger PDF
                </button>
              </div>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default MesCvs;