package gamesys.hr.raffle.exceptions;

public class NoMoreTicketAvailableException extends BusinessLogicException {

    public NoMoreTicketAvailableException() {
        super("Tickets not available");
    }
}
