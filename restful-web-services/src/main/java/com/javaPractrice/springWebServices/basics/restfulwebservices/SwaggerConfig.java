package com.javaPractrice.springWebServices.basics.restfulwebservices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//Configuration
//Enable Swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    // setup API Info that you see on http://localhost:8080/v2/api-docs
    public static final Contact DEFAULT_CONTACT = new Contact("Shawn Fong", "www.shawnfong.com",
            "ShawnHFong@gmail.com");
    public static final ApiInfo DEFAULT_API_INFO = new ApiInfo("Custom API Title", "Custom Api Documentation", "1.0",
            "urn:tos", DEFAULT_CONTACT, "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",
            new ArrayList<VendorExtension>());
    private static final Set<String> DEFAULT_PRODUCES_AND_CONSUMES = new HashSet<String>(Arrays.asList("application/json", "application/xml"));
    // Bean - Docket
    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
            .apiInfo(DEFAULT_API_INFO)
            .produces(DEFAULT_PRODUCES_AND_CONSUMES); //users resource will now show consumes XML/JSON instead of just JSON
    }
    //Swagger 2
    //all the Paths
    //All the apis


}