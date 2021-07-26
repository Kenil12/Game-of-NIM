public interface Payable {

    double getPaymentAmount(); // calculate payment

}

class Employee implements Payable{
    private int hoursOfwork;
    private double wage;
    private double bonus;

    @Override
    public double getPaymentAmount() {
        return hoursOfwork*wage + bonus;
    }
}