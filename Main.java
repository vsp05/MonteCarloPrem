import java.util.Scanner;
import java.lang.Math;
import org.apache.commons.math3.distribution.NormalDistribution;


class Main {
  public static void main(String[] args) {
    boolean cont = true;
    String t1 = "";
    String t2 = "";
    Scanner userInput = new Scanner (System.in);
    while (cont == true){
        System.out.print("Enter the home team abbreviation: ");
        t1 = userInput.next();
        double[] homeTeam = teamVals(t1);
        System.out.print("Enter the away team abbreviation: ");
        t2 = userInput.next();
        double[] awayTeam = teamVals(t2);

        double t1_adj = adj_goals (homeTeam, awayTeam);
        double t2_adj = adj_goals(awayTeam, homeTeam);

        double t1ExpGoals = MonteCarlo(100, t1_adj);
        double t2ExpGoals = MonteCarlo(100, t2_adj);

        System.out.println("Do you want to run a simulation for another game (true/false): ");
        cont = userInput.nextBoolean();
    }
    userInput.close();
  }

  public static double[] teamVals(String abbr){
    Scanner x = new Scanner (System.in);
    System.out.println("Enter stats for this team:");
    System.out.print("Games: ");
    double games = x.nextDouble();
    System.out.print("Goals:");
    double goals = x.nextDouble();
    System.out.print("Goals Against:");
    double GA = x.nextDouble();

    double goalsP90 = goals/games;
    double GAP90 = GA/games;

    double [] rtnArr = new double[]{goalsP90, GAP90};
    x.close();
    return rtnArr;
  }
  
  //returns adjusted goals for the team represented by arr1 
  public static double adj_goals(double[] arr1, double[] arr2){
  
    double t1Goals = arr1[0];
    double t2GA = arr2[1];

    return Math.sqrt(t1Goals*t2GA);
  }

  public static double MonteCarlo(int sims, double adj){
    double mean = adj;
    double std = .9;
    int num = 0;
    double sum = 0.0;

    while (num < sims){

      num++;
    }

  }
}