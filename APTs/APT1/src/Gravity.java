public class Gravity {
    public double falling(double time, double velocity){
        return velocity*time+0.5*9.8*time*time;
    }
}