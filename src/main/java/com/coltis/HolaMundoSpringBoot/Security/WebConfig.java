
package com.coltis.HolaMundoSpringBoot.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 *
 * @Esta clase se encarga de crear configuraciones de la web, desde aqui creamos configraciones de la web
 */
@Configuration
public class WebConfig  implements WebMvcConfigurer{
    
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("/login");
        registro.addViewController("/errores/403").setViewName("/errores/403");
    
    }
}
