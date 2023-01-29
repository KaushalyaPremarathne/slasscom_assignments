import java.util.Scanner;

public class MainThread extends Thread{

    public static void main(String []args){
        int days = 0;
        double perDayPayment = 0;
        double basicSal = 0;
        double finalSal = 0;

        Calculations calc = new Calculations();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter count of working days : ");
        days = sc.nextInt();

        System.out.println("Enter Payment per day : ");
        perDayPayment = sc.nextDouble();

        //calculate basicSal
        basicSal = perDayPayment * days;

        Thread thread2 = new Thread(new Thread2(calc, basicSal));
        Thread thread3 = new Thread(new Thread3(calc, basicSal));

        thread2.start();
        try {
            thread2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        thread3.start();


        double allowance = calc.getAllowance();
        double EPF = calc.getEPF();

        //calculate finalSal
        finalSal = basicSal + allowance + EPF;

        System.out.println("Basic Salary : " + basicSal);
        System.out.println("Final Salary : " + finalSal);

    }
}
