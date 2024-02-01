package tokens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineToken {
    LableToken lableToken;
    public LineToken(String rawLine) {
        lableToken = new LableToken(rawLine);

        System.out.println("============");
        System.out.println(rawLine);
    }

    public LableToken getLableToken() {
        return lableToken;
    }
}
