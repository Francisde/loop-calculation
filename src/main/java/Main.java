import IO.ParseLoopFile;
import emulator.Emulator;
import structure.Assignment;
import structure.Loop;
import structure.Program;
import structure.Statement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // first test
        Assignment as0 = new Assignment(1, 1, 2);
        Assignment as1 = new Assignment(2, 1, 0);
        Assignment as2 = new Assignment(1, 2, 5);
        List<Statement> innerStatements = new ArrayList();

        innerStatements.add(as2);
        Loop l2 = new Loop(1, innerStatements);
        List<Statement> innerStatements2 = new ArrayList();
        innerStatements2.add(l2);
        Loop l1 = new Loop(1, innerStatements2);
        List<Statement> statements = new ArrayList();
        statements.add(as0);
        statements.add(as1);
        statements.add(l1);
        Program program = new Program(statements);
        Emulator e = new Emulator(program, 2);
        System.out.println(program);
        System.out.println("Result: " + e.run());


        ParseLoopFile.parseFile("samples/sample1.loop");
        /*e = new Emulator(testprogram, testprogram.getMaxvar());
        System.out.println("Maxvar: " + testprogram.getMaxvar());
        System.out.println("Print: " + testprogram);
        System.out.println("Result: " + e.run());
*/

    }

}
