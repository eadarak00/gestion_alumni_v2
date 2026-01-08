import React, { useState, useEffect } from 'react'

export default function CVForm({ initialValues = {}, onSubmit }) {
  const [values, setValues] = useState({
    prenom: '',
    nom: '',
    titre: '',
    email: '',
    presentation: '',
    ...initialValues,
  })

  useEffect(() => setValues(v => ({ ...v, ...initialValues })), [initialValues])

  const handleChange = (e) => {
    const { name, value } = e.target
    setValues(prev => ({ ...prev, [name]: value }))
  }

  const submit = (e) => {
    e.preventDefault()
    if (onSubmit) onSubmit(values)
  }

  return (
    <form onSubmit={submit} style={{display: 'grid', gap: 8, maxWidth: 700}}>
      <div style={{display: 'flex', gap: 8}}>
        <input name="prenom" placeholder="Prénom" value={values.prenom || ''} onChange={handleChange} />
        <input name="nom" placeholder="Nom" value={values.nom || ''} onChange={handleChange} />
      </div>
      <input name="titre" placeholder="Titre / Poste" value={values.titre || ''} onChange={handleChange} />
      <input name="email" placeholder="Email" value={values.email || ''} onChange={handleChange} />
      <textarea name="presentation" placeholder="Présentation" value={values.presentation || ''} onChange={handleChange} rows={6} />
      <div>
        <button type="submit">Enregistrer</button>
      </div>
    </form>
  )
}
