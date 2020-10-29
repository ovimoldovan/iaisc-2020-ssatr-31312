package mas.ssatr.moldovan.ovidiu;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileHelper {

    private static String fileName = "output.txt";

    public static void DeletePreviousOutputs() {
        File myObj = new File(fileName);
        if (myObj.delete()) {
            System.out.println("New file printed");
        }
    }

    public static void Write(String content) {

        System.out.println(content);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(content);
            bw.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void WriteOneLine(String content) {

        System.out.print(content);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {
            bw.write(content);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
