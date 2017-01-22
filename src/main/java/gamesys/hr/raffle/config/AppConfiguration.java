package gamesys.hr.raffle.config;

import gamesys.hr.raffle.player.PlayerEndpoint;
import gamesys.hr.raffle.player.PlayerEndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    @Bean
    public PlayerEndpoint raffleEndpoint(){
        return new PlayerEndpointImpl();
    }


}
