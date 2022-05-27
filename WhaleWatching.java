package Whales;

import Whales.Watcher;
import Whales.Whale;
import java.util.*;
import java.io.*;

// The main class which has all execution elements.
public class WhaleWatching {
    // Welcome method
    static void welcome() {
        System.out.println("Hello. Welcome to the whale watching program");
    }

    public static void main(String args[]) {
        // Enter code here
        welcome();
        Scanner input = new Scanner(System.in);
        // Eden, Jervis Bay, Byron Bay, Hervey Bay
        Watcher Eden = new Watcher();
        Watcher Jervis = new Watcher();
        Watcher Byron = new Watcher();
        Watcher Hervey = new Watcher();

        System.out.print("Enter name of Watcher at Eden: ");
        Eden.changeName(input.nextLine());
        System.out.print("Enter name of Watcher at Jervis Bay: ");
        Jervis.changeName(input.nextLine());
        System.out.print("Enter name of Watcher at Byron Bay: ");
        Byron.changeName(input.nextLine());
        System.out.print("Enter name of Watcher at Hervey Bay: ");
        Hervey.changeName(input.nextLine());

        // Reading from seasonobservation
        try {
            File fh = new File("seasonObservation.txt");
            Scanner reader = new Scanner(fh);
            String data = "";
            for (int i = 0; i < 4; i++) {
                data = reader.nextLine();
                String[] elements = data.split(",");
                int rec[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
                for (int j = 0; j < 11; j++) {
                    rec[j] = Integer.parseInt(elements[j]);
                }
                Eden.changeArray(rec);

                switch (i) {
                    case 0:
                        Eden.changeArray(rec);
                        break;
                    case 1:
                        Jervis.changeArray(rec);
                        break;
                    case 2:
                        Byron.changeArray(rec);
                        break;
                    case 3:
                        Hervey.changeArray(rec);
                        break;
                }
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error in file");
        }

        Random random = new Random();
        int WhaleCount = random.nextInt(10);
        // iterating across locations
        for (int k = 0; k < 4; k++) {
            // iterating across whale count
            for (int i = 0; i < WhaleCount; i++) {
                Whale a = new Whale();

                int speciesNumber = random.nextInt(100);
                if (speciesNumber < 50 && speciesNumber >= 0) {
                    a.addSpecies("Humpback");
                    if (random.nextInt(100) == 1) {
                        a.changeMigaloo(true);
                    }
                } else if (speciesNumber < 75 && speciesNumber >= 50) {
                    a.addSpecies("Minke");
                } else if (speciesNumber < 95 && speciesNumber >= 75) {
                    a.addSpecies("Southern Right");
                } else if (speciesNumber < 98 && speciesNumber >= 95) {
                    a.addSpecies("Blue");
                    ;
                } else {
                    a.addSpecies("Orca");
                }
                if (random.nextInt(2) == 1) {
                    a.changeDirection(true);
                    a.addAccompany(random.nextInt(2));
                } else {
                    a.changeDirection(false);
                }
                if (random.nextInt(100) < 10) {
                    a.changeInjury(true);
                }
                switch (k) {
                    case 0:
                        Eden.whales.add(a);
                        Eden.register();
                        break;
                    case 1:
                        Jervis.whales.add(a);
                        Jervis.register();
                        break;
                    case 2:
                        Byron.whales.add(a);
                        Byron.register();
                        break;
                    case 3:
                        Hervey.whales.add(a);
                        Hervey.register();
                        break;
                }
            }

            // To give summary of each location
            switch (k) {
                case 0:
                    System.out.println("\nEDEN");
                    System.out.print("Total Number of Whales");
                    System.out.println(Eden.getAdult_count() + Eden.getCalf_count());
                    for (Whale whaleI : Eden.whales) {
                        System.out.println("\n");
                        if (whaleI.getMigaloo()) {
                            System.out.println(
                                    "A Migaloo is sighted. It is traveling towards the " + whaleI.showDirection()
                                            + " direction.");
                            System.out.println("Injury: " + whaleI.getInjury());
                            continue;
                        }
                        System.out.println("Species: " + whaleI.getSpecies());
                        System.out.println("Direction: " + whaleI.showDirection());
                        System.out.println("Accompanying Calves: " + whaleI.getAccompany());
                        System.out.println("Injured: " + whaleI.getInjury());
                    }
                    break;
                case 1:
                    System.out.println("\nJERVIS BAY");
                    System.out.print("Total Number of Whales");
                    System.out.println(Jervis.getAdult_count() + Jervis.getCalf_count());
                    for (Whale whaleI : Jervis.whales) {
                        System.out.println("\n");
                        if (whaleI.getMigaloo()) {
                            System.out.println(
                                    "A Migaloo is sighted. It is traveling towards the " + whaleI.showDirection()
                                            + " direction.");
                            System.out.println("Injury: " + whaleI.getInjury());
                            continue;
                        }
                        System.out.println("Species: " + whaleI.getSpecies());
                        System.out.println("Direction: " + whaleI.showDirection());
                        System.out.println("Accompanying Calves: " + whaleI.getAccompany());
                        System.out.println("Injured: " + whaleI.getInjury());
                    }
                    break;
                case 2:
                    System.out.println("\nBYRON BAY");
                    System.out.print("Total Number of Whales");
                    System.out.println(Byron.getAdult_count() + Byron.getCalf_count());
                    for (Whale whaleI : Byron.whales) {
                        System.out.println("\n");
                        if (whaleI.getMigaloo()) {
                            System.out.println(
                                    "A Migaloo is sighted. It is traveling towards the " + whaleI.showDirection()
                                            + " direction.");
                            System.out.println("Injury: " + whaleI.getInjury());
                            continue;
                        }
                        System.out.println("Species: " + whaleI.getSpecies());
                        System.out.println("Direction: " + whaleI.showDirection());
                        System.out.println("Accompanying Calves: " + whaleI.getAccompany());
                        System.out.println("Injured: " + whaleI.getInjury());
                    }
                    break;
                case 3:
                    System.out.println("\nHERVEY BAY");
                    System.out.print("Total Number of Whales");
                    System.out.println(Hervey.getAdult_count() + Hervey.getCalf_count());
                    for (Whale whaleI : Hervey.whales) {
                        System.out.println("\n");
                        if (whaleI.getMigaloo()) {
                            System.out.println(
                                    "A Migaloo is sighted. It is traveling towards the " + whaleI.showDirection()
                                            + " direction.");
                            System.out.println("Injury: " + whaleI.getInjury());
                            continue;
                        }
                        System.out.println("Species: " + whaleI.getSpecies());
                        System.out.println("Direction: " + whaleI.showDirection());
                        System.out.println("Accompanying Calves: " + whaleI.getAccompany());
                        System.out.println("Injured: " + whaleI.getInjury());
                    }
                    break;
            }

        }

        // To give overall summary
        int HumpbackACount = Eden.getHumpbackA() + Jervis.getHumpbackA() + Byron.getHumpbackA() + Hervey.getHumpbackA();
        int MinkeACount = Eden.getMinkeA() + Jervis.getMinkeA() + Byron.getMinkeA() + Hervey.getMinkeA();
        int SouthernACount = Eden.getSouthernA() + Jervis.getSouthernA() + Byron.getSouthernA() + Hervey.getSouthernA();
        int BlueACount = Eden.getBlueA() + Jervis.getBlueA() + Byron.getBlueA() + Hervey.getBlueA();
        int OrcaACount = Eden.getOrcaA() + Jervis.getOrcaA() + Byron.getOrcaA() + Hervey.getOrcaA();

        int totalcalves = Eden.getCalf_count() + Jervis.getCalf_count() + Byron.getCalf_count()
                + Hervey.getCalf_count();

        boolean Migaloo = false;
        if (Eden.getMigalooCount() + Jervis.getMigalooCount() + Byron.getMigalooCount()
                + Hervey.getMigalooCount() == 0) {
            Migaloo = false;
        } else {
            Migaloo = true;
        }

        int WWLDArray[] = { Eden.getWwld(), Jervis.getWwld(), Byron.getWwld(), Hervey.getWwld() };
        Arrays.sort(WWLDArray);
        int maxAt = 0;
        for (int i = 0; i < WWLDArray.length; i++) {
            if (WWLDArray[i] > WWLDArray[maxAt]) {
                maxAt = i;
            } else {
                continue;
            }
        }

        System.out.println("\nSUMMARY\n");

        System.out.println("1. Humpback: " + HumpbackACount);
        System.out.println("2. Southern Right: " + MinkeACount);
        System.out.println("3. Minke: " + SouthernACount);
        System.out.println("4. Blue: " + BlueACount);
        System.out.println("5. Orca: " + OrcaACount);

        System.out.println("\nTotal Calves: " + totalcalves);
        System.out.println("\nMigalo  Sighted : " + Migaloo);

        System.out.print("Highest WWLD: ");
        switch (maxAt) {
            case 0:
                System.out.println("Eden");
                break;
            case 1:
                System.out.println("Jervis Bay");
                break;
            case 2:
                System.out.println("Byron Bay");
                break;
            case 3:
                System.out.println("Hervey Bay");
                break;
        }

        int[] edenArray = { Eden.getHumpbackA(), Eden.getMinkeA(), Eden.getSouthernA(), Eden.getBlueA(),
                Eden.getOrcaA(), Eden.getHumpbackC(), Eden.getMinkeC(), Eden.getSouthernC(), Eden.getBlueC(),
                Eden.getOrcaC(), Eden.getWwld() };

        int[] jervisArray = { Jervis.getHumpbackA(), Jervis.getMinkeA(), Jervis.getSouthernA(), Jervis.getBlueA(),
                Jervis.getOrcaA(), Jervis.getHumpbackC(), Jervis.getMinkeC(), Jervis.getSouthernC(),
                Jervis.getBlueC(), Jervis.getOrcaC(), Jervis.getWwld() };

        int[] byronArray = { Byron.getHumpbackA(), Byron.getMinkeA(), Byron.getSouthernA(), Byron.getBlueA(),
                Byron.getOrcaA(), Byron.getHumpbackC(), Byron.getMinkeC(), Byron.getSouthernC(), Byron.getBlueC(),
                Byron.getOrcaC(), Byron.getWwld() };

        int[] herveyArray = { Hervey.getHumpbackA(), Hervey.getMinkeA(), Hervey.getSouthernA(), Hervey.getBlueA(),
                Hervey.getOrcaA(), Hervey.getHumpbackC(), Hervey.getMinkeC(), Hervey.getSouthernC(), Hervey.getBlueC(),
                Hervey.getOrcaC(), Hervey.getWwld() };

        try {
            File fh = new File("seasonObservation.txt");
            
            Scanner reader = new Scanner(fh);
            String data = "";
            String line ="";
            for (int i = 0; i < 4; i++) {
                data = reader.nextLine();
                String[] elements = data.split(",");
                int rec[] = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
                for (int j = 0; j < 11; j++) {
                    rec[j] = Integer.parseInt(elements[j]);
                }
                switch (i) {
                    case 0:
                        for (int j = 0; j < rec.length; j++) {
                            rec[i] = rec[i] + edenArray[i];
                        }
                        line=line+"\n"+Arrays.toString(rec);
                        break;
                    case 1:
                        for (int j = 0; j < rec.length; j++) {
                            rec[i] = rec[i] + jervisArray[i];
                        }
                        line=line+"\n"+Arrays.toString(rec);
                        break;
                    case 2:
                        for (int j = 0; j < rec.length; j++) {
                            rec[i] = rec[i] + byronArray[i];
                        }
                        line=line+"\n"+Arrays.toString(rec);
                        break;
                    case 3:
                        for (int j = 0; j < rec.length; j++) {
                            rec[i] = rec[i] + herveyArray[i];
                        }
                        line=line+"\n"+Arrays.toString(rec);
                        break;
                }

            }
            FileWriter Writer = new FileWriter(fh);
            Writer.write(line);
            reader.close();
            Writer.close();
            System.out.println("Successfully updated season data");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }

        input.close();

    }
}