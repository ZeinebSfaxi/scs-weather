package com.infor.scs.interviews.services;

import com.infor.scs.interviews.domain.Icon;
import com.infor.scs.interviews.domain.Term;
import com.infor.scs.interviews.interfaces.NationalWeatherServiceInterface;

import java.io.IOException;
import java.util.*;
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

    public List<Term> getGlossary(String sort) {
        List<Term> terms ;

        try {
            terms = nwsInterface.getGlossary()
                    .getTerms()
                    .stream()
                    .filter( (term) -> term.getTerm() != null  && term.getDefinition() != null )
                    .collect( Collectors.toList() );

                if(sort.equals("ASC")) {
                    terms.sort(Comparator.comparing((Term term) -> term.getTerm().toLowerCase()));
                }
                else if (sort.equals("DESC")) {
                    terms.sort(Comparator.comparing((Term term) -> term.getTerm().toLowerCase()).reversed());
                }
                return terms;
        } catch ( IOException e ) {
            return Collections.EMPTY_LIST;
        }
    }

    public List<Term> searchGlossary( String searchTerm, String sort ) {


        Predicate<Term> matchesSearchTerm = ( term ) ->
                term.getTerm().contains( searchTerm ) || term.getDefinition().contains( searchTerm );

        return getGlossary(sort)
                .stream()
                .filter( matchesSearchTerm )
                .collect( Collectors.toList() );
    }


}
