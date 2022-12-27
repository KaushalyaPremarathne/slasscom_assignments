abstract public class Student {

    protected String firstName;
    protected String lastName;
    protected String subject;

    public Student(String firstName, String lastName, String subject) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.subject = subject;
    }

    abstract public float calcAverage();
}
