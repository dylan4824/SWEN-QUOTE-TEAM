public class Bye implements Match{
	String team1;
	String team2;
	int round;
	
	public Bye(String team1, String team2, int round){
		this.team1 = team1;
		this.team2 = team2;
		this.round = round;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
	
	
	
}
