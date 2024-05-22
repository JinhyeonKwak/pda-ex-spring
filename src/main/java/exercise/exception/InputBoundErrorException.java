package exercise.exception;

public class InputBoundErrorException extends Exception {
    private String message;
    public InputBoundErrorException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}