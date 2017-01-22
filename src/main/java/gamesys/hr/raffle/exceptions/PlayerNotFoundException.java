package gamesys.hr.raffle.exceptions;

public class PlayerNotFoundException extends RuntimeException {

    public PlayerNotFoundException() {
        super("Player not found");
    }
}
