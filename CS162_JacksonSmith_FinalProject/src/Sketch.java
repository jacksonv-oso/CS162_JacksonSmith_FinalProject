import processing.core.PApplet;

import java.util.ArrayList;

public class Sketch extends PApplet {
    private Human human;
    private Zombie zombie;
    private ArrayList<Human> humans;
    private ArrayList<Zombie>zombies;
    private final int NUM_ZOMBIES = (int) random(100,300);
    private final int NUM_HUMANS = (int) random(100,300);

    public void settings(){
        size(1000,1000);
    }
    public void setup(){
        apocalypseStage();
    }

    public void draw(){
        background(255);
        textSize(30);
        text("Zombies: " + zombies.size() ,width/2,height/10);
        text("Humans: " + humans.size() ,width/2,height*9/10);
        apocalypse();
    }



    public void apocalypseStage(){
        humans = new ArrayList<Human>();
        zombies = new ArrayList<Zombie>();
        for(int i = 0; i < NUM_ZOMBIES; i++){
            zombie = new Zombie((int) random(100,900),(int) random(200,250),(int)random(10,25),(int)random(10,25),0,0,this);
            zombies.add(zombie);
        }
        for(int i = 0; i < NUM_HUMANS; i++){
            human = new Human((int) random(100,900),(int) random(700,750),(int)random(10,25),(int)random(10,25),0,0, this);
            humans.add(human);
            if(human.contact(zombie)){
                text("Undead",100,100);
                zombies.add(new Zombie(human.getX(),human.getY()));
                humans.remove(human);
            }
        }
    }

    public void apocalypse() {
        for (Human human : humans) {
            human.draw();
            human.moveY();
        }
        for (Zombie zombie : zombies) {
            zombie.draw();
            zombie.moveY();
        }
    }
}
