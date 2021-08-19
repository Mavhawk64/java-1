import java.util.*;
import java.math.*;
public class Top5
{
    public static void main(String[] args) {
        System.out.println("TOP 5");
        int[] a = new int[10];
        for(int i = 0; i < a.length; i++) {
            a[i] = (new Random()).nextInt(69)+1;
            System.out.print(a[i] + ", ");
        }
        System.out.println();
        int[][] top5 = {{0,0},{0,0},{0,0},{0,0},{0,0}};
        for(int i = 0; i < a.length; i++) {
            if(top5[0][1] < a[i]) {
                top5[0][1] = a[i];
                top5[0][0] = i;
                i = -1;
            } else {
                for(int j = 1; j < top5.length; j++) {
                    if(top5[j][1] < a[i] && top5[j-1][1] > a[i]) {
                        top5[j][1] = a[i];
                        top5[j][0] = i;
                        i = -1;
                        break;
                    }
                }
            }

            /*if(top5[0] < a[i]) {
            top5[0] = a[i];
            i = -1;
            } else if(top5[1] < a[i] && a[i] < top5[0]) {
            top5[1] = a[i];
            i = -1;
            } else if(top5[2] < a[i] && a[i] < top5[1]) {
            top5[2] = a[i];
            i = -1;
            } else if(top5[3] < a[i] && a[i] < top5[2]) {
            top5[3] = a[i];
            i = -1;
            } else if(top5[4] < a[i] && a[i] < top5[3]) {
            top5[4] = a[i];
            i = -1;
            }*/
        }

        for(int i = 0; i < top5.length; i++) {
            int x = i+1;
            System.out.println("TOP " + x + ": " + top5[i][0] + " : " + top5[i][1]); 
        }
    }
}
