import React from "react";
import { Routes, Route, Navigate } from "react-router-dom";

import { Login } from "../pages/auth/Login";
import { RegisterPage } from "../pages/auth/RegisterPage";

import { AlumniDashboard } from "../pages/alumni/AlumniDashboard";
import { EtudiantDashboard } from "../pages/etudiant/EtudiantDashboard";

import { PublicRoute } from "./PublicRoute";
import { RoleRoute } from "./RoleRoute";

import { AlumniLayout } from "../components/layout/AlumniLayout";
import { EtudiantLayout } from "../components/layout/EtudiantLayout";
import { CvGenerator } from "../pages/etudiant/CvGenerator";

export const AppRoutes = () => {
  return (
    <Routes>
      {/* PUBLIC */}
      <Route element={<PublicRoute />}>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<RegisterPage />} />
      </Route>

      {/* ZONE ALUMNI (protégée + layout Alumni) */}
      <Route element={<RoleRoute allowedRole="ALUMNI" Layout={AlumniLayout} />}>
        <Route path="/alumni/dashboard" element={<AlumniDashboard />} />
        <Route path="/alumni/profile" element={<div>Profile Alumni</div>} />
        <Route path="/alumni/network" element={<div>Network Alumni</div>} />
      </Route>

      {/* ZONE ETUDIANT (protégée + layout Étudiant) */}
      <Route element={<RoleRoute allowedRole="ETUDIANT" Layout={EtudiantLayout} />}>
        <Route path="/etudiant/dashboard" element={<EtudiantDashboard />} />
        <Route path="/etudiant/profile" element={<div>Profile Étudiant</div>} />
        <Route path="/etudiant/discover-alumni" element={<div>Discover Alumni</div>} />
        <Route path="/etudiant/cv-generator" element={<CvGenerator />} />
      </Route>

      {/* ROOT / FALLBACK */}
      <Route path="/" element={<Navigate to="/login" replace />} />
      <Route path="*" element={<Navigate to="/login" replace />} />
    </Routes>
  );
};
