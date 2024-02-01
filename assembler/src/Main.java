import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Input param is missing");
            System.exit(1);
        }
        new Assembler(args[0]);
    }
}