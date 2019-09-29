class particle {
  Body body;
  float r;
  PVector position = new PVector();
  color col;
  boolean delete =false;

  particle(float x, float y, float r_) {
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
    delete = true;
  }

  boolean done() {
    Vec2 pos = box2d.getBodyPixelCoord(body);

    if (pos.y > height+r*2 || delete) {
      killBody();
      return true;
    }
    return false;
  }
  void display() {

    Vec2 pos = box2d.getBodyPixelCoord(body);

    float a = body.getAngle();

    pushMatrix();
    translate(pos.x, pos.y);
    rotate(-a+PI);
    fill(#3EC6ED);
    ellipse(0, 0, r*2, r*2);
    //imageMode(CENTER);
    //image(plathoolPlatform,0,0,r*2,r*2);
    popMatrix();
  }
  void makeBody(Vec2 center, float r) {
    BodyDef bd = new BodyDef();
    bd.position.set(box2d.coordPixelsToWorld(center));
    bd.type=BodyType.DYNAMIC;
    body=box2d.world.createBody(bd);

    CircleShape cs = new CircleShape();
    cs.m_radius = box2d.scalarPixelsToWorld(r);

    FixtureDef fd = new FixtureDef();
    fd.shape=cs;
    //perguntar o que é que estes 3 parametros afetam
    fd.density = 0.5;
    fd.friction=0.5;
    fd.restitution=0.5;

    body.createFixture(fd);
    shoot();

  }
  void shoot() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    Vec2 imp =new Vec2(mouseX-pos.x, pos.y-mouseY);
    imp.normalize();
    imp.mulLocal(2);
    body.applyLinearImpulse(imp, body.getWorldCenter(), true);
  }
}