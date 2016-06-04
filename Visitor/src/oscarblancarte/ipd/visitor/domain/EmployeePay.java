package oscarblancarte.ipd.visitor.domain;

public class EmployeePay {

    public String employeeName;
    public double totalPay;

    public EmployeePay(String employeeName, double totalPay) {
        this.employeeName = employeeName;
        this.totalPay = totalPay;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public void setTotalPay(double totalPay) {
        this.totalPay = totalPay;
    }

    
}
