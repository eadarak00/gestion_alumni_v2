// import { useAuth } from '../../hooks/useAuth';

// export const EtudiantDashboard = () => {
//   const { user, isEtudiant } = useAuth();

//   return (
//     <div className="space-y-6">
//       <div className="flex items-center justify-between">
//         <div>
//           <h1 className="text-3xl font-bold text-gray-900">
//             Bienvenue, {user?.prenom} {user?.nom}
//           </h1>
//           <p className="text-xl text-emerald-600 mt-1">Espace Étudiant</p>
//         </div>
//       </div>

//       <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
//         <div className="bg-white rounded-lg shadow p-6">
//           <h3 className="text-lg font-semibold text-gray-900 mb-2">Mon Profil</h3>
//           <p className="text-gray-600 text-sm mb-4">Complétez votre profil étudiant</p>
//           <div className="flex items-center justify-between text-sm">
//             <span className="text-gray-500">Progression</span>
//             <span className="font-medium text-emerald-600">45%</span>
//           </div>
//           <div className="mt-2 h-2 bg-gray-200 rounded-full overflow-hidden">
//             <div className="h-full bg-emerald-600" style={{ width: '45%' }} />
//           </div>
//         </div>

//         <div className="bg-white rounded-lg shadow p-6">
//           <h3 className="text-lg font-semibold text-gray-900 mb-2">Alumni Disponibles</h3>
//           <p className="text-gray-600 text-sm">Pour mentorat et networking</p>
//           <div className="mt-4 text-3xl font-bold text-emerald-600">47</div>
//           <p className="text-sm text-gray-500">alumni</p>
//         </div>

//         <div className="bg-white rounded-lg shadow p-6">
//           <h3 className="text-lg font-semibold text-gray-900 mb-2">Demandes Envoyées</h3>
//           <p className="text-gray-600 text-sm">En attente de réponse</p>
//           <div className="mt-4 text-3xl font-bold text-purple-600">3</div>
//           <p className="text-sm text-gray-500">en attente</p>
//         </div>
//       </div>

//       <div className="bg-white rounded-lg shadow p-6">
//         <h2 className="text-xl font-bold text-gray-900 mb-4">Prochaines étapes</h2>
//         <div className="space-y-3">
//           <div className="flex items-center space-x-3 p-3 bg-emerald-50 rounded-lg">
//             <div className="w-8 h-8 rounded-full bg-emerald-100 flex items-center justify-center">
//               <span className="text-emerald-600 font-bold">1</span>
//             </div>
//             <p className="text-gray-700">Complétez votre parcours académique</p>
//           </div>
//           <div className="flex items-center space-x-3 p-3 bg-emerald-50 rounded-lg">
//             <div className="w-8 h-8 rounded-full bg-emerald-100 flex items-center justify-center">
//               <span className="text-emerald-600 font-bold">2</span>
//             </div>
//             <p className="text-gray-700">Contactez votre premier alumni</p>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };

  // -----------------------------------------------------


// import { useState } from 'react';
// import { Link, useNavigate } from 'react-router-dom';
// import { 
//   Users, 
//   Briefcase, 
//   Calendar, 
//   MessageCircle, 
//   TrendingUp, 
//   Target,
//   Clock,
//   CheckCircle,
//   ArrowRight,
//   Plus,
//   Star,
//   Trophy,
//   Zap,
//   Sparkles,
//   Award,
//   Rocket,
//   Eye,
//   Heart,
//   Share2,
//   Filter,
//   ChevronRight,
//   GraduationCap,
//   Building,
//   MapPin,
//   Globe,
//   Coffee
// } from 'lucide-react';
// import { useAuth } from '../../hooks/useAuth';

// export const EtudiantDashboard = () => {
//   const { user } = useAuth();
//   const navigate = useNavigate();
//   const [activeTab, setActiveTab] = useState('overview');

//   // Données de démo élégantes
//   const stats = [
//     { label: 'Réseau', value: '42', change: '+12%', icon: Users, color: 'blue', description: 'Contacts actifs' },
//     { label: 'Opportunités', value: '18', change: '+5%', icon: Briefcase, color: 'emerald', description: 'Stages & emplois' },
//     { label: 'Événements', value: '7', change: '+3', icon: Calendar, color: 'purple', description: 'Prochains événements' },
//     { label: 'Mentors', value: '5', icon: Users, color: 'orange', description: 'Mentors connectés' },
//   ];

//   const suggestedMentors = [
//     { id: 1, name: 'Marie Dubois', role: 'Senior Developer @ Google', company: 'Google', match: '95%', tags: ['React', 'Node.js', 'AWS'] },
//     { id: 2, name: 'Jean Martin', role: 'Product Manager @ Meta', company: 'Meta', match: '88%', tags: ['Product', 'Strategy', 'AI'] },
//     { id: 3, name: 'Sophie Chen', role: 'Data Scientist @ Netflix', company: 'Netflix', match: '92%', tags: ['Python', 'ML', 'Big Data'] },
//   ];

