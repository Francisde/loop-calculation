package IO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements methods which can parse a .loop file.
 *
 * @author francis
 * @since 0.1
 */
public class ParseLoopFile {

    /**
     * this method reads a .loop file from the given path and parse it to an List of Strings
     * each String represents a single line in the loop program. Inline comments and empty lines will
     * be removed after this step.
     *
     * @param filePath the filepath as a String
     * @return the program as a List of Strings
     * @since 0.1
     */
    public static List<String> parseFile(String filePath) {
        List<String> result = new ArrayList<>();
        File file = new File(filePath);
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.err.println("Exception while try to open the FileReader.\nThe parser will be closed");
            e.printStackTrace();
        }

        String inputLine;
        try {
            while ((inputLine = br.readLine()) != null) {
                inputLine = inputLine.strip();
                if (inputLine.startsWith("//")) {
                    continue; // this line is a comment line and will be ignored
                } else if (inputLine.equals("")) {
                    continue; // it's an empty line
                } else {
                    System.out.println(inputLine);
                    result.add(removeInlineComments(inputLine));
                }
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        return result;
    }

    /**
     * @param input
     * @return
     * @since 0.1
     */
    public static String removeInlineComments(String input) {
        if (input == null) {
            throw new NullPointerException();
        }
        String result = input;
        int commentIndex = input.indexOf("//");
        if (commentIndex != -1) {
            result = input.substring(0, commentIndex);
        }
        return result;
    }
}
