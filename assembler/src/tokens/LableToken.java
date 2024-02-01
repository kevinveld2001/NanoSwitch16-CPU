package tokens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LableToken {
    private boolean hasLable = false;
    private String lable = "";
    final String lableRegex = "(\\w+):(\\s)*(\\n)*";
    public LableToken(StringBuilder rawLineBuilder) {
        String rawLine = rawLineBuilder.toString();
        Pattern lablePattern = Pattern.compile(lableRegex);
        Matcher lableMatcher = lablePattern.matcher(rawLine);
        if (lableMatcher.find()) {
            hasLable = true;
            lable = lableMatcher.group(1);

            rawLineBuilder.replace(0, rawLine.length(), rawLine.replaceAll(lableRegex, ""));
        }
    }

    public boolean hasLable() {
        return hasLable;
    }

    public String getLable() {
        return lable;
    }
}
