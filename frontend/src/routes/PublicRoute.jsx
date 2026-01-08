import React from "react";
import { Navigate, Outlet } from "react-router-dom";
import { useAuth } from "../hooks/useAuth";

export const PublicRoute = () => {
  const { isAuthenticated, loading, userRole } = useAuth();

  if (loading) return null;

  if (isAuthenticated) {
    if (userRole === "ALUMNI") return <Navigate to="/alumni/dashboard" replace />;
    if (userRole === "ETUDIANT") return <Navigate to="/etudiant/dashboard" replace />;
    return <Navigate to="/login" replace />;
  }

  return <Outlet />;
};
