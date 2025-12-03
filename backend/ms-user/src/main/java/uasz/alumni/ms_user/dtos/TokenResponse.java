package uasz.alumni.ms_user.dtos;

public record TokenResponse(
    String accessToken,
    String refreshToken,
    String tokenType,
    long expiresInSeconds
) {}