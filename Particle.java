import processing.core.PApplet;

public class Particle {
	  float xPos;
	  float yPos;
	  
	  float xDir;
	  float yDir;
	  
	  float size;
	  float age = 0;
	  
	  float red;
	  float green;
	  float  blue;
	  
	  float maxLifeSpan = 255;
	  
	  public Particle(float xint, float yint, float sizeint, float redint, float greenint, float blueint){
	    xPos = xint;
	    yPos = yint;
	    size = sizeint;
	    red = redint;
	    green = greenint;
	    blue = blueint;
	    
	    double angle = Math.random() * 2 * Math.PI;
	    double speed = Math.random();
	    xDir = (float) (Math.cos(angle) * speed);
	    yDir = (float) (Math.sin(angle) * speed);
	  }
	  
	  boolean alive() {
		  return age <= maxLifeSpan;
	  }
	  
	  
	  public void display(PApplet mainProc) {
	     mainProc.stroke(red,green,blue,255 - 2 *age);
	     mainProc.fill(red,green,blue,255 - 2 *age);
	     mainProc.ellipse(xPos, yPos, size, size);
	   }
	     
	   public void update() {
	     xPos += xDir;
	     yPos += yDir;
	     age+= 1;
	   }
}
