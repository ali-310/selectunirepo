package select.unit.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;


@Configuration
@EnableAutoConfiguration
@ComponentScan
@EnableSwagger2
@EnableWebMvc
public class swaggerCustomerConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry
                .addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry
                .addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
    @Bean
    public Docket CustomDucket(){

        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("select.unit"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo())
                .globalOperationParameters(
                        Arrays.asList(new ParameterBuilder()
                                .name("Authorization")
                                .description("Authorization Header")
                                        .modelRef(new ModelRef("string"))
                                .parameterType("header")
                                .required(true)
                                .build()  ) )


                  ;


    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("select unit info")
                .description("api Documentation")
                .version("1.0.0")
                .build();

    }
}
