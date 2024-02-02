package tokens;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class LineToken implements Token {
    LableToken lableToken;
    Token compilebleToken;
    public LineToken(String rawLine) {
        StringBuilder rawLineBuilder = new StringBuilder(rawLine);
        lableToken = new LableToken(rawLineBuilder);

        if (rawLineBuilder.charAt(0) == '@') {
            //function
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
}
