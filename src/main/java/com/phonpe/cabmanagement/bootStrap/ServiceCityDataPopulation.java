package com.phonpe.cabmanagement.bootStrap;

import com.phonpe.cabmanagement.domain.ServiceCity;
import com.phonpe.cabmanagement.repository.ServiceCityRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ServiceCityDataPopulation implements ApplicationRunner
{

    @Autowired
    private ServiceCityRepository serviceCityRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception
    {
        log.debug("Registering cities with service");
        serviceCityRepository.save(ServiceCity.builder().city("Delhi").state("Delhi").country("India").build());
        serviceCityRepository.save(ServiceCity.builder().city("Varanasi").state("UP").country("India").build());
        serviceCityRepository.save(ServiceCity.builder().city("Kolkata").state("Bengal").country("India").build());
        serviceCityRepository.save(ServiceCity.builder().city("Mumbai").state("Maharashtra").country("India").build());
        serviceCityRepository.save(ServiceCity.builder().city("Manali").state("Himanchal").country("India").build());
        serviceCityRepository.save(ServiceCity.builder().city("Lucknow").state("UP").country("India").build());
        serviceCityRepository.save(ServiceCity.builder().city("Jaipur").state("Rajasthan").country("India").build());
        serviceCityRepository.save(ServiceCity.builder().city("Srinagar").state("Kashmir").country("India").build());
        serviceCityRepository.save(ServiceCity.builder().city("Ghaziabad").state("UP").country("India").build());
        serviceCityRepository.save(ServiceCity.builder().city("Bangalore").state("Karnataka").country("India").build());
        log.debug("Registered cities with service");
    }
}
