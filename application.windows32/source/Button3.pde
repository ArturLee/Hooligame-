class Button3 extends Button {

  Button3(float _x, float _y) { //for exit Game over, credits, settings
    super(_x, _y);
    x= _x;
    y= _y;
    rectSize=50;
    highSize=50;
    w=rectSize;
    h=highSize;
    colo=#D8D8D8;
  }
}