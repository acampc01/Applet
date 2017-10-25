
import java.applet.Applet;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class Interfaz extends Applet implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	Sistema sis = null;

	@Override
	public void init() {
		super.init();
		this.setSize(600,480);//Tamaño inicial de la ventana
		
		sis = new Sistema(this.getWidth(),this.getHeight());

		Timer t = new Timer(1000/25, this); //tiempo de vida de la ventana
		t.start();
	}

	@Override
	public void paint (Graphics g){
		//Dibujamos la pantalla en un buffer
		Image img = this.createImage(this.getWidth(), this.getHeight());
		Graphics dd = img.getGraphics();

		String s ="DAM1 CMA> Ejercicio 1";
		int width = g.getFontMetrics().stringWidth(s);

		dd.drawString(s, this.getWidth()/2-width/2, this.getHeight()/2);
		sis.mostrar(dd);
		//Volcamos el buffer en el applet
		g.drawImage(img, 0, 0, null);
		dd.dispose(); //liberamos recursos
	}

	@Override
	public void update(Graphics g){
		this.paint(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		sis.actualizar(this.getWidth(), this.getHeight());
		this.repaint();
	}
}
