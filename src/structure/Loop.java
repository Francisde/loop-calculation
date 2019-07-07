package structure;

import java.util.List;

/**
 * This class defines a loop statement. A loop statement has the form
 * LOOP(xi){
 * P;
 * }
 * where xi is the count variable and P is the statement which is calculatet xi times.
 */
public class Loop extends Statement {

    private int i;
    private List<Statement> statements;

    /**
     * the public constructor for the Loop object
     *
     * @param i          the index of the count value
     * @param statements a list of the inner statements in the loop
     */
    public Loop(int i, List<Statement> statements) {
        this.i = i;
        this.statements = statements;
    }

    /**
     * public getter for the index value
     *
     * @return index value i as an integer
     */
    public int getI() {
        return i;
    }

    /**
     * public getter for the list of inner statements
     *
     * @return a list of Statement objects as a List object
     */
    public List<Statement> getStatements() {
        return statements;
    }

    public int getMaxvar() {
        return -1;
    }

    @Override
    public String toString() {
        String result = "";
        result += "LOOP (X" + this.i + ") {\n";
        for (Statement statement : this.statements) {
            result += "\t";
            result += statement.toString().replace("\n", "\n\t");
            result += "\n";
        }
        result += "}";
        return result;
    }
}
