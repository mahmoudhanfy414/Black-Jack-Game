package blackjack;


import java.util.Scanner;

public class BlackJack
{
   static GUI gui = new GUI();
    static Game g1 =new Game();
     public static void playing () {
        Scanner input= new Scanner(System.in);
        for (int i = 0; i < 3; ++i) {
                System.out.println(g1.players[i].getName() + " "+"your score :" + g1.players[i].getScore());

                System.out.println(g1.players[i].getName()+" 1:HIT OR 2:STAND");

                int s = input.nextInt();

              Card c=new Card();

                while (s == 1 && g1.players[i].getScore() < 21) {
                    c=g1.draw_card();
                    g1.players[i].add_card(c);
                    //System.out.println(c.getValue()+" "+c.getRank()+" "+c.getSuit());
                    gui.updatePlayerHand(c,i);
                    g1.high_score();
                    System.out.println(g1.players[i].getName()+" " + "your score " + g1.players[i].getScore());
                    if (g1.players[i].getScore() > 21) {
                        g1.players[i].setLostornot(true);
                        System.out.println(g1.players[i].getName()+" you basted"+" " + "your score " + g1.players[i].getScore());
                        //to update high score if the player basted
                        g1.players[i].setScore(0);
                        Game.VALID=0;
                        g1.high_score();
                        break;
                    }
                    else if (g1.players[i].getScore() == 21) {
                        g1.players[i].setBlackjack(true);
                        break;
                    }
                    System.out.println("1: HIT or 2:STAND"+(i+1));
                    s = input.nextInt();


                    if (s == 2) {
                        continue;
                    }
                }

            }
         System.out.println("Valid score before deler"+Game.VALID);
dealer(g1.players[3]);

    }
    public static void who_win() {
        int c=0;
        int s=0;
        for (int i=0;i<4;++i)
        {
            if (g1.players[i].isBlackjack() == true) {
                c++;
            }
        }
        if (c==1)
        {
            for (int i=0;i<4;++i)
                if (g1.players[i].isBlackjack()==true) {
                    System.out.println(g1.players[i].getName()+" "+" IS WIN");
                }
        }


        else if (c > 1)
        {
            System.out.println("THE GAME IS PUSH");
        }
        else if (c == 0)
        {
            for (int i = 0; i< 4; ++i) {
                if (g1.players[i].getScore() == Game.VALID)
                {
                    g1.players[i].setLostornot(false);
                    s++;
                }
            }
            if (s == 1) {
                for (int i = 0; i < 4; ++i) {
                    if (g1.players[i].getScore() == Game.VALID) {
                        System.out.println(g1.players[i].getName() + " " + " IS WIN");
                    }

                }
            }
            else  {
                System.out.println("THE GAME IS PUSH");
            }
        }
    }
    public static void dealer(Player player4){

            //System.out.println("VAILD SCORE BEFORE DELER :"+" "+Game.VALID);
            // while (g1.players[i].getScore()<21 && g1.players[i].getScore() <  (Game.VALID))
                System.out.println(player4.getName() + " " + "your score " + player4.getScore());
        if (player4.getScore() > Game.VALID)
        {
            System.out.println(player4.getName() + " " + " your score: " + player4.getScore());
            //to delear win
            Game.VALID=player4.getScore();
            player4.setLostornot(false);
        }
            else
            {
                while (true)
                {
                    Card d = new Card();
                    d = g1.draw_card();
                    gui.updateDealerHand(d,g1.deck_array);
                    player4.add_card(d);
                    System.out.println(player4.getName()+" "+player4.getScore());
                    //to check if deler score bigger than valid score
                    if (player4.getScore()>Game.VALID&&player4.getScore()<21)
                    {
                        //System.out.println("delear score is bigger than valid score");
                       // g1.high_score();
                        Game.VALID=player4.getScore();
                        break;
                    }
                    if (player4.getScore() > 21) {
                        player4.setLostornot(true);
                        //to update the high score
                       player4.setScore(0);
                        g1.high_score();
                        break;
                    }

                    else if (g1.players[3].getScore() == 21)
                    {
                        player4.setLostornot(false);
                        player4.setBlackjack(true);
                        break;

                    }

                }
            }

        }
    public static void main (String [] args)
    {

        g1.generate_deckcards();
       g1.set_information();
      gui.runGUI(g1.deck_array , g1.players[0].cards, g1.players[1].cards, g1.players[2].cards,g1.players[3].cards );
       playing();
        who_win();

    }
}