//   const upcomingEvents = [
//     { id: 1, title: 'Workshop Tech Career', date: 'Demain, 14:00', type: 'En ligne', host: 'Google Alumni', spots: '12 places restantes' },
//     { id: 2, title: 'Networking Breakfast', date: '15 Déc, 09:00', type: 'En présentiel', host: 'Paris Alumni Group', spots: '8 places restantes' },
//   ];

//   const opportunities = [
//     { id: 1, title: 'Stage Développeur Fullstack', company: 'Stripe', location: 'Remote', type: 'Stage', salary: '€2,000/mois', deadline: '15 Déc' },
//     { id: 2, title: 'Junior Data Analyst', company: 'Amazon', location: 'Luxembourg', type: 'CDD', salary: '€45,000/an', deadline: '20 Déc' },
//     { id: 3, title: 'DevOps Intern', company: 'Microsoft', location: 'Paris', type: 'Stage', salary: '€1,800/mois', deadline: '10 Déc' },
//   ];

//   const achievements = [
//     { id: 1, title: 'Profil à 100%', icon: Trophy, progress: 100, points: 500 },
//     { id: 2, title: 'Premier mentor', icon: Users, progress: 100, points: 300 },
//     { id: 3, title: 'Participation active', icon: Star, progress: 75, points: 250 },
//     { id: 4, title: 'Réseau étendu', icon: Network, progress: 60, points: 200 },
//   ];

//   const quickActions = [
//     { label: 'Trouver un mentor', icon: Users, path: '/mentors' },
//     { label: 'Postuler à un stage', icon: Briefcase, path: '/opportunities' },
//     { label: 'Partager mon profil', icon: Share2, path: '/profile' },
//     { label: 'Explorer formations', icon: GraduationCap, path: '/formations' },
//   ];

//   const profileProgress = 65;

//   return (
//     <div className="space-y-8">
//       {/* Hero Welcome Section */}
//       <div className="relative overflow-hidden rounded-3xl bg-gradient-to-br from-blue-600 via-blue-500 to-emerald-500 p-8 text-white shadow-2xl shadow-blue-500/30">
//         <div className="relative z-10">
//           <div className="flex flex-col lg:flex-row items-start lg:items-center justify-between">
//             <div>
//               <div className="flex items-center space-x-3 mb-4">
//                 <div className="p-2 bg-white/20 rounded-xl backdrop-blur-sm">
//                   <Sparkles className="h-6 w-6" />
//                 </div>
//                 <span className="text-sm font-medium bg-white/20 backdrop-blur-sm px-3 py-1 rounded-full">
//                   ÉTUDIANT ACTIF
//                 </span>
//               </div>
              
//               <h1 className="text-3xl md:text-4xl font-bold mb-3">
//                 Bonjour, <span className="text-yellow-300">{user?.prenom}</span> ! 👋
//               </h1>
//               <p className="text-lg opacity-90 mb-6 max-w-2xl">
//                 Votre parcours vers l'excellence professionnelle commence ici. 
//                 Découvrez des opportunités uniques et construisez votre réseau.
//               </p>
              
//               <div className="flex flex-wrap gap-3">
//                 <button
//                   onClick={() => navigate('/profile/edit')}
//                   className="flex items-center space-x-2 bg-white text-blue-600 font-semibold px-6 py-3 rounded-xl hover:bg-blue-50 transition-all shadow-lg hover:shadow-xl"
//                 >
//                   <Plus className="h-5 w-5" />
//                   <span>Compléter mon profil</span>
//                 </button>
//                 <button
//                   onClick={() => navigate('/opportunities')}
//                   className="flex items-center space-x-2 bg-transparent border-2 border-white/50 text-white px-6 py-3 rounded-xl hover:bg-white/10 transition-all"
//                 >
//                   <Rocket className="h-5 w-5" />
//                   <span>Explorer opportunités</span>
//                 </button>
//               </div>
//             </div>
            
