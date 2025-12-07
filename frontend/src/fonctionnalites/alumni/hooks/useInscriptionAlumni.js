import { useState } from 'react';
import { inscrireAlumni } from '../api/inscription.api';
import { validerFormulaireInscription } from '../utils/validationInscription';

export const useInscriptionAlumni = () => {
    const [chargement, setChargement] = useState(false);
    const [erreurs, setErreurs] = useState({});
    const [message, setMessage] = useState('');

    const soumettre = async (formData) => {
        setErreurs({});
        setMessage('');

        console.log('📋 Début de la soumission du formulaire Alumni');

        // --- VALIDATION LOCALE ---
        const validation = validerFormulaireInscription(formData);

        if (!validation.valide) {
            console.log('❌ Validation locale échouée:', validation.erreurs);
            setErreurs(validation.erreurs);
            return { success: false, errors: validation.erreurs };
        }

        console.log('✅ Validation locale réussie');

        setChargement(true);

        try {
            // On retire les champs non envoyés à l'API
            const { confirmationMotDePasse, accepteConditions, ...alumniData } = formData;

            // Conversion des types si nécessaire (ex: anneeDiplome en entier)
            if (alumniData.anneeDiplome) {
                alumniData.anneeDiplome = parseInt(alumniData.anneeDiplome, 10);
            }

            console.log('📤 Envoi des données à l\'API:', alumniData);

            // --- APPEL API ---
            const resultat = await inscrireAlumni(alumniData);

            console.log('📥 Réponse de l\'API:', resultat);

            setChargement(false);

            // --- SUCCÈS ---
            if (resultat.success) {
                console.log('✅ Inscription réussie !');
                setMessage('Inscription réussie ! Un code de validation a été envoyé à votre email.');

                return {
                    success: true,
                    data: resultat.data
                };
            }

            // --- ERREUR API RENVOYÉE ---
            console.log('❌ Échec de l\'inscription:', resultat.message);
            setMessage(resultat.message || "Une erreur s'est produite lors de l'inscription.");
            setErreurs(resultat.errors || {});

            return {
                success: false,
                message: resultat.message,
                errors: resultat.errors
            };

        } catch (error) {
            // --- ERREUR SYSTÈME INATTENDUE ---
            console.error("❌ Erreur inattendue lors de l'inscription Alumni :", error);

            setChargement(false);
            setMessage("Une erreur interne est survenue. Veuillez réessayer plus tard.");

            return {
                success: false,
                message: "Erreur interne"
            };
        }
    };

    return {
        chargement,
        erreurs,
        message,
        soumettre,
    };
};
