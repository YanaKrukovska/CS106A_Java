package ua.edu.ukma.ykrukovska.unit10;

public class ContractStudent extends Student {


    private int coursePrice;
    private String paymentDeadline;

    public ContractStudent(String name, String surname, int coursePrice, String paymentDeadline) {
        super(name, surname);
        this.coursePrice = coursePrice;
        this.paymentDeadline = paymentDeadline;
    }

    public int getCoursePrice() {
        return coursePrice;
    }

    public String getPaymentDeadline() {
        return paymentDeadline;
    }

    public void setCoursePrice(int coursePrice) {
        this.coursePrice = coursePrice;
    }

    public void setPaymentDeadline(String paymentDeadline) {
        this.paymentDeadline = paymentDeadline;
    }


    @Override
    public String toString() {
        return super.toString() +
                " Payment information: " +
                ", course price = " + coursePrice +
                ", Payment deadline: " + paymentDeadline ;
    }
}


