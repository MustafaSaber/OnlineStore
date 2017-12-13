package A2Z;

public class CreditCard {
    private String cardID;
    private double MyMoney;

    public double getMyMoney() {
        return MyMoney;
    }

    public void setMyMoney(double myMoney) {
        MyMoney = myMoney;
    }

    public CreditCard(){

    }

    public CreditCard(String cardID) {
        this.cardID = cardID;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

}
