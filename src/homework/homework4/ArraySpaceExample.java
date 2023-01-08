package homework.homework4;

public class ArraySpaceExample {
    public static void main(String[] args) {
        char[] spaceArray = {' ', 'c', 'a', 't', ' ', 'b', 'i', ' ', 'b', ' ', ' '};
        int firstNonEmptyIndexFromStart = 0;
        for (int i = 0; i < spaceArray.length - 1; i++) {
            if (spaceArray[i] != ' ') {
                firstNonEmptyIndexFromStart = i;
                break;
            }
        }
        int firstNonEmptyIndexFromEnd = 0;
        for (int i = spaceArray.length-1; i > 0; i--) {
            if (spaceArray[i] != ' ') {
                firstNonEmptyIndexFromEnd = i;
                break;
            }
        }

        int newArrayLength =  firstNonEmptyIndexFromEnd- firstNonEmptyIndexFromStart + 1;

        char[] result = new char[newArrayLength];
        for (int i = firstNonEmptyIndexFromStart; i <= firstNonEmptyIndexFromEnd; i++) {
            result[i-1] = spaceArray[i];
            System.out.print(spaceArray[i]);
        }
        System.out.println();

        for (char value : result) {
            System.out.print(value);
        }

    }
}
