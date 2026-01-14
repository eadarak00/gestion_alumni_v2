import { useState } from "react";
import { Check, Layout, Briefcase, GraduationCap, User, FileText, Save, Eye, ArrowLeft } from "lucide-react";
import templateService from "../../services/ms_cv_v2/template.service";

// Types de templates prédéfinis
const PREDEFINED_TEMPLATES = [
  {
    id: "modern-minimal",
    name: "Moderne Minimaliste",
    description: "Design épuré et professionnel, parfait pour les secteurs créatifs",
    icon: Layout,
    color: "from-blue-500 to-cyan-500",
    sections: [
      { type: "header", htmlContent: `<div class="cv-header text-center mb-8">
  <h1 class="text-4xl font-bold text-gray-900 mb-2">[NOM_PRENOM]</h1>
  <h2 class="text-xl text-blue-600 mb-4">[POSTE_RECHERCHE]</h2>
  <p class="text-gray-600 max-w-2xl mx-auto">[PHRASE_ACCROCHE]</p>
</div>`, ordre: 1 },
      { type: "contact", htmlContent: `<div class="contact-info flex justify-center gap-6 mb-8 text-sm">
  <div class="flex items-center gap-2">
    <span>📧</span>
    <span>[EMAIL]</span>
  </div>
  <div class="flex items-center gap-2">
    <span>📱</span>
    <span>[TELEPHONE]</span>
  </div>
  <div class="flex items-center gap-2">
    <span>📍</span>
    <span>[VILLE]</span>
  </div>
</div>`, ordre: 2 },
      { type: "experiences", htmlContent: `<div class="section mb-8">
  <h3 class="text-2xl font-bold text-gray-900 mb-4 border-b-2 border-blue-500 pb-2">Expériences Professionnelles</h3>
  <div class="experience-item mb-6">
    <div class="flex justify-between items-start mb-2">
      <div>
        <h4 class="text-lg font-semibold text-gray-900">[POSTE]</h4>
        <p class="text-blue-600">[ENTREPRISE]</p>
      </div>
      <span class="text-gray-500 text-sm">[DATE_DEBUT] - [DATE_FIN]</span>
    </div>
    <ul class="list-disc list-inside text-gray-700 space-y-1">
      <li>[REALISATION_1]</li>
      <li>[REALISATION_2]</li>
      <li>[REALISATION_3]</li>
    </ul>
  </div>
</div>`, ordre: 3 },
      { type: "formations", htmlContent: `<div class="section mb-8">
  <h3 class="text-2xl font-bold text-gray-900 mb-4 border-b-2 border-blue-500 pb-2">Formation</h3>
  <div class="education-item mb-4">
    <div class="flex justify-between items-start">
      <div>
        <h4 class="text-lg font-semibold text-gray-900">[DIPLOME]</h4>
        <p class="text-gray-600">[ETABLISSEMENT] - [VILLE]</p>
      </div>
      <span class="text-gray-500 text-sm">[ANNEE]</span>
    </div>
  </div>
</div>`, ordre: 4 },
      { type: "competences", htmlContent: `<div class="section mb-8">
  <h3 class="text-2xl font-bold text-gray-900 mb-4 border-b-2 border-blue-500 pb-2">Compétences</h3>
  <div class="flex flex-wrap gap-2">
    <span class="px-3 py-1 bg-blue-100 text-blue-800 rounded-full text-sm">[COMPETENCE_1]</span>
    <span class="px-3 py-1 bg-blue-100 text-blue-800 rounded-full text-sm">[COMPETENCE_2]</span>
    <span class="px-3 py-1 bg-blue-100 text-blue-800 rounded-full text-sm">[COMPETENCE_3]</span>
  </div>
</div>`, ordre: 5 }
    ]
  },
  {
    id: "classic-professional",
    name: "Classique Professionnel",
    description: "Format traditionnel et sérieux, idéal pour les secteurs conservateurs",
    icon: Briefcase,
    color: "from-gray-700 to-gray-900",
    sections: [
      { type: "header", htmlContent: `<div class="cv-header mb-6">
  <h1 class="text-3xl font-bold text-gray-900 uppercase tracking-wide">[NOM_PRENOM]</h1>
  <h2 class="text-lg text-gray-700 mt-1">[POSTE_RECHERCHE]</h2>
  <div class="border-t-2 border-gray-800 mt-2 pt-2 text-sm text-gray-600">
    [EMAIL] | [TELEPHONE] | [VILLE]
  </div>
</div>`, ordre: 1 },
      { type: "summary", htmlContent: `<div class="section mb-6">
  <h3 class="text-xl font-bold text-gray-900 uppercase tracking-wide mb-3 border-b border-gray-300 pb-1">Profil</h3>
  <p class="text-gray-700 leading-relaxed">[RESUME_PROFESSIONNEL]</p>
</div>`, ordre: 2 },
      { type: "experiences", htmlContent: `<div class="section mb-6">
  <h3 class="text-xl font-bold text-gray-900 uppercase tracking-wide mb-3 border-b border-gray-300 pb-1">Expérience Professionnelle</h3>
  <div class="experience-item mb-4">
    <div class="flex justify-between mb-1">
      <strong class="text-gray-900">[POSTE]</strong>
      <span class="text-gray-600 text-sm">[DATE_DEBUT] - [DATE_FIN]</span>
    </div>
    <p class="text-gray-700 italic mb-2">[ENTREPRISE], [VILLE]</p>
    <ul class="list-disc ml-5 text-gray-700 text-sm space-y-1">
      <li>[RESPONSABILITE_1]</li>
      <li>[RESPONSABILITE_2]</li>
    </ul>
  </div>
</div>`, ordre: 3 },
      { type: "formations", htmlContent: `<div class="section mb-6">
  <h3 class="text-xl font-bold text-gray-900 uppercase tracking-wide mb-3 border-b border-gray-300 pb-1">Formation</h3>
  <div class="education-item mb-3">
    <div class="flex justify-between">
      <strong class="text-gray-900">[DIPLOME]</strong>
      <span class="text-gray-600 text-sm">[ANNEE]</span>
    </div>
    <p class="text-gray-700">[ETABLISSEMENT], [VILLE]</p>
  </div>
</div>`, ordre: 4 },
      { type: "competences", htmlContent: `<div class="section mb-6">
  <h3 class="text-xl font-bold text-gray-900 uppercase tracking-wide mb-3 border-b border-gray-300 pb-1">Compétences</h3>
  <div class="grid grid-cols-2 gap-2 text-sm text-gray-700">
    <div>• [COMPETENCE_1]</div>
    <div>• [COMPETENCE_2]</div>
    <div>• [COMPETENCE_3]</div>
    <div>• [COMPETENCE_4]</div>
  </div>
</div>`, ordre: 5 }
    ]
  },
  {
    id: "creative-bold",
    name: "Créatif Audacieux",
    description: "Design coloré et innovant pour se démarquer",
    icon: GraduationCap,
    color: "from-purple-500 to-pink-500",
    sections: [
      { type: "header", htmlContent: `<div class="cv-header bg-gradient-to-r from-purple-600 to-pink-600 text-white p-8 rounded-lg mb-6">
  <h1 class="text-4xl font-extrabold mb-2">[NOM_PRENOM]</h1>
  <h2 class="text-2xl font-light mb-4">[POSTE_RECHERCHE]</h2>
  <p class="text-purple-100">[PHRASE_ACCROCHE]</p>
</div>`, ordre: 1 },
      { type: "contact", htmlContent: `<div class="contact-grid grid grid-cols-3 gap-4 mb-6">
  <div class="bg-purple-50 p-3 rounded-lg text-center">
    <div class="text-purple-600 font-bold text-sm">Email</div>
    <div class="text-gray-700 text-xs">[EMAIL]</div>
  </div>
  <div class="bg-pink-50 p-3 rounded-lg text-center">
    <div class="text-pink-600 font-bold text-sm">Téléphone</div>
    <div class="text-gray-700 text-xs">[TELEPHONE]</div>
  </div>
  <div class="bg-purple-50 p-3 rounded-lg text-center">
    <div class="text-purple-600 font-bold text-sm">Localisation</div>
    <div class="text-gray-700 text-xs">[VILLE]</div>
  </div>
</div>`, ordre: 2 },
      { type: "experiences", htmlContent: `<div class="section mb-6">
  <div class="flex items-center gap-3 mb-4">
    <div class="w-1 h-8 bg-gradient-to-b from-purple-600 to-pink-600 rounded"></div>
    <h3 class="text-2xl font-bold text-gray-900">Parcours</h3>
  </div>
  <div class="experience-item bg-gray-50 p-4 rounded-lg mb-4">
    <div class="flex justify-between items-start mb-2">
      <h4 class="text-lg font-bold text-purple-600">[POSTE]</h4>
      <span class="bg-purple-100 text-purple-800 px-3 py-1 rounded-full text-xs font-semibold">[DATE_DEBUT] - [DATE_FIN]</span>
    </div>
    <p class="text-gray-700 font-medium mb-2">[ENTREPRISE]</p>
    <ul class="space-y-1 text-gray-600 text-sm">
      <li>✨ [REALISATION_1]</li>
      <li>✨ [REALISATION_2]</li>
    </ul>
  </div>
</div>`, ordre: 3 },
      { type: "competences", htmlContent: `<div class="section mb-6">
  <div class="flex items-center gap-3 mb-4">
    <div class="w-1 h-8 bg-gradient-to-b from-purple-600 to-pink-600 rounded"></div>
    <h3 class="text-2xl font-bold text-gray-900">Expertise</h3>
  </div>
  <div class="grid grid-cols-2 gap-3">
    <div class="bg-gradient-to-r from-purple-100 to-pink-100 p-3 rounded-lg">
      <h4 class="font-bold text-purple-700 text-sm mb-2">[CATEGORIE_1]</h4>
      <div class="flex flex-wrap gap-1">
        <span class="bg-white text-purple-600 px-2 py-1 rounded text-xs">[COMPETENCE_1]</span>
        <span class="bg-white text-purple-600 px-2 py-1 rounded text-xs">[COMPETENCE_2]</span>
      </div>
    </div>
  </div>
</div>`, ordre: 4 }
    ]
  },
  {
    id: "tech-developer",
    name: "Tech & Développeur",
    description: "Optimisé pour les profils techniques et développeurs",
    icon: FileText,
    color: "from-green-500 to-teal-500",
    sections: [
      { type: "header", htmlContent: `<div class="cv-header border-l-4 border-green-500 pl-6 mb-6">
  <h1 class="text-3xl font-mono font-bold text-gray-900">&lt;[NOM_PRENOM] /&gt;</h1>
  <h2 class="text-xl text-green-600 font-mono mt-2">[POSTE_RECHERCHE]</h2>
  <p class="text-gray-600 mt-3 font-light">[BIO_TECHNIQUE]</p>
</div>`, ordre: 1 },
      { type: "contact", htmlContent: `<div class="contact-info font-mono text-sm mb-6 bg-gray-50 p-4 rounded border-l-4 border-green-500">
  <div class="grid grid-cols-2 gap-2">
    <div><span class="text-green-600">$</span> email: [EMAIL]</div>
    <div><span class="text-green-600">$</span> phone: [TELEPHONE]</div>
    <div><span class="text-green-600">$</span> location: [VILLE]</div>
    <div><span class="text-green-600">$</span> github: [GITHUB]</div>
  </div>
</div>`, ordre: 2 },
      { type: "competences", htmlContent: `<div class="section mb-6">
  <h3 class="text-xl font-mono font-bold text-gray-900 mb-4">
    <span class="text-green-600">//</span> Stack Technique
  </h3>
  <div class="space-y-3">
    <div>
      <div class="text-sm font-semibold text-gray-700 mb-1">[CATEGORIE_TECH]</div>
      <div class="flex flex-wrap gap-2">
        <code class="bg-green-50 border border-green-200 text-green-700 px-2 py-1 rounded text-sm">[TECHNO_1]</code>
        <code class="bg-green-50 border border-green-200 text-green-700 px-2 py-1 rounded text-sm">[TECHNO_2]</code>
        <code class="bg-green-50 border border-green-200 text-green-700 px-2 py-1 rounded text-sm">[TECHNO_3]</code>
      </div>
    </div>
  </div>
</div>`, ordre: 3 },
      { type: "projets", htmlContent: `<div class="section mb-6">
  <h3 class="text-xl font-mono font-bold text-gray-900 mb-4">
    <span class="text-green-600">//</span> Projets
  </h3>
  <div class="border border-gray-200 rounded p-4 mb-3">
    <div class="flex justify-between items-start mb-2">
      <h4 class="font-mono font-bold text-gray-900">[NOM_PROJET]</h4>
      <a href="[LIEN_PROJET]" class="text-green-600 text-sm hover:underline">→ Voir le projet</a>
    </div>
    <p class="text-gray-600 text-sm mb-2">[DESCRIPTION_PROJET]</p>
    <div class="flex flex-wrap gap-1">
      <span class="bg-gray-100 text-gray-700 px-2 py-1 rounded text-xs font-mono">[TECH_1]</span>
      <span class="bg-gray-100 text-gray-700 px-2 py-1 rounded text-xs font-mono">[TECH_2]</span>
    </div>
  </div>
</div>`, ordre: 4 },
      { type: "experiences", htmlContent: `<div class="section mb-6">
  <h3 class="text-xl font-mono font-bold text-gray-900 mb-4">
    <span class="text-green-600">//</span> Expériences
  </h3>
  <div class="mb-4">
    <div class="flex justify-between mb-2">
      <div>
        <h4 class="font-mono font-bold text-gray-900">[POSTE]</h4>
        <p class="text-green-600 text-sm">[ENTREPRISE]</p>
      </div>
      <span class="text-gray-500 text-sm font-mono">[DATE_DEBUT] → [DATE_FIN]</span>
    </div>
    <ul class="text-gray-700 text-sm space-y-1 font-light">
      <li>→ [MISSION_1]</li>
      <li>→ [MISSION_2]</li>
    </ul>
  </div>
</div>`, ordre: 5 }
    ]
  }
];

