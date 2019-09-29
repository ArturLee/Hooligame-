class Button {
  int rectSize;     // Diameter of rect
  int highSize;   //altura dos rectangulos
  float x, y, w, h;  
  boolean selected;
  int colo;
  Button(float _x, float _y) {
    x= _x;
    y= _y;
    rectSize =217;
    highSize = 128;
    w=rectSize;
    h=highSize;
    colo=#0FFF79;
  }
  void display() { 
    /*stroke(0);
     noFill();
     rectMode(CORNER);
     rect(x, y, w, h);*/
    noFill();
    if (Pressed()) {
      stroke (255, 0, 120);
      rect(x, y, w, h);
    } else {    
      /*stroke(0);
       noFill();
       rect(x, y, w, h);*/
    }
    if (selected) {
      //fill(0,255,120);
      stroke(colo);
      rectMode(CORNER);
      rect(x, y, w, h);
    }
  }
  boolean Pressed() {
    if (mouseX >= x & mouseX <=x+ rectSize & mouseY >= y & mouseY <= y+highSize) {
      selected =true;
      return true;
    } else {
      selected = false;
      return false;
    }
  }
}