//             {/* Profile Progress Ring */}
//             <div className="mt-8 lg:mt-0">
//               <div className="relative w-48 h-48">
//                 <svg className="w-full h-full transform -rotate-90">
//                   <circle
//                     cx="96"
//                     cy="96"
//                     r="88"
//                     stroke="rgba(255,255,255,0.2)"
//                     strokeWidth="12"
//                     fill="none"
//                   />
//                   <circle
//                     cx="96"
//                     cy="96"
//                     r="88"
//                     stroke="url(#gradient)"
//                     strokeWidth="12"
//                     fill="none"
//                     strokeDasharray={`${2 * Math.PI * 88}`}
//                     strokeDashoffset={`${2 * Math.PI * 88 * (1 - profileProgress / 100)}`}
//                     strokeLinecap="round"
//                   />
//                   <defs>
//                     <linearGradient id="gradient" x1="0%" y1="0%" x2="100%" y2="100%">
//                       <stop offset="0%" stopColor="#fbbf24" />
//                       <stop offset="100%" stopColor="#f97316" />
//                     </linearGradient>
//                   </defs>
//                 </svg>
//                 <div className="absolute inset-0 flex flex-col items-center justify-center">
//                   <span className="text-5xl font-bold">{profileProgress}%</span>
//                   <span className="text-sm opacity-80">Profil complété</span>
//                 </div>
//               </div>
//             </div>
//           </div>
//         </div>
        
//         {/* Floating Elements */}
//         <div className="absolute top-0 right-0 w-64 h-64 bg-white/10 rounded-full blur-3xl"></div>
//         <div className="absolute bottom-0 left-0 w-48 h-48 bg-emerald-400/20 rounded-full blur-3xl"></div>
//       </div>

//       {/* Stats Grid */}
//       <div className="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 gap-6">
//         {stats.map((stat, index) => {
//           const Icon = stat.icon;
//           const colorClasses = {
//             blue: 'bg-gradient-to-br from-blue-500 to-blue-600',
//             emerald: 'bg-gradient-to-br from-emerald-500 to-emerald-600',
//             purple: 'bg-gradient-to-br from-purple-500 to-purple-600',
//             orange: 'bg-gradient-to-br from-orange-500 to-orange-600',
//           };
          
//           return (
//             <div 
//               key={index}
//               className="group bg-white/80 backdrop-blur-sm rounded-2xl p-6 border border-gray-200/50 shadow-sm hover:shadow-xl hover:border-blue-200 transition-all duration-300 cursor-pointer hover:scale-[1.02]"
//             >
//               <div className="flex items-center justify-between mb-4">
//                 <div className={`p-3 rounded-xl ${colorClasses[stat.color]} shadow-lg`}>
//                   <Icon className="h-6 w-6 text-white" />
//                 </div>
//                 {stat.change && (
//                   <div className="flex items-center text-sm font-medium text-emerald-600 bg-emerald-50 px-2.5 py-1 rounded-full">
//                     <TrendingUp className="h-3 w-3 mr-1" />
//                     {stat.change}
//                   </div>
//                 )}
//               </div>
              
//               <p className="text-3xl font-bold text-gray-900 mb-1">{stat.value}</p>
//               <p className="text-sm font-medium text-gray-900">{stat.label}</p>
//               <p className="text-xs text-gray-500 mt-1">{stat.description}</p>
              
//               <div className="mt-4 pt-4 border-t border-gray-100">
//                 <button className="text-sm text-blue-600 hover:text-blue-700 font-medium inline-flex items-center group-hover:translate-x-1 transition-transform">
//                   Voir détails
//                   <ChevronRight className="h-4 w-4 ml-1" />
//                 </button>
//               </div>
//             </div>
//           );
//         })}
//       </div>

//       {/* Two Column Layout */}
//       <div className="grid grid-cols-1 lg:grid-cols-3 gap-8">
//         {/* Left Column - 2/3 width */}
//         <div className="lg:col-span-2 space-y-8">
//           {/* Quick Actions */}
//           <div className="bg-white/80 backdrop-blur-sm rounded-2xl border border-gray-200/50 p-6 shadow-sm">
//             <div className="flex items-center justify-between mb-6">
//               <div>
//                 <h2 className="text-xl font-bold text-gray-900">Actions rapides</h2>
//                 <p className="text-sm text-gray-500 mt-1">Accédez rapidement aux fonctionnalités clés</p>
//               </div>
//               <Zap className="h-5 w-5 text-yellow-500" />
//             </div>
            
//             <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
//               {quickActions.map((action, index) => {
//                 const Icon = action.icon;
//                 return (
//                   <Link
//                     key={index}
//                     to={action.path}
//                     className="group flex flex-col items-center justify-center p-4 bg-gradient-to-br from-gray-50 to-white border border-gray-200 rounded-xl hover:border-blue-300 hover:shadow-lg transition-all duration-300"
//                   >
//                     <div className="p-3 bg-gradient-to-br from-blue-50 to-emerald-50 rounded-lg mb-3 group-hover:scale-110 transition-transform">
//                       <Icon className="h-6 w-6 text-blue-600" />
//                     </div>
//                     <span className="text-sm font-medium text-gray-900 text-center">{action.label}</span>
//                   </Link>
//                 );
//               })}
//             </div>
//           </div>

