package gamesys.hr.raffle.player;

import java.util.List;

public interface PlayerRepository {

    public Player add(NewPlayerRequest player);

    public List<Player> findAll();

    public Player findBy(Integer id);


}
