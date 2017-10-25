import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Serpiente {

	private ArrayList<Punto> cola = new ArrayList<Punto>();
	private int xDir, yDir;
	private boolean isMoving, elongate, gameOver = false;
	private final int SIZE = 20, STARTX = 150, STARTY = 150;
	private int score;

	public Serpiente() {
		xDir = 0;
		yDir = 0;
		score = 0;
		isMoving = false;
		elongate = false;

		cola.add(new Punto(STARTX,STARTY));
		for (int i = 0; i < SIZE; i++) {
			cola.add(new Punto(STARTX - i * 4, STARTY));
		}
	}

	public void dibujar(Graphics g) {
		g.setColor(Color.green);
		for (Punto i : cola) {
			g.fillRect(i.getX(), i.getY(), 4, 4);
		}
	}

	public void cambioDireccion(int dX, int dY) {
		this.xDir = dX;
		this.yDir = dY;
	}

	public void mover() {
		if(isMoving){
			Punto temp = cola.get(0);
			Punto newStart = new Punto(temp.getX() + xDir*4, temp.getY() + yDir*4);

			for (int i = cola.size()-1; i>=1; i--) {
				cola.set(i, cola.get(i-1));
			}
			cola.set(0, newStart);

			if(elongate){
				cola.add(cola.get(cola.size()-1));
				elongate = false;
			}
		}
	}

	public boolean isMoving(){
		return isMoving;
	}

	public void setMoving(boolean b) {
		this.isMoving = true;
	}

	public int getDirX() {
		return xDir;
	}

	public int getDirY() {
		return yDir;
	}

	public int getX() {
		return cola.get(0).getX();
	}

	public int getY() {
		return cola.get(0).getY();
	}

	public boolean getElongate(){
		return elongate;
	}

	public void setElongate(boolean elong){
		this.elongate = elong;
	}

	public void gameOver() {
		gameOver = true;
	}

	public void isEating(){
		score++;
	}

	public boolean serpienteChoca() {
		for (int i = 2; i < cola.size(); i++) {
			if(cola.get(i).getX() == cola.get(0).getX() && cola.get(i).getY() == cola.get(0).getY()){
				return true;
			}
		}
		return false;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public int getFoodAte() {
		return score;
	}


}
