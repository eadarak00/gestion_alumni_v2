import { AuthProvider } from './contextes/ContexteAuth';
import RoutesApp from './routes/RoutesApp';

function App() {
  return (
    <AuthProvider>
      <RoutesApp />
    </AuthProvider>
  );
}

export default App;
