package customerform.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer
    extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    // Load application context of ContextLoaderListener
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RootConfig.class };
    }

    @Override
    // Load application context of DispatcherServlet
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebConfig.class };
    }

    @Override
    // Map dispatcherServlet to /
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
