import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Iterator;

public class SpaceMain extends PApplet {

	float score;
	String name = "";
	Boolean Gameover = false;
	Boolean shoot = true;

	ArrayList<Bullet> bulletList;
	ArrayList<asteroid> asteroidList;
	ArrayList<Explo> exploList;

	Bullet theBullet;
	Spaceship theSpaceship;
	asteroid theasteroid;
	Explo explosion;
	Restart button;

	public void setup() {
		textSize(20);
		score = 0;

		theSpaceship = new Spaceship(300, 300, 95);

		button = new Restart(302, 100, 150);

		bulletList = new ArrayList<Bullet>();
		int index = bulletList.size() - 1;
		while (index > 0) {
			index--;
			Bullet theBullet = bulletList.get(index);
			theBullet.draw(this);
		}

		asteroidList = new ArrayList<asteroid>();
		while (asteroidList.size() < 4) {
			asteroidList.add(new asteroid(75, random(0, 600), random(0, 600), random(-2, 2), random(-2, 2)));
		}

		exploList = new ArrayList<Explo>();
	}

	public void draw() {
		background(255, 255, 255);
		fill(0, 0, 0);
		text(score, 260, 20);
		theSpaceship.display(this);

		Iterator<asteroid> asteroidIterator = asteroidList.iterator();
		while (asteroidIterator.hasNext()) {
			asteroid theasteroid = asteroidIterator.next();
			theasteroid.display(this);

			if (theSpaceship.getX() > theasteroid.getXa()
					&& theSpaceship.getX() < theasteroid.getXa() + theasteroid.getSizea()
					&& theSpaceship.getY() > theasteroid.getYa()
					&& theSpaceship.getY() < theasteroid.getYa() + theasteroid.getSizea()) {
				exploList.add(new Explo(1000, theSpaceship.getX(), theSpaceship.getY()));
				theSpaceship.boom();
				shoot = false;
				Gameover = true;
			}
		}

		Iterator<Bullet> bulletIterator = bulletList.iterator();
		while (bulletIterator.hasNext()) {
			Bullet theBullet = bulletIterator.next();
			theBullet.draw(this);
			Iterator<asteroid> asteroidcIterator = asteroidList.iterator();
			while (asteroidcIterator.hasNext()) {
				asteroid theasteroid = asteroidcIterator.next();
				if (theBullet.getXb() > theasteroid.getXa()
						&& theBullet.getXb() < theasteroid.getXa() + theasteroid.getSizea()
						&& theBullet.getYb() > theasteroid.getYa()
						&& theBullet.getYb() < theasteroid.getYa() + theasteroid.getSizea()) {
					exploList.add(new Explo(1000, theasteroid.getXa(), theasteroid.getYa()));
					theasteroid.boom(this);
					score += 1;
				}
			}
			if (theBullet.getXb() > 650 || theBullet.getXb() < -50 || theBullet.getYb() > 650
					|| theBullet.getYb() < -50) {
				bulletIterator.remove();
			}
		}

		for (Explo Explosion : exploList) {
			Explosion.display(this);
			Explosion.update();
		}

		if (Gameover) {
			fill(187, 10, 30);
			text("Press to Restart", 300, 100);
			text("Game Over", 300, 300);
			button.display(this);
		}
	}

	void reset() {
		score = 0;
		textSize(20);
		theSpaceship = new Spaceship(300, 300, 100);
		exploList = new ArrayList<Explo>();
		Gameover = false;
		shoot = true;
	}

	public void mousePressed() {
		if (mouseButton == LEFT) {
			theSpaceship.left();
		} else if (mouseButton == RIGHT) {
			theSpaceship.right();
		}
		if (Gameover) {
			if (mouseX > button.getXr() && mouseX < button.getXr() + button.getSizer() && mouseY > button.getYr()
					&& mouseY < button.getYr() + button.getSizer()) {
				reset();
			}
		}

	}

	public void keyReleased() {
		if (shoot) {
			if (key == ' ') {
				bulletList.add(new Bullet(10, 300, 300, 40 * cos((float) Math.toRadians(theSpaceship.getAngle())),
						40 * sin((float) Math.toRadians(theSpaceship.getAngle()))));
			}
		}
	}

	public void settings() {
		size(600, 600);
	}

	public static void main(String[] args) {
		PApplet.main("SpaceMain");
	}
}
