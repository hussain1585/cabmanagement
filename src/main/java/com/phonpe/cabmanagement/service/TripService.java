package com.phonpe.cabmanagement.service;

import com.phonpe.cabmanagement.domain.Cab;
import com.phonpe.cabmanagement.domain.Rider;
import com.phonpe.cabmanagement.domain.Trip;
import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.trip.BookTripRequest;
import com.phonpe.cabmanagement.dto.trip.BookTripResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import com.phonpe.cabmanagement.enums.TripStatus;
import com.phonpe.cabmanagement.exception.UnRegisteredRiderException;
import com.phonpe.cabmanagement.exception.UnregisteredCabException;
import com.phonpe.cabmanagement.repository.CabRepository;
import com.phonpe.cabmanagement.repository.RiderRepository;
import com.phonpe.cabmanagement.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service
public class TripService
{
    @Autowired
    private TripRepository tripRepository;

    @Autowired
    private RiderRepository riderRepository;

    @Autowired
    private CabRepository cabRepository;

    public CabApplicationResponse bookTrip(BookTripRequest bookTripRequest)
    {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        BookTripResponse bookTripResponse = BookTripResponse.builder()
                .startLocation(bookTripRequest.getStartLocation())
                .bookedDestination(bookTripRequest.getBookedDestination())
                .rideStartDate(dateNow)
                .rideStartTime(timeNow)
                .RiderMobileNo(bookTripRequest.getRiderMobileNo())
                .CabRegistrationNumber(bookTripRequest.getCabRegistrationNumber())
                .bookTripStatus(ApplicationConstants.FAILURE)
                .build();

        String riderMobileNo = bookTripRequest.getRiderMobileNo();
        String cabRegistrationNumber = bookTripRequest.getCabRegistrationNumber();

        Optional<Rider> riderByMobileNo = riderRepository.findAllByMobileNo(riderMobileNo);
        Optional<Cab> cabByRegistrationNumber = cabRepository.findAllByRegistrationNumber(cabRegistrationNumber);

        if (riderByMobileNo.isEmpty())
        {
            throw new UnRegisteredRiderException(String.format("Rider with mobile no %s is not registered", riderMobileNo));
        }
        if (cabByRegistrationNumber.isEmpty())
        {
            throw new UnregisteredCabException(String.format("cab with registration No => %s is not registered", cabRegistrationNumber));
        }
        Rider rider = riderByMobileNo.get();
        Cab cab = cabByRegistrationNumber.get();
        Trip trip = Trip.builder()
                .startLocation(bookTripRequest.getStartLocation())
                .bookedDestination(bookTripRequest.getBookedDestination())
                .rideStartDate(dateNow)
                .rideStartTime(timeNow)
                .rider(rider)
                .cab(cab)
                .tripStatus(TripStatus.IN_JOURNEY)
                .build();

        tripRepository.save(trip);
        bookTripResponse.setBookTripStatus(ApplicationConstants.SUCCESS);

        return bookTripResponse;
    }
}
