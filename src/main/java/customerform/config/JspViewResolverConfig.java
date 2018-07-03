package customerform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class JspViewResolverConfig {

    @Value("${jsp.prefix}")
    String jspPrefix;

    @Value("${jsp.suffix}")
    String jspSuffix;

    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix(jspPrefix);
        resolver.setSuffix(jspSuffix);
        resolver.setOrder(1);
        return resolver;
    }
}
