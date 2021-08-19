class WhoLikesIt {
    public static void main ()
    {
        System.out.println("Initializing...");
        System.out.println(whoLikesIt(""));
        System.out.println(whoLikesIt("Peter"));
        System.out.println(whoLikesIt("Peter", "John"));
        System.out.println(whoLikesIt("Peter", "John", "Max"));
        System.out.println(whoLikesIt("Peter", "John", "Max", "Mark"));
        System.out.println(whoLikesIt("Maverick","Mitchell","Peter", "John","Billy Bob Thorton"));
    }
    
    public static String whoLikesIt(String... names) {
        int oof = names.length -2;
        if(names.length == 0 || names[0].equals(""))
            return "no one likes this";
        else if(names.length == 1)
            return names[0] + " likes this";
        else if(names.length == 2)
            return names[0] + " and " + names[1] + " like this";
        else if(names.length == 3)
            return names[0] + ", " + names[1] + " and " + names[2] + " like this";
        else
            return names[0] + ", " + names[1] + " and " + oof + " others like this";
    }
}