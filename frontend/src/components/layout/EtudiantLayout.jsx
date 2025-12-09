// import { useState } from 'react';
// import { Link, useLocation } from 'react-router-dom';
// import {
//   LayoutDashboard,
//   User,
//   BookOpen,
//   Users,
//   MessageCircle,
//   Calendar,
//   Settings,
//   ChevronLeft,
//   ChevronRight
// } from 'lucide-react';
// import { Header } from './Header';

// const menuItems = [
//   { icon: LayoutDashboard, label: 'Dashboard', path: '/dashboard' },
//   { icon: User, label: 'Mon Profil', path: '/profile' },
//   { icon: BookOpen, label: 'Mes Études', path: '/studies' },
//   { icon: Users, label: 'Alumni à Découvrir', path: '/discover-alumni' },
//   { icon: MessageCircle, label: 'Mentorat', path: '/mentorship' },
//   { icon: Calendar, label: 'Événements', path: '/events' },
//   { icon: Settings, label: 'Paramètres', path: '/settings' }
// ];

// export const EtudiantLayout = ({ children }) => {
//   const [collapsed, setCollapsed] = useState(false);
//   const location = useLocation();

//   return (
//     <div className="min-h-screen flex bg-gray-50">
//       <aside
//         className={`${
//           collapsed ? 'w-20' : 'w-64'
//         } bg-gradient-to-b from-blue-900 to-green-800 text-white flex flex-col transition-all duration-300 fixed h-full z-40`}
//       >
//         <div className="p-6 flex items-center justify-between border-b border-blue-700">
//           {!collapsed && (
//             <div>
//               <h1 className="text-xl font-bold">UASZ Alumni</h1>
//               <p className="text-xs text-blue-200 italic">Espace Étudiant</p>
//             </div>
//           )}
//           <button
//             onClick={() => setCollapsed(!collapsed)}
//             className="p-2 hover:bg-blue-700 rounded-lg transition-colors"
//           >
//             {collapsed ? <ChevronRight className="h-5 w-5" /> : <ChevronLeft className="h-5 w-5" />}
//           </button>
//         </div>

//         <nav className="flex-1 px-3 py-6 space-y-1">
//           {menuItems.map((item) => {
//             const Icon = item.icon;
//             const isActive = location.pathname === item.path;

//             return (
//               <Link
//                 key={item.path}
//                 to={item.path}
//                 className={`flex items-center space-x-3 px-4 py-3 rounded-lg transition-colors ${
//                   isActive
//                     ? 'bg-green-500 text-white'
//                     : 'text-blue-100 hover:bg-blue-700'
//                 }`}
//                 title={collapsed ? item.label : ''}
//               >
//                 <Icon className={`h-5 w-5 flex-shrink-0 ${isActive ? 'text-white' : ''}`} />
//                 {!collapsed && <span className="font-medium">{item.label}</span>}
//               </Link>
//             );
//           })}
//         </nav>
//       </aside>

//       <div className={`flex-1 flex flex-col ${collapsed ? 'ml-20' : 'ml-64'} transition-all duration-300`}>
//         <Header />

//         <main className="flex-1 p-6">
//           {children}
//         </main>

//         <footer className="bg-white border-t border-gray-200 px-6 py-4">
//           <p className="text-center text-sm text-gray-600">
//             © 2024 UASZ Alumni Platform - Tous droits réservés
//           </p>
//         </footer>
//       </div>
//     </div>
//   );
// };






// import { useState, useEffect } from 'react';
// import { Link, useLocation, useNavigate } from 'react-router-dom';
// import {
//   LayoutDashboard,
//   User,
//   BookOpen,
//   Users,
//   MessageCircle,
//   Calendar,
//   Settings,
//   ChevronLeft,
//   ChevronRight,
//   Bell,
//   Search,
//   Mail,
//   LogOut,
//   Home,
//   Briefcase,
//   Network,
//   GraduationCap,
//   Building,
//   Trophy,
//   Zap,
//   Sparkles
// } from 'lucide-react';
// import { useAuth } from '../../hooks/useAuth';

