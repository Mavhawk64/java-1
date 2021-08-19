package GUIstuff;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class OKbutton extends JFrame implements ActionListener
{
    //Attributes
    JPanel panel;
    JLabel label;
    JButton button;
    static int count = 0;
    OKbutton(String title, int x, int y)
    {
        super(title); //Invokes JFrame's Constructor
        Random rando = new Random();
        /*if(count != 0)
        {
        x = rando.nextInt(1000);
        y = rando.nextInt(500);
        if(x == 0 || y == 0)
        {
        if(x == 0)
        x = rando.nextInt(1000);
        else
        y = rando.nextInt(500);
        }
        }*/
        setSize(x, y); // if null, it will be in center!
        setDefaultCloseOperation(/*JFrame.*/EXIT_ON_CLOSE); //You cannot change a variable if in CAPITAL letters

        int randx = rando.nextInt(1300);
        int randy = rando.nextInt(500);
        setLocation(randx, randy);
        //The initialization
        panel = new JPanel();
        label = new JLabel("Click Me");
        button = new JButton();

        //putting JVariables in JFrame
        add(panel); //panel to JFrame
        panel.add(label); //label to panel

        //Color
        if(count < 10)
            panel.setBackground(new Color(0xecff08));
        else if(count > 10 && count < 20)
            panel.setBackground(new Color(0x05c1ff));
        else if(count > 20 && count < 30)
            panel.setBackground(new Color(0xf788ce));
        else if(count > 30 && count < 40)
        {
            panel.setBackground(new Color(0x0505ff));
        }
        else if(count > 40 && count < 50)
            panel.setBackground(new Color(0x029939));
		else if(count > 50 && count < 60)
			panel.setBackground(new Color(0x87c5f5));
		else if(count > 60 && count < 70)
			panel.setBackground(new Color(0xcd5c5c));
		else if(count > 70 && count < 80)
			panel.setBackground(new Color(0xf9536b));
		else if(count > 80 && count < 90)
			panel.setBackground(new Color(0xa10506));
        else
            panel.setBackground(new Color(0x00fa9a));
        //Button work
        button.setText("OK");
        button.addActionListener(this);
        panel.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent evt)
    {
        Random rand = new Random();
        int randi = rand.nextInt(20);
        for(int i = 0; i < randi; i++)
        {
            OKbutton myFirstButton = new OKbutton("Minecraft 1.12.2", 200, 200);
            myFirstButton.setVisible(true);
            count = rand.nextInt(100);
            /**
             * Sleep this...
             * Toolkit.getDefaultToolkit().beep();
             */
        }
        count = rand.nextInt(100);
    }

    public static void main (String [] args)
    {
        OKbutton myFirstButton = new OKbutton("Minecraft 1.12.2", 200, 200);
        myFirstButton.setVisible(true);
        Toolkit.getDefaultToolkit().beep();
    }
}