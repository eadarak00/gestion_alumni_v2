import { User } from 'lucide-react';

export const CreatePostCard = () => {
  return (
    <div className="bg-white rounded-lg shadow p-4 mb-4">
      <div className="flex items-center space-x-3">
        <div className="w-12 h-12 bg-gradient-to-br from-blue-500 to-purple-500 rounded-full flex items-center justify-center flex-shrink-0">
          <User className="h-6 w-6 text-white" />
        </div>
        <button className="flex-1 px-4 py-3 bg-gray-100 hover:bg-gray-200 rounded-full border-0 text-left text-gray-500 transition-colors">
          Commencer un post
        </button>
      </div>
    </div>
  );
};