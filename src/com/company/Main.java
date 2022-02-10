package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        LinkedPlayerList playerList = new LinkedPlayerList();
        readFromFile(playerList);
        menu(playerList, scan);


    }
    public static void menu(LinkedPlayerList playerList, Scanner scan) throws FileNotFoundException {

            System.out.printf("""
                                    
                    Velkommen til The Football Club
                    *******************************
                    Du har nu 6 valgmuligheder
                                    
                    Tast 1 for at oprette et nyt medlem
                    Tast 2 for at se alle medlemmer
                    Tast 3 for at søge efter et medlem
                    Tast 4 for at slette et medlem
                    Tast 5 for at se første holdet eller andet holdet
                    Tast 6 for at afslutte programmet
                    """);
            int answer = scan.nextInt();
            switch (answer) {
                case 1:
                    create(scan, playerList);
                    System.out.println("Vender tilbage til menu...");
                    menu(playerList, scan);
                    break;
                case 2:
                    show(playerList);
                    int choice = scan.nextInt();
                    switch (choice){
                        case 1:
                            System.out.println("Vender tilbage til menu...");
                            menu(playerList, scan);
                            break;
                        case 2:
                            break;
                    }
                    break;
                case 3:
                    show(playerList);
                    System.out.println("Indtast navnet på den personen du søger: ");
                    String name = scan.next();
                    System.out.println(playerList.search(name, playerList));
                    break;
                case 4:
                    show(playerList);
                    System.out.println("Indtast index for den person du gerne vil slette: ");
                    playerList.remove(scan.nextInt());
                    break;
                case 5:
                    //sort();
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        }
    public static void create(Scanner scan, LinkedPlayerList playerList) throws FileNotFoundException {
        System.out.println("Fornavn: ");
        String name = scan.next();
        System.out.println("Efternavn: ");
        String lname = scan.next();
        System.out.println("Alder: ");
        int age = scan.nextInt();
        System.out.println("Går personen på førsteholdet?");
        String team = scan.next();
        boolean team1;
        if (team.equalsIgnoreCase("ja")){
            team1 = true;
        } else {
            team1 = false;
        }
        Random rand = new Random();
        int id = rand.nextInt();

        playerList.add(new FootballPlayer(name, lname, age, team1, id));
        writeToFile(playerList);
    }

    public static void show(LinkedPlayerList playerList) {
        for (int i = 0; i < playerList.size(); i++) {
            System.out.println((i + 1) +": "+ playerList.get(i));
        }
    }
    public static void writeToFile(LinkedPlayerList playerList) throws FileNotFoundException {
        PrintStream out = new PrintStream(new File("players.txt"));
        for (int i = 0; i < playerList.size(); i++)
            out.println(playerList.get(i));
    }
    public static void readFromFile(LinkedPlayerList playerList) throws FileNotFoundException{
        Scanner fileScan = new Scanner(new File("players.txt"));
        while (fileScan.hasNextLine()) {
            String line = fileScan.nextLine();
        Scanner lineScan = new Scanner(line);
            String name = lineScan.next();
            String lastName = lineScan.next();
            int age = lineScan.nextInt();
            boolean team = true;
            int id = lineScan.nextInt();
            FootballPlayer newPlayer = new FootballPlayer(name, lastName, age, team, id);
            playerList.add(newPlayer);
        }
    }
}
