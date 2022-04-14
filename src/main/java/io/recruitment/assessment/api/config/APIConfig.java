package io.recruitment.assessment.api.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

/**
 * <p>Title       :   APIConfig
 * <p>Description :
 */
@Configuration
public class APIConfig {

  @Bean
  public WebMvcConfigurer webMvcConfigurer(){
      return new WebMvcConfigurer(){
        public void addInterceptors(InterceptorRegistry registry) {
          registry.addInterceptor(new AuthInterceptor());
        }
      };
  }
}

