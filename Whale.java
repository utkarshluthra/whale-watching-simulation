package Whales;
import java.util.*;
import java.io.*;

// Class to define the characteristics of a whale
public class Whale {
    private String species; // One of Humpback, Minke, Southern, Blue, Orca
    private int accompany; // Number of calves accompanied
    private boolean injury; // 0 is no injury, 1 means injured
    private boolean direction; // 0 is north, 1 is south
    private boolean Migaloo;

    
    // Accessors
    public String getSpecies(){
        return this.species;
    }
    public int getAccompany(){
        return this.accompany;
    }
    public boolean getInjury(){
        return this.injury;
    }
    public String showDirection(){
        String dir = this.direction?"South":"North";
        return dir;
    }
    public boolean getMigaloo(){
        return this.Migaloo;
    }

    // Mutators
    void addSpecies(String s){
        this.species=s;
    }
    void addAccompany(int a){
        this.accompany+=a;
    }
    void changeInjury(boolean a){
        this.injury=a;
    }
    void changeDirection(boolean a){
        this.direction=a;
    }
    void changeMigaloo(boolean a){
        this.Migaloo=a;
    }


}
