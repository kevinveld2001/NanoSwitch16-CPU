package tokenizer;

import tokens.LineToken;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineTokenizer {
    private ArrayList<LineToken> lineTokens = new ArrayList<>();

    public LineTokenizer(String rawCode) {
        Pattern linePattern = Pattern.compile(
                "^(\\w+:\\s*)?(\\n\\s*)*((\\w{3}(\\s(\\d|\\w)+)?)|(@\\w+\\(.+\\)))(\\n|$)",
                Pattern.MULTILINE
        );
        Matcher lines = linePattern.matcher(rawCode);
        while (lines.find()) {
            lineTokens.add(new LineToken(lines.group().trim()));
        }
    }

    public ArrayList<LineToken> getLineTokens() {
        return lineTokens;
    }
}
