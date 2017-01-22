package gamesys.hr.raffle.raffle;

import gamesys.hr.raffle.exceptions.NoMoreTicketAvailableException;

public class Raffle {

    private final Integer id;
    private final String name;
    private final String code;
    private final Integer numberOfTickets;
    private Integer remainingTickets;

    public Raffle(Integer id, String name, String code, Integer numberOfTickets) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.numberOfTickets = numberOfTickets;
        this.remainingTickets = numberOfTickets;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public Integer getNumberOfTickets() {
        return numberOfTickets;
    }

    public Integer getRemainingTickets() {
        return remainingTickets;
    }

    public void bookTicket(){
        if(remainingTickets<=0){
            throw new NoMoreTicketAvailableException();
        }
        remainingTickets--;
    }


}
