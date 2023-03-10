package uz.md.shopapp.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import uz.md.shopapp.controller.AuthController;
import uz.md.shopapp.controller.InstitutionTypeController;

import java.nio.file.Path;
import java.nio.file.Paths;

public interface AppConstants {

    String BASE_URL = "/api/v1/shop/";

    ObjectMapper objectMapper = new ObjectMapper();

    String AUTHORIZATION_HEADER = "Authorization";

    String AUTHENTICATION_HEADER = "Authentication";

    String[] OPEN_PAGES = {
            InstitutionTypeController.BASE_URL+"/**",
            AuthController.BASE_URL + "/**"
    };

    String[] SWAGGER_PAGES = {
            "/error",
            "/",
            "/favicon.ico",
            "//*.png",
            "//*.gif",
            "//*.svg",
            "//*.jpg",
            "//*.html",
            "//*.css",
            "//*.js",
            "/swagger-ui/**",
            "/swagger-ui/index.html",
            "/swagger-resources/",
            "/v3/api-docs/**",
            "/csrf",
            "/webjars/",
            "/v2/api-docs",
            "/configuration/ui"
    };

    String REQUEST_ATTRIBUTE_CURRENT_USER = "User";
    String REQUEST_ATTRIBUTE_CURRENT_USER_ID = "UserId";
    String REQUEST_ATTRIBUTE_CURRENT_USER_PERMISSIONS = "Permissions";

    /**
     * Regexes
     */
    String PhoneNumber_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    String PASSWORD_REGEX = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";

}
