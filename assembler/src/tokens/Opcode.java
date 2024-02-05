package tokens;

public enum Opcode {

    NOP,
    LDA,
    STA,
    ADD,
    JMP,
    CMP,
    INP,
    OUT,
    PJP,
    RSU,
    RSL;

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
}
