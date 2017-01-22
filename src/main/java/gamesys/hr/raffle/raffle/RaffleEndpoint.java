package gamesys.hr.raffle.raffle;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/raffles")
@Produces("application/json")
public interface RaffleEndpoint {

    @POST
    public Response add(RaffleRequest raffleRequest);



}
