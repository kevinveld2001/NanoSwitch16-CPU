package tokens;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public interface Token {

    byte[] getMachineCodes(Map<String, AtomicInteger> lableAddresses);
    void setStartAddress(byte startAddress);
    byte getStartAddress();

    //returns the address for next token
    byte getEndAddress();
}
