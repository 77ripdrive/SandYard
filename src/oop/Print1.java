package oop;

public class Print1 {

    public <T> void print(T[] items){
        for(T item: items){
            System.out.println(item);
        }
    }

}
