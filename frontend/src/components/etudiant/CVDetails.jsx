import React from 'react'

export default function CVDetails({ cv }) {
  if (!cv) return null

  return (
    <div style={{display: 'grid', gap: 12}}>
      <section>
        <h3>Informations</h3>
        <div>{[cv.prenom, cv.nom].filter(Boolean).join(' ')}</div>
        {cv.titre && <div>{cv.titre}</div>}
        {cv.email && <div>{cv.email}</div>}
        {cv.presentation && <p>{cv.presentation}</p>}
      </section>

      {Array.isArray(cv.experiences) && cv.experiences.length > 0 && (
        <section>
          <h3>Expériences</h3>
          {cv.experiences.map((exp, i) => (
            <div key={i} style={{marginBottom: 8}}>
              <div style={{fontWeight: 600}}>{exp.intitule || exp.poste}</div>
              <div style={{color: '#555'}}>{exp.entreprise}</div>
              <div style={{color: '#777'}}>{exp.dateDebut} - {exp.dateFin || 'Aujourd\'hui'}</div>
            </div>
          ))}
        </section>
      )}

      {Array.isArray(cv.formations) && cv.formations.length > 0 && (
        <section>
          <h3>Formations</h3>
          {cv.formations.map((f, i) => (
            <div key={i}>
              <div style={{fontWeight: 600}}>{f.intitule}</div>
              <div style={{color: '#777'}}>{f.etablissement} — {f.annee}</div>
            </div>
          ))}
        </section>
      )}

      {Array.isArray(cv.competences) && cv.competences.length > 0 && (
        <section>
          <h3>Compétences</h3>
          <div>{cv.competences.map(c => c.nom || c).join(', ')}</div>
        </section>
      )}
    </div>
  )
}
