package customerform.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(CustomerNotFoundException.class)
    public String handleNotFound() {
        return "error/not_found";
    }
}
