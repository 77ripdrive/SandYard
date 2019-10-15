import java.util.*;

public class SetsMaps {

    public void addElement() {
        HashSet <PersonFirst> people = new HashSet <PersonFirst>();

        people.add(new PersonFirst(1, "Mike"));
        people.add(new PersonFirst(1, "Tom"));
        people.add(new PersonFirst(1, "Nick"));
        people.add(new PersonFirst(1, "AAron"));
        for (PersonFirst p : people) {

            System.out.println(p.getName());
        }

        TreeSet <PersonFirst> personFirstTreeSet = new TreeSet <>(people);

        for (PersonFirst p : personFirstTreeSet) {
            System.out.println(p.getName());
        }

    }
    class PersonFirst implements Comparable<PersonFirst> {

        private String name;

        PersonFirst(int i, String name){

            this.name = name;
        }
        String getName(){return name;}

        public int compareTo(PersonFirst p){

            return name.compareTo(p.getName());
        }
    }
}
