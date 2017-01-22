package gamesys.hr.raffle.raffle;

import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class RaffleRepositoryImpl implements RaffleRepository {

    private Integer nextId = -1;
    private HashMap<Integer,Raffle> store = new HashMap<Integer, Raffle>();

    private Integer getNextId(){
        nextId++;
        return nextId;
    }

    @Override
    public Raffle add(RaffleRequest raffleRequest) {
        Integer id = getNextId();
        Raffle raffle = new Raffle(id, raffleRequest.getName(), raffleRequest.getCode(), raffleRequest.getNumberOfTickets());
        store.put(id, raffle);
        return raffle;
    }

    @Override
    public Raffle findBy(Integer id) {
        return store.get(id);
    }



}
