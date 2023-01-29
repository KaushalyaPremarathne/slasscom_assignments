public class Thread2 extends Thread{

    private Calculations calc;
    private double monthlyEarning;

    public Thread2(Calculations calc, double monthlyEarning) {
        this.calc = calc;
        this.monthlyEarning = monthlyEarning;
    }

    public void run(){
        calc.calcEPF(monthlyEarning);
    }


}
