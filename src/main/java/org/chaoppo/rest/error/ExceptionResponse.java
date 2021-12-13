package org.chaoppo.rest.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;

}
