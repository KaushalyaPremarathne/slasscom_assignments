public class EnglishStudent extends Student{

    private float termPaper;
    private float midTerm;
    private float finalExam;

    public EnglishStudent(String firstName, String lastName, String subject, float termPaper, float midTerm, float finalExam) {
        super(firstName, lastName, subject);
        this.termPaper = termPaper;
        this.midTerm = midTerm;
        this.finalExam = finalExam;
    }

    public EnglishStudent(String firstName, String lastName, String subject) {
        super(firstName, lastName, subject);
    }

    @Override
    public float calcAverage() {
        return 0;
    }
}
