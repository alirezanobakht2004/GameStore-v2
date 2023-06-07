package ir.ac.kntu;

import java.io.OutputStream;
import java.io.PrintStream;

class MyPrintStream extends PrintStream {

    public MyPrintStream(OutputStream out) {
        super(out);
    }

    @Override
    public void println(String x) {
        super.println(x);
        super.println("<br>");  // Add extra line break
    }
}
