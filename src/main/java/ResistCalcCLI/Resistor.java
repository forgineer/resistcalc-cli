package ResistCalcCLI;

import java.util.ArrayList;
import java.util.Arrays;

enum eBands {
    /*
        Color Codes
        Color       Value       Multiplier      Tolerance       PPM
        ----------------------------------------------------------------
        Black       (0)         1 ohms                          250ppm/K
        Brown       (1)         10 ohms         +/-1%           100ppm/K
        Red         (2)         100 ohms        +/-2%           50ppm/K
        Orange      (3)         1K ohms                         15ppm/K
        Yellow      (4)         10K ohms                        25ppm/K
        Green       (5)         100K ohms       +/-0.5%         20ppm/K
        Blue        (6)         1M ohms         +/-0.25%        10ppm/K
        Violet      (7)         10M ohms        +/-0.10%        5ppm/K
        Grey        (8)         100M ohms       +/-0.25%        1ppm/K
        White       (9)         1G ohms
        Gold                    0.10 ohms       +/-5%
        Silver                  0.01 ohms       +/-10%
    */
    
    BLACK("0", 1, 0.0, 250),
    BROWN("1", 10, 1.0, 100),
    RED("2", 100, 2.0, 50),
    ORANGE("3", 1000, 0.0, 15),
    YELLOW("4", 10000, 0.0, 25),
    GREEN("5", 100000, 0.5, 20),
    BLUE("6", 1000000, 0.25, 10),
    VIOLET("7", 10000000, 0.10, 5),
    GREY("8", 100000000, 0.25, 1),
    WHITE("9", 1000000000, 0.0, 0),
    GOLD("0", 0.10, 5, 0),
    SILVER("0", 0.01, 10, 0);
    
    private String value;
    private double multiplier;
    private double tolerance;
    private int pmm;
    
    public String getValue() {
        return this.value;
    }
    
    public double getMultiplier() {
        return this.multiplier;
    }

    public double getTolerance() {
        return this.tolerance;
    }

    public int getPmm() {
        return this.pmm;
    }
    
    private eBands(String value, double multiplier, double tolerance, int pmm) {
        this.value = value;
        this.multiplier = multiplier;
        this.tolerance = tolerance;
        this.pmm = pmm;
    }
}

public class Resistor {

    public String translateToValue(String[] pColors, String pUnits, boolean pDebug) { 
        boolean errorInd = false;
        String baseNum;
        double multiplier;
        String resistance = ""; // Final returned value
        
        for(int idx = 0; idx < pColors.length; idx++) {
            
            // Breakout if one of the bands is NULL
            if(pColors[idx] == null) {
                resistance = "ERROR: Color band (" + (idx+1) + ") is missing.";
                break;
            }
            
            // Breakout if one of the bands is not a valid color code...
            if(!validateColor(pColors[idx])) {
                resistance = "ERROR: Color band (" + (idx+1) + ") has invalid color code: " + pColors[idx].toUpperCase() + ".";
                break;
            }
            
            // Breakout if the first or second band is GOLD or SILVER...
            if(idx == 0 || idx == 1) {
               if(pColors[idx].toUpperCase().trim() == "GOLD" || pColors[idx].toUpperCase().trim() == "SILVER") {
                   resistance = "ERROR: Invalid color band (" + (idx+1) + ") of " + pColors[idx].toUpperCase() + ".";
                   break;  
               }
            }
            
            
            // Translate FIRST color band...
            //baseNum = getColorValue(pColors[idx]);
            
            
            // Translate SECOND color band...
            
            
        }

        return resistance;
    }
    
    public ArrayList translateToColors(String pValue, String pUnits, double pTolerance, int pPmm, boolean pDebug) {
        ArrayList<String> colors = new ArrayList<String>();
        
        colors.add("RED");
        colors.add("GREEN");
        colors.add("BLUE");
        
        return colors;
    }

    static boolean validateColor(String color) {
        boolean validInd = true;

        switch(color.toUpperCase().trim()) {
            case "BLACK":
                break;
            case "RED":
                break;
            case "ORANGE":
                break;
            case "YELLOW":
                break;
            case "GREEN":
                break;
            case "BLUE":
                break;
            case "VIOLET":
                break;
            case "GREY":
                break;
            case "WHITE":
                break;
            case "GOLD":
                break;
            case "SILVER":
                break;
            default:
                validInd = false;
        }
        
        return validInd;
    }
    
    // Gets color value associated to enum object
    static String getColorValue(String color) {
        String colorVal = "";

        switch(color.toUpperCase().trim()) {
            case "BLACK":
                colorVal = eBands.BLACK.getValue();
                break;
            case "RED":
                colorVal = eBands.RED.getValue();
                break;
            case "ORANGE":
                colorVal = eBands.ORANGE.getValue();
                break;
            case "YELLOW":
                colorVal = eBands.YELLOW.getValue();
                break;
            case "GREEN":
                colorVal = eBands.GREEN.getValue();
                break;
            case "BLUE":
                colorVal = eBands.BLUE.getValue();
                break;
            case "VIOLET":
                colorVal = eBands.VIOLET.getValue();
                break;
            case "GREY":
                colorVal = eBands.ORANGE.getValue();
                break;
            case "WHITE":
                colorVal = eBands.WHITE.getValue();
        }
        
        return colorVal;
    }
}
