package menuModels;

import java.awt.Graphics;
import java.awt.Image;

public class BotonMdl {
	private int altura, anchura;
	private int posX, posY;
	private Image [] imagenes;
	private boolean selected;
	
	public BotonMdl(Image imagenSinSeleccion, Image imagenSeleccionado,  int alto ,int ancho) {
		imagenes = new Image[2];
		
		selected = false;
		altura = alto;
		anchura = ancho;
		
		posX = 0;
		posY = 0;
		
		imagenes[0] = imagenSinSeleccion;
		imagenes[1] = imagenSeleccionado;
		
	}
	
	
	public void dibujar(Graphics g) {
		if (selected) {
			g.drawImage(imagenes[1], posX, posY, altura, anchura, null);
		}else {
			g.drawImage(imagenes[0], posX, posY, altura, anchura, null);

		}
	}


	public int getAltura() {
		return altura;
	}


	public void setAltura(int altura) {
		this.altura = altura;
	}


	public int getAnchura() {
		return anchura;
	}


	public void setAnchura(int anchura) {
		this.anchura = anchura;
	}


	public int getPosX() {
		return posX;
	}


	public void setPosX(int posX) {
		this.posX = posX;
	}


	public int getPosY() {
		return posY;
	}


	public void setPosY(int posY) {
		this.posY = posY;
	}


	public Image[] getImagenes() {
		return imagenes;
	}


	public void setImagenes(Image[] imagenes) {
		this.imagenes = imagenes;
	}


	public boolean isSelected() {
		return selected;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}


	
	

}
