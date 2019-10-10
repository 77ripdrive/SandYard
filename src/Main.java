import oop.NestedStaticClass;
import oop.Print1;
import oop.Reader;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    static String s, s1, s2, s3;
    static double res;
    static float aFloat;

    public static void simpleReplace() {
        s = "175,679.05";
        //  int ss=Integer.parseInt(s.replace(",",""));
        res = Double.parseDouble(s.replace(",", ""));
        aFloat = Float.parseFloat(s.replace(",", ""));
        //    System.out.println();
        System.out.println(res + "");
        System.out.println(aFloat + "");
    }

    public static void sortWithFilter() {
        ArrayList <String> cities = new ArrayList <String>();
        Collections.addAll(cities, "Париж", "Лондон", "Мадрид","Локи:)");
        cities.stream().filter(s -> s.contains("Лон")).

                forEach(s -> System.out.println(s));
    }

    public static void outputWithFields() {
        Stream <Phone> phoneStream = Stream.of(new Phone("iPhone 6 S", 14000), new Phone("Lumia 950", 45000),
                new Phone("Samsung Galaxy S 8", 40000));

        phoneStream
                .flatMap(p -> Stream.of(
                        String.format("название: %s  цена без скидки: %d", p.getName(), p.getPrice()),
                        String.format("название: %s  цена со скидкой: %d", p.getName(), p.getPrice() - (int) ( p.getPrice() * 0.1 ))
                ))
                .collect(Collectors.toSet()).forEach(s -> System.out.println(s));
    }

    public static int fact(int i){
        if (i<0){return  -1;    }
        if (i==0){return 1;}
        return i*fact(i-1);}

    public static String recString(String s){
        String string="";
        for (int i=s.length()-1 ;i>=0;i--){
            string+=s.charAt(i);
        }return string;
    }

    public static void main(String[] args) {

        simpleReplace();
        sortWithFilter();
        outputWithFields();
        NestedStaticClass.Factorial factorial = NestedStaticClass.getFactorial(7);
        System.out.printf("Факториал числа %d равен %d \n", factorial.getKey(), factorial.getResult());
        Reader.read();

        Print1 printer=new Print1();
        String[] people = {"Tom", "Alice", "Sam", "Kate", "Bob", "Helen"};
        Integer[] numbers = {23, 4, 5, 2, 13, 456, 4};
        printer.<String>print(people);
        printer.<Integer>print(numbers);
        List <String> listName= Arrays.asList(people);
        List <Integer> listInt= Arrays.asList(numbers);
       // Collections.sort(listInt);
        boolean bb=listName.contains("Alice");
        System.out.println(bb);
        TreeSet<String> treeSet=new TreeSet <>(listName);
        TreeSet<Integer> treeSet1=new TreeSet <>(listInt);
        treeSet.forEach(s-> System.out.println(s));
        System.out.println(treeSet1);
        SetsMaps setsMaps=new SetsMaps();
        setsMaps.addElement();
      }

}
