package gamesys.hr.raffle.exceptions;

public class InvalidEmailFormatException extends ValidationException {
    public InvalidEmailFormatException() {
        super("Wrong email format");
    }
}
