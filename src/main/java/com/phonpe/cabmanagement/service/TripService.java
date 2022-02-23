package com.phonpe.cabmanagement.service;

import com.phonpe.cabmanagement.domain.Cab;
import com.phonpe.cabmanagement.domain.Location;
import com.phonpe.cabmanagement.domain.Rider;
import com.phonpe.cabmanagement.domain.Trip;
import com.phonpe.cabmanagement.dto.CabApplicationResponse;
import com.phonpe.cabmanagement.dto.trip.BookTripByGivenCabAndRiderRequest;
import com.phonpe.cabmanagement.dto.trip.BookTripByGivenCabAndRiderResponse;
import com.phonpe.cabmanagement.dto.trip.BookTripRequest;
import com.phonpe.cabmanagement.dto.trip.BookTripResponse;
import com.phonpe.cabmanagement.enums.ApplicationConstants;
import com.phonpe.cabmanagement.enums.TripStatus;
import com.phonpe.cabmanagement.exception.UnRegisteredRiderException;
import com.phonpe.cabmanagement.exception.UnregisteredCabException;
import com.phonpe.cabmanagement.repository.CabRepository;
import com.phonpe.cabmanagement.repository.RiderRepository;
import com.phonpe.cabmanagement.repository.TripRepository;
import com.phonpe.cabmanagement.util.BaseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
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

    List<Cab> allCabs = new ArrayList<>();

    public CabApplicationResponse bookTripByGivenCabAndRider(BookTripByGivenCabAndRiderRequest bookTripByGivenCabAndRiderRequest)
    {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        BookTripByGivenCabAndRiderResponse bookTripByGivenCabAndRiderResponse = BookTripByGivenCabAndRiderResponse.builder()
                .startLocation(bookTripByGivenCabAndRiderRequest.getStartLocation())
                .bookedDestination(bookTripByGivenCabAndRiderRequest.getBookedDestination())
                .rideStartDate(dateNow)
                .rideStartTime(timeNow)
                .RiderMobileNo(bookTripByGivenCabAndRiderRequest.getRiderMobileNo())
                .CabRegistrationNumber(bookTripByGivenCabAndRiderRequest.getCabRegistrationNumber())
                .bookTripStatus(ApplicationConstants.FAILURE)
                .build();

        String riderMobileNo = bookTripByGivenCabAndRiderRequest.getRiderMobileNo();
        String cabRegistrationNumber = bookTripByGivenCabAndRiderRequest.getCabRegistrationNumber();

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
                .startLocation(bookTripByGivenCabAndRiderRequest.getStartLocation())
                .bookedDestination(bookTripByGivenCabAndRiderRequest.getBookedDestination())
                .rideStartDate(dateNow)
                .rideStartTime(timeNow)
                .rider(rider)
                .cab(cab)
                .tripStatus(TripStatus.IN_JOURNEY)
                .build();

        tripRepository.save(trip);
        bookTripByGivenCabAndRiderResponse.setBookTripStatus(ApplicationConstants.SUCCESS);

        return bookTripByGivenCabAndRiderResponse;
    }

    public CabApplicationResponse bookTrip(BookTripRequest bookTripRequest)
    {
        LocalDate dateNow = LocalDate.now();
        LocalTime timeNow = LocalTime.now();
        Location startLocation = bookTripRequest.getStartLocation();
        Location bookedDestination = bookTripRequest.getBookedDestination();

        BookTripResponse bookTripResponse = BookTripResponse.builder()
                .startLocation(startLocation)
                .bookedDestination(bookTripRequest.getBookedDestination())
                .rideStartDate(dateNow)
                .rideStartTime(timeNow)
                .RiderMobileNo(bookTripRequest.getRiderMobileNo())
                .bookTripStatus(ApplicationConstants.FAILURE)
                .build();

        String riderMobileNo = bookTripRequest.getRiderMobileNo();
        Optional<Rider> riderByMobileNo = riderRepository.findAllByMobileNo(riderMobileNo);

        if (riderByMobileNo.isEmpty())
        {
            throw new UnRegisteredRiderException(String.format("Rider with mobile no %s is not registered", riderMobileNo));
        }
        Rider rider = riderByMobileNo.get();
        Cab cab = findNearByCabs(startLocation);
        Trip trip = Trip.builder()
                .startLocation(startLocation)
                .bookedDestination(bookedDestination)
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

    private Cab findNearByCabs(Location bookingLocation)
    {
        if (allCabs.isEmpty())
        {
            allCabs = cabRepository.findAll();
        }

        Cab cab = allCabs.get(0);
        double min_distance = BaseUtil.getDifferenceBetweenLocations(bookingLocation, cab.getCurrentLocation());

        for (int i = 1; i < allCabs.size(); i++)
        {
            Cab current_cab = allCabs.get(i);
            double currentDistance = BaseUtil.getDifferenceBetweenLocations(bookingLocation, cab.getCurrentLocation());
            if (currentDistance < min_distance)
            {
                min_distance = currentDistance;
                cab = current_cab;
            }
        }
        return cab;
    }
}
