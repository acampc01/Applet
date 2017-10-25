
import java.awt.Color;
import java.awt.Graphics;

public class Punto {
	
	//Propiedades o atributos
	private int x=0;
	private int y=0;
	
	//Constructores
	public Punto (){
		this(0,0);
	}
	
	public Punto(int x, int y){
		this.mover(x,y);
	}
	
	public Punto(double x, double y){
		this((int)x,(int)y);
	}
	
	public Punto(Punto p){
		this(p.x, p.y);
	}
	
	//Métodos de acceso
	public int getX(){
		return this.x;
	}
	public int getY(){
		return this.y;	
	}
	
	//Metodos generales
	public void mover(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public void mover(Punto p){//Sobrecarga
		this.mover(p.x,p.y);
	}
	
	public void desplazar(int dx,int dy){
		this.x+=dx; 
		this.y+=dy;
	}
	public void arriba(){
		this.arriba(1);
	}
	public void arriba(int cantidad){
		this.desplazar(0, - Math.abs(cantidad));
	}
	public void abajo(){
		this.abajo(1);
	}
	public void abajo(int cantidad){
		this.desplazar(0, Math.abs(cantidad));
	}
	public void izquierda(){
		this.izquierda(1);
	}
	public void izquierda(int cantidad){
		this.desplazar(- Math.abs(cantidad), 0);
	}
	public void derecha(){
		this.derecha(1);
	}
	public void derecha(int cantidad){
		this.desplazar(Math.abs(cantidad), 0);
	}
	//Metodos de salida /presentación en el Applet
	public String toString(){
		return String.format("(%d,%d)",this.x,this.y);
	}
	public void dibujar(Graphics g){//Sobrecarga
		this.dibujar(g, Color.BLACK);
	}
	public void dibujar(Graphics g, Color c){//Sobrecarga
		g.setColor(c);
		g.drawOval(this.x, this.y, 1, 1);
		g.drawOval(this.x-3, this.y-3, 8,8);
	}
	public void escribir(Graphics g){//Sobrecarga
	this.escribir(g, Color.BLACK);	
	}
	public void escribir(Graphics g, Color c){//Sobrecarga
		this.dibujar(g, c);
		g.drawString(this.toString(),this.x-5,this.y-5);
	}
}
