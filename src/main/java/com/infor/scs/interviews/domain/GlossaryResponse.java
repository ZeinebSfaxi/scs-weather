package com.infor.scs.interviews.domain;

import java.util.ArrayList;
import java.util.List;

public class GlossaryResponse {

    private List<Term> glossary = new ArrayList<>();

    public List<Term> getTerms() {

        return glossary;
    }

    public void setTerms( List<Term> glossary ) {

        this.glossary = glossary;
    }
}