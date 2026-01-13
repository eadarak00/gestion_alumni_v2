import { useState } from 'react';
import { Link, useLocation } from 'react-router-dom';
import {
  LayoutDashboard,
  User,
  BookOpen,
  Users,
  MessageCircle,
  Calendar,
  Settings,
  ChevronLeft,
  ChevronRight,
  FileText

} from 'lucide-react';
import { Header } from './Header';

const menuItems = [
  { icon: LayoutDashboard, label: 'Dashboard', path: '/etudiant/dashboard' },
  { icon: User, label: 'Mon Profil', path: '/etudiant/profile' },
  { icon: BookOpen, label: 'Mes Études', path: '/etudiant/studies' },
  { icon: FileText, label: 'Mon CV', path: '/etudiant/cv-generator' },
  { icon: Users, label: 'Alumni à Découvrir', path: '/etudiant/discover-alumni' },
  { icon: MessageCircle, label: 'Mentorat', path: '/etudiant/mentorship' },
  { icon: Calendar, label: 'Événements', path: '/etudiant/events' },
  { icon: Settings, label: 'Paramètres', path: '/etudiant/settings' }
];

export const EtudiantLayout = ({ children }) => {
  const [collapsed, setCollapsed] = useState(false);
  const location = useLocation();

  return (
    <div className="min-h-screen flex bg-gray-50">
      <aside
        className={`${collapsed ? 'w-20' : 'w-64'
          } bg-gradient-to-b from-blue-900 to-green-800 text-white flex flex-col transition-all duration-300 fixed h-full z-40`}
      >
        <div className="p-6 flex items-center justify-between border-b border-blue-700">
          {!collapsed && (
            <div>
              <h1 className="text-xl font-bold">UASZ Alumni</h1>
              <p className="text-xs text-blue-200 italic">Espace Étudiant</p>
            </div>
          )}
          <button
            onClick={() => setCollapsed(!collapsed)}
            className="p-2 hover:bg-blue-700 rounded-lg transition-colors"
          >
            {collapsed ? <ChevronRight className="h-5 w-5" /> : <ChevronLeft className="h-5 w-5" />}
          </button>
        </div>

        <nav className="flex-1 px-3 py-6 space-y-1">
          {menuItems.map((item) => {
            const Icon = item.icon;
            const isActive = location.pathname === item.path;

            return (
              <Link
                key={item.path}
                to={item.path}
                className={`flex items-center space-x-3 px-4 py-3 rounded-lg transition-colors ${isActive
                    ? 'bg-green-500 text-white'
                    : 'text-blue-100 hover:bg-blue-700'
                  }`}
                title={collapsed ? item.label : ''}
              >
                <Icon className={`h-5 w-5 flex-shrink-0 ${isActive ? 'text-white' : ''}`} />
                {!collapsed && <span className="font-medium">{item.label}</span>}
              </Link>
            );
          })}
        </nav>
      </aside>

      <div className={`flex-1 flex flex-col ${collapsed ? 'ml-20' : 'ml-64'} transition-all duration-300`}>
        <Header />

        <main className="flex-1 p-6">
          {children}
        </main>

        <footer className="bg-white border-t border-gray-200 px-6 py-4">
          <p className="text-center text-sm text-gray-600">
            © 2024 UASZ Alumni Platform - Tous droits réservés
          </p>
        </footer>
      </div>
    </div>
  );
};






