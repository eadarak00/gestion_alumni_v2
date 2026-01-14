import { useEffect, useState } from "react";
import { Loader2, Eye, FileText, Plus, Trash2, Edit3, Sparkles, Globe, User } from "lucide-react";
import { toast } from "react-hot-toast";
import templateService from "../../services/ms_cv_v2/template.service";
import { TemplateResponseDTO } from "../../api-ms-cv-v2/js-client";
import { useNavigate } from "react-router-dom";
import ConfirmationModal from "../../components/common/ConfirmationModal"; // À créer

const EtudiantTemplates = () => {
  const [templates, setTemplates] = useState<TemplateResponseDTO[]>([]);
  const [loading, setLoading] = useState(false);
  const [deletingId, setDeletingId] = useState<number | null>(null);
  const [showDeleteModal, setShowDeleteModal] = useState(false);
  const [selectedTemplate, setSelectedTemplate] = useState<TemplateResponseDTO | null>(null);
  const navigate = useNavigate();

  // ---------------- FETCH TEMPLATES ----------------
  const fetchTemplates = async () => {
    setLoading(true);
    try {
      const templatesList: TemplateResponseDTO[] = await templateService.getAllTemplates();
      setTemplates(templatesList);
    } catch (err) {
      console.error(err);
      toast.error("Impossible de charger les templates");
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    fetchTemplates();
  }, []);

  // ---------------- DELETE TEMPLATE ----------------
  const handleDelete = async () => {
    if (!selectedTemplate) return;

    setDeletingId(selectedTemplate.id ?? null);
    try {
      await templateService.deleteTemplate(selectedTemplate.id!);
      toast.success("Template supprimé avec succès");
      setTemplates(templates.filter(t => t.id !== selectedTemplate.id));
    } catch (err) {
      console.error(err);
      toast.error("Impossible de supprimer le template");
    } finally {
      setDeletingId(null);
      setShowDeleteModal(false);
      setSelectedTemplate(null);
    }
  };

  const openDeleteModal = (template: TemplateResponseDTO) => {
    setSelectedTemplate(template);
    setShowDeleteModal(true);
  };

  // ---------------- UI ----------------
  if (loading) {
    return (
      <div className="min-h-screen flex flex-col items-center justify-center bg-gradient-to-br from-gray-50 to-gray-100">
        <div className="text-center">
          <Loader2 className="animate-spin mx-auto text-blue-600" size={48} />
          <p className="mt-4 text-gray-600">Chargement des templates...</p>
        </div>
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-gradient-to-br from-gray-50 to-gray-100 p-4 md:p-6">
      <div className="max-w-7xl mx-auto">
        {/* Header */}
        <div className="mb-8 md:mb-12">
          <div className="flex flex-col md:flex-row md:items-center justify-between gap-4">
            <div>
              <div className="flex items-center gap-3 mb-2">
                <div className="p-2 bg-blue-100 rounded-lg">
                  <Sparkles className="text-blue-600" size={24} />
                </div>
                <h1 className="text-3xl md:text-4xl font-bold text-gray-900">
                  Templates de CV
                </h1>
              </div>
              <p className="text-gray-600">
                Choisissez un template ou créez-en un nouveau pour votre CV
              </p>
            </div>

            <button
              className="group flex items-center gap-2 bg-gradient-to-r from-blue-600 to-indigo-600 text-white px-5 py-3 rounded-xl hover:from-blue-700 hover:to-indigo-700 transition-all duration-300 shadow-lg hover:shadow-xl font-medium"
              onClick={() => navigate("/templates/creation")}
            >
              <Plus size={20} className="group-hover:rotate-90 transition-transform" />
              Créer un template
            </button>
          </div>
        </div>

        {/* Templates Grid */}
        {templates.length === 0 ? (
          <div className="text-center py-16 bg-white rounded-2xl shadow-sm border border-gray-200">
            <div className="max-w-md mx-auto">
              <FileText size={64} className="mx-auto text-gray-300 mb-4" />
              <h3 className="text-xl font-semibold text-gray-700 mb-2">
                Aucun template disponible
              </h3>
              <p className="text-gray-500 mb-6">
                Créez votre premier template pour commencer
              </p>
              <button
                onClick={() => navigate("/templates/creation")}
                className="inline-flex items-center gap-2 bg-blue-600 text-white px-6 py-3 rounded-lg hover:bg-blue-700 transition-colors"
              >
                <Plus size={18} />
                Créer un template
              </button>
            </div>
          </div>
        ) : (
          <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
            {templates.map((template) => (
              <div
                key={template.id}
                className="group bg-white rounded-2xl shadow-lg hover:shadow-2xl transition-all duration-300 border border-gray-200 overflow-hidden hover:-translate-y-1"
              >
                {/* Template Header */}
                <div className="p-6">
                  <div className="flex justify-between items-start mb-4">
                    <div>
                      <div className="flex items-center gap-2 mb-2">
                        {template.isGlobal ? (
                          <span className="inline-flex items-center gap-1 px-3 py-1 bg-blue-50 text-blue-700 rounded-full text-sm">
                            <Globe size={12} />
                            Global
                          </span>
                        ) : (
                          <span className="inline-flex items-center gap-1 px-3 py-1 bg-green-50 text-green-700 rounded-full text-sm">
                            <User size={12} />
                            Personnel
                          </span>
                        )}
                      </div>
                      <h3 className="text-xl font-bold text-gray-900 group-hover:text-blue-600 transition-colors">
                        {template.nom}
                      </h3>
                    </div>

                    {/* Actions Menu */}
                    <div className="flex items-center gap-1 opacity-0 group-hover:opacity-100 transition-opacity">
                      {!template.isGlobal && (
                        <>
                          <button
                            onClick={() => openDeleteModal(template)}
                            disabled={deletingId === template.id}
                            className="p-2 text-red-600 hover:bg-red-50 rounded-lg transition-colors"
                            title="Supprimer"
                          >
                            <Trash2 size={18} />
                          </button>
                          <button
                            onClick={() => navigate(`/templates/${template.id}/edit`)}
                            className="p-2 text-gray-600 hover:bg-gray-100 rounded-lg transition-colors"
                            title="Modifier"
                          >
                            <Edit3 size={18} />
                          </button>
                        </>
                      )}
                    </div>
                  </div>

                  {/* Sections List */}
                  <div className="mb-6">
                    <p className="text-sm font-medium text-gray-700 mb-3">
                      Sections ({template?.sections?.length || 0})
                    </p>
                    <div className="space-y-2">
                      {template?.sections?.slice(0, 3).map((s, i) => (
                        <div key={i} className="flex items-center gap-2 text-sm text-gray-600">
                          <div className="w-2 h-2 bg-blue-500 rounded-full"></div>
                          <span>{s.type}</span>
                        </div>
                      ))}
                      {template?.sections && template.sections.length > 3 && (
                        <p className="text-sm text-gray-500">
                          + {template.sections.length - 3} autres sections
                        </p>
                      )}
                    </div>
                  </div>

                  {/* Action Buttons */}
                  <div className="flex gap-3 pt-4 border-t border-gray-100">
                    <button
                      onClick={() => navigate(`/templates/${template.id}/preview`)}
                      className="flex-1 flex items-center justify-center gap-2 px-4 py-3 bg-blue-50 text-blue-700 hover:bg-blue-100 rounded-lg transition-colors font-medium"
                    >
                      <Eye size={18} />
                      Prévisualiser
                    </button>
                    <button
                      onClick={() => navigate(`/cv/create?templateId=${template.id}`)}
                      className="flex-1 flex items-center justify-center gap-2 px-4 py-3 bg-gradient-to-r from-blue-600 to-indigo-600 text-white hover:from-blue-700 hover:to-indigo-700 rounded-lg transition-all font-medium shadow-sm"
                    >
                      <FileText size={18} />
                      Utiliser
                    </button>
                  </div>
                </div>
              </div>
            ))}
          </div>
        )}

        {/* Stats */}
        {templates.length > 0 && (
          <div className="mt-8 bg-white rounded-2xl p-6 shadow-sm border border-gray-200">
            <div className="flex flex-wrap gap-6">
              <div className="flex items-center gap-3">
                <div className="p-2 bg-blue-100 rounded-lg">
                  <Globe className="text-blue-600" size={20} />
                </div>
                <div>
                  <p className="text-sm text-gray-600">Templates globaux</p>
                  <p className="text-xl font-bold">
                    {templates.filter(t => t.isGlobal).length}
                  </p>
                </div>
              </div>
              <div className="flex items-center gap-3">
                <div className="p-2 bg-green-100 rounded-lg">
                  <User className="text-green-600" size={20} />
                </div>
                <div>
                  <p className="text-sm text-gray-600">Templates personnels</p>
                  <p className="text-xl font-bold">
                    {templates.filter(t => !t.isGlobal).length}
                  </p>
                </div>
              </div>
            </div>
          </div>
        )}
      </div>

      {/* Confirmation Modal */}
      {showDeleteModal && (
        <ConfirmationModal
          isOpen={showDeleteModal}
          onClose={() => {
            setShowDeleteModal(false);
            setSelectedTemplate(null);
          }}
          onConfirm={handleDelete}
          title="Supprimer le template"
          message={`Êtes-vous sûr de vouloir supprimer "${selectedTemplate?.nom}" ? Cette action est irréversible.`}
          confirmText="Supprimer"
          cancelText="Annuler"
          type="danger"
          isLoading={deletingId === selectedTemplate?.id}
        />
      )}
    </div>
  );
};

export default EtudiantTemplates;