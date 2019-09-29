class Hooligan_2 extends Hooligans {
  Hooligan_2() {
    score = 5; 

    imageToDraw = hooligan2;
    imageToDrawa = hooligan2a;
    health = 200;

    imageRotate=PI/2;
    l=15;
    c=15;
    speed=0.7;
    float p=random(14);
    if (p<=1) {
      pathToFollow = path;
      _x=422;
      _y=579;
    } else if (p<=2) {
      pathToFollow = path2;
      _x=107;
      _y=686;
    } else if (p<=3) {
      pathToFollow= path3;
      _x=884;
      _y=701;
    } else if (p<=4) {
      pathToFollow = path4;
      _x=422;
      _y=579;
    } else if (p<=5) {
      pathToFollow = path5;
      _x=107;
      _y=686;
    } else if (p<=6) {
      pathToFollow = path6;
      _x=884;
      _y=701;
    }else if (p<=7) {
      pathToFollow = path7;
      _x=107;
      _y=686;
    }else if (p<=8) {
      pathToFollow = path8;
      _x=422;
      _y=579;
    }else if (p<=9) {
      pathToFollow = path9;
      _x=107;
      _y=686;
    }else if (p<=10) {
      pathToFollow = path10;
      _x=884;
      _y=701;
    }else if (p<=11) {
      pathToFollow = path11;
      _x=422;
      _y=579;
    }else if (p<=12) {
      pathToFollow = path12;
      _x=107;
      _y=686;
    }else if (p<=13) {
      pathToFollow = path13;
      _x=884;
      _y=701;
    }else if (p<=14) {
      pathToFollow = path14;
      _x=107;
      _y=686;
    }
  }
}