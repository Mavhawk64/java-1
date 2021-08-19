import java.util.*;
/**
 * A Program to play Black Jack
 *
 * @author Maverick Berkland
 * @version 27 August, 2019
 */
public class BlackJack
{
    public static int playertotal = 0;
    public static int dealertotal = 0;
    public static String deal = "";
    public static int count = 0;
    public static boolean playerAce = false;
    public static boolean dealerAce = false;
    public static void main()
    {
        playertotal = 0;
        dealertotal = 0;
        deal = "";
        playerAce = false;
        dealerAce = false;
        if(count != 0)
        {
            System.out.println("\n\n\n");
        }
        count++;
        System.out.println("Welcome to Maverick's blackjack program!");
        PlayerDeal();
    }

    public static void PlayerDeal()
    {
        String c1 = Deal();
        String c2 = Deal();
        deal = Deal();
        if(!(c1.equals("Eight") || c1.equals("Ace")) && !(c2.equals("Eight") || c2.equals("Ace")))
            System.out.println("You drew a " + c1 + " and a " + c2);
        else if((c1.equals("Eight") || c1.equals("Ace")) && !(c2.equals("Eight") || c2.equals("Ace")))
            System.out.println("You drew an " + c1 + " and a " + c2);
        else if(!(c1.equals("Eight") || c1.equals("Ace")) && (c2.equals("Eight") || c2.equals("Ace")))
            System.out.println("You drew a " + c1 + " and an " + c2);
        else
            System.out.println("You drew an " + c1 + " and an " + c2);
        //If Ace & King, Queen, Jack, or Ten... Black Jack (21).
        //Counter...
        int val = 0;
        int val2 = 0;
        int total = 0;
        boolean win = false;
        if(c1.equals("Ace"))
        {
            playerAce = true;
            val = 1;
        }
        else if(c1.equals("Two"))
            val = 2;
        else if(c1.equals("Three"))
            val = 3;
        else if(c1.equals("Four"))
            val = 4;
        else if(c1.equals("Five"))
            val = 5;
        else if(c1.equals("Six"))
            val = 6;
        else if(c1.equals("Seven"))
            val = 7;
        else if(c1.equals("Eight"))
            val = 8;
        else if(c1.equals("Nine"))
            val = 9;
        else
            val = 10;

        if(c2.equals("Ace"))
        {
            playerAce = true;
            val2 = 1;
        }
        else if(c2.equals("Two"))
            val2 = 2;
        else if(c2.equals("Three"))
            val2 = 3;
        else if(c2.equals("Four"))
            val2 = 4;
        else if(c2.equals("Five"))
            val2 = 5;
        else if(c2.equals("Six"))
            val2 = 6;
        else if(c2.equals("Seven"))
            val2 = 7;
        else if(c2.equals("Eight"))
            val2 = 8;
        else if(c2.equals("Nine"))
            val2 = 9;
        else
            val2 = 10;

        if(!playerAce)
        {
            total = val + val2;
            System.out.println("Your total is " + total);
        }
        else if(playerAce)
        {
            total = val + val2;
            System.out.println("Your total, when the ace is one, is " + total);
            total += 10;
            System.out.println("Your total, when the ace is eleven, is " + total); //Permanently +10, so if bust, check for ace and sub 10 if playerAce
            if(total == 21)
            {
                System.out.println("Black Jack! You Won!");
                win = true;
            }
        }
        else
        {
            total = 2;
            System.out.println("Your total, when both aces are one, is " + total);
            total+=10;
            System.out.println("Your total, when one of the aces is eleven, is " + total);
        }

        if(deal.equals("Eight") || deal.equals("Ace"))
            System.out.println("The Dealer is showing an " + deal + " and a hidden card.");
        else
            System.out.println("The Dealer is showing a " + deal + " and a hidden card.");

        if(!win)
            PlayerDraw(total);
        else
        {
            System.out.println("Would you like to play again???");
            Scanner scan = new Scanner(System.in);
            String resp = scan.nextLine();
            if((resp.toLowerCase()).contains("y"))
                main();
        }
    }

