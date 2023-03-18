package homework.homework9;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CollectionExample1 {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final List<String> ARRAY_LIST = new ArrayList<>();
    private static final List<String> LINKED_LIST = new LinkedList<>();

    public static void main(String[] args) {
        //function 1 invocation
        insertByIndex();
        printList(ARRAY_LIST);

        //function 2 invocation
        if (exists()) {
            System.out.println("The name exists in the list");
        } else {
            System.out.println("The name does not exist");
        }

        //function 3 invocation
        remove();
        printList(LINKED_LIST);
    }
    //Գրեք կոդ, որ մարդը ներմուծի անուն, ու ինչ որ ինդեքս, դուք էդ ինդեքսի տակ տանեք էդ անունը դնեք.
    private static void insertByIndex() {
        //for Test
//        ARRAY_LIST.add("Hasmik");
//        ARRAY_LIST.add(1, "bdchd");
        try {
            System.out.println("Please, input index and element");
            String indexAndNameStr = SCANNER.nextLine();
            String[] indexAndName = indexAndNameStr.split(",");
            ARRAY_LIST.add(Integer.parseInt(indexAndName[0]), indexAndName[1]);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("The index is out of bounds");
        }
    }

    //Գրեք կոդ, որը սքաններով կվերցնի անուն, ու կստուգի եթե ցանկի մեջ կա, կասի որ անունը կար, եթե չկա կասի որ չկա
    private static boolean exists() {
        System.out.println("Please, input any name");
        String name = SCANNER.nextLine();
        return ARRAY_LIST.contains(name);
    }

    /*Գրեք կոդ, որտեղ մարդը կներմուծի ինչ որ անուն, եթե էդ անունը կա ցանկի մեջ,
           կջնջեք էդ անունը, ու կտպեք ցանկը ու կտեսնեք որ էդ անունը ջնջվել է.
           */
    private static void remove() {
        //For test
        LINKED_LIST.add("foo");
        LINKED_LIST.add("bar");
        System.out.println("Please, input a name to be deleted.");
        String nameToRemove = SCANNER.nextLine();
        LINKED_LIST.remove(nameToRemove);
    }

    private static void printList(@NotNull List<?> list) {
        for (Object o : list) {
            System.out.println(o);

        }
    }


}