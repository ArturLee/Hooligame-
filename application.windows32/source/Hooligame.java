import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import shiffman.box2d.*; 
import org.jbox2d.common.*; 
import org.jbox2d.dynamics.joints.*; 
import org.jbox2d.collision.shapes.*; 
import org.jbox2d.collision.shapes.Shape; 
import org.jbox2d.common.*; 
import org.jbox2d.dynamics.*; 
import org.jbox2d.dynamics.contacts.*; 
import ddf.minim.*; 
import org.jbox2d.callbacks.ContactImpulse; 
import org.jbox2d.callbacks.ContactListener; 
import org.jbox2d.collision.Manifold; 
import org.jbox2d.dynamics.contacts.Contact; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Hooligame extends PApplet {

// =============================================================================WELCOME TO HOOLIGAME============================================================================================================================================ 
 //india hotel aplha tango echo bravo oscar x-ray 2 delta...








//................................................................Menu Stuffs...................................................................................................................................................................................

enum State { 
  LoadingImg, MAIN_MENU, CREDITS, SETTING, Controls, Difficulty, Audio, Music, SoundEffect, FEEDBACK, Game_Level, Level_1, Level_2, Level_3, MINIGAME, MINIGAME2, MINIGAME3, GAME_OVER, Pause
};

State gameState = State.LoadingImg;
//State gameState = State.MAIN_MENU; 
//State gameState = State.Level_1;

//..........................................................Mini Game VAriables..............................................................................................................................................................................
int inter;
int health;
ArrayList< particle> particles;
ArrayList <HooligansP> hooligansp;
Box2DProcessing box2d;
Ground floor;
Box box;

float posX = 0 ;

int spawn_minigame;//for the mini game limited time
int times=30000;
int minigametimer;
int shootParticles;
boolean minigame=true;
int minitime;
int minitrue=60000;
//...........................................................GamePlay Variables................................................................................................................................................................................
ArrayList<Hooligans> hooligans; //lista de hooligans
ArrayList<Police> police; //lista de towers 
ArrayList<Bullet> bullet; 
ArrayList<Bottle> bottle; 

int pause; // this records the times of the millis()

boolean level_1=false;
boolean level_2=false;
boolean level_3=false; //to know which level are you

boolean level2=false;
boolean level3=false;

int StartGame;  //\u00e9 o tempo
int wave1, wave2, wave3, wave4, wave5, wave6;
int interval = 1000; //ainda a determinar  
int health_s =100; //vida do est\u00e1dio
int damage;  
int credits=500;
int loads;
int walk;

//..................................................................Buttons.......................................................................................................................................................................................
ArrayList<Button> btn; // a cena dos buttons la em cima
ArrayList<Button1> btn1;
ArrayList<Button2> btn2;
ArrayList<Button3> btn3;
ArrayList<Button4> btn4;
ArrayList<Button5> btn5;
ArrayList<Button6> btn6;
ArrayList<Button7> btn7;
ArrayList<Button8> btn8;


//...................................................................Path........................................................................................................................................................................................
ArrayList<PVector> path; // sao os caminhos para o nivel 1
ArrayList<PVector> path2;
ArrayList<PVector> path3;
ArrayList<PVector> path4;
ArrayList<PVector> path5;
ArrayList<PVector> path6;
ArrayList<PVector> path7;
ArrayList<PVector> path8;
ArrayList<PVector> path9;
ArrayList<PVector> path10;
ArrayList<PVector> path11;
ArrayList<PVector> path12;
ArrayList<PVector> path13;
ArrayList<PVector> path14; // fim do nivel 1
ArrayList<PVector> path15;
ArrayList<PVector> path16;
ArrayList<PVector> path17;
ArrayList<PVector> path18;
ArrayList<PVector> path19;
ArrayList<PVector> path20;
ArrayList<PVector> path21;
ArrayList<PVector> path22;
ArrayList<PVector> path23;
ArrayList<PVector> path24;
ArrayList<PVector> path25;
ArrayList<PVector> path26;
ArrayList<PVector> path27;
ArrayList<PVector> path28;
ArrayList<PVector> path29;
ArrayList<PVector> path30;
ArrayList<PVector> path31;
ArrayList<PVector> path32;
ArrayList<PVector> path33;
ArrayList<PVector> path34;
ArrayList<PVector> path35;
ArrayList<PVector> path36;
ArrayList<PVector> path37;
ArrayList<PVector> path38;
ArrayList<PVector> path40; //nivel 3
ArrayList<PVector> path41;
ArrayList<PVector> path42;
ArrayList<PVector> path43;
ArrayList<PVector> path44; 
ArrayList<PVector> path45;
ArrayList<PVector> path46;
ArrayList<PVector> path47;
ArrayList<PVector> path48;
ArrayList<PVector> path49;
ArrayList<PVector> path50;
ArrayList<PVector> path51;
ArrayList<PVector> path52;
ArrayList<PVector> path53; // fim nivel 3


//......................................................................Image LOADED..........................................................................................................................................................................................................................
PImage bg;
PImage bg2;
PImage bg3;
PImage bg4;

PImage creditsm;

PImage rock;

PImage hooligan1;
PImage hooligan2;
PImage hooligan3;
PImage hooligan1a;
PImage hooligan2a;
PImage hooligan3a;

PImage GameOver;
PImage mainMenuImage;

PImage Police1;
PImage Police2;
PImage Police3;
PImage Police4;
PImage policeImage=Police1;

PImage healt0;
PImage healt10;
PImage healt20;
PImage healt30;
PImage healt40;
PImage healt50;
PImage healt60;
PImage healt70;
PImage healt80;
PImage healt90;
PImage healt100;

PImage money;

PImage pausee;
PImage Pause;
PImage clock;
PImage Minigamebtn;

PImage pathMask;
PImage pathMask2;
PImage pathMask3;

//minigame image-----------------------------------------
PImage minibg;
PImage minihoolR;
PImage minihoolL;
PImage Cop;
PImage Bottle;

// menu image---------------------------------------------
PImage LoadingImage;
PImage GameLevel;
PImage playbutton;
PImage settingsbuttonS;
PImage creditsbutton;
PImage feedbackbutton;
PImage exitbuttonS;
PImage exitbutton;

PImage Controllers;
PImage Controls;

PImage difficulty;
PImage easy;
PImage medium;
PImage hard;

PImage sound;
PImage music;

PImage lvl1;
PImage lvl2;
PImage lvl3;

PImage weapon1;
PImage weapon2;
PImage weapon3;
PImage weapon4;

PImage nono;
PImage nonomini;
PImage nono150;
// ..........................................................................Sound Effect........................................................................................................................................................................................................................................

Minim minim;
AudioPlayer menuaudio;
AudioPlayer ingameaudio;
AudioSample gunfire;
AudioSample select;


boolean Music=true;
boolean SoundEffect=true;
boolean MenuMusic=true;
boolean MenuSound=true;

int towerType =0;

int miniGameKilled = 0, miniGameNumHooligans = 0;
// ............................................................................Booleans.............................................................................................................................................................................................................................................
boolean anyPressed1;
boolean anyPressed3;
boolean anyPressed4;
boolean anyPressed5;
boolean anyPressed6;
boolean inSelected=false;

public void setup() { //------------------------------------------------------------Setup--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
  //..............................................Buttons List..........................................................................................................................................................................................................................
  btn=new ArrayList<Button>();

  btn1= new ArrayList<Button1>();
  btn1.add(new Button1(525, 600));
  btn1.add(new Button1(445, 700));
  btn1.add(new Button1(285, 700));
  btn1.add(new Button1(605, 700));
  btn1.add(new Button1(765, 700));

  btn2=new ArrayList<Button2>();
  btn2.add(new Button2(0, 0));
  btn2.add(new Button2(202, 0));
  btn2.add(new Button2(404, 0));
  btn2.add(new Button2(606, 0));
  btn2.add(new Button2(997, 323));

  btn3=new ArrayList<Button3>();
  btn3.add(new Button3(1150, 0));
  btn3.add(new Button3(1150, 750));

  btn4=new ArrayList<Button4>();
  btn4.add(new Button4(250, height/2-25));
  btn4.add(new Button4(550, height/2-25));
  btn4.add(new Button4(850, height/2-25));

  btn5=new ArrayList<Button5>();
  btn5.add(new Button5(width/9, height/2-75));
  btn5.add(new Button5(3*width/9, height/2-75));
  btn5.add(new Button5(5*width/9, height/2-75));
  btn5.add(new Button5(7*width/9, height/2-75));

  btn6=new ArrayList<Button6>();
  btn6.add(new Button6(167, height/4-60 ));
  btn6.add(new Button6(498, height/4-60));
  btn6.add(new Button6(830, height/4-60));
  btn6.add(new Button6(167, 3*height/4-130));
  btn6.add(new Button6(498, 3*height/4-130));  
  btn6.add(new Button6(830, 3*height/4-130));

  btn7=new ArrayList<Button7>();
  btn7.add(new Button7(1000, 600));

  btn8=new ArrayList<Button8>();
  btn8.add(new Button8(222, height/2-60));
  btn8.add(new Button8(525, height/2-60));
  btn8.add(new Button8(822, height/2-60));

  //........................................................................Game Play List...............................................................................................................................................
  hooligans = new ArrayList<Hooligans>(); //nova lista global de hooligans
  police = new ArrayList<Police>(); //nova lista global de police
  bullet = new ArrayList<Bullet>(); //nova lista global AMmO
  bottle = new ArrayList<Bottle>();
  // .......................................................................Load IMAGE.........................................................................................................................................................................................................
  bg = loadImage("bg1.jpg");
  bg.resize(1200, 800);
  bg2 = loadImage("level2.jpg");
  bg2.resize(1200, 800);
  bg3 = loadImage("leve3.jpg");
  bg3.resize(1200, 800);

  rock = loadImage("Rock.png");
  rock.resize(7, 7);
  hooligan1 = loadImage("hooligan1.png");
  hooligan1a= loadImage("hooligan1a.png");
  hooligan2= loadImage("hooligan2.png");
  hooligan2a=loadImage("hooligan2a.png");
  hooligan3= loadImage("hooligan3.png");
  hooligan3a=loadImage("hooligan3a.png");
  mainMenuImage = loadImage ("backGround.jpg");
  GameOver = loadImage("GameOver.jpg");
  GameOver.resize(1200, 800);

  pathMask = loadImage("maskj.png");
  pathMask.resize(1200, 800);
  pathMask2 = loadImage("mask2p.png");
  pathMask2.resize(1200, 800);
  pathMask3 = loadImage("mask3.jpg");
  pathMask3.resize(1200, 800);

  Cop=loadImage("copVan.png");
  Cop.resize(150, 150);
  Bottle=loadImage("bottle.png");
  Bottle.resize(10, 18);
  minihoolR=loadImage("hooliganp1.png");
  minihoolL=loadImage("hooliganp2.png");
  minibg=loadImage("minigame.png");
  minibg.resize(1200, 800);

  Pause=loadImage("menu.jpg");

  healt0=loadImage("healt0.png");
  healt10=loadImage("healt10.png");
  healt20=loadImage("healt20.png");
  healt30=loadImage("healt30.png");
  healt40=loadImage("healt40.png");
  healt50=loadImage("healt50.png");
  healt60=loadImage("healt60.png");
  healt70=loadImage("healt70.png");
  healt80=loadImage("healt80.png");
  healt90=loadImage("healt90.png");
  healt100=loadImage("healt100.png");

  Police1=loadImage("police1.png");
  Police2=loadImage("police2.png");
  Police3=loadImage("police3.png");
  Police4=loadImage("police4.png");
  Police1.resize(25, 25);
  Police2.resize(20, 20);
  Police3.resize(20, 20);
  Police4.resize(25, 25);

  creditsm=loadImage("Credits.jpg");

  GameLevel=loadImage("GameLevel.jpg");
  LoadingImage=loadImage("loading.jpg");

  playbutton = loadImage("playbutton.png");
  playbutton.resize(150, 50);
  settingsbuttonS = loadImage("settingsbutton.png");
  settingsbuttonS.resize(150, 50);
  creditsbutton = loadImage("creditsbutton.png");
  creditsbutton.resize(150, 50);
  feedbackbutton = loadImage("feedb.png");
  feedbackbutton.resize(150, 50);
  exitbuttonS = loadImage("exitS.png");
  exitbuttonS.resize(50, 50);
  exitbutton = loadImage("close.png");
  exitbutton.resize(150, 50);

  Controllers = loadImage("controllersbutton.png");
  Controllers.resize(150, 150);
  Controls = loadImage("Controls.jpg");
  Controls.resize(1200, 800);

  lvl1=loadImage("lvl 1.png");
  lvl2=loadImage("lvl 2.png");
  lvl3=loadImage("lvl 3.png");

  difficulty=loadImage("dificulty button.png");
  difficulty.resize(150, 150);
  easy=loadImage("easy button.png");
  medium=loadImage("medium button.png");
  hard=loadImage("hard button.png");

  sound=loadImage("music button.png");
  sound.resize(150, 150);
  music=loadImage("music.png");
  music.resize(150, 150);

  weapon1=loadImage("beretta.png");
  weapon2=loadImage("beretta2.png");
  weapon3=loadImage("ar15.png");
  weapon4=loadImage("minigun.png");

  nono=loadImage("pipiparou.png");
  nonomini=loadImage("pipiparoumini.png");
  nono150=loadImage("nono150.png");

  pausee = loadImage("IngameP.png");
  pausee.resize(50, 50);
  clock = loadImage("time button.png");
  clock.resize(20, 25);
  Minigamebtn = loadImage("minigame button.png");
  money =loadImage("money button.png");
  money.resize(25, 20);
  //......................................................................Path List..............................................................................................................................................................................................................................................................................
  path = new ArrayList<PVector>();
  path.add(new PVector(423, 590));
  path.add(new PVector(423, 605));
  path.add(new PVector(522, 605)); //end
  path.add(new PVector(522, 335));
  path.add(new PVector(65, 332)); 
  path.add(new PVector(43, 285));
  path.add(new PVector(63, 236));
  path.add(new PVector(790, 244)); 
  path.add(new PVector(915, 239));
  path.add(new PVector(989, 189));


  path2= new ArrayList<PVector>();
  path2.add(new PVector(115, 689));
  path2.add(new PVector(130, 689));
  path2.add(new PVector(130, 604));
  path2.add(new PVector(333, 604)); 
  path2.add(new PVector(333, 467));
  path2.add(new PVector(522, 465));//end
  path2.add(new PVector(522, 335));
  path2.add(new PVector(65, 332)); 
  path2.add(new PVector(43, 285));
  path2.add(new PVector(63, 236));
  path2.add(new PVector(790, 244)); 
  path2.add(new PVector(915, 239));
  path2.add(new PVector(989, 189));


  path3= new ArrayList<PVector>();
  path3.add(new PVector(871, 712));
  path3.add(new PVector(857, 712));
  path3.add(new PVector(857, 472));
  path3.add(new PVector(522, 472)); //end
  path3.add(new PVector(522, 335));
  path3.add(new PVector(65, 332)); 
  path3.add(new PVector(43, 285));
  path3.add(new PVector(63, 236));
  path3.add(new PVector(790, 244)); 
  path3.add(new PVector(915, 239));
  path3.add(new PVector(989, 189));

  path4= new ArrayList<PVector>();
  path4.add(new PVector(423, 590));
  path4.add(new PVector(423, 605));
  path4.add(new PVector(333, 604)); 
  path4.add(new PVector(333, 467));
  path4.add(new PVector(522, 465));//end
  path4.add(new PVector(522, 335));
  path4.add(new PVector(65, 332)); 
  path4.add(new PVector(43, 285));
  path4.add(new PVector(63, 236));
  path4.add(new PVector(790, 244)); 
  path4.add(new PVector(915, 239));
  path4.add(new PVector(989, 189));

  path5 = new ArrayList<PVector>();
  path5.add(new PVector(115, 689));
  path5.add(new PVector(130, 689));
  path5.add(new PVector(130, 604));
  path5.add(new PVector(333, 604));
  path5.add(new PVector(522, 605)); //end
  path5.add(new PVector(522, 335));
  path5.add(new PVector(65, 332)); 
  path5.add(new PVector(43, 285));
  path5.add(new PVector(63, 236));
  path5.add(new PVector(790, 244)); 
  path5.add(new PVector(915, 239));
  path5.add(new PVector(989, 189));

  path6 = new ArrayList<PVector>();
  path6.add(new PVector(871, 712));
  path6.add(new PVector(833, 731));
  path6.add(new PVector(535, 731));
  path6.add(new PVector(522, 605));
  path6.add(new PVector(522, 335));
  path6.add(new PVector(65, 332)); 
  path6.add(new PVector(43, 285));
  path6.add(new PVector(63, 236));
  path6.add(new PVector(790, 244)); 
  path6.add(new PVector(915, 239));
  path6.add(new PVector(989, 189));

  path7 = new ArrayList<PVector>();
  path7.add(new PVector(115, 689));
  path7.add(new PVector(130, 689));
  path7.add(new PVector(139, 777));
  path7.add(new PVector(520, 777));
  path7.add(new PVector(522, 605));
  path7.add(new PVector(522, 335));
  path7.add(new PVector(65, 332)); 
  path7.add(new PVector(43, 285));
  path7.add(new PVector(63, 236));
  path7.add(new PVector(790, 244)); 
  path7.add(new PVector(915, 239));
  path7.add(new PVector(989, 189));

  path8 = new ArrayList<PVector>();
  path8.add(new PVector(423, 590));
  path8.add(new PVector(423, 605));
  path8.add(new PVector(522, 605)); //end
  path8.add(new PVector(522, 335));
  path8.add(new PVector(65, 332)); 
  path8.add(new PVector(43, 285));//
  path8.add(new PVector(68, 160));
  path8.add(new PVector(890, 143)); 
  path8.add(new PVector(989, 189));


  path9= new ArrayList<PVector>();
  path9.add(new PVector(115, 689));
  path9.add(new PVector(130, 689));
  path9.add(new PVector(130, 604));
  path9.add(new PVector(333, 604)); 
  path9.add(new PVector(333, 467));
  path9.add(new PVector(522, 465));//end
  path9.add(new PVector(522, 335));
  path9.add(new PVector(65, 332)); 
  path9.add(new PVector(43, 285));//
  path9.add(new PVector(68, 160));
  path9.add(new PVector(890, 143)); 
  path9.add(new PVector(989, 189));


  path10= new ArrayList<PVector>();
  path10.add(new PVector(871, 712));
  path10.add(new PVector(857, 712));
  path10.add(new PVector(857, 472));
  path10.add(new PVector(522, 472)); //end
  path10.add(new PVector(522, 335));
  path10.add(new PVector(65, 332)); 
  path10.add(new PVector(43, 285));//
  path10.add(new PVector(68, 160));
  path10.add(new PVector(890, 143)); 
  path10.add(new PVector(989, 189));

  path11= new ArrayList<PVector>();
  path11.add(new PVector(423, 590));
  path11.add(new PVector(423, 605));
  path11.add(new PVector(333, 604)); 
  path11.add(new PVector(333, 467));
  path11.add(new PVector(522, 465));//end
  path11.add(new PVector(522, 335));
  path11.add(new PVector(65, 332)); 
  path11.add(new PVector(43, 285));//
  path11.add(new PVector(68, 160));
  path11.add(new PVector(890, 143)); 
  path11.add(new PVector(989, 189));

  path12 = new ArrayList<PVector>();
  path12.add(new PVector(115, 689));
  path12.add(new PVector(130, 689));
  path12.add(new PVector(130, 604));
  path12.add(new PVector(333, 604));
  path12.add(new PVector(522, 605)); //end
  path12.add(new PVector(522, 335));
  path12.add(new PVector(65, 332)); 
  path12.add(new PVector(43, 285));//
  path12.add(new PVector(68, 160));
  path12.add(new PVector(890, 143)); 
  path12.add(new PVector(989, 189));

  path13 = new ArrayList<PVector>();
  path13.add(new PVector(871, 712));
  path13.add(new PVector(833, 731));
  path13.add(new PVector(535, 731));
  path13.add(new PVector(522, 605));
  path13.add(new PVector(522, 335));
  path13.add(new PVector(65, 332)); 
  path13.add(new PVector(43, 285));//
  path13.add(new PVector(68, 160));
  path13.add(new PVector(890, 143)); 
  path13.add(new PVector(989, 189));

  path14 = new ArrayList<PVector>();
  path14.add(new PVector(115, 689));
  path14.add(new PVector(130, 689));
  path14.add(new PVector(139, 777));
  path14.add(new PVector(520, 777));
  path14.add(new PVector(522, 605));
  path14.add(new PVector(522, 335));
  path14.add(new PVector(65, 332)); 
  path14.add(new PVector(43, 285));//
  path14.add(new PVector(68, 160));
  path14.add(new PVector(890, 143)); 
  path14.add(new PVector(989, 189));

  //caminhos PUB left down corner
  path15 = new ArrayList<PVector>(); //caminho pela casa ao pe do status bar
  path15.add(new PVector(102, 676));
  path15.add(new PVector(95, 735));
  path15.add(new PVector(845, 734));
  path15.add(new PVector(872, 213));
  path15.add(new PVector(1148, 193));
  path15.add(new PVector(1153, 129));

  path16 = new ArrayList<PVector>(); //caminho pela casa laranja com piscina em forma de arco lad esq
  path16.add(new PVector(102, 676));
  path16.add(new PVector(95, 735));
  path16.add(new PVector(630, 732));
  path16.add(new PVector(652, 600));//
  path16.add(new PVector(860, 572));
  path16.add(new PVector(872, 213));
  path16.add(new PVector(1148, 193));
  path16.add(new PVector(1153, 129));

  path17 = new ArrayList<PVector>(); // caminho pela casa em forma de T lado esq
  path17.add(new PVector(102, 676));
  path17.add(new PVector(95, 735));
  path17.add(new PVector(447, 732));
  path17.add(new PVector(471, 594));
  path17.add(new PVector(860, 572));
  path17.add(new PVector(872, 213));
  path17.add(new PVector(1148, 193));
  path17.add(new PVector(1153, 129));

  path18 = new ArrayList<PVector>(); //caminho pela casa cizento claro esq
  path18.add(new PVector(102, 676));
  path18.add(new PVector(95, 735));
  path18.add(new PVector(292, 729));
  path18.add(new PVector(323, 591));
  path18.add(new PVector(860, 572));
  path18.add(new PVector(872, 213));
  path18.add(new PVector(1148, 193));
  path18.add(new PVector(1153, 129));

  path19 = new ArrayList<PVector>(); //caminho pela casa cizento claro esq passado pela rua 3 horizontal
  path19.add(new PVector(102, 676));
  path19.add(new PVector(95, 735));
  path19.add(new PVector(292, 729));
  path19.add(new PVector(323, 591));
  path19.add(new PVector(376, 383));
  path19.add(new PVector(858, 361));
  path19.add(new PVector(872, 213));
  path19.add(new PVector(1148, 193));
  path19.add(new PVector(1153, 129));

  path20 = new ArrayList<PVector>(); //caminho pela cas cizento claro esq passando pela rua 2 horizontal
  path20.add(new PVector(102, 676));
  path20.add(new PVector(95, 735));
  path20.add(new PVector(292, 729));
  path20.add(new PVector(323, 591));
  path20.add(new PVector(372, 203));
  path20.add(new PVector(872, 213));
  path20.add(new PVector(1148, 193));
  path20.add(new PVector(1153, 129));

  path21 = new ArrayList<PVector>(); //caminho pela cas cizento claro esq passando pela rua 1 horizontal
  path21.add(new PVector(102, 676));
  path21.add(new PVector(95, 735));
  path21.add(new PVector(292, 729));
  path21.add(new PVector(323, 591));
  path21.add(new PVector(372, 163));
  path21.add(new PVector(1046, 161));
  path21.add(new PVector(1123, 110));
  //end path for This PUb

  //begin path for PUb on left top corner
  path22=new ArrayList<PVector>(); //rua 2 horizontal 
  path22.add(new PVector(72, 255));
  path22.add(new PVector(97, 227));
  path22.add(new PVector(221, 230));
  path22.add(new PVector(375, 225));
  path22.add(new PVector(384, 202));
  path22.add(new PVector(872, 213));//eaehdfg
  path22.add(new PVector(1148, 193));
  path22.add(new PVector(1153, 129));

  path23= new ArrayList<PVector>(); //rua 1 horizontal
  path23.add(new PVector(72, 255));
  path23.add(new PVector(97, 227));
  path23.add(new PVector(221, 230));
  path23.add(new PVector(375, 225));
  path23.add(new PVector(384, 162));
  path23.add(new PVector(1046, 161));
  path23.add(new PVector(1123, 110));

  path24 = new ArrayList<PVector>(); //rua 3 horizontal
  path24.add(new PVector(72, 255));
  path24.add(new PVector(97, 227));
  path24.add(new PVector(221, 230));
  path24.add(new PVector(338, 255));
  path24.add(new PVector(381, 368));
  path24.add(new PVector(847, 367));
  path24.add(new PVector(872, 213));
  path24.add(new PVector(1148, 193));
  path24.add(new PVector(1153, 129));
  //end path for this Pub

  //path for 3rd pub
  path25 = new ArrayList<PVector>(); //long
  path25.add(new PVector(264, 695));
  path25.add(new PVector(284, 724));
  path25.add(new PVector(845, 734));
  path25.add(new PVector(872, 213));
  path25.add(new PVector(1148, 193));
  path25.add(new PVector(1153, 129));

  path26 = new ArrayList<PVector>();
  path26.add(new PVector(264, 695));
  path26.add(new PVector(284, 724));
  path26.add(new PVector(630, 732));
  path26.add(new PVector(652, 600));//
  path26.add(new PVector(860, 572));
  path26.add(new PVector(872, 213));
  path26.add(new PVector(1148, 193));
  path26.add(new PVector(1153, 129));

  path27 = new ArrayList<PVector>();
  path27.add(new PVector(264, 695));
  path27.add(new PVector(284, 724));
  path27.add(new PVector(447, 732));
  path27.add(new PVector(471, 594));
  path27.add(new PVector(860, 572));
  path27.add(new PVector(872, 213));
  path27.add(new PVector(1148, 193));
  path27.add(new PVector(1153, 129));

  path28 = new ArrayList<PVector>();
  path28.add(new PVector(264, 695));
  path28.add(new PVector(304, 689));
  path28.add(new PVector(323, 591));
  path28.add(new PVector(860, 572));
  path28.add(new PVector(872, 213));
  path28.add(new PVector(1148, 193));
  path28.add(new PVector(1153, 129));

  path29 = new ArrayList<PVector>();
  path29.add(new PVector(264, 695));
  path29.add(new PVector(304, 689));
  path29.add(new PVector(323, 591));
  path29.add(new PVector(376, 383));
  path29.add(new PVector(858, 361));
  path29.add(new PVector(872, 213));
  path29.add(new PVector(1148, 193));
  path29.add(new PVector(1153, 129));

  path30 = new ArrayList<PVector>();
  path30.add(new PVector(264, 695));
  path30.add(new PVector(304, 689));
  path30.add(new PVector(323, 591));
  path30.add(new PVector(372, 203));
  path30.add(new PVector(872, 213));
  path30.add(new PVector(1148, 193));
  path30.add(new PVector(1153, 129));

  path31 = new ArrayList<PVector>();
  path31.add(new PVector(264, 695));
  path31.add(new PVector(304, 689));
  path31.add(new PVector(323, 591));
  path31.add(new PVector(372, 163));
  path31.add(new PVector(1046, 161));
  path31.add(new PVector(1123, 110));

  path32 = new ArrayList<PVector>();
  path32.add(new PVector(264, 695));
  path32.add(new PVector(235, 697));
  path32.add(new PVector(212, 680));
  path32.add(new PVector(213, 598));
  path32.add(new PVector(222, 258));
  path32.add(new PVector(263, 239));
  path32.add(new PVector(375, 225));
  path32.add(new PVector(384, 202));
  path32.add(new PVector(872, 213));//eaehdfg
  path32.add(new PVector(1148, 193));
  path32.add(new PVector(1153, 129));

  path33 = new ArrayList<PVector>();
  path33.add(new PVector(264, 695));
  path33.add(new PVector(235, 697));
  path33.add(new PVector(212, 680));
  path33.add(new PVector(213, 598));
  path33.add(new PVector(230, 389));
  path33.add(new PVector(854, 368));
  path33.add(new PVector(872, 213));
  path33.add(new PVector(1148, 193));
  path33.add(new PVector(1153, 129));

  path34 = new ArrayList<PVector>();
  path34.add(new PVector(264, 695));
  path34.add(new PVector(235, 697));
  path34.add(new PVector(212, 680));
  path34.add(new PVector(213, 598));
  path34.add(new PVector(229, 496));
  path34.add(new PVector(333, 478));
  path34.add(new PVector(385, 386));
  path34.add(new PVector(854, 368));
  path34.add(new PVector(872, 213));
  path34.add(new PVector(1148, 193));
  path34.add(new PVector(1153, 129));

  path35 = new ArrayList<PVector>();
  path35.add(new PVector(264, 695));
  path35.add(new PVector(235, 697));
  path35.add(new PVector(212, 680));
  path35.add(new PVector(213, 598));
  path35.add(new PVector(328, 582));
  path35.add(new PVector(384, 381));
  path35.add(new PVector(854, 368));
  path35.add(new PVector(872, 213));
  path35.add(new PVector(1148, 193));
  path35.add(new PVector(1153, 129));
  //end this bp
  path36=new ArrayList<PVector>(); //rua 2 horizontal 
  path36.add(new PVector(59, 96));
  path36.add(new PVector(59, 183));
  path36.add(new PVector(97, 227));
  path36.add(new PVector(221, 230));
  path36.add(new PVector(375, 225));
  path36.add(new PVector(384, 202));
  path36.add(new PVector(872, 213));//eaehdfg
  path36.add(new PVector(1148, 193));
  path36.add(new PVector(1153, 129));

  path37= new ArrayList<PVector>(); //rua 1 horizontal
  path37.add(new PVector(59, 96));
  path37.add(new PVector(59, 183));
  path37.add(new PVector(97, 227));
  path37.add(new PVector(221, 230));
  path37.add(new PVector(375, 225));
  path37.add(new PVector(384, 162));
  path37.add(new PVector(1046, 161));
  path37.add(new PVector(1123, 110));

  path38 = new ArrayList<PVector>(); //rua 3 horizontal
  path38.add(new PVector(59, 96));
  path38.add(new PVector(59, 183));
  path38.add(new PVector(97, 227));
  path38.add(new PVector(221, 230));
  path38.add(new PVector(338, 255));
  path38.add(new PVector(381, 368));
  path38.add(new PVector(847, 367));
  path38.add(new PVector(872, 213));
  path38.add(new PVector(1148, 193));
  path38.add(new PVector(1153, 129));
  //end path level 2
  //PUB1
  path40 = new ArrayList<PVector>(); // rua 1H sentido contrario rua 2H sentido correto
  path40.add(new PVector(585, 189));
  path40.add(new PVector(567, 227));
  path40.add(new PVector(416, 246));
  path40.add(new PVector(261, 248));
  path40.add(new PVector(253, 377));
  path40.add(new PVector(334, 396));
  path40.add(new PVector(649, 402));
  path40.add(new PVector(689, 550));
  path40.add(new PVector(978, 539));
  path40.add(new PVector(982, 323));
  path40.add(new PVector(1059, 183));

  path41 = new ArrayList<PVector>(); //rua 1H sentido correto rua 2H sentido correto
  path41.add(new PVector(585, 189));
  path41.add(new PVector(567, 227));
  path41.add(new PVector(427, 198));
  path41.add(new PVector(315, 208));
  path41.add(new PVector(252, 252));
  path41.add(new PVector(253, 377));
  path41.add(new PVector(334, 396));
  path41.add(new PVector(649, 402));
  path41.add(new PVector(689, 550));
  path41.add(new PVector(978, 539));
  path41.add(new PVector(982, 323));
  path41.add(new PVector(1059, 183));

  path42 = new ArrayList<PVector>(); //rua 1H contrario rua 2H contrario
  path42.add(new PVector(585, 189));
  path42.add(new PVector(567, 227));
  path42.add(new PVector(416, 246));
  path42.add(new PVector(261, 248));
  path42.add(new PVector(252, 357));
  path42.add(new PVector(635, 364));
  path42.add(new PVector(649, 402));
  path42.add(new PVector(689, 550));
  path42.add(new PVector(978, 539));
  path42.add(new PVector(982, 323));
  path42.add(new PVector(1059, 183));

  path43 = new ArrayList<PVector>(); //1H correto 1V contrario 3H contrario
  path43.add(new PVector(585, 189));
  path43.add(new PVector(567, 227));
  path43.add(new PVector(427, 196));
  path43.add(new PVector(305, 217));
  path43.add(new PVector(252, 252));
  path43.add(new PVector(253, 377));
  path43.add(new PVector(246, 384));
  path43.add(new PVector(231, 541));
  path43.add(new PVector(689, 550));
  path43.add(new PVector(978, 539));
  path43.add(new PVector(982, 323));
  path43.add(new PVector(1059, 183));

  //PUB2
  path44 = new ArrayList<PVector>(); //1V 2H contrario 3H
  path44.add(new PVector(202, 196));
  path44.add(new PVector(249, 246));
  path44.add(new PVector(253, 360));
  path44.add(new PVector(635, 364));
  path44.add(new PVector(649, 402));
  path44.add(new PVector(689, 550));
  path44.add(new PVector(978, 539));
  path44.add(new PVector(982, 323));
  path44.add(new PVector(1059, 183));

  path45 = new ArrayList<PVector>(); //
  path45.add(new PVector(202, 196));
  path45.add(new PVector(146, 246));
  path45.add(new PVector(146, 377));
  path45.add(new PVector(230, 409));
  path45.add(new PVector(230, 550));
  path45.add(new PVector(978, 539));
  path45.add(new PVector(982, 323));
  path45.add(new PVector(1059, 183));

  path46 = new ArrayList<PVector>(); //1V correto 4H 3H
  path46.add(new PVector(202, 196));
  path46.add(new PVector(146, 246));
  path46.add(new PVector(146, 377));
  path46.add(new PVector(181, 427));
  path46.add(new PVector(158, 590));
  path46.add(new PVector(159, 670));
  path46.add(new PVector(357, 660));
  path46.add(new PVector(435, 566));
  path46.add(new PVector(978, 539));
  path46.add(new PVector(982, 323));
  path46.add(new PVector(1059, 183));

  path47 = new ArrayList<PVector>(); // 1V 3H
  path47.add(new PVector(202, 196));
  path47.add(new PVector(146, 246));
  path47.add(new PVector(146, 377));
  path47.add(new PVector(181, 427));
  path47.add(new PVector(158, 590));
  path47.add(new PVector(448, 592));
  path47.add(new PVector(978, 539));
  path47.add(new PVector(982, 323));
  path47.add(new PVector(1059, 183));

  //PUB3
  path48 = new ArrayList<PVector>(); //1V contrario 2H (?)
  path48.add(new PVector(143, 535));
  path48.add(new PVector(176, 535));
  path48.add(new PVector(176, 400));
  path48.add(new PVector(668, 400));
  path48.add(new PVector(668, 545));
  path48.add(new PVector(978, 545));
  path48.add(new PVector(982, 323));
  path48.add(new PVector(1059, 183));

  path49 = new ArrayList<PVector>(); // 1V correto 3H
  path49.add(new PVector(143, 535));
  path49.add(new PVector(176, 535));
  path49.add(new PVector(176, 597));
  path49.add(new PVector(391, 597));
  path49.add(new PVector(591, 572));
  path49.add(new PVector(978, 545));
  path49.add(new PVector(982, 323));
  path49.add(new PVector(1059, 183));

  path50 = new ArrayList<PVector>(); // 1V correto 4H 3H
  path50.add(new PVector(143, 535));
  path50.add(new PVector(176, 535));
  path50.add(new PVector(176, 597));
  path50.add(new PVector(144, 617));
  path50.add(new PVector(154, 676));
  path50.add(new PVector(377, 671));
  path50.add(new PVector(397, 595));
  path50.add(new PVector(978, 545));
  path50.add(new PVector(982, 323));
  path50.add(new PVector(1059, 183));

  //PUB4
  path51 = new ArrayList<PVector>();
  path51.add(new PVector(73, 619));
  path51.add(new PVector(143, 592));
  path51.add(new PVector(403, 587));
  path51.add(new PVector(978, 545));
  path51.add(new PVector(982, 323));
  path51.add(new PVector(1059, 183));

  path52 = new ArrayList<PVector>();
  path52.add(new PVector(73, 619));
  path52.add(new PVector(143, 592));
  path52.add(new PVector(146, 670));
  path52.add(new PVector(383, 673));
  path52.add(new PVector(398, 596));
  path52.add(new PVector(978, 545));
  path52.add(new PVector(982, 323));
  path52.add(new PVector(1059, 183));

  //PUB5
  path53 = new ArrayList<PVector>();
  path53.add(new PVector(489, 619));
  path53.add(new PVector(489, 595));
  path53.add(new PVector(978, 545));
  path53.add(new PVector(982, 323));
  path53.add(new PVector(1059, 183));

  //.......................................................................Audio File..........................................................................................................................................................................................................................................................................
  minim = new Minim(this);
  menuaudio = minim.loadFile("Menu_audio.mp3");
  menuaudio.setGain(-13);
  menuaudio.loop();
  ingameaudio = minim.loadFile("ingameaudio.mp3");
  ingameaudio.loop();
  ingameaudio.setGain(-80);
  gunfire= minim.loadSample("Gun_Audio.mp3");
  gunfire.setGain(-40);
  select= minim.loadSample( "select.mp3");

  //...................................................................... Mini Game Stuff...........................................................................................................................................................................................................................................................................
  towerType =0;
  //btn.get(0).selected = false;
  //game state =1 cenas do game state 1 
  // Initialize box2d physics and create the world
  box2d = new Box2DProcessing(this);
  box2d.createWorld();//new Vec2(0, 0)
  // Add a listener to listen for collisions!
  box2d.world.setContactListener(new CustomListener());
  // Create the empty lists
  hooligansp = new ArrayList<HooligansP>();
  particles= new ArrayList<particle>();
  floor = new Ground(width/2, height-105, width, 200);
  //box = new Box(1100, 510, 100, 100); 
  box2d.setGravity(0, -20);
}

public void draw() {  //------------------------------------------------------Draw---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
  if (gameState==State.LoadingImg) {//---------------------------------------------------------Loading--------------------------------------------------------------------------------------------------------------
    background(LoadingImage);
    int loading=millis();
    if (loading>=3000) {
      gameState=State.MAIN_MENU;
    }
  }
  if (gameState==State.MAIN_MENU) {//---------------------------------------------------------Main Menu--------------------------------------------------------------------------------------------------------------
    background(mainMenuImage);
    fill(0);
    imageMode(CORNER);
    image(playbutton, 525, 600);
    image(creditsbutton, 445, 700);
    image(settingsbuttonS, 285, 700);
    image(feedbackbutton, 605, 700);
    image(exitbutton, 765, 700);
    for (int b=0; b<btn1.size(); b++) {
      btn1.get(b).display();
    } 
    if (mousePressed) {
      for (int i=0; i<btn1.size(); i++) {
        if (btn1.get(i).Pressed()) {
          anyPressed1 =true;
          btn1.get(i).selected=true;
          select.trigger();
          break;
        }
      }
      if (anyPressed1 == true) {
        if (btn1.get(0).selected) {
          gameState=State.Game_Level;
          mousePressed=false;
        }
        if (btn1.get(1).selected) {
          gameState=State.CREDITS;
          mousePressed=false;
        }
        if (btn1.get(2).selected) {
          gameState=State.SETTING;
          mousePressed=false;
        }
        if (btn1.get(3).selected) {
          link("https://docs.google.com/forms/d/e/1FAIpQLSdKul9sUOmuB8pMeEKTMX1OuQ7Gx__t-A_SkHMBQ6apZsAkmQ/viewform");
          mousePressed = false;
        }        
        if (btn1.get(4).selected) {
          exit();
          mousePressed=false;
        }
      }
    }
  } else if (gameState==State.Game_Level) {//---------------------------------------------------------------------Game Level--------------------------------------------------------------------------------------------------------------
    background(GameLevel);
    imageMode(CORNER);
    image(exitbuttonS, 1150, 0);
    image(lvl1, 262, 380);
    image(lvl2, 562, 380);
    image(lvl3, 862, 380);
    fill(0);
    police.clear();
    hooligans.clear();
    if (!level2) {
      image(nono, 562, 380);
    }
    if (!level3) {
      image(nono, 862, 380);
    }
    for (int b=0; b<btn4.size(); b++) {
      btn4.get(b).display();
    }
    for (int b=0; b<btn3.size(); b++) {
      btn3.get(0).display();
    }
    if (mousePressed) {
      for (int i=0; i<btn4.size(); i++) {
        if (btn4.get(i).Pressed()) {
          anyPressed1 =true;
          btn4.get(i).selected=true;
          select.trigger();
          if (menuaudio.isPlaying()) {
            menuaudio.pause();
          } else {
            menuaudio.loop();
          }
          break;
        }
      }      
      for (int i=0; i<btn3.size(); i++) {
        if (btn3.get(i).Pressed()) {
          anyPressed3 =true;
          btn3.get(i).selected=true;
          select.trigger();
          break;
        }
      }
      if (anyPressed1 == true) {
        if (btn3.get(0).selected) {
          gameState=State.MAIN_MENU;
          mousePressed=false;
        }
        if (btn4.get(0).selected) {
          gameState=State.Level_1;
          level_1=true;
          level_2=false;
          level_3=false;
          ingameaudio.setGain(-13);
          menuaudio.pause();
          StartGame=millis();
          mousePressed=false;
        }
        if (btn4.get(1).selected && level2==true) {
          gameState=State.Level_2;
          level_2=true;
          level_1=false;
          level_3=false;
          ingameaudio.setGain(-13);
          menuaudio.pause();
          StartGame=millis();
          mousePressed=false;
        }
        if (btn4.get(2).selected && level3==true) {
          gameState=State.Level_3;
          level_3=true;
          level_2=false;
          level_1=false;
          ingameaudio.setGain(-13);
          menuaudio.pause();
          StartGame=millis();
          mousePressed=false;
        }
      }
    }
  } else if (gameState==State.Level_1) {//---------------------------------------------------------------------Level 1--------------------------------------------------------------------------------------------------------------
    background(bg);
    fill(0);
    imageMode(CORNER);
    image(pausee, 1150, 750);
    image(weapon1, 0, 0);
    image(weapon2, 202, 0);
    image(weapon3, 404, 0);
    image(weapon4, 606, 0);
    image(Minigamebtn, 997, 323);
    for (int b=0; b<btn2.size(); b++) {
      btn2.get(b).display();
    }
    for (int i=0; i<btn3.size(); i++) {
      btn3.get(1).display();
    }

    for (int p=0; p<police.size(); p++) {
      police.get(p).display();  // mira e angulo de disparo
      police.get(p).shoot(); //disparar
    }
    for (int h=hooligansp.size(); h<hooligans.size(); h++) { //inicio de add hooligans
      if (hooligans.get(h).remove) {
        hooligans.remove(h);
      } else {
        hooligans.get(h).display();
        hooligans.get(h).move();//indexOutOfBoundsException: Index:0, Size:0
      }
    }
    int diff = millis() - StartGame; //timer, millis is the time since the game started, StartGame, is the same value of the millis()
    imageMode(CORNER);
    image(clock, 1065, 505);
    text("" + diff/1000, 1115, 525);
    //text("spawn: " + StartGame/1000, 1060, 700);
    //text ("millis: "+ millis()/1000, 1060, 750);
    if (diff>=10000 && diff<=40000) { //30seg
      int wv1 = millis()-wave1;
      text("wave: 1", 1065, 560);
      if (wv1 >= 2000) {
        hooligans.add(new Hooligan_1());
        walk=millis();
        wave1=millis();
      }
    } else if (diff>=50000 && diff<=90000) { //40seg
      int wv2 = millis()-wave2;
      text("wave: 2", 1065, 560);
      if (wv2 >= 1500) {
        hooligans.add(new Hooligan_2());
        wave2=millis();
      }
    } else if (diff>= 100000 && diff<150000) { //50seg
      int wv3 = millis()-wave3;
      text("wave: 3", 1065, 560);
      if (wv3 >= 1000) {
        hooligans.add(new Hooligan_3());
        wave3=millis();
      }
    } else if (diff>= 160000 && diff <= 220000) {//60
      int wv4 = millis()-wave4;
      text("wave: 4", 1065, 560);
      if (wv4 >= 800) {
        float m =random(100);
        if (m>=1 & m<=49) {// se o tempo for maior ou igual ao intervalo add 1 hool
          hooligans.add(new Hooligan_1());
        } else if (m>=50&m<90) {
          hooligans.add(new Hooligan_2());
        } else if (m>=90&m<=100) {
          hooligans.add(new Hooligan_3());
        }  
        wave4=millis();
      }
    } else if (diff>= 230000 && diff <= 300000) {//70  230000
      int wv5 = millis()-wave5;
      text("wave: 5", 1065, 560);
      if (wv5 >= 500) {
        float m =random(3);
        if (m<=1) {// se o tempo for maior ou igual ao intervalo add 1 hool
          hooligans.add(new Hooligan_1());
        } else if (m<=2) {
          hooligans.add(new Hooligan_2());
        } else if (m<=3) {
          hooligans.add(new Hooligan_3());
        }  
        wave5=millis();
      }
    } else if (diff>= 310000 && diff<=390000) {
      int wv6 = millis()-wave6;
      text("wave: 6", 1065, 560);
      if (wv6 >= 250) {
        float m =random(3);
        if (m<=1) {// se o tempo for maior ou igual ao intervalo add 1 hool
          hooligans.add(new Hooligan_1());
        } else if (m<=2) {
          hooligans.add(new Hooligan_2());
        } else if (m<=3) {
          hooligans.add(new Hooligan_3());
        }  
        wave6=millis();
      }
    } else if (diff>=320000 && hooligans.size() == 0) {//320000
      level2=true;
      gameState=State.Game_Level;
      ingameaudio.setGain(-80);
      StartGame=0;
    }
    stadiumhealth(); // void vida do estadio
    collision(); 
    disparar();
    if (!minigame) {
      imageMode(CORNER);
      image(nonomini, 997, 323);
      if (minitrue <= millis() - minitime) {
        minigame=true;
      } else {
        minigame=false;
      }
    }
    if (keyPressed) {
      if (key =='q') {
        gameState=State.MAIN_MENU;
        ingameaudio.setGain(-80);
        keyPressed=false;
      }
    }
    /*for (int i=0; i<path.size(); i++) {                                      // This is to be abel to see the path
     ellipse(path.get(i).x, path.get(i).y, 5, 5);
     }
     stroke(255);
     for (int i=0; i<path.size()-1; i++) {
     line(path.get(i).x, path.get(i).y, path.get(i+1).x, path.get(i+1).y);
     }
     for (int i=0; i<path2.size(); i++) {
     ellipse(path2.get(i).x, path2.get(i).y, 5, 5);
     }
     stroke(255);
     for (int i=0; i<path2.size()-1; i++) {
     line(path2.get(i).x, path2.get(i).y, path2.get(i+1).x, path2.get(i+1).y);
     }
     for (int i=0; i<path3.size(); i++) {
     ellipse(path3.get(i).x, path3.get(i).y, 5, 5);
     }
     stroke(255);
     for (int i=0; i<path3.size()-1; i++) {
     line(path3.get(i).x, path3.get(i).y, path3.get(i+1).x, path3.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path4.size()-1; i++) {
     line(path4.get(i).x, path4.get(i).y, path4.get(i+1).x, path4.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path5.size()-1; i++) {
     line(path5.get(i).x, path5.get(i).y, path5.get(i+1).x, path5.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path6.size()-1; i++) {
     line(path6.get(i).x, path6.get(i).y, path6.get(i+1).x, path6.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path7.size()-1; i++) {
     line(path7.get(i).x, path7.get(i).y, path7.get(i+1).x, path7.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path8.size()-1; i++) {
     line(path8.get(i).x, path8.get(i).y, path8.get(i+1).x, path8.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path9.size()-1; i++) {
     line(path9.get(i).x, path9.get(i).y, path9.get(i+1).x, path9.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path10.size()-1; i++) {
     line(path10.get(i).x, path10.get(i).y, path10.get(i+1).x, path10.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path11.size()-1; i++) {
     line(path11.get(i).x, path11.get(i).y, path11.get(i+1).x, path11.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path12.size()-1; i++) {
     line(path12.get(i).x, path12.get(i).y, path12.get(i+1).x, path12.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path13.size()-1; i++) {
     line(path13.get(i).x, path13.get(i).y, path13.get(i+1).x, path13.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path14.size()-1; i++) {
     line(path14.get(i).x, path14.get(i).y, path14.get(i+1).x, path14.get(i+1).y); //                       the debug ends here !
     }*/
    fill(0);
    textSize(20); 
    imageMode(CORNER);
    image(money, 1065, 435);
    text(""+credits, 1110, 453);
    if (health_s<=0) {
      imageMode(CORNER);
      image(healt0, 1080, 430);
    } else if (health_s<=10) {
      imageMode(CORNER);
      image(healt10, 1090, 430);
    } else if (health_s<=20) {
      imageMode(CORNER);
      image(healt20, 1090, 430);
    } else if (health_s<=30) {
      imageMode(CORNER);
      image(healt30, 1090, 430);
    } else if (health_s<=40) {
      imageMode(CORNER);
      image(healt40, 1090, 430);
    } else if (health_s<=50) {
      imageMode(CORNER);
      image(healt50, 1090, 430);
    } else if (health_s<=60) {
      imageMode(CORNER);
      image(healt60, 1090, 430);
    } else if (health_s<=70) {
      imageMode(CORNER);
      image(healt70, 1090, 430);
    } else if (health_s<=80) {
      imageMode(CORNER);
      image(healt80, 1090, 430);
    } else if (health_s<=90) {
      imageMode(CORNER);
      image(healt90, 1090, 430);
    } else if (health_s<=100) {
      imageMode(CORNER);
      image(healt100, 1090, 430);
    }
    text("Health:", 1020, 485);
    //String cursorPos ="mousePressed-x:"+floor(mouseX)+"y:"+floor(mouseY);
    //text("framerate: " + (int)frameRate, 12, 20);
    //text(cursorPos, 888, 700);
    if (mousePressed) {
      int c = pathMask.get(mouseX, mouseY);  //path mask \u00e9 um imagem qe meti em preto em branco e assim so se pode meter nos sitios em brancos
      boolean anyPressed = false; 
      for (int i=0; i<btn2.size(); i++) {
        if (btn2.get(i).Pressed()) {
          anyPressed = true;
          select.trigger();
          //podemos usar o indice do bot\u00e3o (i) para indicar o tipo de torre
          if (towerType != i) { // quando seleccionamos um bot\u00e3o vemos se ele \u00e9 de um tipo diferente da torre que j\u00e1 tinha-mos selecionado
            btn2.get(towerType).selected = false;  //se \u00e9, ent\u00e3o pomos o selected como falso
          }
          btn2.get(i).selected = true; //indicamos que a torre precionada deve estar selected
          towerType = i; //e colocamos na towerType o indice do novo bot\u00e3o
          break;
        }
      }
      for (int i=0; i<btn3.size(); i++) {
        if (btn3.get(i).Pressed()) {
          anyPressed6 =true;
          btn3.get(i).selected=true;
          select.trigger();
          break;
        }
      }
      if (btn3.get(1).selected) {
        gameState=State.Pause;
        ingameaudio.setGain(-80);
        pause=diff; //it records the ellaps time then it will subtract with the millis to give you startgame.
        mousePressed=false;
      }
      if (anyPressed ==true) {
        if (btn2.get(4).selected && minigame==true) {
          gameState = State.MINIGAME; 
          minigametimer=millis();
          mousePressed=false;
          miniGameKilled = 0;
          miniGameNumHooligans = hooligans.size();
          box = new Box(1100, 510, 100, 100);
          pause=diff; //it records the ellaps time then it will subtract with the millis to give you startgame.}
        }
      }

      boolean insideTower = false;
      for (int i=0; i<police.size(); i++) {
        if (police.get(i).isOccupied(mouseX, mouseY)) {
          insideTower = true;
          break;
        }
      }

      if (anyPressed == false && insideTower == false) {
        switch(towerType) {
        case 0: //caso towerType tenha o valor 0
          if (credits >=50 && c== color(255, 255, 255)) {
            police.add(new Police_1(mouseX, mouseY)); // aqui acrescentarias a torre type 0
            ellipseMode(CENTER);
            fill(0);
            ellipse(mouseX, mouseY, 50, 50);
            credits -=50;
            mousePressed=false;
          }
          break; //no final de cada case \u00e9 preciso por um "break" para sair do switch
        case 1: //caso towerType tenha o valor 1
          if (credits >=100 && c== color(255, 255, 255)) {
            police.add(new Police_2(mouseX, mouseY)); // aqui acrescentarias a torre type 0
            ellipseMode(CENTER);
            ellipse(mouseX, mouseY, 50, 50);
            credits -=100;
            mousePressed=false;
          }
          break;
        case 2: //etc..
          if (credits >=250 & c== color(255, 255, 255)) {
            police.add(new Police_3(mouseX, mouseY)); // aqui esta o problema
            ellipse(mouseX, mouseY, 50, 50);
            credits -=250;
            mousePressed=false;
            println("policia3");
          }
          break;
        case 3: //etc..
          if (credits >=500 & c== color(255, 255, 255)) {
            police.add(new Police_4(mouseX, mouseY)); // aqui acrescentarias a torre type 0
            ellipseMode(CENTER);
            ellipse(mouseX, mouseY, 50, 50);
            credits -=500;
            mousePressed=false;
            println("policia4");
          }
          break;
          //END PROF RUI
        }
      }
    }
  } else if (gameState==State.Level_2) { //---------------------------------------------------------------------Level 2--------------------------------------------------------------------------------------------------------------
    background(bg2);
    fill(0);
    imageMode(CORNER);
    image(pausee, 1150, 750);
    image(weapon1, 0, 0);
    image(weapon2, 202, 0);
    image(weapon3, 404, 0);
    image(weapon4, 606, 0);
    image(Minigamebtn, 997, 323);
    for (int b=0; b<btn2.size(); b++) {
      btn2.get(b).display();
    }
    for (int i=0; i<btn3.size(); i++) {
      btn3.get(1).display();
    }
    for (int p=0; p<police.size(); p++) {
      police.get(p).display();  // mira e angulo de disparo
      police.get(p).shoot(); //disparar
    }
    for (int h=hooligansp.size(); h<hooligans.size(); h++) { //inicio de add hooligans
      if (hooligans.get(h).remove) {
        hooligans.remove(h);
      } else {
        hooligans.get(h).display();
        hooligans.get(h).move();//indexOutOfBoundsException: Index:0, Size:0
      }
    }
    int diff = millis() - StartGame; //defenir tempo
    imageMode(CORNER);
    image(clock, 1065, 505);
    text("" + diff/1000, 1115, 525);
    if (diff>=10000 && diff<=40000) { //30seg
      int wv1 = millis()-wave1;
      text("wave: 1", 1065, 560);
      if (wv1 >= 2000) {
        hooligans.add(new Hooligan_4());
        walk=millis();
        wave1=millis();
      }
    } else if (diff>=50000 && diff<=90000) { //40seg
      int wv2 = millis()-wave2;
      text("wave: 2", 1065, 560);
      if (wv2 >= 1500) {
        hooligans.add(new Hooligan_5());
        wave2=millis();
      }
    } else if (diff>= 100000 && diff<150000) { //50seg
      int wv3 = millis()-wave3;
      text("wave: 3", 1065, 560);
      if (wv3 >= 1000) {
        hooligans.add(new Hooligan_6());
        wave3=millis();
      }
    } else if (diff>= 160000 && diff <= 220000) {//60
      int wv4 = millis()-wave4;
      text("wave: 4", 1065, 560);
      if (wv4 >= 800) {
        float m =random(100);
        if (m>=1 & m<=49) {// se o tempo for maior ou igual ao intervalo add 1 hool
          hooligans.add(new Hooligan_4());
        } else if (m>=50&m<90) {
          hooligans.add(new Hooligan_5());
        } else if (m>=90&m<=100) {
          hooligans.add(new Hooligan_6());
        }  
        wave4=millis();
      }
    } else if (diff>= 230000 && diff <= 300000) {//70  230000
      int wv5 = millis()-wave5;
      text("wave: 5", 1065, 560);
      if (wv5 >= 500) {
        float m =random(3);
        if (m<=1) {// se o tempo for maior ou igual ao intervalo add 1 hool
          hooligans.add(new Hooligan_4());
        } else if (m<=2) {
          hooligans.add(new Hooligan_5());
        } else if (m<=3) {
          hooligans.add(new Hooligan_6());
        }  
        wave5=millis();
      }
    } else if (diff>= 310000 && diff<=390000) {//80
      int wv6 = millis()-wave6;
      text("wave: 6", 1065, 560);
      if (wv6 >= 250) {
        float m =random(3);
        if (m<=1) {// se o tempo for maior ou igual ao intervalo add 1 hool
          hooligans.add(new Hooligan_4());
        } else if (m<=2) {
          hooligans.add(new Hooligan_5());
        } else if (m<=3) {
          hooligans.add(new Hooligan_6());
        }  
        wave6=millis();
      }
    } else if (diff>=310000 && hooligans.size() == 0) {
      level3=true;
      gameState=State.MAIN_MENU;
      ingameaudio.setGain(-80);
      StartGame=0;
      for (int p=police.size()-1; p>=0; ) {
        police.remove(p);
        break;
      }
    }
    stadiumhealth(); // void vida do estadio
    collision(); 
    disparar();
    if (!minigame) {
      imageMode(CORNER);
      image(nonomini, 997, 323);
      if (minitrue <= millis() - minitime) {
        println("minitime:"+minitime);
        minigame=true;
      } else {
        minigame=false;
      }
    }
    if (keyPressed) {
      if (key =='q') {
        gameState=State.MAIN_MENU;
        ingameaudio.setGain(-80);
        keyPressed=false;
      }
    }
    /*for (int i=0; i<path15.size(); i++) {                                      // This is to be abel to see the path
     ellipse(path15.get(i).x, path15.get(i).y, 5, 5);
     }
     stroke(255);
     for (int i=0; i<path15.size()-1; i++) {
     line(path15.get(i).x, path15.get(i).y, path15.get(i+1).x, path15.get(i+1).y);
     }
     for (int i=0; i<path16.size(); i++) {
     ellipse(path16.get(i).x, path16.get(i).y, 5, 5);
     }
     stroke(255);
     for (int i=0; i<path16.size()-1; i++) {
     line(path16.get(i).x, path16.get(i).y, path16.get(i+1).x, path16.get(i+1).y);
     }
     for (int i=0; i<path17.size(); i++) {
     ellipse(path17.get(i).x, path17.get(i).y, 5, 5);
     }
     stroke(255);
     for (int i=0; i<path17.size()-1; i++) {
     line(path17.get(i).x, path17.get(i).y, path17.get(i+1).x, path17.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path18.size()-1; i++) {
     line(path18.get(i).x, path18.get(i).y, path18.get(i+1).x, path18.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path19.size()-1; i++) {
     line(path19.get(i).x, path19.get(i).y, path19.get(i+1).x, path19.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path20.size()-1; i++) {
     line(path20.get(i).x, path20.get(i).y, path20.get(i+1).x, path20.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path21.size()-1; i++) {
     line(path21.get(i).x, path21.get(i).y, path21.get(i+1).x, path21.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path22.size()-1; i++) {
     line(path22.get(i).x, path22.get(i).y, path22.get(i+1).x, path22.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path23.size()-1; i++) {
     line(path23.get(i).x, path23.get(i).y, path23.get(i+1).x, path23.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path24.size()-1; i++) {
     line(path24.get(i).x, path24.get(i).y, path24.get(i+1).x, path24.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path25.size()-1; i++) {
     line(path25.get(i).x, path25.get(i).y, path25.get(i+1).x, path25.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path26.size()-1; i++) {
     line(path26.get(i).x, path26.get(i).y, path26.get(i+1).x, path26.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path27.size()-1; i++) {
     line(path27.get(i).x, path27.get(i).y, path27.get(i+1).x, path27.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path28.size()-1; i++) {
     line(path28.get(i).x, path28.get(i).y, path28.get(i+1).x, path28.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path29.size()-1; i++) {
     line(path29.get(i).x, path29.get(i).y, path29.get(i+1).x, path29.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path30.size()-1; i++) {
     line(path30.get(i).x, path30.get(i).y, path30.get(i+1).x, path30.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path31.size()-1; i++) {
     line(path31.get(i).x, path31.get(i).y, path31.get(i+1).x, path31.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path32.size()-1; i++) {
     line(path32.get(i).x, path32.get(i).y, path32.get(i+1).x, path32.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path33.size()-1; i++) {
     line(path33.get(i).x, path33.get(i).y, path33.get(i+1).x, path33.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path34.size()-1; i++) {
     line(path34.get(i).x, path34.get(i).y, path34.get(i+1).x, path34.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path35.size()-1; i++) {
     line(path35.get(i).x, path35.get(i).y, path35.get(i+1).x, path35.get(i+1).y); //                       the debug ends here !
     }*/    //falta 36 37 38;
    fill(0);
    textSize(20);
    // String cursorPos ="mousePressed-x:"+floor(mouseX)+"y:"+floor(mouseY);
    //text("framerate: " + (int)frameRate, 12, 20);
    // text(cursorPos, 888, 700);
    imageMode(CORNER);
    image(money, 1065, 435);
    text(""+credits, 1110, 453);
    if (health_s<=0) {
      imageMode(CORNER);
      image(healt0, 1080, 430);
    } else if (health_s<=10) {
      imageMode(CORNER);
      image(healt10, 1090, 430);
    } else if (health_s<=20) {
      imageMode(CORNER);
      image(healt20, 1090, 430);
    } else if (health_s<=30) {
      imageMode(CORNER);
      image(healt30, 1090, 430);
    } else if (health_s<=40) {
      imageMode(CORNER);
      image(healt40, 1090, 430);
    } else if (health_s<=50) {
      imageMode(CORNER);
      image(healt50, 1090, 430);
    } else if (health_s<=60) {
      imageMode(CORNER);
      image(healt60, 1090, 430);
    } else if (health_s<=70) {
      imageMode(CORNER);
      image(healt70, 1090, 430);
    } else if (health_s<=80) {
      imageMode(CORNER);
      image(healt80, 1090, 430);
    } else if (health_s<=90) {
      imageMode(CORNER);
      image(healt90, 1090, 430);
    } else if (health_s<=100) {
      imageMode(CORNER);
      image(healt100, 1090, 430);
    }
    text("Health:", 1020, 485);
    if (mousePressed) {
      int c = pathMask2.get(mouseX, mouseY);  //path mask \u00e9 um imagem qe meti em preto em branco e assim so se pode meter nos sitios em brancos
      boolean anyPressed = false; 
      for (int i=0; i<btn2.size(); i++) {
        if (btn2.get(i).Pressed()) {
          anyPressed = true;
          select.trigger();
          //podemos usar o indice do bot\u00e3o (i) para indicar o tipo de torre
          if (towerType != i) { // quando seleccionamos um bot\u00e3o vemos se ele \u00e9 de um tipo diferente da torre que j\u00e1 tinha-mos selecionado
            btn2.get(towerType).selected = false;  //se \u00e9, ent\u00e3o pomos o selected como falso
          }
          btn2.get(i).selected = true; //indicamos que a torre precionada deve estar selected
          towerType = i; //e colocamos na towerType o indice do novo bot\u00e3o
          break;
        }
      }      
      for (int i=0; i<btn3.size(); i++) {
        if (btn3.get(i).Pressed()) {
          anyPressed6 =true;
          btn3.get(i).selected=true;
          select.trigger();
          break;
        }
      }
      if (btn3.get(1).selected) {
        gameState=State.Pause;
        ingameaudio.setGain(-80);
        mousePressed=false;
        pause=diff; //it records the ellaps time then it will subtract with the millis to give you startgame.
      }
      if (anyPressed ==true) {
        if (btn2.get(4).selected && minigame==true ) {
          gameState = State.MINIGAME2;
          minigametimer=millis();
          mousePressed=false;
          miniGameKilled = 0;
          miniGameNumHooligans = hooligans.size();
          box = new Box(1100, 510, 100, 100);
          pause=diff; //it records the ellaps time then it will subtract with the millis to give you startgame.
        }
      }

      boolean insideTower = false;
      for (int i=0; i<police.size(); i++) {
        if (police.get(i).isOccupied(mouseX, mouseY)) {
          insideTower = true;
          break;
        }
      }

      if (anyPressed == false && insideTower == false) {
        switch(towerType) {
        case 0: //caso towerType tenha o valor 0
          if (credits >=50 && c== color(255, 255, 255)) {
            police.add(new Police_1(mouseX, mouseY)); // aqui acrescentarias a torre type 0
            ellipseMode(CENTER);
            fill(0);
            ellipse(mouseX, mouseY, 50, 50);
            credits -=50;
            mousePressed=false;
          }
          break; //no final de cada case \u00e9 preciso por um "break" para sair do switch
        case 1: //caso towerType tenha o valor 1
          if (credits >=100 && c== color(255, 255, 255)) {
            police.add(new Police_2(mouseX, mouseY)); // aqui acrescentarias a torre type 0
            ellipseMode(CENTER);
            ellipse(mouseX, mouseY, 50, 50);
            credits -=100;
            mousePressed=false;
          }
          break;
        case 2: //etc..
          if (credits >=250 & c== color(255, 255, 255)) {
            police.add(new Police_3(mouseX, mouseY)); // aqui acrescentarias a torre type 0
            ellipseMode(CENTER);
            ellipse(mouseX, mouseY, 50, 50);
            credits -=250;
            mousePressed=false;
          }
          break;
        case 3: //etc..
          if (credits >=500 & c== color(255, 255, 255)) {
            police.add(new Police_4(mouseX, mouseY)); // aqui acrescentarias a torre type 0
            ellipseMode(CENTER);
            ellipse(mouseX, mouseY, 50, 50);
            credits -=500;
            mousePressed=false;
          }
          break;
          //END PROF RUI
        }
      }
    }
  } else if (gameState==State.Level_3) {//---------------------------------------------------------------------Level 3--------------------------------------------------------------------------------------------------------------
    background(bg3);
    fill(0);
    imageMode(CORNER);
    image(pausee, 1150, 750);
    image(weapon1, 0, 0);
    image(weapon2, 202, 0);
    image(weapon3, 404, 0);
    image(weapon4, 606, 0);
    image(Minigamebtn, 997, 323);
    for (int b=0; b<btn2.size(); b++) {
      btn2.get(b).display();
    }
    for (int i=0; i<btn3.size(); i++) {
      btn3.get(1).display();
    }

    for (int p=0; p<police.size(); p++) {
      police.get(p).display();  // mira e angulo de disparo
      police.get(p).shoot(); //disparar
    }
    for (int h=hooligansp.size(); h<hooligans.size(); h++) { //inicio de add hooligans
      if (hooligans.get(h).remove) {
        hooligans.remove(h);
      } else {
        hooligans.get(h).display();
        hooligans.get(h).move();//indexOutOfBoundsException: Index:0, Size:0
      }
    }
    int diff = millis() - StartGame; //defenir tempo
    imageMode(CORNER);
    image(clock, 1065, 505);
    text("" + diff/1000, 1115, 525);
    if (diff>=10000 && diff<=40000) { //30seg
      int wv1 = millis()-wave1;
      text("wave: 1", 1065, 560);
      if (wv1 >= 2000) {
        hooligans.add(new Hooligan_7());
        walk=millis();
        wave1=millis();
      }
    } else if (diff>=50000 && diff<=90000) { //40seg
      int wv2 = millis()-wave2;
      text("wave: 2", 1065, 560);
      if (wv2 >= 1500) {
        hooligans.add(new Hooligan_8());
        wave2=millis();
      }
    } else if (diff>= 100000 && diff<150000) { //50seg
      int wv3 = millis()-wave3;
      text("wave: 3", 1065, 560);
      if (wv3 >= 1000) {
        hooligans.add(new Hooligan_9());
        wave3=millis();
      }
    } else if (diff>= 160000 && diff <= 220000) {//60
      int wv4 = millis()-wave4;
      text("wave: 4", 1065, 560);
      if (wv4 >= 800) {
        float m =random(100);
        if (m>=1 & m<=49) {// se o tempo for maior ou igual ao intervalo add 1 hool
          hooligans.add(new Hooligan_7());
        } else if (m>=50&m<90) {
          hooligans.add(new Hooligan_8());
        } else if (m>=90&m<=100) {
          hooligans.add(new Hooligan_9());
        }  
        wave4=millis();
      }
    } else if (diff>= 230000 && diff <= 300000) {//70  230000
      int wv5 = millis()-wave5;
      text("wave: 5", 1065, 560);
      if (wv5 >= 500) {
        float m =random(3);
        if (m<=1) {// se o tempo for maior ou igual ao intervalo add 1 hool
          hooligans.add(new Hooligan_7());
        } else if (m<=2) {
          hooligans.add(new Hooligan_8());
        } else if (m<=3) {
          hooligans.add(new Hooligan_9());
        }  
        wave5=millis();
      }
    } else if (diff>= 310000 && diff<=390000) {
      int wv6 = millis()-wave6;
      text("wave: 6", 1065, 560);
      if (wv6 >= 250) {
        float m =random(3);
        if (m<=1) {// se o tempo for maior ou igual ao intervalo add 1 hool
          hooligans.add(new Hooligan_7());
        } else if (m<=2) {
          hooligans.add(new Hooligan_8());
        } else if (m<=3) {
          hooligans.add(new Hooligan_9());
        }  
        wave6=millis();
      }
    } else if (diff>=310000 && hooligans.size() == 0) {
      gameState=State.MAIN_MENU;
      ingameaudio.setGain(-80);
      StartGame=0;
      for (int p=police.size()-1; p>=0; ) {
        police.remove(p);
        break;
      }
    }
    stadiumhealth(); // void vida do estadio
    collision(); 
    disparar();
    if (!minigame) {
      imageMode(CORNER);
      image(nonomini, 997, 323);
      if (minitrue <= millis() - minitime) {
        println("minitime:"+minitime);
        minigame=true;
      } else {
        minigame=false;
      }
    }
    if (keyPressed) {
      if (key =='q') {
        gameState=State.MAIN_MENU;
        ingameaudio.setGain(-80);
        keyPressed=false;
      }
    }
    /*for (int i=0; i<path40.size(); i++) {                                      // This is to be abel to see the path
     ellipse(path40.get(i).x, path40.get(i).y, 5, 5);
     }
     stroke(255);
     for (int i=0; i<path40.size()-1; i++) {
     line(path40.get(i).x, path40.get(i).y, path40.get(i+1).x, path40.get(i+1).y);
     }
     for (int i=0; i<path41.size(); i++) {
     ellipse(path41.get(i).x, path41.get(i).y, 5, 5);
     }
     stroke(255);
     for (int i=0; i<path41.size()-1; i++) {
     line(path41.get(i).x, path41.get(i).y, path41.get(i+1).x, path41.get(i+1).y);
     }
     for (int i=0; i<path42.size(); i++) {
     ellipse(path42.get(i).x, path42.get(i).y, 5, 5);
     }
     stroke(255);
     for (int i=0; i<path42.size()-1; i++) {
     line(path42.get(i).x, path42.get(i).y, path42.get(i+1).x, path42.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path43.size()-1; i++) {
     line(path43.get(i).x, path43.get(i).y, path43.get(i+1).x, path43.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path44.size()-1; i++) {
     line(path44.get(i).x, path44.get(i).y, path44.get(i+1).x, path44.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path45.size()-1; i++) {
     line(path45.get(i).x, path45.get(i).y, path45.get(i+1).x, path45.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path46.size()-1; i++) {
     line(path46.get(i).x, path46.get(i).y, path46.get(i+1).x, path46.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path47.size()-1; i++) {
     line(path47.get(i).x, path47.get(i).y, path47.get(i+1).x, path47.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path48.size()-1; i++) {
     line(path48.get(i).x, path48.get(i).y, path48.get(i+1).x, path48.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path49.size()-1; i++) {
     line(path49.get(i).x, path49.get(i).y, path49.get(i+1).x, path49.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path50.size()-1; i++) {
     line(path50.get(i).x, path50.get(i).y, path50.get(i+1).x, path50.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path51.size()-1; i++) {
     line(path51.get(i).x, path51.get(i).y, path51.get(i+1).x, path51.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path52.size()-1; i++) {
     line(path52.get(i).x, path52.get(i).y, path52.get(i+1).x, path52.get(i+1).y); //                       the debug ends here !
     }
     stroke(255);
     for (int i=0; i<path53.size()-1; i++) {
     line(path53.get(i).x, path53.get(i).y, path53.get(i+1).x, path53.get(i+1).y); //                       the debug ends here !
     }*/
    fill(0);
    textSize(20); //sadsdaskdjadsbfalsvflashdvflasdvflasdvfkasvdfaiyvsairgvsa\u00e7ivgaslihfvasihgvaisyfgvasifygva\u00e7sifygvas\u00e7ifgvasi\u00e7fgvas\u00e7ifygs\u00e7faygca\u00e7sfiygcas\u00e7fucgiyas\u00e7fugycaslf\u00e7igycas\u00e7riygc\u00e7asdiyhgcasfghjasrhg asrhv ashrvfasfvasihvcaisvf\u00e7iasdvf\u00e7iasdvf
    imageMode(CORNER);
    image(money, 1065, 435);
    text(""+credits, 1110, 453);
    if (health_s<=0) {
      imageMode(CORNER);
      image(healt0, 1080, 430);
    } else if (health_s<=10) {
      imageMode(CORNER);
      image(healt10, 1090, 430);
    } else if (health_s<=20) {
      imageMode(CORNER);
      image(healt20, 1090, 430);
    } else if (health_s<=30) {
      imageMode(CORNER);
      image(healt30, 1090, 430);
    } else if (health_s<=40) {
      imageMode(CORNER);
      image(healt40, 1090, 430);
    } else if (health_s<=50) {
      imageMode(CORNER);
      image(healt50, 1090, 430);
    } else if (health_s<=60) {
      imageMode(CORNER);
      image(healt60, 1090, 430);
    } else if (health_s<=70) {
      imageMode(CORNER);
      image(healt70, 1090, 430);
    } else if (health_s<=80) {
      imageMode(CORNER);
      image(healt80, 1090, 430);
    } else if (health_s<=90) {
      imageMode(CORNER);
      image(healt90, 1090, 430);
    } else if (health_s<=100) {
      imageMode(CORNER);
      image(healt100, 1090, 430);
    }
    text("Health:", 1020, 485);
    //String cursorPos ="mousePressed-x:"+floor(mouseX)+"y:"+floor(mouseY);
    //text("framerate: " + (int)frameRate, 12, 20);
    //text(cursorPos, 888, 700);
    if (mousePressed) {
      int c = pathMask3.get(mouseX, mouseY);  //path mask \u00e9 um imagem qe meti em preto em branco e assim so se pode meter nos sitios em brancos
      boolean anyPressed = false; 
      for (int i=0; i<btn2.size(); i++) {
        if (btn2.get(i).Pressed()) {
          anyPressed = true;
          //podemos usar o indice do bot\u00e3o (i) para indicar o tipo de torre
          if (towerType != i) { // quando seleccionamos um bot\u00e3o vemos se ele \u00e9 de um tipo diferente da torre que j\u00e1 tinha-mos selecionado
            btn2.get(towerType).selected = false;  //se \u00e9, ent\u00e3o pomos o selected como falso
          }
          btn2.get(i).selected = true; //indicamos que a torre precionada deve estar selected
          towerType = i; //e colocamos na towerType o indice do novo bot\u00e3o
          break;
        }
      }
      for (int i=0; i<btn3.size(); i++) {
        if (btn3.get(i).Pressed()) {
          anyPressed6 =true;
          btn3.get(i).selected=true;
          select.trigger();
          break;
        }
      }
      if (btn3.get(1).selected) {
        gameState=State.Pause;
        ingameaudio.setGain(-80);
        pause=diff; //it records the ellaps time then it will subtract with the millis to give you startgame.
        mousePressed=false;
      }
      if (anyPressed ==true) {
        if (btn2.get(4).selected && minigame==true) {
          gameState = State.MINIGAME3; 
          minigametimer=millis();
          mousePressed=false;
          miniGameKilled = 0;
          miniGameNumHooligans = hooligans.size();
          box = new Box(1100, 510, 100, 100);
          pause=diff; //it records the ellaps time then it will subtract with the millis to give you startgame.
        }
      }

      boolean insideTower = false;
      for (int i=0; i<police.size(); i++) {
        if (police.get(i).isOccupied(mouseX, mouseY)) {
          insideTower = true;
          break;
        }
      }

      if (anyPressed == false && insideTower == false) {
        switch(towerType) {
        case 0: //caso towerType tenha o valor 0
          if (credits >=50 && c== color(255, 255, 255)) {
            police.add(new Police_1(mouseX, mouseY)); // aqui acrescentarias a torre type 0
            ellipseMode(CENTER);
            fill(0);
            ellipse(mouseX, mouseY, 50, 50);
            credits -=50;
            mousePressed=false;
          }
          break; //no final de cada case \u00e9 preciso por um "break" para sair do switch
        case 1: //caso towerType tenha o valor 1
          if (credits >=100 && c== color(255, 255, 255)) {
            police.add(new Police_2(mouseX, mouseY)); // aqui acrescentarias a torre type 0
            ellipseMode(CENTER);
            ellipse(mouseX, mouseY, 50, 50);
            credits -=100;
            mousePressed=false;
          }
          break;
        case 2: //etc..
          if (credits >=250 & c== color(255, 255, 255)) {
            police.add(new Police_3(mouseX, mouseY)); // aqui acrescentarias a torre type 0
            ellipseMode(CENTER);
            ellipse(mouseX, mouseY, 50, 50);
            credits -=250;
            mousePressed=false;
          }
          break;
        case 3: //etc..
          if (credits >=500 & c== color(255, 255, 255)) {
            police.add(new Police_4(mouseX, mouseY)); // aqui acrescentarias a torre type 0
            ellipseMode(CENTER);
            ellipse(mouseX, mouseY, 50, 50);
            credits -=500;
            mousePressed=false;
          }
          break;
          //END PROF RUI
        }
      }
    }
  } else if (gameState == State.MINIGAME) {  //---------------------------------------------------------------------------------Minigame----------------------------------------------------------------------------------------------
    background(minibg);
    int timer = millis()-minigametimer;
    fill(0);
    imageMode(CORNER);
    image(clock, 1130, 0);
    text("" + timer/1000, 1180, 20);
    box2d.step(); 
    floor.display();
    box.display();
    box.move();
    time();
    if (mousePressed) {
      float sz = random (2, 1);
      //int sht = millis() -shootParticles;
      //if (sht>=100) {
      particles.add(new particle(1035, 450, sz));
      shootParticles=millis();//0
      // }
    }
    //println(bottle.size());
    for (int b=0; b<bottle.size(); b++) {
      bottle.get(b).display();
    }
    for (int b = bottle.size() -1; b>=0; b--) {
      Bottle bo = bottle.get(b);
      if (bo.done()) {
        bottle.remove(b);
      }
    }
    for (int i=0; i<particles.size(); i++) {
      particles.get(i).display();
    }
    for (int i = particles.size()-1; i>= 0; i--) {
      particle p = particles.get(i);
      if (p.done()) {
        particles.remove(i);
      }
    }
    for (int i = hooligansp.size()-1; i>= 0; i--) {
      HooligansP p = hooligansp.get(i);
      p.display();
      //hooligansp.get(i).move();
      if (p.done() || p.remove == true) {
        p.destroyBody();
        hooligansp.remove(i);

        //hooligans.get(i).remove = true;
      }
    }
    if (timer>=times || hooligansp.size()==0 || box.copHealth <= 0) { 
      gameState= State.Level_1;
      for (int i=particles.size()-1; i>=0; i--) {
        particles.get(i).killBody();
        particles.remove(i);
      }
      for (int i=0; i<bottle.size(); i++) {
        bottle.get(i).destroyBody();
      }
      bottle.clear();
      println("exit mini game - num hooligans left:" + hooligansp.size());
      for (int i=0; i<hooligansp.size(); i++) {
        hooligansp.get(i).destroyBody();
        println("removing hooligan :" + i);
      }
      hooligansp.clear();
      for (int i=0; i<miniGameKilled; i++) {
        if (i >= hooligans.size()) {
          break;
        }
        hooligans.get(i).remove = true;
      }
      box.destroyBody();
      box = null;
      StartGame=millis()-pause;
      minigame=false;
      minitime=millis();
    }
  } else if (gameState == State.MINIGAME2) {  //---------------------------------------------------------------------------------Minigame2----------------------------------------------------------------------------------------------
    background(minibg);
    int timer = millis()-minigametimer;
    fill(0);
    imageMode(CORNER);
    image(clock, 1130, 0);
    text("" + timer/1000, 1180, 20);
    box2d.step(); 
    floor.display();
    box.display();
    box.move();
    time();
    if (mousePressed) {
      float sz = random (2, 1);
      //int sht = millis() -shootParticles;
      //if (sht>=100) {
      particles.add(new particle(1035, 450, sz));
      shootParticles=millis();//0
      // }
    }
    //println(bottle.size());
    for (int b=0; b<bottle.size(); b++) {
      bottle.get(b).display();
    }
    for (int b = bottle.size() -1; b>=0; b--) {
      Bottle bo = bottle.get(b);
      if (bo.done()) {
        bottle.remove(b);
      }
    }
    for (int i=0; i<particles.size(); i++) {
      particles.get(i).display();
    }
    for (int i = particles.size()-1; i>= 0; i--) {
      particle p = particles.get(i);
      if (p.done()) {
        particles.remove(i);
      }
    }
    for (int i = hooligansp.size()-1; i>= 0; i--) {
      HooligansP p = hooligansp.get(i);
      p.display();
      //hooligansp.get(i).move();
      if (p.done() || p.remove == true) {
        p.destroyBody();
        hooligansp.remove(i);

        //hooligans.get(i).remove = true;
      }
    }
    if (timer>=times || hooligansp.size()==0 || box.copHealth <= 0) { 
      gameState= State.Level_2;
      for (int i=particles.size()-1; i>=0; i--) {
        particles.get(i).killBody();
        particles.remove(i);
      }
      for (int i=0; i<bottle.size(); i++) {
        bottle.get(i).destroyBody();
      }
      bottle.clear();
      println("exit mini game - num hooligans left:" + hooligansp.size());
      for (int i=0; i<hooligansp.size(); i++) {
        hooligansp.get(i).destroyBody();
        println("removing hooligan :" + i);
      }
      hooligansp.clear();
      for (int i=0; i<miniGameKilled; i++) {
        if (i >= hooligans.size()) {
          break;
        }
        hooligans.get(i).remove = true;
      }
      box.destroyBody();
      box = null;
      StartGame=millis()-pause;
      minigame=false;
      minitime=millis();
    }
  } else if (gameState == State.MINIGAME3) {  //---------------------------------------------------------------------------------Minigame3----------------------------------------------------------------------------------------------
    background(minibg);
    int timer = millis()-minigametimer;
    fill(0);
    imageMode(CORNER);
    image(clock, 1130, 0);
    text("" + timer/1000, 1180, 20);
    box2d.step(); 
    floor.display();
    box.display();
    box.move();
    time();
    if (mousePressed) {
      float sz = random (2, 1);
      //int sht = millis() -shootParticles;
      //if (sht>=100) {
      particles.add(new particle(1035, 450, sz));
      shootParticles=millis();//0
      // }
    }
    //println(bottle.size());
    for (int b=0; b<bottle.size(); b++) {
      bottle.get(b).display();
    }
    for (int b = bottle.size() -1; b>=0; b--) {
      Bottle bo = bottle.get(b);
      if (bo.done()) {
        bottle.remove(b);
      }
    }
    for (int i=0; i<particles.size(); i++) {
      particles.get(i).display();
    }
    for (int i = particles.size()-1; i>= 0; i--) {
      particle p = particles.get(i);
      if (p.done()) {
        particles.remove(i);
      }
    }
    for (int i = hooligansp.size()-1; i>= 0; i--) {
      HooligansP p = hooligansp.get(i);
      p.display();
      //hooligansp.get(i).move();
      if (p.done() || p.remove == true) {
        p.destroyBody();
        hooligansp.remove(i);

        //hooligans.get(i).remove = true;
      }
    }
    if (timer>=times || hooligansp.size()==0 || box.copHealth <= 0) { 
      gameState= State.Level_3;
      for (int i=particles.size()-1; i>=0; i--) {
        particles.get(i).killBody();
        particles.remove(i);
      }
      for (int i=0; i<bottle.size(); i++) {
        bottle.get(i).destroyBody();
      }
      bottle.clear();
      println("exit mini game - num hooligans left:" + hooligansp.size());
      for (int i=0; i<hooligansp.size(); i++) {
        hooligansp.get(i).destroyBody();
        println("removing hooligan :" + i);
      }
      hooligansp.clear();
      for (int i=0; i<miniGameKilled; i++) {
        if (i >= hooligans.size()) {
          break;
        }
        hooligans.get(i).remove = true;
      }
      box.destroyBody();
      box = null;
      StartGame=millis()-pause;
      minigame=false;
      minitime=millis();
    }
  } else if (gameState== State.GAME_OVER) {
    imageMode(CENTER);
    image(GameOver, width/2, height/2);
    imageMode(CORNER);
    image(exitbuttonS, 1150, 0);
    ingameaudio.setGain(-80);
    menuaudio.play();
    for (int b=0; b<btn3.size(); b++) {
      btn3.get(b).display();
    } 
    if (mousePressed) {
      for (int i=0; i<btn3.size(); i++) {
        if (btn3.get(i).Pressed()) {
          anyPressed3 =true;
          btn3.get(i).selected=true;
          select.trigger();
          break;
        }
      }
      if (btn3.get(0).selected) {
        StartGame=0;
        gameState=State.MAIN_MENU;
        ingameaudio.setGain(-80);
        mousePressed=false;
      }
    }
    if (keyPressed) {
      if (key =='q') {
        gameState=State.MAIN_MENU;
        ingameaudio.setGain(-80);
        keyPressed=false;
      }
    }
  } else if (gameState==State.Pause) {//---------------------------------------------------------------------------------Pause----------------------------------------------------------------------------------------------
    imageMode(CENTER);
    image(Pause, width/2, height/2);
    if (!Music) {
      image(nono150, 600, 555);
    }
    if (!SoundEffect) {
      image(nono150, 280, 555);
    }
    menuaudio.play();
    for (int i=0; i<btn6.size(); i++) {
      btn6.get(i).display();
    }
    if (mousePressed) {
      for (int i=0; i<btn6.size(); i++) {
        if (btn6.get(i).Pressed()) {
          anyPressed6=true;
          btn6.get(i).selected=true;
          select.trigger();
          break;
        }
      } 
      if (btn6.get(0).selected) {
        gameState=State.Game_Level;
        mousePressed=false;
      } 
      if (btn6.get(1).selected && level_1==true && level_2==false && level_3 ==false) {
        gameState=State.Level_1;
        if (Music==true) {
          ingameaudio.setGain(-13);
        } else if (!Music) {
          ingameaudio.setGain(-80);
        }
        menuaudio.pause();
        StartGame=millis()-pause;
        mousePressed=false;
      } 
      if (btn6.get(1).selected && level_1==false && level_2==true && level_3 ==false) {
        gameState=State.Level_2;
        if (Music==true) {
          ingameaudio.setGain(-13);
        } else if (!Music) {
          ingameaudio.setGain(-80);
        }
        menuaudio.pause();
        StartGame=millis()-pause;
        mousePressed=false;
      }
      if (btn6.get(1).selected && level_1==false && level_2==false && level_3 ==true) {
        gameState=State.Level_3;
        if (Music==true) {
          ingameaudio.setGain(-13);
        } else if (!Music) {
          ingameaudio.setGain(-80);
        }
        menuaudio.pause();
        StartGame=millis()-pause;
        mousePressed=false;
      }
      if (btn6.get(2).selected) {
        gameState=State.MAIN_MENU;
        mousePressed=false;
      } 
      if (btn6.get(3).selected && SoundEffect==true ) {
        gunfire.setGain(-80);
        SoundEffect=false;
        println("false");
        mousePressed=false;
      } else if (btn6.get(3).selected && SoundEffect==false) {
        gunfire.setGain(-40);
        SoundEffect=true;
        println("true");
        mousePressed=false;
      } 
      if (btn6.get(4).selected&& Music==true) {
        ingameaudio.setGain(-80); //Credit FNC Effects
        Music=false;
        mousePressed=false;
      } else if (btn6.get(4).selected&& Music==false) {
        Music=true;
        ingameaudio.setGain(-13);
        mousePressed=false;
      }
      if (btn6.get(5).selected) {
        exit();
        mousePressed=false;
      }
    }
  } else if (gameState== State.SETTING) { //---------------------------------------------------------------------------------SETTINGS-----------------------------------------------------------------------------------------------
    background(GameLevel);
    imageMode(CORNER);
    image(exitbuttonS, 1150, 0);
    image(Controllers, width/9, height/2-75);
    image(difficulty, 3*width/9, height/2-75);
    image(sound, 5*width/9, height/2-75);//875
    image(music, 7*width/9, height/2-75);
    if (!MenuMusic) {
      image(nono150, 7*width/9, height/2-75);
    }
    if (!MenuSound) {
      image(nono150, 5*width/9, height/2-75);
    }
    for (int b=0; b<btn3.size(); b++) {
      btn3.get(0).display();
    }
    for (int b=0; b<btn5.size(); b++) {
      btn5.get(b).display();
    }

    if (mousePressed) {
      for (int i=0; i<btn3.size(); i++) {
        if (btn3.get(i).Pressed()) {
          anyPressed3 =true;
          btn3.get(i).selected=true;
          select.trigger();
          break;
        }
      }
      for (int i=0; i<btn5.size(); i++) {
        if (btn5.get(i).Pressed()) {
          anyPressed5 = true;
          btn5.get(i).selected = true;
          select.trigger();
          break;
        }
      }
      if (btn3.get(0).selected) {
        gameState=State.MAIN_MENU;
        mousePressed=false;
      }
      if (btn5.get(0).selected) {
        gameState=State.Controls;
        mousePressed = false;
      }
      if ( btn5.get(1).selected) {
        gameState=State.Difficulty;
        mousePressed=false;
      } 
      if (btn5.get(2).selected && MenuSound==true ) {
        select.setGain(-80);
        MenuSound=false;
        println("false");
        mousePressed=false;
      } else if (btn5.get(2).selected && MenuSound==false) {
        select.setGain(0);
        MenuSound=true;
        println("true");
        mousePressed=false;
      }      
      if (btn5.get(3).selected&& MenuMusic==true) {
        menuaudio.setGain(-80); 
        MenuMusic=false;
        mousePressed=false;
      } else if (btn5.get(3).selected&& MenuMusic==false) {
        menuaudio.setGain(-13); 
        MenuMusic=true;
        mousePressed=false;
      }
    } 
    if (keyPressed) {
      if (key =='q') {
        gameState=State.MAIN_MENU;
        keyPressed=false;
      }
    }
  } else if (gameState== State.Controls) {//---------------------------------------------------------------------------------Controls----------------------------------------------------------------------------------------------
    background(Controls);    
    imageMode(CORNER);
    image(exitbuttonS, 1150, 0);
    for (int b=0; b<btn3.size(); b++) {
      btn3.get(0).display();
    } 
    if (mousePressed) {
      for (int i=0; i<btn3.size(); i++) {
        if ( btn3.get(i).Pressed()) {
          anyPressed3 = true; 
          btn3.get(i).selected = true;
          select.trigger();
          break;
        }
      }
      if (btn3.get(0).selected) {
        gameState=State.SETTING;
        mousePressed=false;
      }
    }
  } else if (gameState == State.Difficulty) {//---------------------------------------------------------------------------------Difficulty----------------------------------------------------------------------------------------------
    //imageMode(CENTER);
    //image(yadyadyadyayda,width/2,height/2);
    background(GameLevel);
    imageMode(CORNER);
    image(easy, 225, 350);
    image(medium, 525, 350);
    image(hard, 825, 350);
    for (int b=0; b<btn8.size(); b++) {
      btn8.get(b).display();
    }
    if (mousePressed) {
      for (int i=0; i<btn8.size(); i++) {
        if (btn8.get(i).Pressed()) {
          anyPressed5 = true;
          select.trigger();
          break;
        }
      }
      if (btn8.get(0).selected) {
        credits+=500;
        gameState = State.MAIN_MENU;
        mousePressed=false;
      }
      if (btn8.get(1).selected) {
        credits += 0;
        gameState = State.MAIN_MENU;
        mousePressed=false;
      }
      if (btn8.get(2).selected) {
        credits -=300; 
        gameState = State.MAIN_MENU;
        mousePressed = false;
      }
    }
  } else if (gameState == State.Audio) {//---------------------------------------------------------------------------------Audio----------------------------------------------------------------------------------------------
    background(GameLevel);
    for (int b=0; b<btn3.size(); b++) {
      btn3.get(b).display();
    }
    for (int b=0; b<btn5.size(); b++) {
      btn5.get(b).display();
    }

    if (mousePressed) {
      for (int i=0; i<btn3.size(); i++) {
        if (btn3.get(i).Pressed()) {
          anyPressed3 =true;
          btn3.get(i).selected=true;
          select.trigger();
          break;
        }
      }
      for (int i=0; i<btn5.size(); i++) {
        if (btn5.get(i).Pressed()) {
          anyPressed5 = true;
          btn5.get(i).selected = true;
          select.trigger();
          break;
        }
      }
      if (btn3.get(0).selected) {
        gameState=State.SETTING;
        mousePressed=false;
      }
      if (btn5.get(4).selected) {
        gameState=State.Music;
        mousePressed = false;
      }
      if ( btn5.get(5).selected) {
        gameState=State.SoundEffect;
        mousePressed=false;
      }
    }
  } else if (gameState == State.Music) {//---------------------------------------------------------------------------------Music----------------------------------------------------------------------------------------------
  } else if (gameState==State.SoundEffect) {//---------------------------------------------------------------------------------SoundEffect----------------------------------------------------------------------------------------------
  } else if (gameState == State.CREDITS) {//---------------------------------------------------------------------------------Credits----------------------------------------------------------------------------------------------
    imageMode(CENTER);
    image(creditsm, width/2, height/2);
    imageMode(CORNER);
    image(exitbuttonS, 1150, 0);
    for (int b=0; b<btn3.size(); b++) {
      btn3.get(0).display();
    } 
    if (mousePressed) {
      for (int i=0; i<btn3.size(); i++) {
        if (btn3.get(i).Pressed()) {
          anyPressed3 =true;
          btn3.get(i).selected=true;
          select.trigger();
          break;
        }
      }
      if (btn3.get(0).selected) {
        gameState=State.MAIN_MENU;
        mousePressed=false;
      }
    }
    if (keyPressed) {
      if (key =='q') {
        gameState=State.MAIN_MENU;
        keyPressed=false;
      }
    }
  }
}
public void keyPressed() {
  switch (gameState) {
  case MAIN_MENU:
    {
      if (key =='1') {
        gameState=State.Game_Level;
        break;
      }
      if (key =='2') {
        gameState=State.CREDITS;
        break;
      }
      if (key =='3') {
        gameState=State.SETTING;
        break;
      }
      if (key =='4') {
        gameState=State.FEEDBACK;
        break;
      }
    }
  case Game_Level:
    {
      if (key == 'n') {//cheat
        level2=true;
      }
      if (key == 'b') {
        level3=true;
      }
    }
  case Level_1:
    {
      if ( key == 'm') { // cheat
        credits+=1000;
      } else if (key =='r') {
        gameState= State.MINIGAME;
        minigametimer=millis();
        mousePressed=false;
        miniGameKilled = 0;
        miniGameNumHooligans = hooligans.size();
        keyPressed = false;
      }
    }
  case Level_2:
    {
      if ( key == 'm') { // cheat
        credits+=1000;
      } else if (key =='r') {
        gameState= State.MINIGAME;
        minigametimer=millis();
        mousePressed=false;
        miniGameKilled = 0;
        miniGameNumHooligans = hooligans.size();
        keyPressed = false;
      }
    } 
  case Level_3:
    {
      if ( key == 'm') { //cheat
        credits+=1000;
      } else if (key =='r') {
        gameState= State.MINIGAME;
        minigametimer=millis();
        mousePressed=false;
        miniGameKilled = 0;
        miniGameNumHooligans = hooligans.size();
        keyPressed = false;
      }
    }  
  case CREDITS:
    {
    }
  case FEEDBACK:
    {
    }
  case GAME_OVER:
    {
    }
  case MINIGAME:
    {
    }
  case SETTING:
    {
    }
  }
}

public void stadiumhealth () { //basically when you run out of HP, just trie again!  
  if (health_s <= 0) {
    gameState= State.GAME_OVER;
  }
}
public void collision () { 
  for (int i=0; i<bullet.size(); i++) { //collision between Bullet and hooligans 
    for (int h=0; h<hooligans.size(); h++) {
      float distance = dist(hooligans.get(h)._x, hooligans.get(h)._y, bullet.get(i).position.x, bullet.get(i).position.y);
      if (distance<25) { //if the distance between them is smaller than 25 it means the hooligans got hit and we have to remove the bullet.
        bullet.remove(i); 
        hooligans.get(h).damage();
        break;
      }
    }
  }
}
public void disparar () { //this is the direction when the tower fire...
  for (int i=0; i<bullet.size(); i++) {
    bullet.get(i).display();
    gunfire.trigger();
    if ((bullet.get(i).position.x)>width|| (bullet.get(i).position.x)<0 || (bullet.get(i).position.y)>height|| (bullet.get(i).position.y)<0) { //in case the bullet is outside of the game, it just remove it from the game world aka processing
      bullet.remove(i);
    }
  }
}
public void time() { 
  int diff = millis() - spawn_minigame;
  if (miniGameNumHooligans > 0) {   
    if (diff >= 500) { //cada meio segundo aparece um enimigo
      walk=millis();
      hooligansp.add(new HooligansP(posX, 580));
      spawn_minigame = millis();
      miniGameNumHooligans--;
    }
  }
}
class Bottle {
  Body body;
  float r;
  PVector position = new PVector();
  int col;
  boolean delete =false;

  Bottle(float x, float y, float r_) {
    position.x=x;
    position.y=y;
    r=r_;
    makeBody(new Vec2(x, y), r);
    body.setUserData(this);
  }
  public void killBody() {
    box2d.destroyBody(body);
  }
  public void delete() {
    delete=true;
  }

  public boolean done() {
    Vec2 pos = box2d.getBodyPixelCoord(body);

    if (pos.y < 0 || delete) {
      killBody();
      return true;
    }
    return false;
  }

  public boolean done2() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    if (pos.x > width+r*2 || delete) {
      killBody();
      return true;
    }
    return false;
  }


  public void display() {

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
  public void destroyBody() {
    box2d.destroyBody(body);
  }
  public void makeBody(Vec2 center, float r) {
    BodyDef bd = new BodyDef();
    bd.position.set(box2d.coordPixelsToWorld(center));
    bd.type=BodyType.DYNAMIC;
    body=box2d.world.createBody(bd);

    PolygonShape ps = new PolygonShape();
    float w = box2d.scalarPixelsToWorld(20);
    FixtureDef fd = new FixtureDef();
    ps.setAsBox(w, w);
    fd.shape=ps;
    //perguntar o que \u00e9 que estes 3 parametros afetam
    fd.density = 1;
    fd.friction=0.5f;
    fd.restitution=0.2f;
    body.createFixture(fd);
  }
}
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

  public void display() {
    //target = new PVector(dirX, dirY);
    fill(0xffFF0303);
    imageMode(CENTER);
    image(rock,position.x,position.y);
    //ellipse(position.x, position.y, 10, 10); //bullet
    PVector velocity = PVector.sub(target, gun); //compute the difference vector (start to end) = direction 
    position.add(new PVector(velocity.x/2, velocity.y/2)); //add velocidade a nova posi\u00e7\u00e3o
  }
}
class Button {
  int rectSize;     // Diameter of rect
  int highSize;   //altura dos rectangulos
  float x, y, w, h;  
  boolean selected;
  int colo;
  Button(float _x, float _y) {
    x= _x;
    y= _y;
    rectSize =217;
    highSize = 128;
    w=rectSize;
    h=highSize;
    colo=0xff0FFF79;
  }
  public void display() { 
    /*stroke(0);
     noFill();
     rectMode(CORNER);
     rect(x, y, w, h);*/
    noFill();
    if (Pressed()) {
      stroke (255, 0, 120);
      rect(x, y, w, h);
    } else {    
      /*stroke(0);
       noFill();
       rect(x, y, w, h);*/
    }
    if (selected) {
      //fill(0,255,120);
      stroke(colo);
      rectMode(CORNER);
      rect(x, y, w, h);
    }
  }
  public boolean Pressed() {
    if (mouseX >= x & mouseX <=x+ rectSize & mouseY >= y & mouseY <= y+highSize) {
      selected =true;
      return true;
    } else {
      selected = false;
      return false;
    }
  }
}
class Button1 extends Button {

