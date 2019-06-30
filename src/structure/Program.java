package structure;


import java.util.List;

public class Program {

    private List<Statement> statementList;

    public Program(List<Statement> statementList) {
        this.statementList = statementList;
    }

    public List<Statement> getStatementList() {
        return statementList;
    }
}
