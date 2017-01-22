package gamesys.hr.raffle.ticket;

import java.util.List;

public interface TicketService {

    Ticket requestTicketForPlayer(TicketRequest ticketRequest);

    List<Ticket> getAll();
}
