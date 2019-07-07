package structure;

public class Assignment extends Statement {
    /*
     * an assignment has the form xi = xj + c. where i and j are elements from Var(P) and i==j is possible. c is a integer.
     */

    private int i;
    private int j;
    private int c;


    /**
     * the public constructor for the Assignment object
     *
     * @param i the variable index for the left side of the equation
     * @param j the variable index for the right side of the equation
     * @param c the integer after the + of the right side of the equation
     */
    public Assignment(int i, int j, int c) {
        this.i = i;
        this.j = j;
        this.c = c;
    }

    /**
     * the public getter for left index i
     *
     * @return index i as an integer
     */
    public int getI() {
        return i;
    }

    /**
     * the public getter for the right index j
     *
     * @return index j as an integer
     */
    public int getJ() {
        return j;
    }

    /**
     * the public getter for the right side integer value c
     *
     * @return c as an integer
     */
    public int getC() {
        return c;
    }

    public int getMaxvar() {
        if (i > j) {
            return i;
        } else {
            return j;
        }
    }

    @Override
    public String toString() {
        return "x" + this.i + " = x" + this.j + " + " + this.c;
    }

    @Override
    public boolean equals(Object other) {
        if (other.getClass() != Assignment.class) {
            return false;
        } else {
            other = (Assignment) other;
            if (((Assignment) other).getC() == this.c && ((Assignment) other).getI() == this.i && ((Assignment) other).getJ() == this.j) {
                return true;
            } else {
                return false;
            }
        }
    }

}
