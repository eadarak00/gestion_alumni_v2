import { useAuth } from '../../hooks/useAuth';

export const EtudiantDashboard = () => {
  const { user, isAlumni, isEtudiant } = useAuth();

  return (
    <div className="space-y-6">
      <div className="flex items-center justify-between">
        <div>
          <h1 className="text-3xl font-bold text-gray-900">
            Bienvenue, {user?.prenom} {user?.nom}
          </h1>
          <p className="text-gray-600 mt-1">
            {isAlumni && 'Espace Alumni'}
            {isEtudiant && 'Espace Étudiant'}
          </p>
        </div>
      </div>

      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        <div className="bg-white rounded-lg shadow p-6">
          <h3 className="text-lg font-semibold text-gray-900 mb-2">Mon Profil</h3>
          <p className="text-gray-600 text-sm">Complétez votre profil pour être visible par la communauté</p>
          <div className="mt-4">
            <div className="flex items-center justify-between text-sm">
              <span className="text-gray-500">Progression</span>
              <span className="font-medium text-green-600">60%</span>
            </div>
            <div className="mt-2 h-2 bg-gray-200 rounded-full overflow-hidden">
              <div className="h-full bg-green-600" style={{ width: '60%' }} />
            </div>
          </div>
        </div>

        <div className="bg-white rounded-lg shadow p-6">
          <h3 className="text-lg font-semibold text-gray-900 mb-2">Réseau</h3>
          <p className="text-gray-600 text-sm">
            {isAlumni && 'Connectez-vous avec d\'autres alumni'}
            {isEtudiant && 'Découvrez des alumni pour vous guider'}
          </p>
          <div className="mt-4 text-3xl font-bold text-blue-600">0</div>
          <p className="text-sm text-gray-500">connexions</p>
        </div>

        <div className="bg-white rounded-lg shadow p-6">
          <h3 className="text-lg font-semibold text-gray-900 mb-2">Activité</h3>
          <p className="text-gray-600 text-sm">Restez actif dans la communauté</p>
          <div className="mt-4 text-3xl font-bold text-orange-600">0</div>
          <p className="text-sm text-gray-500">interactions cette semaine</p>
        </div>
      </div>

      <div className="bg-white rounded-lg shadow p-6">
        <h2 className="text-xl font-bold text-gray-900 mb-4">Prochaines étapes</h2>
        <div className="space-y-3">
          <div className="flex items-center space-x-3 p-3 bg-gray-50 rounded-lg">
            <div className="w-8 h-8 rounded-full bg-green-100 flex items-center justify-center">
              <span className="text-green-600 font-bold">1</span>
            </div>
            <p className="text-gray-700">Complétez votre profil</p>
          </div>
          <div className="flex items-center space-x-3 p-3 bg-gray-50 rounded-lg">
            <div className="w-8 h-8 rounded-full bg-green-100 flex items-center justify-center">
              <span className="text-green-600 font-bold">2</span>
            </div>
            <p className="text-gray-700">
              {isAlumni && 'Créez votre CV professionnel'}
              {isEtudiant && 'Connectez-vous avec des alumni'}
            </p>
          </div>
          <div className="flex items-center space-x-3 p-3 bg-gray-50 rounded-lg">
            <div className="w-8 h-8 rounded-full bg-green-100 flex items-center justify-center">
              <span className="text-green-600 font-bold">3</span>
            </div>
            <p className="text-gray-700">Rejoignez des groupes d'intérêt</p>
          </div>
        </div>
      </div>
    </div>
  );
};
