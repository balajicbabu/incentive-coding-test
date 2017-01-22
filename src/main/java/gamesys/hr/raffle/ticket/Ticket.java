package gamesys.hr.raffle.ticket;

public class Ticket {

    private final Integer id;
    private final Integer playerId;
    private final String code;

    public Ticket(Integer id, Integer playerId, String code) {
        this.id = id;
        this.playerId = playerId;
        this.code = code;
    }

    public Integer getId() {
        return id;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public String getCode() {
        return code;
    }
}
