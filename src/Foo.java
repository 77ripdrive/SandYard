import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Foo {
    private String[] dd = {"av", "bbb", "abbb"};

    public void noNullSort(String[] c) {
        System.out.println(Arrays.asList(dd));
        LinkedList <String> linkedList = new LinkedList <>(Arrays.asList(dd));

        linkedList.removeIf(Objects::isNull);

        List <String> stringList = new ArrayList <>(Arrays.asList(null, "A", "B", null, "C", null));
        List <String> listWithoutNulls1 = stringList.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList()); //[A,B,C]
        List <String> listWithoutNulls2 = stringList.parallelStream()
                .filter(Objects::nonNull)
                .collect(Collectors.toList()); //[A,B,C]
        stringList.removeIf(Objects::isNull); //[A,B,C]

        stringList.stream().min(String::compareTo).get();


    }

}
