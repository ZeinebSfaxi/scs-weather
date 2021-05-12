package com.infor.scs.interviews.services;

import com.infor.scs.interviews.domain.Icon;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class WeatherServiceTest {

    private WeatherService weatherService;

    @Before
    public void setup() {
        // TODO: Should be a singleton
        weatherService = new WeatherService();
    }

    @Test
    public void testGetIcons() {

        List<Icon> icons = weatherService.getAllIcons();
        Assert.assertEquals( "Incorrect number of icons", 34, icons.size() );
    }

}
