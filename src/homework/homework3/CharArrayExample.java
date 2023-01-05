package homework.homework3;

public class CharArrayExample {

    public static void main(String[] args) {

        char[] chars = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e'};
        char expectedValue = 'o';
        int charAmount = 0;
        for (char value : chars) {
            if (value == expectedValue) {
                charAmount++;
            }
        }
        System.out.println("The symbol 'o' appears in the array " + charAmount + " time(s)");

        char[] chars2 = {'j', 'a', 'v', 'a', 'l', 'o', 'v', 'e'};
        int midElementIndex = chars2.length / 2;
        char midItem1 = chars2[midElementIndex];
        char midItem2 = chars2[midElementIndex - 1];
        System.out.println("The two middle items in the array are " + " ' " + midItem2 + " ' " + "and " + " ' " + midItem1 + " ' ");


        char[] chars3 = {'j', 'a', 'v', 'a', 'l', 'o', 'l', 'y'};
        char lastItem = chars3[chars3.length - 1];
        char secondToLastItem = chars3[chars3.length - 2];
        boolean expectedResult = secondToLastItem == 'l' && lastItem == 'y';
        System.out.println(expectedResult);


        char[] text = {' ', ' ', 'b', 'a', 'r', 'e', 'v', ' ', ' '};
        for (char value : text) {
            if (value != ' ') {
                System.out.print(value + "  ");
            }
        }


    }
}