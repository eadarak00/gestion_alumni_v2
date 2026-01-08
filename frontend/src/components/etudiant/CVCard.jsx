import React from 'react'
import { Link } from 'react-router-dom'

export default function CVCard({ cv }) {
  const fullName = [cv?.prenom, cv?.nom].filter(Boolean).join(' ')
  const title = cv?.titre || cv?.poste || cv?.intitule || ''

  return (
    <div style={{border: '1px solid #ddd', padding: 12, marginBottom: 8, borderRadius: 6}}>
      <div style={{display: 'flex', justifyContent: 'space-between'}}>
        <div>
          <div style={{fontWeight: '600'}}>{fullName || 'CV sans nom'}</div>
          {title && <div style={{color: '#666'}}>{title}</div>}
          {cv?.email && <div style={{color: '#666'}}>{cv.email}</div>}
        </div>
        <div style={{display: 'flex', gap: 8}}>
          <Link to={`/etudiant/cvs/${cv.id}`}>Voir</Link>
          <Link to={`/etudiant/cvs/${cv.id}/edit`}>Éditer</Link>
        </div>
      </div>
    </div>
  )
}
