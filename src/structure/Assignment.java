package structure;

public class Assignment extends Statement {
    /*
     * an assignment has the form xi = xj + c. where i and j are elements from Var(P) and i==j is possible. c is a integer.
     */

    private int i;
    private int j;
    private int c;


    public Assignment(int i, int j, int c) {
        this.i = i;
        this.j = j;
        this.c = c;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public int getC() {
        return c;
    }
}
