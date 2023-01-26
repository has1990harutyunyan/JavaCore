package homework.homework7;

public class BraceCheckerCopy {
    private String text;

    public BraceCheckerCopy(String text) {
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
        String message = "Brackets match ";
        for (int i = text.length()-1; i>=0; i--) {
            char closingBrace = text.charAt(i);
            switch (closingBrace) {
                case ')':
                case '}':
                case ']':
                    char openingBrace = openingBrackets.pop();
                    if (openingBrace == '(' && closingBrace == ')') {
                        System.out.println(message + "opened " + openingBrace + " closed " + closingBrace);
                    } else if (openingBrace == '{' && closingBrace == '}') {
                        System.out.println(message + "opened " + openingBrace + " closed " + closingBrace);
                    } else if (openingBrace == '[' && closingBrace == ']') {
                        System.out.println(message + "opened " + openingBrace + " closed " + closingBrace);
                    } else {
                        System.err.println("Error : Opened " + openingBrace + " but closed " + closingBrace + "at index " + i);
                    }
                    break;

            }
        }


    }
}