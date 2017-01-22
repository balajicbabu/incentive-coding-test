package gamesys.hr.raffle.player;

import gamesys.hr.raffle.exceptions.ValidationException;

public class InvalidAgeException extends ValidationException {
    public InvalidAgeException() {
        super("Invalid birth date. Player needs to be at least 18.");
    }
}
