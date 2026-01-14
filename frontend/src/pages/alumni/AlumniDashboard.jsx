import { useAuth } from "../../hooks/useAuth";

export const AlumniDashboard = () => {
  const { user } = useAuth();

  return (
    <div className="space-y-6">
      {/* 👋 HEADER */}
      <div>
        <h1 className="text-3xl font-bold text-gray-900">
          Bienvenue, {user?.prenom} {user?.nom}
        </h1>
        <p className="text-gray-600 mt-1">Espace Alumni</p>
      </div>

      {/* 📊 CARTES */}
      <div className="grid grid-cols-1 md:grid-cols-3 gap-6">
        {/* PROFIL */}
        <div className="bg-white rounded-lg shadow p-6">
          <h3 className="text-lg font-semibold text-gray-900 mb-2">
            Mon Profil
          </h3>
          <p className="text-gray-600 text-sm">
            État d'avancement de votre profil
          </p>

          <div className="mt-4">
            <div className="flex justify-between text-sm">
              <span className="text-gray-500">Progression</span>
              <span className="font-medium text-green-600">100%</span>
            </div>
            <div className="mt-2 h-2 bg-gray-200 rounded-full overflow-hidden">
              <div
                className="h-full bg-green-600 transition-all"
                style={{ width: "100%" }}
              />
            </div>
          </div>
        </div>

        {/* RÉSEAU */}
        <div className="bg-white rounded-lg shadow p-6">
          <h3 className="text-lg font-semibold text-gray-900 mb-2">
            Réseau Alumni
          </h3>
          <p className="text-gray-600 text-sm">
            Vos connexions professionnelles
          </p>
          <div className="mt-4 text-3xl font-bold text-blue-600">0</div>
          <p className="text-sm text-gray-500">connexions</p>
        </div>

        {/* ACTIVITÉ */}
        <div className="bg-white rounded-lg shadow p-6">
          <h3 className="text-lg font-semibold text-gray-900 mb-2">
            Activité
          </h3>
          <p className="text-gray-600 text-sm">
            Interactions récentes
          </p>
          <div className="mt-4 text-3xl font-bold text-orange-600">0</div>
          <p className="text-sm text-gray-500">actions cette semaine</p>
        </div>
      </div>
    </div>
  );
};
