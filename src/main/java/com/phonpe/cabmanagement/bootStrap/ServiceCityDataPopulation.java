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
        ServiceCity serviceCity1 = ServiceCity.builder().city("Delhi").state("Delhi").country("India").build();
        log.debug("Registering city for service with details => {}", serviceCity1);
        serviceCityRepository.save(serviceCity1);
        ServiceCity serviceCity2 = ServiceCity.builder().city("Varanasi").state("UP").country("India").build();
        log.debug("Registering city for service with details => {}", serviceCity2);
        serviceCityRepository.save(serviceCity2);
        ServiceCity serviceCity3 = ServiceCity.builder().city("Kolkata").state("Bengal").country("India").build();
        log.debug("Registering city for service with details => {}", serviceCity3);
        serviceCityRepository.save(serviceCity3);
        ServiceCity serviceCity4 = ServiceCity.builder().city("Mumbai").state("Maharashtra").country("India").build();
        log.debug("Registering city for service with details => {}", serviceCity4);
        serviceCityRepository.save(serviceCity4);
        ServiceCity serviceCity5 = ServiceCity.builder().city("Manali").state("Himanchal").country("India").build();
        log.debug("Registering city for service with details => {}", serviceCity5);
        serviceCityRepository.save(serviceCity5);
        ServiceCity serviceCity6 = ServiceCity.builder().city("Lucknow").state("UP").country("India").build();
        log.debug("Registering city for service with details => {}", serviceCity6);
        serviceCityRepository.save(serviceCity6);
        ServiceCity serviceCity7 = ServiceCity.builder().city("Jaipur").state("Rajasthan").country("India").build();
        log.debug("Registering city for service with details => {}", serviceCity7);
        serviceCityRepository.save(serviceCity7);
        ServiceCity serviceCity8 = ServiceCity.builder().city("Srinagar").state("Kashmir").country("India").build();
        log.debug("Registering city for service with details => {}", serviceCity8);
        serviceCityRepository.save(serviceCity8);
        ServiceCity serviceCity9 = ServiceCity.builder().city("Ghaziabad").state("UP").country("India").build();
        log.debug("Registering city for service with details => {}", serviceCity9);
        serviceCityRepository.save(serviceCity9);
        ServiceCity serviceCity10 = ServiceCity.builder().city("Bangalore").state("Karnataka").country("India").build();
        log.debug("Registering city for service with details => {}", serviceCity10);
        serviceCityRepository.save(serviceCity10);
        log.debug("Registered cities with service");
    }
}
