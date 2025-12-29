import { Navigate, Outlet } from 'react-router-dom';
import { useAuth } from '../hooks/useAuth';
import { Spinner } from '../components/common/Spinner';
import { AlumniLayout } from '../components/layout/AlumniLayout';
import { EtudiantLayout } from '../components/layout/EtudiantLayout';

export const PrivateRoute = () => {
  const { isAuthenticated, loading, userRole } = useAuth();

  if (loading) {
    return (
      <div className="min-h-screen flex items-center justify-center bg-gray-50">
        <Spinner size="large" />
      </div>
    );
  }

  if (!isAuthenticated) {
    return <Navigate to="/login" replace />;
  }

  const Layout = userRole === 'ALUMNI' ? AlumniLayout : EtudiantLayout;

  return (
    <Layout>
      <Outlet />
    </Layout>
  );
};
