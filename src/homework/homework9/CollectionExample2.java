package homework.homework9;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class CollectionExample2 {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Set<String> LINKED_HASHSET = new LinkedHashSet<>();
    private static final Set<String> TREE_SET = new TreeSet<>();

    public static void main(String[] args) {
        //function 1 invocation
        addElementsIntoLinkedHashSet();
        printSet(LINKED_HASHSET);

        //function 2 invocation
        addElementsIntoTreeSet();
        printSet(TREE_SET);
    }

    //սքաններով մարդուց կվերցնեք 5 անուն,
    // որը կպահեք քլլեքշններից որևե մեկի մեջ, հետո կտպեք, բայց տպելուց այնպես պտի տպեք, որ կրկնություն չլինի անունների.
    private static void addElementsIntoLinkedHashSet() {
        System.out.println("Please, input 5 element names");
        String elementsStr = SCANNER.nextLine();
        String[] elementsArray = elementsStr.split(",");
        LINKED_HASHSET.addAll(List.of(elementsArray));
    }

    // Ներմուծեք 10 անուն, որից հետո կտպեք սորտավորած անունների ցանկը.
    private static void addElementsIntoTreeSet() {
        System.out.println("Please input names");
        String elementsStr = SCANNER.nextLine();
        String[] elementsArray = elementsStr.split(",");
        TREE_SET.addAll(List.of(elementsArray));
    }


    private static void printSet(@NotNull Set<?> set) {
        for (Object o : set) {
            System.out.println(o);
        }
    }


}
