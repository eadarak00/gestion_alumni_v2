import { useState, useEffect } from 'react';
import { fetchEtudiantCvData } from '../services/msUser/cvService';

export const useEtudiantCv = (etudiantId = null) => {
  const [cvData, setCvData] = useState(null);
  const [loading, setLoading] = useState(false);

  useEffect(() => {
    if (etudiantId) {
      setLoading(true);
      fetchEtudiantCvData(etudiantId)
        .then(data => {
          setCvData(data);
          setLoading(false);
        })
        .catch(() => setLoading(false));
    }
  }, [etudiantId]);

  return { cvData, loading, refetch: () => fetchEtudiantCvData(etudiantId).then(setCvData) };
};
