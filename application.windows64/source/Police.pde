class Police {
  Hooligans nearestHooligan;
  PVector police = new PVector();
  float xx, yy;
  int range =88;
  int size =50;
  float ang=0.0; 
  int lastShotTime;
  int inte;
  PImage policeImage;

  float ocupationRadius;
  

  Police (float x, float y) { //posição da torre
    police.x = x;
    police.y = y;
    inte=0;
    bullet = new ArrayList();
    damage = 50;
    ocupationRadius = 20;
    policeImage=Police1;
  }
  void display() {
    fill(50);
    //rectMode(CENTER);
    //rect(police.x, police.y, size, size+25);
    pushMatrix();
    translate(police.x, police.y);
    rotate(ang+2*PI+PI/2);
    //rotate(ang+PI);
    imageMode(CENTER);
    image(policeImage, 0, 0);
    //fill(153, 204, 0);
    //ellipse(size/4, 0, size/2, size/2);
    popMatrix();
    for (int i=0; i<hooligans.size(); i++) {
      if (dist(hooligans.get(i)._x, hooligans.get(i)._y, police.x, police.y) < range) { //distancia de dois pontos (hool x, hool y,gun x,guyn y)<alcançe
        //ang=atan2(police.y-((hooligans.get(0))._y),police.x-((hooligans.get(0))._x))-180; //ask teacher....
        ang = atan2(((hooligans.get(i))._y)-police.y, ((hooligans.get(i))._x)-police.x); //atan2(y1-y2,x1-x2) da nos o angle em radiano
        xx = (40*cos(ang)) + police.x; //x angulo de disparo
        yy = (40*sin(ang)) + police.y; //y angulo de disparo
        break;
      }
    }
  }
  
  boolean isOccupied(float x, float y){
    return dist(police.x, police.y, x, y) < ocupationRadius;  
  }

  void shoot () {
    if (hooligans.size() == 0) {
      nearestHooligan = null; //não existem hooligans portanto o nearesHooligan é nulo.
    } else {
      float nearestDist = range; //este valor vai ter a distância menor encontrada até agora..
      for (int h=0; h<hooligans.size(); h++) { //um loop que percorre todos os hooligans
        float d = dist(hooligans.get(h)._x, hooligans.get(h)._y, police.x, police.y); //a distancia deste..
        if (d < nearestDist) { //se for menor do que a menor distância encontrada..
          nearestDist = d; //guardamos esse valor na variável nearestDist
          nearestHooligan = hooligans.get(h); //e guardamos este hooligan na variável nearestHooligan
          int time = millis() - lastShotTime; //defenir tempo
          if (time>= inte) {
            bullet.add(new Bullet(police.x, police.y, xx, yy));
            lastShotTime = millis();
          }
        }
      }
    }
  }
}