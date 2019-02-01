import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class CalcTest {

    static final String path = "D:\\calc_div.exe";

    @DisplayName("Display name of container")
    @ParameterizedTest(name = "{index} ==> first=''{0}'', second=''{1}'', expected=''{2}''")
    @CsvFileSource(resources = "TestsSources.csv")
    void test1(String first, String second, String expected) throws IOException {
        StringBuilder line = new StringBuilder();
        OutputStream stdin;
        InputStream stdout;
        String result;

        Process process = Runtime.getRuntime().exec(path);
        stdin = process.getOutputStream();
        stdout = process.getInputStream();

        line.append(first + " " + second);
        stdin.write(line.toString().getBytes());
        stdin.flush();
        stdin.close();

        BufferedReader brCleanUp =
                new BufferedReader(new InputStreamReader(stdout));

        result = brCleanUp.readLine();
        brCleanUp.close();

        assertEquals(expected, result);

    }

}