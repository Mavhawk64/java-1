package ShapesMaverick;
/**
 * Abstract class Shape - Protects it from being instantiated
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Shape
{
    String symbol;
    int size;
    Shape()
    {
        symbol = " ";
        size = 1;
    }
    
    public abstract void Draw ();
}