// const menuItems = [
//   { icon: Home, label: 'Accueil', path: '/dashboard' },
//   { icon: User, label: 'Mon Profil', path: '/profile' },
//   { icon: BookOpen, label: 'Mes Études', path: '/studies' },
//   { icon: Network, label: 'Mon Réseau', path: '/network' },
//   { icon: Users, label: 'Alumni', path: '/alumni' },
//   { icon: Briefcase, label: 'Opportunités', path: '/opportunities' },
//   { icon: MessageCircle, label: 'Mentorat', path: '/mentorship' },
//   { icon: GraduationCap, label: 'Formations', path: '/formations' },
//   { icon: Calendar, label: 'Événements', path: '/events' },
//   { icon: Trophy, label: 'Badges', path: '/badges' },
// ];

// export const EtudiantLayout = ({ children }) => {
//   const [collapsed, setCollapsed] = useState(false);
//   const [searchQuery, setSearchQuery] = useState('');
//   const [notifications] = useState([
//     { id: 1, message: 'Marie a accepté votre demande', time: '2h', read: false },
//     { id: 2, message: 'Nouvel événement ajouté', time: '5h', read: true },
//     { id: 3, message: 'Stage disponible chez Google', time: 'Hier', read: false },
//   ]);
//   const [unreadNotifications] = useState(2);
  
//   const location = useLocation();
//   const navigate = useNavigate();
//   const { user, logout } = useAuth();

//   const handleSearch = (e) => {
//     e.preventDefault();
//     if (searchQuery.trim()) {
//       navigate(`/search?q=${encodeURIComponent(searchQuery)}`);
//     }
//   };

//   const handleLogout = () => {
//     logout();
//     navigate('/login');
//   };

//   return (
//     <div className="min-h-screen bg-gradient-to-br from-gray-50 to-blue-50">
//       {/* Top Navigation Bar */}
//       <nav className="bg-white/80 backdrop-blur-lg border-b border-gray-200/50 fixed top-0 left-0 right-0 z-50">
//         <div className="px-4 sm:px-6 lg:px-8">
//           <div className="flex items-center justify-between h-16">
            
//             {/* Left: Logo & Search */}
//             <div className="flex items-center space-x-6">
//               {/* Logo */}
//               <Link to="/dashboard" className="flex items-center space-x-3">
//                 <div className="w-10 h-10 bg-gradient-to-br from-blue-600 to-emerald-500 rounded-xl flex items-center justify-center shadow-lg shadow-blue-500/30">
//                   <Sparkles className="h-6 w-6 text-white" />
//                 </div>
//                 {!collapsed && (
//                   <div>
//                     <h1 className="text-lg font-bold bg-gradient-to-r from-blue-600 to-emerald-500 bg-clip-text text-transparent">
//                       UASZ Alumni
//                     </h1>
//                     <p className="text-xs text-gray-500">Espace Étudiant</p>
//                   </div>
//                 )}
//               </Link>

//               {/* Search Bar */}
//               <form onSubmit={handleSearch} className="hidden md:block">
//                 <div className="relative">
//                   <Search className="absolute left-4 top-1/2 transform -translate-y-1/2 text-gray-400 h-4 w-4" />
//                   <input
//                     type="text"
//                     placeholder="Rechercher alumni, opportunités, événements..."
//                     className="pl-12 pr-4 py-2.5 w-80 bg-gray-100/80 border border-gray-300/50 rounded-xl focus:outline-none focus:ring-2 focus:ring-blue-500/30 focus:border-blue-500/50 transition-all"
//                     value={searchQuery}
//                     onChange={(e) => setSearchQuery(e.target.value)}
//                   />
//                 </div>
//               </form>
//             </div>

