package file;

import java.io.File;
import java.util.Scanner;

public class FileInput {
    private String rawCode = "";

    public FileInput (String fileName) {
        File input = new File(fileName);

        if (!input.exists()) {
            fileNotFoundExit();
        }
        try {
            Scanner inputScanner = new Scanner(input);
            StringBuilder rawCodeBuilder = new StringBuilder();
            while (inputScanner.hasNextLine()) {
                rawCodeBuilder.append(inputScanner.nextLine()).append("\n");
            }
            rawCode = rawCodeBuilder.toString();
        } catch (Exception e) {
            fileNotFoundExit();
        }
    }

    private void fileNotFoundExit() {
        System.err.println("File not found");
        System.exit(1);
    }

    public String getRawCode() {
        return rawCode;
    }
}
