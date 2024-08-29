package cc.phos.atom.utils;

import lombok.Getter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-04-23 15:38:50
 */
public class PasswordUtils {

    @Getter
    private final static PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 密码加密
     *
     * @param password
     * @return
     */
    public static String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }


    /**
     * 密码验证
     *
     * @param password
     * @param encodedPassword
     * @return
     */
    public static Boolean checkPassword(String password, String encodedPassword) {
        return passwordEncoder.matches(password, encodedPassword);
    }

}
