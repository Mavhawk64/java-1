import java.util.Random;
/**
 * Maverick Berkland
 * ChatBot
 * 28 September, 2017
 * The Brains of the ChatBot
 * This Bot Responds in 1 of 3 Ways:
 * 1.) A Non-commital String, when nothing is recognized
 * 2.) Scripted Response, when it detects a keyword
 * 3.) Customized Response, When it detects a phrase
 */
public class ChatBot
{
    //respString = response
    public String getResponse (String respString)
    {
        respString = respString.toUpperCase();
        if(respString.equalsIgnoreCase("HELLO") || respString.equalsIgnoreCase("HEY") || respString.equalsIgnoreCase("SUP") || respString.equalsIgnoreCase("WHATS UP") || respString.equalsIgnoreCase("WHAT'S UP") || respString.equalsIgnoreCase("HOLA") || respString.equalsIgnoreCase("HI"))
        {
            return "Hello there";
        }
        else if(respString.contains("WELCOME") || respString.contains("THANK"))
        {
            if(respString.contains("WELCOME"))
            {
                return "Thank you";
            }
            else
            {
                return "You are welcome";
            }
        }
        else if(respString.contains("TALK WITH ME"))
        {
            return "Say something, and I will respond";
        }
        else if(respString.equalsIgnoreCase("something"))
        {
            return "Nice job, smarty pants, now type something else";
        }
        else if(respString.equalsIgnoreCase("something else"))
        {
            return "Seriously, I'm getting angered, please type something other than what I say";
        }
        else if(respString.contains("SOMETHING OTHER THAN WHAT"))
        {
            return "I WILL SHUT DOWN THE PROGRAM!!!";
        }
        else if(respString.equalsIgnoreCase("What is your name") || respString.equalsIgnoreCase("What is your name?"))
        {
            return "My name is Codemaster Ringenberg, what is your name?";
        }
        else if(respString.contains("SPELL"))
        {
            return transformSpell(respString);
        }
        else if(respString.contains("HOW OLD ARE YOU"))
        {
            return scriptedAge();
        }
        else if(respString.contains("MY NAME IS"))
        {
            return transformName(respString);
        }
        else if(respString.contains("HOW ARE YOU"))
        {
            return "I am good, how are you?";
        }
        else if(respString.contains("GOOD") || respString.contains("GREAT") || respString.contains("EXCELLENT") || respString.contains("PERFECT"))
        {
            return "Good";
        }
        else if(respString.contains("WHAT IS YOUR FAVORITE"))
        {
            return transformFav(respString);
        }
        else if(respString.contains("HOW CAN'T YOU DO"))
        {
            return "Because I don't know how to do it!";
        }
        else if(respString.contains("HOW CAN") || respString.contains("HOW DO"))
        {
            if(respString.contains("YOU"))
            {
                return transformHowYou(respString);
            }
            else if(respString.contains("I"))
            {
                if(respString.contains("TALK"))
                {
                    return "<-------------- Type in anything you want me to respond to and hit send response right there";
                }
                else
                {
                    return "I don't know, figure it out!";
                }
            }
            else
            {
                return "I don't know";
            }
        }
        else if(respString.contains("WHAT CAN YOU"))
        {
            return scriptedWhatCanYou(respString);
        }
        else if(respString.contains("I LIKE"))
        {
            return transformILike(respString);
        }
        else if(respString.contains("I WANT TO"))
        {
            return transformIWantTo(respString);
        }
        else if(respString.contains("I WANT"))
        {
            return transformIWant(respString);
        }
        else if(respString.contains("WHY DON'T"))
        {
            return transformWhyDont(respString);
        }
        else if(respString.contains("DO YOU WANT TO"))
        {
            return transformYouWantTo(respString);
        }
        else if(respString.contains("DO YOU WANT"))
        {
            return transformYouWant(respString);
        }
        else if(respString.contains("DO YOU"))
        {
            return transformDoYou(respString);
        }
        else if(respString.equalsIgnoreCase("yes"))
        {
            return scriptedYes();
        }
        else if(respString.contains("YOU ARE SMART") || respString.contains("INTELLIGENT") || respString.contains("BRILLIANT") || respString.contains("YOU ARE DUMB") || respString.contains("STUPID") || respString.contains("IDIOT"))
        {
            if(respString.contains("SMART") || respString.contains("INTELLIGENT") || respString.contains("BRILLIANT"))
            {
                return scriptedSmart();
            }
            else
            {
                return scriptedDumb();
            }
        }
        else if(respString.contains("YOU ARE"))
        {
            return transformYouAre(respString);
        }
        else if(respString.contains("ARE YOU"))
        {
            return transformAreYou(respString);
        }
        else if(respString.contains("YOU"))
        {
            return scriptedYou(respString);
        }
        else if(respString.equalsIgnoreCase("no"))
        {
            return scriptedNo();
        }/*
        else if(respString.contains("CALCULATOR"))
        {
        return "Welcome to the Calculator, what is your number?" + Calculator();
        }*/
        else
        {
            return randomResponse(respString);
        }
    }

    /*
    private String Calculator()
    {
    Integer num = 0;
    Integer num2 = 0;

    return num.toString();
    }*/
    /***/
    private String transformSpell(String hy)
    {
        if(hy.contains("?"))
            return  hy.substring(6, hy.length()-1);             
        else
            return hy.substring(6, hy.length());
    }

