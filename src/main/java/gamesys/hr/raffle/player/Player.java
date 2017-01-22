package gamesys.hr.raffle.player;


import org.joda.time.DateTime;

public class Player {

    private final Integer id;
    private final String name;
    private final String email;
    private final String dob;

    public Player(Integer id, String name, String email, String dob) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDob() {
        return dob;
    }
}
