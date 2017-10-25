import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Interfaz extends Applet implements ActionListener, KeyListener{

	private Sistema sis;
	
	@Override
	public void init(){
		super.init();
		
		addKeyListener(this);
		setSize(300,300);
		
		sis = new Sistema(getWidth(),getHeight());
		
		Timer t = new Timer(40, this); //tiempo de vida de la ventana
		t.start();
	}
	
	@Override
	public void paint(Graphics g){
		Image img = this.createImage(this.getWidth(), this.getHeight());
		Graphics gra = img.getGraphics();
		
		gra.setColor(Color.black);
		gra.fillRect(0, 0, getWidth(), getHeight());
	
		sis.mostrar(gra);

		g.drawImage(img, 0, 0, null);
		gra.dispose();
	}
	
	@Override
	public void update(Graphics g){
		this.paint(g);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		sis.actualizar(getWidth(), getHeight());
		sis.come();
		sis.checkGameOver(getWidth(), getHeight());
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(!sis.snakeIsMoving()){
			sis.snakeStartMoving();
		}
		
		if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_UP){
			if(sis.snakeGetDirY() != 1){
				sis.cambioDireccion(0,-1);
			}
		}else if(e.getKeyCode() == KeyEvent.VK_S || e.getKeyCode() == KeyEvent.VK_DOWN){
			if(sis.snakeGetDirY() != -1){
				sis.cambioDireccion(0, 1);
			}
		}else if(e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_LEFT){
			if(sis.snakeGetDirX() != 1){
				sis.cambioDireccion(-1, 0);
			}
		}else if(e.getKeyCode() == KeyEvent.VK_D || e.getKeyCode() == KeyEvent.VK_RIGHT){
			if(sis.snakeGetDirX() != -1){
				sis.cambioDireccion(1, 0);
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {}

	@Override
	public void keyTyped(KeyEvent e) {}

	
	
	
}