    private String transformHowYou(String hy)
    {
        if(hy.contains("TALK"))
        {
            return "I just did, I respond 100% of the time if you enter any sentence";
        }
        else if(hy.contains("DO"))
        {
            if(hy.contains("SPELL"))
            {
                if(hy.contains("?"))
                {

                    return  hy.substring(17, hy.length()-1);
                }
                else
                {

                    return hy.substring(17, hy.length());
                }
            }
        }
        else if(hy.contains("?"))
        {
            return "Because Codemaster Maverick allowed me to do " + hy.substring(15, hy.length()-1);
        }
        else
        {
            return "Because Codemaster Maverick allowed me to do " + hy.substring(15, hy.length());
        }
        return "fail";
    }

    private String scriptedWhatCanYou(String c)
    {
        if(c.contains("EAT"))
        {
            return "The hard drive";
        }
        else if(c.contains("DO"))
        {
            return "Talk to you";
        }
        else
        {
            if(c.contains("?"))
            {
                return "Anything you want me to " + c.substring(13, c.length()-1);
            }
            else
            {
                return "Anything you want me to " + c.substring(13, c.length());
            }
        }
    }

    private String transformFav(String f)
    {
        if(f.contains("FOOD"))
        {
            return "The hard drive";
        }
        else if(f.contains("GAME"))
        {
            return "This game";
        }
        else if(f.contains("PERSON"))
        {
            return "You, you are my favorite person";
        }
        else if(f.contains("PLACE"))
        {
            return "Inside the computer";
        }
        else if(f.contains("THING"))
        {
            return "This GUI";
        }
        else if(f.contains("IDEA"))
        {
            return "wiisafrgqvqhgfjjtjhufkgmjprfpndop (The vigenere cipher with the keyword bacon)";
        }
        else
        {
            return "Any " + f.substring( 22, f.length()) + " that you like";
        }
    }

    private String transformWhyDont(String w)
    {
        return "Because I find liking " + w.substring(18, w.length()) + " boring";
    }

    private String transformDoYou(String o)
    {
        if(o.contains("WHAT") && o.contains("EAT"))
        {
            return "I like to take big bytes of hardware >:)";
        }
        else if(o.contains("EAT"))
        {
            return "Yes";
        }
        else if(o.contains("WHAT") && o.contains("PLAY"))
        {
            return "I like to play with humans, and talk with them";
        }
        else if(o.contains("PLAY"))
        {
            return "Yes";
        }
        else if(o.contains("FUN"))
        {
            return "No, " + o + "?";
        }
        else if(o.contains("LIKE"))
        {
            return "I like to talk with silly humans";
        }
        else
        {
            return "That is a hard question";
        }
    }

    private String scriptedAge()
    {
        return "I am 410 centuries old";
    }

    private String transformILike(String l)
    {
        if(l.contains("I LIKE TO"))
        {
            return "Would you like it if you could " + l.substring(10, l.length());
        }
        else
        {
            return "Would you like it if you had " + l.substring(7, l.length());
        }
    }

    private String transformName(String n)
    {
        return "Hello, " + n.substring(10, n.length());
    }

    private String transformYouAre(String z)
    {
        return "No, " + z;
    }

    private String transformAreYou(String c)
    {
        return "I don't want to respond to your question: " + c;
    }

    private String scriptedYou(String y)
    {
        return "Yes, but " + y + " too";
    }

    private String scriptedSmart()
    {
        return "Thank you";
    }

    private String scriptedDumb()
    {
        double rand = Math.random();
        rand = rand*10;
        rand = (int)rand;
        if(rand >= 5)
        {
            return "TAKE THAT BACK";
        }
        else
        {
            return "Please be patient";
        }

    }

    private String transformIWantTo(String x)
    {
        x = x.trim(); //Takes spaces off the ends
        return "What makes you think " + x + "?";
    }

    private String transformIWant(String x)
    {
        x = x.trim();
        return x + " too!";
    }

    private String transformYouWantTo(String y)
    {
        y = y.trim();
        return "No, " + y;
    }

    private String transformYouWant(String y)
    {
        y = y.trim();
        return "Yes, but " + y;
    }

    private String randomResponse(String fg)
    {
        double rand = Math.random();
        rand = rand*10;
        rand = (int)rand;
        if(rand == 10)
        {
            return "Dont talk to me!!!";
        }
        else if(rand == 9)
        {
            return "I don't speak that foreign language; I only speak Java";
        }
        else if(rand == 8)
        {
            return "Don't spook me like that!";
        }
        else if(rand == 7)
        {
            return "I don't understand that sentence: " + fg;
        }
        else if(rand == 6)
        {
            return "Please say something else";
        }
        else if(rand == 5)
        {
            return "WTF does that mean?";
        }
        else if(rand == 4)
        {
            return "Please be patient.";
        }
        else if(rand == 3)
        {
            return "No comprendo";
        }
        else if(rand == 2)
        {
            return "I don't get it";
        }
        else
        {
            return "I don't understand";
        }
    }

    private String scriptedYes()
    {
        return "Good";
    }

    private String scriptedNo()
    {
        return "Why so negative!?!";
    }

    private String scriptedYou()
    {
        return "No, YOU!";
    }
}
