package tokens;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LableToken {
    private boolean hasLable = false;
    private String lable = "";
    public LableToken(String rawLine) {
        Pattern lablePattern = Pattern.compile("(\\w+):");
        Matcher lableMatcher = lablePattern.matcher(rawLine);
        if (lableMatcher.find()) {
            hasLable = true;
            lable = lableMatcher.group(1);
        }
    }

    public boolean hasLable() {
        return hasLable;
    }

    public String getLable() {
        return lable;
    }
}
