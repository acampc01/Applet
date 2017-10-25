import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Sistema {

	private int ancho;
	private int alto;

	private Serpiente serpiente;
	private Particula comida;
	private Random rnd = new Random();

	public Sistema(int ancho, int alto){
		this.ancho = ancho;
		this.alto = alto;

		serpiente = new Serpiente();
		comida = new Particula(rnd.nextInt(ancho),rnd.nextInt(alto));
	}

	public void actualizar(int ancho, int alto){
		serpiente.mover();
	}

	public void mostrar(Graphics g){
		if(!serpiente.isGameOver()){
			serpiente.dibujar(g);
			comida.dibujar(g);
		}else{
			g.setColor(Color.red);
			g.drawString("Game Over", (ancho/2-30), alto/2);
			g.drawString("Score: "+ serpiente.getFoodAte(), (ancho/2-30) + 10, alto/2 + 15);
		}
	}

	public void cambioDireccion(int dX, int dY){
		serpiente.cambioDireccion(dX,dY);
	}

	public boolean snakeIsMoving(){
		return serpiente.isMoving();
	}

	public void snakeStartMoving() {
		serpiente.setMoving(true);
	}

	public int snakeGetDirX(){
		return serpiente.getDirX();
	}

	public int snakeGetDirY(){
		return serpiente.getDirY();
	}

	public void checkGameOver(int ancho, int alto) {
		if(serpiente.getX()<0 || serpiente.getX()>alto){
			serpiente.gameOver();
		}else if(serpiente.getY()<0 || serpiente.getY()>ancho){
			serpiente.gameOver();
		}else if(serpiente.serpienteChoca()){
			serpiente.gameOver();
		}
	}

	public void come() {
		int snakeX = serpiente.getX();
		int snakeY = serpiente.getY();

		if(snakeX >= comida.getX()-1 && snakeX <= (comida.getX() + 7)){
			if(snakeY >= comida.getY()-1 && snakeY <= (comida.getY()+7)){
				cambioComida();
				serpiente.isEating();
				serpiente.setElongate(true);
			}
		}
	}

	private void cambioComida(){
		comida.setX(rnd.nextInt(ancho));
		comida.setY(rnd.nextInt(alto));
	}
}
