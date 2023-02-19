/**
* Player
*
* COMP 1020 SECTION A03
* INSTRUCTOR Ali Neshati
* ASSIGNMENT 1
* @author Bhavik Jain, 7927054
* @version March 6th, 2022
*
* PURPOSE: To create a class named Player
*/

public class Player {
    private String name;
    private int count ;
    private int average;
    private int score;
    Location place;
    
    
    public Player(String name){
        this.name = name;
        int count = 0;
        int score = 0;

    }

    public Player(String name, Location place){
        this.name = name;
        int count = 0;
        int score = 0;
        this.place = place;
        place.addMember(this);
    }

    public void addGameResult(int newScore){
        average = 0;
        score += newScore;
        count++;
        average = score/count;
    }

    public boolean equals(Player other){
        return this.name.equals(other.name);
    }

    public String toString(){
        if (count ==0){
            return "Player: " + this.name + " has played no games";
        }else{
            return "Player: " + this.name + " has played " + count + " game with average of " + average;
        }
    }

    public String getName(){
        return this.name;
    }
}
