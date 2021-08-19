package DisasterSimulator;

public class SlowText
{
    private String text;
    SlowText(String letters)
    {
        text = letters;
    }

    public void typer()
    {
        for(int i = 0; i < text.length(); i++)
        {
            System.out.print(text.charAt(i));
            Thread t1 = new Thread();
            try
            {
                t1.sleep(500);
            }
            catch(Exception woopsy)
            {
                System.out.println(woopsy);
            }
        }
    }
}
