import React from "react";
import { Navigate, Outlet } from "react-router-dom";
import { useAuth } from "../hooks/useAuth";
import { Spinner } from "../components/common/Spinner";

export const RoleRoute = ({ allowedRole, Layout }) => {
  const { isAuthenticated, loading, userRole } = useAuth();

  if (loading) {
    return (
      <div className="min-h-screen flex items-center justify-center bg-gray-50">
        <Spinner size="large" />
      </div>
    );
  }

  if (!isAuthenticated) return <Navigate to="/login" replace />;

  if (userRole !== allowedRole) {
    const fallback = userRole === "ALUMNI" ? "/alumni/dashboard" : "/etudiant/dashboard";
    return <Navigate to={fallback} replace />;
  }

  return (
    <Layout>
      <Outlet />
    </Layout>
  );
};


