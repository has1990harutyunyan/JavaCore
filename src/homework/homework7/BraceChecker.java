package homework.homework7;

public class BraceChecker {
    private String text;

    public BraceChecker(String text) {
        this.text = text;
    }

    public void check() {

        String message = "Brackets match ";
        Stack openingBrackets = new Stack();
        for (int i = 0; i < text.length(); i++) {
            char pop;
            char bracket = text.charAt(i);
            switch (bracket) {
                case '(':
                case '{':
                case '[':
                    openingBrackets.push(bracket);
                    break;
                case ')':
                    pop = openingBrackets.pop();
                    if (pop == '[' || pop == '{') {
                        System.err.println("Error : Opened " + pop + " but closed " + bracket + "at index " + i);
                    } else if (pop == 0) {
                        System.out.println("Closed but not opened");
                    } else {
                        System.out.println(message);
                    }
                    break;
                case '}':
                    pop = openingBrackets.pop();
                    if (pop == '[' || pop == '(') {
                        System.err.println("Error : Opened " + pop + " but closed " + bracket + "at index " + i);
                    } else if (pop == 0) {
                        System.out.println("Closed but not opened");
                    } else {
                        System.out.println(message);
                    }
                    break;
                case ']':
                    pop = openingBrackets.pop();
                    if (pop == '(' || pop == '{') {
                        System.err.println("Error : Opened " + pop + " but closed " + bracket + "at index " + i);
                    } else if (pop == 0) {
                        System.out.println("Closed but not opened");
                    } else {
                        System.out.println(message);
                    }
                    break;

            }
        }

        while (openingBrackets.getSize() >= 0) {
            System.out.println(openingBrackets.pop() + " opened but not closed");
        }
    }

}
