package mas.ssatr.moldovan.ovidiu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {
    public static void Write(String content) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt", true))) {
            bw.write(content);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }
}
