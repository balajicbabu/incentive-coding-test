package gamesys.hr.raffle.exceptions;

public class InvalidDateFormatException extends ValidationException {
    public InvalidDateFormatException() {
        super("Wrong format data, use dd/MM/yyyy");
    }
}
