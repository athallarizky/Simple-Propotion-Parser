/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FiniteAutomata;

import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class InputView {

    public String readString() {
        System.out.println("Type 'help' to get more information");
        System.out.print("Insert your proposition : ");
        Scanner scanner = new Scanner(System.in);
        String proposition = scanner.nextLine();
        if (proposition.equals("help")) {
            showHelp();
            System.out.print("Insert your proposition : ");
            proposition = scanner.nextLine();
        }
        return proposition;
    }
    
    public void showHelp() {
        System.out.println("This program only read this combination");
        System.out.println("        // OPERAND   : p, q, r, s\n"
                + "        // OPERATOR  : not, and, or, xor, if, then, iff\n"
                + "        // GROUPING  : (, )\n"
                + "Always give a blank space between open or close bracket!\n"
                + "Example : if ( p or q ) then s \n");
    }

}
