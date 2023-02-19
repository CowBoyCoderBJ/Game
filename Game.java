/**
* Game
*
* COMP 1020 SECTION A03
* INSTRUCTOR Ali Neshati
* ASSIGNMENT 1
* @author Bhavik Jain, 7927054
* @version March 6th, 2022
*
* PURPOSE: To create a class named Game
*/

public class Game {
    private Team firstTeam;
    private Team sTeam;

    public Game(Team firstTeam, Team sTeam){
        this.firstTeam = firstTeam;
        this.sTeam = sTeam;
    }

    public boolean validGame(){
        if (firstTeam.hasCommonPlayers(sTeam) == true){
            return false;
        }

        if (firstTeam.teamFull() == false){
            if (sTeam.teamFull() == false){
                return false;
            } 
            
        }
        return true;
    }

    public void awardWinner( Team winner, int points){
        int eachPoints = 0;
        if (points % winner.getRoster().length !=0){
            points -= points % winner.getRoster().length;
        }

        eachPoints = points / winner.getSize();
        for (int i = 0; i < winner.getRoster().length;i++){
            winner.getRoster()[i].addGameResult(eachPoints);
        }
        awardLooser(winner);
    }

    public void awardLooser( Team winner){
        /*
        Distribute points to looser Team automatically
        */
        if (this.firstTeam == winner){
            for (int i = 0; i < winner.getRoster().length;i++){
                this.sTeam.getRoster()[i].addGameResult(0);
            }
        }else
        for (int i = 0; i < winner.getRoster().length;i++){
            this.firstTeam.getRoster()[i].addGameResult(0);
        }
    }

    public String toString() {
        if(!this.validGame()) {
        return ("Not a valid game");
        }
        String result = "Team rosters:" + "\n";
        for (int i = 0; i < this.firstTeam.getSize(); i++){
        result += firstTeam.getRoster()[i].getName() + "\t" + sTeam.getRoster()[i].getName() + "\n";
        }
        
    
        return result;
    }
}
