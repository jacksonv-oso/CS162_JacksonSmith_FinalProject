import processing.core.PApplet;
public class Human {
    PApplet sketch;
    protected int x;
    protected int y;
    protected int Width;
    protected int height;
    protected int xVelocity;
    protected int yVelocity;
    final int Y_VELOCITY = 5;

    Human(int x, int y, int Width, int height, int xVelocity, int yVelocity, PApplet sketch) {
        this.x = x;
        this.y = y;
        this.Width = Width;
        this.height = height;
        this.xVelocity = xVelocity;
        this.yVelocity = Y_VELOCITY;
        this.sketch = sketch;
    }

    public Human(int x, int y) {

    }

    public PApplet getSketch() {
        return sketch;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return height;
    }

    public int getxVelocity() {
        return xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }

    public int getY_VELOCITY() {
        return Y_VELOCITY;
    }

    public void draw() {
        sketch.fill(0,224,255);
        sketch.ellipse(x, y, Width, height);
    }

    public void setSketch(PApplet sketch) {
        this.sketch = sketch;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        Width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }

    public void moveY() {
        if (y == 200) {
            yVelocity *= 0;
        }
        int dodge = (int) this.sketch.random(4);
        if(dodge ==0){
            this.x++;
        } else if (dodge ==1){
            this.x--;
        } else if (dodge ==2){
            this.y--;
        } else {
            this.y--;
        }
    }
    public boolean contact(Zombie zombie){
        float distance = sketch.dist(this.x,this.y,zombie.x,zombie.y);
        return (distance < (this.Width + zombie.Width));
    }
}