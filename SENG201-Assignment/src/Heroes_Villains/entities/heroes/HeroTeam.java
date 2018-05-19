package Heroes_Villains.entities.heroes;

public class HeroTeam {

    public Hero[] team;
    public String teamName;

    public HeroTeam(Hero[] team, String teamName) {
        this.team = team;
        this.teamName = teamName;
    }
}
