package tokens;

public enum Opcode {

    NOP (1),
    LDA (1),
    STA (2),
    ADD (1),
    JMP (1),
    CMP (1),
    INP (1),
    OUT (1),
    PJP (1),
    RSU (1),
    RSL (1);
    private byte opcodeLenght;

    Opcode (int lenght) {
        opcodeLenght = (byte) lenght;
    }

    public static Opcode fromString (String opcode) {
        if (opcode == null) throw new IllegalArgumentException("No opcode found");
        opcode = opcode.toUpperCase();
        for (Opcode enumOpcode : Opcode.values()) {
            if (enumOpcode.name().equals(opcode)) return enumOpcode;
        }
        throw new IllegalArgumentException("'" + opcode + "' is not a valide opcode");
    }

    public byte toMachineCode() {
        return (byte) (this.ordinal() << 4);
    }

    public byte getOpcodeLenght() {
        return opcodeLenght;
    }
}
