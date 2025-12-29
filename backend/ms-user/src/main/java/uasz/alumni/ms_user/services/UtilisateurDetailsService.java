package uasz.alumni.ms_user.services;

import lombok.RequiredArgsConstructor;
import uasz.alumni.ms_user.entities.Utilisateur;
import uasz.alumni.ms_user.repositories.UtilisateurRepository;
import uasz.alumni.ms_user.security.UtilisateurDetails;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UtilisateurDetailsService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Utilisateur utilisateur = utilisateurRepository.findByEmailAndDeletedFalse(email)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé : " + email));
        return new UtilisateurDetails(utilisateur);
    }
}
