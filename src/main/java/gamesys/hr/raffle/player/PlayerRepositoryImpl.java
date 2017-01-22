package gamesys.hr.raffle.player;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class PlayerRepositoryImpl implements PlayerRepository {

    private Integer nextId = -1;

    private HashMap<Integer,Player> store = new HashMap<Integer, Player>();


    @Override
    public Player add(NewPlayerRequest newPlayerRequest) {
        Integer id = getNextId();
        Player player = new Player(id, newPlayerRequest.getName(), newPlayerRequest.getEmail(), newPlayerRequest.getDob());
        store.put(id, player);
        return player;
    }

    @Override
    public List<Player> findAll() {
        return new ArrayList<Player>(store.values());
    }

    @Override
    public Player findBy(Integer id) {
        return store.get(id);
    }

    private Integer getNextId(){
        nextId++;
        return nextId;
    }
}
