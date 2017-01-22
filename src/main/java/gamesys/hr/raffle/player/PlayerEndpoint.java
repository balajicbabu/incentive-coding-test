package gamesys.hr.raffle.player;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/players")
@Produces("application/json")
public interface PlayerEndpoint {

    @GET
    public Response findAll();

    @GET
    @Path("/{id}")
    public Response findBy(@PathParam("id") Integer id);

    @POST
    public Response add(NewPlayerRequest newPlayerRequest);


}
