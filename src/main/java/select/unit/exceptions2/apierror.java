package select.unit.exceptions2;

import org.springframework.http.HttpStatus;

public class apierror {
    private HttpStatus status;
    private String messsage;

    apierror(HttpStatus status){

       this.status=status;
    }


    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }
}
