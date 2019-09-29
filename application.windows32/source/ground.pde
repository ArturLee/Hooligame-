//foi feito por ti 
class Ground {
  float x;
  float y;
  float w;
  float h;

  Body b;

  Ground(float x_, float y_, float w_, float h_) {
    x=x_;
    y=y_;
    w=w_;
    h=h_;

    //defenir o polygon
    PolygonShape sd = new PolygonShape();
    //descobrir as coordenadas do box2d
    float box2dW = box2d.scalarPixelsToWorld(w/2); //continuo sem perceber o que este w/2
    float box2dH = box2d.scalarPixelsToWorld(h/2); //same // isto é que o universo do jogo começa no meio em vez no canto ass arturlee

    sd.setAsBox(box2dW, box2dH);

    //criar o body
    BodyDef bd = new BodyDef();
    bd.type = BodyType.STATIC;
    bd.position.set(box2d.coordPixelsToWorld(x, y));
    b=box2d.createBody(bd);

    //juntar o body á shape atraves da fixture
    b.createFixture(sd, 1); //exprimentar mudar o 1 para outro valor a ver o que acontece
    // se nada acontecer perguntar para que serve (penso que é a density)
  }

  void display() {
    //fill(255);
    noFill();
    rectMode(CENTER); // EXPRIMENTAR RETIRAR A VER O QUE ACONTECE
    rect(x, y, w, h);
  }
}