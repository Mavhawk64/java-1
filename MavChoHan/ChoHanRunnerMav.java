package ChoHan;


/**
 * This is the runner for ChoHanMaverick and DiceMaverick
 */
public class ChoHanRunnerMav
{
    public static void main (String [] args)
    {
        System.out.println("Welcome to ChoHan!");
        System.out.println("ChoHan means Odd or Even in Chinese.");
        ChoHanMaverick game = new ChoHanMaverick();
        game.Play();
    }
}
