package tokens;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class OpcodeToken implements Token {
    Opcode opcode;
    String param;
    byte machineCodeLength = 1;
    byte machineCodeAddress = 0;

    public OpcodeToken(StringBuilder rawCode) {
        String[] splitOpcodes = rawCode.toString().split(" ", 2);
        opcode = Opcode.fromString(splitOpcodes[0]);
        machineCodeLength = opcode.getOpcodeLenght();

        if (splitOpcodes.length > 1) {
            param = splitOpcodes[1];
        }
    }

    @Override
    public byte[] getMachineCodes(Map<String, AtomicInteger> lableAddresses) {
        byte[] machineCodes = new byte[opcode.getOpcodeLenght()];
        byte param = getParam(this.param, lableAddresses);
        machineCodes[0] = (byte) (opcode.toMachineCode() + param);

        //STA is edge case. It adds
        if (opcode == Opcode.STA) {
            machineCodes[1] = Opcode.NOP.toMachineCode();
        }
        return machineCodes;
    }

    private byte getParam(String param, Map<String, AtomicInteger> lableAddresses) {
        try {
            return Byte.parseByte(param);
        } catch (Exception e) {
            if (!lableAddresses.containsKey(param)) throw new IllegalArgumentException("'" + param + "' is not a valid param");

            return lableAddresses.get(param).byteValue();
        }
    }

    @Override
    public void setStartAddress(byte startAddress) {
        machineCodeAddress = startAddress;
    }

    @Override
    public byte getStartAddress() {
        return machineCodeAddress;
    }

    @Override
    public byte getEndAddress() {
        return (byte) (machineCodeAddress + machineCodeLength);
    }
}
