import React, { useEffect, useState } from 'react'
import { useParams, Link } from 'react-router-dom'
import { getService } from '../../services/msCv'
import CVDetails from '../../components/etudiant/CVDetails'

export default function CVView() {
  const { id } = useParams()
  const [cv, setCv] = useState(null)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    let mounted = true
    async function load() {
      try {
        const svc = getService()
        const res = await svc.cvsApi.getCVComplet({ id })
        if (mounted) setCv(res)
      } catch (err) {
        console.error('Erreur chargement CV', err)
      } finally {
        if (mounted) setLoading(false)
      }
    }
    load()
    return () => (mounted = false)
  }, [id])

  if (loading) return <div>Chargement du CV...</div>
  if (!cv) return <div>CV introuvable</div>

  return (
    <div>
      <div style={{display: 'flex', justifyContent: 'space-between', alignItems: 'center'}}>
        <h2>Détails du CV</h2>
        <div>
          <Link to={`/etudiant/cvs/${id}/edit`}>Modifier</Link>
        </div>
      </div>
      <CVDetails cv={cv} />
    </div>
  )
}
