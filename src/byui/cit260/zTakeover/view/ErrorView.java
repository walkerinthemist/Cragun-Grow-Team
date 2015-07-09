/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.zTakeover.view;

import java.io.*;
import zombietakeover.ZombieTakeover;

/**
 *
 * @author The King's Wit
 */
public class ErrorView {
    private static final PrintWriter errorFile = ZombieTakeover.getOutFile();
    private static final PrintWriter logFile = ZombieTakeover.getLogFile();
    public static void display (String className, String errorMessage){
        errorFile.println(
         "-----------------------------------------------------------------"
        +"\n- Error - " + errorMessage
        +"\n-----------------------------------------------------------------");
        
        logFile.println(className + " - " + errorMessage);
    }
}
