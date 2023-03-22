package org.example;

import java.sql.SQLOutput;

public interface UserInterfaceTesla {

    //Main Menu
    default void printMainMenu() {

        System.out.println("Welcome to the Tesla Configurator");
        System.out.println();
        System.out.println("1: Build your Tesla!");
        System.out.println("2: Exit");
    }

    //Models
    default void displayModels(){
        System.out.println("Please choose a Model (1 - 4)");
        System.out.println();
        System.out.println("1: Model 3    ------    $42,990.00");
        System.out.println("2: Model Y    ------    $54,990.00");
        System.out.println("3: Model S    ------    $");
        System.out.println("4: Model X    ------    $");
    }


    //MODEL 3
    default void display3TrimLevels(){
        System.out.println("Please choose a Trim Level (1 - 3)");
        System.out.println();
        System.out.println("1: Rear Wheel Drive  ------    $0.00");
        System.out.println("2: Long Range        ------   +$8,000.00");
        System.out.println("3: Performance       ------   +$11,000.00");

    }

    default void display3AndYExteriorColors(){
        System.out.println("Please choose an exterior color");
        System.out.println();
        System.out.println("1: Pearl White         ------     $0.00");
        System.out.println("2: Midnight Silver     ------    +$1,000.00");
        System.out.println("3: Deep Blue Metallic  ------    +$1,000.00");
        System.out.println("4: Solid Black         ------    +$1,500.00");
        System.out.println("5: Red Multi-Coat      ------    +$2,000.00");
    }

    default void display3WheelTypes(){
        System.out.println("Please choose a wheel");
        System.out.println();
        System.out.println("1: 18\" Aero wheels   ------    $0.00");
        System.out.println("2: 19\" Sport wheels  ------    $1500.00");
    }

    default void display3PerformanceWheelType(){
        System.out.println("Please choose a wheel (Performance trim comes with Uberturbine wheels)");
        System.out.println();
        System.out.println("1: 20\" Uberturbine wheels    ------    $0.00");
    }

    default void display3AndSTow(){
        System.out.println("Tow Hitch Option");
        System.out.println();
        System.out.println("We're sorry, this Model currently does not offer Tow Hitches, please enter 1 to continue");

    }
    default void display3AndYInteriorColors(){
        System.out.println("Please chose an interior color");
        System.out.println();
        System.out.println("1: Black    ------    $0.00");
        System.out.println("2: White    ------    $1000.00");
    }

    default void displayNumberOfSeats3AndS(){
        System.out.println("Please choose the number of seats");
        System.out.println();
        System.out.println("1: 5 Seats");
    }

    default void displayAutopilotTypes(){
        System.out.println("Please choose a level of Autopilot");
        System.out.println();
        System.out.println("1: Autopilot             ------    $0.00");
        System.out.println("2: Enhanced Autopilot    ------    $6,000.00");
        System.out.println("3: Full-Self Driving     ------    $15,000.00");
    }

    default void displayChargingTypes(){
        System.out.println("Please choose a type of charger you would like");
        System.out.println();
        System.out.println("1: Mobile Bundle     ------    $230.00");
        System.out.println("2: Wall Connector    ------    $425.00");

    }

    default void displayTotalPricing(){

    }


    //MODEL Y
    default void displayYTrimLevels(){
        System.out.println("1: Long Range      ------    $0.00");
        System.out.println("2: Performance     ------    $4,000.00");

    }
        //PLUS display3AndYExteriorColors()

    default void displayYWheelTypes(){
        System.out.println("1:    ------    $");
    }

        //PLUS display3AndYInteriorColors() in MODEL 3
        //PLUS displayAutopilotTypes in MODEL 3
        // PLUS displayChargingTypes in MODEL 3
        // PLUS displayTotalPricing in MODEL 3

    //MODEL S
    default void displaySTrimLevels(){
        System.out.println("Model S    ------    $");
    }

    default void displaySAndXExteriorColors(){
        System.out.println("1: Pearl White         ------     $0.00");
        System.out.println("2: Midnight Silver     ------    +$1,000.00");
        System.out.println("3: Deep Blue Metallic  ------    +$1,000.00");
        System.out.println("4: Solid Black         ------    +$1,500.00");
        System.out.println("5: Red Multi-Coat      ------    +$2,000.00");
    }

    default void displaySWheelTypes(){
        System.out.println("Model 3    ------    $");
    }
        // PLUS display3AndSTow in MODEL 3
        //PLUS displayAutopilotTypes in MODEL 3
        // PLUS displayChargingTypes in MODEL 3
        // PLUS displayTotalPricing in MODEL 3

    //MODEL X
    default void displayXTrimLevels(){
        System.out.println("Model X    ------    $");
    }
        // PLUS displaySAndXExteriorColors()

    default void displayXWheelTypes(){
        System.out.println("Model 3    ------    $");
    }

    default void displaySAndXInteriorColors(){
        System.out.println("Model 3    ------    $");
    }
        // PLUS displayAutopilotTypes in MODEL 3
        // PLUS displayChargingTypes in MODEL 3
        // PLUS displayTotalPricing in MODEL 3

// END OF PROGRAM
    default void endOfProgram(){
        System.out.println("Thank you for using the Tesla Configurator, Goodbye!");
    }
}