//           {/* Opportunities */}
//           <div className="bg-white/80 backdrop-blur-sm rounded-2xl border border-gray-200/50 p-6 shadow-sm">
//             <div className="flex items-center justify-between mb-6">
//               <div>
//                 <h2 className="text-xl font-bold text-gray-900">Opportunités à ne pas manquer</h2>
//                 <p className="text-sm text-gray-500 mt-1">Recommandées selon votre profil</p>
//               </div>
//               <button className="text-sm text-blue-600 hover:text-blue-700 font-medium">
//                 Voir tout
//               </button>
//             </div>
            
//             <div className="space-y-4">
//               {opportunities.map((opp) => (
//                 <div
//                   key={opp.id}
//                   className="group p-5 bg-gradient-to-r from-white to-gray-50 border border-gray-200 rounded-xl hover:border-blue-300 hover:shadow-lg transition-all duration-300 cursor-pointer"
//                 >
//                   <div className="flex items-start justify-between">
//                     <div className="flex-1">
//                       <div className="flex items-center space-x-3">
//                         <div className="w-12 h-12 bg-gradient-to-br from-blue-100 to-emerald-100 rounded-lg flex items-center justify-center">
//                           <Building className="h-6 w-6 text-blue-600" />
//                         </div>
//                         <div>
//                           <h3 className="font-bold text-gray-900">{opp.title}</h3>
//                           <div className="flex items-center space-x-3 mt-1">
//                             <span className="text-sm text-gray-600">{opp.company}</span>
//                             <span className="flex items-center text-sm text-gray-500">
//                               <MapPin className="h-3 w-3 mr-1" />
//                               {opp.location}
//                             </span>
//                             <span className={`px-2 py-1 text-xs rounded-full ${
//                               opp.type === 'Stage' 
//                                 ? 'bg-blue-100 text-blue-800'
//                                 : 'bg-emerald-100 text-emerald-800'
//                             }`}>
//                               {opp.type}
//                             </span>
//                           </div>
//                         </div>
//                       </div>
                      
//                       <div className="flex items-center justify-between mt-4">
//                         <div className="flex items-center space-x-4">
//                           <span className="text-sm font-medium text-gray-900">{opp.salary}</span>
//                           <span className="flex items-center text-sm text-gray-500">
//                             <Clock className="h-3 w-3 mr-1" />
//                             Clôture: {opp.deadline}
//                           </span>
//                         </div>
//                         <button className="px-4 py-2 bg-gradient-to-r from-blue-500 to-emerald-500 text-white rounded-lg hover:shadow-lg transition-all opacity-0 group-hover:opacity-100">
//                           Postuler
//                         </button>
//                       </div>
//                     </div>
//                   </div>
//                 </div>
//               ))}
//             </div>
//           </div>
//         </div>

//         {/* Right Column - 1/3 width */}
//         <div className="space-y-8">
//           {/* Suggested Mentors */}
//           <div className="bg-white/80 backdrop-blur-sm rounded-2xl border border-gray-200/50 p-6 shadow-sm">
//             <div className="flex items-center justify-between mb-6">
//               <div>
//                 <h2 className="text-xl font-bold text-gray-900">Mentors suggérés</h2>
//                 <p className="text-sm text-gray-500 mt-1">Connectez-vous avec des experts</p>
//               </div>
//               <Users className="h-5 w-5 text-blue-600" />
//             </div>
            
//             <div className="space-y-4">
//               {suggestedMentors.map((mentor) => (
//                 <div key={mentor.id} className="p-4 bg-gradient-to-r from-blue-50/50 to-emerald-50/50 border border-blue-100 rounded-xl">
//                   <div className="flex items-start space-x-3">
//                     <div className="relative">
//                       <div className="w-12 h-12 bg-gradient-to-br from-blue-400 to-emerald-400 rounded-full" />
//                       <div className="absolute -bottom-1 -right-1 bg-emerald-500 text-white text-xs px-1.5 py-0.5 rounded-full">
//                         {mentor.match}
//                       </div>
//                     </div>
//                     <div className="flex-1">
//                       <h4 className="font-bold text-gray-900">{mentor.name}</h4>
//                       <p className="text-sm text-gray-600">{mentor.role}</p>
//                       <div className="flex flex-wrap gap-1 mt-2">
//                         {mentor.tags.map((tag, idx) => (
//                           <span key={idx} className="px-2 py-1 bg-white text-xs text-gray-600 rounded-lg border">
//                             {tag}
//                           </span>
//                         ))}
//                       </div>
//                       <button className="w-full mt-3 px-4 py-2 bg-gradient-to-r from-blue-500 to-emerald-500 text-white rounded-lg hover:shadow-lg transition-all">
//                         Connecter
//                       </button>
//                     </div>
//                   </div>
//                 </div>
//               ))}
//             </div>
//           </div>

