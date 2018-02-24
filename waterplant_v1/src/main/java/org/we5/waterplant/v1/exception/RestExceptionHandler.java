/**
 * 
 */
package org.we5.waterplant.v1.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * @author KARNA
 *
 */
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	private WebRequest request;
	
	public ResponseEntity<Object> handleServiceException( Exception ex ) {
		ResponseEntity<Object> responseObject = handleException(ex, request);
		return responseObject;
		
	}
	

}
