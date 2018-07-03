package customerform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

@Configuration
public class JspViewResolverConfig {

//    @Value("${jsp.prefix}")
//    String jspPrefix;
//
//    @Value("${jsp.suffix}")
//    String jspSuffix;
//
//    @Bean
//    public ViewResolver jspViewResolver() {
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setPrefix(jspPrefix);
//        resolver.setSuffix(jspSuffix);
//        resolver.setOrder(1);
//        return resolver;
//    }

    @Value("${jsp.order}")
    int order;

    @Bean
    public TilesConfigurer tilesConfigurer() {
        TilesConfigurer tiles = new TilesConfigurer();
        tiles.setDefinitions(new String[] {
                "/WEB-INF/views/jsp/layout/tiles.xml"
        });
        tiles.setCheckRefresh(true);
        return tiles;
    }

    @Bean
    public ViewResolver jspViewResolver() {
        TilesViewResolver resolver = new TilesViewResolver();
        resolver.setOrder(order);
        return resolver;
    }
}
