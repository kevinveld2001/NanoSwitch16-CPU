import file.FileInput;
import tokenizer.LineTokenizer;
import tokens.LineToken;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Assembler {
    public Assembler(String inputFileName) {
        FileInput fileInput = new FileInput(inputFileName);
        String rawCode = fileInput.getRawCode();

        LineTokenizer lineTokenizer = new LineTokenizer(rawCode);
        ArrayList<LineToken> lineTokens = lineTokenizer.getLineTokens();
        setOpcodeAddresses(lineTokens);
        Map<String, AtomicInteger> lableAddresses = getLableAddresses(lineTokens);

        Byte[] machineCodes = assamble(lineTokens, lableAddresses);

        for (var machineCode : machineCodes) {
            System.out.print(String.format("0x%02X ", machineCode));
        }

    }

    private void setOpcodeAddresses(ArrayList<LineToken> lineTokens) {
        int address = 0;
        for (var lineToken: lineTokens) {
            lineToken.setStartAddress((byte) address);
            address = lineToken.getEndAddress();
        }
    }

    private Map<String, AtomicInteger> getLableAddresses(ArrayList<LineToken> lineTokens) {
        Map<String, AtomicInteger> lableAddresses = new HashMap<>();
        for (var lineToken: lineTokens) {
            if (!lineToken.getLableToken().hasLable()) continue;

            lableAddresses.put(
                    lineToken.getLableToken().getLable(),
                    new AtomicInteger((int) lineToken.getStartAddress() % 16)
            );
        }
        return lableAddresses;
    }

    private Byte[] assamble(ArrayList<LineToken> lineTokens, Map<String, AtomicInteger> lableAddresses) {
        return lineTokens.stream()
                .map(lineToken -> lineToken.getMachineCodes(lableAddresses))
                .flatMapToInt(bytes -> java.util.stream.IntStream.range(0, bytes.length).map(i -> bytes[i]))
                .mapToObj(value -> (byte) value)
                .toArray(Byte[]::new);
    }
}
