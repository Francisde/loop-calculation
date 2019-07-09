package parser;

import structure.Assignment;

/**
 * @author francis
 * @since 0.1
 */
public class ParseAssignment {

    public static Assignment parseAssignment(String input) {
        //remove possible ";" at the end of the String
        input = input.replace(";", "");
        input = input.strip();
        input = input.toLowerCase();
        String[] bothSides = input.split("=");
        if (bothSides.length != 2) {
            // throw exception
        }
        String leftSide = bothSides[0].replace("x", "");
        leftSide = leftSide.strip();
        int i = Integer.parseInt(leftSide);

        // change + to @ because split cant check '+' character
        bothSides[1] = bothSides[1].replace("+", "@");
        String[] rightSide = bothSides[1].split("@");
        if (rightSide.length != 2) {
            // throw exception
        }
        String left = rightSide[0].replace("x", "");
        left = left.strip();
        int j = Integer.parseInt(left);

        String right = rightSide[1].strip();
        int c;
        if (right.contains("-")) {
            right = right.replace("-", "");
            c = Integer.parseInt(right);
            c = 0 - c;
        } else {
            c = Integer.parseInt(right);
        }

        return new Assignment(i, j, c);
    }
}
