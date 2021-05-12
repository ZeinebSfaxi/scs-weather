package com.infor.scs.interviews.domain;

public class Icon {

    private String name;
    private String description;

    public Icon( String name, String description ) {

        this.name = name;
        this.description = description;
    }

    public String getName() {

        return name;
    }

    public void setName( String name ) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription( String description ) {

        this.description = description;
    }

}
