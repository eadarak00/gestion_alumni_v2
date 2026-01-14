// src/pages/etudiant/Mentorat.jsx
import React from "react";
import { GraduationCap } from "lucide-react";
import { UnderConstruction } from "../common/UnderConstruction";

export const Mentorat = () => {
    return (
        <UnderConstruction
            title="Mentorat"
            description="Trouvez un mentor parmi les alumni ou devenez mentor pour accompagner d'autres étudiants. Un programme d'accompagnement personnalisé arrive bientôt."
            icon={GraduationCap}
        />
    );
};
