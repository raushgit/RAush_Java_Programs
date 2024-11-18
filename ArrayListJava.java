/*

Array List in Java :-
he array list class in java is a part of collection framework and find in java.util package 
It provide a dynamic array which can grow and shrink
unlike traditional array.

*/


import java.util.ArrayList;
public class ArrayListJava {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        
        list.add("papaya");
        list.add("apple");
        list.add("banana");
        list.add("guava");

        System.out.println(list);
        System.out.println("First item: " + list.get(0));
    }
}