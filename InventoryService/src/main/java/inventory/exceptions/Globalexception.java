package inventory.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class Globalexception {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleGlobalExceptions(Exception ex, WebRequest request) {
		return new ResponseEntity<>("Item not found in Inventory... will load it soon  ", HttpStatus.NOT_FOUND);
	}
}
