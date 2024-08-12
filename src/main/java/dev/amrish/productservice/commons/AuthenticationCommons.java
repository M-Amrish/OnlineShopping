package dev.amrish.productservice.commons;

import dev.amrish.productservice.dto.UserDto;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthenticationCommons {

    private RestTemplate restTemplate;

    AuthenticationCommons(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public UserDto validateToken(String token){
        if(token == null){
            return null;
        }

        HttpHeaders header = new HttpHeaders();
        header.set("Authorization",token);

        HttpEntity<String> entity =new HttpEntity<>(header);


        ResponseEntity<UserDto> response
        = restTemplate.exchange(
                "http://localhost:8080/users/validate",
                HttpMethod.POST,
                entity,
                UserDto.class
        );


        return response.getBody();
    }
}
