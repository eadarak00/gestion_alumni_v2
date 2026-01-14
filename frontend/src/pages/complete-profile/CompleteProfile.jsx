// src/pages/complete-profile/CompleteProfile.jsx
// Ce composant redirige maintenant vers le dashboard car la complétion de profil
// se fait lors de l'inscription (après validation du code email)

import React, { useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../hooks/useAuth";
import { Spinner } from "../../components/common/Spinner";

export const CompleteProfile = () => {
  const { user, userRole, isAuthenticated } = useAuth();
  const navigate = useNavigate();

  useEffect(() => {
    // Si l'utilisateur n'est pas authentifié, rediriger vers login
    if (!isAuthenticated) {
      navigate("/login", { replace: true });
      return;
    }

    // Sinon, rediriger vers le dashboard approprié
    const dashboardUrl = userRole === "ALUMNI"
      ? "/alumni/dashboard"
      : "/etudiant/dashboard";

    navigate(dashboardUrl, { replace: true });
  }, [isAuthenticated, userRole, navigate]);

  // Afficher un spinner pendant la redirection
  return (
    <div className="min-h-screen flex items-center justify-center bg-gray-50">
      <div className="text-center">
        <Spinner size="lg" />
        <p className="mt-4 text-gray-600">Redirection en cours...</p>
      </div>
    </div>
  );
};
