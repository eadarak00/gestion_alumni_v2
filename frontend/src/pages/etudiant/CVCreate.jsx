import React from 'react'
import { useNavigate } from 'react-router-dom'
import CVForm from '../../components/etudiant/CVForm'
import { getService } from '../../services/msCv'

export default function CVCreate() {
  const navigate = useNavigate()

  const handleSubmit = async (values) => {
    try {
      const svc = getService()
      const created = await svc.cvsApi.creerCV({ body: values })
      const id = created?.id || created
      navigate(`/etudiant/cvs/${id}`)
    } catch (err) {
      console.error('Erreur création CV', err)
      alert('Erreur lors de la création du CV')
    }
  }

  return (
    <div>
      <h2>Créer un CV</h2>
      <CVForm onSubmit={handleSubmit} />
    </div>
  )
}
