import file.FileInput;

public class Assembler {
    public Assembler(String inputFileName) {
        FileInput fileInput = new FileInput(inputFileName);
        String rawCode = fileInput.getRawCode();

        System.out.println(rawCode);

    }
}
