class RowSumOddNumbers {
    /*
     *            1
     *           3 5
     *          7 9 11
     *        13 15 17 19
     *      21 23 25 27 29
     *      ...
     */
    /**
     * Main Method -- Solved By Maverick Berkland
     */
    public static void main ()
    {
        for(int i = 1; i < 43; i++)
        {
            System.out.println(rowSumOddNumbers(i));
        }
    }

    public static int rowSumOddNumbers(int n) {
        int firstInt = (n-1)*n+1; //general formula I derived
        int tot = 0;
        for(int i = 0; i < n; i++)
        {
            tot+=firstInt+2*i;   
        }

        return tot;
    }
}