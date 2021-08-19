package Robot;

/* 
 * Class to be used with PaintingBot to create layouts for shapes 
 * @author Zach Klimowicz
 * @version May 5th, 2017
 * 
 */
public class RobotShapes {
    /** Creates new filled circle
     *  @param int radius
     *  <p>PRECONDITION: radius in an integer greater than zero</p>
     *  @return filled two-dimensional array for printing
     */
    public int [][] newCircle(int radius) {
        int [][] output = new int[radius*2+1][radius*2+1];
        int x;
        int y;
        for (int t = 0;t<360;t++) {
            x = (int)Math.round(radius+radius*Math.cos(t));
            y = (int)Math.round(radius+radius*Math.sin(t)); 

            for (int i = x;i<(output.length-x);i++) {
                output[i][y] = 1;
            }
        }
        return output;
    }

    /** Creates a new Hollow Circle
     *  @param Integer radius
     *  <p>PRECONDITION: radius is an integer greater than zero</p>
     *  @return Filled array Output
     */
    public int [][] newHollowCircle(int radius) {
        int [][] output = new int[radius*2+1][radius*2+1];
        double x;
        double y;
        for (int t = 0;t<360;t++) {
            x = radius+radius*Math.cos(t);
            y = radius+radius*Math.sin(t); 
            output[(int)Math.round(x)][(int)Math.round(y)] = 1;
        }
        return output;
    }

    /** Creates a new Hollow Rectangle
     *  @param Integer x (width)
     *  <p>PRECONDITION: x is an integer greater than zero</p>
     *  @param Integer y (height)
     *  <p>PRECONDITION: y is an integer greater than zero</p>
     *  @return filled array Output
     */
    public int [][] newHollowRectangle(int x,int y) {
        int [][] output = new int[x][y];

        for (int i = 0;i<output[0].length;i++) {
            output[0][i] = 1;
        }

        for (int i = 0;i<output.length;i++) {
            output[i][0] = 1;
            output[i][y-1] = 1;
        }

        for (int i = 0;i<output[0].length;i++) {
            output[x-1][i] = 1;
        }

        return output;
    }

    /** Creates a new filled Rectangle
     *  @param Integer x (width)
     *  <p>PRECONDITION: x is an integer greater than zero</p>
     *  @param Integer y (height)
     *  <p>PRECONDITION: y is an integer greater than zero</p>
     *  @return Filled array Output
     */
    public int [][] newRectangle(int x,int y) {
        int [][] output = new int[x][y];
        for (int i = 0;i<x;i++) {
            for (int j = 0;j<y;j++) {
                output[i][j] = 1;
            }
        }
        return output;
    }

    /** Creates a new filled Square
     * @param Integer size
     * <p>PRECONDITION: size is and integer greater than zero</p>
     * @return two-dimensional array Output
     */
    public int [][] newSquare(int size) {
        int [][] output = new int [size][size];
        int x = 0;
        int y = 0;
        for (int [] arr:output) {
            x = 0;
            for (int num:arr) {
                output[y][x] = 1;
                x++;
            }
            y++;
        }
        return output;
    }

    /** Creates a new filled right Triangle
     *  @param Integer size
     *  <p>PRECONDITION: size is an integer greater than zero</p>
     *  @param Orgins direction
     *  @return two dimensional array Output
     *  
     */
    public int [][] newTriangle(int size,Orgins direction) {
        int [][] output = new int [size][size];

        if (direction == Orgins.TOP_LEFT) {
            for (int i = 0;i<size;i++) {
                for (int j = 0;j<i;j++) {
                    output[i][j] = 1;
                }
            }
        } else if (direction == Orgins.TOP_RIGHT) {
            for (int i = 0;i<size;i++){
                for (int j = 0;j<i;j++) {
                    output[i][(size-1)-j] = 1;
                }
            }
        } else if (direction == Orgins.BOTTOM_LEFT) {
            for (int i = 0;i<size;i++){
                for (int j = 0;j<i;j++) {
                    output[(size-1)-1][j] = 1;
                }
            }
        } else if (direction == Orgins.BOTTOM_RIGHT) {
            for (int i = 0;i<size;i++){
                for (int j = 0;j<i;j++) {
                    output[(size-1)-i][(size-1)-j] = 1;
                }
            }
        }   

        return output;
    }

    /** Blank method to provide a base for additional shapes
     * <p>Use this method to create new custom shapes</p>
     * @param Size to build shape to
     * <p>PRECONDITION: size is an integer greater than zero</p>
     * @returns filled two-dimensional Integer array
     */
    private int [][] customShapeHere(int size) {
        //create integer array to fill
        int [][] output = new int[size][size];

        //use loops to iterate a pattern to the arrays
        //current loops create a square of size Size
        for (int i = 0;i<output.length;i++) {
            for (int j = 0;j<output[i].length;j++) {
                output[i][j] = 1;
            }
        }

        //return the filled array
        return output;
    }
}