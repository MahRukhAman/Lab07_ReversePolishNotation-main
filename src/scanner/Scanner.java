package scanner;

import java.util.ArrayList;
import java.util.List;

public class Scanner {

    String input;
    List<String> tokens;

    public Scanner(String input) {
        this.input = input;
        this.tokens = new ArrayList<>();
        tokenize();
    }

    // Tokenize the input string
    private void tokenize() {
        StringBuilder numberBuffer = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                numberBuffer.append(c);
            } else {
                if (numberBuffer.length() > 0) {
                    tokens.add(numberBuffer.toString());
                    numberBuffer.setLength(0);
                }
                if (!Character.isWhitespace(c)) {
                    tokens.add(Character.toString(c));
                }
            }
        }
        if (numberBuffer.length() > 0) {
            tokens.add(numberBuffer.toString());
        }
    }

    // Return tokens as an array of strings
    public String[] getToken() {
        return tokens.toArray(new String[0]);
    }
}