import java.util.Set;
import java.util.TreeSet;

public class Collections {

    public static void main(String[] args) {
        Set<Enum> enums  = new TreeSet<>();
        enums.add(CollectionEnum.HASMIK);
        enums.add(CollectionEnum.ARAKELYAN);
        enums.add(CollectionEnum.MANE);

        for (Enum anEnum : enums) {
            System.out.println(anEnum);
        }

    }

}
