package IO;

import parser.ParseAssignment;
import structure.Program;
import structure.Statement;

import javax.swing.plaf.nimbus.State;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * This class implements methods which can parse a .loop file in an Program object
 */
public class ParseLoopFile {

    public static Program parseFile(String filePath) {
        Program result = null;
        List<Statement> statementList = new ArrayList();
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
                    continue; // this line is a comment line
                } else if (inputLine.startsWith("x") || inputLine.startsWith("X")) {
                    // parse assignemnt
                    // this will be easy
                    Statement statement = ParseAssignment.parseAssignment(inputLine);
                    statementList.add(statement);
                } else if (inputLine.startsWith("L")) {
                    // parse loop statement
                } else {
                    // in this case the parser read unexpected code
                    // throw an parser exception
                }

            }
        } catch (Exception e) {
            System.err.println(e);
        }
        result = new Program(statementList);
        return result;
    }
}
