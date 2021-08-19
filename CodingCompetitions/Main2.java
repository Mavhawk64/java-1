import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        System.out.println("Input");
        String in = (new Scanner(System.in)).nextLine();
    	 int iterations = numberInput(in);
    	 for(int i=0; i<iterations; i++) {
    	     System.out.println("i" + i);
    		 System.out.println(conBase());
    	 }
    }
    
    public static long conBase()
    {
        System.out.println("New Input");
    	String in = (new Scanner(System.in)).nextLine();
    	int pos = in.indexOf(" ");
		int base = numberInput(in.substring(0, pos));
		String inCode = in.substring(pos+1, in.length());
		int converted = 0;
		int k = 0;
    	for(int i = inCode.length()-1; i >= 0; i--)
    	{
    		int add = 1;
    		int l = numberInput(in.charAt(i));
    		converted += l*Math.pow(base, k-1);
    		System.out.println("Value is " + converted);
    		k++;
    	}
    	return converted;
    }
    
    
    public static int numberInput(String x){
        try{
            return Integer.parseInt(x.trim());
        }catch (Exception e){
            return 0;
        }
    }
    
    public static int numberInput(char x){
        String newGuy = "" + x;
        return numberInput(newGuy);
    }
}