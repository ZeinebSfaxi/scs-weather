package com.infor.scs.interviews.domain;

import java.util.HashMap;
import java.util.Map;

public class IconsResponse {

    private Map<String, Icon> icons = new HashMap<>();

    public Map<String, Icon> getIconsByName() {

        return icons;
    }

    public void setIconsByName( Map<String, Icon> iconsByName ) {

        this.icons = iconsByName;
    }
}