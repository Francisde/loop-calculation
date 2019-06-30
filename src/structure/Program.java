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
     * @return all Statement objects as a list
     */
    public List<Statement> getStatementList() {
        return statementList;
    }
}
