import { Routes, Route, Navigate } from 'react-router-dom';
import { Login } from '../pages/auth/Login';
import { RegisterPage } from '../pages/auth/RegisterPage';
import { Dashboard } from '../pages/dashboard/Dashboard';
import { AlumniDashboard } from '../pages/alumni/AlumniDashboard';     // ← NOUVEAU
import { EtudiantDashboard } from '../pages/etudiant/EtudiantDashboard';
import { PrivateRoute } from './PrivateRoute';
import { PublicRoute } from './PublicRoute';

export const AppRoutes = () => {
  return (
    <Routes>
      <Route element={<PublicRoute />}>
        <Route path="/login" element={<Login />} />
        {/* <Route path="/register/student" element={<RegisterStudent />} /> */}
        <Route path="/register" element={<RegisterPage />} />
      </Route>

      <Route element={<PrivateRoute />}>
        <Route path="/alumni/dashboard" element={<AlumniDashboard />} />
        <Route path="/etudiant/dashboard" element={<EtudiantDashboard />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/profile" element={<div>Profile Page</div>} />
        <Route path="/cv" element={<div>CV Page</div>} />
        <Route path="/academic" element={<div>Academic Page</div>} />
        <Route path="/experience" element={<div>Experience Page</div>} />
        <Route path="/network" element={<div>Network Page</div>} />
        <Route path="/invitations" element={<div>Invitations Page</div>} />
        <Route path="/settings" element={<div>Settings Page</div>} />
        <Route path="/studies" element={<div>Studies Page</div>} />
        <Route path="/discover-alumni" element={<div>Discover Alumni Page</div>} />
        <Route path="/mentorship" element={<div>Mentorship Page</div>} />
        <Route path="/events" element={<div>Events Page</div>} />
      </Route>

      <Route path="/" element={<Navigate to="/login" replace />} />

      <Route path="*" element={<Navigate to="/login" replace />} />
    </Routes>
  );
};
