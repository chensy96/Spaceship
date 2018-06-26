import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Iterator;

public class Explo {
	ArrayList<Particle> particleList;
	  
	  float xPos;
	  float yPos;
	  float size  =5;
	  
	  public Explo(int numParticles, float xPosint, float yPosint) {
	    xPos = xPosint;
	    yPos = yPosint;
	    particleList = new ArrayList<Particle>();
	    while (particleList.size() < 40) {
	      particleList.add(new Particle(xPos, yPos, size, 187, 10, 30));
	    }
	  }
	  
	  public void display(PApplet mainProc) {
	    for (Particle theParticle : particleList) {
	      theParticle.display(mainProc);
	    }
	  }
	  
	  public void update() {
		  Iterator<Particle> ParticleIt = particleList.iterator();
		  while (ParticleIt.hasNext()) {
			  Particle theParticle = ParticleIt.next();
			  if(theParticle.alive()) {
				  theParticle.update();
			  } else {
				  ParticleIt.remove();
			  }
		  }
}
}
