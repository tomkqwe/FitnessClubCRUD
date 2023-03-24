package com.lebedev.exception;

import java.io.IOException;

public class ReadPropertiesException extends RuntimeException {
    public ReadPropertiesException(IOException e) {
    }
}
