import processing.core.PApplet;
public class asteroid {
	  float x;
	  float y;
	  float spx;
	  float spy;
	  float size;

	  boolean show = false;
	  
	  public asteroid(float s,float xa, float ya, float speedx, float speedy) {
		  this.size = s;
		  this.x = xa;
		  this.y = ya;
		  this.spx = speedx;
		  this.spy = speedy;
	  }
	  
	  public void display(PApplet mainProc) {
	      x = x + spx;    
	      y = y + spy;  
	  
	    if (x < 0) {
	    x = 600;
	  }
	    if (x > 600) {
		    x = 0;
		  }
	    if (y < 0) {
		    y = 600;
		  }
	    if (y > 600) {
		    y = 0;
		  }
	    mainProc.ellipse(x,y,40,40);
	   }

	 
	public void show() {
	    show = true;
	  }
	
	public void boom(PApplet mainProc){
		x = mainProc.random(0,600);
		y = mainProc.random(0,600);
	}
	  
	  
	  float getXa() {
	  return x;
	}

	  float getYa() {
	  return y;
	}

	  float getSizea() {
	  return size;
	}
	}

