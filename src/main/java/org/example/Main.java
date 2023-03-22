package org.example;

import java.util.Scanner;

public class Main implements Runnable {
    private Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        Main main = new Main();
        main.run();

    }

    @Override
    public void run() {
        printMainMenu();
        displayModels();
    }

    private void printMainMenu() {

        System.out.println("Welcome to the Tesla Configurator");
        System.out.println();
        System.out.println("1: Build your Tesla!");
        System.out.println("2: Exit");
        System.out.println();
    }

    private void displayModels(){
        System.out.println("Model 3    ------    $");
        System.out.println("Model Y    ------    $");
        System.out.println("Model S    ------    $");
        System.out.println("Model X    ------    $");
    }

    private void displayTrimLevels(){
        System.out.println("Model 3    ------    $");
    }

    private void displayExteriorColors(){
        System.out.println("Model 3    ------    $");
    }

    private void displayWheelTypes(){
        System.out.println("Model 3    ------    $");
    }

    private void displayInteriorColors(){
        System.out.println("Model 3    ------    $");
    }

    private void displayAutopilotTypes(){
        System.out.println("Model 3    ------    $");
    }

    private void displayChargingTypes(){
        System.out.println("Model 3    ------    $");
    }

    private void displayTotalPricing(){

    }

}