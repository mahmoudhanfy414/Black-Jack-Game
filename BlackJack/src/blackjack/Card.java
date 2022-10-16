package blackjack;


public class Card {
    private   int suit;
    private  int rank;
    private  int value;

    public Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    // copy constructor
    public Card (Card card)
    {
        suit=card.suit;
        rank=card.rank;
        value=card.value;
    }
    public Card()
    {

    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }


}

