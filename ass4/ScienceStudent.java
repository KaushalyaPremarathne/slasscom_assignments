public class ScienceStudent extends Student{

    private int attendance;
    private float project;
    private float midTerm;
    private float finalExam;

    public ScienceStudent(String firstName, String lastName, String subject, int attendance, float project, float midTerm, float finalExam) {
        super(firstName, lastName, subject);
        this.attendance = attendance;
        this.project = project;
        this.midTerm = midTerm;
        this.finalExam = finalExam;
    }

    public ScienceStudent(String firstName, String lastName, String subject) {
        super(firstName, lastName, subject);
    }


    @Override
    public float calcAverage() {
        return 0;
    }
}
