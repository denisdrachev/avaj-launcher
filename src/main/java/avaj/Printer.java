package avaj;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class Printer {

    private static String outputFileName = "simulation.txt";
    private static Path path = Paths.get(outputFileName);

    public static void writeToFile(String s) {
        String str = s.concat("\n");
        byte[] strToBytes = str.getBytes();
        try {
            Files.write(path, strToBytes, StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToConsole(String s) {
        String str = s.concat("\n");
        System.out.println(str);
    }

    public static Path getPath() {
        return path;
    }
}