//             {/* Right: User Actions */}
//             <div className="flex items-center space-x-4">
//               {/* Quick Actions */}
//               <button className="hidden lg:flex items-center space-x-2 px-4 py-2 bg-gradient-to-r from-blue-500 to-emerald-500 text-white rounded-xl hover:shadow-lg hover:shadow-blue-500/30 transition-all">
//                 <Zap className="h-4 w-4" />
//                 <span className="text-sm font-medium">Trouver un mentor</span>
//               </button>

//               {/* Icons */}
//               <button className="p-2 text-gray-600 hover:text-blue-600 hover:bg-blue-50/80 rounded-xl transition-colors relative">
//                 <Mail className="h-5 w-5" />
//                 <span className="absolute -top-1 -right-1 bg-blue-500 text-white text-xs rounded-full w-5 h-5 flex items-center justify-center">
//                   3
//                 </span>
//               </button>

//               <button className="p-2 text-gray-600 hover:text-blue-600 hover:bg-blue-50/80 rounded-xl transition-colors relative">
//                 <Bell className="h-5 w-5" />
//                 {unreadNotifications > 0 && (
//                   <span className="absolute -top-1 -right-1 bg-red-500 text-white text-xs rounded-full w-5 h-5 flex items-center justify-center">
//                     {unreadNotifications}
//                   </span>
//                 )}
//               </button>

//               {/* User Profile */}
//               <div className="flex items-center space-x-3">
//                 <div className="text-right hidden md:block">
//                   <p className="text-sm font-medium text-gray-900">
//                     {user?.prenom} {user?.nom}
//                   </p>
//                   <p className="text-xs text-gray-500">Étudiant en Informatique</p>
//                 </div>
//                 <div className="relative">
//                   <div className="w-10 h-10 bg-gradient-to-br from-blue-500 to-emerald-400 rounded-full border-2 border-white shadow-lg cursor-pointer" />
//                   <div className="absolute bottom-0 right-0 w-3 h-3 bg-green-500 rounded-full border-2 border-white"></div>
//                 </div>
//               </div>
//             </div>
//           </div>
//         </div>
//       </nav>

//       {/* Main Content */}
//       <div className="pt-16">
//         <div className="flex">
//           {/* Sidebar */}
//           <aside
//             className={`${
//               collapsed ? 'w-20' : 'w-64'
//             } bg-white/80 backdrop-blur-lg border-r border-gray-200/50 flex flex-col transition-all duration-300 fixed h-full z-40`}
//           >
//             {/* Mobile Search */}
//             <div className="md:hidden p-4 border-b border-gray-200/50">
//               <div className="relative">
//                 <Search className="absolute left-4 top-1/2 transform -translate-y-1/2 text-gray-400 h-4 w-4" />
//                 <input
//                   type="text"
//                   placeholder="Rechercher..."
//                   className="w-full pl-12 pr-4 py-2.5 bg-gray-100/80 border border-gray-300/50 rounded-xl focus:outline-none focus:ring-2 focus:ring-blue-500/30 focus:border-blue-500/50"
//                   value={searchQuery}
//                   onChange={(e) => setSearchQuery(e.target.value)}
//                 />
//               </div>
//             </div>

//             {/* Navigation */}
//             <nav className="flex-1 px-4 py-6 space-y-1 overflow-y-auto">
//               {menuItems.map((item) => {
//                 const Icon = item.icon;
//                 const isActive = location.pathname === item.path;

//                 return (
//                   <Link
//                     key={item.path}
//                     to={item.path}
//                     className={`flex items-center space-x-3 px-4 py-3 rounded-xl transition-all group ${
//                       isActive
//                         ? 'bg-gradient-to-r from-blue-500 to-emerald-500 text-white shadow-lg shadow-blue-500/30'
//                         : 'text-gray-700 hover:bg-gradient-to-r hover:from-blue-50 hover:to-emerald-50 hover:text-blue-600 hover:shadow-sm'
//                     }`}
//                     title={collapsed ? item.label : ''}
//                   >
//                     <div className={`p-2 rounded-lg ${
//                       isActive 
//                         ? 'bg-white/20' 
//                         : 'bg-gray-100 group-hover:bg-white'
//                     }`}>
//                       <Icon className={`h-5 w-5 ${isActive ? 'text-white' : 'text-gray-600 group-hover:text-blue-600'}`} />
//                     </div>
//                     {!collapsed && (
//                       <>
//                         <span className="font-medium">{item.label}</span>
//                         {item.badge && (
//                           <span className="ml-auto px-2 py-1 text-xs bg-blue-100 text-blue-600 rounded-full">
//                             {item.badge}
//                           </span>
//                         )}
//                       </>
//                     )}
//                   </Link>
//                 );
//               })}
//             </nav>

