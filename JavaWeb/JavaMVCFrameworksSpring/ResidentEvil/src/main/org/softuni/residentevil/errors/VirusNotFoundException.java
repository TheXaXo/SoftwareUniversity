package org.softuni.residentevil.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Virus does not exist.")
public class VirusNotFoundException extends RuntimeException {
}
