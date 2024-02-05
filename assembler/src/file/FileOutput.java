package file;

import java.io.*;

public class FileOutput {
    File outputFile;

    public FileOutput(String inputPath) {
        String outputPath = inputPath.replaceFirst("\\.s", ".bin");
        outputFile = new File(outputPath);
    }

    public void writeToFile(byte[] data) {
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(data);
            System.out.println("Bin file was successfully saved to: " + outputFile.getName());
        } catch (Exception e) {
            System.err.println("Was not able to write to .bin file: " + e.getMessage());
        }
    }
}
