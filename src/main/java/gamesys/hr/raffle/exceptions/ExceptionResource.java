package gamesys.hr.raffle.exceptions;

public class ExceptionResource {

    private final String reason;

    public ExceptionResource(String reason) {
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }
}
