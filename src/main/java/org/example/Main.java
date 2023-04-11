package org.example;
import org.example.Dao.JdbcModelDao;
import org.apache.commons.dbcp2.BasicDataSource;
import org.example.Dao.ModelDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


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

    final String url =  "jdbc:postgresql://localhost:5432/TeslaConfigurator";
    final String user = "postgres";
    final String pass = "Fall2022!";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, pass);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage() + e.getSQLState());
        }
        return conn;
    }




    public static void main(String[] args) {
        Main main = new Main();
        main.connect();
        main.run();


    }

    @Override
    public void run() {
        boolean run = true;
        boolean endRequested =  false;

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/TeslaConfigurator");
        dataSource.setUsername("postgres");
        dataSource.setPassword("Fall2022!");
        ModelDao model = new JdbcModelDao(dataSource);

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
                    System.out.println(model.getModel(modelChoice).getName() + "  " + model.getModel(modelChoice).getPrice());
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
                    trimChoice = keyboard.nextInt();

                    if (trimChoice == 2){
                        displayYPerformanceWheels();
                        wheelChoice = keyboard.nextInt();

                        display3AndYExteriorColors();
                        exteriorChoice = keyboard.nextInt();

                        display3AndYInteriorColors();
                        interiorChoice = keyboard.nextInt();

                        displayYTowing();
                        towChoice = keyboard.nextInt();

                        displayYPerformanceSeats();
                        seatsChoice = keyboard.nextInt();

                        displayAutopilotTypes();
                        autoPilotChoice = keyboard.nextInt();

                        displayChargingTypes();
                        chargingChoice = keyboard.nextInt();

                    } else {

                        displayYWheelTypes();
                        wheelChoice = keyboard.nextInt();

                        display3AndYExteriorColors();
                        exteriorChoice = keyboard.nextInt();

                        display3AndYInteriorColors();
                        interiorChoice = keyboard.nextInt();

                        displayYTowing();
                        towChoice = keyboard.nextInt();

                        displayYSeatChoice();
                        seatsChoice = keyboard.nextInt();

                        displayAutopilotTypes();
                        autoPilotChoice = keyboard.nextInt();

                        displayChargingTypes();
                        chargingChoice = keyboard.nextInt();

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


                //MODEL S
                else if (modelChoice == 3){
                    displaySTrimLevels();
                    trimChoice = keyboard.nextInt();

                    displaySWheelTypes();
                    wheelChoice = keyboard.nextInt();

                    displaySAndXExteriorColors();
                    exteriorChoice = keyboard.nextInt();

                    displaySAndXInteriorColors();
                    interiorChoice = keyboard.nextInt();

                    display3AndSTow();
                    towChoice = keyboard.nextInt();

                    displayNumberOfSeats3AndS();
                    seatsChoice = keyboard.nextInt();

                    displayAutopilotTypes();
                    autoPilotChoice = keyboard.nextInt();

                    displayChargingTypes();
                    chargingChoice = keyboard.nextInt();

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


                //MODEL X
                else if(modelChoice == 4){
                    displayXTrimLevels();
                    trimChoice = keyboard.nextInt();

                    displayXWheelTypes();
                    wheelChoice = keyboard.nextInt();

                    displaySAndXExteriorColors();
                    exteriorChoice = keyboard.nextInt();

                    displaySAndXInteriorColors();
                    interiorChoice = keyboard.nextInt();

                    displayXTowPackage();
                    towChoice = keyboard.nextInt();

                    displayXSeats();
                    seatsChoice = keyboard.nextInt();

                    displayAutopilotTypes();
                    autoPilotChoice = keyboard.nextInt();

                    displayChargingTypes();
                    chargingChoice = keyboard.nextInt();

                    displayTotalPricing();
                    System.out.println("Here is your configuration");
                    System.out.println();
                    System.out.println(model.getModel(modelChoice));
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


            }
            // RETURNS EXISTING ORDERS
            else if (mainMenuChoice == 2){
                System.out.println("Currently working on this section, come back later!");
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            //ENDS PROGRAM
            else if (mainMenuChoice == 3) {
                run = false;
                endOfProgram();
            }

        }


    }



}