  Button1(float _x, float _y) {  //for the main menu
    super(_x, _y);
    x= _x;
    y= _y;
    rectSize=150;
    highSize=50;
    w=rectSize;
    h=highSize;
    colo=0xffD8D8D8;
  }
}
class Button2 extends Button {

  Button2(float _x, float _y) { // for in game buttons
    super(_x, _y);
    x= _x;
    y= _y;
    rectSize=198;
    highSize=89;
    w=rectSize;
    h=highSize;
  }
}
class Button3 extends Button {

  Button3(float _x, float _y) { //for exit Game over, credits, settings
    super(_x, _y);
    x= _x;
    y= _y;
    rectSize=50;
    highSize=50;
    w=rectSize;
    h=highSize;
    colo=0xffD8D8D8;
  }
}
class Button4 extends Button {

  Button4(float _x, float _y) { //for levels section 
    super(_x, _y);
    x= _x;
    y= _y;
    rectSize=50;
    highSize=100;
    w=rectSize;
    h=highSize;
    colo=0xffD8D8D8;
  }
}
class Button5 extends Button {

  Button5(float _x, float _y) { //this is for the setting - diffulty and yadyadyada
  super(_x, _y);
    x= _x;
    y= _y;
    rectSize=150;
    highSize=150;
    w=rectSize;
    h=highSize;
    colo=0xffD8D8D8;
  }
}
class Button6 extends Button {

