public class Thread3 extends Thread{

    double allowance = 0;
    public void run(){
        public void calcAllowance(double basicSal){
            allowance = basicSal * 5 / 100;
        }
    }

    public double getAllowance(){
        return  allowance;
    }
}
