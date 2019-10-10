public class PersonFirst implements Comparable<PersonFirst> {

    private String name;
    
    PersonFirst(int i, String name){

        this.name = name;
    }
    String getName(){return name;}

    public int compareTo(PersonFirst p){

        return name.compareTo(p.getName());
    }
}
