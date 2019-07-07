package structure;


import java.util.List;

public class Program {

    private List<Statement> statementList;

    /**
     * the public constructor for the Program object
     *
     * @param statementList the statementlist as a List object
     */
    public Program(List<Statement> statementList) {
        this.statementList = statementList;
    }

    /**
     * the public getter for the statementList
     *
     * @return all Statement objects as a list
     */
    public List<Statement> getStatementList() {
        return statementList;
    }

    public int getMaxvar() {
        int maxVar = 1;
        for (Statement statement : statementList) {
            int localMaxVar = statement.getMaxvar();
            if (localMaxVar > maxVar) {
                maxVar = localMaxVar;
            }
        }

        return maxVar;
    }

    /**
     * toString method for the Program object
     *
     * @return a string representation for the Emulator object
     */
    @Override
    public String toString() {
        String result = "";
        for (Statement statement : this.statementList) {
            result += statement + "\n";
        }
        return result;
    }
}
