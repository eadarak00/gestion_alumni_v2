// import {
//   Bell,
//   Search,
//   User,
//   LogOut,
//   FileText,
//   Mail,
//   UserCircle,
// } from "lucide-react";
// import { useAuth } from "../../hooks/useAuth";
// import { useNavigate } from "react-router-dom";
// import { useState, useRef, useEffect } from "react";

// export const Header = () => {
//   const { user, logout } = useAuth();
//   const navigate = useNavigate();
//   const [dropdownOpen, setDropdownOpen] = useState(false);
//   const dropdownRef = useRef(null);

//   const handleLogout = async () => {
//     await logout();
//     navigate("/login");
//   };

//   // Fermer le dropdown quand on clique en dehors
//   useEffect(() => {
//     const handleClickOutside = (event) => {
//       if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
//         setDropdownOpen(false);
//       }
//     };

//     document.addEventListener("mousedown", handleClickOutside);
//     return () => {
//       document.removeEventListener("mousedown", handleClickOutside);
//     };
//   }, []);

//   // Menu items selon le rôle
//   const getMenuItems = () => {
//     const baseItems = [
//       {
//         icon: UserCircle,
//         label: "Mon Profil",
//         path: "/profile",
//         onClick: () => navigate("/profile"),
//       },
//     ];

//     // Ajouter "Invitations" pour tous les utilisateurs
//     baseItems.push({
//       icon: Mail,
//       label: "Invitations",
//       path: "/invitations",
//       onClick: () => navigate("/invitations"),
//     });

//     // Si c'est un étudiant, ajouter "Mon CV"
//     if (user?.role?.toLowerCase() === "etudiant") {
//       baseItems.push({
//         icon: FileText,
//         label: "Mon CV",
//         path: "/cv",
//         onClick: () => navigate("/cv"),
//       });
//     }

//     // Ajouter "Déconnexion" à la fin
//     baseItems.push({
//       icon: LogOut,
//       label: "Déconnexion",
//       onClick: handleLogout,
//       isLogout: true,
//     });

//     return baseItems;
//   };

//   const menuItems = getMenuItems();

//   return (
//     <header className="bg-white border-b border-gray-200 sticky top-0 z-30">
//       <div className="px-6 py-4 flex items-center justify-between">
//         <div className="flex items-center space-x-4 flex-1 max-w-2xl">
//           <div className="relative flex-1">
//             <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400 h-5 w-5" />
//             <input
//               type="text"
//               placeholder="Rechercher..."
//               className="w-full pl-10 pr-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-green-500 focus:border-transparent"
//             />
//           </div>
//         </div>

//         <div className="flex items-center space-x-4">
//           <button className="relative p-2 text-gray-600 hover:text-gray-900 hover:bg-gray-100 rounded-lg transition-colors">
//             <Bell className="h-6 w-6" />
//             <span className="absolute top-1 right-1 w-2 h-2 bg-red-500 rounded-full" />
//           </button>

//           <div className="flex items-center space-x-3 pl-4 border-l border-gray-200">
//             <div className="text-right">
//               <p className="text-sm font-medium text-gray-900">
//                 {user?.prenom} {user?.nom}
//               </p>
//               <p className="text-xs text-gray-500">{user?.role}</p>
//             </div>

//             <div className="relative" ref={dropdownRef}>
//               <button
//                 onClick={() => setDropdownOpen(!dropdownOpen)}
//                 className="flex items-center space-x-2 p-2 rounded-lg hover:bg-gray-100 transition-colors"
//               >
//                 <div className="w-10 h-10 rounded-full bg-green-100 flex items-center justify-center">
//                   <User className="h-6 w-6 text-green-600" />
//                 </div>
//               </button>

//               {dropdownOpen && (
//                 <div className="absolute right-0 mt-2 w-56 bg-white rounded-lg shadow-lg py-2 border border-gray-200">
//                   {menuItems.map((item, index) => (
//                     <button
//                       key={index}
//                       onClick={() => {
//                         item.onClick();
//                         setDropdownOpen(false);
//                       }}
//                       className={`w-full flex items-center space-x-3 px-4 py-3 text-sm hover:bg-gray-50 transition-colors ${
//                         item.isLogout
//                           ? "border-t border-gray-200 text-red-600 hover:text-red-700"
//                           : "text-gray-700"
//                       }`}
//                     >
//                       <item.icon
//                         className={`h-4 w-4 ${
//                           item.isLogout ? "text-red-600" : ""
//                         }`}
//                       />
//                       <span className="flex-1 text-left">{item.label}</span>
//                     </button>
//                   ))}
//                 </div>
//               )}
//             </div>
//           </div>
//         </div>
//       </div>
//     </header>
//   );
// };

