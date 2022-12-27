public class MathsStudent extends Student{

    private float quizAvg;
    private float test1;
    private float test2;
    private float finalExam;

    public MathsStudent(String firstName, String lastName, String subject, float quizAvg, float test1, float test2, float finalExam) {
        super(firstName, lastName, subject);
        this.quizAvg = quizAvg;
        this.test1 = test1;
        this.test2 = test2;
        this.finalExam = finalExam;
    }

    public MathsStudent(String firstName, String lastName, String subject) {
        super(firstName, lastName, subject);
    }

    @Override
    public float calcAverage() {
        return 0;
    }
}
