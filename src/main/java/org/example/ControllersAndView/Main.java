package org.example.ControllersAndView;
import org.example.Dao.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.example.Dao.Jdbc.*;
import org.example.models.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.*;

import static java.util.logging.Level.OFF;


public class Main implements Runnable, UserInterfaceTesla, BasicConsole {


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
    int returnToMenu = 0;

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


    private final static Logger LOGGER =
            Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    public void turnOffLogger()
    {
        LOGGER.setLevel(OFF);
    }


    public static void main(String[] args) {
        Main main = new Main();
        main.connect();
        main.run();
        main.turnOffLogger();
        LogManager lgmngr = LogManager.getLogManager();

        Logger log = lgmngr.getLogger(Logger.GLOBAL_LOGGER_NAME);
        log.setLevel(Level.OFF);





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
        TrimDao trim = new JdbcTrimDao(dataSource);
        ExteriorDao exterior = new JdbcExteriorDao(dataSource);
        WheelDao wheel = new JdbcWheelDao(dataSource);
        InteriorDao interior = new JdbcInteriorDao(dataSource);
        AutopilotDao autopilot = new JdbcAutopilotDao(dataSource);
        ChargingDao charging = new JdbcChargingDao(dataSource);
        SeatDao seat = new JdbcSeatDao(dataSource);
        TowDao tow = new JdbcTowDao(dataSource);
        CustomerDao customer = new JdbcCustomerDao(dataSource);

        //MAIN MENU

        while(run) {
            lineSegments();
            printMainMenu();

            int mainMenuChoice = keyboard.nextInt();


            //SENDS TO BUILDER
            if (mainMenuChoice == 1) {
                lineSegments();
                //Choose a Model
                displayModels();
                modelChoice = keyboard.nextInt();

                //MODEL 3
                if (modelChoice == 1){
                    lineSegments();
                    display3TrimLevels();
                    trimChoice = keyboard.nextInt();

                    //If Performance, this way since they have some features provided that are options elsewhere
                    if (trimChoice == 3){
                        lineSegments();
                        trimChoice = trim.getTrimName("3 Performance").getTrimId();
                        display3PerformanceWheelType();
                        wheelChoice = keyboard.nextInt();
                        wheelChoice = wheel.getWheelName("20\" Uberturbine Wheels").getWheelId();
                        lineSegments();
                        display3AndYExteriorColors();
                        exteriorChoice = keyboard.nextInt();
                        if (exteriorChoice == 1) {

                            exteriorChoice = exterior.getExteriorName("3&Y Pearl White").getExteriorId();
                        } else if (exteriorChoice == 2) {
                            exteriorChoice = exterior.getExteriorName("3&Y Midnight Silver").getExteriorId();
                        } else if (exteriorChoice == 3){
                            exteriorChoice = exterior.getExteriorName("3&Y Deep Blue Metallic").getExteriorId();
                        } else if (exteriorChoice == 4){
                            exteriorChoice = exterior.getExteriorName("3&Y Solid Black").getExteriorId();
                        } else if (exteriorChoice == 5){
                            exteriorChoice = exterior.getExteriorName("3&Y Red Multi-Coat").getExteriorId();
                        }
                        lineSegments();
                        display3AndYInteriorColors();
                        interiorChoice = keyboard.nextInt();
                        if (interiorChoice == 1){
                            interiorChoice = interior.getInteriorName("3&Y Black").getInteriorId();
                        } else if (interiorChoice == 2){
                            interiorChoice = interior.getInteriorName("3&Y White").getInteriorId();
                        }
                        lineSegments();
                        display3AndSTow();
                        towChoice = keyboard.nextInt();
                            towChoice = tow.getTowName("NOT OFFERED ON THIS MODEL").getTowId();
                        lineSegments();
                        displayNumberOfSeats3AndS();
                        seatsChoice = keyboard.nextInt();
                            seatsChoice = seat.getSeatName("5 Seats").getSeatId();
                        lineSegments();
                        displayAutopilotTypes();
                        autoPilotChoice = keyboard.nextInt();
                        if (autoPilotChoice == 1){
                            autoPilotChoice = autopilot.getAutopilotName("Autopilot").getAutopilotId();
                        } else if (autoPilotChoice == 2){
                            autoPilotChoice = autopilot.getAutopilotName("Enhanced Autopilot").getAutopilotId();
                        } else if (autoPilotChoice == 3){
                            autoPilotChoice = autopilot.getAutopilotName("Full-Self Driving").getAutopilotId();
                        }
                        lineSegments();
                        displayChargingTypes();
                        chargingChoice =keyboard.nextInt();
                        if (chargingChoice == 1){
                            chargingChoice = charging.getChargingName("None").getChargingId();
                        } else if (chargingChoice == 2){
                            chargingChoice = charging.getChargingName("Mobile Bundle").getChargingId();
                        } else if (chargingChoice == 3){
                            chargingChoice = charging.getChargingName("Wall Connector").getChargingId();
                        }
                    } else {
                        if (trimChoice == 1) {
                            trimChoice = trim.getTrimName("3 Rear Wheel Drive").getTrimId();
                        } else if (trimChoice == 2) {
                            trimChoice = trim.getTrimName("3 Long Range").getTrimId();
                        }
                        lineSegments();
                        display3WheelTypes();
                        wheelChoice = keyboard.nextInt();
                        if(wheelChoice == 1){
                            wheelChoice = wheel.getWheelName("18\" Aero Wheels").getWheelId();
                        } else if(wheelChoice == 2){
                            wheelChoice = wheel.getWheelName("19\" Sport Wheels").getWheelId();
                        }
                        lineSegments();
                        display3AndYExteriorColors();
                        exteriorChoice = keyboard.nextInt();
                        if (exteriorChoice == 1) {
                            exteriorChoice = exterior.getExteriorName("3&Y Pearl White").getExteriorId();
                        } else if (exteriorChoice == 2) {
                            exteriorChoice = exterior.getExteriorName("3&Y Midnight Silver").getExteriorId();
                        } else if (exteriorChoice == 3){
                            exteriorChoice = exterior.getExteriorName("3&Y Deep Blue Metallic").getExteriorId();
                        } else if (exteriorChoice == 4){
                            exteriorChoice = exterior.getExteriorName("3&Y Solid Black").getExteriorId();
                        } else if (exteriorChoice == 5){
                            exteriorChoice = exterior.getExteriorName("3&Y Red Multi-Coat").getExteriorId();
                        }
                        lineSegments();
                        display3AndYInteriorColors();
                        interiorChoice = keyboard.nextInt();
                        if (interiorChoice == 1){
                            interiorChoice = interior.getInteriorName("3&Y Black").getInteriorId();
                        } else if (interiorChoice == 2){
                            interiorChoice = interior.getInteriorName("3&Y White").getInteriorId();
                        }
                        lineSegments();
                        display3AndSTow();
                        towChoice = keyboard.nextInt();
                             towChoice = tow.getTowName("NOT OFFERED ON THIS MODEL").getTowId();
                        lineSegments();
                        displayNumberOfSeats3AndS();
                        seatsChoice = keyboard.nextInt();
                            seatsChoice = seat.getSeatName("5 Seats").getSeatId();
                        lineSegments();
                        displayAutopilotTypes();
                        autoPilotChoice = keyboard.nextInt();
                            if (autoPilotChoice == 1){
                                autoPilotChoice = autopilot.getAutopilotName("Autopilot").getAutopilotId();
                            } else if (autoPilotChoice == 2){
                                autoPilotChoice = autopilot.getAutopilotName("Enhanced Autopilot").getAutopilotId();
                            } else if (autoPilotChoice == 3){
                                autoPilotChoice = autopilot.getAutopilotName("Full-Self Driving").getAutopilotId();
                            }
                        lineSegments();
                        displayChargingTypes();
                        chargingChoice =keyboard.nextInt();
                        if (chargingChoice == 1){
                            chargingChoice = charging.getChargingName("None").getChargingId();
                        } else if (chargingChoice == 2){
                            chargingChoice = charging.getChargingName("Mobile Bundle").getChargingId();
                        } else if (chargingChoice == 3){
                            chargingChoice = charging.getChargingName("Wall Connector").getChargingId();
                        }
                    }


                    lineSegments();
                    displayTotalPricing();
                    double total =  (tow.getTow(towChoice).getTowPrice() +
                                                model.getModel(modelChoice).getPrice() +
                                                trim.getTrim(trimChoice).getTrimPrice() +
                                                exterior.getExterior(trimChoice).getExteriorPrice() +
                                                wheel.getWheel(wheelChoice).getWheelPrice() +
                                                interior.getInterior(interiorChoice).getInteriorPrice() +
                                                autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice() +
                                                charging.getCharging(chargingChoice).getChargingPrice());

                    System.out.println("Here is your configuration");
                    System.out.println();
                    System.out.println("MODEL: " + model.getModel(modelChoice).getName() + "  " + model.getModel(modelChoice).getPrice());
                    System.out.println("TRIM: " + trim.getTrim(trimChoice).getTrimName() + "  " + trim.getTrim(trimChoice).getTrimPrice());
                    System.out.println("EXTERIOR COLOR: " + exterior.getExterior(exteriorChoice).getExteriorName() + "  " + exterior.getExterior(exteriorChoice).getExteriorPrice());
                    System.out.println("WHEELS: " + wheel.getWheel(wheelChoice).getWheelName() + "  " + wheel.getWheel(wheelChoice).getWheelPrice());
                    System.out.println("INTERIOR COLOR: " + interior.getInterior(interiorChoice).getInteriorName() + "  " + interior.getInterior(interiorChoice).getInteriorPrice());
                    System.out.println("AUTOPILOT LEVEL: " + autopilot.getAutopilot(autoPilotChoice).getAutopilotName() + "  " + autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice());
                    System.out.println("CHARGING: " + charging.getCharging(chargingChoice).getChargingName() + "  " + charging.getCharging(chargingChoice).getChargingPrice());
                    System.out.println("TOW HITCH: " + tow.getTow(towChoice).getTowConfirmed() + "  " + tow.getTow(towChoice).getTowPrice());
                    System.out.println("SEATS: " + seat.getSeat(seatsChoice).getNumOfSeats() + "  " + seat.getSeat(seatsChoice).getSeatPrice());
                    System.out.println();
                    System.out.println("Total Price: " + total);

                    System.out.println();
                    System.out.println();
                    lineSegments();
                    System.out.println("Would you like to save this configuration build?");
                    System.out.println();
                    System.out.println();
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int saveChoice = keyboard.nextInt();
                    if (saveChoice == 1){

                        Customer createdCustomer = new Customer();
                        createdCustomer.setModelId(modelChoice);
                        createdCustomer.setTrimId(trim.getTrim(trimChoice).getTrimId());
                        createdCustomer.setExteriorId(exteriorChoice);
                        createdCustomer.setWheelId(wheelChoice);
                        createdCustomer.setInteriorId(interiorChoice);
                        createdCustomer.setAutopilotId(autoPilotChoice);
                        createdCustomer.setChargingId(chargingChoice);
                        createdCustomer.setTowId(towChoice);
                        createdCustomer.setSeatId(seatsChoice);
                        createdCustomer.setTotalPrice((int) (tow.getTow(towChoice).getTowPrice() +
                                model.getModel(modelChoice).getPrice() +
                                trim.getTrim(trimChoice).getTrimPrice() +
                                exterior.getExterior(trimChoice).getExteriorPrice() +
                                wheel.getWheel(wheelChoice).getWheelPrice() +
                                interior.getInterior(interiorChoice).getInteriorPrice() +
                                autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice() +
                                charging.getCharging(chargingChoice).getChargingPrice()));

                        customer.createCustomer(createdCustomer);
                        lineSegments();
                        System.out.println("Your order number is : " + createdCustomer.getCustomerId());
                        System.out.println("Please save this for your records");
                        lineSegments();
                    } else if (saveChoice == 2){
                        continue;
                    }

                    returnToMain();
                    int returnToMainMenu = keyboard.nextInt();
                    if(returnToMainMenu == 1){
                        run();
                    } else if(returnToMainMenu == 2){
                        endOfProgram();
                        run = false;
                        System.exit(1);
                    }

                }






                //MODEL Y
                else if (modelChoice == 2){
                    lineSegments();
                    displayYTrimLevels();
                    trimChoice = keyboard.nextInt();

                    if (trimChoice == 2){
                        trimChoice = trim.getTrimName("Y Performance").getTrimId();


                        lineSegments();
                        displayYPerformanceWheels();
                        wheelChoice = keyboard.nextInt();
                            wheelChoice = wheel.getWheelName("21\" Uberturbine Wheels").getWheelId();
                        lineSegments();
                        display3AndYExteriorColors();
                        exteriorChoice = keyboard.nextInt();
                        if (exteriorChoice == 1) {
                            exteriorChoice = exterior.getExteriorName("3&Y Pearl White").getExteriorId();
                        } else if (exteriorChoice == 2) {
                            exteriorChoice = exterior.getExteriorName("3&Y Midnight Silver").getExteriorId();
                        } else if (exteriorChoice == 3){
                            exteriorChoice = exterior.getExteriorName("3&Y Deep Blue Metallic").getExteriorId();
                        } else if (exteriorChoice == 4){
                            exteriorChoice = exterior.getExteriorName("3&Y Solid Black").getExteriorId();
                        } else if (exteriorChoice == 5){
                            exteriorChoice = exterior.getExteriorName("3&Y Red Multi-Coat").getExteriorId();
                        }
                        lineSegments();
                        display3AndYInteriorColors();
                        interiorChoice = keyboard.nextInt();
                        if (interiorChoice == 1){
                            interiorChoice = interior.getInteriorName("3&Y Black").getInteriorId();
                        } else if (interiorChoice == 2){
                            interiorChoice = interior.getInteriorName("3&Y White").getInteriorId();
                        }
                        lineSegments();
                        displayYTowing();
                        towChoice = keyboard.nextInt();
                            if (towChoice == 1){
                                towChoice = tow.getTowName("NOT ADDED").getTowId();
                            } else if (towChoice == 2){
                                towChoice = tow.getTowName("Y Tow Hitch").getTowId();
                            }
                        lineSegments();
                        displayYPerformanceSeats();
                        seatsChoice = keyboard.nextInt();
                            seatsChoice = seat.getSeatName("5 Seats").getSeatId();
                        lineSegments();
                        displayAutopilotTypes();
                        autoPilotChoice = keyboard.nextInt();
                        if (autoPilotChoice == 1){
                            autoPilotChoice = autopilot.getAutopilotName("Autopilot").getAutopilotId();
                        } else if (autoPilotChoice == 2){
                            autoPilotChoice = autopilot.getAutopilotName("Enhanced Autopilot").getAutopilotId();
                        } else if (autoPilotChoice == 3){
                            autoPilotChoice = autopilot.getAutopilotName("Full-Self Driving").getAutopilotId();
                        }
                        lineSegments();
                        displayChargingTypes();
                        chargingChoice = keyboard.nextInt();
                        if (chargingChoice == 1){
                            chargingChoice = charging.getChargingName("None").getChargingId();
                        } else if (chargingChoice == 2){
                            chargingChoice = charging.getChargingName("Mobile Bundle").getChargingId();
                        } else if (chargingChoice == 3){
                            chargingChoice = charging.getChargingName("Wall Connector").getChargingId();
                        }
                    } else {
                        trimChoice = trim.getTrimName("Y Long Range").getTrimId();
                        lineSegments();
                        displayYWheelTypes();
                        wheelChoice = keyboard.nextInt();
                        if(wheelChoice == 1){
                            wheelChoice = wheel.getWheelName("19\" Gemini Wheels").getWheelId();
                        } else if(wheelChoice == 2){
                            wheelChoice = wheel.getWheelName("20\" Induction Wheels").getWheelId();
                        }
                        lineSegments();
                        display3AndYExteriorColors();
                        exteriorChoice = keyboard.nextInt();
                        if (exteriorChoice == 1) {
                            exteriorChoice = exterior.getExteriorName("3&Y Pearl White").getExteriorId();
                        } else if (exteriorChoice == 2) {
                            exteriorChoice = exterior.getExteriorName("3&Y Midnight Silver").getExteriorId();
                        } else if (exteriorChoice == 3){
                            exteriorChoice = exterior.getExteriorName("3&Y Deep Blue Metallic").getExteriorId();
                        } else if (exteriorChoice == 4){
                            exteriorChoice = exterior.getExteriorName("3&Y Solid Black").getExteriorId();
                        } else if (exteriorChoice == 5){
                            exteriorChoice = exterior.getExteriorName("3&Y Red Multi-Coat").getExteriorId();
                        }
                        lineSegments();
                        display3AndYInteriorColors();
                        interiorChoice = keyboard.nextInt();
                        if (interiorChoice == 1){
                            interiorChoice = interior.getInteriorName("3&Y Black").getInteriorId();
                        } else if (interiorChoice == 2){
                            interiorChoice = interior.getInteriorName("3&Y White").getInteriorId();
                        }
                        lineSegments();
                        displayYTowing();
                        towChoice = keyboard.nextInt();
                        if (towChoice == 1){
                            towChoice = tow.getTowName("NOT ADDED").getTowId();
                        } else if (towChoice == 2){
                            towChoice = tow.getTowName("Y Tow Hitch").getTowId();
                        }
                        lineSegments();
                        displayYSeatChoice();
                        seatsChoice = keyboard.nextInt();
                        if (seatsChoice == 1){
                            seatsChoice = seat.getSeatName("5 Seats").getSeatId();

                        } else if (seatsChoice == 2){
                            seatsChoice = seat.getSeatName("Y 7 Seats").getSeatId();

                        }
                        lineSegments();
                        displayAutopilotTypes();
                        autoPilotChoice = keyboard.nextInt();
                        if (autoPilotChoice == 1){
                            autoPilotChoice = autopilot.getAutopilotName("Autopilot").getAutopilotId();
                        } else if (autoPilotChoice == 2){
                            autoPilotChoice = autopilot.getAutopilotName("Enhanced Autopilot").getAutopilotId();
                        } else if (autoPilotChoice == 3){
                            autoPilotChoice = autopilot.getAutopilotName("Full-Self Driving").getAutopilotId();
                        }
                        lineSegments();
                        displayChargingTypes();
                        chargingChoice = keyboard.nextInt();
                        if (chargingChoice == 1){
                            chargingChoice = charging.getChargingName("None").getChargingId();
                        } else if (chargingChoice == 2){
                            chargingChoice = charging.getChargingName("Mobile Bundle").getChargingId();
                        } else if (chargingChoice == 3){
                            chargingChoice = charging.getChargingName("Wall Connector").getChargingId();
                        }
                    }
                    lineSegments();
                    displayTotalPricing();
                    double total =  (tow.getTow(towChoice).getTowPrice() +
                            model.getModel(modelChoice).getPrice() +
                            trim.getTrim(trimChoice).getTrimPrice() +
                            exterior.getExterior(trimChoice).getExteriorPrice() +
                            wheel.getWheel(wheelChoice).getWheelPrice() +
                            interior.getInterior(interiorChoice).getInteriorPrice() +
                            autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice() +
                            charging.getCharging(chargingChoice).getChargingPrice());

                    System.out.println("Here is your configuration");
                    System.out.println();
                    System.out.println("MODEL: " + model.getModel(modelChoice).getName() + "  " + model.getModel(modelChoice).getPrice());
                    System.out.println("TRIM: " + trim.getTrim(trimChoice).getTrimName() + "  " + trim.getTrim(trimChoice).getTrimPrice());
                    System.out.println("EXTERIOR COLOR: " + exterior.getExterior(exteriorChoice).getExteriorName() + "  " + exterior.getExterior(exteriorChoice).getExteriorPrice());
                    System.out.println("WHEELS: " + wheel.getWheel(wheelChoice).getWheelName() + "  " + wheel.getWheel(wheelChoice).getWheelPrice());
                    System.out.println("INTERIOR COLOR: " + interior.getInterior(interiorChoice).getInteriorName() + "  " + interior.getInterior(interiorChoice).getInteriorPrice());
                    System.out.println("AUTOPILOT LEVEL: " + autopilot.getAutopilot(autoPilotChoice).getAutopilotName() + "  " + autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice());
                    System.out.println("CHARGING: " + charging.getCharging(chargingChoice).getChargingName() + "  " + charging.getCharging(chargingChoice).getChargingPrice());
                    System.out.println("TOW HITCH: " + tow.getTow(towChoice).getTowConfirmed() + "  " + tow.getTow(towChoice).getTowPrice());
                    System.out.println("SEATS: " + seat.getSeat(seatsChoice).getNumOfSeats() + "  " + seat.getSeat(seatsChoice).getSeatPrice());
                    System.out.println();
                    System.out.println("Total Price: " + total);
                    System.out.println();
                    System.out.println();
                    lineSegments();
                    System.out.println("Would you like to save this configuration build?");
                    System.out.println();
                    System.out.println();
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int saveChoice = keyboard.nextInt();
                    if (saveChoice == 1){

                        Customer createdCustomer = new Customer();
                        createdCustomer.setModelId(modelChoice);
                        createdCustomer.setTrimId(trim.getTrim(trimChoice).getTrimId());
                        createdCustomer.setExteriorId(exteriorChoice);
                        createdCustomer.setWheelId(wheelChoice);
                        createdCustomer.setInteriorId(interiorChoice);
                        createdCustomer.setAutopilotId(autoPilotChoice);
                        createdCustomer.setChargingId(chargingChoice);
                        createdCustomer.setTowId(towChoice);
                        createdCustomer.setSeatId(seatsChoice);
                        createdCustomer.setTotalPrice((int) (tow.getTow(towChoice).getTowPrice() +
                                model.getModel(modelChoice).getPrice() +
                                trim.getTrim(trimChoice).getTrimPrice() +
                                exterior.getExterior(trimChoice).getExteriorPrice() +
                                wheel.getWheel(wheelChoice).getWheelPrice() +
                                interior.getInterior(interiorChoice).getInteriorPrice() +
                                autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice() +
                                charging.getCharging(chargingChoice).getChargingPrice()));

                        customer.createCustomer(createdCustomer);
                        lineSegments();
                        System.out.println("Your order number is : " + createdCustomer.getCustomerId());
                        System.out.println("Please save this for your records");
                        lineSegments();
                    } else if (saveChoice == 2){
                        continue;
                    }
                    returnToMain();
                    int returnToMainMenu = keyboard.nextInt();
                    if(returnToMainMenu == 1){
                        run();
                    } else if(returnToMainMenu == 2){
                        endOfProgram();
                        run = false;
                        System.exit(1);
                    }

                }

                //MODEL S
                else if (modelChoice == 3){
                    lineSegments();
                    displaySTrimLevels();
                    trimChoice = keyboard.nextInt();
                    if (trimChoice == 1) {
                        trimChoice = trim.getTrimName("S Regular").getTrimId();
                    } else if (trimChoice == 2) {
                        trimChoice = trim.getTrimName("S Plaid").getTrimId();
                    }
                    lineSegments();
                    displaySWheelTypes();
                    wheelChoice = keyboard.nextInt();
                    if(wheelChoice == 1){
                        wheelChoice = wheel.getWheelName("19\" Tempest Wheels").getWheelId();
                    } else if(wheelChoice == 2){
                        wheelChoice = wheel.getWheelName("20\" Arachnid Wheels").getWheelId();
                    }
                    lineSegments();
                    displaySAndXExteriorColors();
                    exteriorChoice = keyboard.nextInt();
                    if (exteriorChoice == 1) {
                        exteriorChoice = exterior.getExteriorName("S&X Pearl White").getExteriorId();
                    } else if (exteriorChoice == 2) {
                        exteriorChoice = exterior.getExteriorName("S&X Midnight Silver").getExteriorId();
                    } else if (exteriorChoice == 3){
                        exteriorChoice = exterior.getExteriorName("S&X Deep Blue Metallic").getExteriorId();
                    } else if (exteriorChoice == 4){
                        exteriorChoice = exterior.getExteriorName("S&X Solid Black").getExteriorId();
                    } else if (exteriorChoice == 5){
                        exteriorChoice = exterior.getExteriorName("S&X Ultra Red").getExteriorId();
                    }
                    lineSegments();
                    displaySAndXInteriorColors();
                    interiorChoice = keyboard.nextInt();
                    if (interiorChoice == 1){
                        interiorChoice = interior.getInteriorName("S&X Black").getInteriorId();
                    } else if (interiorChoice == 2){
                        interiorChoice = interior.getInteriorName("S&X White").getInteriorId();
                    } else if (interiorChoice == 3){
                        interiorChoice = interior.getInteriorName("S&X Cream").getInteriorId();
                    }
                    lineSegments();
                    display3AndSTow();
                    towChoice = keyboard.nextInt();
                        towChoice = tow.getTowName("NOT OFFERED ON THIS MODEL").getTowId();
                    lineSegments();
                    displayNumberOfSeats3AndS();
                    seatsChoice = keyboard.nextInt();
                        seatsChoice = seat.getSeatName("5 Seats").getSeatId();
                    lineSegments();
                    displayAutopilotTypes();
                    autoPilotChoice = keyboard.nextInt();
                    if (autoPilotChoice == 1){
                        autoPilotChoice = autopilot.getAutopilotName("Autopilot").getAutopilotId();
                    } else if (autoPilotChoice == 2){
                        autoPilotChoice = autopilot.getAutopilotName("Enhanced Autopilot").getAutopilotId();
                    } else if (autoPilotChoice == 3){
                        autoPilotChoice = autopilot.getAutopilotName("Full-Self Driving").getAutopilotId();
                    }
                    lineSegments();
                    displayChargingTypes();
                    chargingChoice = keyboard.nextInt();
                    if (chargingChoice == 1){
                        chargingChoice = charging.getChargingName("None").getChargingId();
                    } else if (chargingChoice == 2){
                        chargingChoice = charging.getChargingName("Mobile Bundle").getChargingId();
                    } else if (chargingChoice == 3){
                        chargingChoice = charging.getChargingName("Wall Connector").getChargingId();
                    }
                    lineSegments();
                    displayTotalPricing();
                    double total =  (tow.getTow(towChoice).getTowPrice() +
                            model.getModel(modelChoice).getPrice() +
                            trim.getTrim(trimChoice).getTrimPrice() +
                            exterior.getExterior(trimChoice).getExteriorPrice() +
                            wheel.getWheel(wheelChoice).getWheelPrice() +
                            interior.getInterior(interiorChoice).getInteriorPrice() +
                            autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice() +
                            charging.getCharging(chargingChoice).getChargingPrice());

                    System.out.println("Here is your configuration");
                    System.out.println();
                    System.out.println("MODEL: " + model.getModel(modelChoice).getName() + "  " + model.getModel(modelChoice).getPrice());
                    System.out.println("TRIM: " + trim.getTrim(trimChoice).getTrimName() + "  " + trim.getTrim(trimChoice).getTrimPrice());
                    System.out.println("EXTERIOR COLOR: " + exterior.getExterior(exteriorChoice).getExteriorName() + "  " + exterior.getExterior(exteriorChoice).getExteriorPrice());
                    System.out.println("WHEELS: " + wheel.getWheel(wheelChoice).getWheelName() + "  " + wheel.getWheel(wheelChoice).getWheelPrice());
                    System.out.println("INTERIOR COLOR: " + interior.getInterior(interiorChoice).getInteriorName() + "  " + interior.getInterior(interiorChoice).getInteriorPrice());
                    System.out.println("AUTOPILOT LEVEL: " + autopilot.getAutopilot(autoPilotChoice).getAutopilotName() + "  " + autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice());
                    System.out.println("CHARGING: " + charging.getCharging(chargingChoice).getChargingName() + "  " + charging.getCharging(chargingChoice).getChargingPrice());
                    System.out.println("TOW HITCH: " + tow.getTow(towChoice).getTowConfirmed() + "  " + tow.getTow(towChoice).getTowPrice());
                    System.out.println("SEATS: " + seat.getSeat(seatsChoice).getNumOfSeats() + "  " + seat.getSeat(seatsChoice).getSeatPrice());
                    System.out.println();
                    System.out.println("Total Price: " + total);
                    System.out.println();
                    System.out.println();
                    lineSegments();
                    System.out.println("Would you like to save this configuration build?");
                    System.out.println();
                    System.out.println();
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                    int saveChoice = keyboard.nextInt();
                    if (saveChoice == 1){

                        Customer createdCustomer = new Customer();
                        createdCustomer.setModelId(modelChoice);
                        createdCustomer.setTrimId(trim.getTrim(trimChoice).getTrimId());
                        createdCustomer.setExteriorId(exteriorChoice);
                        createdCustomer.setWheelId(wheelChoice);
                        createdCustomer.setInteriorId(interiorChoice);
                        createdCustomer.setAutopilotId(autoPilotChoice);
                        createdCustomer.setChargingId(chargingChoice);
                        createdCustomer.setTowId(towChoice);
                        createdCustomer.setSeatId(seatsChoice);
                        createdCustomer.setTotalPrice((int) (tow.getTow(towChoice).getTowPrice() +
                                model.getModel(modelChoice).getPrice() +
                                trim.getTrim(trimChoice).getTrimPrice() +
                                exterior.getExterior(trimChoice).getExteriorPrice() +
                                wheel.getWheel(wheelChoice).getWheelPrice() +
                                interior.getInterior(interiorChoice).getInteriorPrice() +
                                autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice() +
                                charging.getCharging(chargingChoice).getChargingPrice()));

                        customer.createCustomer(createdCustomer);
                        lineSegments();
                        System.out.println("Your order number is : " + createdCustomer.getCustomerId());
                        System.out.println("Please save this for your records");
                        lineSegments();
                    } else if (saveChoice == 2){
                        continue;
                    }
                    returnToMain();
                    int returnToMainMenu = keyboard.nextInt();
                    if(returnToMainMenu == 1){
                        run();
                    } else if(returnToMainMenu == 2){
                        endOfProgram();
                        run = false;
                        System.exit(1);
                    }

                }



                //MODEL X
                else if(modelChoice == 4){
                    lineSegments();
                    displayXTrimLevels();
                    trimChoice = keyboard.nextInt();
                    if (trimChoice == 1) {
                        trimChoice = trim.getTrimName("X Regular").getTrimId();
                    } else if (trimChoice == 2) {
                        trimChoice = trim.getTrimName("X Plaid").getTrimId();
                    }
                    lineSegments();
                    displayXWheelTypes();
                    wheelChoice = keyboard.nextInt();
                    if(wheelChoice == 1){
                        wheelChoice = wheel.getWheelName("20\" Cyberstream Wheels").getWheelId();
                    } else if(wheelChoice == 2){
                        wheelChoice = wheel.getWheelName("22\" Turbine Wheels").getWheelId();
                    }
                    lineSegments();
                    displaySAndXExteriorColors();
                    exteriorChoice = keyboard.nextInt();
                    if (exteriorChoice == 1) {
                        exteriorChoice = exterior.getExteriorName("S&X Pearl White").getExteriorId();
                    } else if (exteriorChoice == 2) {
                        exteriorChoice = exterior.getExteriorName("S&X Midnight Silver").getExteriorId();
                    } else if (exteriorChoice == 3){
                        exteriorChoice = exterior.getExteriorName("S&X Deep Blue Metallic").getExteriorId();
                    } else if (exteriorChoice == 4){
                        exteriorChoice = exterior.getExteriorName("S&X Solid Black").getExteriorId();
                    } else if (exteriorChoice == 5){
                        exteriorChoice = exterior.getExteriorName("S&X Ultra Red").getExteriorId();
                    }
                    lineSegments();
                    displaySAndXInteriorColors();
                    interiorChoice = keyboard.nextInt();
                    if (interiorChoice == 1){
                        interiorChoice = interior.getInteriorName("S&X Black").getInteriorId();
                    } else if (interiorChoice == 2){
                        interiorChoice = interior.getInteriorName("S&X White").getInteriorId();
                    } else if (interiorChoice == 3){
                        interiorChoice = interior.getInteriorName("S&X Cream").getInteriorId();
                    }
                    lineSegments();
                    displayXTowPackage();
                    towChoice = keyboard.nextInt();
                        towChoice = tow.getTowName("X Tow Hitch").getTowId();
                    lineSegments();
                    displayXSeats();
                    seatsChoice = keyboard.nextInt();
                    if (seatsChoice == 1){
                        seatsChoice = seat.getSeatName("5 Seats").getSeatId();

                    } else if (seatsChoice == 2){
                        seatsChoice = seat.getSeatName("6 Seats").getSeatId();

                    } else if(seatsChoice == 3){
                        seatsChoice = seat.getSeatName("X 7 Seats").getSeatId();
                    }
                    lineSegments();
                    displayAutopilotTypes();
                    autoPilotChoice = keyboard.nextInt();
                    if (autoPilotChoice == 1){
                        autoPilotChoice = autopilot.getAutopilotName("Autopilot").getAutopilotId();
                    } else if (autoPilotChoice == 2){
                        autoPilotChoice = autopilot.getAutopilotName("Enhanced Autopilot").getAutopilotId();
                    } else if (autoPilotChoice == 3){
                        autoPilotChoice = autopilot.getAutopilotName("Full-Self Driving").getAutopilotId();
                    }
                    lineSegments();
                    displayChargingTypes();
                    chargingChoice = keyboard.nextInt();

                    if (chargingChoice == 1){
                        chargingChoice = charging.getChargingName("None").getChargingId();
                    } else if (chargingChoice == 2){
                        chargingChoice = charging.getChargingName("Mobile Bundle").getChargingId();
                    } else if (chargingChoice == 3){
                        chargingChoice = charging.getChargingName("Wall Connector").getChargingId();
                    }
                    lineSegments();
                    displayTotalPricing();
                    double total =  (tow.getTow(towChoice).getTowPrice() +
                            model.getModel(modelChoice).getPrice() +
                            trim.getTrim(trimChoice).getTrimPrice() +
                            exterior.getExterior(trimChoice).getExteriorPrice() +
                            wheel.getWheel(wheelChoice).getWheelPrice() +
                            interior.getInterior(interiorChoice).getInteriorPrice() +
                            autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice() +
                            charging.getCharging(chargingChoice).getChargingPrice());

                    System.out.println("Here is your configuration");
                    System.out.println();
                    System.out.println("MODEL: " + model.getModel(modelChoice).getName() + "  " + model.getModel(modelChoice).getPrice());
                    System.out.println("TRIM: " + trim.getTrim(trimChoice).getTrimName() + "  " + trim.getTrim(trimChoice).getTrimPrice());
                    System.out.println("EXTERIOR COLOR: " + exterior.getExterior(exteriorChoice).getExteriorName() + "  " + exterior.getExterior(exteriorChoice).getExteriorPrice());
                    System.out.println("WHEELS: " + wheel.getWheel(wheelChoice).getWheelName() + "  " + wheel.getWheel(wheelChoice).getWheelPrice());
                    System.out.println("INTERIOR COLOR: " + interior.getInterior(interiorChoice).getInteriorName() + "  " + interior.getInterior(interiorChoice).getInteriorPrice());
                    System.out.println("AUTOPILOT LEVEL: " + autopilot.getAutopilot(autoPilotChoice).getAutopilotName() + "  " + autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice());
                    System.out.println("CHARGING: " + charging.getCharging(chargingChoice).getChargingName() + "  " + charging.getCharging(chargingChoice).getChargingPrice());
                    System.out.println("TOW HITCH: " + tow.getTow(towChoice).getTowConfirmed() + "  " + tow.getTow(towChoice).getTowPrice());
                    System.out.println("SEATS: " + seat.getSeat(seatsChoice).getNumOfSeats() + "  " + seat.getSeat(seatsChoice).getSeatPrice());
                    System.out.println();
                    System.out.println("Total Price: " + total);
                    System.out.println();
                    System.out.println();
                    lineSegments();
                    System.out.println("Would you like to save this configuration build?");
                    System.out.println();
                    System.out.println();
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                        int saveChoice = keyboard.nextInt();
                        if (saveChoice == 1){

                        Customer createdCustomer = new Customer();
                        createdCustomer.setModelId(modelChoice);
                        createdCustomer.setTrimId(trim.getTrim(trimChoice).getTrimId());
                        createdCustomer.setExteriorId(exteriorChoice);
                        createdCustomer.setWheelId(wheelChoice);
                        createdCustomer.setInteriorId(interiorChoice);
                        createdCustomer.setAutopilotId(autoPilotChoice);
                        createdCustomer.setChargingId(chargingChoice);
                        createdCustomer.setTowId(towChoice);
                        createdCustomer.setSeatId(seatsChoice);
                        createdCustomer.setTotalPrice((int) (tow.getTow(towChoice).getTowPrice() +
                                                        model.getModel(modelChoice).getPrice() +
                                                        trim.getTrim(trimChoice).getTrimPrice() +
                                                        exterior.getExterior(trimChoice).getExteriorPrice() +
                                                        wheel.getWheel(wheelChoice).getWheelPrice() +
                                                        interior.getInterior(interiorChoice).getInteriorPrice() +
                                                        autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice() +
                                                        charging.getCharging(chargingChoice).getChargingPrice()));

                        customer.createCustomer(createdCustomer);
                            lineSegments();
                            System.out.println("Your order number is : " + createdCustomer.getCustomerId());
                            System.out.println("Please save this for your records");
                            lineSegments();
                        } else if (saveChoice == 2){
                           continue;
                        }
                    returnToMain();
                    int returnToMainMenu = keyboard.nextInt();
                    if(returnToMainMenu == 1){
                        run();
                    } else if(returnToMainMenu == 2){
                        endOfProgram();
                        run = false;
                        System.exit(1);
                    }
                }


            }
            // RETURNS EXISTING ORDERS
            else if (mainMenuChoice == 2){
                boolean secondaryMenu = true;
                while (secondaryMenu){
                lineSegments();
                displayCustomerChoices();
                    int customerOptionView = keyboard.nextInt();

                    if (customerOptionView == 1){

                        System.out.println("What is your order id number?: ");

                        int orderIdNumber = keyboard.nextInt();
                        Customer viewedCustomer = customer.getCustomerById(orderIdNumber);

                        System.out.println("ORDER NUMBER: " + viewedCustomer.getCustomerId());
                        System.out.println("MODEL CHOICE: " + model.getModel(viewedCustomer.getModelId()).getName());
                        System.out.println("TRIM LEVEL: " + trim.getTrim(viewedCustomer.getTrimId()).getTrimName());
                        System.out.println("EXTERIOR COLOR: " + exterior.getExterior(viewedCustomer.getExteriorId()).getExteriorName());
                        System.out.println("WHEEL TYPE: " + wheel.getWheel(viewedCustomer.getWheelId()).getWheelName());
                        System.out.println("INTERIOR COLOR: " + interior.getInterior(viewedCustomer.getInteriorId()).getInteriorName());
                        System.out.println("AUTOPILOT LEVEL: " + autopilot.getAutopilot(viewedCustomer.getAutopilotId()).getAutopilotName());
                        System.out.println("CHARGING TYPE: " + charging.getCharging(viewedCustomer.getChargingId()).getChargingName());
                        System.out.println("TOW PACKAGE: " + tow.getTow(viewedCustomer.getTowId()).getTowConfirmed());
                        System.out.println("SEATS: " + seat.getSeat(viewedCustomer.getSeatId()).getNumOfSeats());
                        System.out.println("TOTAL PRICE: " + viewedCustomer.getTotalPrice());
                        System.out.println();
                        lineSegments();
                        System.out.println("Would you like to make another selection?");
                        System.out.println();
                        System.out.println("1: Yes");
                        System.out.println("2: No");
                        int searchingAgainChoice = keyboard.nextInt();
                        if (searchingAgainChoice == 1){
                            continue;

                        } else if (searchingAgainChoice == 2) {
                            lineSegments();
                            System.out.println("Would you like to return to the main menu?");
                            System.out.println();
                            System.out.println("1: Yes");
                            System.out.println("2: No");
                            int returnToMenu = keyboard.nextInt();
                            if(returnToMenu == 1){
                                secondaryMenu = false;
                                run();
                            } else if (returnToMenu == 2){
                                endOfProgram();
                                run = false;
                                System.exit(1);

                            }
                        }


                    } else if(customerOptionView == 2){

                        List<Customer> customers = customer.getAllCustomerOrders();

                        for (Customer value : customers) {
                            System.out.println("**** ORDER NUMBER: " + value.getCustomerId() + " ****");
                            System.out.println("  MODEL: " + model.getModel(value.getModelId()).getName());
                            System.out.println("  TRIM LEVEL: " + trim.getTrim(value.getTrimId()).getTrimName());
                            System.out.println("  EXTERIOR COLOR: " + exterior.getExterior(value.getExteriorId()).getExteriorName());
                            System.out.println("  WHEEL TYPE: " + wheel.getWheel(value.getWheelId()).getWheelName());
                            System.out.println("  INTERIOR COLOR: " + interior.getInterior(value.getInteriorId()).getInteriorName());
                            System.out.println("  AUTOPILOT LEVEL: " + autopilot.getAutopilot(value.getAutopilotId()).getAutopilotName());
                            System.out.println("  CHARGING TYPE: " + charging.getCharging(value.getChargingId()).getChargingName());
                            System.out.println("  TOW PACKAGE: " + tow.getTow(value.getTowId()).getTowConfirmed());
                            System.out.println("  SEATS: " + seat.getSeat(value.getSeatId()).getNumOfSeats());
                            System.out.println("  TOTAL PRICE: " + value.getTotalPrice());

                        }

                        lineSegments();
                        System.out.println("Would you like to return to the main menu?");
                        System.out.println();
                        System.out.println("1: Yes");
                        System.out.println("2: No");
                        int returnToMenu = keyboard.nextInt();
                        if (returnToMenu == 1) {
                            run();
                        } else if (returnToMenu == 2) {

                            endOfProgram();
                            secondaryMenu = false;
                            run = false;
                            System.exit(1);
                        }

                    } else if (customerOptionView == 3){
                        System.out.println();
                        System.out.println();
                        run();
                    } else if(customerOptionView == 4){
                        secondaryMenu = false;
                        endOfProgram();
                        run = false;
                        System.exit(1);
                    }

                }
            }
            //ENDS PROGRAM
            else if (mainMenuChoice == 3) {

                endOfProgram();
                run = false;
                System.exit(1);
            }

        }


    }



}