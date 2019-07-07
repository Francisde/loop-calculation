package emulator;

import java.util.List;

import structure.Assignment;
import structure.Loop;
import structure.Program;
import structure.Statement;

import javax.swing.plaf.nimbus.State;

public class Emulator {

    private Program program;
    private int maxVar;
    private int[] vars;

    public Emulator(Program program, int maxVar) {
        this.program = program;
        this.maxVar = maxVar;
        this.vars = new int[maxVar];
        for (int i = 0; i < maxVar; i++) {
            vars[i] = 0;
        }
    }


    public int run() {
        for (Statement statement : program.getStatementList()) {
            runStatement(statement);
        }

        return vars[0];
    }

    private void runStatement(Statement statement) {
        if (statement.getClass() == Assignment.class) {
            this.runAssignment((Assignment) statement);
        } else if (statement.getClass() == Loop.class) {
            this.runLoop((Loop) statement);
        }
    }

    /**
     * the method valuate a single assignment statement and change the global program variables
     *
     * @param assignemnt as an Assignment object
     */
    private void runAssignment(Assignment assignemnt) {
        this.vars[assignemnt.getI() - 1] = vars[assignemnt.getJ() - 1] + assignemnt.getC();
        //System.out.println(assignemnt);
    }

    /**
     * the method valuate loop statement
     *
     * @param loop as as Loop object
     */
    private void runLoop(Loop loop) {
        int loopIndex = vars[loop.getI() - 1];
        for (; loopIndex > 0; loopIndex--) {
            for (Statement statement : loop.getStatements()) {
                runStatement(statement);
            }
        }
    }

}
