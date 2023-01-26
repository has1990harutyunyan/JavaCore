package homework.homework7;

public class BraceChecker {
    private String text;

    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {
        Stack openingBrackets = new Stack();
        for (int i = 0; i < text.length(); i++) {
            switch (text.charAt(i)) {
                case '(':
                case '{':
                case '[':
                    openingBrackets.push(text.charAt(i));
                    break;
            }
        }
        Stack closingBrackets = new Stack();
        for (int i = text.length() - 1; i >= 0; i--) {
            switch (text.charAt(i)) {
                case ')':
                case '}':
                case ']':
                    closingBrackets.push(text.charAt(i));
                    break;
            }
        }
        int size = openingBrackets.getSize();
        for (int i = 0; i <= size; i++) {
            String message = "Brackets match ";
            char openingBrace = openingBrackets.pop();
            char closingBrace = closingBrackets.pop();
            if (openingBrace == '(' && closingBrace == ')') {
                System.out.println(message + "opened " + openingBrace + " closed " + closingBrace);
            } else if (openingBrace == '{' && closingBrace == '}') {
                System.out.println(message + "opened " + openingBrace + " closed " + closingBrace);
            } else if (openingBrace == '[' && closingBrace == ']') {
                System.out.println(message + "opened " + openingBrace + " closed " + closingBrace);
            } else {
                System.err.println("Error : Opened " + openingBrace + " but closed " + closingBrace);
            }


        }
    }
}