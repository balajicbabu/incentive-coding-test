package gamesys.hr.raffle.raffle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;

@Component
public class RaffleEndpointImpl implements RaffleEndpoint {

    @Autowired
    private RaffleRepository raffleRepository;

    @Override
    public Response add(RaffleRequest raffleRequest) {

        Raffle raffle = raffleRepository.add(raffleRequest);
        return Response.status(200).entity(raffle).build();


    }
}
