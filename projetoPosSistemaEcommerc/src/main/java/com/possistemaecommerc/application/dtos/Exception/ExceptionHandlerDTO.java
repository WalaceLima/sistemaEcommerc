package com.possistemaecommerc.application.dtos.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionHandlerDTO {
    private HttpStatus status;
    private List<String> errors;
}