//             {/* Bottom Actions */}
//             <div className="p-4 border-t border-gray-200/50">
//               <div className="space-y-2">
//                 <Link
//                   to="/settings"
//                   className={`flex items-center space-x-3 px-4 py-3 rounded-xl transition-all group ${
//                     location.pathname === '/settings'
//                       ? 'bg-gradient-to-r from-blue-500 to-emerald-500 text-white'
//                       : 'text-gray-700 hover:bg-gradient-to-r hover:from-blue-50 hover:to-emerald-50 hover:text-blue-600'
//                   }`}
//                 >
//                   <Settings className="h-5 w-5" />
//                   {!collapsed && <span className="font-medium">Paramètres</span>}
//                 </Link>
                
//                 <button
//                   onClick={handleLogout}
//                   className="flex items-center space-x-3 px-4 py-3 rounded-xl text-red-600 hover:bg-red-50 w-full transition-colors group"
//                 >
//                   <LogOut className="h-5 w-5" />
//                   {!collapsed && <span className="font-medium">Déconnexion</span>}
//                 </button>
//               </div>
              
//               {/* Collapse Button */}
//               <button
//                 onClick={() => setCollapsed(!collapsed)}
//                 className="mt-4 p-2 hover:bg-gray-100 rounded-lg transition-colors text-gray-600 w-full"
//               >
//                 {collapsed ? (
//                   <ChevronRight className="h-5 w-5 mx-auto" />
//                 ) : (
//                   <div className="flex items-center justify-between">
//                     <span className="text-sm text-gray-500">Réduire</span>
//                     <ChevronLeft className="h-5 w-5" />
//                   </div>
//                 )}
//               </button>
//             </div>
//           </aside>

//           {/* Main Content Area */}
//           <div className={`flex-1 transition-all duration-300 ${collapsed ? 'ml-20' : 'ml-64'}`}>
//             <main className="p-6">
//               {children}
//             </main>

//             {/* Footer */}
//             <footer className="px-6 py-8 border-t border-gray-200/50 bg-white/50">
//               <div className="max-w-7xl mx-auto">
//                 <div className="flex flex-col md:flex-row items-center justify-between">
//                   <div className="flex items-center space-x-3 mb-4 md:mb-0">
//                     <div className="w-10 h-10 bg-gradient-to-br from-blue-600 to-emerald-500 rounded-xl flex items-center justify-center">
//                       <Sparkles className="h-6 w-6 text-white" />
//                     </div>
//                     <div>
//                       <h3 className="font-bold text-gray-900">UASZ Alumni Platform</h3>
//                       <p className="text-sm text-gray-600">Connecter les talents de demain</p>
//                     </div>
//                   </div>
                  
//                   <div className="flex items-center space-x-6">
//                     <a href="/mentions-legales" className="text-sm text-gray-600 hover:text-blue-600 transition-colors">
//                       Mentions légales
//                     </a>
//                     <a href="/confidentialite" className="text-sm text-gray-600 hover:text-blue-600 transition-colors">
//                       Confidentialité
//                     </a>
//                     <a href="/contact" className="text-sm text-gray-600 hover:text-blue-600 transition-colors">
//                       Contact
//                     </a>
//                   </div>
//                 </div>
                
