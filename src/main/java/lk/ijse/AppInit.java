package lk.ijse;

import jakarta.servlet.MultipartConfigElement;
import jakarta.servlet.ServletRegistration;
import lk.ijse.config.WebAppConfig;
import lk.ijse.config.WebAppRootConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{WebAppRootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebAppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    // multipart form data managing -  must give the folder to process
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
            String tempDir = System.getProperty("java.io.tmpdir");
            registration.setMultipartConfig(new MultipartConfigElement(tempDir));
    }

}
