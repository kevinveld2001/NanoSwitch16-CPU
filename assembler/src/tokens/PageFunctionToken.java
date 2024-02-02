package tokens;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class PageFunctionToken implements Token {
    private byte startAddress;
    private byte endAddress;
    public PageFunctionToken(String params) {
        try {
            this.endAddress = (byte) (16 * Byte.parseByte(params));
        } catch (Exception e) {
            throw new IllegalArgumentException("Function has invalid params.");
        }
    }

    @Override
    public byte[] getMachineCodes(Map<String, AtomicInteger> lableAddresses) {
        return new byte[endAddress - startAddress];
    }

    @Override
    public void setStartAddress(byte startAddress) {
        this.startAddress = startAddress;
    }

    @Override
    public byte getStartAddress() {
        return startAddress;
    }

    @Override
    public byte getEndAddress() {
        return endAddress;
    }
}
