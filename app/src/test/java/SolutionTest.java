import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    private static final InputStream OLD_SYSTEM_IN = System.in;
    private static final PrintStream OLD_SYSTEM_OUT = System.out;
    private static final byte[] BUFFER = new byte[1024 * 10];
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

    private static void setInputInBuffer(String inputString) {
        System.arraycopy(inputString.getBytes(), 0, BUFFER, 0, inputString.length());
    }

    @Test
    void test1() {
        String inputString = """
                3
                Hello world! - 1
                Hello world! - 2
                Hello world! - 3
                """;

        setInputInBuffer(inputString);
        Solution.main(new String[]{});

        String expected = """
                Hello world! - 1
                Hello world! - 2
                Hello world! - 3
                """;
        assertEquals(expected, outputStream.toString());
    }

}
