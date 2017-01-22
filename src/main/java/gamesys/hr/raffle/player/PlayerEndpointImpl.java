package gamesys.hr.raffle.player;

import org.apache.commons.httpclient.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.core.Response;
import java.util.List;

@Component
public class PlayerEndpointImpl implements PlayerEndpoint {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerService playerService;


    @Override
    public Response findAll() {

        List<Player> players = playerRepository.findAll();

        return Response.status(200).entity(players).build();
    }

    @Override
    public Response findBy(Integer id) {
        Player player = playerRepository.findBy(id);
        if(player == null){
            Response.status(HttpStatus.SC_NOT_FOUND);
        }
        return Response.status(200).entity(player).build();
    }

    @Override
    public Response add(NewPlayerRequest newPlayerRequest) {

        Player player = playerService.add(newPlayerRequest);

        return Response.status(200).entity(player).build();

    }

}
