public class Thread3 extends Thread{

    private Calculations calc;
    private double basicSal;

    public Thread3(Calculations calc, double basicSal) {
        this.calc = calc;
        this.basicSal = basicSal;
    }

    public void run(){
        calc.calcAllowance(basicSal);
    }


}
