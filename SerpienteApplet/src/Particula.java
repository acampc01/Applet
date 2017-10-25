import java.awt.Color;
import java.awt.Graphics;

public class Particula {
	private Punto p = new Punto();

	public Particula(int x, int y){
		p.mover(x,y);
	}

	public void dibujar(Graphics g){
		p.dibujar(g,Color.white);
	}
	
	public int getX(){
		return p.getX();
	}

	public int getY(){
		return p.getY();
	}

	public void setX(int x) {
		p.setX(x);
	}

	public void setY(int y) {
		p.setY(y);
	}
} 
