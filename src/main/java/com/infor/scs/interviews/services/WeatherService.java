package com.infor.scs.interviews.services;

import com.infor.scs.interviews.domain.Icon;
import com.infor.scs.interviews.domain.Term;
import com.infor.scs.interviews.interfaces.NationalWeatherServiceInterface;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class WeatherService {

    // TODO: Should be a singleton shared by all services (https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch04s04.html)
    private final NationalWeatherServiceInterface nwsInterface = new NationalWeatherServiceInterface();

    public List<Icon> getAllIcons() {

        try {
            return nwsInterface.getIcons()
                    .getIconsByName()
                    .entrySet()
                    .stream()
                    .map( iconByName -> new Icon( iconByName.getKey(), iconByName.getValue().getDescription() ) )
                    .collect( Collectors.toList() );
        } catch ( IOException e ) {
            return Collections.EMPTY_LIST;
        }
    }

    public List<Term> getGlossary() {

        try {
            return nwsInterface.getGlossary().getTerms();
        } catch ( IOException e ) {
            return Collections.EMPTY_LIST;
        }
    }

    public List<Term> searchGlossary( String searchTerm ) {

        Predicate<Term> matchesSearchTerm = ( term ) ->
                term.getTerm().contains( searchTerm ) || term.getDefinition().contains( searchTerm );

        return getGlossary()
                .stream()
                .filter( matchesSearchTerm )
                .collect( Collectors.toList() );
    }
}