// src/components/layout/Header.jsx
import {
  Bell,
  Search,
  User,
  LogOut,
  FileText,
  Mail,
  UserCircle,
} from "lucide-react";
import { useAuth } from "../../hooks/useAuth";
import { useNavigate } from "react-router-dom";
import { useState, useRef, useEffect } from "react";

export const Header = () => {
  const { user, logout, profileCompleted } = useAuth();
  const navigate = useNavigate();
  const [dropdownOpen, setDropdownOpen] = useState(false);
  const dropdownRef = useRef(null);

  const handleLogout = async () => {
    await logout();
    navigate("/login");
  };

  useEffect(() => {
    const handleClickOutside = (event) => {
      if (dropdownRef.current && !dropdownRef.current.contains(event.target)) {
        setDropdownOpen(false);
      }
    };
    document.addEventListener("mousedown", handleClickOutside);
    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, []);

  const getMenuItems = () => {
    const baseItems = [
      {
        icon: UserCircle,
        label: "Mon Profil",
        onClick: () => {
          if (user?.role === "ALUMNI") {
            navigate("/alumni/profile");
          } else if (user?.role === "ETUDIANT") {
            navigate("/etudiant/profile");
          } else {
            navigate("/profile"); // Fallback
          }
        },
      },
      {
        icon: Mail,
        label: "Invitations",
        onClick: () => navigate("/invitations"),
      },
    ];

    if (user?.role?.toLowerCase() === "etudiant") {
      baseItems.push({
        icon: FileText,
        label: "Mon CV",
        onClick: () => navigate("/cv"),
      });
    }

    baseItems.push({
      icon: LogOut,
      label: "Déconnexion",
      onClick: handleLogout,
      isLogout: true,
    });

    return baseItems;
  };

  const menuItems = getMenuItems();

  return (
    <header className="bg-white border-b border-gray-200 sticky top-0 z-30">
      <div className="px-6 py-4 flex items-center justify-between">
        <div className="flex items-center space-x-4 flex-1 max-w-2xl">
          <div className="relative flex-1">
            <Search className="absolute left-3 top-1/2 transform -translate-y-1/2 text-gray-400 h-5 w-5" />
            <input
              type="text"
              placeholder="Rechercher..."
              className="w-full pl-10 pr-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-green-500 focus:border-transparent"
            />
          </div>
        </div>

        <div className="flex items-center space-x-4">
          <button className="relative p-2 text-gray-600 hover:text-gray-900 hover:bg-gray-100 rounded-lg transition-colors">
            <Bell className="h-6 w-6" />
            <span className="absolute top-1 right-1 w-2 h-2 bg-red-500 rounded-full" />
          </button>

          <div className="flex items-center space-x-3 pl-4 border-l border-gray-200">
            <div className="text-right">
              <p className="text-sm font-medium text-gray-900">
                {user?.prenom} {user?.nom}
              </p>
              <p className="text-xs text-gray-500">{user?.role}</p>
            </div>

            <div className="relative" ref={dropdownRef}>
              <button
                onClick={() => setDropdownOpen(!dropdownOpen)}
                className="flex items-center space-x-2 p-2 rounded-lg hover:bg-gray-100 transition-colors"
              >
                <div className="w-10 h-10 rounded-full bg-green-100 flex items-center justify-center">
                  <User className="h-6 w-6 text-green-600" />
                </div>
              </button>

              {dropdownOpen && (
                <div className="absolute right-0 mt-2 w-56 bg-white rounded-lg shadow-lg py-2 border border-gray-200">
                  {menuItems.map((item, index) => (
                    <button
                      key={index}
                      onClick={() => {
                        item.onClick();
                        setDropdownOpen(false);
                      }}
                      className={`w-full flex items-center space-x-3 px-4 py-3 text-sm hover:bg-gray-50 transition-colors ${item.isLogout
                        ? "border-t border-gray-200 text-red-600 hover:text-red-700"
                        : "text-gray-700"
                        }`}
                    >
                      <item.icon
                        className={`h-4 w-4 ${item.isLogout ? "text-red-600" : ""
                          }`}
                      />
                      <span className="flex-1 text-left">{item.label}</span>
                    </button>
                  ))}
                </div>
              )}
            </div>
          </div>
        </div>
      </div>
    </header>
  );
};
