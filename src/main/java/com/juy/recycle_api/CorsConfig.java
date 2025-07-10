package com.juy.recycle_api;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
//import org.springframework.data.rest.core.config.RepositoryRestConfigurer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc
@Configuration
public class CorsConfig implements RepositoryRestConfigurer {
//public class CorsConfig implements WebMvcConfigurer {

//    @Override
//    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
//        // Definir la configuración de CORS para los endpoints generados por Spring Data REST
//        CorsConfiguration corsConfig = new CorsConfiguration();
//        corsConfig.addAllowedOrigin("http://localhost:5173"); // El origen de tu frontend
//        corsConfig.addAllowedMethod("GET");  // Métodos permitidos
//        corsConfig.addAllowedMethod("POST");
//        corsConfig.addAllowedMethod("PUT");
//        corsConfig.addAllowedMethod("DELETE");
//        corsConfig.addAllowedMethod("OPTIONS");
//        corsConfig.addAllowedHeader("*");  // Permite todos los headers
//        corsConfig.setAllowCredentials(true); // Si usas cookies o credenciales
//        corsConfig.setMaxAge(3600L); // Tiempo máximo para la pre-solicitud OPTIONS
//
//        // Aplica la configuración de CORS a los endpoints de Spring Data REST
//        config.setCorsConfiguration("/**", corsConfig);
//    }


    @Override
//    public void addCorsMappings(CorsRegistry registry) {
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration  registry, CorsRegistry cors) {

            // Permite peticiones desde el puerto 8080 (o cualquier otro dominio que uses para el frontend)
        cors.addMapping("/api/**")
                .allowedOrigins("*") // Cambia esto si tu frontend tiene otro dominio/puerto
                .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH") // Los métodos HTTP que quieres permitir
                .allowedHeaders("*"); // Permite todos los encabezados

        System.out.println("--------------------------------------------------------------------");
    }



//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        // Permite peticiones desde el puerto 3000 (o cualquier otro dominio que uses para el frontend)
//        registry.addMapping("/**")
//                .allowedMethods("*") // Los métodos HTTP que quieres permitir
//                .allowedOrigins("*") // Cambia esto si tu frontend tiene otro dominio/puerto
//                .allowedHeaders("*"); // Permite todos los encabezados
//    }
}
