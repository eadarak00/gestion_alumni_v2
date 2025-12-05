package uasz.alumni.ms_cv.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import uasz.alumni.ms_cv.entity.DemandeTelechargement;

public interface DemandeTelechargementRepository extends JpaRepository <DemandeTelechargement, Integer> {
    List<DemandeTelechargement> findByStatut(String statut);
   
} 