//                 <div className="mt-6 pt-6 border-t border-gray-200/50 text-center">
//                   <p className="text-sm text-gray-500">
//                     © {new Date().getFullYear()} UASZ Alumni Platform - Tous droits réservés
//                   </p>
//                 </div>
//               </div>
//             </footer>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };






import { useState } from 'react';
import { Link, useLocation, useNavigate } from 'react-router-dom';
import {
  Home,
  Users,
  Briefcase,
  MessageSquare,
  Bell,
  Search,
  Grid3x3,
  User,
  Plus,
  Globe,
  Menu,
  X,
  Building,
  GraduationCap,
  Calendar,
  BookOpen,
  Trophy,
  Sparkles,
  Target,
  ChevronDown,
  HelpCircle,
  Settings,
  LogOut
} from 'lucide-react';
import { useAuth } from '../../hooks/useAuth';

export const EtudiantLayout = ({ children }) => {
  const [searchQuery, setSearchQuery] = useState('');
  const [showMobileMenu, setShowMobileMenu] = useState(false);
  const [showProfileMenu, setShowProfileMenu] = useState(false);
  const [showNotifications, setShowNotifications] = useState(false);
  
  const location = useLocation();
  const navigate = useNavigate();
  const { user, logout } = useAuth();

  const navItems = [
    { icon: Home, label: 'Accueil', path: '/dashboard', active: true },
    { icon: Users, label: 'Mon réseau', path: '/network', count: 42 },
    { icon: Briefcase, label: 'Opportunités', path: '/opportunities' },
    { icon: MessageSquare, label: 'Messagerie', path: '/messages', count: 3 },
    { icon: Bell, label: 'Notifications', path: '/notifications', count: 2 },
  ];

  const mainMenuItems = [
    { label: 'Mon profil', path: '/profile', icon: User },
    { label: 'Mes études', path: '/studies', icon: BookOpen },
    { label: 'Mentorat', path: '/mentorship', icon: Users },
    { label: 'Événements', path: '/events', icon: Calendar },
    { label: 'Formations', path: '/formations', icon: GraduationCap },
    { label: 'Entreprises', path: '/companies', icon: Building },
    { label: 'Badges', path: '/badges', icon: Trophy },
  ];

  const handleSearch = (e) => {
    e.preventDefault();
    if (searchQuery.trim()) {
      navigate(`/search?q=${encodeURIComponent(searchQuery)}`);
    }
  };

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  return (
    <div className="min-h-screen bg-gray-50">
      {/* Top Navigation Bar - LinkedIn Style */}
      <header className="sticky top-0 z-50 bg-white border-b border-gray-200">
        <div className="max-w-7xl mx-auto px-4">
          <div className="flex items-center justify-between h-14">
            
            {/* Left: Logo & Search */}
            <div className="flex items-center space-x-4">
              {/* Logo */}
              <Link to="/dashboard" className="flex items-center space-x-2">
                <div className="w-9 h-9 bg-gradient-to-br from-blue-600 to-emerald-500 rounded-md flex items-center justify-center">
                  <span className="text-white font-bold text-lg">in</span>
                </div>
                <span className="hidden lg:block text-2xl font-bold text-blue-600">UASZ Alumni</span>
              </Link>

              {/* Search Bar */}
              <form onSubmit={handleSearch} className="relative hidden md:block">
                <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400 h-4 w-4" />
                <input
                  type="text"
                  placeholder="Rechercher alumni, opportunités..."
                  className="pl-10 pr-4 py-2 w-80 bg-gray-100 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                  value={searchQuery}
                  onChange={(e) => setSearchQuery(e.target.value)}
                />
              </form>
            </div>

            {/* Center: Navigation Icons */}
            <nav className="hidden md:flex items-center space-x-1">
              {navItems.map((item) => {
                const Icon = item.icon;
                const isActive = location.pathname === item.path;
                
                return (
                  <Link
                    key={item.path}
                    to={item.path}
                    className={`flex flex-col items-center px-4 py-2 text-xs font-medium rounded-md hover:bg-gray-100 transition-colors ${
                      isActive ? 'text-gray-900' : 'text-gray-500'
                    }`}
                  >
                    <div className="relative">
                      <Icon className="h-5 w-5" />
                      {item.count && (
                        <span className="absolute -top-2 -right-2 bg-red-500 text-white text-xs rounded-full w-5 h-5 flex items-center justify-center">
                          {item.count}
                        </span>
                      )}
                    </div>
                    <span className="mt-1">{item.label}</span>
                    {isActive && (
                      <div className="w-full h-0.5 bg-gray-900 rounded-full mt-1" />
                    )}
                  </Link>
                );
              })}
            </nav>

            {/* Right: User Actions */}
            <div className="flex items-center space-x-4">
              {/* Profile Menu */}
              <div className="relative">
                <button
                  onClick={() => setShowProfileMenu(!showProfileMenu)}
                  className="flex items-center space-x-2 p-2 hover:bg-gray-100 rounded-md"
                >
                  <div className="w-8 h-8 rounded-full border-2 border-blue-500 overflow-hidden">
                    <div className="w-full h-full bg-gradient-to-br from-blue-400 to-emerald-400" />
                  </div>
                  <ChevronDown className="h-4 w-4 text-gray-600 hidden lg:block" />
                </button>

                {/* Profile Dropdown */}
                {showProfileMenu && (
                  <div className="absolute right-0 mt-2 w-72 bg-white rounded-lg shadow-lg border border-gray-200 py-2 z-50">
                    <div className="px-4 py-3 border-b border-gray-100">
                      <div className="flex items-center space-x-3">
                        <div className="w-12 h-12 rounded-full bg-gradient-to-br from-blue-400 to-emerald-400" />
                        <div>
                          <p className="font-medium text-gray-900">
                            {user?.prenom} {user?.nom}
                          </p>
                          <p className="text-sm text-gray-500">Étudiant à UASZ</p>
                        </div>
                      </div>
                      <Link
                        to="/profile"
                        className="block mt-3 text-center text-blue-600 hover:text-blue-700 font-medium text-sm"
                      >
                        Voir mon profil
                      </Link>
                    </div>

                    <div className="py-2">
                      <Link
                        to="/profile/edit"
                        className="flex items-center space-x-3 px-4 py-2 text-gray-700 hover:bg-gray-100"
                      >
                        <Settings className="h-4 w-4" />
                        <span>Paramètres et confidentialité</span>
                      </Link>
                      <Link
                        to="/help"
                        className="flex items-center space-x-3 px-4 py-2 text-gray-700 hover:bg-gray-100"
                      >
                        <HelpCircle className="h-4 w-4" />
                        <span>Aide</span>
                      </Link>
                      <button
                        onClick={handleLogout}
                        className="flex items-center space-x-3 px-4 py-2 text-red-600 hover:bg-red-50 w-full"
                      >
                        <LogOut className="h-4 w-4" />
                        <span>Déconnexion</span>
                      </button>
                    </div>

                    <div className="px-4 py-2 border-t border-gray-100">
                      <button className="w-full py-2 bg-blue-600 text-white rounded-md hover:bg-blue-700 font-medium">
                        Essayer Premium gratuitement
                      </button>
                    </div>
                  </div>
                )}
              </div>

              {/* Premium Button */}
              <button className="hidden lg:flex items-center space-x-1 px-4 py-2 bg-gradient-to-r from-yellow-100 to-yellow-50 text-yellow-700 border border-yellow-200 rounded-full hover:bg-yellow-100">
                <Sparkles className="h-4 w-4" />
                <span className="text-sm font-medium">Essayer Premium</span>
              </button>

              {/* Create Post Button */}
              <button className="hidden lg:flex items-center space-x-2 px-4 py-2 bg-blue-600 text-white rounded-full hover:bg-blue-700">
                <Plus className="h-4 w-4" />
                <span className="text-sm font-medium">Publier</span>
              </button>

              {/* Mobile Menu Button */}
              <button
                className="md:hidden p-2"
                onClick={() => setShowMobileMenu(!showMobileMenu)}
              >
                {showMobileMenu ? (
                  <X className="h-6 w-6 text-gray-600" />
                ) : (
                  <Menu className="h-6 w-6 text-gray-600" />
                )}
              </button>
            </div>
          </div>
        </div>

        {/* Mobile Navigation Menu */}
        {showMobileMenu && (
          <div className="md:hidden bg-white border-t border-gray-200">
            <div className="px-4 py-3">
              {/* Mobile Search */}
              <form onSubmit={handleSearch} className="mb-4">
                <div className="relative">
                  <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400 h-4 w-4" />
                  <input
                    type="text"
                    placeholder="Rechercher..."
                    className="w-full pl-10 pr-4 py-2.5 bg-gray-100 border border-gray-300 rounded-md"
                    value={searchQuery}
                    onChange={(e) => setSearchQuery(e.target.value)}
                  />
                </div>
              </form>

              {/* Mobile Nav Items */}
              <div className="space-y-2">
                {navItems.map((item) => {
                  const Icon = item.icon;
                  return (
                    <Link
                      key={item.path}
                      to={item.path}
                      className="flex items-center space-x-3 px-3 py-3 text-gray-700 hover:bg-gray-100 rounded-md"
                      onClick={() => setShowMobileMenu(false)}
                    >
                      <Icon className="h-5 w-5" />
                      <span className="font-medium">{item.label}</span>
                      {item.count && (
                        <span className="ml-auto bg-red-500 text-white text-xs rounded-full w-6 h-6 flex items-center justify-center">
                          {item.count}
                        </span>
                      )}
                    </Link>
                  );
                })}
              </div>
            </div>
          </div>
        )}
      </header>

      {/* Main Content Area */}
      <div className="max-w-7xl mx-auto px-4 py-6">
        <div className="flex flex-col lg:flex-row gap-6">
          {/* Left Sidebar - LinkedIn Profile Card */}
          <div className="lg:w-1/4">
            <div className="sticky top-20 space-y-6">
              {/* Profile Card */}
              <div className="bg-white rounded-lg shadow-sm border border-gray-200 overflow-hidden">
                {/* Cover Image */}
                <div className="h-24 bg-gradient-to-r from-blue-500 to-emerald-400" />
                
                {/* Profile Info */}
                <div className="px-6 pb-6 -mt-12">
                  <div className="flex flex-col items-center">
                    <div className="w-20 h-20 rounded-full border-4 border-white bg-gradient-to-br from-blue-400 to-emerald-300" />
                    <h2 className="mt-4 text-xl font-bold text-gray-900">
                      {user?.prenom} {user?.nom}
                    </h2>
                    <p className="text-gray-600">Étudiant en Informatique</p>
                    <p className="text-sm text-gray-500">Université Assane Secé de Ziguinchor</p>
                    
                    {/* Profile Stats */}
                    <div className="w-full mt-6">
                      <div className="flex items-center justify-between text-sm text-gray-500">
                        <span>Qui a consulté votre profil</span>
                        <span className="font-medium text-blue-600">12</span>
                      </div>
                      <div className="flex items-center justify-between text-sm text-gray-500 mt-2">
                        <span>Impression de votre profil</span>
                        <span className="font-medium text-blue-600">42</span>
                      </div>
                    </div>
                  </div>
                </div>

                {/* Premium Banner */}
                <div className="px-6 py-4 bg-gradient-to-r from-yellow-50 to-yellow-100 border-t border-yellow-200">
                  <p className="text-sm text-gray-700 mb-2">
                    Développez votre réseau
                  </p>
                  <button className="w-full py-2 bg-gradient-to-r from-yellow-400 to-yellow-500 text-white rounded-md font-medium hover:from-yellow-500 hover:to-yellow-600">
                    Essayer Premium pour 0 CFA
                  </button>
                </div>
              </div>

              {/* Saved Items */}
              <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-5">
                <h3 className="text-sm font-semibold text-gray-700 mb-3">Éléments enregistrés</h3>
                <div className="space-y-2">
                  {['Groupes', 'Newsletters', 'Événements'].map((item) => (
                    <button
                      key={item}
                      className="w-full text-left text-sm text-gray-600 hover:text-blue-600 hover:bg-blue-50 px-2 py-1.5 rounded"
                    >
                      {item}
                    </button>
                  ))}
                </div>
              </div>

              {/* Learning Section */}
              <div className="bg-white rounded-lg shadow-sm border border-gray-200 overflow-hidden">
                <div className="p-5">
                  <h3 className="text-sm font-semibold text-gray-700 mb-2">Formation recommandée</h3>
                  <p className="text-xs text-gray-600 mb-3">
                    Excel : Le VBA avancé
                  </p>
                  <div className="flex items-center text-xs text-gray-500 mb-4">
                    <span>LINKEDIN LEARNING</span>
                  </div>
                  <button className="w-full py-2 border border-blue-600 text-blue-600 rounded-md hover:bg-blue-50 font-medium text-sm">
                    Regarder le cours gratuitement
                  </button>
                </div>
              </div>

              {/* Sponsor */}
              <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-5">
                <div className="flex items-center justify-between text-xs text-gray-500 mb-2">
                  <span>Peut sponsorisé</span>
                  <span>•</span>
                </div>
                <h4 className="font-medium text-gray-900 mb-2">Accron Aviation</h4>
                <p className="text-xs text-gray-600 mb-3">
                  Leading airlines trust Accron Aviation to train the next generation of pilots.
                </p>
                <button className="text-xs text-gray-500 hover:text-blue-600">
                  plus
                </button>
              </div>
            </div>
          </div>

          {/* Main Feed - 2/3 width */}
          <div className="lg:w-2/4">
            {children}
          </div>

          {/* Right Sidebar - Suggestions */}
          <div className="lg:w-1/4">
            <div className="sticky top-20 space-y-6">
              {/* Premium Promo */}
              <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-5">
                <div className="flex items-center justify-between mb-3">
                  <span className="text-sm font-semibold text-gray-700">Essayer Premium pour 0 CFA</span>
                  <Sparkles className="h-4 w-4 text-yellow-500" />
                </div>
                <p className="text-xs text-gray-600 mb-4">
                  Déverrouillez des outils et des informations Premium
                </p>
                <button className="w-full py-2 bg-gradient-to-r from-yellow-400 to-yellow-500 text-white rounded-md font-medium hover:from-yellow-500 hover:to-yellow-600">
                  Essayer gratuitement
                </button>
              </div>

              {/* Quick Links */}
              <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-5">
                <h3 className="text-sm font-semibold text-gray-700 mb-4">Pour les entreprises</h3>
                <div className="space-y-3">
                  <button className="w-full text-left text-sm text-blue-600 hover:underline">
                    See who's hiring on LinkedIn
                  </button>
                </div>
              </div>

              {/* Footer Links */}
              <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-5">
                <div className="space-y-2">
                  {[
                    'Accessibilité',
                    'Assistance clientèle',
                    'Conditions générales et confidentialité',
                    'Préférences Pubs Publicité',
                    'Solutions professionnelles',
                    'Téléchargez l\'application LinkedIn'
                  ].map((item) => (
                    <button
                      key={item}
                      className="block text-xs text-gray-500 hover:text-blue-600 hover:underline"
                    >
                      {item}
                    </button>
                  ))}
                  <div className="flex items-center space-x-2 pt-4 border-t border-gray-100">
                    <div className="w-6 h-6 bg-blue-600 rounded flex items-center justify-center">
                      <span className="text-white text-xs font-bold">in</span>
                    </div>
                    <div>
                      <p className="text-xs text-gray-600">LinkedIn Corporation</p>
                      <p className="text-xs text-gray-500">© {new Date().getFullYear()}</p>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};