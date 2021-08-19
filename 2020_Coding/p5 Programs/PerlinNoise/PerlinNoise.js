var xOff = 0;
var xOff2 = 10000;
var inc = 0.01;
var start = 0;
function setup() {
  createCanvas(windowWidth, windowHeight);
}

function draw() {
  background(51);
  //frameRate(5);
  beginShape();
  stroke(255);
  noFill();
  xOff = start;
  for ( var x = 0; x < width; x++)
  {
    stroke(255);
    vertex(x, noise(xOff)*height);
    xOff+=inc;
  }
  endShape();
  start+=inc;
  //noLoop();
  // var x = map(noise(xOff), 0, 1, 0, width);
  // var y = map(noise(xOff2), 0, 1, 0, height);
  // xOff+=0.02;
  // xOff2+=0.02;
  //ellipse(x, y, 24, 24);
}
