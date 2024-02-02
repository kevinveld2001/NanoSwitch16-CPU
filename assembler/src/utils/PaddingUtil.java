package utils;

public class PaddingUtil {
    private byte[] data;
    public PaddingUtil(byte[] data) {
        this.data = data;
    }

    public byte[] getWithPadding(int totalSize) {
        byte[] dataWithPadding = new byte[totalSize];

        for (int i = 0; i < data.length; i++) {
            dataWithPadding[i] = data[i];
        }
        return dataWithPadding;
    }
}
