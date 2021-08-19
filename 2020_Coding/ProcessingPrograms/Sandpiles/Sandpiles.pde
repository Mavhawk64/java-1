int [][] sandpiles;
color col;
int sandAmt;
void setup()
{
  size(400, 400);
  sandpiles = new int[width][height];
  sandAmt = 4;
}

void render()
{
  loadPixels();
  sandpiles[width/2][height/2] = sandAmt;
  for(int i = 0; i < width; i++)
  {
    for(int j = 0; j < height; j++)
    {
      int num = sandpiles[i][j];
      switch(num)
      {
        case 0: 
          col = #9bd7d5;
          break;
        case 1:
          col = #129793;
          break;
        case 2:
          col = #2b374b;
          break;
        case 3:
          col = #f9bd2e;
          break;
        default:
          col = #f88379;
          break;
      }
      pixels[i+j*width] = col;
    }
  }
  updatePixels();
}

void check4()
{
  int [][] nextpiles = sandpiles;
  
  if(sandpiles[width/2][height/2] >= 4)
  {
    nextpiles[width/2][height/2] -= 4;
    nextpiles[width/2+1][height/2]+=1;
    nextpiles[width/2-1][height/2]+=1;
    nextpiles[width/2][height/2+1]+=1;
    nextpiles[width/2][height/2-1]+=1;
  }
  
  
  //Edges Checker
  //if(sandpiles[0][0] >= 4)
  //{
  //  nextpiles[1][0] += 1;
  //  nextpiles[0][1] += 1;
  //  nextpiles[0][0] -= 4;
  //}
  //else
  //{
  //  nextpiles[0][0] = nextpiles[0][0];
  //}
  
  //if(sandpiles[width-1][height-1] >= 4)
  //{
  //  nextpiles[width-2][height-1] += 1;
  //  nextpiles[width-1][height-2] += 1;
  //  nextpiles[width-1][height-1] -= 4;
  //}
  
  //for(int i = 1; i < width; i++)
  //{
  //if(sandpiles[i][0] >= 4)
  //{
  //  nextpiles[i-1][0] += 1;
  //  nextpiles[i+1][0] += 1;
  //  nextpiles[i][1] += 1;
  //  nextpiles[i][0] -= 4;
  //}
  //}
  
  //for(int j = 1; j < height; j++)
  //{
  //  if(sandpiles[0][j] >= 4)
  //  {
  //    nextpiles[0][j-1] += 1;
  //    nextpiles[0][j+1] += 1;
  //    nextpiles[1][j] += 1;
  //    nextpiles[0][j] -= 4;
  //  }
  //}
  ////Main Checker
  //for(int i = 1; i < width-1; i++)
  //{
  //  for(int j = 1; j < height-1; j++)
  //  {
  //    if(sandpiles[i][j] >= 4)
  //    {
  //      nextpiles[i+1][j] += 1;
  //      nextpiles[i-1][j] += 1;
  //      nextpiles[i][j+1] += 1;
  //      nextpiles[i][j-1] += 1;
  //      nextpiles[i][j] -= 4;
  //    }
  //  }
  //}
  sandpiles = nextpiles;
}

void draw()
{
  frameRate(1);
  render();
  check4();
}
