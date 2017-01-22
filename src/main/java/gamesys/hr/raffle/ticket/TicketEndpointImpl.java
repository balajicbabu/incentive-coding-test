package gamesys.hr.raffle.ticket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;


@Component
public class TicketEndpointImpl implements TicketEndpoint {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketService ticketService;

    @Override
    public Response requestTicket(TicketRequest ticketRequest) {

        Ticket ticket = ticketService.requestTicketForPlayer(ticketRequest);

        return Response.status(200).entity(ticket).build();

    }

    @Override
    public Response getAll() {
        return Response.status(200).entity(ticketService.getAll()).build();
    }
}
