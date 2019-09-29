class Box {
  int copHealth=100;
  boolean remove;
  boolean wasHit;
  Body body;
  float speed = 5;
  float R;
  float w, h ;
  Box(float x, float y, float _w, float _h) {
    BodyDef def = new BodyDef();
    R = 20;
    def.type = BodyType.STATIC;
    w = _w; 
    h = _h;
    def.position = box2d.coordPixelsToWorld(x, y);
    body = box2d.createBody(def);

    PolygonShape shape = new PolygonShape();
    float box2dW = box2d.scalarPixelsToWorld(w/2);
    float box2dH = box2d.scalarPixelsToWorld(h/2);
    shape.setAsBox(box2dW, box2dH);
    body.createFixture(shape, 1);
    body.setUserData(this);
  }
  void display() {
        if (copHealth<=0) {
      imageMode(CORNER);
      image(healt0, 980, -35);
    } else if (copHealth<=10) {
      imageMode(CORNER);
      image(healt10, 980, -35);
    } else if (copHealth<=20) {
      imageMode(CORNER);
      image(healt20, 980, -35);
    } else if (copHealth<=30) {
      imageMode(CORNER);
      image(healt30, 980, -35);
    } else if (copHealth<=40) {
      imageMode(CORNER);
      image(healt40, 980, -35);
    } else if (copHealth<=50) {
      imageMode(CORNER);
      image(healt50, 980, -35);
    } else if (copHealth<=60) {
      imageMode(CORNER);
      image(healt60, 980, -35);
    } else if (copHealth<=70) {
      imageMode(CORNER);
      image(healt70, 980, -35);
    } else if (copHealth<=80) {
      imageMode(CORNER);
      image(healt80, 980, -35);
    } else if (copHealth<=90) {
      imageMode(CORNER);
      image(healt90, 980, -35);
    } else if (copHealth<=100) {
      imageMode(CORNER);
      image(healt100, 980, -35);
    }
    text("Health:", 900, 20);
    stroke(0);
    Vec2 pos = box2d.getBodyPixelCoord(body);
    float angle = -body.getAngle();
    pushMatrix();
    translate(pos.x, pos.y);
    rotate(angle);
    imageMode(CENTER);
    image(Cop,1,1);
    noFill();
    popMatrix();
    if (wasHit ==true) {
      hit();
    }
    /*if (copHealth <=0) {  
      //delete();
      remove = true;
    }*/
  } 
  void hit() {
    println("LOLOLOLOLOLDODLOasdbhasidgfaisfasdfasdfasdfasdfjhvnvejbhdge");
    copHealth -= 15;
  }
  boolean contains(float x, float y) { //just copied to see if it works
    Vec2 worldPoint = box2d.coordPixelsToWorld(x, y);
    Fixture f = body.getFixtureList();
    boolean inside = f.testPoint(worldPoint);
    return inside;
  }

  
  /*void delete() {
    gameState= State.Level_1;
    for (int i=particles.size()-1; i>=0; i--) {
      particles.get(i).killBody();
      particles.remove(i);
    }

    for (int i=0; i<hooligansp.size(); i++) {
      hooligansp.get(i).destroyBody();
      hooligansp.remove(i);
    }
    for (int i=0; i<miniGameKilled; i++) {
      if (i >= hooligans.size()) {
        break;
      }
      hooligans.get(i).remove = true;
    }
    
  }*/

  void move() {
    Vec2 pos = box2d.getBodyPixelCoord(body); // only for moving object
    if (key=='a') {
      body.setLinearVelocity(new Vec2(-10, 0));
    } else if (key=='d') {
      body.setLinearVelocity(new Vec2(10, 0));
    } else if (key=='w') {
      body.setLinearVelocity(new Vec2(0, 10));
    }
  }
  void destroyBody() {
    box2d.destroyBody(body);
  }

  Vec2 getPos() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    return pos;
  }
}