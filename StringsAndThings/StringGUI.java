import java.awt.Font;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class StringGUI
{
    //instance data
    public JFrame frame = new JFrame("Maverick's ChatBot");
    public JPanel buttonPanel = new JPanel();
    public JPanel textPanel = new JPanel();
    public JPanel mainPanel = new JPanel();
    public JTextField youSay = new JTextField("Talk with me...", 30);
    public JTextArea theConvo = new JTextArea("PLEASE GO INTO FULL SCREEN MODE FOR BETTER RESULTS",5, 20);
    public JButton talkButton = new JButton("Send Response");
    ChatBot cb = new ChatBot();
    //constructor
    public StringGUI()
    {

        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.PAGE_AXIS));

        frame.add(mainPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(15,0)));
        mainPanel.add(buttonPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(15,0)));
        mainPanel.add(textPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(15,0)));

        buttonPanel.add(Box.createRigidArea(new Dimension(0,35)));
        buttonPanel.add(talkButton);
        buttonPanel.add(Box.createRigidArea(new Dimension(0,35)));

        textPanel.add(Box.createRigidArea(new Dimension(0,25)));
        textPanel.add(youSay);
        textPanel.add(Box.createRigidArea(new Dimension(0,25)));
        textPanel.add(theConvo);
        textPanel.add(Box.createVerticalGlue());
        textPanel.add(Box.createRigidArea(new Dimension(0,25)));

        Font font1 = new Font("Comic Sans MS", Font.BOLD, 18);
        Font font2 = new Font("Elephant", Font.BOLD, 18);
        youSay.setFont(font1);
        theConvo.setFont(font2);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 250);

        talkButton.addActionListener(new Action1());
    }

    class Action1 implements ActionListener 
    {

        //Where the conversation happens
        public void actionPerformed(ActionEvent e) {

            String ansString = youSay.getText();

            theConvo.setText(cb.getResponse(ansString));

        }
    }

    //Main Method
    public static void main (String [] args)
    {
        StringGUI cal1 = new StringGUI();
    }
}