  Button6(float _x, float _y) {//Pause menu wUt I have done!
    super(_x, _y);
    x= _x;
    y= _y;
    rectSize=202;
    highSize=190;
    w=rectSize;
    h=highSize;
    colo=0xffD8D8D8;
  }
}
class Button7 extends Button {

  Button7(float _x, float _y) {//Pause button S wUt I have done!
    super(_x, _y);
    x= _x;
    y= _y;
    rectSize=50;
    highSize=50;
    w=rectSize;
    h=highSize;
    colo=0xffD8D8D8;
  }
}
class Button8 extends Button {

  Button8(float _x, float _y) {//how hard is the game?
    super(_x, _y);
    x= _x;
    y= _y;
    rectSize=165;
    highSize=75;
    w=rectSize;
    h=highSize;
    colo=0xffD8D8D8;
  }
}
//isto sao as colisoes para o BOX2D

// The Nature of Code
// <http://www.shiffman.net/teaching/nature>
// Spring 2010
// Box2DProcessing example

// ContactListener to listen for collisions!






class CustomListener implements ContactListener {
  CustomListener() {
  }

  // This function is called when a new collision occurs
  public void beginContact(Contact cp) {
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
    //pode ser uma colis\u00e3o entre objectos que n\u00e3o tenham o user data definido. Nesses casos n\u00e3o queremos 
    //detectar colis\u00f5es, pelo que fazemos logo return
    if (o1 == null || o2 == null) { 
      return;
    }
    //println(o1.getClass());
    //println(o3.getClass());
    //este 'if' detecta se o primeiro objecto \u00e9 uma particle e o segundo um Hooligan
    if (o1.getClass() == particle.class && o2.getClass() == HooligansP.class) {
      particle p = (particle)o1; //fazemos um 'cast' do 'o1' para a sua class particle
      HooligansP h = (HooligansP)o2; //fazemos um 'cast' do 'o2' para a sua class Hooligans
      p.delete(); //chamamos a fun\u00e7\u00e3o delete da particle
      h.kill(); //chamamos a fun\u00e7\u00e3o delete do hooligan
      hooligansp.remove(this);
      //o 'else if' a seguir verifica o caso de o Box2D detectar a colis\u00e3o com os objectos na ordem contr\u00e1ria
    } else if (o2.getClass() == particle.class && o1.getClass() == HooligansP.class) {
      particle p = (particle)o2; //fazemos um 'cast' do 'o2' para a sua class particle
      HooligansP h = (HooligansP)o1; //fazemos um 'cast' do 'o1' para a sua class hooligan
      p.delete(); //chamamos a fun\u00e7\u00e3o delete da particle
      h.kill(); //chamamos a fun\u00e7\u00e3o delete do hooligan

      //o 'else if' verifica o caso em que o o1 \u00e9 uma particula mas o o2 n\u00e3o \u00e9 um hooligan
      //por exemplo se a particula colidiu com o ch\u00e3o ou outro objecto, tamb\u00e9m querem apagar a particula
    } else if (o1.getClass() == particle.class) {
      particle p = (particle)o1;
      p.delete();

      //o 'else if' verifica o caso em que o o2 \u00e9 uma particula mas o o1 n\u00e3o \u00e9 um hooligan
      //por exemplo se a particula colidiu com o ch\u00e3o ou outro objecto, tamb\u00e9m querem apagar a particula
      /*  } else if (o2.getClass() == particle.class) {
       particle p = (particle)o2;
       p.delete();*/
    } else if (o1.getClass() == Bottle.class && o2.getClass() == Box.class) {
      Bottle b = (Bottle)o1; //fazemos um 'cast' do 'o1' para a sua class garrafa
      Box bx = (Box)o2; //fazemos um 'cast' do 'o2' para a sua class COPVAN
      b.delete();//chamamos a fun\u00e7\u00e3o delete da garrafa
      bx.hit();
      //bottle.remove(this);
      //println("987987987987");
    } else if (o2.getClass() == Bottle.class && o1.getClass() == Box.class) {
      Bottle b = (Bottle)o2; //fazemos um 'cast' do 'o2' para a sua class garrafa
      Box bx = (Box)o1; //fazemos um 'cast' do 'o1' para a sua class CopVan
      b.delete(); //chamamos a fun\u00e7\u00e3o delete da garrafa
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
    //chamamos a fun\u00e7\u00e3o delete do bottle
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
   //pode ser uma colis\u00e3o entre objectos que n\u00e3o tenham o user data definido. Nesses casos n\u00e3o queremos 
   //detectar colis\u00f5es, pelo que fazemos logo return
   if (o1 == null || o2 == null) { 
   return;
   }
   println(o1.getClass());
   //este 'if' detecta se o primeiro objecto \u00e9 uma particle e o segundo um Hooligan
   if (o1.getClass() == Bottle.class && o2.getClass() == Box.class) {
   Bottle b = (Bottle)o1; //fazemos um 'cast' do 'o1' para a sua class particle
   Box bx = (Box)o2; //fazemos um 'cast' do 'o2' para a sua class Hooligans
   b.delete();//chamamos a fun\u00e7\u00e3o delete da particle
   bx.hit();
   //chamamos a fun\u00e7\u00e3o delete do hooligan
   
   //o 'else if' a seguir verifica o caso de o Box2D detectar a colis\u00e3o com os objectos na ordem contr\u00e1ria
   } else if (o2.getClass() == Bottle.class && o1.getClass() == Box.class) {
   Bottle b = (Bottle)o2; //fazemos um 'cast' do 'o2' para a sua class particle
   Box bx = (Box)o1; //fazemos um 'cast' do 'o1' para a sua class hooligan
   b.delete(); //chamamos a fun\u00e7\u00e3o delete da particle
   bx.hit();
   //chamamos a fun\u00e7\u00e3o delete do hooligan
   
   //o 'else if' verifica o caso em que o o1 \u00e9 uma particula mas o o2 n\u00e3o \u00e9 um hooligan
   //por exemplo se a particula colidiu com o ch\u00e3o ou outro objecto, tamb\u00e9m querem apagar a particula
   } else if (o1.getClass() == Bottle.class) {
   Bottle b = (Bottle)o1;
   b.delete();
   }
   }*/

  public void endContact(Contact contact) {
    // TODO Auto-generated method stub
  }

  public void preSolve(Contact contact, Manifold oldManifold) {
    // TODO Auto-generated method stub
  }

  public void postSolve(Contact contact, ContactImpulse impulse) {
    // TODO Auto-generated method stub
  }
}
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
  public void display() {
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
  public void hit() {
    println("LOLOLOLOLOLDODLOasdbhasidgfaisfasdfasdfasdfasdfjhvnvejbhdge");
    copHealth -= 15;
  }
  public boolean contains(float x, float y) { //just copied to see if it works
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

  public void move() {
    Vec2 pos = box2d.getBodyPixelCoord(body); // only for moving object
    if (key=='a') {
      body.setLinearVelocity(new Vec2(-10, 0));
    } else if (key=='d') {
      body.setLinearVelocity(new Vec2(10, 0));
    } else if (key=='w') {
      body.setLinearVelocity(new Vec2(0, 10));
    }
  }
  public void destroyBody() {
    box2d.destroyBody(body);
  }

  public Vec2 getPos() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    return pos;
  }
}
class Hooligan_1 extends Hooligans {
  Hooligan_1() {
    score = 2; 
    health = 150;
    imageRotate=PI/2;
    l=15;
    c=15;
    speed=1;
      imageToDraw = hooligan1;
      imageToDrawa = hooligan1a;
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
class Hooligan_2 extends Hooligans {
  Hooligan_2() {
    score = 5; 

    imageToDraw = hooligan2;
    imageToDrawa = hooligan2a;
    health = 200;

    imageRotate=PI/2;
    l=15;
    c=15;
    speed=0.7f;
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
class Hooligan_3 extends Hooligans {
  Hooligan_3() {
    score = 10; 
    imageToDraw = hooligan3;
    imageToDrawa = hooligan3a;
    health = 350;
    imageRotate = PI/2;
    l=15;
    c=15;
    speed=0.5f;
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
class Hooligan_4 extends Hooligans {
  Hooligan_4() {
    score = 5; 
    imageToDraw = hooligan1;
    imageToDrawa = hooligan1a;
    health = 200;
    imageRotate = PI/2;
    l=11;
    c=11;
    speed=1;
    float p=random(24);
    if (p<=1) {
      pathToFollow = path15;
      _x=95;
      _y=676;
    } else if (p<=2) {
      pathToFollow = path16;
      _x=95;
      _y=676;
    } else if (p<=3) {
      pathToFollow= path17;
      _x=95;
      _y=676;
    } else if (p<=4) {
      pathToFollow = path18;
      _x=95;
      _y=676;
    } else if (p<=5) {
      pathToFollow = path19;
      _x=95;
      _y=676;
    } else if (p<=6) {
      pathToFollow = path20;
      _x=95;
      _y=676;
    }else if (p<=7) {
      pathToFollow = path21;
      _x=95;
      _y=676;
    }else if (p<=8) {
      pathToFollow = path22;
      _x=65;
      _y=255;
    }else if (p<=9) {
      pathToFollow = path23;
      _x=65;
      _y=255;
    }else if (p<=10) {
      pathToFollow = path24;
      _x=65;
      _y=255;
    }else if (p<=11) {
      pathToFollow = path25;
      _x=264;
      _y=692;
    }else if (p<=12) {
      pathToFollow = path26;
      _x=264;
      _y=692;
    }else if (p<=13) {
      pathToFollow = path27;
      _x=264;
      _y=692;
    }else if (p<=14) {
      pathToFollow = path28;
      _x=264;
      _y=692;
    }else if (p<=15) {
      pathToFollow = path29;
      _x=264;
      _y=692;
    }else if (p<=16) {
      pathToFollow = path30;
      _x=264;
      _y=692;
    }else if (p<=17) {
      pathToFollow = path31;
      _x=264;
      _y=692;
    }else if (p<=18) {
      pathToFollow = path32;
      _x=264;
      _y=692;
    }else if (p<=19) {
      pathToFollow = path33;
      _x=264;
      _y=692;
    }else if (p<=20) {
      pathToFollow = path34;
      _x=264;
      _y=692;
    }else if (p<=21) {
      pathToFollow = path35;
      _x=264;
      _y=692;
    }else if (p<=22) {
      pathToFollow = path36;
      _x=59;
      _y=92;
    }else if (p<=23) {
      pathToFollow = path37;
      _x=59;
      _y=92;
    }else if (p<=24) {
      pathToFollow = path38;
      _x=59;
      _y=92;
    }
  }
}
class Hooligan_5 extends Hooligans {
  Hooligan_5() {
    score = 10; 
    imageToDraw = hooligan2;
    imageToDrawa = hooligan2a;
    health = 350;
    imageRotate = PI/2;
    l=11;
    c=11;
    speed=0.7f;
      float p=random(24);
    if (p<=1) {
      pathToFollow = path15;
      _x=95;
      _y=676;
    } else if (p<=2) {
      pathToFollow = path16;
      _x=95;
      _y=676;
    } else if (p<=3) {
      pathToFollow= path17;
      _x=95;
      _y=676;
    } else if (p<=4) {
      pathToFollow = path18;
      _x=95;
      _y=676;
    } else if (p<=5) {
      pathToFollow = path19;
      _x=95;
      _y=676;
    } else if (p<=6) {
      pathToFollow = path20;
      _x=95;
      _y=676;
    }else if (p<=7) {
      pathToFollow = path21;
      _x=95;
      _y=676;
    }else if (p<=8) {
      pathToFollow = path22;
      _x=65;
      _y=255;
    }else if (p<=9) {
      pathToFollow = path23;
      _x=65;
      _y=255;
    }else if (p<=10) {
      pathToFollow = path24;
      _x=65;
      _y=255;
    }else if (p<=11) {
      pathToFollow = path25;
      _x=264;
      _y=692;
    }else if (p<=12) {
      pathToFollow = path26;
      _x=264;
      _y=692;
    }else if (p<=13) {
      pathToFollow = path27;
      _x=264;
      _y=692;
    }else if (p<=14) {
      pathToFollow = path28;
      _x=264;
      _y=692;
    }else if (p<=15) {
      pathToFollow = path29;
      _x=264;
      _y=692;
    }else if (p<=16) {
      pathToFollow = path30;
      _x=264;
      _y=692;
    }else if (p<=17) {
      pathToFollow = path31;
      _x=264;
      _y=692;
    }else if (p<=18) {
      pathToFollow = path32;
      _x=264;
      _y=692;
    }else if (p<=19) {
      pathToFollow = path33;
      _x=264;
      _y=692;
    }else if (p<=20) {
      pathToFollow = path34;
      _x=264;
      _y=692;
    }else if (p<=21) {
      pathToFollow = path35;
      _x=264;
      _y=692;
    }else if (p<=22) {
      pathToFollow = path36;
      _x=59;
      _y=92;
    }else if (p<=23) {
      pathToFollow = path37;
      _x=59;
      _y=92;
    }else if (p<=24) {
      pathToFollow = path38;
      _x=59;
      _y=92;
    }
  }
}
class Hooligan_6 extends Hooligans {
  Hooligan_6() {
    score = 15; 
    imageToDraw = hooligan3;
    imageToDrawa = hooligan3a;
    health = 500;
    imageRotate = PI/2;
    l=11;
    c=11;
    speed=0.5f;
      float p=random(24);
    if (p<=1) {
      pathToFollow = path15;
      _x=95;
      _y=676;
    } else if (p<=2) {
      pathToFollow = path16;
      _x=95;
      _y=676;
    } else if (p<=3) {
      pathToFollow= path17;
      _x=95;
      _y=676;
    } else if (p<=4) {
      pathToFollow = path18;
      _x=95;
      _y=676;
    } else if (p<=5) {
      pathToFollow = path19;
      _x=95;
      _y=676;
    } else if (p<=6) {
      pathToFollow = path20;
      _x=95;
      _y=676;
    }else if (p<=7) {
      pathToFollow = path21;
      _x=95;
      _y=676;
    }else if (p<=8) {
      pathToFollow = path22;
      _x=65;
      _y=255;
    }else if (p<=9) {
      pathToFollow = path23;
      _x=65;
      _y=255;
    }else if (p<=10) {
      pathToFollow = path24;
      _x=65;
      _y=255;
    }else if (p<=11) {
      pathToFollow = path25;
      _x=264;
      _y=692;
    }else if (p<=12) {
      pathToFollow = path26;
      _x=264;
      _y=692;
    }else if (p<=13) {
      pathToFollow = path27;
      _x=264;
      _y=692;
    }else if (p<=14) {
      pathToFollow = path28;
      _x=264;
      _y=692;
    }else if (p<=15) {
      pathToFollow = path29;
      _x=264;
      _y=692;
    }else if (p<=16) {
      pathToFollow = path30;
      _x=264;
      _y=692;
    }else if (p<=17) {
      pathToFollow = path31;
      _x=264;
      _y=692;
    }else if (p<=18) {
      pathToFollow = path32;
      _x=264;
      _y=692;
    }else if (p<=19) {
      pathToFollow = path33;
      _x=264;
      _y=692;
    }else if (p<=20) {
      pathToFollow = path34;
      _x=264;
      _y=692;
    }else if (p<=21) {
      pathToFollow = path35;
      _x=264;
      _y=692;
    }else if (p<=22) {
      pathToFollow = path36;
      _x=59;
      _y=92;
    }else if (p<=23) {
      pathToFollow = path37;
      _x=59;
      _y=92;
    }else if (p<=24) {
      pathToFollow = path38;
      _x=59;
      _y=92;
    }
  }
}
class Hooligan_7 extends Hooligans {
  Hooligan_7() {
    score = 10; 
    imageToDraw = hooligan1;
    imageToDrawa = hooligan1a;
    health = 200;
    imageRotate = PI/2;
    l=11;
    c=11;
    speed=1;
    float p=random(14);
    if (p<=1) {
      pathToFollow = path40;
      _x=586;
      _y=185;
    } else if (p<=2) {
      pathToFollow = path41;
      _x=586;
      _y=185;
    } else if (p<=3) {
      pathToFollow = path42;
      _x=586;
      _y=185;
    } else if (p<=4) {
      pathToFollow = path43;
      _x=586;
      _y=185;
    } else if (p<=5) {
      pathToFollow = path44;
      _x=205;
      _y=192;
    } else if (p<=6) {
      pathToFollow = path45;
      _x=205;
      _y=192;
    } else if (p<=7) {
      pathToFollow = path46;
      _x=205;
      _y=192;
    } else if (p<=8) {
      pathToFollow = path47;
      _x=205;
      _y=192;
    } else if (p<=9) {
      pathToFollow = path48;
      _x=100;
      _y=507;
    } else if (p<=10) {
      pathToFollow = path49;
      _x=100;
      _y=507;
    } else if (p<=11) {
      pathToFollow = path50;
      _x=100;
      _y=507;
    } else if (p<=12) {
      pathToFollow = path51;
      _x=63;
      _y=639;
    } else if (p<=13) {
      pathToFollow = path52;
      _x=64;
      _y=639;
    } else if (p<=14) {
      pathToFollow = path53;
      _x=489;
      _y=642;
    }
  }
}

class Hooligan_8 extends Hooligans {
  Hooligan_8() {
    score = 15; 
    imageToDraw = hooligan2;
    imageToDrawa = hooligan2a;
    health = 350;
    imageRotate = PI/2;
    l=11;
    c=11;
    speed=0.7f;
    float p=random(14);
    if (p<=1) {
      pathToFollow = path40;
      _x=586;
      _y=185;
    } else if (p<=2) {
      pathToFollow = path41;
      _x=586;
      _y=185;
    } else if (p<=3) {
      pathToFollow = path42;
      _x=586;
      _y=185;
    } else if (p<=4) {
      pathToFollow = path43;
      _x=586;
      _y=185;
    } else if (p<=5) {
      pathToFollow = path44;
      _x=205;
      _y=192;
    } else if (p<=6) {
      pathToFollow = path45;
      _x=205;
      _y=192;
    } else if (p<=7) {
      pathToFollow = path46;
      _x=205;
      _y=192;
    } else if (p<=8) {
      pathToFollow = path47;
      _x=205;
      _y=192;
    } else if (p<=9) {
      pathToFollow = path48;
      _x=100;
      _y=507;
    } else if (p<=10) {
      pathToFollow = path49;
      _x=100;
      _y=507;
    } else if (p<=11) {
      pathToFollow = path50;
      _x=100;
      _y=507;
    } else if (p<=12) {
      pathToFollow = path51;
      _x=63;
      _y=639;
    } else if (p<=13) {
      pathToFollow = path52;
      _x=64;
      _y=639;
    } else if (p<=14) {
      pathToFollow = path53;
      _x=489;
      _y=642;
    }
  }
}
class Hooligan_9 extends Hooligans {
  Hooligan_9() {
    score = 20; 
    imageToDraw = hooligan3;
    imageToDrawa = hooligan3a;
    health = 500;
    imageRotate = PI/2;
    l=11;
    c=11;
    speed=0.5f;
    float p=random(14);
    if (p<=1) {
      pathToFollow = path40;
      _x=586;
      _y=185;
    } else if (p<=2) {
      pathToFollow = path41;
      _x=586;
      _y=185;
    } else if (p<=3) {
      pathToFollow = path42;
      _x=586;
      _y=185;
    } else if (p<=4) {
      pathToFollow = path43;
      _x=586;
      _y=185;
    } else if (p<=5) {
      pathToFollow = path44;
      _x=205;
      _y=192;
    } else if (p<=6) {
      pathToFollow = path45;
      _x=205;
      _y=192;
    } else if (p<=7) {
      pathToFollow = path46;
      _x=205;
      _y=192;
    } else if (p<=8) {
      pathToFollow = path47;
      _x=205;
      _y=192;
    } else if (p<=9) {
      pathToFollow = path48;
      _x=100;
      _y=507;
    } else if (p<=10) {
      pathToFollow = path49;
      _x=100;
      _y=507;
    } else if (p<=11) {
      pathToFollow = path50;
      _x=100;
      _y=507;
    } else if (p<=12) {
      pathToFollow = path51;
      _x=63;
      _y=639;
    } else if (p<=13) {
      pathToFollow = path52;
      _x=64;
      _y=639;
    } else if (p<=14) {
      pathToFollow = path53;
      _x=489;
      _y=642;
    }
  }
}
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
  }public void damage() {
    health -=damage; //cada bullet que colide com hool tira 1/100 de vida
  }
  public void display() {
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
  public void move () {
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

  public void delete() {
    hooligansp.remove(this);
    box2d.destroyBody(body);
    miniGameKilled++;
  }

  public void kill() {
    hoolhealth-=1;
  }

  public boolean contains(float x, float y) { //just copied to see if it works
    Vec2 worldPoint = box2d.coordPixelsToWorld(x, y);
    Fixture f = body.getFixtureList();
    boolean inside = f.testPoint(worldPoint);
    return inside;
  }
  public boolean done() {
    // Let's find the screen position of the particle
    Vec2 pos = box2d.getBodyPixelCoord(body);
    // Is it off the bottom of the screen?
    if (pos.y > width+100 || delete) {
      return true;
    }
    return false;
  }
  public void display() {

    Vec2 pos = box2d.getBodyPixelCoord(body);
    // println(pos);
    int change = millis()-walk;
    if (change<=500) {
      pushMatrix();
      translate(pos.x, pos.y);
      rotate(0);
      fill(0xffFFFFFF);
      imageMode(CENTER);
      image(minihoolL, 0, 0, r*2, r*2);
      noFill();
      popMatrix();
    }
    if (change<=1000) { 
      pushMatrix();
      translate(pos.x, pos.y);
      rotate(0);
      fill(0xffFFFFFF);
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
  public void destroyBody() {
    box2d.destroyBody(body);
  }
  /*  void move(){
   Vec2 speedVec = new Vec2(0, 0);
   speedVec.x += speed;
   Vec2 vel = body.getLinearVelocity();
   Vec2 force = new Vec2(speedVec.x-vel.x, speedVec.y-vel.y); 
   body.applyLinearImpulse(force, body.getWorldCenter(), true);
   
   }*/
  public void makeBody(Vec2 center, float r) {
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
    fd.friction = 0.01f;
    fd.restitution = 0.3f;

    // Attach fixture to body
    body.createFixture(fd);

    body.setLinearVelocity(new Vec2(20, 0));
  }

  public void disparar() {


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
class particle {
  Body body;
  float r;
  PVector position = new PVector();
  int col;
  boolean delete =false;

  particle(float x, float y, float r_) {
    position.x=x;
    position.y=y;
    r=r_;
    makeBody(new Vec2(x, y), r);
    body.setUserData(this);
  }
  public void killBody() {
    box2d.destroyBody(body);
  }
  public void delete() {
    delete = true;
  }

  public boolean done() {
    Vec2 pos = box2d.getBodyPixelCoord(body);

    if (pos.y > height+r*2 || delete) {
      killBody();
      return true;
    }
    return false;
  }
  public void display() {

    Vec2 pos = box2d.getBodyPixelCoord(body);

    float a = body.getAngle();

    pushMatrix();
    translate(pos.x, pos.y);
    rotate(-a+PI);
    fill(0xff3EC6ED);
    ellipse(0, 0, r*2, r*2);
    //imageMode(CENTER);
    //image(plathoolPlatform,0,0,r*2,r*2);
    popMatrix();
  }
  public void makeBody(Vec2 center, float r) {
    BodyDef bd = new BodyDef();
    bd.position.set(box2d.coordPixelsToWorld(center));
    bd.type=BodyType.DYNAMIC;
    body=box2d.world.createBody(bd);

    CircleShape cs = new CircleShape();
    cs.m_radius = box2d.scalarPixelsToWorld(r);

    FixtureDef fd = new FixtureDef();
    fd.shape=cs;
    //perguntar o que \u00e9 que estes 3 parametros afetam
    fd.density = 0.5f;
    fd.friction=0.5f;
    fd.restitution=0.5f;

    body.createFixture(fd);
    shoot();

  }
  public void shoot() {
    Vec2 pos = box2d.getBodyPixelCoord(body);
    Vec2 imp =new Vec2(mouseX-pos.x, pos.y-mouseY);
    imp.normalize();
    imp.mulLocal(2);
    body.applyLinearImpulse(imp, body.getWorldCenter(), true);
  }
}
//november echo echo delta hotel echo lima papa ...
class Police {
  Hooligans nearestHooligan;
  PVector police = new PVector();
  float xx, yy;
  int range =88;
  int size =50;
  float ang=0.0f; 
  int lastShotTime;
  int inte;
  PImage policeImage;

  float ocupationRadius;
  

  Police (float x, float y) { //posi\u00e7\u00e3o da torre
    police.x = x;
    police.y = y;
    inte=0;
    bullet = new ArrayList();
    damage = 50;
    ocupationRadius = 20;
    policeImage=Police1;
  }
  public void display() {
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
      if (dist(hooligans.get(i)._x, hooligans.get(i)._y, police.x, police.y) < range) { //distancia de dois pontos (hool x, hool y,gun x,guyn y)<alcan\u00e7e
        //ang=atan2(police.y-((hooligans.get(0))._y),police.x-((hooligans.get(0))._x))-180; //ask teacher....
        ang = atan2(((hooligans.get(i))._y)-police.y, ((hooligans.get(i))._x)-police.x); //atan2(y1-y2,x1-x2) da nos o angle em radiano
        xx = (40*cos(ang)) + police.x; //x angulo de disparo
        yy = (40*sin(ang)) + police.y; //y angulo de disparo
        break;
      }
    }
  }
  
  public boolean isOccupied(float x, float y){
    return dist(police.x, police.y, x, y) < ocupationRadius;  
  }

  public void shoot () {
    if (hooligans.size() == 0) {
      nearestHooligan = null; //n\u00e3o existem hooligans portanto o nearesHooligan \u00e9 nulo.
    } else {
      float nearestDist = range; //este valor vai ter a dist\u00e2ncia menor encontrada at\u00e9 agora..
      for (int h=0; h<hooligans.size(); h++) { //um loop que percorre todos os hooligans
        float d = dist(hooligans.get(h)._x, hooligans.get(h)._y, police.x, police.y); //a distancia deste..
        if (d < nearestDist) { //se for menor do que a menor dist\u00e2ncia encontrada..
          nearestDist = d; //guardamos esse valor na vari\u00e1vel nearestDist
          nearestHooligan = hooligans.get(h); //e guardamos este hooligan na vari\u00e1vel nearestHooligan
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
class Police_1 extends Police {

  Police_1(float x, float y) {
    super(x, y);
    inte = 1000;
    damage=15;
    policeImage=Police1;
  }
}
class Police_2 extends Police {
  Police_2(float x, float y) {
    super(x,y);
    inte= 500;
    damage = 15;
    policeImage=Police2;
  }
}
class Police_3 extends Police {
  Police_3(float x, float y) {
    super (x, y);
    inte =1000;
    damage=50;
    policeImage=Police3;
  }
}
class Police_4 extends Police {
  Police_4(float x, float y) {
    super (x, y);
    inte =100;
    damage=20;
    policeImage=Police4;
  }
}
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
    float box2dH = box2d.scalarPixelsToWorld(h/2); //same // isto \u00e9 que o universo do jogo come\u00e7a no meio em vez no canto ass arturlee

    sd.setAsBox(box2dW, box2dH);

    //criar o body
    BodyDef bd = new BodyDef();
    bd.type = BodyType.STATIC;
    bd.position.set(box2d.coordPixelsToWorld(x, y));
    b=box2d.createBody(bd);

    //juntar o body \u00e1 shape atraves da fixture
    b.createFixture(sd, 1); //exprimentar mudar o 1 para outro valor a ver o que acontece
    // se nada acontecer perguntar para que serve (penso que \u00e9 a density)
  }

  public void display() {
    //fill(255);
    noFill();
    rectMode(CENTER); // EXPRIMENTAR RETIRAR A VER O QUE ACONTECE
    rect(x, y, w, h);
  }
}
  public void settings() {  size (1200, 800); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "--present", "--window-color=#666666", "--stop-color=#cccccc", "Hooligame" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
