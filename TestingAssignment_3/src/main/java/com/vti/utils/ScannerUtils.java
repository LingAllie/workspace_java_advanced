package com.vti.utils;

import java.util.*;

public class ScannerUtils {

    private static Scanner sc = new Scanner(System.in);

    public static String inputString(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                String input = sc.nextLine().trim();
                if (!input.isEmpty()) {
                    return input;
                } else {
                    System.err.println("Input is empty, please enter data !");
                }

            } catch (Exception e) {
                System.err.println("Unexpected error occurred: " + e.getMessage());
            }
        }
    }

    public static short inputNumShort(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                short input = Short.parseShort(sc.nextLine().trim());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error occurred: " + e.getMessage());
            }
        }
    }

    public static int inputNumInt(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                int input = Integer.parseInt(sc.nextLine().trim());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error occurred: " + e.getMessage());
            }
        }
    }

    public static boolean inputBoolean(String msg) {
        while (true) {
            try {
                System.out.print(msg);
                boolean input = Boolean.parseBoolean(sc.nextLine().trim());
                return input;
            } catch (NumberFormatException e) {
                System.err.println("Invalid boolean format: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error occurred: " + e.getMessage());
            }
        }
    }



}
