package tokens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineToken {
    LableToken lableToken;
    public LineToken(String rawLine) {
        StringBuilder rawLineBuilder = new StringBuilder(rawLine);
        lableToken = new LableToken(rawLineBuilder);

        System.out.println("============");
        System.out.println(rawLineBuilder);
    }

    public LableToken getLableToken() {
        return lableToken;
    }
}
