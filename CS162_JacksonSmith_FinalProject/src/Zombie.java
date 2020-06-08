import processing.core.PApplet;
public class Zombie extends Human{

    Zombie(int x, int y, int Width, int height, int xVelocity, int yVelocity, PApplet sketch) {
        super(x, y, Width, height, xVelocity, yVelocity, sketch);
    }

    public Zombie(int x, int y) {
        super(x, y);
    }

    @Override
    public void draw(){
        sketch.fill(162,0,0);
        sketch.ellipse(x,y,Width,height);
    }

    @Override
    public void moveY() {
        int stagger = (int) this.sketch.random(4);
        if(stagger == 0){
            this.x++;
        } else if (stagger ==1){
            this.x--;
        } else if (stagger ==2){
            this.y++;
        } else {
            this.y++;
        }
        if (y == 800) {
            yVelocity *= 0;
        }
    }
}

