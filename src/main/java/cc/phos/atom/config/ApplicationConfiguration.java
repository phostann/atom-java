package cc.phos.atom.config;

import cc.phos.atom.domain.po.UserEntity;
import cc.phos.atom.service.IUserService;
import cc.phos.atom.utils.PasswordUtils;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-29 15:19:57
 */
@Configuration
public class ApplicationConfiguration {
    @Resource
    private IUserService userService;

    @Bean
    UserDetailsService userDetailsService() {
        return username -> {
            UserEntity entity = userService.getByEmail(username);
            if (entity == null) {
                throw new UsernameNotFoundException("用户不存在");
            }
            return entity;
        };
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordUtils.getPasswordEncoder();
    }

    @Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
