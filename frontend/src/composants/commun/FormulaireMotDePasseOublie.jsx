import React, { useState } from 'react';
import ChampTexte from '../commun/ChampTexte';
import Bouton from '../commun/Bouton';
import { demanderReinitialisationMotDePasse } from '../../fonctionnalites/alumni/api/inscription.api';

const FormulaireMotDePasseOublie = () => {
    const [email, setEmail] = useState('');
    const [chargement, setChargement] = useState(false);
    const [message, setMessage] = useState(null);
    const [erreur, setErreur] = useState('');

    const handleSubmit = async (e) => {
        e.preventDefault();
        setChargement(true);
        setMessage(null);
        setErreur('');

        try {
            const res = await demanderReinitialisationMotDePasse(email);
            if (res.success) {
                setMessage(res.message);
            } else {
                setErreur(res.message || "Une erreur est survenue.");
            }
        } catch (err) {
            setErreur("Impossible de contacter le serveur.");
        } finally {
            setChargement(false);
        }
    };

    return (
        <div className="w-full max-w-md mx-auto">
            <div className="mb-8">
                <h1 className="text-3xl font-bold text-gray-900 mb-2">
                    Mot de passe <span className="text-emerald-600">oublié ?</span>
                </h1>
                <p className="text-gray-600 text-sm">
                    Entrez votre email pour recevoir un lien de réinitialisation.
                </p>
            </div>

            {message ? (
                <div className="bg-emerald-50 border border-emerald-200 rounded-lg p-6 text-center">
                    <div className="w-12 h-12 bg-emerald-100 rounded-full flex items-center justify-center mx-auto mb-4">
                        <svg className="w-6 h-6 text-emerald-600" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M5 13l4 4L19 7" />
                        </svg>
                    </div>
                    <h3 className="text-lg font-medium text-emerald-900 mb-2">Email envoyé !</h3>
                    <p className="text-emerald-700 text-sm mb-6">{message}</p>
                    <a href="/connexion-alumni" className="text-emerald-600 hover:text-emerald-700 font-medium text-sm">
                        Retour à la connexion
                    </a>
                </div>
            ) : (
                <form onSubmit={handleSubmit} className="space-y-6">
                    <ChampTexte
                        label="Email"
                        name="email"
                        type="email"
                        value={email}
                        onChange={(e) => setEmail(e.target.value)}
                        placeholder="votre-email@alumni.uasz.sn"
                        required
                    />

                    {erreur && (
                        <div className="p-3 rounded-lg text-sm bg-red-50 text-red-700">
                            {erreur}
                        </div>
                    )}

                    <Bouton type="submit" fullWidth disabled={chargement}>
                        {chargement ? 'Envoi en cours...' : 'Envoyer le lien'}
                    </Bouton>

                    <p className="text-center text-sm text-gray-600">
                        <a href="/connexion-alumni" className="text-gray-500 hover:text-gray-700 font-medium">
                            Retour à la connexion
                        </a>
                    </p>
                </form>
            )}
        </div>
    );
};

export default FormulaireMotDePasseOublie;
