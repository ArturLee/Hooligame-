class Hooligan_7 extends Hooligans {
  Hooligan_7() {
    score = 10; 
    imageToDraw = hooligan1;
    imageToDrawa = hooligan1a;
    health = 200;
    imageRotate = PI/2;
    l=11;
    c=11;
    speed=1;
    float p=random(14);
    if (p<=1) {
      pathToFollow = path40;
      _x=586;
      _y=185;
    } else if (p<=2) {
      pathToFollow = path41;
      _x=586;
      _y=185;
    } else if (p<=3) {
      pathToFollow = path42;
      _x=586;
      _y=185;
    } else if (p<=4) {
      pathToFollow = path43;
      _x=586;
      _y=185;
    } else if (p<=5) {
      pathToFollow = path44;
      _x=205;
      _y=192;
    } else if (p<=6) {
      pathToFollow = path45;
      _x=205;
      _y=192;
    } else if (p<=7) {
      pathToFollow = path46;
      _x=205;
      _y=192;
    } else if (p<=8) {
      pathToFollow = path47;
      _x=205;
      _y=192;
    } else if (p<=9) {
      pathToFollow = path48;
      _x=100;
      _y=507;
    } else if (p<=10) {
      pathToFollow = path49;
      _x=100;
      _y=507;
    } else if (p<=11) {
      pathToFollow = path50;
      _x=100;
      _y=507;
    } else if (p<=12) {
      pathToFollow = path51;
      _x=63;
      _y=639;
    } else if (p<=13) {
      pathToFollow = path52;
      _x=64;
      _y=639;
    } else if (p<=14) {
      pathToFollow = path53;
      _x=489;
      _y=642;
    }
  }
}