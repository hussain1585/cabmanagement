package com.phonpe.cabmanagement;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class CabManagementApplication
{

    public static void main(String[] args)
    {
        log.debug("Starting application");
        SpringApplication.run(CabManagementApplication.class, args);
    }
}
