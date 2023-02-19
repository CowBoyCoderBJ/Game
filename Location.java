/**
* Location
*
* COMP 1020 SECTION A03
* INSTRUCTOR Ali Neshati
* ASSIGNMENT 1
* @author Bhavik Jain, 7927054
* @version March 6th, 2022
*
* PURPOSE: To create a class named Location
*/

public class Location {
    private String name;
    private String address;
    private Player[] memberList = new Player[999];
    private int totalMembers = 0;
    private static Location[] locationsList = new Location[999];
    private static int count = 0;
    
    public Location(String name,String address){
        this.name = name;
        this.address = address;
        locationsList[count] = this;
        int totalMembers = 0;
        count++;
    }

    public void addMember(Player newbie){
        if (!hasCommonMembers(newbie)){
            memberList[totalMembers] = newbie;
            totalMembers++;
        }
    }

    public boolean hasCommonMembers(Player otherMember){
        for(int i = 0;i<totalMembers;i++){
                if (memberList[i].getName() == otherMember.getName() ){
                    return true;
                }
            }
    
        return false;
    }

    public static String allLocationNames(){
        String result = "";
        for( int i = 0; i < count;i++){
            result += locationsList[i].name + "\n";
        }
        return result;
    }

    public static String whichLocations(Player who){
        String result = who.getName() + " is a member at: " + "\n";
        for (int i = 0; i < count; i++){
            for (int j =0; j < locationsList[i].totalMembers; j++){
                if (locationsList[i].memberList[j] == who){
                    result += locationsList[i].name + "\n";
                }
            }
        }
        return result;
    }

    public String toString(){
    String result = "Membership list for " + this.name + " , " + this.address + "\n";
    for(int i=0; i< totalMembers; i++) {
        result += memberList[i].toString() + "\n";
    }
    return result;
    }   

}
