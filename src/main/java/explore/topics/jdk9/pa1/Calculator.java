package explore.topics.jdk9.pa1;

import explore.topics.jdk9.internal.Addhelper;

public class Calculator {

    Addhelper addhelper = new Addhelper();

    public int adder(int u, int v) {
        return addhelper.adder(u, v);
    }

    public int adder(double u, double v) {
        return addhelper.adder((int)u, (int)v);
    }
}
