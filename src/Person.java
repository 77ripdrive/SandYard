import java.util.Objects;

public class Person
{

    private int id;
    private String name;
    static int counter=1;

    public Person(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(id);
    }

    @Override
    public String toString()
    {
        return "Person{" + "id=" + id + '}';
    }

    Person(){
        id = counter++;
    }

    public int getId()
    {
        return id;
    }

    public void displayId(){

        System.out.printf("Id: %d \n", id);

    }

    public String getName()
    {
        return name;
    }
}
