import processing.core.PApplet;

public class Bullet {
		  
		  float xb;
		  float yb;
		  float sx;
		  float sy;
		  float size;
		  
		public boolean draw;
	
		  		  
		  public Bullet(float sz,float x, float y, float speedx, float speedy) {
		    this.size = sz;
		    this.xb = x;
		    this.yb = y;
		    this.sx = speedx;
		    this.sy = speedy;
		  }

		  
		  public boolean draw(PApplet mainProc) {
				mainProc.fill(0,0,0);
				mainProc.ellipse(xb,yb,10,10);
				xb = xb + sx;
				yb = yb + sy;
				return(xb > 600);
					  }



		float getXb() {
		  return xb;
		}

		float getYb() {
		  return yb;
		}
		}

