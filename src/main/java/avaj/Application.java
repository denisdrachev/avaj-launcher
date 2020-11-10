package avaj;

import avaj.exceptions.BaseException;
import avaj.exceptions.IncorrectInputException;
import avaj.helper.AircraftType;
import avaj.weather.WeatherTower;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import static avaj.Printer.writeToConsole;

public class Application {

    private static int roundCount = 0;

    private static void deleteFile() throws IOException {
        try {
            Files.delete(Printer.getPath());
        } catch (Exception e) {}
        Files.createFile(Printer.getPath());
    }

    public static void main(String[] args) throws IOException {
        if (args == null || args.length != 1 || args[0].isEmpty()) {
            exitWithPrint("Incorrect options");
        }

        deleteFile();

        String fileName = args[0];
        List<Flyable> collect = new ArrayList<>();
        try {

            File file = new File(fileName);
            if (!file.exists()) {
                exitWithPrint("File '" + fileName + "' not found");
            }
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String line;
            List<String> correctLines = new ArrayList<>();
            try {
                while ((line = br.readLine()) != null)
                    if (filter(line))
                        correctLines.add(line);
            } catch (BaseException e) {
                writeToConsole(e.getMessage());
                System.exit(0);
            } finally {
                fr.close();
            }

            for (String correctLine : correctLines) {
                collect.add(prepare(correctLine));
            }
        } catch (IOException e) {
            exitWithPrint(e.getMessage());
        }

        WeatherTower weatherTower = new WeatherTower();

        for (Flyable flyable : collect) {
            flyable.registerTower(weatherTower);
        }

        weatherTower.simulate(getRoundCount());
    }

    private static boolean filter(String line) throws IncorrectInputException {
        if (line.matches("^\\d+")) {
            try {
                setRoundCount(Integer.parseInt(line));
            } catch (Exception e) {
                return true;
            }
            return false;
        } else {
            if (getRoundCount() <= 0)
                throw new IncorrectInputException("Incorrect input. First line incorrect!");
            String[] sArray = line.split(" ");
            if (sArray.length != 5)
                throw new IncorrectInputException("Incorrect input. Line components not equal 5. Line data: " + line);
            try {
                String aircraftType = sArray[0];
                int longitude = Integer.parseInt(sArray[2]);
                int latitude = Integer.parseInt(sArray[3]);
                int height = Integer.parseInt(sArray[4]);

                AircraftType.valueOf(aircraftType.toUpperCase());

                if (longitude <= 0 || latitude <= 0 || height > 100 || height <= 0)
                    throw new IncorrectInputException("Incorrect input. Params value incorrect. Line data: " + line);
            } catch (Exception e) {
                throw new IncorrectInputException("Incorrect input. Line data: " + line);
            }
            return true;
        }
    }

    private static Flyable prepare(String s) {
        String[] sArray = s.split(" ");
        try {
            return AircraftFactory.newArtifact(
                    sArray[0],
                    sArray[1],
                    Integer.parseInt(sArray[2]),
                    Integer.parseInt(sArray[3]),
                    Integer.parseInt(sArray[4]));
        } catch (Exception e) {
            return null;
        }
    }

    public static int getRoundCount() {
        return roundCount;
    }

    public static void exitWithPrint(String text) {
        writeToConsole(text);
        System.exit(0);
    }

    public static void setRoundCount(int roundCount) {
        Application.roundCount = roundCount;
    }
}

