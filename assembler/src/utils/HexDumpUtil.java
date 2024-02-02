package utils;

public class HexDumpUtil {
    private byte[] data;
    public HexDumpUtil(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        StringBuilder hexdump = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            hexdump.append(String.format("0x%02X ", data[i]));

            if ((i + 1) % 16 == 0) {
                hexdump.append("\n");
            }
        }

        return hexdump.toString();
    }
}
