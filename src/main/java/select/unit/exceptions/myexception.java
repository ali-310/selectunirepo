package select.unit.exceptions;

public class myexception extends Exception {

    public myexception(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "myexception{}";
    }
}
