export const NewsCard = () => {
  // TODO: Récupérer les actualités depuis le backend
  
  return (
    <div className="bg-white rounded-lg shadow p-4 mb-4">
      <h3 className="font-semibold text-gray-900 mb-4">Actualités UASZ</h3>
      
      <div className="space-y-3">
        <div className="text-center text-gray-500 text-sm py-4">
          Aucune actualité pour le moment
        </div>
      </div>
    </div>
  );
};