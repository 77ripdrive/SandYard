import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.stream.Collectors;

public class StringExample
{
    private static void noNullSort() {

        List <String> stringList = new ArrayList <>(Arrays.asList(null, "A", "B", null, "C", null));
        List <String> listWithoutNulls1 = stringList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList()); //[A,B,C]
        List <String> listWithoutNulls2 = stringList.parallelStream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList()); //[A,B,C]
        stringList.removeIf(Objects::isNull); //[A,B,C]

        System.out.println(stringList.stream().min(String::compareTo).get());

    }


    private static void stringWithFiles() throws IOException {
        {
            List<String> stringList = Files
                    .lines(Paths.get("file.txt"))
                    .map(s -> s.replaceAll("A-76", "D-98"))
                    .collect(Collectors.toList());
            Files.write(Paths.get("demo.txt"), stringList, StandardOpenOption.CREATE);

        }
    }

    public static void main(String[] args)
    {

        String isbn = "7 000p.  5 000  3 000  2 00  8 000";
        String[] isbnParts = isbn.split("  ");

        List<String> stringList= Arrays.asList(isbnParts);
        String sss= stringList.stream().min(String::compareTo).get();
        System.out.println("Min "+sss);

        TreeSet <String> st = new TreeSet<String>(Arrays.asList(isbnParts));
        System.out.println("first"+ st.first());
        st.forEach(s -> System.out.println(s));

        System.out.println(st.first());

        Date date=new Date();
        System.out.println(date);

    }
}

