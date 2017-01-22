package gamesys.hr.raffle.ticket;

import gamesys.hr.raffle.exceptions.PlayerNotFoundException;
import gamesys.hr.raffle.player.Player;
import gamesys.hr.raffle.player.PlayerRepository;
import gamesys.hr.raffle.raffle.Raffle;
import gamesys.hr.raffle.exceptions.RaffleNotFoundException;
import gamesys.hr.raffle.raffle.RaffleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    RaffleRepository raffleRepository;

    @Override
    public Ticket requestTicketForPlayer(TicketRequest ticketRequest) {

        Raffle raffle = raffleRepository.findBy(ticketRequest.getRaffleId());

        if(raffle == null){
            throw new RaffleNotFoundException();
        }

        Player player = playerRepository.findBy(ticketRequest.getPlayerId());

        if(player == null){
            throw new PlayerNotFoundException();
        }

        raffle.bookTicket();

        Ticket ticket = ticketRepository.add(ticketRequest);

        return ticket;
    }

    @Override
    public List<Ticket> getAll() {
        return ticketRepository.findAll();
    }
}
