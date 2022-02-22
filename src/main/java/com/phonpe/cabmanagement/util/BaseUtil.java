package com.phonpe.cabmanagement.util;

import com.phonpe.cabmanagement.domain.Location;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseUtil
{
    public double getDifferenceBetweenLocations(Location loc1, Location loc2)
    {

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        double lon1 = Math.toRadians(loc1.getLongitude());
        double lon2 = Math.toRadians(loc2.getLongitude());
        double lat1 = Math.toRadians(loc1.getLatitude());
        double lat2 = Math.toRadians(loc2.getLatitude());

        // Haversine formula
        double longitudeDifference = lon2 - lon1;
        double latitudeDifference = lat2 - lat1;
        double a = Math.pow(Math.sin(latitudeDifference / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(longitudeDifference / 2), 2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return (c * r);
    }
}
