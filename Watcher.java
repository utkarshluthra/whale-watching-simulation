package Whales;
import java.util.*;
import java.io.*;

// Class to define properties and characteristics of a watcher.
// Assuming each location to have 1 watcher, for this code, will be assuming that watcher and location are synonymous (As per specifications).
public class Watcher {

    ArrayList<Whale> whales = new ArrayList<>();
    private String Name;
    private int HumpbackA = 0, MinkeA = 0, SouthernA = 0, BlueA = 0, OrcaA = 0, HumpbackC = 0, MinkeC = 0, SouthernC = 0, BlueC = 0, OrcaC = 0;
    private int adult_count = 0, calf_count = 0;
    private int rare_count = 0;
    private int MigalooCount = 0;
    private int report[];
    private int wwld = 0;
    
    //Accessors
    public String getName() {
        return this.Name;
    }
    public int getHumpbackA() {
        return this.HumpbackA;
    }
    public int getMinkeA() {
        return this.MinkeA;
    }
    public int getSouthernA() {
        return this.SouthernA;
    }
    public int getBlueA() {
        return this.BlueA;
    }
    public int getOrcaA() {
        return this.OrcaA;
    }
    public int getHumpbackC() {
        return this.HumpbackC;
    }
    public int getMinkeC() {
        return this.MinkeC;
    }
    public int getSouthernC() {
        return this.SouthernC;
    }
    public int getBlueC() {
        return this.BlueC;
    }
    public int getOrcaC() {
        return this.OrcaC;
    }
    public int getAdult_count() {
        return this.adult_count;
    }
    public int getCalf_count() {
        return this.calf_count;
    }
    public int getMigalooCount() {
        return this.MigalooCount;
    }
    public int[] getReport() {
        return this.report;
    }
    public int getWwld() {
        return wwld;
    }
    public int getRare_count() {
        return rare_count;
    }
    //Modifiers
    public void changeName(String s){
        this.Name=s;        
    }
    public void changeArray(int [] arr){
        this.report=arr;
    }


    // Method to register all changes.
    public void register() {
        for (int i = 0; i < whales.size(); i++) {
            String species = whales.get(i).getSpecies();
            switch (species) {
                case "Humpback":
                    this.HumpbackA++;
                    this.adult_count++;
                    if (whales.get(i).getMigaloo()) {
                        this.MigalooCount++;
                    }
                    if (whales.get(i).getAccompany() > 0) {
                        this.HumpbackC += whales.get(i).getAccompany();
                        this.calf_count += whales.get(i).getAccompany();
                    }
                    break;
                case "Minke":
                    this.MinkeA++;
                    this.adult_count++;
                    if (whales.get(i).getAccompany() > 0) {
                        this.calf_count += whales.get(i).getAccompany();
                        this.MinkeC += whales.get(i).getAccompany();
                    }
                    break;
                case "Southern Right":
                    this.SouthernA++;
                    this.adult_count++;
                    if (whales.get(i).getAccompany()> 0) {
                        this.calf_count += whales.get(i).getAccompany();
                        this.SouthernC += whales.get(i).getAccompany();
                    }
                    break;
                case "Blue":
                    this.BlueA++;
                    this.adult_count++;
                    if (whales.get(i).getAccompany()> 0) {
                        this.calf_count += whales.get(i).getAccompany();
                        this.BlueC += whales.get(i).getAccompany();
                    }
                    break;
                case "Orac":
                    this.OrcaA++;
                    this.adult_count++;
                    if (whales.get(i).getAccompany()> 0) {
                        this.calf_count += whales.get(i).getAccompany();
                        this.OrcaC += whales.get(i).getAccompany();
                    }
                    break;
                default:

                    break;
            }
        }
        this.wwld = this.adult_count + 2 * this.calf_count + 4 * this.rare_count + 10 * this.MigalooCount;
        this.rare_count = this.BlueA + this.BlueC + this.OrcaA + this.OrcaC;

    }
}
