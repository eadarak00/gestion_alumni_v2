import React from "react";
import { Routes, Route, Navigate } from "react-router-dom";

import { Login } from "../pages/auth/Login";
import { RegisterPage } from "../pages/auth/RegisterPage";
import { CompleteProfile } from "../pages/complete-profile/CompleteProfile";

// Pages Alumni
import { AlumniDashboard } from "../pages/alumni/AlumniDashboard";
import { MonProfileAlumni } from "../pages/alumni/MonProfileAlumni";
import { NetworkAlumni } from "../pages/alumni/NetworkAlumni";
import { ParcoursAcademique } from "../pages/alumni/ParcoursAcademique";
import { ExperiencesPro } from "../pages/alumni/ExperiencesPro";
import { Invitations } from "../pages/alumni/Invitations";

// Pages Étudiant
import { EtudiantDashboard } from "../pages/etudiant/EtudiantDashboard";
import { MonProfileEtudiant } from "../pages/etudiant/MonProfileEtudiant";
import { DiscoverAlumni } from "../pages/etudiant/DiscoverAlumni";
import { CreationCV } from "../pages/etudiant/CreationCV";
import { MonCV } from "../pages/etudiant/MonCV";
import { MesAmis } from "../pages/etudiant/MesAmis";
import { Mentorat } from "../pages/etudiant/Mentorat";
import { Evenements } from "../pages/etudiant/Evenements";

// Pages Communes
import { Parametres } from "../pages/common/Parametres";

import { PublicRoute } from "./PublicRoute";
import { RoleRoute } from "./RoleRoute";

import { AlumniLayout } from "../components/layout/AlumniLayout";
import { EtudiantLayout } from "../components/layout/EtudiantLayout";

export const AppRoutes = () => {
  return (
    <Routes>
      {/* PUBLIC */}
      <Route element={<PublicRoute />}>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<RegisterPage />} />
      </Route>

      {/* COMPLETION PROFIL - Redirige vers dashboard */}
      <Route path="/complete-profile" element={<CompleteProfile />} />

      {/* ZONE ALUMNI (protégée + layout Alumni) */}
      <Route element={<RoleRoute allowedRole="ALUMNI" Layout={AlumniLayout} />}>
        <Route path="/alumni/dashboard" element={<AlumniDashboard />} />
        <Route path="/alumni/profile" element={<MonProfileAlumni />} />
        <Route path="/alumni/network" element={<NetworkAlumni />} />
        <Route path="/alumni/academic" element={<ParcoursAcademique />} />
        <Route path="/alumni/experience" element={<ExperiencesPro />} />
        <Route path="/alumni/invitations" element={<Invitations />} />
        <Route path="/alumni/settings" element={<Parametres />} />
        {/* Routes sans préfixe pour compatibilité avec le menu Alumni */}
        <Route path="/dashboard" element={<AlumniDashboard />} />
        <Route path="/profile" element={<MonProfileAlumni />} />
        <Route path="/academic" element={<ParcoursAcademique />} />
        <Route path="/experience" element={<ExperiencesPro />} />
        <Route path="/network" element={<NetworkAlumni />} />
        <Route path="/invitations" element={<Invitations />} />
        <Route path="/settings" element={<Parametres />} />
      </Route>

      {/* ZONE ETUDIANT (protégée + layout Étudiant) */}
      <Route element={<RoleRoute allowedRole="ETUDIANT" Layout={EtudiantLayout} />}>
        <Route path="/etudiant/dashboard" element={<EtudiantDashboard />} />
        <Route path="/etudiant/profile" element={<MonProfileEtudiant />} />
        <Route path="/etudiant/discover-alumni" element={<DiscoverAlumni />} />
        <Route path="/etudiant/friends" element={<MesAmis />} />
        <Route path="/etudiant/settings" element={<Parametres />} />
        {/* Routes sans préfixe pour compatibilité avec le menu Étudiant */}
        <Route path="/dashboard" element={<EtudiantDashboard />} />
        <Route path="/cv" element={<MonCV />} />
        <Route path="/discover-alumni" element={<DiscoverAlumni />} />
        <Route path="/mentorship" element={<Mentorat />} />
        <Route path="/events" element={<Evenements />} />
        <Route path="/creationcv" element={<CreationCV />} />
      </Route>

      {/* ROOT / FALLBACK */}
      <Route path="/" element={<Navigate to="/login" replace />} />
      <Route path="*" element={<Navigate to="/login" replace />} />
    </Routes>
  );
};
