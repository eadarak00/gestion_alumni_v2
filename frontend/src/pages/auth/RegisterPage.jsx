import { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';
import { User, Mail, Lock, Phone, UserCircle, GraduationCap, CheckCircle, ArrowRight } from 'lucide-react';
import { AuthLayout } from '../../components/layout/AuthLayout';
import { Input } from '../../components/common/Input';
import { Button } from '../../components/common/Button';
import { useToast } from '../../hooks/useToast';
import { authService } from '../../services/msUser/authService';
import { validationService } from '../../services/msUser/validationService';

export const RegisterPage = () => {
  const navigate = useNavigate();
  const { showSuccess, showError } = useToast();

  const [step, setStep] = useState(1);
  const [loading, setLoading] = useState(false);
  
  const [formData, setFormData] = useState({
    nom: '',
    prenom: '',
    email: '',
    username: '',
    motDePasse: '',
    confirmPassword: '',
    telephone: '',
    role: ''
  });
  
  const [validationCode, setValidationCode] = useState('');

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!formData.role) {
      showError('Veuillez sélectionner un type de compte');
      return;
    }

    if (formData.motDePasse !== formData.confirmPassword) {
      showError('Les mots de passe ne correspondent pas');
      return;
    }

    if (formData.motDePasse.length < 8) {
      showError('Le mot de passe doit contenir au moins 8 caractères');
      return;
    }

    const phoneRegex = /^(\+221|00221)?[0-9]{9}$/;
    const cleanedPhone = formData.telephone.replace(/\s/g, '');
    if (!phoneRegex.test(cleanedPhone)) {
      showError('Format de téléphone invalide (ex: +221 77 123 45 67)');
      return;
    }

    setLoading(true);

    try {
      const userData = {
        nom: formData.nom.trim(),
        prenom: formData.prenom.trim(),
        email: formData.email.trim().toLowerCase(),
        username: formData.username.trim() || formData.email.trim(),
        motDePasse: formData.motDePasse,
        telephone: cleanedPhone,
        role: formData.role
      };

      await authService.registerUser(userData);
      await validationService.sendValidationCode(userData.email);

      showSuccess('Inscription réussie! Vérifiez votre email pour le code de validation.');
      setStep(2);
    } catch (error) {
      console.error('Erreur inscription:', error);
      
      let errorMessage = 'Erreur lors de l\'inscription';
      
      if (error.response?.body?.message) {
        errorMessage = error.response.body.message;
      } else if (error.message) {
        errorMessage = error.message;
      }
      
      if (errorMessage.toLowerCase().includes('email')) {
        errorMessage = 'Cet email est déjà utilisé';
      } else if (errorMessage.toLowerCase().includes('username')) {
        errorMessage = 'Ce nom d\'utilisateur est déjà utilisé';
      } else if (errorMessage.toLowerCase().includes('telephone')) {
        errorMessage = 'Ce numéro de téléphone est déjà utilisé';
      }
      
      showError(errorMessage);
    } finally {
      setLoading(false);
    }
  };

  const handleValidation = async (e) => {
    e.preventDefault();
    
    if (!validationCode || validationCode.length !== 6) {
      showError('Veuillez entrer un code de validation à 6 chiffres');
      return;
    }

    setLoading(true);

    try {
      const timeoutPromise = new Promise((_, reject) => {
        setTimeout(() => reject(new Error('Timeout - la validation a pris trop de temps')), 10000);
      });

      const validationPromise = validationService.verifyValidationCode(
        formData.email, 
        validationCode
      );

      const result = await Promise.race([validationPromise, timeoutPromise]);

      const successIndicators = ['valid', 'success', 'ok', 'true', '200', 'validé', 'succès'];
      const resultStr = String(result).toLowerCase();
      
      let isSuccess = false;
      
      if (typeof result === 'string') {
        isSuccess = successIndicators.some(indicator => resultStr.includes(indicator));
      } else if (typeof result === 'object' && result !== null) {
        const resultJson = JSON.stringify(result).toLowerCase();
        isSuccess = successIndicators.some(indicator => resultJson.includes(indicator));
      }
      
      if (isSuccess) {
        showSuccess('Compte activé avec succès! Vous pouvez maintenant vous connecter.');
        
        setTimeout(() => {
          navigate('/login');
        }, 1500);
      } else {
        showError(`Réponse inattendue: ${result}`);
      }
      
    } catch (error) {
      console.error('Erreur validation complète:', error);
      
      let errorMessage = 'Code de validation invalide ou expiré';
      
      if (error.message.includes('Timeout')) {
        errorMessage = 'La validation a pris trop de temps. Veuillez réessayer.';
      } else if (error.response) {
        if (error.response.status === 400) {
          errorMessage = 'Code incorrect ou expiré';
        } else if (error.response.status === 404) {
          errorMessage = 'Email non trouvé';
        } else if (error.response.status === 500) {
          errorMessage = 'Erreur serveur. Veuillez réessayer plus tard.';
        }
      }
      
      showError(errorMessage);
    } finally {
      setLoading(false);
    }
  };

  const handleResendCode = async () => {
    setLoading(true);
    try {
      await validationService.sendValidationCode(formData.email);
      showSuccess('Un nouveau code a été envoyé à votre email');
    } catch (error) {
      console.error('Erreur renvoi code:', error);
      showError('Erreur lors de l\'envoi du code. Veuillez réessayer.');
    } finally {
      setLoading(false);
    }
  };

  // Étape 2 - Validation
  if (step === 2) {
    return (
      <AuthLayout
        title="Validation du compte"
        subtitle="Entrez le code reçu par email"
      >
        <div className="space-y-6">
          <div className="text-center p-6 bg-emerald-50 rounded-xl border border-emerald-100">
            <div className="w-16 h-16 bg-emerald-100 rounded-full flex items-center justify-center mx-auto mb-4">
              <Mail className="w-8 h-8 text-emerald-600" />
            </div>
            <p className="text-gray-700 mb-2">
              Un code de validation à 6 chiffres a été envoyé à
            </p>
            <p className="font-semibold text-emerald-700 text-lg">
              {formData.email}
            </p>
            <p className="text-xs text-gray-500 mt-3 flex items-center justify-center gap-2">
              <span className="w-2 h-2 bg-emerald-500 rounded-full animate-pulse"></span>
              Le code expire après 10 minutes
            </p>
          </div>

          <form onSubmit={handleValidation} className="space-y-6">
            <div>
              <Input
                label="Code de validation"
                type="text"
                name="code"
                value={validationCode}
                onChange={(e) => setValidationCode(e.target.value.replace(/\D/g, ''))}
                placeholder="000000"
                maxLength={6}
                required
                className="text-center text-2xl tracking-widest font-mono"
              />
              <p className="text-xs text-gray-500 mt-2 text-center">
                Saisissez les 6 chiffres reçus par email
              </p>
            </div>

            <button
              type="submit"
              disabled={validationCode.length !== 6 || loading}
              className="w-full bg-emerald-600 hover:bg-emerald-700 text-white font-medium py-3 px-4 rounded-lg transition-colors disabled:opacity-50 disabled:cursor-not-allowed flex items-center justify-center gap-2"
            >
              {loading ? (
                'Validation en cours...'
              ) : validationCode.length === 6 ? (
                <>
                  <CheckCircle className="w-5 h-5" />
                  Valider mon compte
                </>
              ) : (
                'Entrez 6 chiffres'
              )}
            </button>

            <div className="flex flex-col items-center gap-3 pt-4 border-t border-gray-200">
              <button
                type="button"
                onClick={handleResendCode}
                disabled={loading}
                className="text-sm text-emerald-600 hover:text-emerald-700 font-medium transition-colors disabled:opacity-50"
              >
                Renvoyer le code
              </button>
              
              <button
                type="button"
                onClick={() => setStep(1)}
                className="text-sm text-gray-600 hover:text-gray-700 transition-colors"
                disabled={loading}
              >
                ← Retour à l'inscription
              </button>
            </div>
          </form>
        </div>
      </AuthLayout>
    );
  }

  // Étape 1 - Inscription
  return (
    <AuthLayout
      title="Créer un compte"
      subtitle="Rejoignez la communauté UASZ Alumni"
    >
      <form onSubmit={handleSubmit} className="space-y-6">
        {/* Section compacte : Type de compte */}
        <div className="bg-gray-50 p-4 rounded-lg border border-gray-200">
          <h3 className="text-sm font-semibold text-gray-700 mb-3">Type de compte</h3>
          <div className="grid grid-cols-2 gap-3">
            <label className={`flex items-center gap-3 p-3 rounded-lg cursor-pointer transition-all ${
              formData.role === 'ALUMNI'
                ? 'bg-emerald-500 text-white'
                : 'bg-white border border-gray-300 hover:border-emerald-400'
            }`}>
              <input
                type="radio"
                name="role"
                value="ALUMNI"
                checked={formData.role === 'ALUMNI'}
                onChange={handleChange}
                className="sr-only"
              />
              <GraduationCap className="w-5 h-5" />
              <div>
                <p className="font-medium text-sm">Alumni</p>
                <p className="text-xs opacity-80">Ancien diplômé</p>
              </div>
            </label>

            <label className={`flex items-center gap-3 p-3 rounded-lg cursor-pointer transition-all ${
              formData.role === 'ETUDIANT'
                ? 'bg-emerald-500 text-white'
                : 'bg-white border border-gray-300 hover:border-emerald-400'
            }`}>
              <input
                type="radio"
                name="role"
                value="ETUDIANT"
                checked={formData.role === 'ETUDIANT'}
                onChange={handleChange}
                className="sr-only"
              />
              <UserCircle className="w-5 h-5" />
              <div>
                <p className="font-medium text-sm">Étudiant</p>
                <p className="text-xs opacity-80">Étudiant actuel</p>
              </div>
            </label>
          </div>
        </div>

        {/* Section compacte : Informations personnelles */}
        <div className="space-y-4">          
          <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
            <Input
              label="Prénom"
              type="text"
              name="prenom"
              value={formData.prenom}
              onChange={handleChange}
              placeholder="Prenom"
              icon={User}
              required
            />

            <Input
              label="Nom"
              type="text"
              name="nom"
              value={formData.nom}
              onChange={handleChange}
              placeholder="Nom"
              required
            />
          </div>

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

          <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
            <Input
              label="Nom d'utilisateur"
              type="text"
              name="username"
              value={formData.username}
              onChange={handleChange}
              placeholder="username"
              icon={User}
            />

            <Input
              label="Numéro de Téléphone"
              type="tel"
              name="telephone"
              value={formData.telephone}
              onChange={handleChange}
              placeholder="+221 77 123 45 67"
              icon={Phone}
              required
            />
          </div>
        </div>

        {/* Section compacte : Sécurité */}
        <div className="space-y-4">          
          <div className="grid grid-cols-1 md:grid-cols-2 gap-4">
            <Input
              label="Mot de passe"
              type="password"
              name="motDePasse"
              value={formData.motDePasse}
              onChange={handleChange}
              placeholder="••••••••"
              icon={Lock}
              required
              minLength={8}
            />

            <Input
              label="Confirmation"
              type="password"
              name="confirmPassword"
              value={formData.confirmPassword}
              onChange={handleChange}
              placeholder="••••••••"
              required
              minLength={8}
            />
          </div>

          {/* Indicateurs de sécurité inline */}
          <div className="flex flex-wrap gap-4 text-xs">
            <div className={`flex items-center gap-2 px-3 py-1.5 rounded-full ${
              formData.motDePasse.length >= 8 
                ? 'bg-emerald-100 text-emerald-700' 
                : 'bg-gray-100 text-gray-500'
            }`}>
              <span className={`w-2 h-2 rounded-full ${
                formData.motDePasse.length >= 8 ? 'bg-emerald-500' : 'bg-gray-400'
              }`}></span>
              8+ caractères
            </div>
            <div className={`flex items-center gap-2 px-3 py-1.5 rounded-full ${
              formData.motDePasse === formData.confirmPassword && formData.motDePasse 
                ? 'bg-emerald-100 text-emerald-700' 
                : 'bg-gray-100 text-gray-500'
            }`}>
              <span className={`w-2 h-2 rounded-full ${
                formData.motDePasse === formData.confirmPassword && formData.motDePasse 
                  ? 'bg-emerald-500' 
                  : 'bg-gray-400'
              }`}></span>
              Correspondance
            </div>
          </div>
        </div>

        {/* Conditions et bouton */}
        <div className="space-y-4">
          <div className="flex items-start">
            <input
              type="checkbox"
              required
              className="h-4 w-4 mt-0.5 text-emerald-600 focus:ring-emerald-500 border-gray-300 rounded"
              id="terms"
            />
            <label htmlFor="terms" className="ml-3 text-sm text-gray-700">
              J'accepte les{' '}
              <Link to="/terms" className="text-emerald-600 hover:text-emerald-700 font-medium">
                conditions d'utilisation
              </Link>
              {' '}et la{' '}
              <Link to="/privacy" className="text-emerald-600 hover:text-emerald-700 font-medium">
                politique de confidentialité
              </Link>
            </label>
          </div>

          <button
            type="submit"
            disabled={loading}
            className="w-full bg-gradient-to-r from-emerald-600 to-emerald-700 hover:from-emerald-700 hover:to-emerald-800 text-white font-semibold py-3 px-4 rounded-lg transition-all disabled:opacity-50 disabled:cursor-not-allowed flex items-center justify-center gap-2 shadow-md hover:shadow-lg"
          >
            {loading ? (
              <span className="flex items-center gap-2">
                <div className="w-4 h-4 border-2 border-white border-t-transparent rounded-full animate-spin"></div>
                Inscription en cours...
              </span>
            ) : (
              <>
                Créer mon compte
                <ArrowRight className="w-5 h-5" />
              </>
            )}
          </button>

          <div className="text-center pt-2">
            <p className="text-sm text-gray-600">
              Vous avez déjà un compte ?{' '}
              <Link to="/login" className="text-emerald-600 hover:text-emerald-700 font-semibold transition-colors">
                Se connecter
              </Link>
            </p>
          </div>
        </div>
      </form>
    </AuthLayout>
  );
};