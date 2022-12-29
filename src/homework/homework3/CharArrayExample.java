package homework.homework3;

public class CharArrayExample {

    public static void main(String[] args) {

        char[] chars = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e'};

        char c = 'o';
        int charAmount = 0;
        for (char value : chars) {
            if (value == c) {
                charAmount++;
            }
        }
        System.out.println("The symbol 'o' appears in the array " + charAmount + " time(s)");

        char[] chars2 = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e'};
        if (chars2.length > 0 && chars2.length % 2 == 0) {
            int midElement = chars2.length / 2;
            char midItem1 = chars2[midElement];
            char midItem2 = chars2[midElement - 1];
            System.out.println("The two middle items in the array are " + " ' " + midItem2 + " ' " + "and " + " ' " + midItem1 + " ' ");

        }

        char[] chars3 = {'j', 'a', 'v', 'a', 'l', 'o', 'l', 'y'};
        char lastItem = chars3[chars.length - 1];
        char secondToLastItem = chars3[chars.length - 2];
        String ly = secondToLastItem + "" + lastItem;
        if (ly.equals("ly")) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

        char[] text = {' ', ' ', 'b', 'a', 'r', 'e', 'v', ' ', ' '};
        for (char value : text) {
            if (value != ' ') {
                System.out.print(value + "  ");
            }
        }


    }
}