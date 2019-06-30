import emulator.Emulator;
import structure.Assignment;
import structure.Statement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // first test
        Assignment as1 = new Assignment(2, 1, 2);
        Assignment as2 = new Assignment(1, 2, 3);
        List<Statement> statements = new ArrayList();
        statements.add(as1);
        statements.add(as2);
        Emulator e = new Emulator(statements, 2);
        System.out.println(e.run());

    }

}
