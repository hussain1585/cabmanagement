package com.phonpe.cabmanagement.bootStrap;

import com.phonpe.cabmanagement.domain.Cab;
import com.phonpe.cabmanagement.domain.Location;
import com.phonpe.cabmanagement.enums.CabMovementStatus;
import com.phonpe.cabmanagement.enums.VehicleType;
import com.phonpe.cabmanagement.repository.CabRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class CabDataPopulation implements ApplicationRunner
{

    @Autowired
    private CabRepository cabRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        log.debug("Registering cabs with service");
        cabRepository.saveAll(List.of(
                Cab.builder()
                        .vehicleBrand("TATA")
                        .vehicleModel("ALTROZ")
                        .vehicleColor("RED")
                        .vehicleType(VehicleType.HATCH_BACK)
                        .registrationNumber("UP-14-EQ-1371")
                        .currentLocation(Location.builder().latitude(28.547640).longitude(77.305283).build())
                        .isAvailable(true)
                        .cabMovementStatus(CabMovementStatus.IDLE)
                        .build(),
                Cab.builder()
                        .vehicleBrand("TATA")
                        .vehicleModel("ALTROZ")
                        .vehicleColor("RED")
                        .vehicleType(VehicleType.HATCH_BACK)
                        .registrationNumber("UP-14-EQ-1372")
                        .currentLocation(Location.builder().latitude(28.547640).longitude(77.305283).build())
                        .isAvailable(true)
                        .cabMovementStatus(CabMovementStatus.IDLE)
                        .build(),
                Cab.builder()
                        .vehicleBrand("TATA")
                        .vehicleModel("ALTROZ")
                        .vehicleColor("RED")
                        .vehicleType(VehicleType.HATCH_BACK)
                        .registrationNumber("UP-14-EQ-1373")
                        .currentLocation(Location.builder().latitude(28.547640).longitude(77.305283).build())
                        .isAvailable(true)
                        .cabMovementStatus(CabMovementStatus.IDLE)
                        .build(),
                Cab.builder()
                        .vehicleBrand("TATA")
                        .vehicleModel("ALTROZ")
                        .vehicleColor("RED")
                        .vehicleType(VehicleType.HATCH_BACK)
                        .registrationNumber("UP-14-EQ-1374")
                        .currentLocation(Location.builder().latitude(28.547640).longitude(77.305283).build())
                        .isAvailable(true)
                        .cabMovementStatus(CabMovementStatus.IDLE)
                        .build(),
                Cab.builder()
                        .vehicleBrand("TATA")
                        .vehicleModel("ALTROZ")
                        .vehicleColor("RED")
                        .vehicleType(VehicleType.HATCH_BACK)
                        .registrationNumber("UP-14-EQ-1375")
                        .currentLocation(Location.builder().latitude(28.547640).longitude(77.305283).build())
                        .isAvailable(true)
                        .cabMovementStatus(CabMovementStatus.IDLE)
                        .build(),
                Cab.builder()
                        .vehicleBrand("TATA")
                        .vehicleModel("ALTROZ")
                        .vehicleColor("RED")
                        .vehicleType(VehicleType.HATCH_BACK)
                        .registrationNumber("UP-14-EQ-1376")
                        .currentLocation(Location.builder().latitude(28.547640).longitude(77.305283).build())
                        .isAvailable(true)
                        .cabMovementStatus(CabMovementStatus.IDLE)
                        .build(),
                Cab.builder()
                        .vehicleBrand("TATA")
                        .vehicleModel("ALTROZ")
                        .vehicleColor("RED")
                        .vehicleType(VehicleType.HATCH_BACK)
                        .registrationNumber("UP-14-EQ-1377")
                        .currentLocation(Location.builder().latitude(28.547640).longitude(77.305283).build())
                        .isAvailable(true)
                        .cabMovementStatus(CabMovementStatus.IDLE)
                        .build(),
                Cab.builder()
                        .vehicleBrand("TATA")
                        .vehicleModel("ALTROZ")
                        .vehicleColor("RED")
                        .vehicleType(VehicleType.HATCH_BACK)
                        .registrationNumber("UP-14-EQ-1378")
                        .currentLocation(Location.builder().latitude(28.547640).longitude(77.305283).build())
                        .isAvailable(true)
                        .cabMovementStatus(CabMovementStatus.IDLE)
                        .build(),
                Cab.builder()
                        .vehicleBrand("TATA")
                        .vehicleModel("ALTROZ")
                        .vehicleColor("RED")
                        .vehicleType(VehicleType.HATCH_BACK)
                        .registrationNumber("UP-14-EQ-1379")
                        .currentLocation(Location.builder().latitude(28.547640).longitude(77.305283).build())
                        .isAvailable(true)
                        .cabMovementStatus(CabMovementStatus.IDLE)
                        .build(),
                Cab.builder()
                        .vehicleBrand("TATA")
                        .vehicleModel("ALTROZ")
                        .vehicleColor("RED")
                        .vehicleType(VehicleType.HATCH_BACK)
                        .registrationNumber("UP-14-EQ-1380")
                        .currentLocation(Location.builder().latitude(28.547640).longitude(77.305283).build())
                        .isAvailable(true)
                        .cabMovementStatus(CabMovementStatus.IDLE)
                        .build()

        ));
        log.debug("Registered cabs with service");
    }
}
