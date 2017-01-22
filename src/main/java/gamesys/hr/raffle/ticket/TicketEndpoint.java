package gamesys.hr.raffle.ticket;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/ticket-api")
@Produces("application/json")
public interface TicketEndpoint {

    @POST
    @Path("/ticket-requests")
    Response requestTicket(TicketRequest ticketRequest);

    @GET
    @Path("/tickets")
    Response getAll();

}
