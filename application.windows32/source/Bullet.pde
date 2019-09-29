class Bullet { //extensao de police 
  PVector position = new PVector(); //
  PVector target;// pos do hool
  PVector gun;  // pos do tower defense
  float dirX, dirY; 

  Bullet(float x, float y, float xx, float yy) { //adicionar range das bullets 
    position.x=x; 
    position.y=y;
    dirX=xx;
    dirY=yy;
    gun = new PVector(position.x, position.y);
    target = new PVector(dirX, dirY);
  }

  void display() {
    //target = new PVector(dirX, dirY);
    fill(#FF0303);
    imageMode(CENTER);
    image(rock,position.x,position.y);
    //ellipse(position.x, position.y, 10, 10); //bullet
    PVector velocity = PVector.sub(target, gun); //compute the difference vector (start to end) = direction 
    position.add(new PVector(velocity.x/2, velocity.y/2)); //add velocidade a nova posição
  }
}