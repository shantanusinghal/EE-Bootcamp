package ee.bootcamp.isro.exception;

public class BoundaryViolation extends Throwable {

    private String message;

    public BoundaryViolation(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