//           {/* Upcoming Events */}
//           <div className="bg-white/80 backdrop-blur-sm rounded-2xl border border-gray-200/50 p-6 shadow-sm">
//             <div className="flex items-center justify-between mb-6">
//               <div>
//                 <h2 className="text-xl font-bold text-gray-900">Événements à venir</h2>
//                 <p className="text-sm text-gray-500 mt-1">Ne manquez pas ces rendez-vous</p>
//               </div>
//               <Calendar className="h-5 w-5 text-purple-600" />
//             </div>
            
//             <div className="space-y-4">
//               {upcomingEvents.map((event) => (
//                 <div key={event.id} className="p-4 bg-gradient-to-r from-purple-50/50 to-pink-50/50 border border-purple-100 rounded-xl">
//                   <div className="flex items-start justify-between">
//                     <div>
//                       <h4 className="font-bold text-gray-900">{event.title}</h4>
//                       <div className="flex items-center space-x-3 mt-2">
//                         <span className="flex items-center text-sm text-gray-600">
//                           <Clock className="h-3 w-3 mr-1" />
//                           {event.date}
//                         </span>
//                         <span className={`px-2 py-1 text-xs rounded-full ${
//                           event.type === 'En ligne' 
//                             ? 'bg-blue-100 text-blue-800'
//                             : 'bg-purple-100 text-purple-800'
//                         }`}>
//                           {event.type}
//                         </span>
//                       </div>
//                       <p className="text-sm text-gray-600 mt-2">{event.host}</p>
//                       <p className="text-xs text-emerald-600 font-medium mt-1">{event.spots}</p>
//                     </div>
//                   </div>
//                   <button className="w-full mt-4 px-4 py-2 bg-gradient-to-r from-purple-500 to-pink-500 text-white rounded-lg hover:shadow-lg transition-all">
//                     S'inscrire
//                   </button>
//                 </div>
//               ))}
//             </div>
//           </div>

//           {/* Achievements */}
//           <div className="bg-white/80 backdrop-blur-sm rounded-2xl border border-gray-200/50 p-6 shadow-sm">
//             <div className="flex items-center justify-between mb-6">
//               <div>
//                 <h2 className="text-xl font-bold text-gray-900">Mes succès</h2>
//                 <p className="text-sm text-gray-500 mt-1">Badges et accomplissements</p>
//               </div>
//               <Trophy className="h-5 w-5 text-yellow-600" />
//             </div>
            
//             <div className="grid grid-cols-2 gap-4">
//               {achievements.map((achievement) => {
//                 const Icon = achievement.icon;
//                 return (
//                   <div key={achievement.id} className="text-center p-4 bg-gradient-to-br from-gray-50 to-white border border-gray-200 rounded-xl">
//                     <div className="inline-flex p-3 bg-gradient-to-br from-yellow-50 to-orange-50 rounded-lg mb-2">
//                       <Icon className="h-6 w-6 text-yellow-600" />
//                     </div>
//                     <p className="text-sm font-medium text-gray-900 mb-1">{achievement.title}</p>
//                     <div className="flex items-center justify-center space-x-2">
//                       <div className="w-16 bg-gray-200 rounded-full h-1.5">
//                         <div 
//                           className="bg-gradient-to-r from-yellow-500 to-orange-500 h-1.5 rounded-full" 
//                           style={{ width: `${achievement.progress}%` }}
//                         />
//                       </div>
//                       <span className="text-xs text-gray-500">{achievement.progress}%</span>
//                     </div>
//                     <div className="mt-2 flex items-center justify-center text-xs text-gray-600">
//                       <Award className="h-3 w-3 mr-1" />
//                       {achievement.points} pts
//                     </div>
//                   </div>
//                 );
//               })}
//             </div>
//           </div>
//         </div>
//       </div>

//       {/* Daily Tip */}
//       <div className="bg-gradient-to-r from-blue-50 to-emerald-50 border border-blue-100 rounded-2xl p-6">
//         <div className="flex items-start space-x-4">
//           <div className="p-3 bg-gradient-to-br from-blue-500 to-emerald-500 rounded-xl">
//             <Target className="h-6 w-6 text-white" />
//           </div>
//           <div className="flex-1">
//             <h3 className="font-bold text-gray-900 mb-2">Conseil du jour</h3>
//             <p className="text-gray-700">
//               Connectez-vous avec au moins un alumni cette semaine. Une simple conversation 
//               peut ouvrir des portes insoupçonnées pour votre carrière.
//             </p>
//             <div className="flex items-center mt-4">
//               <Coffee className="h-4 w-4 text-gray-400 mr-2" />
//               <span className="text-sm text-gray-500">
//                 "Le réseau est la clé du succès professionnel"
//               </span>
//             </div>
//           </div>
//         </div>
//       </div>
//     </div>
//   );
// };


