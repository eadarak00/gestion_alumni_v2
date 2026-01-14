// src/pages/etudiant/CreationCV.jsx
import React from "react";
import { FilePlus } from "lucide-react";
import { UnderConstruction } from "../common/UnderConstruction";

export const CreationCV = () => {
    return (
        <UnderConstruction
            title="Création de CV"
            description="Utilisez notre outil de création de CV pour générer un CV professionnel en quelques minutes. Choisissez parmi plusieurs modèles et personnalisez-le selon vos besoins."
            icon={FilePlus}
        />
    );
};
