package gamesys.hr.raffle.ticket;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Component
public class TicketRepositoryImpl implements TicketRepository {

    private Integer nextId = -1;
    private HashMap<Integer,Ticket> store = new HashMap<Integer, Ticket>();


    @Override
    public Ticket add(TicketRequest ticketRequest) {
        Integer id = getNextId();
        Ticket ticket = new Ticket(id,ticketRequest.getPlayerId(), UUID.randomUUID().toString());
        store.put(id, ticket);
        return ticket;
    }

    @Override
    public List<Ticket> findAll() {
        return new ArrayList<Ticket>(store.values());
    }

    private Integer getNextId(){
        nextId++;
        return nextId;
    }

}
