export const SuggestionsCard = () => {
  // TODO: Récupérer les suggestions depuis le backend
  
  return (
    <div className="bg-white rounded-lg shadow p-4">
      <div className="flex items-center justify-between mb-4">
        <h3 className="font-semibold text-gray-900">Alumni à découvrir</h3>
      </div>
      
      <div className="text-center text-gray-500 text-sm py-4">
        Aucune suggestion pour le moment
      </div>
      
      <button className="w-full text-center text-gray-600 font-semibold text-sm mt-4 hover:bg-gray-100 py-2 rounded-lg transition-colors">
        Voir tous les alumni →
      </button>
    </div>
  );
};