    public static void PlayerDraw(int total)
    {
        System.out.println("Would you like to hit or stay?");
        Scanner scan = new Scanner(System.in);
        String hORs = scan.nextLine();
        int val = 0;
        playertotal = total;
        if((hORs.toLowerCase()).contains("h"))
        {
            String c = Draw();
            if(c.equals("Eight") || c.equals("Ace"))
                System.out.println("You drew an " + c);
            else
                System.out.println("You drew a " + c);
            if(c.equals("Ace"))
            {
                playerAce = true;
                val = 1;
            }
            else if(c.equals("Two"))
                val = 2;
            else if(c.equals("Three"))
                val = 3;
            else if(c.equals("Four"))
                val = 4;
            else if(c.equals("Five"))
                val = 5;
            else if(c.equals("Six"))
                val = 6;
            else if(c.equals("Seven"))
                val = 7;
            else if(c.equals("Eight"))
                val = 8;
            else if(c.equals("Nine"))
                val = 9;
            else
                val = 10;
            if(playerAce)
            {
                if(total > 10)
                {
                    total++;
                    System.out.println("Your total, when the ace is one, is now " + total);
                }
                else
                {
                    total+=11;
                    System.out.println("Your total, when the ace is 11, is now " + total);
                }
            }
            else
            {
                total+=val;
                System.out.println("Your total is now " + total);
            }
            playertotal = total;
            if(total > 21 && !playerAce)
            {
                System.out.println("You busted! YOU LOSE!");
                System.out.println("Would you like to play again???");
                String resp = scan.nextLine();
                if((resp.toLowerCase()).contains("y"))
                    main();
            }
            else if(total > 21 && playerAce)
            {
                total = total - 10;
                System.out.println("Your total is now " + total + " after giving your ace a value of 1.");
                PlayerDraw(total);
            }
            else if(total == 21)
            {
                System.out.println("Black Jack! YOU WON!");
                System.out.println("Would you like to play again???");
                String resp = scan.nextLine();
                if((resp.toLowerCase()).contains("y"))
                    main();
            }
            else
                PlayerDraw(total);
        }
        else
        {
            DealerDeal();
        }
    }

    public static void DealerDeal()
    {
        String c1 = deal;
        String c2 = Deal();
        if(c2.equals("Eight") || c2.equals("Ace"))
            System.out.println("The Dealer flips his card; it is an " + c2);
        else
            System.out.println("The Dealer flips his card; it is a " + c2);
        int val = 0;
        int val2 = 0;
        int total = 0;
        boolean lose = false;
        if(c1.equals("Ace"))
        {
            dealerAce = true;
            val = 1;
        }
        else if(c1.equals("Two"))
            val = 2;
        else if(c1.equals("Three"))
            val = 3;
        else if(c1.equals("Four"))
            val = 4;
        else if(c1.equals("Five"))
            val = 5;
        else if(c1.equals("Six"))
            val = 6;
        else if(c1.equals("Seven"))
            val = 7;
        else if(c1.equals("Eight"))
            val = 8;
        else if(c1.equals("Nine"))
            val = 9;
        else
            val = 10;

        if(c2.equals("Ace"))
        {
            dealerAce = true;
            val2 = 1;
        }
        else if(c2.equals("Two"))
            val2 = 2;
        else if(c2.equals("Three"))
            val2 = 3;
        else if(c2.equals("Four"))
            val2 = 4;
        else if(c2.equals("Five"))
            val2 = 5;
        else if(c2.equals("Six"))
            val2 = 6;
        else if(c2.equals("Seven"))
            val2 = 7;
        else if(c2.equals("Eight"))
            val2 = 8;
        else if(c2.equals("Nine"))
            val2 = 9;
        else
            val2 = 10;

        if(!dealerAce)
        {
            total = val + val2;
            System.out.println("The Dealer's total is " + total);
        }
        else if(dealerAce)
        {
            total = val + val2;
            System.out.println("The Dealer's total, when the ace is one, is " + total);
            total += 10;
            System.out.println("The Dealer's total, when the ace is eleven, is " + total);
            if(total == 21)
            {
                System.out.println("Black Jack! YOU LOST!");
                lose = true;
            }
        }
        else
        {
            total = 2;
            System.out.println("The Dealer's total, when both aces are one, is " + total);
            total+=10;
            System.out.println("The Dealer's total, when one of the aces is eleven, is " + total);
        }
        dealertotal = total;
        if(!lose)
            DealerDraw(total);
        else
        {
            System.out.println("Would you like to play again???");
            Scanner scan = new Scanner(System.in);
            String resp = scan.nextLine();
            if((resp.toLowerCase()).contains("y"))
                main();
        }
    }

