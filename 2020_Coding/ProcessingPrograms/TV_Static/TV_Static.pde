//Draw the snow from the TV
int mult = 1;
void setup()
{
  //fullScreen();
   size(400,400);
}

void draw()
{
  for (int i = 0; i < width/mult; i++)
  {
    for (int j = 0; j < height/mult; j++)
    {
      drawStatic(i, j);
    }
  }
  
}

void drawStatic(int i, int j)
{
  noStroke();
  fill(random(255));
  rect(i*mult, j*mult, mult, mult);
}
