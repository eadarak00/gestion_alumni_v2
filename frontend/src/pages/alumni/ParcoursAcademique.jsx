// src/pages/alumni/ParcoursAcademique.jsx
import React from "react";
import { GraduationCap } from "lucide-react";
import { UnderConstruction } from "../common/UnderConstruction";

export const ParcoursAcademique = () => {
    return (
        <UnderConstruction
            title="Parcours Académique"
            description="Retrouvez et partagez votre parcours académique complet : formations, diplômes, certifications et réalisations universitaires."
            icon={GraduationCap}
        />
    );
};
