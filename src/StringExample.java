import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringExample
{
    // Concatenates to String
    public static void concat1(String s1)
    {
        s1 = s1 + "forgeeks";
    }

    // Concatenates to StringBuilder
    public static void concat2(StringBuilder s2)
    {
        s2.append("forgeeks");
    }

    // Concatenates to StringBuffer
    public static void concat3(StringBuffer s3)
    {
        s3.append("forgeeks");
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
        String s1 = "Geeks";
        concat1(s1);  // s1 is not changed
        System.out.println("String: " + s1);

        StringBuilder s2 = new StringBuilder("Geeks");
        concat2(s2);
        s2.reverse();// s2 is changed
        System.out.println("StringBuilder: " + s2);

        StringBuffer s3 = new StringBuffer("Geeks");
        concat3(s3); // s3 is changed
        System.out.println("StringBuffer: " + s3);

        StringBuffer sbr = new StringBuffer("Geeks");
        StringBuilder sbdr = new StringBuilder("Hello");

        // conversion from StringBuffer object to String
        String str = sbr.toString();
        System.out.println("StringBuffer object to String : ");
        System.out.println(str);

        // conversion from StringBuilder object to String
        String str1 = sbdr.toString();
        System.out.println("StringBuilder object to String : ");
        System.out.println(str1);

        // changing StringBuffer object sbr
        // but String object(str) doesn't change
        sbr.append("ForGeeks");
        System.out.println(sbr);
        System.out.println(str);
        try
        {
            Stream<String> streamFromFiles = Files.lines(Paths.get("file.txt"));
            List<String> stringList=streamFromFiles.map(s->s.replaceAll("A-76","D-98")).collect(
                    Collectors.toList());
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

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