// -----------------------------------------------------

import { useState } from 'react';
import { Link } from 'react-router-dom';
import {
  Plus,
  Image,
  Video,
  Calendar,
  MapPin,
  Globe,
  Send,
  ThumbsUp,
  MessageCircle,
  Share2,
  MoreHorizontal,
  Eye,
  Users,
  Briefcase,
  GraduationCap,
  Building,
  Award,
  TrendingUp,
  ChevronRight,
  Coffee,
  Target,
  Zap,
  Star,
  BookOpen,
  Clock
} from 'lucide-react';
import { useAuth } from '../../hooks/useAuth';

export const EtudiantDashboard = () => {
  const { user } = useAuth();
  const [postContent, setPostContent] = useState('');

  // Data for feed
  const feedPosts = [
    {
      id: 1,
      author: {
        name: 'Marie Dubois',
        title: 'Senior Developer @ Google',
        avatar: 'bg-gradient-to-br from-blue-400 to-emerald-300',
      },
      content: 'Nous recrutons des stagiaires en développement ! Si vous êtes passionné par React, Node.js et que vous voulez apprendre dans un environnement stimulant, contactez-moi. #recrutement #stage #tech',
      time: '2h',
      likes: 42,
      comments: 12,
      shares: 5,
      type: 'job',
    },
    {
      id: 2,
      author: {
        name: 'UASZ Alumni Network',
        title: 'Groupe officiel',
        avatar: 'bg-gradient-to-br from-blue-600 to-emerald-500',
      },
      content: '🎉 Événement à venir : "Career Path in Tech" le 15 décembre. Rejoignez nos alumni travaillant chez Google, Amazon et Microsoft pour discuter des opportunités en tech.',
      time: '5h',
      likes: 89,
      comments: 24,
      shares: 18,
      type: 'event',
    },
    {
      id: 3,
      author: {
        name: 'Jean Martin',
        title: 'Product Manager @ Meta',
        avatar: 'bg-gradient-to-br from-purple-400 to-pink-300',
      },
      content: 'Partage d\'article intéressant sur les tendances AI pour 2024. Une lecture essentielle pour tout étudiant en informatique qui veut rester à jour.',
      time: '1j',
      likes: 156,
      comments: 47,
      shares: 32,
      type: 'article',
    },
  ];

  const suggestedConnections = [
    {
      id: 1,
      name: 'Sophie Chen',
      title: 'Data Scientist @ Netflix',
      mutual: 12,
    },
    {
      id: 2,
      name: 'Thomas Leroy',
      title: 'Software Engineer @ Microsoft',
      mutual: 8,
    },
    {
      id: 3,
      name: 'Amandine Petit',
      title: 'UX Designer @ Spotify',
      mutual: 5,
    },
  ];

  const trendingTopics = [
    { tag: '#TechJobs', posts: '2.4k' },
    { tag: '#CareerAdvice', posts: '1.8k' },
    { tag: '#AlumniNetwork', posts: '856' },
    { tag: '#UASZ', posts: '432' },
  ];

  return (
    <div className="space-y-6">
      {/* Create Post Card */}
      <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-4">
        <div className="flex items-start space-x-3">
          <div className="w-12 h-12 rounded-full bg-gradient-to-br from-blue-400 to-emerald-300" />
          <div className="flex-1">
            <button
              onClick={() => document.getElementById('postModal').showModal()}
              className="w-full text-left px-4 py-3 bg-gray-100 hover:bg-gray-200 rounded-full text-gray-500 mb-3"
            >
              Commencer un post
            </button>
            <div className="flex items-center justify-between">
              <div className="flex items-center space-x-4">
                <button className="flex items-center space-x-2 text-gray-600 hover:text-blue-600">
                  <Image className="h-5 w-5" />
                  <span className="text-sm">Photo</span>
                </button>
                <button className="flex items-center space-x-2 text-gray-600 hover:text-blue-600">
                  <Video className="h-5 w-5" />
                  <span className="text-sm">Vidéo</span>
                </button>
                <button className="flex items-center space-x-2 text-gray-600 hover:text-blue-600">
                  <Calendar className="h-5 w-5" />
                  <span className="text-sm">Événement</span>
                </button>
              </div>
              <button className="px-4 py-1.5 bg-blue-600 text-white rounded-full text-sm font-medium hover:bg-blue-700">
                Publier
              </button>
            </div>
          </div>
        </div>
      </div>

      {/* Stats Overview */}
      <div className="grid grid-cols-2 md:grid-cols-4 gap-4">
        <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-4">
          <div className="flex items-center justify-between">
            <div>
              <p className="text-2xl font-bold text-gray-900">42</p>
              <p className="text-sm text-gray-600">Contacts</p>
            </div>
            <div className="p-2 bg-blue-50 rounded-lg">
              <Users className="h-6 w-6 text-blue-600" />
            </div>
          </div>
          <div className="flex items-center text-sm text-emerald-600 mt-2">
            <TrendingUp className="h-4 w-4 mr-1" />
            <span>+5 cette semaine</span>
          </div>
        </div>

        <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-4">
          <div className="flex items-center justify-between">
            <div>
              <p className="text-2xl font-bold text-gray-900">18</p>
              <p className="text-sm text-gray-600">Opportunités</p>
            </div>
            <div className="p-2 bg-emerald-50 rounded-lg">
              <Briefcase className="h-6 w-6 text-emerald-600" />
            </div>
          </div>
          <div className="text-sm text-gray-500 mt-2">
            <span className="text-emerald-600 font-medium">5 nouvelles</span>
          </div>
        </div>

        <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-4">
          <div className="flex items-center justify-between">
            <div>
              <p className="text-2xl font-bold text-gray-900">7</p>
              <p className="text-sm text-gray-600">Événements</p>
            </div>
            <div className="p-2 bg-purple-50 rounded-lg">
              <Calendar className="h-6 w-6 text-purple-600" />
            </div>
          </div>
          <div className="text-sm text-gray-500 mt-2">
            Prochain dans 2 jours
          </div>
        </div>

        <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-4">
          <div className="flex items-center justify-between">
            <div>
              <p className="text-2xl font-bold text-gray-900">92%</p>
              <p className="text-sm text-gray-600">Profil</p>
            </div>
            <div className="p-2 bg-yellow-50 rounded-lg">
              <Award className="h-6 w-6 text-yellow-600" />
            </div>
          </div>
          <div className="text-sm text-gray-500 mt-2">
            <span className="text-blue-600 font-medium">Compléter</span>
          </div>
        </div>
      </div>

      {/* Feed */}
      <div className="space-y-4">
        {feedPosts.map((post) => (
          <div key={post.id} className="bg-white rounded-lg shadow-sm border border-gray-200 overflow-hidden">
            {/* Post Header */}
            <div className="p-4 border-b border-gray-100">
              <div className="flex items-start justify-between">
                <div className="flex items-start space-x-3">
                  <div className={`w-12 h-12 rounded-full ${post.author.avatar}`} />
                  <div>
                    <h4 className="font-semibold text-gray-900">{post.author.name}</h4>
                    <p className="text-sm text-gray-600">{post.author.title}</p>
                    <div className="flex items-center text-xs text-gray-500 mt-1">
                      <Clock className="h-3 w-3 mr-1" />
                      <span>{post.time}</span>
                      <span className="mx-2">•</span>
                      <Globe className="h-3 w-3 mr-1" />
                      <span>Public</span>
                    </div>
                  </div>
                </div>
                <button className="text-gray-400 hover:text-gray-600">
                  <MoreHorizontal className="h-5 w-5" />
                </button>
              </div>
            </div>

            {/* Post Content */}
            <div className="p-4">
              <p className="text-gray-800">{post.content}</p>
              {post.type === 'job' && (
                <div className="mt-3 p-3 bg-blue-50 rounded-lg">
                  <div className="flex items-center text-blue-700 mb-1">
                    <Briefcase className="h-4 w-4 mr-2" />
                    <span className="text-sm font-medium">Offre d'emploi</span>
                  </div>
                  <p className="text-sm text-blue-600">Google • Paris • Stage</p>
                </div>
              )}
            </div>

            {/* Post Stats */}
            <div className="px-4 py-2 border-t border-gray-100 flex items-center justify-between text-sm text-gray-500">
              <div className="flex items-center space-x-4">
                <div className="flex items-center">
                  <ThumbsUp className="h-4 w-4 text-blue-600 mr-1" />
                  <span>{post.likes}</span>
                </div>
                <span>{post.comments} commentaires</span>
                <span>{post.shares} partages</span>
              </div>
              <div className="flex items-center">
                <Eye className="h-4 w-4 mr-1" />
                <span>2.4k vues</span>
              </div>
            </div>

            {/* Post Actions */}
            <div className="grid grid-cols-4 border-t border-gray-100">
              <button className="flex items-center justify-center space-x-2 py-3 text-gray-600 hover:bg-gray-50 hover:text-blue-600">
                <ThumbsUp className="h-5 w-5" />
                <span className="text-sm font-medium">J'aime</span>
              </button>
              <button className="flex items-center justify-center space-x-2 py-3 text-gray-600 hover:bg-gray-50 hover:text-blue-600">
                <MessageCircle className="h-5 w-5" />
                <span className="text-sm font-medium">Commenter</span>
              </button>
              <button className="flex items-center justify-center space-x-2 py-3 text-gray-600 hover:bg-gray-50 hover:text-blue-600">
                <Share2 className="h-5 w-5" />
                <span className="text-sm font-medium">Partager</span>
              </button>
              <button className="flex items-center justify-center space-x-2 py-3 text-gray-600 hover:bg-gray-50 hover:text-blue-600">
                <Send className="h-5 w-5" />
                <span className="text-sm font-medium">Envoyer</span>
              </button>
            </div>
          </div>
        ))}
      </div>

      {/* Suggested Connections */}
      <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-5">
        <div className="flex items-center justify-between mb-4">
          <h3 className="font-semibold text-gray-900">Personnes que vous connaissez peut-être</h3>
          <Link to="/network" className="text-sm text-blue-600 hover:text-blue-700">
            Voir tout
          </Link>
        </div>
        <div className="space-y-4">
          {suggestedConnections.map((connection) => (
            <div key={connection.id} className="flex items-center justify-between">
              <div className="flex items-center space-x-3">
                <div className="w-10 h-10 rounded-full bg-gradient-to-br from-blue-400 to-emerald-300" />
                <div>
                  <p className="font-medium text-gray-900">{connection.name}</p>
                  <p className="text-sm text-gray-600">{connection.title}</p>
                  <p className="text-xs text-gray-500">{connection.mutual} contacts en commun</p>
                </div>
              </div>
              <button className="px-4 py-1.5 border border-blue-600 text-blue-600 rounded-full hover:bg-blue-50 text-sm font-medium">
                Connecter
              </button>
            </div>
          ))}
        </div>
      </div>

      {/* Trending Topics */}
      <div className="bg-white rounded-lg shadow-sm border border-gray-200 p-5">
        <h3 className="font-semibold text-gray-900 mb-4">Sujets tendance</h3>
        <div className="space-y-3">
          {trendingTopics.map((topic) => (
            <button
              key={topic.tag}
              className="block w-full text-left hover:bg-gray-50 p-2 rounded"
            >
              <div className="flex items-center justify-between">
                <span className="font-medium text-gray-900">{topic.tag}</span>
                <span className="text-sm text-gray-500">{topic.posts} posts</span>
              </div>
            </button>
          ))}
        </div>
      </div>

      {/* Post Modal */}
      <dialog id="postModal" className="rounded-lg shadow-xl max-w-2xl w-full">
        <div className="p-6">
          <div className="flex items-center justify-between mb-6">
            <h3 className="text-lg font-semibold text-gray-900">Créer une publication</h3>
            <button
              onClick={() => document.getElementById('postModal').close()}
              className="text-gray-400 hover:text-gray-600"
            >
              ✕
            </button>
          </div>
          
          <div className="flex items-start space-x-3 mb-6">
            <div className="w-12 h-12 rounded-full bg-gradient-to-br from-blue-400 to-emerald-300" />
            <div>
              <p className="font-medium text-gray-900">
                {user?.prenom} {user?.nom}
              </p>
              <div className="flex items-center text-sm text-gray-500">
                <Globe className="h-4 w-4 mr-1" />
                <span>Public</span>
              </div>
            </div>
          </div>

          <textarea
            placeholder="De quoi voulez-vous parler ?"
            className="w-full min-h-[200px] border-none focus:outline-none text-lg resize-none"
            value={postContent}
            onChange={(e) => setPostContent(e.target.value)}
          />

          <div className="flex items-center justify-between mt-6 pt-6 border-t border-gray-200">
            <div className="flex items-center space-x-4">
              <button className="p-2 text-gray-600 hover:text-blue-600 hover:bg-blue-50 rounded-lg">
                <Image className="h-5 w-5" />
              </button>
              <button className="p-2 text-gray-600 hover:text-blue-600 hover:bg-blue-50 rounded-lg">
                <Video className="h-5 w-5" />
              </button>
              <button className="p-2 text-gray-600 hover:text-blue-600 hover:bg-blue-50 rounded-lg">
                <Calendar className="h-5 w-5" />
              </button>
              <button className="p-2 text-gray-600 hover:text-blue-600 hover:bg-blue-50 rounded-lg">
                <MapPin className="h-5 w-5" />
              </button>
            </div>
            <div className="flex items-center space-x-3">
              <button
                onClick={() => document.getElementById('postModal').close()}
                className="px-4 py-2 text-gray-700 hover:bg-gray-100 rounded-full"
              >
                Annuler
              </button>
              <button className="px-6 py-2 bg-blue-600 text-white rounded-full font-medium hover:bg-blue-700">
                Publier
              </button>
            </div>
          </div>
        </div>
      </dialog>
    </div>
  );
};