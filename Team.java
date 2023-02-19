/**
* Team
*
* COMP 1020 SECTION A03
* INSTRUCTOR Ali Neshati
* ASSIGNMENT 1
* @author Bhavik Jain, 7927054
* @version March 6th, 2022
*
* PURPOSE: To create a class named Team
*/

public class Team {
    private static final int MAX_SIZE = 5;
    private  Player[] teamList;
    private int totalPlayers;

    public Team(){
        totalPlayers = 0;
        teamList = new Player[MAX_SIZE];

    }

    public int getSize(){
        return MAX_SIZE;
    }

    public boolean addMember(Player newOne){
        for (int i=0;i<totalPlayers;i++){
            if (teamList[i].getName() == newOne.getName()){
                
                 return false;
            }
        }
        if (totalPlayers == MAX_SIZE){
            return false;}
        
        teamList[totalPlayers] = newOne;
        totalPlayers++;
        return true;
        
        }
    
    public String toString(){
        String result = "Team members:" ;
        for (int i = 0;i < totalPlayers;i++){
            result += "\n";
            result += i+1+ ": " + teamList[i].getName();
        }
        return result;

    }

    public boolean hasCommonPlayers(Team other){
        for(int i = 0;i<MAX_SIZE;i++){
            for(int j = 0;j<MAX_SIZE;j++){
                if (other.teamList[j] == this.teamList[i] ){
                    return true;
                    
                }
            }
    }
        return false;
    }

    public boolean teamFull(){
        if (totalPlayers == MAX_SIZE){
            return true;
        }
        return false;
    }

    public boolean removePlayer(Player toRemove){
        int index = 0;
        for (int i=0;i<totalPlayers;i++){
            if (teamList[i] == toRemove){
                index = i;
            }else{
                 return false;
            }   
        }

        for (int i = index; i < totalPlayers;i++){
            teamList[i] = teamList[i+1];
        }
        totalPlayers--;
        return true;

    }

    public Player[] getRoster(){
        Player[] deepCopy = new Player[totalPlayers];
        for(int i = 0; i < totalPlayers; i++){
            deepCopy[i] = teamList[i];

        }
        return deepCopy;
    }

}


    

