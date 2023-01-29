public class Calculations {

    private double EPF = 0;
    private double allowance = 0;

    //calculate EPF
    public void calcEPF(double monthlyEarning){
        EPF = monthlyEarning * 8 / 100;
    }

    public double getEPF(){
        return EPF;
    }

    //calculate Allaowance
    public void calcAllowance(double basicSal){
        allowance = basicSal * 5 / 100;
    }

    public double getAllowance(){
        return  allowance;
    }
}
