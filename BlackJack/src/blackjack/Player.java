package blackjack;


public class Player {
    int index=0;
    private  String Name;
    private  int score;
    private boolean blackjack =false;
    private boolean lostornot=false;
    Card [] cards = new Card[11];

    public String getName() {
        return Name;
    }

    public int getScore() {
        return score;
    }

    public Card[] getCards() {
        return cards;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setName(String name) {
        Name = name;
    }

    public boolean isBlackjack() {
        return blackjack;
    }

    public boolean isLostornot() {
        return lostornot;
    }

    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    public void setLostornot(boolean lostornot) {
        this.lostornot = lostornot;
    }

    public void  add_card(Card c)
    {
        cards[this.index]= c;
       this.setScore(this.getScore()+cards[this.index].getValue());
        index++;
        //score+=c.getValue();


    }


}

