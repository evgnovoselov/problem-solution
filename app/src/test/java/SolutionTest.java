import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

class SolutionTest {
    private static final InputStream OLD_SYSTEM_IN = System.in;
    private static final PrintStream OLD_SYSTEM_OUT = System.out;
    private static final byte[] BUFFER = new byte[10240];
    private OutputStream outputStream;

    @BeforeEach
    void setUp() {
        InputStream inputStream = new ByteArrayInputStream(BUFFER);
        System.setIn(inputStream);

        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @AfterEach
    void tearDown() {
        System.setIn(OLD_SYSTEM_IN);
        System.setOut(OLD_SYSTEM_OUT);
    }

    @Test
    void test1() {
        String inputString = "Hello world!" + System.lineSeparator();
        System.arraycopy(inputString.getBytes(), 0, BUFFER, 0, inputString.length());

        Solution.main(new String[]{});

        String expected = "Hello world!" + System.lineSeparator();
        Assertions.assertEquals(expected, outputStream.toString());
    }
}