    public static void DealerDraw(int total)
    {
        int val = 0;
        dealertotal = total;
        if(dealertotal <= 16 && dealertotal != playertotal)
        {
            String c = Draw();
            if(c.equals("Eight") || c.equals("Ace"))
                System.out.println("The Dealer drew an " + c);
            else
                System.out.println("The Dealer drew a " + c);
            if(c.equals("Ace"))
            {
                dealerAce = true;
                val = 1;
            }
            else if(c.equals("Two"))
                val = 2;
            else if(c.equals("Three"))
                val = 3;
            else if(c.equals("Four"))
                val = 4;
            else if(c.equals("Five"))
                val = 5;
            else if(c.equals("Six"))
                val = 6;
            else if(c.equals("Seven"))
                val = 7;
            else if(c.equals("Eight"))
                val = 8;
            else if(c.equals("Nine"))
                val = 9;
            else
                val = 10;
            if(dealerAce)
            {
                if(total > 10)
                {
                    total++;
                    System.out.println("The Dealer's total, when the ace is one, is now " + total);
                }
                else
                {
                    total+=11;
                    System.out.println("The Dealer's total, when the ace is 11, is now " + total);
                }
            }
            else
            {
                total+=val;
                System.out.println("The Dealer's total is now " + total);
            }
            dealertotal = total;
            if(total > 21 && !dealerAce)
            {
                System.out.println("The Dealer busted! You Win!");
                System.out.println("Would you like to play again???");
                Scanner scan = new Scanner(System.in);
                String resp = scan.nextLine();
                if((resp.toLowerCase()).contains("y"))
                    main();
            }
            else if(total > 21 && dealerAce)
            {
                total = total - 10;
                System.out.println("The dealer's total is now " + total + " after giving the dealer's ace a value of 1.");
                DealerDraw(total);
            }
            else if(total == 21)
            {
                System.out.println("Black Jack! YOU LOST!");
                System.out.println("Would you like to play again???");
                Scanner scan = new Scanner(System.in);
                String resp = scan.nextLine();
                if((resp.toLowerCase()).contains("y"))
                    main();
            }
            else
                DealerDraw(total);
        }
        else
        {
            System.out.println("The Dealer stays.");
            dealertotal = total;
            TotalChecker();
        }
    }

    public static void TotalChecker()
    {
        System.out.println("Checking Totals...");
        if(playertotal > dealertotal)
            System.out.println("Your Total: " + playertotal + " is greater than The Dealer's Total: " + dealertotal + ", so You Win!");
        else if(dealertotal > playertotal)
            System.out.println("Your Total: " + playertotal + " is less than The Dealer's Total: " + dealertotal + ", so YOU LOSE!");
        else
            System.out.println("Your Total: " + playertotal + " is the same as The Dealer's Total: " + dealertotal + ", and the tie goes to The Dealer... YOU LOSE!");

        System.out.println("Would you like to play again???");
        Scanner scan = new Scanner(System.in);
        String resp = scan.nextLine();
        if((resp.toLowerCase()).contains("y"))
            main();
    }

    public static String Draw()
    {
        int x = 0;
        String c = "";
        Random rand = new Random();
        x = rand.nextInt(13);
        String [] cards = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        c = cards[x];
        return c;
    }

    public static String Deal()
    {
        // A-K
        //A = 1 or 11
        //J, Q, K = 10
        //4/13 chance of getting a card with value 10
        int x = 0;
        String c = "";
        Random rand = new Random();
        x = rand.nextInt(13);
        String [] cards = {"Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
        c = cards[x];
        //System.out.println("THE METHOD 'DEAL()' RETURNS A(n) " + c); //Debugging
        return c;
    }
}