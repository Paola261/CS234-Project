/**
 *
 * @author Taryn Davis
 */
public abstract class Person {
    protected String name;
    protected int age;
    protected int personID;
    
    public Person(String name, int age, int personID) {
        this.name = name;
        this.age = age;
        this.personID = personID;
    }
    
    public String getName() { return name; }
    public int getAge() { return age; }
    public int getPersonID() { return personID; }
    
    public void setName(String name) { this.name = name; }
    public void setAge(int age) { this.age = age; }
}

