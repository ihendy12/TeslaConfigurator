package org.example;

import java.util.Scanner;

public class Main implements Runnable, UserInterfaceTesla {
    private Scanner keyboard = new Scanner(System.in);

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
                int modelChoice = keyboard.nextInt();

                //MODEL 3
                if (modelChoice == 1){
                    display3TrimLevels();
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