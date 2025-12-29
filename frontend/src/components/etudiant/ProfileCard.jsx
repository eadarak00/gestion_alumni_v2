import { User } from 'lucide-react';

export const ProfileCard = () => {
  // TODO: Récupérer les données de l'utilisateur depuis le backend
  // const { user } = useAuth();
  
  return (
    <div className="bg-white rounded-lg shadow overflow-hidden mb-4">
      <div className="h-16 bg-gradient-to-r from-blue-600 to-green-600" />
      <div className="px-4 pb-4 -mt-8">
        <div className="w-16 h-16 bg-gradient-to-br from-blue-500 to-purple-500 rounded-full border-4 border-white flex items-center justify-center">
          <User className="h-8 w-8 text-white" />
        </div>
        <h3 className="font-semibold text-gray-900 mt-2">Chargement...</h3>
        <p className="text-sm text-gray-600">Étudiant(e) UASZ</p>
        
        <div className="mt-4 pt-4 border-t border-gray-200">
          <div className="flex justify-between text-sm mb-2">
            <span className="text-gray-600">Visiteurs du profil</span>
            <span className="text-blue-600 font-semibold">--</span>
          </div>
          <div className="flex justify-between text-sm">
            <span className="text-gray-600">Connections</span>
            <span className="text-blue-600 font-semibold">--</span>
          </div>
        </div>

        <button className="w-full mt-4 py-2 text-sm font-medium text-blue-600 hover:bg-blue-50 rounded-lg transition-colors">
          Voir mon profil
        </button>
      </div>
    </div>
  );
};