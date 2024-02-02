package tokens;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LineToken implements Token {
    LableToken lableToken;
    Token compilebleToken;
    public LineToken(String rawLine) {
        StringBuilder rawLineBuilder = new StringBuilder(rawLine);
        lableToken = new LableToken(rawLineBuilder);

        if (rawLineBuilder.charAt(0) == '@') {
            String[] function = getFunctionName(rawLineBuilder.toString());
            switch (function[0]) {
                case "page":
                    compilebleToken = new PageFunctionToken(function[1]);
                    break;
                case "define":
                    compilebleToken = new DefineFunctionToken(function[1]);
                    break;
//                case "sub":
//                    break;
                default:
                    throw new IllegalArgumentException(rawLineBuilder.append(" <-- is not a valid function").toString());
            }
        } else {
            compilebleToken = new OpcodeToken(rawLineBuilder);
        }
    }

    public LableToken getLableToken() {
        return lableToken;
    }

    @Override
    public byte[] getMachineCodes(Map<String, AtomicInteger> lableAddresses) {
        return compilebleToken.getMachineCodes(lableAddresses);
    }

    @Override
    public void setStartAddress(byte startAddress) {
        compilebleToken.setStartAddress(startAddress);
    }

    @Override
    public byte getStartAddress() {
        return compilebleToken.getStartAddress();
    }

    @Override
    public byte getEndAddress() {
        return compilebleToken.getEndAddress();
    }

    private String[] getFunctionName(String rawCode) {
        Pattern functionPattern = Pattern.compile("^@(\\w+)\\((.*)\\)$");
        Matcher functionMatcher = functionPattern.matcher(rawCode);

        String[] function = new String[2];
        if (functionMatcher.find()) {
            function[0] = functionMatcher.group(1);
            function[1] = functionMatcher.group(2);
        }
        return function;
    }
}
