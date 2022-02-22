package com.phonpe.cabmanagement.dto;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class CabApplicationExceptionResponse extends CabApplicationResponse
{
    private String error;
    private HttpStatus httpStatus;
    private LocalDateTime localDateTime;
}
