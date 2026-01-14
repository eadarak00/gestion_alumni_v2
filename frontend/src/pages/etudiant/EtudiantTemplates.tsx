import { useEffect, useState } from "react";
import {
  Loader2,
  Eye,
  FileText,
  Plus,
  Trash2,
  Edit3,
  Sparkles,
} from "lucide-react";
import { toast } from "react-hot-toast";
import templateService from "../../services/ms_cv_v2/template.service";
import { TemplateResponseDTO } from "../../api-ms-cv-v2/js-client";
import { useNavigate } from "react-router-dom";

const EtudiantTemplates = () => {
  const [templates, setTemplates] = useState<TemplateResponseDTO[]>([]);
  const [loading, setLoading] = useState(true);
  const [deletingId, setDeletingId] = useState<number | null>(null);

  const navigate = useNavigate();

  // ================= FETCH =================
  const fetchTemplates = async () => {
    try {
      setLoading(true);
      const data = await templateService.getAllTemplates();
      setTemplates(data);
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

  // ================= DELETE =================
  const handleDelete = async (id: number) => {
    const ok = window.confirm(
      "Êtes-vous sûr de vouloir supprimer ce template ? Cette action est irréversible."
    );
    if (!ok) return;

    try {
      setDeletingId(id);

      console.log("DELETE TEMPLATE ID =", id);

      await templateService.deleteTemplate(id);

      toast.success("Template supprimé avec succès");

      // refresh depuis API
      await fetchTemplates();

      // ou en local :
      // setTemplates(prev => prev.filter(t => t.id !== id));

    } catch (err: any) {
      console.error("DELETE ERROR:", err);
      toast.error(
        err?.response?.data?.message || "Erreur lors de la suppression"
      );
    } finally {
      setDeletingId(null);
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
    <div className="min-h-screen bg-gradient-to-br from-gray-50 to-gray-100 p-4 md:p-6">
      <div className="max-w-7xl mx-auto">

        {/* HEADER */}
        <div className="mb-10 flex justify-between items-center">
          <div>
            <div className="flex items-center gap-3 mb-2">
              <div className="p-2 bg-blue-100 rounded-lg">
                <Sparkles className="text-blue-600" size={24} />
              </div>
              <h1 className="text-3xl font-bold">Templates de CV</h1>
            </div>
            <p className="text-gray-600">
              Choisissez un template ou créez-en un nouveau
            </p>
          </div>

          <button
            onClick={() => navigate("/templates/creation")}
            className="flex items-center gap-2 bg-blue-600 text-white px-5 py-3 rounded-xl hover:bg-blue-700"
          >
            <Plus size={18} />
            Créer
          </button>
        </div>

        {/* LIST */}
        {templates.length === 0 ? (
          <div className="bg-white p-10 rounded-xl text-center">
            <FileText size={60} className="mx-auto text-gray-300 mb-4" />
            <p className="text-gray-500">Aucun template disponible</p>
          </div>
        ) : (
          <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-6">
            {templates.map((template) => (
              <div
                key={template.id}
                className="bg-white rounded-xl shadow hover:shadow-xl transition border"
              >
                <div className="p-6">

                  {/* HEADER CARD */}
                  <div className="flex justify-between mb-4">
                    <div>
                      <span
                        className={`px-3 py-1 rounded-full text-sm ${
                          template.isGlobal
                            ? "bg-blue-50 text-blue-700"
                            : "bg-green-50 text-green-700"
                        }`}
                      >
                        {template.isGlobal ? "Global" : "Personnel"}
                      </span>

                      <h3 className="text-lg font-bold mt-2">{template.nom}</h3>
                    </div>

                    {!template.isGlobal && (
                      <div className="flex gap-2">
                        <button
                          disabled={deletingId === template.id}
                          onClick={() => handleDelete(template.id!)}
                          className="p-2 text-red-600 hover:bg-red-50 rounded disabled:opacity-50"
                        >
                          {deletingId === template.id ? (
                            <Loader2 size={18} className="animate-spin" />
                          ) : (
                            <Trash2 size={18} />
                          )}
                        </button>

                        <button
                          onClick={() =>
                            navigate(`/templates/${template.id}/edit`)
                          }
                          className="p-2 text-gray-600 hover:bg-gray-100 rounded"
                        >
                          <Edit3 size={18} />
                        </button>
                      </div>
                    )}
                  </div>

                  {/* SECTIONS */}
                  <p className="text-sm text-gray-600 mb-3">
                    Sections : {template.sections?.length || 0}
                  </p>

                  {/* ACTIONS */}
                  <div className="flex gap-3 pt-4 border-t">
                    <button
                      onClick={() =>
                        navigate(`/templates/${template.id}/preview`)
                      }
                      className="flex-1 flex items-center justify-center gap-2 bg-blue-50 text-blue-700 py-2 rounded"
                    >
                      <Eye size={16} /> Voir
                    </button>

                    <button
                      onClick={() =>
                        navigate(`/cv/create?templateId=${template.id}`)
                      }
                      className="flex-1 flex items-center justify-center gap-2 bg-blue-600 text-white py-2 rounded"
                    >
                      <FileText size={16} /> Utiliser
                    </button>
                  </div>
                </div>
              </div>
            ))}
          </div>
        )}
      </div>
    </div>
  );
};

export default EtudiantTemplates;
