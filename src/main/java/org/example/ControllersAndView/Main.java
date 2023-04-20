package org.example.ControllersAndView;
import org.example.Dao.*;
import org.apache.commons.dbcp2.BasicDataSource;
import org.example.Dao.Jdbc.*;
import org.example.models.Customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


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
                        trimChoice = trim.getTrimName("3 Performance").getTrimId();
                        display3PerformanceWheelType();
                        wheelChoice = keyboard.nextInt();
                        wheelChoice = wheel.getWheelName("20\" Uberturbine Wheels").getWheelId();
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
                        display3AndYInteriorColors();
                        interiorChoice = keyboard.nextInt();
                        if (interiorChoice == 1){
                            interiorChoice = interior.getInteriorName("3&Y Black").getInteriorId();
                        } else if (interiorChoice == 2){
                            interiorChoice = interior.getInteriorName("3&Y White").getInteriorId();
                        }
                        display3AndSTow();
                        towChoice = keyboard.nextInt();
                            towChoice = tow.getTowName("NOT OFFERED ON THIS MODEL").getTowId();
                        displayNumberOfSeats3AndS();
                        seatsChoice = keyboard.nextInt();
                            seatsChoice = seat.getSeatName("5 Seats").getSeatId();
                        displayAutopilotTypes();
                        autoPilotChoice = keyboard.nextInt();
                        if (autoPilotChoice == 1){
                            autoPilotChoice = autopilot.getAutopilotName("Autopilot").getAutopilotId();
                        } else if (autoPilotChoice == 2){
                            autoPilotChoice = autopilot.getAutopilotName("Enhanced Autopilot").getAutopilotId();
                        } else if (autoPilotChoice == 3){
                            autoPilotChoice = autopilot.getAutopilotName("Full-Self Driving").getAutopilotId();
                        }
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
                        display3WheelTypes();
                        wheelChoice = keyboard.nextInt();
                        if(wheelChoice == 1){
                            wheelChoice = wheel.getWheelName("18\" Aero Wheels").getWheelId();
                        } else if(wheelChoice == 2){
                            wheelChoice = wheel.getWheelName("19\" Sport Wheels").getWheelId();
                        }
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
                        display3AndYInteriorColors();
                        interiorChoice = keyboard.nextInt();
                        if (interiorChoice == 1){
                            interiorChoice = interior.getInteriorName("3&Y Black").getInteriorId();
                        } else if (interiorChoice == 2){
                            interiorChoice = interior.getInteriorName("3&Y White").getInteriorId();
                        }
                        display3AndSTow();
                        towChoice = keyboard.nextInt();
                             towChoice = tow.getTowName("NOT OFFERED ON THIS MODEL").getTowId();
                        displayNumberOfSeats3AndS();
                        seatsChoice = keyboard.nextInt();
                            seatsChoice = seat.getSeatName("5 Seats").getSeatId();
                        displayAutopilotTypes();
                        autoPilotChoice = keyboard.nextInt();
                            if (autoPilotChoice == 1){
                                autoPilotChoice = autopilot.getAutopilotName("Autopilot").getAutopilotId();
                            } else if (autoPilotChoice == 2){
                                autoPilotChoice = autopilot.getAutopilotName("Enhanced Autopilot").getAutopilotId();
                            } else if (autoPilotChoice == 3){
                                autoPilotChoice = autopilot.getAutopilotName("Full-Self Driving").getAutopilotId();
                            }
                        displayChargingTypes();
                        chargingChoice =keyboard.nextInt();
                        chargingChoice =keyboard.nextInt();
                        if (chargingChoice == 1){
                            chargingChoice = charging.getChargingName("None").getChargingId();
                        } else if (chargingChoice == 2){
                            chargingChoice = charging.getChargingName("Mobile Bundle").getChargingId();
                        } else if (chargingChoice == 3){
                            chargingChoice = charging.getChargingName("Wall Connector").getChargingId();
                        }
                    }



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
                    System.out.println(model.getModel(modelChoice).getName() + "  " + model.getModel(modelChoice).getPrice());
                    System.out.println(trim.getTrim(trimChoice).getTrimName() + "  " + trim.getTrim(trimChoice).getTrimPrice());
                    System.out.println(exterior.getExterior(exteriorChoice).getExteriorName() + "  " + exterior.getExterior(exteriorChoice).getExteriorPrice());
                    System.out.println(wheel.getWheel(wheelChoice).getWheelName() + "  " + wheel.getWheel(wheelChoice).getWheelPrice());
                    System.out.println(interior.getInterior(interiorChoice).getInteriorName() + "  " + interior.getInterior(interiorChoice).getInteriorPrice());
                    System.out.println(autopilot.getAutopilot(autoPilotChoice).getAutopilotName() + "  " + autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice());
                    System.out.println(charging.getCharging(chargingChoice).getChargingName() + "  " + charging.getCharging(chargingChoice).getChargingPrice());
                    System.out.println(tow.getTow(towChoice).getTowConfirmed() + "  " + tow.getTow(towChoice).getTowPrice());
                    System.out.println(seat.getSeat(seatsChoice).getNumOfSeats() + "  " + seat.getSeat(seatsChoice).getSeatPrice());
                    System.out.println();
                    System.out.println("Total Price: " + total);

                    endOfProgram();
                    run = false;


                }






                //MODEL Y
                else if (modelChoice == 2){
                    displayYTrimLevels();
                    trimChoice = keyboard.nextInt();

                    if (trimChoice == 2){
                        trimChoice = trim.getTrimName("Y Performance").getTrimId();

                        displayYPerformanceWheels();
                        wheelChoice = keyboard.nextInt();
                            wheelChoice = wheel.getWheelName("21\" Uberturbine Wheels").getWheelId();
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
                        display3AndYInteriorColors();
                        interiorChoice = keyboard.nextInt();
                        if (interiorChoice == 1){
                            interiorChoice = interior.getInteriorName("3&Y Black").getInteriorId();
                        } else if (interiorChoice == 2){
                            interiorChoice = interior.getInteriorName("3&Y White").getInteriorId();
                        }
                        displayYTowing();
                        towChoice = keyboard.nextInt();
                            if (towChoice == 1){
                                towChoice = tow.getTowName("NOT ADDED").getTowId();
                            } else if (towChoice == 2){
                                towChoice = tow.getTowName("Y Tow Hitch").getTowId();
                            }
                        displayYPerformanceSeats();
                        seatsChoice = keyboard.nextInt();
                            seatsChoice = seat.getSeatName("5 Seats").getSeatId();
                        displayAutopilotTypes();
                        autoPilotChoice = keyboard.nextInt();
                        if (autoPilotChoice == 1){
                            autoPilotChoice = autopilot.getAutopilotName("Autopilot").getAutopilotId();
                        } else if (autoPilotChoice == 2){
                            autoPilotChoice = autopilot.getAutopilotName("Enhanced Autopilot").getAutopilotId();
                        } else if (autoPilotChoice == 3){
                            autoPilotChoice = autopilot.getAutopilotName("Full-Self Driving").getAutopilotId();
                        }
                        displayChargingTypes();
                        chargingChoice = keyboard.nextInt();
                        chargingChoice =keyboard.nextInt();
                        if (chargingChoice == 1){
                            chargingChoice = charging.getChargingName("None").getChargingId();
                        } else if (chargingChoice == 2){
                            chargingChoice = charging.getChargingName("Mobile Bundle").getChargingId();
                        } else if (chargingChoice == 3){
                            chargingChoice = charging.getChargingName("Wall Connector").getChargingId();
                        }
                    } else {
                        trimChoice = trim.getTrimName("Y Long Range").getTrimId();
                        displayYWheelTypes();
                        wheelChoice = keyboard.nextInt();
                        if(wheelChoice == 1){
                            wheelChoice = wheel.getWheelName("19\" Gemini Wheels").getWheelId();
                        } else if(wheelChoice == 2){
                            wheelChoice = wheel.getWheelName("20\" Induction Wheels").getWheelId();
                        }
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
                        display3AndYInteriorColors();
                        interiorChoice = keyboard.nextInt();
                        if (interiorChoice == 1){
                            interiorChoice = interior.getInteriorName("3&Y Black").getInteriorId();
                        } else if (interiorChoice == 2){
                            interiorChoice = interior.getInteriorName("3&Y White").getInteriorId();
                        }
                        displayYTowing();
                        towChoice = keyboard.nextInt();
                        if (towChoice == 1){
                            towChoice = tow.getTowName("NOT ADDED").getTowId();
                        } else if (towChoice == 2){
                            towChoice = tow.getTowName("Y Tow Hitch").getTowId();
                        }
                        displayYSeatChoice();
                        seatsChoice = keyboard.nextInt();
                        if (seatsChoice == 1){
                            seatsChoice = seat.getSeatName("5 Seats").getSeatId();

                        } else if (seatsChoice == 2){
                            seatsChoice = seat.getSeatName("Y 7 Seats").getSeatId();

                        }
                        displayAutopilotTypes();
                        autoPilotChoice = keyboard.nextInt();
                        if (autoPilotChoice == 1){
                            autoPilotChoice = autopilot.getAutopilotName("Autopilot").getAutopilotId();
                        } else if (autoPilotChoice == 2){
                            autoPilotChoice = autopilot.getAutopilotName("Enhanced Autopilot").getAutopilotId();
                        } else if (autoPilotChoice == 3){
                            autoPilotChoice = autopilot.getAutopilotName("Full-Self Driving").getAutopilotId();
                        }
                        displayChargingTypes();
                        chargingChoice = keyboard.nextInt();
                        chargingChoice =keyboard.nextInt();
                        if (chargingChoice == 1){
                            chargingChoice = charging.getChargingName("None").getChargingId();
                        } else if (chargingChoice == 2){
                            chargingChoice = charging.getChargingName("Mobile Bundle").getChargingId();
                        } else if (chargingChoice == 3){
                            chargingChoice = charging.getChargingName("Wall Connector").getChargingId();
                        }
                    }

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
                    System.out.println(model.getModel(modelChoice).getName() + "  " + model.getModel(modelChoice).getPrice());
                    System.out.println(trim.getTrim(trimChoice).getTrimName() + "  " + trim.getTrim(trimChoice).getTrimPrice());
                    System.out.println(exterior.getExterior(exteriorChoice).getExteriorName() + "  " + exterior.getExterior(exteriorChoice).getExteriorPrice());
                    System.out.println(wheel.getWheel(wheelChoice).getWheelName() + "  " + wheel.getWheel(wheelChoice).getWheelPrice());
                    System.out.println(interior.getInterior(interiorChoice).getInteriorName() + "  " + interior.getInterior(interiorChoice).getInteriorPrice());
                    System.out.println(autopilot.getAutopilot(autoPilotChoice).getAutopilotName() + "  " + autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice());
                    System.out.println(charging.getCharging(chargingChoice).getChargingName() + "  " + charging.getCharging(chargingChoice).getChargingPrice());
                    System.out.println(tow.getTow(towChoice).getTowConfirmed() + "  " + tow.getTow(towChoice).getTowPrice());
                    System.out.println(seat.getSeat(seatsChoice).getNumOfSeats() + "  " + seat.getSeat(seatsChoice).getSeatPrice());
                    System.out.println();
                    System.out.println("Total Price: " + total);

                    endOfProgram();
                    run = false;

                }


                //MODEL S
                else if (modelChoice == 3){
                    displaySTrimLevels();
                    trimChoice = keyboard.nextInt();
                    if (trimChoice == 1) {
                        trimChoice = trim.getTrimName("S Regular").getTrimId();
                    } else if (trimChoice == 2) {
                        trimChoice = trim.getTrimName("S Plaid").getTrimId();
                    }

                    displaySWheelTypes();
                    wheelChoice = keyboard.nextInt();
                    if(wheelChoice == 1){
                        wheelChoice = wheel.getWheelName("19\" Tempest Wheels").getWheelId();
                    } else if(wheelChoice == 2){
                        wheelChoice = wheel.getWheelName("20\" Arachnid Wheels").getWheelId();
                    }
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
                    displaySAndXInteriorColors();
                    interiorChoice = keyboard.nextInt();
                    if (interiorChoice == 1){
                        interiorChoice = interior.getInteriorName("S&X Black").getInteriorId();
                    } else if (interiorChoice == 2){
                        interiorChoice = interior.getInteriorName("S&X White").getInteriorId();
                    } else if (interiorChoice == 3){
                        interiorChoice = interior.getInteriorName("S&X Cream").getInteriorId();
                    }
                    display3AndSTow();
                    towChoice = keyboard.nextInt();
                        towChoice = tow.getTowName("NOT OFFERED ON THIS MODEL").getTowId();

                    displayNumberOfSeats3AndS();
                    seatsChoice = keyboard.nextInt();
                        seatsChoice = seat.getSeatName("5 Seats").getSeatId();
                    displayAutopilotTypes();
                    autoPilotChoice = keyboard.nextInt();
                    if (autoPilotChoice == 1){
                        autoPilotChoice = autopilot.getAutopilotName("Autopilot").getAutopilotId();
                    } else if (autoPilotChoice == 2){
                        autoPilotChoice = autopilot.getAutopilotName("Enhanced Autopilot").getAutopilotId();
                    } else if (autoPilotChoice == 3){
                        autoPilotChoice = autopilot.getAutopilotName("Full-Self Driving").getAutopilotId();
                    }
                    displayChargingTypes();
                    chargingChoice = keyboard.nextInt();
                    chargingChoice =keyboard.nextInt();
                    if (chargingChoice == 1){
                        chargingChoice = charging.getChargingName("None").getChargingId();
                    } else if (chargingChoice == 2){
                        chargingChoice = charging.getChargingName("Mobile Bundle").getChargingId();
                    } else if (chargingChoice == 3){
                        chargingChoice = charging.getChargingName("Wall Connector").getChargingId();
                    }
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
                    System.out.println(model.getModel(modelChoice).getName() + "  " + model.getModel(modelChoice).getPrice());
                    System.out.println(trim.getTrim(trimChoice).getTrimName() + "  " + trim.getTrim(trimChoice).getTrimPrice());
                    System.out.println(exterior.getExterior(exteriorChoice).getExteriorName() + "  " + exterior.getExterior(trimChoice).getExteriorPrice());
                    System.out.println(wheel.getWheel(wheelChoice).getWheelName() + "  " + wheel.getWheel(wheelChoice).getWheelPrice());
                    System.out.println(interior.getInterior(interiorChoice).getInteriorName() + "  " + interior.getInterior(interiorChoice).getInteriorPrice());
                    System.out.println(autopilot.getAutopilot(autoPilotChoice).getAutopilotName() + "  " + autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice());
                    System.out.println(charging.getCharging(chargingChoice).getChargingName() + "  " + charging.getCharging(chargingChoice).getChargingPrice());
                    System.out.println(tow.getTow(towChoice).getTowConfirmed() + "  " + tow.getTow(towChoice).getTowPrice());
                    System.out.println(seat.getSeat(seatsChoice).getNumOfSeats() + "  " + seat.getSeat(seatsChoice).getSeatPrice());
                    System.out.println();
                    System.out.println("Total Price: " + total);
                    endOfProgram();
                    run = false;

                }


                //MODEL X
                else if(modelChoice == 4){
                    displayXTrimLevels();
                    trimChoice = keyboard.nextInt();
                    if (trimChoice == 1) {
                        trimChoice = trim.getTrimName("X Regular").getTrimId();
                    } else if (trimChoice == 2) {
                        trimChoice = trim.getTrimName("X Plaid").getTrimId();
                    }
                    displayXWheelTypes();
                    wheelChoice = keyboard.nextInt();
                    if(wheelChoice == 1){
                        wheelChoice = wheel.getWheelName("20\" Cyberstream Wheels").getWheelId();
                    } else if(wheelChoice == 2){
                        wheelChoice = wheel.getWheelName("22\" Turbine Wheels").getWheelId();
                    }
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
                    displaySAndXInteriorColors();
                    interiorChoice = keyboard.nextInt();
                    if (interiorChoice == 1){
                        interiorChoice = interior.getInteriorName("S&X Black").getInteriorId();
                    } else if (interiorChoice == 2){
                        interiorChoice = interior.getInteriorName("S&X White").getInteriorId();
                    } else if (interiorChoice == 3){
                        interiorChoice = interior.getInteriorName("S&X Cream").getInteriorId();
                    }
                    displayXTowPackage();
                    towChoice = keyboard.nextInt();
                        towChoice = tow.getTowName("X Tow Hitch").getTowId();
                    displayXSeats();
                    seatsChoice = keyboard.nextInt();
                    if (seatsChoice == 1){
                        seatsChoice = seat.getSeatName("5 Seats").getSeatId();

                    } else if (seatsChoice == 2){
                        seatsChoice = seat.getSeatName("6 Seats").getSeatId();

                    } else if(seatsChoice == 3){
                        seatsChoice = seat.getSeatName("X 7 Seats").getSeatId();
                    }
                    displayAutopilotTypes();
                    autoPilotChoice = keyboard.nextInt();
                    if (autoPilotChoice == 1){
                        autoPilotChoice = autopilot.getAutopilotName("Autopilot").getAutopilotId();
                    } else if (autoPilotChoice == 2){
                        autoPilotChoice = autopilot.getAutopilotName("Enhanced Autopilot").getAutopilotId();
                    } else if (autoPilotChoice == 3){
                        autoPilotChoice = autopilot.getAutopilotName("Full-Self Driving").getAutopilotId();
                    }
                    displayChargingTypes();
                    chargingChoice = keyboard.nextInt();
                    chargingChoice =keyboard.nextInt();
                    if (chargingChoice == 1){
                        chargingChoice = charging.getChargingName("None").getChargingId();
                    } else if (chargingChoice == 2){
                        chargingChoice = charging.getChargingName("Mobile Bundle").getChargingId();
                    } else if (chargingChoice == 3){
                        chargingChoice = charging.getChargingName("Wall Connector").getChargingId();
                    }
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
                    System.out.println(model.getModel(modelChoice).getName() + "  " + model.getModel(modelChoice).getPrice());
                    System.out.println(trim.getTrim(trimChoice).getTrimName() + "  " + trim.getTrim(trimChoice).getTrimPrice());
                    System.out.println(exterior.getExterior(exteriorChoice).getExteriorName() + "  " + exterior.getExterior(trimChoice).getExteriorPrice());
                    System.out.println(wheel.getWheel(wheelChoice).getWheelName() + "  " + wheel.getWheel(wheelChoice).getWheelPrice());
                    System.out.println(interior.getInterior(interiorChoice).getInteriorName() + "  " + interior.getInterior(interiorChoice).getInteriorPrice());
                    System.out.println(autopilot.getAutopilot(autoPilotChoice).getAutopilotName() + "  " + autopilot.getAutopilot(autoPilotChoice).getAutopilotPrice());
                    System.out.println(charging.getCharging(chargingChoice).getChargingName() + "  " + charging.getCharging(chargingChoice).getChargingPrice());
                    System.out.println(tow.getTow(towChoice).getTowConfirmed() + "  " + tow.getTow(towChoice).getTowPrice());
                    System.out.println(seat.getSeat(seatsChoice).getNumOfSeats() + "  " + seat.getSeat(seatsChoice).getSeatPrice());
                    System.out.println();
                    System.out.println("Total Price: " + total);
                    System.out.println();
                    System.out.println();
                    System.out.println("Would you like to save this configuration build?");
                    System.out.println();
                    System.out.println();
                    System.out.println("1. Yes");
                    System.out.println("2. No");
                        int saveChoice = keyboard.nextInt();
                        if (saveChoice == 1){

                        } else if (saveChoice == 2){
                            endOfProgram();
                            run = false;
                        }

                    endOfProgram();
                    run = false;
                }


            }
            // RETURNS EXISTING ORDERS
            else if (mainMenuChoice == 2){


                displayCustomerChoices();
                    int customerOptionView = keyboard.nextInt();

                    if (customerOptionView == 1){
                        customer.createCustomer(new Customer());

                    } else if(customerOptionView == 2){

                    } else if (customerOptionView == 3){
                        System.out.println();
                        System.out.println();
                        run();
                    } else if(customerOptionView == 4){
                        endOfProgram();
                        run = false;
                    }

            }
            //ENDS PROGRAM
            else if (mainMenuChoice == 3) {

                endOfProgram();
                run = false;
            }

        }


    }



}