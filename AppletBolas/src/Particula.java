
//import java.awt.Color;
import java.awt.Graphics;

public class Particula {
	private Punto p = new Punto();
	private int velocidad = 1;
	private int direccion = 0;

	public Particula(int x, int y,int velocidad,int direccion){
		p.mover(x,y);
		this.velocidad=velocidad;
		this.direccion=direccion;
	}

	public void mover (int ancho, int alto){		
		switch(direccion){
		case 0: //arriba

			if(p.getY()<=0){ //direccion nueva
				this.direccion = 2;
				p.abajo(this.velocidad);
			}else{
				p.arriba(this.velocidad); //direccion del numero 0
			}
			break;

		case 1: //derecha

			if(p.getX()>=ancho){
				this.direccion = 3;
				p.izquierda(this.velocidad);
			}else{
				p.derecha(this.velocidad);  //direccion del numero 1
			}
			break;

		case 2: //abajo

			if(p.getY()>=alto){
				this.direccion = 0;
				p.arriba(this.velocidad);
			}else{
				p.abajo(this.velocidad);  //direccion del numero 2
			}
			break;

		case 3: //izquierda

			if(p.getX()<=0){
				this.direccion = 1;
				p.derecha(this.velocidad);
			}else{
				p.izquierda(this.velocidad);  //direccion del numero 3
			}
			break;

		}
	}

	public void dibujar(Graphics g){
		p.dibujar(g); //sin color, negro
		
		/*switch(direccion){ //Con colores
		case 0:
			p.dibujar(g, Color.blue);
			break;
		case 1:
			p.dibujar(g, Color.green);
			break;
		case 2:
			p.dibujar(g, Color.red);
			break;
		case 3:
			p.dibujar(g, Color.black);
			break;
		}*/
		
	}

} 
