package gamesys.hr.raffle.raffle;

import gamesys.hr.raffle.player.Player;


public interface RaffleRepository {

    public Raffle add(RaffleRequest raffleRequest);

    public Raffle findBy(Integer id);

}
