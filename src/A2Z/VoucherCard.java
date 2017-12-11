package A2Z;

import java.util.Date;

public class VoucherCard {
    private double value;
    private Date expiryDate;
    private String voucherID;

    public VoucherCard(){

    }

    public VoucherCard(double value, Date expiryDate, String voucherID) {
        this.value = value;
        this.expiryDate = expiryDate;
        this.voucherID = voucherID;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getVoucherID() {
        return voucherID;
    }

    public void setVoucherID(String voucherID) {
        this.voucherID = voucherID;
    }

}
