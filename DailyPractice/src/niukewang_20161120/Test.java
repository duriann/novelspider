package niukewang_20161120;

class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {
    	super(id);
        empID = id;
    }
}
public class Test {
    public static void main(String args[]) {
      /*  Employee e = new Employee("123");
        System.out.println(e.empID);
        */
    	System.out.println(String.format("%s","a"));
    }
}
