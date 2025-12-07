import React, { useState } from 'react';
import PropTypes from 'prop-types';
import ChampTexte from '../commun/ChampTexte';
import ChampMotDePasse from '../commun/ChampMotDePasse';
import Bouton from '../commun/Bouton';
import Checkbox from '../commun/Checkbox';

const FormulaireConnexionAlumni = ({ onSuccess }) => {
    const [formData, setFormData] = useState({
        email: '',
        motDePasse: '',
        seSouvenir: false,
    });

    const [chargement, setChargement] = useState(false);
    const [erreur, setErreur] = useState('');

    const handleChange = (e) => {
        const { name, value, type, checked } = e.target;
        setFormData((prev) => ({
            ...prev,
            [name]: type === 'checkbox' ? checked : value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        setErreur('');
        setChargement(true);

        // Simulation d'appel API
        setTimeout(() => {
            setChargement(false);
            if (onSuccess) {
                onSuccess();
            }
        }, 1500);
    };

    return (
        <div className="w-full max-w-md mx-auto">
            <div className="mb-8">
                <h1 className="text-3xl font-bold text-gray-900 mb-2">
                    Connexion <span className="text-emerald-600">Alumni</span>
                </h1>
                <p className="text-gray-600 text-sm">
                    Accédez à votre espace réseau
                </p>
            </div>
            <form onSubmit={handleSubmit} className="space-y-6">
                <ChampTexte
                    label="Email ou nom d'utilisateur"
                    name="email"
                    type="text"
                    value={formData.email}
                    onChange={handleChange}
                    placeholder="votre-email@alumni.uasz.sn"
                    required
                />
                <ChampMotDePasse
                    label="Mot de passe"
                    name="motDePasse"
                    value={formData.motDePasse}
                    onChange={handleChange}
                    placeholder="••••••••••••"
                    required
                />
                <div className="flex items-center justify-between">
                    <Checkbox
                        name="seSouvenir"
                        checked={formData.seSouvenir}
                        onChange={handleChange}
                        label="Se souvenir de moi"
                    />
                    <a href="/mot-de-passe-oublie" className="text-sm text-emerald-600 hover:underline">
                        Mot de passe oublié ?
                    </a>
                </div>
                {erreur && (
                    <div className="p-3 rounded-lg text-sm bg-red-50 text-red-700">
                        {erreur}
                    </div>
                )}
                <Bouton
                    type="submit"
                    fullWidth
                    disabled={chargement}
                >
                    {chargement ? 'Connexion...' : 'Se connecter'}
                </Bouton>
                <p className="text-center text-sm text-gray-600">
                    Pas encore de compte?{' '}
                    <a href="/inscription-alumni" className="text-emerald-600 hover:underline font-medium">
                        S'inscrire
                    </a>
                </p>
            </form>
        </div>
    );
};

FormulaireConnexionAlumni.propTypes = {
    onSuccess: PropTypes.func,
};

export default FormulaireConnexionAlumni;
