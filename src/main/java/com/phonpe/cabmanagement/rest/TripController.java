package com.phonpe.cabmanagement.rest;

import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.trip.BookTripByGivenCabAndRiderRequest;
import com.phonpe.cabmanagement.dto.trip.BookTripRequest;
import com.phonpe.cabmanagement.service.TripService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TripController
{
    @Autowired
    private TripService tripService;

    @PostMapping("/trip/bookTripByGivenCabAndRider")
    public CabApplicationResponse bookTripByGivenCabAndRider(@RequestBody BookTripByGivenCabAndRiderRequest bookTripByGivenCabAndRiderRequest)
    {
        return tripService.bookTripByGivenCabAndRider(bookTripByGivenCabAndRiderRequest);
    }

    @PostMapping("/trip/bookTrip")
    public CabApplicationResponse bookTrip(@RequestBody BookTripRequest bookTripRequest)
    {
        return tripService.bookTrip(bookTripRequest);
    }
}
