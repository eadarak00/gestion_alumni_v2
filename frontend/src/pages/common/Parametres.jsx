// src/pages/common/Parametres.jsx
import React from "react";
import { Settings } from "lucide-react";
import { UnderConstruction } from "./UnderConstruction";

export const Parametres = () => {
    return (
        <UnderConstruction
            title="Paramètres"
            description="Personnalisez votre compte : notifications, confidentialité, sécurité, préférences d'affichage et gestion des données personnelles."
            icon={Settings}
        />
    );
};
