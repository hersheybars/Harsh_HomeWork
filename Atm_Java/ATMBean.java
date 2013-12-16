/*
 * 
 * Start of ATMBean
 */

public class ATMBean {

    private String pincode;
    private String Name;
    private String Address;
    private int Age;
    private double AccountBalance;
    private double NewBalance;
    private double WithdrawBalance;
// private double WB;
//return value of variables declared above! accessor method -get... & mutator method -set..
//pin code
    public String getpc() {
        return pincode;
    }

    public void setpc(String pc) {
        pincode = pc;
    }
//name
    public String getName() {
        return Name;
    }

    public void setName(String studName) {
        Name = studName;
    }
//address
    public String getAddress() {
        return Address;
    }

    public void setAddress(String studAdd) {
        Address = studAdd;
    }
//age
    public int getAge() {
        return Age;
    }

    public void setAge(int studAge) {
        Age = studAge;
    }
//AccountBalance
    public double getBalance() {
        return AccountBalance;
    }

    public void setBalance(double Balance) {
        AccountBalance = Balance;
    }
//NewBalance
    public double getNB() {
        return NewBalance;
    }

    public void setNB(double NB) {
        NewBalance = NB;
    }
//Withdraw
    public double getWB() {
        return WithdrawBalance;
    }

    public void setWB(double WB) {
        WithdrawBalance = WB;
    }
}
