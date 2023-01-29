public class MainThread extends Thread{

    public static void main(String []args){
        int days = 0;
        double perDayPayment = 0;
        double basicSal = 0;
        double finalSal = 0;

        //calculate basicSal
        basicSal = perDayPayment * days;

        Thread thread2 = new Thread(new Thread2());
        Thread thread3 = new Thread(new Thread3());

        thread3.start();
        thread2.start();

        double allowance = thread3.getAllowance();
        double EPF = thread2.getEPF();

        //calculate finalSal
        finalSal = basicSal + allowance + EPF;

        System.out.println("Basic Salary : " + basicSal);
        System.out.println("Final Salary : " + finalSal);

    }
}
