import { MessageCircle } from 'lucide-react';

export const PostsFeed = () => {
  // TODO: Récupérer les posts depuis le backend
  // const { posts, loading } = usePosts();
  
  return (
    <div className="space-y-4">
      <div className="bg-white rounded-lg shadow p-8 text-center">
        <div className="w-16 h-16 bg-gray-100 rounded-full flex items-center justify-center mx-auto mb-4">
          <MessageCircle className="h-8 w-8 text-gray-400" />
        </div>
        <h3 className="text-lg font-semibold text-gray-900 mb-2">Aucune publication pour le moment</h3>
        <p className="text-gray-600">Les publications des alumni apparaîtront ici</p>
      </div>
    </div>
  );
};