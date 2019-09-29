class Bottle {
  Body body;
  float r;
  PVector position = new PVector();
  color col;
  boolean delete =false;

  Bottle(float x, float y, float r_) {
    position.x=x;
    position.y=y;
    r=r_;
    makeBody(new Vec2(x, y), r);
    body.setUserData(this);
  }
  void killBody() {
    box2d.destroyBody(body);
  }
  void delete() {
    delete=true;
  }

  boolean done() {
    Vec2 pos = box2d.getBodyPixelCoord(body);

    if (pos.y < 0 || delete) {
      killBody();
      return true;
    }
    return false;
  }

  boolean done2() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    if (pos.x > width+r*2 || delete) {
      killBody();
      return true;
    }
    return false;
  }


  void display() {

    Vec2 pos = box2d.getBodyPixelCoord(body);

    float a = body.getAngle();
    //println(pos.x,pos.y);
    pushMatrix();
    translate(pos.x, pos.y);
    rotate(a);
    fill(255);
    imageMode(CENTER);
    image(Bottle,2,2);
    popMatrix();
  }
  void destroyBody() {
    box2d.destroyBody(body);
  }
  void makeBody(Vec2 center, float r) {
    BodyDef bd = new BodyDef();
    bd.position.set(box2d.coordPixelsToWorld(center));
    bd.type=BodyType.DYNAMIC;
    body=box2d.world.createBody(bd);

    PolygonShape ps = new PolygonShape();
    float w = box2d.scalarPixelsToWorld(20);
    FixtureDef fd = new FixtureDef();
    ps.setAsBox(w, w);
    fd.shape=ps;
    //perguntar o que é que estes 3 parametros afetam
    fd.density = 1;
    fd.friction=0.5;
    fd.restitution=0.2;
    body.createFixture(fd);
  }
}