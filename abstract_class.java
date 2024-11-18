/*
Definition :-
An abstract class is a class that can not be initialized and used to provide 
a comman definition of a base class which can be shared by multiple deriuved class.

-Abstract class can contain both type of method(abstract menthod and concrete method).

-Abstract calss is primerly used as blueprint for other class to follow.


Key features of abstract class:-
  1.Object of the abstrat class cannot be iniatilized(It must be inherited by another class).
  2.Although abstract class cannot be initilized still they have consturctors that can be called whenever any object of sub-class is created.
 */


//Example

abstract class RAushan{
    abstract void sound();
    void fun1() {
        System.out.println("RAushan's code executed successfully.");
    }
}
class Parker extends RAushan {
    
    void fun2() {
        System.out.println("The Parker is good.");
    }

    @Override
    void sound() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
public class Main {
    public static void main(String[] args) {
        Parker parker = new Parker();
        parker.fun2(); 
        parker.fun1();
    }
}