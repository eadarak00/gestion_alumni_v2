package uasz.alumni.ms_user.common.utils;

@Component
public class SecurityServiceUtils {

    public Long getAuthenticatedUserId() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return user.getId();
    }
}
