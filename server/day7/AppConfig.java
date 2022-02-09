package day7workshop.day7;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class AppConfig implements WebMvcConfigurer {
    
    @Override
    public void addCorsMappings(CorsRegistration reg) {
        reg.addMapping("/api/**");
    }
}
