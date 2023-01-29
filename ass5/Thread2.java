public class Thread2 extends Thread{

    double EPF = 0;
    public void run(){
        //calculate EPF
        public void calcEPF(double monthlyEarning){
             EPF = monthlyEarning * 8 / 100;
        }
    }

    public double getEPF(){
        return EPF;
    }
}
