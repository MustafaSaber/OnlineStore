package A2Z;

public class CreditCard {
    private String cardID;
    private double myMoney;

    public double getMyMoney() {
        return myMoney;
    }

    public void setMyMoney(double myMoney) {
        this.myMoney = myMoney;
    }

    public CreditCard(){

    }

    public CreditCard(String cardID , double mo) {
        this.cardID = cardID;
        myMoney = mo;
    }

    public String getCardID() {
        return cardID;
    }

    public void setCardID(String cardID) {
        this.cardID = cardID;
    }

}
