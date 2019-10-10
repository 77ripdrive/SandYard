import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectionsExample {
    public static void main(String[] args) {

        ArrayList <String> people = new ArrayList <String>();
        // добавим в список ряд элементов
        people.add("Tom");
        people.add("Alice");
        people.add("Kate");
        people.add("Sam");
        people.add(1, "Bob"); // добавляем элемент по индексу 1

        System.out.println(people.get(1));// получаем 2-й объект
        people.set(1, "Robert"); // установка нового значения для 2-го объекта

        System.out.printf("ArrayList has %d elements \n", people.size());
        for (String person : people) {

            System.out.println(person);
        }
        // проверяем наличие элемента
        if (people.contains("Tom")) {

            System.out.println("ArrayList contains Tom");
        }

        // удалим несколько объектов
        // удаление конкретного элемента
        people.remove("Robert");
        // удаление по индексу
        people.remove(0);

        Object[] peopleArray = people.toArray();
        for (Object person : peopleArray) {

            System.out.println(person);
        }

        HashSet <String> states = new HashSet <String>();

        // добавим в список ряд элементов
        states.add("Germany");
        states.add("France");
        states.add("Italy");
        // пытаемся добавить элемент, который уже есть в коллекции
        boolean isAdded = states.add("Germany");
        System.out.println(isAdded);    // false

        System.out.printf("Set contains %d elements \n", states.size());    // 3

        for (String state : states) {

            System.out.println(state);
        }
        // удаление элемента
        states.remove("Germany");

        // хеш-таблица объектов PersonFirst
        HashSet <PersonFirst> peopl = new HashSet <PersonFirst>();
        peopl.add(new PersonFirst(1, "Mike"));
        peopl.add(new PersonFirst(2, "Tom"));
        peopl.add(new PersonFirst(3, "Nick"));
        for (PersonFirst p : peopl) {

            System.out.println(p.getName());
        }

        TreeSet <String> st = new TreeSet <String>();

        // добавим в список ряд элементов
        st.add("Germany");
        st.add("Yrance");
        st.add("Italy");
        st.add("Great Britain");

        System.out.printf("TreeSet contains %d elements \n", st.size());

        // удаление элемента
        st.remove("Germany");
        for (String state : st) {

            System.out.println(state);
        }
    }

    public void mapSort() {
//        Количество повторяющихся элементов -> 3 варианта решения
//1
        Map <Integer, Integer> map = new HashMap <>();
        List <Integer> list = Arrays.asList(4, 4, 4, 2, 3, 1, 1, 4, 0, 0);
        List <Integer> list1 = list.stream().filter(s -> s != 0).collect(Collectors.toList());
        list1.forEach(s -> System.out
                .println("not null" + s));
        list.forEach(element -> {
            map.put(element, map.getOrDefault(element, 0) + 1);
        });
        System.out.println(map);
//2
        Map <Integer, Integer> map1 = new HashMap <>();
        int num[] = {1, 3, 2, 4, 1, 2, 4, 6, 7, 5};

        for (int i = 0; i < num.length; i++) {
            if (map1.containsKey(num[i])) {
                map1.put(num[i], map1.get(num[i]) + 1);
            } else {
                map1.put(num[i], 1);
            }
        }
//3
        List <Integer> listInteger = Arrays.asList(1, 3, 5, 6, 3, 1, 1, 6);
        Map <Integer, Long> map2 = listInteger.stream().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()
                )
        );
        System.out.println("Map1" + map1);
        System.out.println("Map2" + map2);
    }
}

