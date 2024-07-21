package Yandex.Sprint2.Bankomat.data;

public class Card {
    String cardNumber;
    int balance;
    String pinCode;

    public Card(String cardNumber, int balance, String pinCode) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pinCode = pinCode;
    }

    @Override
    public String toString() {
        return "Card{" +
                "cardNumber='" + cardNumber + '\'' +
                ", balance=" + balance +
                ", pinCode='" + pinCode + '\'' +
                '}';
    }
    

}




