package select.unit.exceptions2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.*;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
public class restexceptinhandleali extends ResponseEntityExceptionHandler {
    protected Logger logger=  LoggerFactory.getLogger(getClass());


    @ExceptionHandler(messageexception.class)
    protected ResponseEntity<Object> handlenotfoundexception(messageexception notfoundexception)
    {
        apierror apieror=new apierror(NOT_FOUND);
        apieror.setMesssage(notfoundexception.getMessage());
        return  buildResponseEntity(apieror);
    }
    @ExceptionHandler(badrequestxceptionmessage.class)
    protected ResponseEntity<Object> handlenulpointerexception2(badrequestxceptionmessage badrequestexception)
    {
        apierror apieror=new apierror(BAD_REQUEST);
        apieror.setMesssage(badrequestexception.getMessage());
        return  buildResponseEntity(apieror);
    }
    @ExceptionHandler(foundokstatus.class)
    protected ResponseEntity<Object> handlenulpointerexception3(foundokstatus ok)
    {
        apierror apieror=new apierror(OK);
        apieror.setMesssage(ok.getMessage());
        return  buildResponseEntity(apieror);
    }

    private ResponseEntity<Object> buildResponseEntity(apierror apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }


}
