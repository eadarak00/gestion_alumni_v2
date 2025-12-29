// import { useState } from 'react';
// import { useNavigate, Link } from 'react-router-dom';
// import { Mail, Lock } from 'lucide-react';
// import { AuthLayout } from '../../components/layout/AuthLayout';
// import { Input } from '../../components/common/Input';
// import { useAuth } from '../../hooks/useAuth';
// import { useToast } from '../../hooks/useToast';

// export const Login = () => {
//   const navigate = useNavigate();
//   const { login } = useAuth();
//   const { showSuccess, showError } = useToast();

//   const [formData, setFormData] = useState({
//     email: '',
//     motDePasse: ''
//   });
//   const [loading, setLoading] = useState(false);
//   const [rememberMe, setRememberMe] = useState(false);

//   const handleChange = (e) => {
//     setFormData({
//       ...formData,
//       [e.target.name]: e.target.value
//     });
//   };

//   const handleSubmit = async (e) => {
//     e.preventDefault();
    
//     // Validation de l'email
//     const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
//     if (!formData.email.trim()) {
//       showError('Veuillez entrer votre adresse email');
//       return;
//     }
    
//     if (!emailRegex.test(formData.email)) {
//       showError('Veuillez entrer une adresse email valide');
//       return;
//     }
    
//     if (!formData.motDePasse) {
//       showError('Veuillez entrer votre mot de passe');
//       return;
//     }

//     setLoading(true);

//     try {
//       // Envoi des données de connexion avec l'email uniquement
//       const result = await login(formData.email, formData.motDePasse);
//       showSuccess('Connexion réussie!');
      
//       setTimeout(() => {
//         if (result.user?.role === 'ALUMNI') {
//           navigate('/alumni/dashboard');
//         } else if (result.user?.role === 'ETUDIANT') {
//           navigate('/etudiant/dashboard');
//         } else {
//           navigate('/dashboard');
//         }
//       }, 100);
      
//     } catch (error) {
//       let errorMessage = error.message || 'Erreur de connexion';
      
//       if (errorMessage.includes('401') || errorMessage.toLowerCase().includes('incorrect')) {
//         errorMessage = 'Email ou mot de passe incorrect. Veuillez réessayer.';
//       } else if (errorMessage.includes('403')) {
//         errorMessage = 'Compte désactivé ou non vérifié. Veuillez vérifier votre email.';
//       } else if (errorMessage.includes('404')) {
//         errorMessage = 'Aucun compte trouvé avec cet email. Vérifiez votre email ou inscrivez-vous.';
//       }
      
//       showError(errorMessage);
//     } finally {
//       setLoading(false);
//     }
//   };

//   return (
//     <AuthLayout
//       title="Connexion"
//       subtitle="Accédez à votre espace personnel"
//     >
//       <form onSubmit={handleSubmit} className="space-y-6">
//         <div className="space-y-2">
//           <Input
//             label="Adresse Email"
//             type="email"
//             name="email"
//             value={formData.email}
//             onChange={handleChange}
//             placeholder="votre.email@example.com"
//             icon={Mail}
//             required
//           />
//           <p className="text-xs text-gray-500">
//             Utilisez l'adresse email avec laquelle vous vous êtes inscrit
//           </p>
//         </div>

//         <Input
//           label="Mot de passe"
//           type="password"
//           name="motDePasse"
//           value={formData.motDePasse}
//           onChange={handleChange}
//           placeholder="••••••••"
//           icon={Lock}
//           required
//         />

//         <div className="flex items-center justify-between">
//           <label className="flex items-center cursor-pointer">
//             <input
//               type="checkbox"
//               checked={rememberMe}
//               onChange={(e) => setRememberMe(e.target.checked)}
//               className="h-4 w-4 text-emerald-600 focus:ring-emerald-500 border-gray-300 rounded"
//             />
//             <span className="ml-2 text-sm text-gray-700">Se souvenir de moi</span>
//           </label>

//           <Link
//             to="/forgot-password"
//             className="text-sm text-emerald-600 hover:text-emerald-700 font-medium transition-colors"
//           >
//             Mot de passe oublié ?
//           </Link>
//         </div>

