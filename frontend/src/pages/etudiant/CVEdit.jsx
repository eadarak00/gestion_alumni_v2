import React, { useEffect, useState } from 'react'
import { useParams, useNavigate } from 'react-router-dom'
import CVForm from '../../components/etudiant/CVForm'
import { getService } from '../../services/msCv'

export default function CVEdit() {
  const { id } = useParams()
  const navigate = useNavigate()
  const [initialValues, setInitialValues] = useState(null)
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    let mounted = true
    async function load() {
      try {
        const svc = getService()
        const res = await svc.cvsApi.getCVComplet({ id })
        if (mounted) setInitialValues(res)
      } catch (err) {
        console.error('Erreur chargement CV pour édition', err)
      } finally {
        if (mounted) setLoading(false)
      }
    }
    load()
    return () => (mounted = false)
  }, [id])

  const handleSubmit = async (values) => {
    try {
      const svc = getService()
      await svc.cvsApi.updateCV({ id, body: values })
      navigate(`/etudiant/cvs/${id}`)
    } catch (err) {
      console.error('Erreur mise à jour CV', err)
      alert('Erreur lors de la mise à jour du CV')
    }
  }

  if (loading) return <div>Chargement...</div>
  if (!initialValues) return <div>CV introuvable</div>

  return (
    <div>
      <h2>Modifier le CV</h2>
      <CVForm initialValues={initialValues} onSubmit={handleSubmit} />
    </div>
  )
}
