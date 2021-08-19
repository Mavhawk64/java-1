public class BogoSort extends SortAlgorithm
{
    @Override
    public void sort(int[] data)
    {
        //Random Shuffler
        while(!isSorted(data)) 
        {
            for (int x = 0; x < data.length; x++) 
            {
                int index1 = (int) (Math.random() * data.length), index2 = (int) (Math.random() * data.length);
                int a = data[index1];
                data[index1] = data[index2];
                data[index2] = a;
            }
        } 
        System.out.println("Array in order: ");
        for(int i = 0; i < data.length; i++)
        {
            if(i < data.length - 1)
                System.out.print(data[i] + ", ");
            else
                System.out.println(data[i]);
        }
    }

    private boolean isSorted(int[] data) 
    {
        for (int x = 0; x < data.length - 1; ++x) 
        {
            if (data[x] > data[x + 1]) 
                return false;
        }
        return true;
    }

    @Override
    public String getName()
    {
        return "Bogo Sort";
    }
}