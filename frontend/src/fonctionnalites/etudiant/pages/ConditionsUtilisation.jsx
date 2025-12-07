import React from "react";
import PropTypes from 'prop-types'; // <-- NOUVELLE IMPORTATION
import logoUasz from "../../../assets/logos/uasz.jpg";

const ConditionsUtilisation = () => {
  return (
    <div className="flex flex-col min-h-screen bg-gray-50">
      {/* Header sticky */}
      <header className="sticky top-0 z-30 bg-white border-b border-gray-200 py-4">
        <div className="max-w-6xl mx-auto flex items-center justify-between px-4 sm:px-6 lg:px-8">
          <div className="flex items-center gap-3">
            {/* Logo sans bordure */}
            <div className="w-12 h-12 flex items-center justify-center">
              <img
                src={logoUasz}
                alt="Logo Université Assane Seck"
                className="w-10 h-10 object-cover"
              />
            </div>

            <div>
              <span className="block text-lg font-bold text-gray-900">
                Université Assane Seck de Ziguinchor
              </span>
              <span className="block text-xs text-emerald-700 italic">
                L'excellence, ma référence
              </span>
            </div>
          </div>

          <a
            href="/"
            className="inline-flex items-center text-gray-500 hover:text-emerald-600 space-x-1 transition"
          >
            <svg className="w-5 h-5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
              <path
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="M6 18L18 6M6 6l12 12"
              />
            </svg>
            <span className="text-sm font-medium">Fermer</span>
          </a>
        </div>
      </header>

      {/* Main content */}
      <main className="flex-1 max-w-4xl mx-auto px-4 sm:px-6 lg:px-8 py-12">
        {/* Title */}
        <section className="mb-10 text-center">
          <h1 className="text-3xl font-bold text-gray-800 mb-2 tracking-tight">
            Conditions d&apos;utilisation
          </h1>
          <p className="text-base text-gray-600 mb-2">
            Plateforme Alumni — Communauté des Anciens Étudiants
          </p>
          <span className="text-xs text-gray-500">
            Dernière mise à jour :{" "}
            {new Date().toLocaleDateString("fr-FR", {
              year: "numeric",
              month: "long",
              day: "numeric",
            })}
          </span>
        </section>

        {/* Sections */}
        <div className="space-y-8">
          <Section
            title="Acceptation des conditions"
            index={1}
            description={
              <>
                En utilisant cette plateforme, vous reconnaissez avoir lu et accepté l'ensemble de
                ces conditions d'utilisation ainsi que toutes les lois applicables. En cas de
                désaccord, quittez la plateforme.
              </>
            }
          />

          <Section
            title="Inscription et gestion du compte"
            index={2}
            description={
              <>
                Pour accéder à nos services, créez un compte personnel avec des informations exactes
                et à jour. Vous devez :
                <ul className="list-disc ml-6 mt-2 text-sm text-gray-700 space-y-1">
                  <li>Être étudiant ou alumni de l'université</li>
                  <li>Fournir des informations véridiques</li>
                  <li>Maintenir la confidentialité de votre mot de passe</li>
                  <li>Signaler toute utilisation non autorisée</li>
                </ul>
              </>
            }
            note="Vous êtes responsable de toutes les activités liées à votre compte."
          />

          <Section
            title="Services et fonctionnalités"
            index={3}
            description={
              <>
                Vous bénéficiez de services dédiés à la communauté alumni : création de profil,
                réseau de contacts, mentorat, opportunités et événements.
              </>
            }
          />

          <Section
            title="Comportement et éthique"
            index={4}
            description={
              <>
                Le respect et la bienveillance sont obligatoires. Sont interdits :
                <ul className="list-disc ml-6 mt-2 text-sm text-gray-700 space-y-1">
                  <li>Contenu offensant, diffamatoire, illégal</li>
                  <li>Harcèlement ou discrimination</li>
                  <li>Spam ou usage commercial non autorisé</li>
                  <li>Toute tentative de piratage ou fraude</li>
                </ul>
              </>
            }
            note="Toute violation peut entraîner la suspension du compte."
          />

          <Section
            title="Protection des données personnelles"
            index={5}
            description={
              <>
                Vos données sont traitées conformément au RGPD et aux lois nationales. Vous disposez
                d’un droit d’accès, de modification et de suppression de vos informations.
              </>
            }
          />

          <Section
            title="Propriété intellectuelle"
            index={6}
            description={
              <>
                Le contenu de la plateforme est protégé. Toute reproduction ou diffusion sans
                autorisation est interdite.
              </>
            }
          />

          <Section
            title="Modification des conditions"
            index={7}
            description={
              <>Des mises à jour peuvent être apportées. Les utilisateurs seront informés.</>
            }
          />

          <Section
            title="Résiliation"
            index={8}
            description={
              <>
                En cas de non-respect des conditions, la plateforme peut suspendre ou supprimer un
                compte sans préavis.
              </>
            }
          />

          <Section
            title="Limitation"
            index={9}
            description={
              <>
                La plateforme est fournie « en l’état ». Des interruptions peuvent survenir en
                raison de facteurs extérieurs.
              </>
            }
          />
        </div>

        {/* Section Contact professionnelle */}
        <section className="mt-14">
          <div className="bg-white shadow-sm border border-gray-200 rounded-2xl p-8">
            <h2 className="text-xl font-semibold text-gray-900 text-center mb-2">
              Contact
            </h2>
            <p className="text-sm text-gray-600 text-center mb-8">
              Pour toute question ou information complémentaire, contactez-nous :
            </p>

            <div className="grid grid-cols-1 sm:grid-cols-3 gap-8">
              {/* Email */}
              <div className="flex flex-col items-center">
                <div className="w-12 h-12 rounded-full bg-emerald-100 flex items-center justify-center mb-3">
                  <svg className="w-6 h-6 text-emerald-600" fill="none" stroke="currentColor" strokeWidth="2" viewBox="0 0 24 24">
                    <path strokeLinecap="round" strokeLinejoin="round" d="M4 4h16v16H4z" />
                    <path strokeLinecap="round" strokeLinejoin="round" d="M22 6l-10 7L2 6" />
                  </svg>
                </div>
                <p className="text-gray-700 font-semibold">Email</p>
                <p className="text-emerald-700 text-sm mt-1">alumni@univ-zig.sn</p>
              </div>

              {/* Téléphone */}
              <div className="flex flex-col items-center">
                <div className="w-12 h-12 rounded-full bg-emerald-100 flex items-center justify-center mb-3">
                  <svg className="w-6 h-6 text-emerald-600" fill="none" stroke="currentColor" strokeWidth="2" viewBox="0 0 24 24">
                    <path strokeLinecap="round" strokeLinejoin="round" d="M22 16.92V21a2 2 0 0 1-2.18 2A19.79 19.79 0 0 1 3 5.18 2 2 0 0 1 5 3h4.09a1 1 0 0 1 1 .75 12.84 12.84 0 0 0 .7 2.19 1 1 0 0 1-.25 1L8.44 9.44a16 16 0 0 0 6.12 6.12l2.5-1.1a1 1 0 0 1 1 .25 12.84 12.84 0 0 0 2.19.7 1 1 0 0 1 .75 1Z" />
                  </svg>
                </div>
                <p className="text-gray-700 font-semibold">Téléphone</p>
                <p className="text-emerald-700 text-sm mt-1">+221 33 994 11 89</p>
              </div>

              {/* Adresse */}
              <div className="flex flex-col items-center">
                <div className="w-12 h-12 rounded-full bg-emerald-100 flex items-center justify-center mb-3">
                  <svg className="w-6 h-6 text-emerald-600" fill="none" stroke="currentColor" strokeWidth="2" viewBox="0 0 24 24">
                    <path strokeLinecap="round" strokeLinejoin="round" d="M12 3a7 7 0 0 0-7 7c0 5.25 7 11 7 11s7-5.75 7-11a7 7 0 0 0-7-7Z" />
                    <circle cx="12" cy="10" r="3" />
                  </svg>
                </div>
                <p className="text-gray-700 font-semibold">Adresse</p>
                <p className="text-emerald-700 text-sm mt-1 text-center">
                  Université Assane Seck<br />Ziguinchor
                </p>
              </div>
            </div>
          </div>
        </section>

        {/* Footer */}
        <footer className="mt-10 py-6 border-t border-gray-200 text-center text-xs text-gray-500">
          &copy; {new Date().getFullYear()} Université Assane Seck de Ziguinchor. Tous droits réservés.
        </footer>
      </main>
    </div>
  );
};

// Section component
function Section({ title, description, note, index }) {
  return (
    <section className="bg-white border border-gray-200 rounded-lg p-6">
      <div className="flex items-center gap-3 mb-2">
        <span className="inline-flex items-center justify-center w-7 h-7 rounded bg-emerald-500 text-white text-sm font-bold">
          {index}
        </span>
        <span className="text-lg font-semibold text-gray-900">{title}</span>
      </div>

      <div className="text-gray-700 text-sm leading-relaxed">{description}</div>

      {note && (
        <div className="mt-3 px-4 py-2 bg-gray-50 border-l-4 border-emerald-300 text-xs text-emerald-800 rounded">
          {note}
        </div>
      )}
    </section>
  );
}

// Validation des props pour le composant Section
Section.propTypes = {
  title: PropTypes.string.isRequired,
  description: PropTypes.oneOfType([
    PropTypes.string,
    PropTypes.element,
    PropTypes.arrayOf(PropTypes.element)
  ]).isRequired,
  index: PropTypes.number.isRequired,
  note: PropTypes.string,
};

export default ConditionsUtilisation;