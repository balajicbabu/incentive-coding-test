package gamesys.hr.raffle.ticket;

public class TicketRequest {

    private Integer playerId;
    private Integer raffleId;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public Integer getRaffleId() {
        return raffleId;
    }

    public void setRaffleId(Integer raffleId) {
        this.raffleId = raffleId;
    }
}
