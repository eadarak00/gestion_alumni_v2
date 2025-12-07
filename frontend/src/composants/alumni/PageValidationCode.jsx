import React, { useState, useEffect, useRef } from 'react';
import PropTypes from 'prop-types';
import Bouton from '../commun/Bouton';

const PageValidationCode = ({ email, onValidationSuccess, onRetour }) => {
    const [code, setCode] = useState(['', '', '', '', '', '']);
    const [chargement, setChargement] = useState(false);
    const [message, setMessage] = useState('');
    const [typeMessage, setTypeMessage] = useState('');
    const [tempsRestant, setTempsRestant] = useState(900); // 900 secondes = 15 minutes
    const [peutRenvoyer, setPeutRenvoyer] = useState(false);
    const inputRefs = useRef([]);

    // Timer pour le renvoi du code
    useEffect(() => {
        if (tempsRestant > 0 && !peutRenvoyer) {
            const timer = setTimeout(() => {
                setTempsRestant(tempsRestant - 1);
            }, 1000);
            return () => clearTimeout(timer);
        } else if (tempsRestant === 0) {
            setPeutRenvoyer(true);
        }
    }, [tempsRestant, peutRenvoyer]);

    // Formater le temps en MM:SS
    const formatTemps = (secondes) => {
        const minutes = Math.floor(secondes / 60);
        const secs = secondes % 60;
        return `${minutes}:${secs.toString().padStart(2, '0')}`;
    };

    // Gérer la saisie du code
    const handleChange = (index, value) => {
        // Accepter uniquement les chiffres
        if (!/^\d*$/.test(value)) return;

        const nouveauCode = [...code];
        nouveauCode[index] = value;
        setCode(nouveauCode);

        // Passer au champ suivant si un chiffre est saisi
        if (value && index < 5) {
            inputRefs.current[index + 1]?.focus();
        }
    };

    // Gérer la suppression (Backspace)
    const handleKeyDown = (index, e) => {
        if (e.key === 'Backspace' && !code[index] && index > 0) {
            inputRefs.current[index - 1]?.focus();
        }
    };

    // Gérer le collage du code
    const handlePaste = (e) => {
        e.preventDefault();
        const pasteData = e.clipboardData.getData('text').replaceAll(/\D/g, '').slice(0, 6);
        const nouveauCode = [...code];

        for (let i = 0; i < pasteData.length; i++) {
            nouveauCode[i] = pasteData[i];
        }

        setCode(nouveauCode);

        // Focus sur le dernier champ rempli ou le suivant
        const nextIndex = Math.min(pasteData.length, 5);
        inputRefs.current[nextIndex]?.focus();
    };

    // Valider le code
    const handleValider = async () => {
        const codeComplet = code.join('');

        if (codeComplet.length !== 6) {
            setMessage('Veuillez entrer le code complet à 6 chiffres');
            setTypeMessage('error');
            return;
        }

        setChargement(true);
        setMessage('');

        try {
            // Import dynamique de l'API Alumni
            const { validerCode } = await import('../../fonctionnalites/alumni/api/inscription.api');
            const resultat = await validerCode(email, codeComplet);

            setChargement(false);

            if (resultat.success) {
                setMessage('Compte validé avec succès ! Redirection...');
                setTypeMessage('success');
                setTimeout(() => {
                    onValidationSuccess();
                }, 1500);
            } else {
                setMessage(resultat.message || '❌ Code invalide. Veuillez réessayer.');
                setTypeMessage('error');
                setCode(['', '', '', '', '', '']);
                inputRefs.current[0]?.focus();
            }
        } catch (error) {
            setChargement(false);
            setMessage('❌ Erreur lors de la validation');
            setTypeMessage('error');
            console.error(error);
        }
    };

    // Renvoyer le code
    const handleRenvoyer = async () => {
        if (!peutRenvoyer) return;

        setChargement(true);
        setMessage('');

        try {
            // Import dynamique de l'API Alumni
            const { renvoyerCode } = await import('../../fonctionnalites/alumni/api/inscription.api');
            const resultat = await renvoyerCode(email);

            setChargement(false);

            if (resultat.success) {
                setMessage('Nouveau code envoyé par email !');
                setTypeMessage('success');
                setCode(['', '', '', '', '', '']);
                setTempsRestant(900); // Réinitialiser à 15 minutes
                setPeutRenvoyer(false);
                inputRefs.current[0]?.focus();
            } else {
                setMessage(resultat.message || '❌ Impossible d\'envoyer un nouveau code');
                setTypeMessage('error');
            }
        } catch (error) {
            setChargement(false);
            setMessage('❌ Erreur lors de l\'envoi du code');
            setTypeMessage('error');
            console.error(error);
        }
    };

    const codeComplet = code.every(digit => digit !== '');

    return (
        <div className="min-h-screen bg-gradient-to-br from-emerald-50 via-white to-teal-50 flex items-center justify-center p-4">
            <div className="w-full max-w-md">
                {/* Card principale */}
                <div className="bg-white rounded-2xl shadow-xl p-8 space-y-6">
                    {/* Icône et badge */}
                    <div className="flex flex-col items-center space-y-4">
                        <div className="relative">
                            <div className="w-20 h-20 bg-gradient-to-br from-emerald-500 to-teal-600 rounded-full flex items-center justify-center shadow-lg">
                                <svg className="w-10 h-10 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M3 8l7.89 5.26a2 2 0 002.22 0L21 8M5 19h14a2 2 0 002-2V7a2 2 0 00-2-2H5a2 2 0 00-2 2v10a2 2 0 002 2z" />
                                </svg>
                            </div>
                            <div className="absolute -bottom-1 -right-1 w-7 h-7 bg-emerald-500 rounded-full flex items-center justify-center border-4 border-white">
                                <svg className="w-4 h-4 text-white" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                    <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={3} d="M5 13l4 4L19 7" />
                                </svg>
                            </div>
                        </div>

                        {/* Titre */}
                        <div className="text-center space-y-2">
                            <h1 className="text-3xl font-bold text-gray-900">
                                Vérifiez votre email
                            </h1>
                            <p className="text-gray-600 text-sm leading-relaxed">
                                Nous avons envoyé un code de vérification à
                            </p>
                            <p className="text-emerald-600 font-semibold text-base">
                                {email}
                            </p>
                        </div>
                    </div>

                    {/* Champs de code */}
                    <div className="space-y-3">
                        <label htmlFor="code-0" className="block text-sm font-medium text-gray-700 text-center">
                            Code de vérification
                        </label>
                        <div className="flex justify-center gap-2">
                            {code.map((digit, index) => {
                                const inputId = `code-${index}`;
                                return (
                                    <input
                                        key={inputId}
                                        id={inputId}
                                        ref={el => { inputRefs.current[index] = el; }}
                                        type="text"
                                        inputMode="numeric"
                                        maxLength={1}
                                        value={digit}
                                        onChange={(e) => handleChange(index, e.target.value)}
                                        onKeyDown={(e) => handleKeyDown(index, e)}
                                        onPaste={index === 0 ? handlePaste : undefined}
                                        disabled={chargement}
                                        className="w-12 h-14 text-center text-2xl font-bold border-2 border-gray-300 rounded-lg focus:border-emerald-500 focus:ring-2 focus:ring-emerald-200 transition-all outline-none disabled:bg-gray-50 disabled:cursor-not-allowed"
                                        autoFocus={index === 0}
                                        aria-label={`Chiffre ${index + 1} du code`}
                                    />
                                );
                            })}
                        </div>
                    </div>

                    {/* Message de feedback */}
                    {message && (
                        <div
                            role="alert"
                            className={`p-4 rounded-xl text-sm font-medium text-center transition-all ${typeMessage === 'success'
                                    ? 'bg-emerald-50 text-emerald-700 border border-emerald-200'
                                    : 'bg-red-50 text-red-700 border border-red-200'
                                }`}
                        >
                            {message}
                        </div>
                    )}

                    {/* Bouton de validation */}
                    <Bouton
                        onClick={handleValider}
                        disabled={!codeComplet || chargement}
                        fullWidth
                        variant="primary"
                        type="button"
                    >
                        {chargement ? (
                            <span className="flex items-center justify-center gap-2">
                                <svg className="animate-spin h-5 w-5" fill="none" viewBox="0 0 24 24">
                                    <circle className="opacity-25" cx="12" cy="12" r="10" stroke="currentColor" strokeWidth="4" />
                                    <path className="opacity-75" fill="currentColor" d="M4 12a8 8 0 018-8V0C5.373 0 0 5.373 0 12h4zm2 5.291A7.962 7.962 0 014 12H0c0 3.042 1.135 5.824 3 7.938l3-2.647z" />
                                </svg>
                                Vérification...
                            </span>
                        ) : (
                            'Vérifier et continuer'
                        )}
                    </Bouton>

                    {/* Section de renvoi */}
                    <div className="space-y-3">
                        <div className="flex items-center justify-center gap-2 text-sm text-gray-600">
                            <svg className="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z" />
                            </svg>
                            <span>
                                Vous n&apos;avez pas reçu le code ?
                            </span>
                        </div>

                        <button
                            type="button"
                            onClick={handleRenvoyer}
                            disabled={!peutRenvoyer || chargement}
                            className="w-full py-3 bg-white border-2 border-gray-300 text-gray-700 font-medium rounded-lg hover:border-emerald-500 hover:text-emerald-600 hover:bg-emerald-50 disabled:opacity-50 disabled:cursor-not-allowed disabled:hover:border-gray-300 disabled:hover:text-gray-700 disabled:hover:bg-white transition-all"
                            aria-label={peutRenvoyer ? 'Renvoyer le code' : `Renvoyer le code disponible dans ${formatTemps(tempsRestant)}`}
                        >
                            {peutRenvoyer ? (
                                'Renvoyer le code'
                            ) : (
                                <span className="flex items-center justify-center gap-2">
                                    Renvoyer le code
                                    {' '}
                                    <span className="inline-flex items-center justify-center min-w-[3.5rem] px-2.5 py-1 bg-gray-100 rounded-full text-xs font-mono text-gray-600 font-semibold">
                                        {formatTemps(tempsRestant)}
                                    </span>
                                </span>
                            )}
                        </button>
                    </div>

                    {/* Info supplémentaire */}
                    <div className="flex items-start gap-3 p-4 bg-blue-50 border border-blue-100 rounded-xl">
                        <svg className="w-5 h-5 text-blue-600 flex-shrink-0 mt-0.5" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M13 16h-1v-4h-1m1-4h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z" />
                        </svg>
                        <div className="text-xs text-blue-700 space-y-1">
                            <p className="font-semibold">Conseils :</p>
                            <ul className="space-y-0.5 list-disc list-inside">
                                <li>Le code est valide pendant 15 minutes</li>
                                <li>Vérifiez vos spams si vous ne le trouvez pas</li>
                            </ul>
                        </div>
                    </div>
                </div>

                {/* Lien retour */}
                {onRetour && (
                    <div className="mt-6 text-center">
                        <button
                            type="button"
                            onClick={onRetour}
                            className="text-sm text-gray-600 hover:text-emerald-600 font-medium transition-colors inline-flex items-center gap-2"
                        >
                            <svg className="w-4 h-4" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                                <path strokeLinecap="round" strokeLinejoin="round" strokeWidth={2} d="M10 19l-7-7m0 0l7-7m-7 7h18" />
                            </svg>
                            Retour à la connexion
                        </button>
                    </div>
                )}
            </div>
        </div>
    );
};

PageValidationCode.propTypes = {
    email: PropTypes.string.isRequired,
    onValidationSuccess: PropTypes.func.isRequired,
    onRetour: PropTypes.func,
};

PageValidationCode.defaultProps = {
    onRetour: null,
};

export default PageValidationCode;
