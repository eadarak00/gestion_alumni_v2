import React, { useState } from 'react';
import PropTypes from 'prop-types';
import ChampTexte from '../commun/ChampTexte';
import ChampMotDePasse from '../commun/ChampMotDePasse';
import ListeDeroulante from '../commun/ListeDeroulante';
import Checkbox from '../commun/Checkbox';
import Bouton from '../commun/Bouton';
import { useInscriptionAlumni } from '../../fonctionnalites/alumni/hooks/useInscriptionAlumni';

const FormulaireInscriptionAlumni = ({ onSuccess }) => {
    const [formData, setFormData] = useState({
        prenom: '',
        nom: '',
        email: '',
        telephone: '',
        ville: '',
        profession: '',
        entreprise: '',
        filiere: '',
        niveau: '',
        anneeDiplome: '',
        motDePasse: '',
        confirmationMotDePasse: '',
        accepteConditions: false,
    });

    const { chargement, erreurs = {}, message, soumettre } = useInscriptionAlumni();

    const codesPays = [
        { code: '+221', flag: '🇸🇳', name: 'Sénégal' },
        { code: '+33', flag: '🇫🇷', name: 'France' },
        { code: '+1', flag: '🇺🇸', name: 'USA' },
        { code: '+1', flag: '🇨🇦', name: 'Canada' },
        { code: '+212', flag: '🇲🇦', name: 'Maroc' },
        { code: '+225', flag: '🇨🇮', name: 'Côte d\'Ivoire' },
        { code: '+223', flag: '🇲🇱', name: 'Mali' },
        { code: '+224', flag: '🇬🇳', name: 'Guinée' },
        { code: '+241', flag: '🇬🇦', name: 'Gabon' },
        { code: '+237', flag: '🇨🇲', name: 'Cameroun' },
    ];

    const [indicatif, setIndicatif] = useState('+221');
    const [numeroTelephone, setNumeroTelephone] = useState('');

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setFormData((prev) => ({
            ...prev,
            [name]: type === 'checkbox' ? checked : value,
        }));
    };

    const handleIndicatifChange = (e) => {
        const newIndicatif = e.target.value;
        setIndicatif(newIndicatif);
        setFormData(prev => ({
            ...prev,
            telephone: `${newIndicatif}${numeroTelephone}`
        }));
    };

    const handleTelephoneChange = (e) => {
        const val = e.target.value;
        setNumeroTelephone(val);
        setFormData(prev => ({
            ...prev,
            telephone: `${indicatif}${val}`
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        const resultat = await soumettre(formData);

        if (resultat.success && onSuccess) {
            onSuccess(resultat.data);
        }
    };

    const handleGoogleSignup = () => {
        console.log('Inscription avec Google');
    };

    const handleAppleSignup = () => {
        console.log('Inscription avec Apple');
    };

    return (
        <div className="w-full max-w-xl">
            {/* TITRE */}
            <div className="mb-8">
                <h1 className="text-3xl font-bold text-gray-900 mb-2">
                    Bienvenue dans votre
                    {' '}
                    <span className="text-emerald-600">Espace Alumni</span>
                </h1>
                <p className="text-gray-600 text-sm text-center">
                    Rejoignez le réseau des anciens et boostez votre carrière.
                </p>
            </div>

            {/* BOUTONS SOCIAUX */}
            <div className="flex gap-4 mb-6">
                <Bouton variant="google" onClick={handleGoogleSignup} fullWidth className="text-sm">
                    <svg className="w-5 h-5" viewBox="0 0 24 24">
                        <path fill="#4285F4" d="M22.56 12.25c0-.78-.07-1.53-.2-2.25H12v4.26h5.92c-.26 1.37-1.04 2.53-2.21 3.31v2.77h3.57c2.08-1.92 3.28-4.74 3.28-8.09z" />
                        <path fill="#34A853" d="M12 23c2.97 0 5.46-.98 7.28-2.66l-3.57-2.77c-.98.66-2.23 1.06-3.71 1.06-2.86 0-5.29-1.93-6.16-4.53H2.18v2.84C3.99 20.53 7.7 23 12 23z" />
                        <path fill="#FBBC05" d="M5.84 14.09c-.22-.66-.35-1.36-.35-2.09s.13-1.43.35-2.09V7.07H2.18C1.43 8.55 1 10.22 1 12s.43 3.45 1.18 4.93l2.85-2.22.81-.62z" />
                        <path fill="#EA4335" d="M12 5.38c1.62 0 3.06.56 4.21 1.64l3.15-3.15C17.45 2.09 14.97 1 12 1 7.7 1 3.99 3.47 2.18 7.07l3.66 2.84c.87-2.6 3.3-4.53 6.16-4.53z" />
                    </svg>
                    S'inscrire avec Google
                </Bouton>

                <Bouton variant="apple" onClick={handleAppleSignup} fullWidth className="text-sm">
                    <svg className="w-5 h-5" viewBox="0 0 24 24" fill="currentColor">
                        <path d="M17.05 20.28c-.98.95-2.05.8-3.08.35-1.09-.46-2.09-.48-3.24 0-1.44.62-2.2.44-3.06-.35C2.79 15.25 3.51 7.59 9.05 7.31c1.35.07 2.29.74 3.08.8 1.18-.24 2.31-.93 3.57-.84 1.51.12 2.65.72 3.4 1.8-3.12 1.87-2.38 5.98.48 7.13-.57 1.5-1.31 2.99-2.54 4.09z" />
                        <path d="M12.03 7.25c-.15-2.23 1.66-4.07 3.74-4.25.29 2.58-2.34 4.5-3.74 4.25z" />
                    </svg>
                    S'inscrire avec Apple
                </Bouton>
            </div>

            {/* SÉPARATEUR */}
            <div className="flex items-center gap-4 mb-6">
                <div className="flex-1 h-px bg-gray-300"></div>
                <span className="text-sm text-gray-500">Ou</span>
                <div className="flex-1 h-px bg-gray-300"></div>
            </div>

            {/* FORMULAIRE */}
            <form onSubmit={handleSubmit} className="space-y-4">

                {/* Nom / Prénom */}
                <div className="grid grid-cols-2 gap-4">
                    <ChampTexte
                        label="Prénom"
                        name="prenom"
                        value={formData.prenom}
                        onChange={handleChange}
                        placeholder="Votre prénom"
                        error={erreurs.prenom}
                        required
                    />
                    <ChampTexte
                        label="Nom"
                        name="nom"
                        value={formData.nom}
                        onChange={handleChange}
                        placeholder="Votre nom"
                        error={erreurs.nom}
                        required
                    />
                </div>

                {/* Info Contact */}
                <div className="grid grid-cols-2 gap-4">
                    <ChampTexte
                        label="Email"
                        name="email"
                        type="email"
                        value={formData.email}
                        onChange={handleChange}
                        placeholder="email@exemple.com"
                        error={erreurs.email}
                        required
                    />

                    {/* Champ Téléphone avec Indicatif */}
                    <div className="flex flex-col gap-1">
                        <label htmlFor="telephone" className="text-sm font-medium text-gray-700">
                            Téléphone <span className="text-red-500 ml-1">*</span>
                        </label>
                        <div className="flex gap-2">
                            <select
                                value={indicatif}
                                onChange={handleIndicatifChange}
                                className="w-24 px-2 py-2.5 border border-gray-300 rounded-lg focus:outline-none focus:ring-2 focus:ring-emerald-500 focus:border-transparent bg-white transition-all"
                            >
                                {codesPays.map((pays) => (
                                    <option key={pays.code} value={pays.code}>
                                        {pays.flag} {pays.code}
                                    </option>
                                ))}
                            </select>
                            <input
                                id="telephone"
                                name="numeroTelephone"
                                type="tel"
                                value={numeroTelephone}
                                onChange={handleTelephoneChange}
                                placeholder="77 000 00 00"
                                className={`flex-1 px-4 py-2.5 border rounded-lg focus:outline-none focus:ring-2 focus:ring-emerald-500 focus:border-transparent transition-all ${erreurs.telephone ? 'border-red-500' : 'border-gray-300'
                                    }`}
                                required
                            />
                        </div>
                        {erreurs.telephone && <span className="text-xs text-red-500">{erreurs.telephone}</span>}
                    </div>
                </div>

                {/* Ville */}
                <ChampTexte
                    label="Ville de résidence"
                    name="ville"
                    value={formData.ville}
                    onChange={handleChange}
                    placeholder="Ex: Dakar, Paris, New York"
                    error={erreurs.ville}
                    required
                />

                {/* Info Pro */}
                <div className="grid grid-cols-2 gap-4">
                    <ChampTexte
                        label="Profession actuelle"
                        name="profession"
                        value={formData.profession}
                        onChange={handleChange}
                        placeholder="Ex: Développeur Fullstack"
                        error={erreurs.profession}
                        required
                    />
                    <ChampTexte
                        label="Entreprise"
                        name="entreprise"
                        value={formData.entreprise}
                        onChange={handleChange}
                        placeholder="Ex: Orange, Free, Startup..."
                        error={erreurs.entreprise}
                        required
                    />
                </div>



                <ChampTexte
                    label="Année d'obtention du diplôme (Optionnel)"
                    name="anneeDiplome"
                    type="number"
                    value={formData.anneeDiplome}
                    onChange={handleChange}
                    placeholder="Ex: 2023"
                    error={erreurs.anneeDiplome}
                />

                {/* MOT DE PASSE */}
                <div className="grid grid-cols-2 gap-4">
                    <ChampMotDePasse
                        label="Mot de passe"
                        name="motDePasse"
                        value={formData.motDePasse}
                        onChange={handleChange}
                        placeholder="********"
                        error={erreurs.motDePasse}
                        required
                    />
                    <ChampMotDePasse
                        label="Confirmation"
                        name="confirmationMotDePasse"
                        value={formData.confirmationMotDePasse}
                        onChange={handleChange}
                        placeholder="********"
                        error={erreurs.confirmationMotDePasse}
                        required
                    />
                </div>

                {/* CONDITIONS */}
                <Checkbox
                    name="accepteConditions"
                    checked={formData.accepteConditions}
                    onChange={handleChange}
                    label={
                        <span>
                            J'accepte les
                            {' '}
                            <a href="/ConditionsUtilisation" className="text-emerald-600 hover:underline">
                                conditions d'utilisation
                            </a>
                        </span>
                    }
                    error={erreurs.accepteConditions}
                    required
                />

                {/* MESSAGE */}
                {message && (
                    <div
                        className={`p-3 rounded-lg text-sm ${message.includes('réussie')
                            ? 'bg-emerald-50 text-emerald-700'
                            : 'bg-red-50 text-red-700'
                            }`}
                    >
                        {message}
                    </div>
                )}

                {/* SUBMIT */}
                <Bouton type="submit" fullWidth disabled={chargement}>
                    {chargement ? 'Inscription en cours...' : "S'inscrire"}
                </Bouton>

                <p className="text-center text-sm text-gray-600">
                    Vous avez déjà un compte ?
                    {' '}
                    <a href="/connexion-alumni" className="text-emerald-600 hover:underline font-medium">
                        Connectez-vous
                    </a>
                </p>
            </form>
        </div>
    );
};

FormulaireInscriptionAlumni.propTypes = {
    onSuccess: PropTypes.func.isRequired,
};

export default FormulaireInscriptionAlumni;
