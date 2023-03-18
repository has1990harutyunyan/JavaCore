package homework.fileUtil;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileUtil {

    static Scanner SCANNER = new Scanner(System.in);


    public static void main(String[] args) {
         System.out.println(fileExists());
         System.out.println(getKeywordContainingFileList());
         System.out.println(getSizeOfPackage());
         createFileWithContent();

    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - fileName - ֆայլի անունը, որը փնտրում ենք։
    //Որպես արդյունք պտի ծրագիրը տպի true եթե կա էդ ֆայլը էդ պապկի մեջ, false եթե չկա։
    static boolean fileExists() {
        System.out.println("Please, input folder path");
        String directory = SCANNER.nextLine();
        System.out.println("Please, input file name");
        String fileName = SCANNER.nextLine();
        File file = new File(directory);
        String[] files = file.list();
        for (String name : Objects.requireNonNull(files)) {
            int i = name.lastIndexOf(".");
            String fileNameNoExtension = name.substring(0, i);
            if (fileNameNoExtension.equalsIgnoreCase(fileName)) {
                return true;
            }
        }
        return false;
    }

    //այս մեթոդը պետք է սքաններով վերցնի երկու string.
    // 1 - path թե որ ֆոլդերում ենք փնտրելու
    // 2 - keyword - ինչ որ բառ
    // Մեթոդը պետք է նշված path-ում գտնի բոլոր .txt ֆայլերը, և իրենց մեջ փնտրի
    // մեր տված keyword-ը, եթե գտնի, պետք է տպի տվյալ ֆայլի անունը։
    @NotNull
    static List<String> getKeywordContainingFileList() {
        List<String> keywordContainingFileList = new ArrayList<>();
        System.out.println("Please, input folder path");
        String directory = SCANNER.nextLine();
        System.out.println("Please, input keyword");
        String keyWord = SCANNER.nextLine();
        File file = new File(directory);
        String[] list = file.list((dir, name) -> name.toLowerCase().endsWith(".txt"));
        assert list != null;
        for (String s : list) {
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(directory + "\\" + s))) {
                if (bufferedReader.readLine().contains(keyWord)) {
                    keywordContainingFileList.add(s);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return keywordContainingFileList;

    }

    //այս մեթոդը պետք է սքաններով վերցնի մեկ string.
    // 1 - path թե որ ֆոլդերի չափն ենք ուզում հաշվել
    // ֆոլդերի բոլոր ֆայլերի չափսերը գումարում ենք իրար, ու տպում
    static long getSizeOfPackage() {
        long size = 0;
        System.out.println("Please, input folder path");
        String directory = SCANNER.nextLine();
        File file = new File(directory);
        if (file.exists()) {
            for (File listFile : Objects.requireNonNull(file.listFiles())) {
                size += listFile.length();
            }
        }
        return size;
    }


    //այս մեթոդը պետք է սքաններով վերցնի երեք string.
    // 1 - path պապկի տեղը, թե որտեղ է սարքելու նոր ֆայլը
    // 2 - fileName ֆայլի անունը, թե ինչ անունով ֆայլ է սարքելու
    // 3 - content ֆայլի պարունակությունը։ Այսինքն ստեղծված ֆայլի մեջ ինչ է գրելու
    // որպես արդյունք պապկի մեջ սարքելու է նոր ֆայլ, իրա մեջ էլ լինելու է content-ով տվածը
    static void createFileWithContent() {
        System.out.println("Please, input folder path, file name and content");
        String path = SCANNER.nextLine();
        String[] pathInfo = path.split(",");
        try {
            File file = new File(pathInfo[0] + "\\" + pathInfo[1]);
            boolean newFile = file.createNewFile();
            if (newFile) {
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(pathInfo[0] + "\\" + pathInfo[1]));
                bufferedWriter.write(pathInfo[2]);
                bufferedWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

