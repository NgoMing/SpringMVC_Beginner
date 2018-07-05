package customerform.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration.Dynamic;

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

    @Override
    // Configure for Multipart
    protected void customizeRegistration(Dynamic registration) {

        registration.setMultipartConfig(
                new MultipartConfigElement("C:/temp/", 4194304, 41943040, 0));
    }

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        super.onStartup(servletContext);
        servletContext.setInitParameter("spring.profiles.active", "hibernate-repository");
    }
}
