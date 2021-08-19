import java.util.*;
/**
 * Write a description of class LogMessage here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LogMessage
{
    private static String machineId;
    private static String description;
    public static String keyword;
    public static boolean n = false;
    static List<String> messageList = new ArrayList<String>();
    public String LogMessage(String message)
    {
        machineId = message.substring(0, message.indexOf(":"));
        description = message.substring(message.indexOf(":") + 1, message.length());
        //System.out.println(machineId);
        //System.out.println(description);
        return description;
    }

    public boolean containsWord(String keyword)
    {
        keyword = keyword + " ";
        description = description + " ";
        if(description.equals(keyword))
            n = true;
        else if(description.contains(" " + keyword))
            n = true;
        else
            n = false;
        System.out.println(keyword + " is " + description + ":" + n);
        return n;
    }
    
    public List<LogMessage> removeMessages(String keyword)
    {
        List<LogMessage> x = new ArrayList<LogMessage>();
        for(int i = messageList.size(); i >= 0; i--)
        {
            if((messageList.get(i)).containsWord(keyword))
            {
                x.add(messageList.get(i));
                message.remove(messageList.get(i));
            }
        }
        return x;
    }

    public static void main (String [] args)
    {
        String message = "error:disk";
        LogMessage(message);
        String [] arr = {"disk", "error on disk", "error on /dev/disk disk", "error on disk DSK1", "DISK", "error on disk3", "error on /dev/disk", "diskette"};
        for(int i = 0; i < arr.length; i++)
        {
            messageList.add(arr[i]);
        }

        for(int i = 0; i < arr.length; i++)
        {
            description = arr[i];
            keyword = "disk";
            System.out.println(containsWord(keyword));
        }

        System.out.println("--C--" + "\n\n\n");
    }
}