//         <button
//           type="submit"
//           disabled={!formData.email || !formData.motDePasse || loading}
//           className="w-full bg-emerald-600 hover:bg-emerald-700 text-white font-medium py-3 px-4 rounded-lg transition-colors disabled:opacity-50 disabled:cursor-not-allowed focus:outline-none focus:ring-2 focus:ring-emerald-500 focus:ring-offset-2"
//         >
//           {loading ? 'Connexion en cours...' : 'Se connecter'}
//         </button>

//         <div className="mt-6">
//           <div className="relative">
//             <div className="absolute inset-0 flex items-center">
//               <div className="w-full border-t border-gray-300" />
//             </div>
//             <div className="relative flex justify-center text-sm">
//               <span className="px-2 bg-white text-gray-500">Pas encore de compte ?</span>
//             </div>
//           </div>

//           <div className="mt-6">
//             <Link to="/register">
//               <button 
//                 type="button"
//                 className="w-full border-2 border-emerald-600 text-emerald-600 hover:bg-emerald-50 font-medium py-3 px-4 rounded-lg transition-colors"
//               >
//                 Créer un compte
//               </button>
//             </Link>
//             <p className="text-xs text-gray-500 text-center mt-2">
//               Choisissez votre type de compte (Étudiant ou Alumni) lors de l'inscription
//             </p>
//           </div>
//         </div>

//         {/* Liens rapides pour le développement */}
//         {process.env.NODE_ENV === 'development' && (
//           <div className="mt-4 p-3 bg-emerald-50 rounded-lg border border-emerald-200">
//             <p className="text-xs font-medium text-emerald-800 mb-2">💡 Développement - Comptes de test :</p>
//             <div className="grid grid-cols-2 gap-2 text-xs">
//               <button
//                 type="button"
//                 onClick={() => {
//                   setFormData({
//                     email: 'test@alumni.uasz.sn',
//                     motDePasse: 'password123'
//                   });
//                 }}
//                 className="p-2 bg-emerald-100 text-emerald-700 rounded hover:bg-emerald-200 transition-colors font-medium"
//               >
//                 Alumni test
//               </button>
//               <button
//                 type="button"
//                 onClick={() => {
//                   setFormData({
//                     email: 'test@etudiant.uasz.sn',
//                     motDePasse: 'password123'
//                   });
//                 }}
//                 className="p-2 bg-emerald-100 text-emerald-700 rounded hover:bg-emerald-200 transition-colors font-medium"
//               >
//                 Étudiant test
//               </button>
//             </div>
//           </div>
//         )}
//       </form>
//     </AuthLayout>
//   );
// };

import { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { Mail, Lock } from 'lucide-react';
import { AuthLayout } from '../../components/layout/AuthLayout';
import { Input } from '../../components/common/Input';
import { useAuth } from '../../hooks/useAuth';
import { useToast } from '../../hooks/useToast';

export const Login = () => {
  const navigate = useNavigate();
  const { login, userRole } = useAuth();
  const { showSuccess, showError } = useToast();

  const [formData, setFormData] = useState({
    email: '',
    motDePasse: ''
  });
  const [loading, setLoading] = useState(false);
  const [rememberMe, setRememberMe] = useState(false);

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    
    // Validation
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!formData.email.trim()) {
      showError('Veuillez entrer votre adresse email');
      return;
    }
    if (!emailRegex.test(formData.email)) {
      showError('Veuillez entrer une adresse email valide');
      return;
    }
    if (!formData.motDePasse) {
      showError('Veuillez entrer votre mot de passe');
      return;
    }

    setLoading(true);

    try {
      // Login → authService met à jour le contexte automatiquement
      await login(formData.email, formData.motDePasse);
      showSuccess('Connexion réussie!');

      // Navigation basée sur le rôle du contexte (mis à jour par authService)
      setTimeout(() => {
        if (userRole === 'ALUMNI') {
          navigate('/alumni/dashboard', { replace: true });
        } else if (userRole === 'ETUDIANT') {
          navigate('/etudiant/dashboard', { replace: true });
        } else {
          navigate('/dashboard', { replace: true });
        }
      }, 100);
      
    } catch (error) {
      let errorMessage = error.message || 'Erreur de connexion';
      
      if (errorMessage.includes('401') || errorMessage.toLowerCase().includes('incorrect')) {
        errorMessage = 'Email ou mot de passe incorrect. Veuillez réessayer.';
      } else if (errorMessage.includes('403')) {
        errorMessage = 'Compte désactivé ou non vérifié. Veuillez vérifier votre email.';
      } else if (errorMessage.includes('404')) {
        errorMessage = 'Aucun compte trouvé avec cet email. Vérifiez votre email ou inscrivez-vous.';
      }
      
      showError(errorMessage);
    } finally {
      setLoading(false);
    }
  };

  return (
    <AuthLayout
      title="Connexion"
      subtitle="Accédez à votre espace personnel"
    >
      <form onSubmit={handleSubmit} className="space-y-6">
        <div className="space-y-2">
          <Input
            label="Adresse Email"
            type="email"
            name="email"
            value={formData.email}
            onChange={handleChange}
            placeholder="votre.email@example.com"
            icon={Mail}
            required
          />
          <p className="text-xs text-gray-500">
            Utilisez l'adresse email avec laquelle vous vous êtes inscrit
          </p>
        </div>

        <Input
          label="Mot de passe"
          type="password"
          name="motDePasse"
          value={formData.motDePasse}
          onChange={handleChange}
          placeholder="••••••••"
          icon={Lock}
          required
        />

        <div className="flex items-center justify-between">
          <label className="flex items-center cursor-pointer">
            <input
              type="checkbox"
              checked={rememberMe}
              onChange={(e) => setRememberMe(e.target.checked)}
              className="h-4 w-4 text-emerald-600 focus:ring-emerald-500 border-gray-300 rounded"
            />
            <span className="ml-2 text-sm text-gray-700">Se souvenir de moi</span>
          </label>

          <Link
            to="/forgot-password"
            className="text-sm text-emerald-600 hover:text-emerald-700 font-medium transition-colors"
          >
            Mot de passe oublié ?
          </Link>
        </div>

        <button
          type="submit"
          disabled={!formData.email || !formData.motDePasse || loading}
          className="w-full bg-emerald-600 hover:bg-emerald-700 text-white font-medium py-3 px-4 rounded-lg transition-colors disabled:opacity-50 disabled:cursor-not-allowed focus:outline-none focus:ring-2 focus:ring-emerald-500 focus:ring-offset-2"
        >
          {loading ? 'Connexion en cours...' : 'Se connecter'}
        </button>

        <div className="mt-6">
          <div className="relative">
            <div className="absolute inset-0 flex items-center">
              <div className="w-full border-t border-gray-300" />
            </div>
            <div className="relative flex justify-center text-sm">
              <span className="px-2 bg-white text-gray-500">Pas encore de compte ?</span>
            </div>
          </div>

          <div className="mt-6">
            <Link to="/register">
              <button 
                type="button"
                className="w-full border-2 border-emerald-600 text-emerald-600 hover:bg-emerald-50 font-medium py-3 px-4 rounded-lg transition-colors"
              >
                Créer un compte
              </button>
            </Link>
            <p className="text-xs text-gray-500 text-center mt-2">
              Choisissez votre type de compte (Étudiant ou Alumni) lors de l'inscription
            </p>
          </div>
        </div>

        {/* Boutons de test développement */}
        {process.env.NODE_ENV === 'development' && (
          <div className="mt-4 p-3 bg-emerald-50 rounded-lg border border-emerald-200">
            <p className="text-xs font-medium text-emerald-800 mb-2">💡 Développement - Comptes de test :</p>
            <div className="grid grid-cols-2 gap-2 text-xs">
              <button
                type="button"
                onClick={() => {
                  setFormData({
                    email: 'test@alumni.uasz.sn',
                    motDePasse: 'password123'
                  });
                }}
                className="p-2 bg-emerald-100 text-emerald-700 rounded hover:bg-emerald-200 transition-colors font-medium"
              >
                Alumni test
              </button>
              <button
                type="button"
                onClick={() => {
                  setFormData({
                    email: 'test@etudiant.uasz.sn',
                    motDePasse: 'password123'
                  });
                }}
                className="p-2 bg-emerald-100 text-emerald-700 rounded hover:bg-emerald-200 transition-colors font-medium"
              >
                Étudiant test
              </button>
            </div>
          </div>
        )}
      </form>
    </AuthLayout>
  );
};
