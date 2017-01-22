package gamesys.hr.raffle.ticket;

import java.util.List;

public interface TicketRepository {

    Ticket add(TicketRequest ticketRequest);

    List<Ticket> findAll();


}
