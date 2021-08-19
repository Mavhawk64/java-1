function setup() {
  createCanvas(windowWidth, 400);
}


let arry = []; //an array of y values
let arrx = []; //an array of x values

function draw() {
  background(55);
  noLoop();
}
var smallX = 0;
var smallY = 0;
var bigX = 0;
var bigY = 0;
var b = 0;
function getBiggestNum()
{
  for(var i = 0; i < arrx.length; i++)
  {
    if(bigX < arrx[i])
    {
      bigX = arrx[i];
    }
    if(smallX > arrx[i])
    {
      smallX = arrx[i];
    }
  }
  for(var i = 0; i < arry.length; i++)
  {
    if(bigY < arry[i])
    {
      bigY = arry[i];
    }
    if(smallY > arry[i])
    {
      smallY = arry[i];
    }
  }
}
var n1;
function drawEllipses()
{
  //alert("N1: " + n1);
  background(55);
  noStroke();
  for(var i = 0; i < arry.length; i++)
  {
    var x = map(arrx[i], smallX, bigX, 0, width);
    var y = height-map(arry[i], smallY, bigY, 0, height);
    ellipse(x, y, 7);
    //stroke(255);
    if(arrx.length <= 26)
    {
      fill(255);
      text("("+nfc(arrx[i],2)+","+nfc(arry[i],2)+")", x, 10);
    }
  }
  drawLines();
}


function drawLines()
{
  stroke(155);
  var px = map(arrx[0], smallX, bigX, 0, width);
  var py = height-map(arry[0], smallY, bigY, 0, height);
  for(var i = 0; i < arry.length; i++)
  {
    var x = map(arrx[i], smallX, bigX, 0, width);
    var y = height-map(arry[i], smallY, bigY, 0, height);
    line(px, py, x, y);
    px = x;
    py = y;
  }
}

function isClicked()
{
  smallX = 0;
  smallY = 0;
  bigX = 0;
  bigY = 0;
  while(arrx.length > 0)
  {
    arrx.pop();
  }
  while(arry.length > 0)
  {
    arry.pop();
  }
  mainStringArgs();
}

function mainStringArgs()
{
  var f = document.getElementById('f').value; //string
  var h = parseFloat(document.getElementById('h').value); //double
  var y0s = document.getElementById('y0s').value; //string
  b = parseFloat(document.getElementById('b').value); //double
  var x0 = parseFloat(y0s.substring(2,y0s.indexOf(")"))); //double
  var y0 = parseFloat(y0s.substring(y0s.indexOf("=") + 1, y0s.length)); //Double
  //alert("F: " + f);
  //alert("h: " + h);
  //alert("y0s: " + y0s);
  //alert("b: " + b);
  //alert("x0: " + x0);
  //alert("y0: " + y0);
  arry.push(y0);
  var count = 0;
  //alert(f);
  f = f.substring(f.indexOf("=") + 1, f.length);
  //alert(f);
  var yn = euMe(f, h, x0, y0, b, count, b-x0);
  arry.push(yn);
  for(var i = 0; i < arry.length; i++)
  {
    arrx.push(h*i+x0);
  }
  //alert("y: [" + arry + "]");
  //alert("x: [" + arrx + "]");
  console.log("x: " + arrx);
  console.log("y: " + arry);
  getBiggestNum();
  drawEllipses();
}







function euMe(f, h, x, y, b, c, bd)
{
  c++;
  var n = bd / h;
  n1 = n;
  var newF = f;
  newF = replace(newF, 'x', x);
  //alert(newF);
  newF = replace(newF, 'y', y);
  //alert(newF);
  if(newF.includes('^'))
  {
    newF = carrotAway(newF);
  }
  //alert(newF);
  //fn = eval(newF);
  fn = parseFloat(eval(newF));
  //alert("FN " + fn);
  y = parseFloat(y);
  x = parseFloat(x);
  var yn = y + h * fn;
  x+=parseFloat(h);
  y=parseFloat(yn);
  if(c != n)
  {
    arry.push(yn);
    return euMe(f, h, x, y, b, c, bd);
  }
  else {
    return yn;
  }
}





function replace(f, get, take)
{
  var g = f.split('');
  var t = "("+take+")";
  let count = [];
  let newF = f;
  for(var i = 0; i < g.length; i++)
  {
    if(g[i] == get)
    {
      count.push(i);
    }
  }
  newF = newF.substring(0, (count[0]))  + t + newF.substring((count[0]) + 1, newF.length);
  count.shift();
  if(count.length >= 1)
  {
    return replace(newF, get, take);
  }
  return newF;
}





function carrotAway(f)
{
  //alert("F: " + f);
  var base = 0;
  var newF = f;
  var ind = 0;
  var ind2 = 0;
  //2 + (1.2)^2 - 3*y
  //(1.3) + (1.2)^2 + 3*(1.2)
  if(f.substring(f.indexOf("^") - 1,f.indexOf("^")) == ')')
  {
    //alert("I'm in the first if statement of the base!");
    var car = f.indexOf("^");
    //alert("Car: " + car);
    var par = car - 1;
    let arr = (f.substring(0, par)).split('');
    var parf = 0;
    arr.reverse();
    for(var i = 0; i < arr.length; i++)
    {
      if(arr[i] == '(')
      {
        parf = i;
        break;
      }
    }

    base = f.substring(par-parf, par);
    newF = f.substring(0, par-parf-1);
  }
  else
  {
    //alert("I'm in the else statement of the base!");
    //2 + 3^32
    //334^2 + 10*(1.12)
    if((f.substring(0, f.indexOf("^"))).includes(" "))
    {
      //alert("I'm in the if space statement under the else statement of the base!");
      let arr = (f.substring(0, f.indexOf("^"))).split('');
      arr.reverse();
      var s = 0;
      for(var i = 0; i < arr.length; i++)
      {
        if(arr[i] == ' ')
        {
          s = i;
          break;
        }
      }
      ind = s+1;
      base = f.substring(f.indexOf("^") - ind, f.indexOf("^"));
      newF = f.substring(0, f.indexOf(base));
    }
    else {
      //alert("I'm in the else-else statement of the base!");
      base = f.substring(0, f.indexOf("^"));
      newF = "";
    }
  }




  //Now we have to find the exponent
  //alert("(Right under the comment) " + newF);
  newF = newF + " Math.pow("+base+",";
  //alert("Hmm... " + newF);
  var exp = 1;
  if(f.substring(f.indexOf("^")+1,f.indexOf("^")+2) == '(')
  {
    //alert("I'm in the if statement of the exp!");
    exp = f.substring(f.indexOf("^")+2, f.indexOf(")", f.indexOf("^")));
    newF = newF + exp+") " + f.substring(f.indexOf(")", f.indexOf("^"))+1, f.length);
    //alert(newF);
  }
  else {
    //alert("I'm in the else statement of the exp!");
    if((f.substring(f.indexOf("^"), f.length)).includes(' '))
    {
      //alert("I'm in the else-if statement of the exp!");
      exp = f.substring(f.indexOf("^")+1, f.indexOf(" ", f.indexOf("^")));
      newF = newF + exp+") " + f.substring(f.indexOf(" ", f.indexOf("^")),f.length);
    }
    else {
      //alert("I'm in the else-else statement of the exp!");
      exp = f.substring(f.indexOf("^")+1, f.length);
      newF = newF + exp+") " + " ";
    }
  }

  //alert(newF);
  if(newF.includes("^"))
  {
    return carrotAway(newF);
  }
  return newF;
}
