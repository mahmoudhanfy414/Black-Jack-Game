package blackjack;


import java.util.Random;
import java.util.Scanner;

public class Game {
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    Player[] players = new Player[4];
    Card[] deck_array = new Card[52];
    static int VALID=0;

    //function to generate the  deck cards
    public void generate_deckcards() {
        int c = 0;
        for (int i = 0; i < 4; ++i) {
            for (int j = 0; j < 13; ++j) {
                if (j >9) {
                    deck_array[c] = new Card(i, j, 10);
                } else {
                    deck_array[c] = new Card(i, j, j + 1);
                }
                c++;
            }
        }
    }

    //function to draw card from a deck card
    public Card draw_card()
    {
        Card random_chosen_card = new Card();
        while ( true)
        {
            int random_choice_index = rand.nextInt(52);
            if (deck_array[random_choice_index]==null)
            {

                continue;
            }

            else
            {
                random_chosen_card = deck_array[random_choice_index];
                deck_array[random_choice_index] = null;
                break;


            }
        }
        return  random_chosen_card;
    }


    //function to set information of players
    public void set_information() {


        for (int i=0;i<4;++i)
        {
            players[i]=new Player();
            Card c=new Card();
            System.out.println("Enter the player name ");
            players[i].setName(input.next());

            players[i].add_card(draw_card());

            players[i].add_card(draw_card());



        }
    }
    //function to keep track of high score of all players
    public  void  high_score ()
    {

        for(int i=0;i<3;++i)
        {
            if (players[i].getScore()>=VALID && players[i].getScore()<=21)
            {
                VALID=players[i].getScore();
            }
        }

    }
}
