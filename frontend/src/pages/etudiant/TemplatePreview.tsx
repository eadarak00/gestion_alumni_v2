import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { 
  Loader2, 
  ArrowLeft, 
  Download, 
  Printer, 
  Share2, 
  Edit3, 
  FileText,
  Layout,
  Palette,
  Type,
  ChevronRight,
  CheckCircle,
  Smartphone,
  Monitor,
  Tablet
} from "lucide-react";
import { toast } from "react-hot-toast";
import templateService from "../../services/ms_cv_v2/template.service";
import { TemplateResponseDTO } from "../../api-ms-cv-v2/js-client";

const TemplatePreview = () => {
  const { id } = useParams<{ id: string }>();
  const navigate = useNavigate();
  const [template, setTemplate] = useState<TemplateResponseDTO | null>(null);
  const [loading, setLoading] = useState(true);
  const [activeView, setActiveView] = useState<'desktop' | 'tablet' | 'mobile'>('desktop');
  const [zoom, setZoom] = useState(1);

  // Récupérer le template
  useEffect(() => {
    const fetchTemplate = async () => {
      if (!id) return;
      
      setLoading(true);
      try {
        const templateData = await templateService.getTemplateById(parseInt(id));
        setTemplate(templateData);
      } catch (err) {
        console.error(err);
        toast.error("Impossible de charger le template");
        navigate("/templates");
      } finally {
        setLoading(false);
      }
    };

    fetchTemplate();
  }, [id, navigate]);

  // Télécharger le template PDF
  const handleDownload = async () => {
    if (!template?.id) return;
    
    try {
      toast.loading("Génération du PDF...");
      // Simuler le téléchargement - à remplacer par l'appel réel
      await new Promise(resolve => setTimeout(resolve, 1500));
      toast.dismiss();
      toast.success("PDF généré avec succès");
    } catch (err) {
      toast.error("Erreur lors de la génération du PDF");
    }
  };

  // Imprimer le template
  const handlePrint = () => {
    window.print();
  };

  // Partager le template
  const handleShare = () => {
    if (navigator.share) {
      navigator.share({
        title: template?.nom || "Template CV",
        text: `Découvrez ce template CV: ${template?.nom}`,
        url: window.location.href,
      });
    } else {
      navigator.clipboard.writeText(window.location.href);
      toast.success("Lien copié dans le presse-papier");
    }
  };

  // Simuler un rendu de template basé sur les sections
  const renderTemplatePreview = () => {
    if (!template?.sections) return null;

    return (
      <div className={`bg-white shadow-lg ${activeView === 'mobile' ? 'max-w-[400px]' : activeView === 'tablet' ? 'max-w-[768px]' : 'max-w-[1000px]'}`}>
        {/* En-tête du CV */}
        <div className="bg-gradient-to-r from-blue-600 to-indigo-700 text-white p-8">
          <div className="flex justify-between items-start">
            <div>
              <h1 className="text-3xl font-bold mb-2">JEAN DUPONT</h1>
              <p className="text-blue-100 text-lg">Développeur Full Stack</p>
            </div>
            <div className="text-right text-blue-100">
              <p className="mb-1">contact@jeandupont.com</p>
              <p className="mb-1">+33 6 12 34 56 78</p>
              <p>Paris, France</p>
            </div>
          </div>
        </div>

        {/* Corps du CV */}
        <div className="p-8">
          {/* Sections dynamiques basées sur le template */}
          {template.sections.map((section, index) => (
            <div key={index} className="mb-8 last:mb-0">
              <div className="flex items-center mb-4">
                <div className="w-1 h-8 bg-blue-600 mr-3 rounded-full"></div>
                <h2 className="text-xl font-bold text-gray-800">
                  {section?.type?.replace(/_/g, ' ')}
                </h2>
              </div>
              
              {/* Contenu de section simulé */}
              <div className="bg-gray-50 p-4 rounded-lg">
                {section.type === 'EXPERIENCE' && (
                  <div className="space-y-4">
                    <div className="border-l-4 border-blue-500 pl-4">
                      <h3 className="font-semibold text-gray-800">Développeur Full Stack - TechCorp</h3>
                      <p className="text-gray-600 text-sm">2020 - Présent | Paris</p>
                      <p className="text-gray-700 mt-2">
                        Développement d'applications web modernes avec React et Node.js.
                        Collaboration avec une équipe de 10 développeurs.
                      </p>
                    </div>
                  </div>
                )}
                
                {section.type === 'EDUCATION' && (
                  <div className="space-y-4">
                    <div className="border-l-4 border-green-500 pl-4">
                      <h3 className="font-semibold text-gray-800">Master en Informatique</h3>
                      <p className="text-gray-600 text-sm">Université Paris-Saclay | 2018-2020</p>
                      <p className="text-gray-700 mt-2">
                        Spécialisation en développement web et intelligence artificielle.
                      </p>
                    </div>
                  </div>
                )}
                
                {section.type === 'SKILLS' && (
                  <div className="flex flex-wrap gap-2">
                    {['React', 'TypeScript', 'Node.js', 'MongoDB', 'AWS', 'Docker'].map((skill, i) => (
                      <span 
                        key={i}
                        className="px-3 py-1 bg-blue-100 text-blue-700 rounded-full text-sm"
                      >
                        {skill}
                      </span>
                    ))}
                  </div>
                )}
                
                {section.type === 'PROJECTS' && (
                  <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
                    {[1, 2].map((project) => (
                      <div key={project} className="bg-white p-4 rounded border border-gray-200">
                        <h3 className="font-semibold text-gray-800 mb-2">Projet {project}</h3>
                        <p className="text-gray-600 text-sm">
                          Description du projet {project} développé avec les dernières technologies.
                        </p>
                      </div>
                    ))}
                  </div>
                )}
              </div>
            </div>
          ))}
        </div>
      </div>
    );
  };

  if (loading) {
    return (
      <div className="min-h-screen flex flex-col items-center justify-center bg-gradient-to-br from-gray-50 to-gray-100">
        <div className="text-center">
          <Loader2 className="animate-spin mx-auto text-blue-600" size={48} />
          <p className="mt-4 text-gray-600">Chargement du template...</p>
        </div>
      </div>
    );
  }

  if (!template) {
    return (
      <div className="min-h-screen flex flex-col items-center justify-center bg-gradient-to-br from-gray-50 to-gray-100">
        <div className="text-center">
          <FileText size={64} className="mx-auto text-gray-300 mb-4" />
          <h3 className="text-xl font-semibold text-gray-700 mb-2">
            Template non trouvé
          </h3>
          <button
            onClick={() => navigate("/templates")}
            className="mt-4 inline-flex items-center gap-2 bg-blue-600 text-white px-6 py-3 rounded-lg hover:bg-blue-700 transition-colors"
          >
            <ArrowLeft size={18} />
            Retour aux templates
          </button>
        </div>
      </div>
    );
  }

  return (
    <div className="min-h-screen bg-gradient-to-br from-gray-50 to-gray-100">
      {/* En-tête fixe */}
      <header className="sticky top-0 z-50 bg-white/80 backdrop-blur-md border-b border-gray-200">
        <div className="max-w-7xl mx-auto px-4 py-4">
          <div className="flex items-center justify-between">
            <div className="flex items-center gap-4">
              <button
                onClick={() => navigate("/templates")}
                className="flex items-center gap-2 text-gray-600 hover:text-gray-900 transition-colors"
              >
                <ArrowLeft size={20} />
                Retour
              </button>
              
              <div className="hidden md:block">
                <nav className="flex items-center gap-2 text-sm text-gray-500">
                  <span>Templates</span>
                  <ChevronRight size={16} />
                  <span className="text-gray-700 font-medium">{template.nom}</span>
                </nav>
              </div>
            </div>

            <div className="flex items-center gap-3">
              <button
                onClick={() => navigate(`/templates/${id}/edit`)}
                className="flex items-center gap-2 px-4 py-2 bg-gray-100 text-gray-700 hover:bg-gray-200 rounded-lg transition-colors"
              >
                <Edit3 size={18} />
                Modifier
              </button>
              
              <button
                onClick={handleShare}
                className="flex items-center gap-2 px-4 py-2 bg-blue-50 text-blue-600 hover:bg-blue-100 rounded-lg transition-colors"
              >
                <Share2 size={18} />
                Partager
              </button>
              
              <button
                onClick={() => navigate(`/cv/create?templateId=${template.id}`)}
                className="flex items-center gap-2 px-4 py-2 bg-gradient-to-r from-blue-600 to-indigo-600 text-white hover:from-blue-700 hover:to-indigo-700 rounded-lg transition-all shadow-sm"
              >
                <FileText size={18} />
                Utiliser ce template
              </button>
            </div>
          </div>
        </div>
      </header>

      <div className="max-w-7xl mx-auto px-4 py-8">
        <div className="flex flex-col lg:flex-row gap-8">
          {/* Panneau latéral */}
          <div className="lg:w-1/4 space-y-6">
            {/* Informations du template */}
            <div className="bg-white rounded-xl shadow-sm border border-gray-200 p-6">
              <h2 className="text-xl font-bold text-gray-900 mb-4 flex items-center gap-2">
                <Layout size={20} />
                {template.nom}
              </h2>
              
              <div className="space-y-4">
                <div>
                  <p className="text-sm text-gray-500 mb-1">Type</p>
                  <div className="inline-flex items-center gap-2 px-3 py-1 rounded-full bg-blue-50 text-blue-700 text-sm">
                    {template.isGlobal ? 'Global' : 'Personnel'}
                  </div>
                </div>
                
                <div>
                  <p className="text-sm text-gray-500 mb-1">Sections</p>
                  <div className="space-y-2">
                    {template.sections?.map((section, index) => (
                      <div key={index} className="flex items-center gap-2">
                        <CheckCircle size={16} className="text-green-500" />
                        <span className="text-gray-700">{section?.type?.replace(/_/g, ' ')}</span>
                      </div>
                    ))}
                  </div>
                </div>
                
                <div>
                  <p className="text-sm text-gray-500 mb-1">Date de création</p>
                  <p className="text-gray-700">
                    {new Date(template.createdAt || Date.now()).toLocaleDateString('fr-FR')}
                  </p>
                </div>
              </div>
            </div>

            {/* Contrôles d'affichage */}
            <div className="bg-white rounded-xl shadow-sm border border-gray-200 p-6">
              <h3 className="font-semibold text-gray-900 mb-4 flex items-center gap-2">
                <Monitor size={20} />
                Aperçu
              </h3>
              
              <div className="space-y-4">
                <div>
                  <p className="text-sm text-gray-500 mb-2">Appareil</p>
                  <div className="grid grid-cols-3 gap-2">
                    {[
                      { mode: 'desktop', icon: Monitor, label: 'Desktop' },
                      { mode: 'tablet', icon: Tablet, label: 'Tablette' },
                      { mode: 'mobile', icon: Smartphone, label: 'Mobile' },
                    ].map(({ mode, icon: Icon, label }) => (
                      <button
                        key={mode}
                        onClick={() => setActiveView(mode as any)}
                        className={`flex flex-col items-center justify-center p-3 rounded-lg transition-all ${
                          activeView === mode 
                            ? 'bg-blue-50 border-2 border-blue-500' 
                            : 'bg-gray-50 border-2 border-transparent hover:bg-gray-100'
                        }`}
                      >
                        <Icon size={24} className={activeView === mode ? 'text-blue-600' : 'text-gray-500'} />
                        <span className="text-xs mt-1">{label}</span>
                      </button>
                    ))}
                  </div>
                </div>
                
                <div>
                  <p className="text-sm text-gray-500 mb-2">Zoom</p>
                  <div className="flex items-center gap-3">
                    <button
                      onClick={() => setZoom(Math.max(0.5, zoom - 0.1))}
                      className="p-2 bg-gray-100 rounded-lg hover:bg-gray-200"
                      disabled={zoom <= 0.5}
                    >
                      -
                    </button>
                    <span className="flex-1 text-center font-medium">{Math.round(zoom * 100)}%</span>
                    <button
                      onClick={() => setZoom(Math.min(2, zoom + 0.1))}
                      className="p-2 bg-gray-100 rounded-lg hover:bg-gray-200"
                      disabled={zoom >= 2}
                    >
                      +
                    </button>
                  </div>
                  <input
                    type="range"
                    min="50"
                    max="200"
                    value={zoom * 100}
                    onChange={(e) => setZoom(parseInt(e.target.value) / 100)}
                    className="w-full mt-2"
                  />
                </div>
              </div>
            </div>

            {/* Actions */}
            <div className="bg-white rounded-xl shadow-sm border border-gray-200 p-6">
              <h3 className="font-semibold text-gray-900 mb-4">Actions</h3>
              <div className="space-y-3">
                <button
                  onClick={handleDownload}
                  className="w-full flex items-center justify-center gap-2 px-4 py-3 bg-blue-600 text-white hover:bg-blue-700 rounded-lg transition-colors"
                >
                  <Download size={18} />
                  Télécharger en PDF
                </button>
                
                <button
                  onClick={handlePrint}
                  className="w-full flex items-center justify-center gap-2 px-4 py-3 bg-gray-100 text-gray-700 hover:bg-gray-200 rounded-lg transition-colors"
                >
                  <Printer size={18} />
                  Imprimer
                </button>
              </div>
            </div>

            {/* Détails du style */}
            <div className="bg-white rounded-xl shadow-sm border border-gray-200 p-6">
              <h3 className="font-semibold text-gray-900 mb-4 flex items-center gap-2">
                <Palette size={20} />
                Style
              </h3>
              <div className="space-y-4">
                <div>
                  <p className="text-sm text-gray-500 mb-2">Police</p>
                  <div className="flex items-center gap-2">
                    <Type size={16} />
                    <span className="text-gray-700">Inter (sans-serif)</span>
                  </div>
                </div>
                
                <div>
                  <p className="text-sm text-gray-500 mb-2">Couleurs</p>
                  <div className="flex gap-2">
                    {['#3B82F6', '#1E40AF', '#6B7280', '#111827'].map((color, i) => (
                      <div
                        key={i}
                        className="w-8 h-8 rounded-full border border-gray-200"
                        style={{ backgroundColor: color }}
                        title={color}
                      />
                    ))}
                  </div>
                </div>
              </div>
            </div>
          </div>

          {/* Aperçu principal */}
          <div className="lg:w-3/4">
            <div className="bg-white rounded-xl shadow-sm border border-gray-200 p-6 mb-6">
              <div className="flex items-center justify-between mb-6">
                <h2 className="text-2xl font-bold text-gray-900">Aperçu en direct</h2>
                <div className="text-sm text-gray-500">
                  Template ID: {template.id}
                </div>
              </div>
              
              <div className="flex justify-center bg-gray-50 rounded-xl p-8 overflow-auto">
                <div 
                  className="transition-transform duration-200"
                  style={{ transform: `scale(${zoom})` }}
                >
                  {renderTemplatePreview()}
                </div>
              </div>
              
              <div className="mt-6 pt-6 border-t border-gray-200">
                <p className="text-sm text-gray-500 text-center">
                  Cet aperçu montre à quoi ressemblera votre CV avec ce template.
                  Cliquez sur "Utiliser ce template" pour créer votre CV personnalisé.
                </p>
              </div>
            </div>

            {/* Conseils d'utilisation */}
            <div className="bg-gradient-to-r from-blue-50 to-indigo-50 rounded-xl border border-blue-200 p-6">
              <h3 className="text-lg font-semibold text-gray-900 mb-4 flex items-center gap-2">
                💡 Conseils d'utilisation
              </h3>
              <ul className="space-y-3">
                <li className="flex items-start gap-2">
                  <div className="w-2 h-2 bg-blue-500 rounded-full mt-2"></div>
                  <span className="text-gray-700">
                    Ce template est optimisé pour une impression A4
                  </span>
                </li>
                <li className="flex items-start gap-2">
                  <div className="w-2 h-2 bg-blue-500 rounded-full mt-2"></div>
                  <span className="text-gray-700">
                    Utilisez un contraste élevé pour une meilleure lisibilité
                  </span>
                </li>
                <li className="flex items-start gap-2">
                  <div className="w-2 h-2 bg-blue-500 rounded-full mt-2"></div>
                  <span className="text-gray-700">
                    Personnalisez les couleurs selon votre secteur d'activité
                  </span>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default TemplatePreview;