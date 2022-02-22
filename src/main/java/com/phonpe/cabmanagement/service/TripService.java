package com.phonpe.cabmanagement.service;

import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.trip.BookTripReqeust;
import com.phonpe.cabmanagement.dto.trip.BookTripResponse;
import com.phonpe.cabmanagement.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TripService
{
    @Autowired
    private TripRepository tripRepository;

    public CabApplicationResponse bookTrip(BookTripReqeust bookTripReqeust)
    {
        BookTripResponse bookTripResponse = BookTripResponse.builder().build();

        return bookTripResponse;
    }
}
