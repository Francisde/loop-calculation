package emulator;

import java.util.List;

import structure.Assignment;
import structure.Statement;

import javax.swing.plaf.nimbus.State;

public class Emulator {

    private List<Statement> statements;
    private int maxVar;
    private int[] vars;

    public Emulator(List<Statement> statements, int maxVar) {
        this.statements = statements;
        this.maxVar = maxVar;
        this.vars = new int[maxVar];
        for (int i = 0; i < maxVar; i++) {
            vars[i] = 0;
        }
    }


    public int run() {
        for (Statement statement : statements) {
            this.runAssignment((Assignment) statement);
        }

        return vars[0];
    }

    /**
     * the method valuate a single assignment statement and change the global program variables
     *
     * @param assignemnt as an Assignment object
     */
    private void runAssignment(Assignment assignemnt) {
        this.vars[assignemnt.getI() - 1] = vars[assignemnt.getJ() - 1] + assignemnt.getC();
    }
    
}
