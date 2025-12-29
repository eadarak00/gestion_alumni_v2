import { BookOpen, Calendar, Users } from 'lucide-react';

export const QuickLinksCard = () => {
  return (
    <div className="bg-white rounded-lg shadow p-4 sticky top-20">
      <div className="space-y-2">
        <button className="flex items-center space-x-3 w-full text-left px-3 py-2 hover:bg-gray-100 rounded-lg transition-colors">
          <BookOpen className="h-5 w-5 text-gray-600" />
          <span className="text-sm font-medium text-gray-700">Mes Études</span>
        </button>
        <button className="flex items-center space-x-3 w-full text-left px-3 py-2 hover:bg-gray-100 rounded-lg transition-colors">
          <Calendar className="h-5 w-5 text-gray-600" />
          <span className="text-sm font-medium text-gray-700">Événements</span>
        </button>
        <button className="flex items-center space-x-3 w-full text-left px-3 py-2 hover:bg-gray-100 rounded-lg transition-colors">
          <Users className="h-5 w-5 text-gray-600" />
          <span className="text-sm font-medium text-gray-700">Groupes</span>
        </button>
      </div>
    </div>
  );
};
