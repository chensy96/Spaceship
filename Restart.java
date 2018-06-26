import processing.core.PApplet;
public class Restart {
	
	  float x;
	  float y;
	  float size;
	  
	  public Restart(float xi, float yi, float s) {
		    x = xi;
		    y = yi;
		    size = s;	
}
	  public void display(PApplet mainProc) {  
		  mainProc.fill(255,0,0);
		  mainProc.rect(x,y,140,25);
	  }
	  
	  float getXr() {
		   return x;
		 }

		   float getYr() {
		   return y;
		 }

		   float getSizer() {
		   return size;
		 }
}
