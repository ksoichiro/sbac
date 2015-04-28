package admin.console.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    // Required to enable resource handlers
    @Bean
    public ResourceUrlEncodingFilter resourceUrlEncodingFilter() {
        return new ResourceUrlEncodingFilter();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Files in the CSS and JS directories will be versioned
        VersionResourceResolver versionResolver = new VersionResourceResolver()
                .addContentVersionStrategy("/css/**", "/js/**");
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:static/")
                .setCachePeriod(null)
                .resourceChain(true)
                .addResolver(versionResolver);
    }
}
