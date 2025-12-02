package uasz.alumni.ms_user.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.common.exceptions.ResourceNotFoundException;
import uasz.alumni.ms_user.dtos.UtilisateurResponseDTO;
import uasz.alumni.ms_user.entities.Utilisateur;
import uasz.alumni.ms_user.mappers.UtilisateurMapper;
import uasz.alumni.ms_user.repositories.UtilisateurRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class UtilisateurService {

    private final UtilisateurRepository utilisateurRepository;
    private final UtilisateurMapper utilisateurMapper;

    /**
     * Récupération de tous les utilisateurs (y compris supprimés)
     */
    @Transactional(readOnly = true)
    public List<UtilisateurResponseDTO> getAllUtilisateurs() {
        return utilisateurRepository.findAll()
                .stream()
                .map(utilisateurMapper::toDto)
                .toList();
    }

    /**
     * Liste des utilisateurs non supprimés (soft delete)
     */
    @Transactional(readOnly = true)
    public List<UtilisateurResponseDTO> getUtilisateursNonSupprimes() {
        return utilisateurRepository.findByDeletedFalse()
                .stream()
                .map(utilisateurMapper::toDto)
                .toList();
    }

    /**
     * Récupérer un utilisateur par e-mail (non supprimé par défaut)
     */
    @Transactional(readOnly = true)
    public UtilisateurResponseDTO getUtilisateurDtoByEmail(@NonNull String email) {
        Utilisateur utilisateur = this.getUtilisateurEntityByEmail(email);
        return utilisateurMapper.toDto(utilisateur);
    }

    /**
     * Récupération d’un utilisateur (entité) par email — uniquement actif/non supprimé
     */
    @Transactional(readOnly = true)
    public Utilisateur getUtilisateurEntityByEmail(@NonNull String email) {
        return utilisateurRepository.findByEmailAndDeletedFalse(email)
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Utilisateur non trouvé ou supprimé avec l'email : " + email
                ));
    }

    /**
     * Vérifier l’existence d’un email
     */
    @Transactional(readOnly = true)
    public boolean emailExists(@NonNull String email) {
        return utilisateurRepository.existsByEmail(email);
    }

    /**
     * Vérifier l’existence d’un username
     */
    @Transactional(readOnly = true)
    public boolean usernameExists(@NonNull String username) {
        return utilisateurRepository.existsByUsername(username);
    }
}
