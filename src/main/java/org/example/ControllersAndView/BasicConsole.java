package org.example.ControllersAndView;

import java.math.BigDecimal;
import java.time.LocalDate;

public interface BasicConsole {

        void pauseOutput();

        void printMessage(String message);
        void printErrorMessage(String message);
        void printDivider();
        void printBanner(String message);
        void printBulletedItems(String[] items);

        String getMenuSelection(String[] options);
        String getMenuSelection(String[] options, boolean allowNullResponse);
        Integer getMenuSelectionIndex(String[] options, boolean allowNullResponse);

        String promptForString(String prompt);
        //    String promptForString(String prompt, String defaultValue);
        boolean promptForYesNo(String prompt);
        //    boolean promptForYesNo(String prompt, boolean defaultValue);
        Integer promptForInteger(String prompt);
        //    Integer promptForInteger(String prompt, Integer defaultValue);
        Double promptForDouble(String prompt);
        //    Double promptForDouble(String prompt, Double defaultValue);
        BigDecimal promptForBigDecimal(String prompt);
        //    BigDecimal promptForBigDecimal(String prompt, BigDecimal defaultValue);
        LocalDate promptForLocalDate(String prompt);
//    LocalDate promptForLocalDate(String prompt, LocalDate defaultValue);
    }


