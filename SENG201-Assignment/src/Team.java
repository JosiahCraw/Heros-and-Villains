import java.util.ArrayList;

public class Team {
	
	private String teamName;
	private double teamMoney = 100;
	private int maxSize;
	private ArrayList<Hero> heroes = new ArrayList<Hero>();

	public Team(int size, String name) {
		teamName = name;
		maxSize = size;
	}
	
	public Team() {
	}
	
	public int getMaxSize(){
		return maxSize;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setName(String name) {
		teamName = name;
	}
	
	public void setMaxSize(int size) {
		maxSize = size;
	}
	
	public void addHero(Hero toAdd) {
		//pass
	}
	
}