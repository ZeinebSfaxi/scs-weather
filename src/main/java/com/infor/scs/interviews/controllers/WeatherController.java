package com.infor.scs.interviews.controllers;

import com.infor.scs.interviews.domain.Icon;
import com.infor.scs.interviews.domain.Term;
import com.infor.scs.interviews.services.WeatherService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// TODO: Can you explain the difference between @Controller and @RestController?
@RestController
@RequestMapping( WeatherController.ROOT_URL )
public class WeatherController {

    // TODO: Why has this variable been declared static and final and would there be any reason to change it?
    public static final String ROOT_URL = "/api/weather";

    // TODO: Should be a singleton (https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch04s04.html)
    private final WeatherService weatherService = new WeatherService();

    @RequestMapping( "/icons" )
    public List<Icon> getIcons() {

        return weatherService.getAllIcons();
    }

    // TODO: Can you describe the API endpoint that this annotated method configures?
    @RequestMapping( "/glossary" )
    public List<Term> getGlossary( @RequestParam( required = false ) String searchTerm , @RequestParam( required = false ) String sort ) {

        // TODO: Would you change anything about this if block or the signatures for getGlossary or searchGlossary?
        if( searchTerm == null ) {
            return weatherService.getGlossary( sort );
        }
        else {
            return weatherService.searchGlossary( searchTerm, sort );
        }
    }

}
