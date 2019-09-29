//os hooligans do Side view
class HooligansP {
  int hoolhealth=100;
  boolean remove;
  boolean wasHit;
  boolean delete = false;
  boolean vaiDisparar;
  int BottleInterval;  

  Body body;
  float speed = 5;
  float w, h, _x, _y ;
  int r=40;

  HooligansP(float x, float y) {
    makeBody(new Vec2(x, y), r);
    body.setUserData(this);
    remove=false;

    // This function removes the particle from the box2d world
    //println(vaiDisparar);
    vaiDisparar = random(0, 100) <= 50;
  }

  void delete() {
    hooligansp.remove(this);
    box2d.destroyBody(body);
    miniGameKilled++;
  }

  void kill() {
    hoolhealth-=1;
  }

  boolean contains(float x, float y) { //just copied to see if it works
    Vec2 worldPoint = box2d.coordPixelsToWorld(x, y);
    Fixture f = body.getFixtureList();
    boolean inside = f.testPoint(worldPoint);
    return inside;
  }
  boolean done() {
    // Let's find the screen position of the particle
    Vec2 pos = box2d.getBodyPixelCoord(body);
    // Is it off the bottom of the screen?
    if (pos.y > width+100 || delete) {
      return true;
    }
    return false;
  }
  void display() {

    Vec2 pos = box2d.getBodyPixelCoord(body);
    // println(pos);
    int change = millis()-walk;
    if (change<=500) {
      pushMatrix();
      translate(pos.x, pos.y);
      rotate(0);
      fill(#FFFFFF);
      imageMode(CENTER);
      image(minihoolL, 0, 0, r*2, r*2);
      noFill();
      popMatrix();
    }
    if (change<=1000) { 
      pushMatrix();
      translate(pos.x, pos.y);
      rotate(0);
      fill(#FFFFFF);
      imageMode(CENTER);
      image(minihoolR, 0, 0, r*2, r*2);
      noFill();
      popMatrix();
    }
    walk=millis();
    //and then reset the timer
    if (hoolhealth <=0) {  //qnd hool fica sem vida
      delete();
      //credits +=20;
      //coins.add(this).display; //adicionar moeda no floor
    }

    int atirar = millis() - BottleInterval;
    if (atirar >= 3000) {
      BottleInterval = millis();
      if (vaiDisparar) {
        disparar();
      } else {
        println("ok");
      }
    }
  }
  void destroyBody() {
    box2d.destroyBody(body);
  }
  /*  void move(){
   Vec2 speedVec = new Vec2(0, 0);
   speedVec.x += speed;
   Vec2 vel = body.getLinearVelocity();
   Vec2 force = new Vec2(speedVec.x-vel.x, speedVec.y-vel.y); 
   body.applyLinearImpulse(force, body.getWorldCenter(), true);
   
   }*/
  void makeBody(Vec2 center, float r) {
    // Define a body
    BodyDef bd = new BodyDef();
    // Set its position
    bd.position.set(box2d.coordPixelsToWorld(center));
    bd.type = BodyType.DYNAMIC;
    body = box2d.createBody(bd);

    // Make the body's shape a circle
    CircleShape cs = new CircleShape();
    cs.m_radius = box2d.scalarPixelsToWorld(r);

    FixtureDef fd = new FixtureDef();
    fd.shape = cs;
    // Parameters that affect physics
    fd.density = 1;
    fd.friction = 0.01;
    fd.restitution = 0.3;

    // Attach fixture to body
    body.createFixture(fd);

    body.setLinearVelocity(new Vec2(20, 0));
  }

  void disparar() {


    Vec2 vanPos = box.getPos();
    Vec2 pos = box2d.getBodyPixelCoord(body);
    float dist = (pos.x - vanPos.x)/5 ;
    float angle = PI / 4;
    float grav = random(10,20);
    float vel = sqrt(abs((dist * grav) / sin(2*angle)));
    float velocidadeInicialX = cos(angle) * vel;
    float velocidadeInicialY = sin(angle) * vel;

    //println("harambe");  
    //FALTA FAZER:
    //criar o objecto da bala
    //aplicar como velocidade inicial o vec velocidadeInicial
    Bottle b = new Bottle(pos.x+50, pos.y-40, 40);  
    bottle.add(b);
    b.body.setLinearVelocity(new Vec2(velocidadeInicialX, velocidadeInicialY));
  }
}