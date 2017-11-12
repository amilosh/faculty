package by.it.milosh.REST.model;

public class RegistrationPageResponse {
    private String message;

    public RegistrationPageResponse() {
    }

    public RegistrationPageResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
