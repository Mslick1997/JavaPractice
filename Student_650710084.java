import java.util.Random;

class Player{
    private String playerName;
    
    Player(String playerName){
        this.playerName = playerName;
    }
    Player(){}
    public String getName(){
        return playerName;
    }
}
class Team{
    private String teamName;
    private Player[] playerArray;
    
    Team(String teamName, Player[] playerArray){
        this.teamName = teamName;
        this.playerArray = playerArray;
    }
    Team(){}
    public void listPlayer(){
        for (int i = 0 ; i < 3 ; i++){
            System.out.println(playerArray[i].getName());
        }
    }
    public Player getPlayerArr(){
        return playerArray[1];
    }
}
class Goal{
    private Team theTeam;
    private Player thePlayer;
    private double theTime;
    
    Goal(Team theTeam, Player thePlayer, double theTime){
        this.theTeam = theTeam;
        this.thePlayer = thePlayer;
        this.theTime = theTime;
    }
    Goal(){}
}
class Game{
    private Team homeTeam;
    private Team awayTeam;
    private Goal[] goals;
    
    Game(Team homeTeam, Team awayTeam){
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }
    public Team getHome(){
        return homeTeam;
    }
    public Team getAway(){
        return awayTeam;
    }
}
class League{
    public static void test_1(){
        Player thePlayer[] = new Player[6];
        
        Player player1 = new Player("Jane Austen");
        Player player2 = new Player("Thomas Hardy");
        Player player3 = new Player("Charles Dickens");
        thePlayer[0] = player1;
        thePlayer[1] = player2;
        thePlayer[2] = player3;
        //System.out.println(player1);
        Team team1 = new Team("The Greens", thePlayer);
        team1.listPlayer();
        
        Player player4 = new Player("George Henry");
        Player player5 = new Player("Elizabeth Gaskell");
        Player player6 = new Player("Emily Bronte");
        thePlayer[0] = player4;
        thePlayer[1] = player5;
        thePlayer[2] = player6;
        Team team2 = new Team("The Reds", thePlayer);
        team2.listPlayer();
    }
    public static Team createTeam(){
        Player thePlayer[] = new Player[6];
        
        Player player1 = new Player("Jane Austen");
        Player player2 = new Player("Thomas Hardy");
        Player player3 = new Player("Charles Dickens");
        thePlayer[0] = player1;
        thePlayer[1] = player2;
        thePlayer[2] = player3;
        Team team1 = new Team("The Greens", thePlayer);
        
        Player player4 = new Player("George Henry");
        Player player5 = new Player("Elizabeth Gaskell");
        Player player6 = new Player("Emily Bronte");
        thePlayer[0] = player4;
        thePlayer[1] = player5;
        thePlayer[2] = player6;
        Team team2 = new Team("The Greens", thePlayer);
        Team team[] = new Team[2];
        team[0] = team1;
        team[1] = team2;
        return team[0];
    }
    public static Game createGame(Team Team[]){
        Game theGame = new Game(Team[0], Team[1]);
        Game theGames[] = new Game[1];
        theGames[0] = theGame;
        return theGames[0];
    }
    public static Goal createGoal(Game game, Team team){
        Goal goal = new Goal(game.getAway(), team.getPlayerArr(),35.0);
        return goal;
    }
    public void reportGame(){
        System.out.println("Goal scored after the Time mins by thePlayer of theTeam.");
    }
    public static void test_2(){
        try {Team team1 = new Team();
        Team team2 = new Team();
        Team team[] = new Team[10];
        team[0] = team1;
        team[1] = team2;
        createTeam();
        createGame(team);
        createGoal(createGame(team), team1);
        League l = new League();
        l.reportGame();
        } catch(NullPointerException e){
            e.getMessage();
        }
    }
}
class MyLeague{
    Team[] teams;
    Game[] games;
    
    MyLeague(Team[] teams, Game[] games){
        this.teams = teams;
        this.games = games;
    }
    MyLeague(){}
    public Goal createGoals(int n){
        Random random = new Random();
        double theTime = random.nextDouble(90);
        Goal goal[] = new Goal[n];
        return goal[0];
    }
    public void summary(){
        System.out.println("Goal scored after the Time mins by thePlayer of theTeam.");
    }
}

public class Student_650710084 {
    public static void main(String[] args) {
        League.test_1();
        Team team1 = new Team();
        Team team2 = new Team();
        Team []team = new Team[10];
        team[0] = team1;
        team[1] = team2;
        Game []game = new Game[10];
        League.createTeam();
        League.createGame(team);
        MyLeague mL = new MyLeague(team, game);
        //League.createGoal(League.createGame(team), team1);
        mL.summary();
    }
}
