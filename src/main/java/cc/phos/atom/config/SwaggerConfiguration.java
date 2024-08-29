package cc.phos.atom.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 *
 * </p>
 *
 * @author 骸
 * @since 2024-08-28 13:41:00
 */
@Configuration
public class SwaggerConfiguration {

    // @formatter:off
    @Bean
    public OpenAPI publicApi() {
        return new OpenAPI()
                .info(new Info().title("Atom API")
                        .description("Atom API")
                        .version("v0.0.1")
                        .license(new License().name("Apache 2.0").url("https://springdoc.org")));
    }
}
