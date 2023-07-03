package juegoModels;

import java.awt.*;

import javax.swing.ImageIcon;

public class Bala extends Thread{
	private final static int DERECHA = 1;
	private final static int IZQUIERDA = 0;


	private int ancho, alto;




	private int posX, posY;
	private int dirH;
	private Image imagenBalaDer, imagenBalaIzq;
	private int velocidad;
	private boolean enabled;
	
	public Bala() {
		posX = 0;
		posY = 0;
		dirH = -1;

		imagenBalaDer = new ImageIcon("images/bala.png").getImage();

		velocidad = 60;
		
		ancho = 20;
		alto = 15;

		enabled = false;
	}
	
	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		while(true) {
			movimiento();

			try {
				sleep(velocidad);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public void movimiento() {
		if (enabled){
			if (dirH == DERECHA) {
				posX += velocidad;
			}else {
				posX -= velocidad;
			}
		}

	}
	
	public void dibujar(Graphics g) {
		if (enabled){

			if (dirH == DERECHA)
			{
				g.drawImage(imagenBalaDer, posX, posY, ancho, alto, null);
			}
			if (dirH == IZQUIERDA)
			{
				g.drawImage(imagenBalaDer, posX, posY, ancho, alto, null);
			}
		}

	}
	public Rectangle getRect(){
		return (new Rectangle(posX, posY, ancho, alto));
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public void setDirH(int dirH) {
		this.dirH = dirH;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public int getPosX() {
		return posX;
	}

	public int getPosY() {
		return posY;
	}
}
