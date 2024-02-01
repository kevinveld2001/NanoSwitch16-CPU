import file.FileInput;
import tokenizer.LineTokenizer;
import tokens.LineToken;

import java.util.ArrayList;

public class Assembler {
    public Assembler(String inputFileName) {
        FileInput fileInput = new FileInput(inputFileName);
        String rawCode = fileInput.getRawCode();

        LineTokenizer lineTokenizer = new LineTokenizer(rawCode);
        ArrayList<LineToken> lineTokens = lineTokenizer.getLineTokens();
        for (var lineToken : lineTokens) {
            if (lineToken.getLableToken().hasLable()) {
                System.out.println("----------------");
                System.out.println(lineToken.getLableToken().getLable());
            }
        }
    }
}
