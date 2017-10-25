
import java.awt.Graphics;
import java.util.Random;

public class Sistema {

	private Particula[] particulas =new Particula[50];

	public Sistema(int ancho, int alto){
		Random rnd= new Random();
		for (int i =0; i < particulas.length;i++){
			int vel= rnd.nextInt(10)+1;
			int dir = i % 4;

			switch(dir){//Sirve para marcar el punto de origen de las particulas
			case 0:
				particulas[i]=new Particula(rnd.nextInt(ancho),alto+rnd.nextInt(alto), vel,dir);
				
				break;
			case 1:
				particulas[i]=new Particula(-rnd.nextInt(ancho),rnd.nextInt(alto), vel,dir);

				break;
			case 2:
				particulas[i]=new Particula(rnd.nextInt(ancho),-rnd.nextInt(alto), vel,dir);

				break;
			case 3:
				particulas[i]=new Particula(ancho+rnd.nextInt(ancho),rnd.nextInt(alto), vel,dir);

				break;
			}
			
		
			

		}
		
		//particulas[0] = new Particula(150, 50, 1, 1);
		//particulas[1] = new Particula(300, 50, 1, 3);
	}

	public void actualizar(int ancho, int alto){
		for (int i =0; i<particulas.length;i++){
			particulas[i].mover(ancho, alto);
		}
	}

	public void mostrar(Graphics g){
		for (int i =0; i<particulas.length;i++){
			particulas[i].dibujar(g);
		}
	}
}
