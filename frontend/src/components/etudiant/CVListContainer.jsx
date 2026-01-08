import React from 'react'

export default function CVListContainer({ children }) {
  return (
    <div style={{display: 'grid', gap: 8}}>
      {children}
    </div>
  )
}
