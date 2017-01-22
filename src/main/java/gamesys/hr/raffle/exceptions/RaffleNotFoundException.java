package gamesys.hr.raffle.exceptions;

public class RaffleNotFoundException extends BusinessLogicException {
    public RaffleNotFoundException() {
        super("Raffle not found");
    }
}
