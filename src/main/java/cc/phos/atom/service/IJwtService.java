package cc.phos.atom.service;

import cc.phos.atom.domain.dto.auth.LoginUserDTO;
import cc.phos.atom.domain.dto.auth.RegisterUserDTO;
import cc.phos.atom.domain.po.UserEntity;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Map;
import java.util.function.Function;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-29 14:46:12
 */
public interface IJwtService {
    String extractUsername(String token);

    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

    String generateToken(UserDetails userDetails);

    String generateToken(Map<String, Object> extraClaims, UserDetails userDetails);

    String generateRefreshToken(UserDetails userDetails);

    String generateRefreshToken(Map<String, Object> extraClaims, UserDetails userDetails);

    long getExpirationTime();

    long getRefreshExpirationTime();

    boolean isRefreshToken(String token);

    boolean isTokenValid(String token, UserDetails userDetails);

    boolean isRefreshTokenValid(String token);
}

