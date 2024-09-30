package lk.ijse.config;

import jakarta.servlet.annotation.MultipartConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(basePackages = "lk.ijse")
@EnableWebMvc
@MultipartConfig(   // multipart configuration enabling
        fileSizeThreshold = 1024*1024*2, //
        maxFileSize = 1024*1024*5, //5mb must be in bits
        maxRequestSize = 1024*1024*10  //total size of the request including file sizes
)
public class WebAppConfig {
}
