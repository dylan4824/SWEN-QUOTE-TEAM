import java.time.LocalDate;

public class Game implements Match{
	private int round;
	private LocalDate date;
	private String homeTeam;
	private String awayTeam;
	private int homeScore;
	private int awayScore;
	private String venue;
	private boolean overtime;

	public Game(int round, LocalDate date, String homeTeam, String awayTeam, int homeScore, int awayScore, String venue, boolean overtime){
		this.round = round;
		this.date = date;
		this.homeTeam = homeTeam;
		this.awayTeam = awayTeam;
		this.homeScore = homeScore;
		this.awayScore = awayScore;
		this.venue = venue;
		this.overtime = overtime;
	}
	/**
	 * @return the round
	 */
	public int getRound() {
		return round;
	}
	/**
	 * @param round the round to set
	 */
	public void setRound(int round) {
		this.round = round;
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * @return the homeTeam
	 */
	public String getHomeTeam() {
		return homeTeam;
	}
	/**
	 * @param homeTeam the homeTeam to set
	 */
	public void setHomeTeam(String homeTeam) {
		this.homeTeam = homeTeam;
	}
	/**
	 * @return the homeScore
	 */
	public int getHomeScore() {
		return homeScore;
	}
	/**
	 * @param homeScore the homeScore to set
	 */
	public void setHomeScore(int homeScore) {
		this.homeScore = homeScore;
	}
	/**
	 * @return the awayScore
	 */
	public int getAwayScore() {
		return awayScore;
	}
	/**
	 * @param awayScore the awayScore to set
	 */
	public void setAwayScore(int awayScore) {
		this.awayScore = awayScore;
	}
	/**
	 * @return the awayTeam
	 */
	public String getAwayTeam() {
		return awayTeam;
	}
	/**
	 * @param awayTeam the awayTeam to set
	 */
	public void setAwayTeam(String awayTeam) {
		this.awayTeam = awayTeam;
	}
	/**
	 * @return the venue
	 */
	public String getVenue() {
		return venue;
	}
	/**
	 * @param venu the venue to set
	 */
	public void setVenue(String venue) {
		this.venue = venue;
	}




}
