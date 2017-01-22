package gamesys.hr.raffle.player;

import gamesys.hr.raffle.exceptions.InvalidDateFormatException;
import gamesys.hr.raffle.exceptions.InvalidEmailFormatException;
import org.apache.commons.validator.routines.EmailValidator;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerServiceImpl implements PlayerService {

    public static final int MIN_AGE = 18;
    DateTimeFormatter DOB_TIME_FORMATTER = DateTimeFormat.forPattern("dd/MM/yyyy");


    @Autowired
    PlayerRepository playerRepository;

    @Override
    public Player add(NewPlayerRequest newPlayerRequest) {

        DateTime playerDob = null;
        try {
            playerDob = DOB_TIME_FORMATTER.parseDateTime(newPlayerRequest.getDob());
        }catch (RuntimeException e){
            throw new InvalidDateFormatException();
        }

        if(new Period(playerDob,new DateTime()).getYears() < MIN_AGE){
            throw new InvalidAgeException();
        }

        if(!EmailValidator.getInstance().isValid(newPlayerRequest.getEmail())){
            throw new InvalidEmailFormatException();
        }


        Player player = playerRepository.add(newPlayerRequest);
        return player;
    }
}
