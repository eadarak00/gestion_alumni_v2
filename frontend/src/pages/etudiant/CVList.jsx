import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'
import { getService } from '../../services/msCv'
import CVCard from '../../components/etudiant/CVCard'

export default function CVList() {
  const [cvs, setCvs] = useState([])
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    let mounted = true
    async function load() {
      try {
        const svc = getService()
        const res = await svc.cvsApi.getAllCVs()
        if (mounted) setCvs(res || [])
      } catch (err) {
        console.error('Failed to load CVs', err)
      } finally {
        if (mounted) setLoading(false)
      }
    }
    load()
    return () => (mounted = false)
  }, [])

  if (loading) return <div>Chargement des CVs...</div>

  return (
    <div>
      <div style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center'}}>
        <h2>Mes CVs</h2>
        <Link to="/etudiant/cvs/create">Créer un CV</Link>
      </div>
      <div>
        {cvs.length === 0 && <div>Aucun CV trouvé.</div>}
        {cvs.map((cv) => (
          <CVCard key={cv.id} cv={cv} />
        ))}
      </div>
    </div>
  )
}
