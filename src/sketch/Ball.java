package sketch;

import vectors.*;

public class Ball {

    private ProcessingSketch mySketch;

    Position position;
    Velocity velocity;
    Acceleration acceleration;
   
    public Ball(ProcessingSketch mySketch, Position position, Velocity velocity,
        Acceleration acceleration){

        this.mySketch = mySketch;
        this.position = position;
        this.velocity = velocity;
        this.acceleration = acceleration;

        drawBall();
    }  

    public Ball(ProcessingSketch mySketch, float x, float y, float vx, float vy,
                float ax, float ay) {

        this.mySketch = mySketch;
        this.position = new Position(x, y);
        this.velocity = new Velocity(vx, vy);
        this.acceleration = new Acceleration(ax, ay);

        drawBall();
    }

    private void drawBall() {
        mySketch.fill(255);
        mySketch.circle(position.x, position.y, 20);
    }

    public void onUpdate(){

        if (!isBallUnderGround()){

            position.x += velocity.x;
            velocity.x += acceleration.x;
    
            position.y += velocity.y;
            velocity.y += acceleration.y;

            drawBall();

        }else{
            stopBall();
            drawBall();
        }

    }

    public void stopBall(){

        velocity.x = 0;
        velocity.y = 0;

        acceleration.x = 0;
        acceleration.y = 0;

        //drawBall();
    }

    private boolean isBallUnderGround(){

        return position.y > mySketch.height - 20;
    }

    public String getData(){
        return "Data: " +position.x + " -- " + position.y;
    }


}