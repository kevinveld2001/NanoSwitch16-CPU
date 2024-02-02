package tokens;

import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class DefineFunctionToken implements Token {
    private byte[] values;
    private byte startAddress;
    public DefineFunctionToken(String params) {
        params = params.replaceAll(" ", "");
        String[] values = params.split(",");

        try {
            this.values = new byte[values.length];
            for (int i = 0; i < values.length; i++) {
                this.values[i] = Byte.parseByte(values[i]);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Function has invalid params.");
        }
    }

    @Override
    public byte[] getMachineCodes(Map<String, AtomicInteger> lableAddresses) {
        return values;
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
        return (byte) (startAddress + values.length);
    }
}
