package gamesys.hr.raffle.raffle;

public class RaffleRequest {

    private String name;
    private String code;
    private Integer numberOfTickets;

    public RaffleRequest() {
    }

    public RaffleRequest(String name, String code, Integer numberOfTickets) {
        this.name = name;
        this.code = code;
        this.numberOfTickets = numberOfTickets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public void setNumberOfTickets(Integer numberOfTickets) {
        this.numberOfTickets = numberOfTickets;
    }
}
