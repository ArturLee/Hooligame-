//isto sao as colisoes para o BOX2D

// The Nature of Code
// <http://www.shiffman.net/teaching/nature>
// Spring 2010
// Box2DProcessing example

// ContactListener to listen for collisions!

import org.jbox2d.callbacks.ContactImpulse;
import org.jbox2d.callbacks.ContactListener;
import org.jbox2d.collision.Manifold;
import org.jbox2d.dynamics.contacts.Contact;

class CustomListener implements ContactListener {
  CustomListener() {
  }

  // This function is called when a new collision occurs
  void beginContact(Contact cp) {
    // Get both fixtures
    Fixture f1 = cp.getFixtureA();
    Fixture f2 = cp.getFixtureB();

    // Get both bodies
    Body b1 = f1.getBody();
    Body b2 = f2.getBody();

    // Get our objects that reference these bodies
    Object o1 = b1.getUserData();
    Object o2 = b2.getUserData();


    //  BEGIN PROFESSOR RUI
    //pode ser uma colisão entre objectos que não tenham o user data definido. Nesses casos não queremos 
    //detectar colisões, pelo que fazemos logo return
    if (o1 == null || o2 == null) { 
      return;
    }
    //println(o1.getClass());
    //println(o3.getClass());
    //este 'if' detecta se o primeiro objecto é uma particle e o segundo um Hooligan
    if (o1.getClass() == particle.class && o2.getClass() == HooligansP.class) {
      particle p = (particle)o1; //fazemos um 'cast' do 'o1' para a sua class particle
      HooligansP h = (HooligansP)o2; //fazemos um 'cast' do 'o2' para a sua class Hooligans
      p.delete(); //chamamos a função delete da particle
      h.kill(); //chamamos a função delete do hooligan
      hooligansp.remove(this);
      //o 'else if' a seguir verifica o caso de o Box2D detectar a colisão com os objectos na ordem contrária
    } else if (o2.getClass() == particle.class && o1.getClass() == HooligansP.class) {
      particle p = (particle)o2; //fazemos um 'cast' do 'o2' para a sua class particle
      HooligansP h = (HooligansP)o1; //fazemos um 'cast' do 'o1' para a sua class hooligan
      p.delete(); //chamamos a função delete da particle
      h.kill(); //chamamos a função delete do hooligan

      //o 'else if' verifica o caso em que o o1 é uma particula mas o o2 não é um hooligan
      //por exemplo se a particula colidiu com o chão ou outro objecto, também querem apagar a particula
    } else if (o1.getClass() == particle.class) {
      particle p = (particle)o1;
      p.delete();

      //o 'else if' verifica o caso em que o o2 é uma particula mas o o1 não é um hooligan
      //por exemplo se a particula colidiu com o chão ou outro objecto, também querem apagar a particula
      /*  } else if (o2.getClass() == particle.class) {
       particle p = (particle)o2;
       p.delete();*/
    } else if (o1.getClass() == Bottle.class && o2.getClass() == Box.class) {
      Bottle b = (Bottle)o1; //fazemos um 'cast' do 'o1' para a sua class garrafa
      Box bx = (Box)o2; //fazemos um 'cast' do 'o2' para a sua class COPVAN
      b.delete();//chamamos a função delete da garrafa
      bx.hit();
      //bottle.remove(this);
      //println("987987987987");
    } else if (o2.getClass() == Bottle.class && o1.getClass() == Box.class) {
      Bottle b = (Bottle)o2; //fazemos um 'cast' do 'o2' para a sua class garrafa
      Box bx = (Box)o1; //fazemos um 'cast' do 'o1' para a sua class CopVan
      b.delete(); //chamamos a função delete da garrafa
      bx.hit();
      //println("654654654654");
      //bottle.remove(this);
    } 
    
    
   // println("collision " + o1.getClass() + "   +" + o2.getClass());
    
    
    /*else if (o1.getClass() == Bottle.class) {
      Bottle b = (Bottle)o1;
      b.delete();
      println("321321321");
    } else if (o2.getClass() == Bottle.class) {
      Bottle b = (Bottle)o2;
      b.delete();
      println("dasdasdasd");
    } else if (o1.getClass() == Box.class) {
      Box b = (Box)o1;
      b.hit();
      println("321321321");
    } else if (o2.getClass() == Box.class) {
      Box b = (Box)o2;
      b.hit();
      println("dasdasdasd");
    } */
    //chamamos a função delete do bottle
    // END PROF RUI


    // If object 1 is a Box, then object 2 must be a particle
    // Note we are ignoring particle on particle collisions
    /*  if (o1.getClass() == particle.class) { //collisions and control interface example 
     Hooligans p = (Hooligans) o2;
     p.delete();
     
     } 
     // If object 2 is a Box, then object 1 must be a particle
     else if (o2.getClass() == particle.class) { 
     Hooligans p = (Hooligans) o1;
     p.delete();
     }*/
  }

  /*void beginContact2(Contact cp) {
   // Get both fixtures
   Fixture f1 = cp.getFixtureA();
   Fixture f2 = cp.getFixtureB();
   // Get both bodies
   Body b1 = f1.getBody();
   Body b2 = f2.getBody();
   // Get our objects that reference these bodies
   Object o1 = b1.getUserData();
   Object o2 = b2.getUserData();
   
   //  BEGIN PROFESSOR RUI
   //pode ser uma colisão entre objectos que não tenham o user data definido. Nesses casos não queremos 
   //detectar colisões, pelo que fazemos logo return
   if (o1 == null || o2 == null) { 
   return;
   }
   println(o1.getClass());
   //este 'if' detecta se o primeiro objecto é uma particle e o segundo um Hooligan
   if (o1.getClass() == Bottle.class && o2.getClass() == Box.class) {
   Bottle b = (Bottle)o1; //fazemos um 'cast' do 'o1' para a sua class particle
   Box bx = (Box)o2; //fazemos um 'cast' do 'o2' para a sua class Hooligans
   b.delete();//chamamos a função delete da particle
   bx.hit();
   //chamamos a função delete do hooligan
   
   //o 'else if' a seguir verifica o caso de o Box2D detectar a colisão com os objectos na ordem contrária
   } else if (o2.getClass() == Bottle.class && o1.getClass() == Box.class) {
   Bottle b = (Bottle)o2; //fazemos um 'cast' do 'o2' para a sua class particle
   Box bx = (Box)o1; //fazemos um 'cast' do 'o1' para a sua class hooligan
   b.delete(); //chamamos a função delete da particle
   bx.hit();
   //chamamos a função delete do hooligan
   
   //o 'else if' verifica o caso em que o o1 é uma particula mas o o2 não é um hooligan
   //por exemplo se a particula colidiu com o chão ou outro objecto, também querem apagar a particula
   } else if (o1.getClass() == Bottle.class) {
   Bottle b = (Bottle)o1;
   b.delete();
   }
   }*/

  void endContact(Contact contact) {
    // TODO Auto-generated method stub
  }

  void preSolve(Contact contact, Manifold oldManifold) {
    // TODO Auto-generated method stub
  }

  void postSolve(Contact contact, ContactImpulse impulse) {
    // TODO Auto-generated method stub
  }
}