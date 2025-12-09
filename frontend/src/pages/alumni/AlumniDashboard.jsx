import { useAuth } from '../../hooks/useAuth';

export const AlumniDashboard = () => {
  const { user, isAlumni } = useAuth();

  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold text-gray-900">
            Bienvenue, {user?.prenom} {user?.nom}
          </h1>
          <p className="text-xl text-blue-600 mt-1">Espace Alumni</p>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        <div className="bg-white rounded-lg shadow p-6">
          <h3 className="text-lg font-semibold text-gray-900 mb-2">Mon Profil</h3>
          <p className="text-gray-600 text-sm mb-4">Complétez votre profil professionnel</p>
          <div className="flex items-center justify-between text-sm">
            <span className="text-gray-500">Progression</span>
            <span className="font-medium text-blue-600">75%</span>
          </div>
          <div className="mt-2 h-2 bg-gray-200 rounded-full overflow-hidden">
            <div className="h-full bg-blue-600" style={{ width: '75%' }} />
          </div>
        </div>

        <div className="bg-white rounded-lg shadow p-6">
          <h3 className="text-lg font-semibold text-gray-900 mb-2">Réseau</h3>
          <p className="text-gray-600 text-sm">Connectez-vous avec d'autres alumni</p>
          <div className="mt-4 text-3xl font-bold text-blue-600">12</div>
          <p className="text-sm text-gray-500">connexions</p>
        </div>

        <div className="bg-white rounded-lg shadow p-6">
          <h3 className="text-lg font-semibold text-gray-900 mb-2">CVs Vus</h3>
          <p className="text-gray-600 text-sm">Étudiants qui ont vu votre profil</p>
          <div className="mt-4 text-3xl font-bold text-orange-600">8</div>
          <p className="text-sm text-gray-500">cette semaine</p>
        </div>
      </div>

      <div className="bg-white rounded-lg shadow p-6">
        <h2 className="text-xl font-bold text-gray-900 mb-4">Prochaines étapes</h2>
        <div className="space-y-3">
          <div className="flex items-center space-x-3 p-3 bg-blue-50 rounded-lg">
            <div className="w-8 h-8 rounded-full bg-blue-100 flex items-center justify-center">
              <span className="text-blue-600 font-bold">1</span>
            </div>
            <p className="text-gray-700">Finalisez votre CV professionnel</p>
          </div>
          <div className="flex items-center space-x-3 p-3 bg-blue-50 rounded-lg">
            <div className="w-8 h-8 rounded-full bg-blue-100 flex items-center justify-center">
              <span className="text-blue-600 font-bold">2</span>
            </div>
            <p className="text-gray-700">Connectez-vous avec des étudiants</p>
          </div>
        </div>
      </div>
    </div>
  );
};
