int [][] grid;
int WIDTH = 75;
int HEIGHT = 75;
int MARGIN = 5;
int w = 10;
int h = 10;
void setup()
{
  size(805, 805);
  grid = new int [w][h];
  for(int i = 0; i < 10; i++)
  {
    int ranW = floor(random(grid.length));
    int ranH = floor(random(grid.length));
    if(grid[ranW][ranH] == 1)
      i--;
    else
    grid[ranW][ranH] = 1;
  }
}

void draw()
{
  background(0);
  show();
  update();
  frameRate(0.5);
}

void show()
{
  for(int i = 0; i < grid.length; i++)
  {
    for(int j = 0; j < grid[i].length; j++)
    {
      fill(255,0,0);
      if(grid[i][j] == 0)
      fill(0,255,0);
      rect((MARGIN + WIDTH) * i + MARGIN, (MARGIN + HEIGHT) * j + MARGIN, WIDTH, HEIGHT);
    }
  }
}

void update()
{
  for(int i = 0; i < grid.length; i++)
  {
    for(int j = 0; j < grid[i].length; j++)
    {
      if(grid[i][j] == 0 && i != 0 && j != 0 && i != grid.length-1 && j != grid[i].length-1)
      { //between 1 and grid - 2
        //get the 8 surrounding blocks
        if(grid[i-1][j-1] == 1 && (grid[i][j-1] == 1 || grid[i][j+1] == 1 || grid[i-1][j+1] == 1 || grid[i+1][j-1] == 1 || grid[i-1][j] == 1 || grid[i+1][j] == 1 || grid[i+1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i][j-1] == 1 && (grid[i-1][j-1] == 1 || grid[i][j+1] == 1 || grid[i-1][j+1] == 1 || grid[i+1][j-1] == 1 || grid[i-1][j] == 1 || grid[i+1][j] == 1 || grid[i+1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i+1][j-1] == 1 && (grid[i][j-1] == 1 || grid[i][j+1] == 1 || grid[i-1][j+1] == 1 || grid[i-1][j-1] == 1 || grid[i-1][j] == 1 || grid[i+1][j] == 1 || grid[i+1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i-1][j] == 1 && (grid[i][j-1] == 1 || grid[i][j+1] == 1 || grid[i-1][j+1] == 1 || grid[i+1][j-1] == 1 || grid[i-1][j-1] == 1 || grid[i+1][j] == 1 || grid[i+1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i+1][j] == 1 && (grid[i][j-1] == 1 || grid[i][j+1] == 1 || grid[i-1][j+1] == 1 || grid[i+1][j-1] == 1 || grid[i-1][j] == 1 || grid[i-1][j-1] == 1 || grid[i+1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i-1][j+1] == 1 && (grid[i][j-1] == 1 || grid[i][j+1] == 1 || grid[i-1][j-1] == 1 || grid[i+1][j-1] == 1 || grid[i-1][j] == 1 || grid[i+1][j] == 1 || grid[i+1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i][j+1] == 1 && (grid[i][j-1] == 1 || grid[i-1][j-1] == 1 || grid[i-1][j+1] == 1 || grid[i+1][j-1] == 1 || grid[i-1][j] == 1 || grid[i+1][j] == 1 || grid[i+1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i+1][j+1] == 1 && (grid[i][j-1] == 1 || grid[i][j+1] == 1 || grid[i-1][j+1] == 1 || grid[i+1][j-1] == 1 || grid[i-1][j] == 1 || grid[i+1][j] == 1 || grid[i-1][j-1] == 1))
        {
          grid[i][j] = 1;
        }
      }
      else if(grid[i][j] == 0 && i == 0 && j == 0)
      { //0,0
        if(grid[i+1][j] == 1 && (grid[i][j+1] == 1 || grid[i+1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i][j+1] == 1 && (grid[i+1][j] == 1 || grid[i+1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i+1][j+1] == 1 && (grid[i+1][j] == 1 || grid[i+1][j] == 1))
        {
          grid[i][j] = 1;
        }
      }
      else if(grid[i][j] == 0 && i == grid.length-1 && j == grid[i].length-1)
      { //Bottom Right Corner
        if(grid[i-1][j-1] == 1 && (grid[i-1][j] == 1 || grid[i][j-1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i-1][j] == 1 && (grid[i-1][j-1] == 1 || grid[i][j-1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i][j-1] == 1 && (grid[i-1][j] == 1 || grid[i-1][j-1] == 1))
        {
          grid[i][j] = 1;
        }
      }
      else if(grid[i][j] == 0 && i == 0 && j == grid[i].length-1)
      { //Top Right Corner
        if(grid[i][j-1] == 1 && (grid[i+1][j-1] == 1 || grid[i+1][j] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i+1][j-1] == 1 && (grid[i][j-1] == 1 || grid[i+1][j] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i+1][j] == 1 && (grid[i+1][j-1] == 1 || grid[i-1][j-1] == 1))
        {
          grid[i][j] = 1;
        }
      }
      else if(grid[i][j] == 0 && i == grid.length-1 && j == 0)
      { //Bottom Left Corner
        if(grid[i-1][j] == 1 && ( grid[i-1][j+1] == 1 || grid[i][j+1] == 1))
      {
        grid[i][j] = 1;
      }
      else if(grid[i-1][j+1] == 1 && ( grid[i-1][j] == 1 || grid[i][j+1] == 1))
      {
        grid[i][j] = 1;
      }
      else if(grid[i][j+1] == 1 && ( grid[i-1][j+1] == 1 || grid[i-1][j] == 1))
      {
        grid[i][j] = 1;
      }
      }
      else if(grid[i][j] == 0 && i == 0 && j < grid.length-1)
      { //Top Edge
        if(grid[0][j-1] == 1 && (grid[0][j+1] == 1 || grid[1][j-1] == 1 || grid[1][j] == 1 || grid[1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[0][j+1] == 1 && (grid[0][j-1] == 1 || grid[1][j-1] == 1 || grid[1][j] == 1 || grid[1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[1][j-1] == 1 && (grid[0][j+1] == 1 || grid[0][j-1] == 1 || grid[1][j] == 1 || grid[1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[1][j] == 1 && (grid[0][j+1] == 1 || grid[1][j-1] == 1 || grid[0][j-1] == 1 || grid[1][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[1][j+1] == 1 && (grid[0][j+1] == 1 || grid[1][j-1] == 1 || grid[1][j] == 1 || grid[0][j-1] == 1))
        {
          grid[i][j] = 1;
        }
      }
      else if(grid[i][j] == 0 && j == 0 && i < grid.length-1)
      { //Left Edge
        if(grid[i-1][0] == 1 && (grid[i+1][0] == 1 || grid[i-1][1] == 1 || grid[i][1] == 1 || grid[i+1][1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i+1][0] == 1 && (grid[i-1][0] == 1 || grid[i-1][1] == 1 || grid[i][1] == 1 || grid[i+1][1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i-1][1] == 1 && (grid[i+1][0] == 1 || grid[i-1][0] == 1 || grid[0][i] == 1 || grid[i+1][1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i][1] == 1 && (grid[i+1][0] == 1 || grid[i-1][1] == 1 || grid[i-1][0] == 1 || grid[i+1][1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[1+i][1] == 1 && (grid[i+1][0] == 1 || grid[i-1][1] == 1 || grid[i][1] == 1 || grid[i-1][0] == 1))
        {
          grid[i][j] = 1;
        }
      }
      else if(grid[i][j] == 0 && i == grid.length - 1 && j > 0)
      { //Bottom Edge
        if(grid[i-1][j-1] == 1 && (grid[i-1][j] == 1 || grid[i-1][j+1] == 1 || grid[i][j-1] == 1 || grid[i][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i-1][j] == 1 && (grid[i-1][j-1] == 1 || grid[i-1][j+1] == 1 || grid[i][j-1] == 1 || grid[i][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i-1][j+1] == 1 && (grid[i-1][j] == 1 || grid[i-1][j-1] == 1 || grid[i][j-1] == 1 || grid[i][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i][j-1] == 1 && (grid[i-1][j] == 1 || grid[i-1][j+1] == 1 || grid[i-1][j-1] == 1 || grid[i][j+1] == 1))
        {
          grid[i][j] = 1;
        }
        else if(grid[i][j+1] == 1 && (grid[i-1][j] == 1 || grid[i-1][j+1] == 1 || grid[i][j-1] == 1 || grid[i-1][j-1] == 1))
        {
          grid[i][j] = 1;
        }
      }
      else if(grid[i][j] == 0 && i > 0 && j == grid[i].length - 1)
      { //Right Edge
        if(grid[i-1][j-1] == 1 && (grid[i-1][j] == 1 || grid[i][j-1] == 1 || grid[i+1][j-1] == 1 || grid[i+1][j] == 1))
        {
         grid[i][j] = 1; 
        }
        else if(grid[i-1][j] == 1 && (grid[i-1][j-1] == 1 || grid[i][j-1] == 1 || grid[i+1][j-1] == 1 || grid[i+1][j] == 1))
        {
         grid[i][j] = 1; 
        }
        else if(grid[i][j-1] == 1 && (grid[i-1][j] == 1 || grid[i-1][j-1] == 1 || grid[i+1][j-1] == 1 || grid[i+1][j] == 1))
        {
         grid[i][j] = 1; 
        }
        else if(grid[i+1][j-1] == 1 && (grid[i-1][j] == 1 || grid[i][j-1] == 1 || grid[i-1][j-1] == 1 || grid[i+1][j] == 1))
        {
         grid[i][j] = 1; 
        }
        else if(grid[i+1][j] == 1 && (grid[i-1][j] == 1 || grid[i][j-1] == 1 || grid[i+1][j-1] == 1 || grid[i-1][j-1] == 1))
        {
         grid[i][j] = 1; 
        }
      }
    }
  }
}
