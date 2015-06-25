import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;


public class Parser {
	private int ROUND,DATE,HOMETEAM,SCORE,AWAYTEAM,VENUE;
	private int year;
	private ArrayList<ArrayList<Match>> years = new ArrayList<ArrayList<Match>>();
	public static void main(String[] args) {
		Parser p = new Parser(args);
	}

	public ArrayList<ArrayList<Match>> getYears(){
		return years;
	}
	public Parser(String[] args) {
		for(String arg : args){
			year = Integer.parseInt(arg.substring(0, 4));
			File f = new File(arg);
			Scanner s = null;
			try {
				s = new Scanner(f);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String[] lables = s.nextLine().toString().split(",");
			for(int i = 0; i<lables.length; i++){
				switch(lables[i]){
				case "Round":		ROUND = i;
									break;
				case "Date" :		DATE = i;
									break;
				case "Time":		break;
				case "Home Team" :	HOMETEAM = i;
									break;
				case "Score" :		SCORE = i;
									break;
				case "Away Team" :	AWAYTEAM = i;
									break;
				case "Venue" :	VENUE = i;
									break;
				default:	    	System.out.println("no match on " + lables[i]);
									break;

				}
			}
			process(s);
		}
	}

	private void process(Scanner s) {
		ArrayList<Match> year = new ArrayList<Match>();
		while(s.hasNextLine()){
			String[] game = s.nextLine().toString().split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)", -1);
			year.add(processLine(game));
		}
		years.add(year);
	}

	private Match processLine(String[] game) {
		int round = Integer.parseInt(game[ROUND]);
		LocalDate date = null;
		try{
			String[] splitDate = game[DATE].split(" ");
			if(splitDate[0].contains("BYES:")){
				String g1 = game[DATE].substring(6).split(" and ")[0];
				//System.out.println("[" + g1 + "]");
				String g2 = game[DATE].substring(6).split(" and ")[1];
				return new Bye(g1, g1, ROUND);
			}else{
				//System.out.println("Split Date:");
				//for(int i = 0; i<splitDate.length; i++)
				//	System.out.println("\t " +splitDate[i]);
				int day = Integer.parseInt(splitDate[1].trim());
				String month = splitDate[2].trim().toUpperCase().replace(",", "");
				Month m = Month.valueOf(month);
				date = LocalDate.of(year, Month.valueOf(month), day);
				//System.out.println(date + " from " + game[DATE]);
			}
		} catch(Exception e){
			System.out.println(e);
			return null;
		}
		String homeTeam = game[HOMETEAM];
		String awayTeam = game[AWAYTEAM];
		String venue = game[VENUE];
		int homeScore;
		int awayScore;
		String score = game[SCORE].replaceAll("\\s+","").replaceAll("\"+", "");
		//System.out.println(score);
		try{
			homeScore = Integer.parseInt(score.substring(0, 2));
			awayScore = Integer.parseInt(score.substring(3, 5));
		} catch (Exception e){
			homeScore = Integer.parseInt(score.substring(0, 1));
			awayScore = Integer.parseInt(score.substring(2, 3));
		}
		boolean overtime = game[SCORE].contains("(");
		System.out.println(round + " " + date + " " + homeTeam + " " + awayTeam + " " + homeScore + " " + awayScore + " " + venue + " " + overtime);
		return new Game(round, date, homeTeam, awayTeam, homeScore, awayScore, venue, overtime);
	}

}
