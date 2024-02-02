package file;

import java.io.File;
import java.io.FileWriter;

public class FileOutput {
    File outputFile;

    public FileOutput(String inputPath) {
        String outputPath = inputPath.replaceFirst("\\.s", ".bin");
        outputFile = new File(outputPath);
    }

    public void writeToFile(byte[] data) {
        try {
            FileWriter fileWriter = new FileWriter(outputFile);

            for (int i = 0; i < data.length; i++) {
                fileWriter.append((char) data[i]);
            }
            fileWriter.flush();
            fileWriter.close();

        } catch (Exception e) {
            System.err.println("Was not able to write to .bin file");
        }
    }
}
