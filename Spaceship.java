import processing.core.PApplet;

public class Spaceship {

	  float x;
	  float y;
	  float size;
	  
	  float angle = 0;
	  float dir;
	  
	   public Spaceship(float xi, float yi, float s) {
	    x = xi;
	    y = yi;
	    size = s;
	  }
	  
	   public void display(PApplet mainProc) {  
	  mainProc.pushMatrix();
	  mainProc.translate(x,y);
	  mainProc.rotate((float) Math.toRadians(angle));
	  mainProc.translate(10, 0);
	  mainProc.fill(0,0,0);
	  mainProc.triangle(-17, -17, -17, 17, 38, 0);
	  mainProc.popMatrix();
	      angle = angle + dir;
	  }

	   public void right() {
		   dir = 2;
	   }
	   
	  public void left() {
		   dir = -2;
	   }
	   
	   public void boom() {
		    x = 1200;
		  }
	   
	   float getX() {
		   return x;
		 }

		   float getY() {
		   return y;
		 }

		   float getSize() {
		   return size;
		 }
		   float getAngle() {
			   return angle;
			 }
		   float getDir() {
			   return dir;
			 }
		    }
	   
	
	



