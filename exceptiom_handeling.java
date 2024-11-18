
/*
Definition :-
-It is a mechanism in java to handle ensring the normal flow of program its basic usees is to stock program termination unexpectedly
enabling developer to take necessary action for programs stability.

Exception Definition:-
-Exception is an event that occur during the execution of a program which desruupt the normal flow of program.

Type of Exception :-
  1.Checked Exception:- Exception which are checked at compiled time like IOException, SQLException.
  2.Unchecked Exception:- Runtime exception that are not checked at complied time these are known as unchecked exception
    e.g- ArithmeticException, NullPointerException


*/



public class exceptiom_handeling {
    public static void main(String[] args) {
        try {
            int num = 100 / 0;  // This will throw ArithmeticException
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } finally {
            System.out.println("This block is always executed.");
        }
    
}
