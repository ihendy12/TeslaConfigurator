package org.example;

import java.util.Scanner;

public class Main implements Runnable, UserInterfaceTesla {
    private Scanner keyboard = new Scanner(System.in);
    int modelChoice = 0;
    int trimChoice = 0;
    int exteriorChoice = 0;
    int wheelChoice = 0;
    int towChoice = 0;
    int interiorChoice = 0;
    int seatsChoice = 0;
    int autoPilotChoice = 0;
    int chargingChoice = 0;




    public static void main(String[] args) {

        Main main = new Main();
        main.run();

    }

    @Override
    public void run() {
        boolean run = true;
        //MAIN MENU

        while(run) {
            printMainMenu();

            int mainMenuChoice = keyboard.nextInt();


            //SENDS TO BUILDER
            if (mainMenuChoice == 1) {

                //Choose a Model
                displayModels();
                modelChoice = keyboard.nextInt();

                //MODEL 3
                if (modelChoice == 1){
                    display3TrimLevels();
                    trimChoice = keyboard.nextInt();

                    //If Performance, this way since they have some features provided that are options elsewhere
                    if (trimChoice == 3){

                        display3PerformanceWheelType();
                        wheelChoice = keyboard.nextInt();

                        display3AndYExteriorColors();
                        exteriorChoice = keyboard.nextInt();

                        display3AndYInteriorColors();
                        interiorChoice = keyboard.nextInt();

                        display3AndSTow();
                        towChoice = keyboard.nextInt();

                        displayNumberOfSeats3AndS();
                        seatsChoice = keyboard.nextInt();

                        displayAutopilotTypes();
                        autoPilotChoice = keyboard.nextInt();

                        displayChargingTypes();
                        chargingChoice =keyboard.nextInt();

                    } else {
                        display3WheelTypes();
                        wheelChoice = keyboard.nextInt();

                        display3AndYExteriorColors();
                        exteriorChoice = keyboard.nextInt();

                        display3AndYInteriorColors();
                        interiorChoice = keyboard.nextInt();

                        display3AndSTow();
                        towChoice = keyboard.nextInt();

                        displayNumberOfSeats3AndS();
                        seatsChoice = keyboard.nextInt();

                        displayAutopilotTypes();
                        autoPilotChoice = keyboard.nextInt();

                        displayChargingTypes();
                        chargingChoice =keyboard.nextInt();

                    }

                    displayTotalPricing();
                    System.out.println("Here is your configuration");
                    System.out.println();
                    System.out.println(modelChoice);
                    System.out.println(trimChoice);
                    System.out.println(exteriorChoice);
                    System.out.println(wheelChoice);
                    System.out.println(interiorChoice);
                    System.out.println(autoPilotChoice);
                    System.out.println(chargingChoice);
                    System.out.println(towChoice);
                    System.out.println(seatsChoice);
                    System.out.println();
                    System.out.println("Total Price: ");

                    endOfProgram();
                    run = false;


                }






                //MODEL Y
                else if (modelChoice == 2){
                    displayYTrimLevels();
                }


                //MODEL S
                else if (modelChoice == 3){
                    displaySTrimLevels();
                }


                //MODEL X
                else if(modelChoice == 4){
                    displayXTrimLevels();
                }


            }
            //ENDS PROGRAM
            else if (mainMenuChoice == 2) {
                run = false;
                endOfProgram();
            }

        }


    }



}