const CreateTemplate = () => {
  const [step, setStep] = useState<"select" | "confirm" | "preview">("select");
  const [selectedTemplate, setSelectedTemplate] = useState<typeof PREDEFINED_TEMPLATES[0] | null>(null);
  const [templateName, setTemplateName] = useState("");
  const [isGlobal, setIsGlobal] = useState(false);
  const [previewHTML, setPreviewHTML] = useState("");

  const handleSelectTemplate = (template: typeof PREDEFINED_TEMPLATES[0]) => {
    setSelectedTemplate(template);
    setTemplateName(template.name);
    setStep("confirm");
  };

  const handlePreview = () => {
    if (selectedTemplate) {
      const html = selectedTemplate.sections
        .map(s => s.htmlContent)
        .join('\n\n');
      setPreviewHTML(html);
      setStep("preview");
    }
  };

  const handleSubmit = async () => {
    if (!selectedTemplate || !templateName.trim()) {
      alert("Veuillez remplir tous les champs");
      return;
    }

    const payload = {
      nom: templateName,
      isGlobal,
      sections: selectedTemplate.sections
    };

    console.log("Template à créer:", payload);
    
    // Simuler l'appel API
    await templateService.createTemplate(payload);
    
    alert("Template créé avec succès!");
    
    // Reset
    setStep("select");
    setSelectedTemplate(null);
    setTemplateName("");
    setIsGlobal(false);
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-gray-50 to-gray-100 p-4 md:p-8">
      <div className="max-w-7xl mx-auto">
        {/* Header */}
        <div className="mb-8 bg-white rounded-2xl shadow-xl p-6 md:p-8">
          <div className="flex items-center justify-between">
            <div>
              <h1 className="text-3xl md:text-4xl font-bold text-gray-900">
                {step === "select" && "Choisissez votre modèle de CV"}
                {step === "confirm" && "Personnalisez votre template"}
                {step === "preview" && "Aperçu du template"}
              </h1>
              <p className="text-gray-600 mt-2">
                {step === "select" && "Sélectionnez un modèle prédéfini pour créer rapidement votre template"}
                {step === "confirm" && "Configurez les paramètres de votre template avant création"}
                {step === "preview" && "Visualisez le rendu de votre template"}
              </p>
            </div>
            {step !== "select" && (
              <button
                onClick={() => setStep(step === "preview" ? "confirm" : "select")}
                className="flex items-center gap-2 px-4 py-2 text-gray-600 hover:bg-gray-100 rounded-xl transition"
              >
                <ArrowLeft size={20} />
                Retour
              </button>
            )}
          </div>
        </div>

        {/* Step 1: Select Template */}
        {step === "select" && (
          <div className="grid md:grid-cols-2 gap-6">
            {PREDEFINED_TEMPLATES.map((template) => (
              <div
                key={template.id}
                onClick={() => handleSelectTemplate(template)}
                className="bg-white rounded-2xl shadow-lg hover:shadow-2xl transition-all cursor-pointer overflow-hidden group"
              >
                <div className={`h-3 bg-gradient-to-r ${template.color}`}></div>
                <div className="p-6">
                  <div className="flex items-start justify-between mb-4">
                    <div className={`p-4 bg-gradient-to-r ${template.color} rounded-xl`}>
                      <template.icon className="w-8 h-8 text-white" />
                    </div>
                    <div className="opacity-0 group-hover:opacity-100 transition-opacity">
                      <div className="bg-green-100 text-green-700 px-3 py-1 rounded-full text-sm font-semibold">
                        Sélectionner
                      </div>
                    </div>
                  </div>
                  
                  <h3 className="text-2xl font-bold text-gray-900 mb-2">
                    {template.name}
                  </h3>
                  
                  <p className="text-gray-600 mb-4">
                    {template.description}
                  </p>
                  
                  <div className="flex items-center justify-between pt-4 border-t border-gray-100">
                    <div className="text-sm text-gray-500">
                      {template.sections.length} sections incluses
                    </div>
                    <div className="flex gap-2">
                      {template.sections.slice(0, 3).map((section, idx) => (
                        <div
                          key={idx}
                          className="w-2 h-2 bg-gray-300 rounded-full"
                        ></div>
                      ))}
                    </div>
                  </div>
                </div>
              </div>
            ))}
          </div>
        )}

        {/* Step 2: Confirm and Configure */}
        {step === "confirm" && selectedTemplate && (
          <div className="space-y-6">
            {/* Template Info */}
            <div className="bg-white rounded-2xl shadow-xl p-6 md:p-8">
              <div className="flex items-center gap-4 mb-6">
                <div className={`p-4 bg-gradient-to-r ${selectedTemplate.color} rounded-xl`}>
                  <selectedTemplate.icon className="w-8 h-8 text-white" />
                </div>
                <div>
                  <h2 className="text-2xl font-bold text-gray-900">
                    {selectedTemplate.name}
                  </h2>
                  <p className="text-gray-600">
                    {selectedTemplate.description}
                  </p>
                </div>
              </div>

              {/* Configuration */}
              <div className="space-y-6">
                <div>
                  <label className="block text-sm font-semibold text-gray-700 mb-2">
                    Nom du template *
                  </label>
                  <input
                    type="text"
                    className="w-full border border-gray-300 rounded-xl p-3 focus:ring-2 focus:ring-blue-500 focus:border-blue-500 transition"
                    value={templateName}
                    onChange={(e) => setTemplateName(e.target.value)}
                    placeholder="Ex: Mon CV Moderne"
                  />
                </div>

                <div>
                  <label className="block text-sm font-semibold text-gray-700 mb-3">
                    Visibilité du template
                  </label>
                  <div className="grid md:grid-cols-2 gap-4">
                    <label className={`flex items-start gap-3 p-4 border-2 rounded-xl cursor-pointer transition ${!isGlobal ? 'border-blue-500 bg-blue-50' : 'border-gray-200 hover:border-gray-300'}`}>
                      <input
                        type="radio"
                        name="visibility"
                        checked={!isGlobal}
                        onChange={() => setIsGlobal(false)}
                        className="mt-1"
                      />
                      <div>
                        <div className="font-semibold text-gray-900 mb-1">
                          Personnel
                        </div>
                        <div className="text-sm text-gray-600">
                          Visible uniquement par vous
                        </div>
                      </div>
                    </label>
                    
                    <label className={`flex items-start gap-3 p-4 border-2 rounded-xl cursor-pointer transition ${isGlobal ? 'border-blue-500 bg-blue-50' : 'border-gray-200 hover:border-gray-300'}`}>
                      <input
                        type="radio"
                        name="visibility"
                        checked={isGlobal}
                        onChange={() => setIsGlobal(true)}
                        className="mt-1"
                      />
                      <div>
                        <div className="font-semibold text-gray-900 mb-1">
                          Global
                        </div>
                        <div className="text-sm text-gray-600">
                          Visible par tous les utilisateurs
                        </div>
                      </div>
                    </label>
                  </div>
                </div>
              </div>
            </div>

            {/* Sections Preview */}
            <div className="bg-white rounded-2xl shadow-xl p-6 md:p-8">
              <h3 className="text-xl font-bold text-gray-900 mb-4">
                Sections incluses ({selectedTemplate.sections.length})
              </h3>
              <div className="grid md:grid-cols-2 lg:grid-cols-3 gap-4">
                {selectedTemplate.sections.map((section, idx) => (
                  <div
                    key={idx}
                    className="flex items-center gap-3 p-4 bg-gray-50 rounded-xl border border-gray-200"
                  >
                    <div className="w-8 h-8 bg-green-100 text-green-700 rounded-lg flex items-center justify-center font-bold text-sm">
                      {section.ordre}
                    </div>
                    <div className="flex-1">
                      <div className="font-semibold text-gray-900 capitalize">
                        {section.type}
                      </div>
                      <div className="text-xs text-gray-500">
                        Section HTML
                      </div>
                    </div>
                    <Check className="w-5 h-5 text-green-600" />
                  </div>
                ))}
              </div>
            </div>

            {/* Actions */}
            <div className="flex justify-end gap-4">
              <button
                onClick={handlePreview}
                className="px-6 py-3 border border-gray-300 rounded-xl font-medium text-gray-700 hover:bg-gray-50 transition flex items-center gap-2"
              >
                <Eye size={20} />
                Prévisualiser
              </button>
              <button
                onClick={handleSubmit}
                className="px-8 py-3 bg-gradient-to-r from-blue-600 to-purple-600 text-white rounded-xl font-medium hover:opacity-90 transition flex items-center gap-2 shadow-lg"
              >
                <Save size={20} />
                Créer le Template
              </button>
            </div>
          </div>
        )}

        {/* Step 3: Preview */}
        {step === "preview" && (
          <div className="bg-white rounded-2xl shadow-xl p-6 md:p-8">
            <div className="flex justify-between items-center mb-6">
              <h2 className="text-xl font-bold text-gray-900 flex items-center gap-3">
                <Eye className="w-6 h-6 text-green-500" />
                Aperçu du Template
              </h2>
              <button
                onClick={handleSubmit}
                className="px-6 py-3 bg-gradient-to-r from-blue-600 to-purple-600 text-white rounded-xl font-medium hover:opacity-90 transition flex items-center gap-2"
              >
                <Save size={20} />
                Créer le Template
              </button>
            </div>

            <div className="bg-gray-50 rounded-2xl p-8">
              <div className="max-w-4xl mx-auto bg-white shadow-2xl rounded-xl p-12">
                <div dangerouslySetInnerHTML={{ __html: previewHTML }} />
              </div>
            </div>

            <div className="mt-6 p-4 bg-blue-50 rounded-xl">
              <h4 className="font-semibold text-blue-800 mb-2">ℹ️ À propos de l'aperçu</h4>
              <p className="text-sm text-blue-700">
                Les variables entre crochets [COMME_CECI] seront remplacées par les vraies données lors de la génération du CV.
              </p>
            </div>
          </div>
        )}
      </div>
    </div>
  );
};

export default CreateTemplate;