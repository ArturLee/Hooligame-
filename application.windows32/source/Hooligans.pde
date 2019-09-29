class Hooligans {

  //int health=100;
  float _x, _y;
  int pathIndex;
  PVector vel = new PVector();
  int health=100;
  int score;
  ArrayList<PVector> pathToFollow;
  PImage imageToDraw;
  PImage imageToDrawa;
  float imageRotate;
  int l,c;
  boolean remove;
  float speed;

  Hooligans() {
    score = 1;
    pathToFollow = path;
    imageToDraw = hooligan1;
    _x=49;
    _y=318;
    imageRotate = PI/2;
    l=40;
    c=80;
    remove = false;
    speed =1; 
  }void damage() {
    health -=damage; //cada bullet que colide com hool tira 1/100 de vida
  }
  void display() {
    int change = millis()-walk;
    if (change<=500){
    float rotation = atan2(vel.y, vel.x);
    pushMatrix();
    translate(_x, _y);
    rotate(rotation);
    imageMode(CENTER);
    rotate(imageRotate);
    image(imageToDraw, 0, 0, l, c);
    popMatrix();
    }if (change<=1000){
    float rotation = atan2(vel.y, vel.x);
    pushMatrix();
    translate(_x, _y);
    rotate(rotation);
    imageMode(CENTER);
    rotate(imageRotate);
    image(imageToDrawa, 0, 0, l, c);
    popMatrix();
    }walk=millis();

    if (health <= 0) {  //qnd hool fica sem vida
      remove=true; 
      credits+=score;
      //coins.add(this).display; //adicionar moeda no floor
    }
  }
  void move () {
    vel = PVector.sub(pathToFollow.get(pathIndex), new PVector(_x, _y));
    vel.normalize();
    vel.mult(speed);
    _x += vel.x;
    _y += vel.y;

    float d = dist(_x, _y, pathToFollow.get(pathIndex).x, pathToFollow.get(pathIndex).y);
    if (d < 3) {
      pathIndex++;
      if (pathIndex >= pathToFollow.size()) {
        hooligans.remove(this);
        health_s-=10;
        pathIndex = 0;
     }
    }
  } 
}