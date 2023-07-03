package menuModels;

import java.awt.Graphics;
import java.awt.Image;

public class MenuBossModel {
	private int altura, anchura;
	private int posX, posY;
	private Image [] imagenes;
	private boolean selected, unlocked;
	private int coste;
	
	public MenuBossModel(Image imgUnloNO,Image imgUnloS, Image imagLockNO, Image imageLockS, int alto, int ancho) {
		imagenes = new Image[4];
		imagenes[0] = imgUnloNO;
		imagenes[1] = imgUnloS;
		imagenes[2] = imagLockNO;
		imagenes[3] = imageLockS;
		
		posX = 0;
		posY = 0;
	
		coste = 0;
		
		unlocked = false;
		selected = false;
		
		anchura = ancho;
		altura = alto;
	}
	
	public void dibujar(Graphics g) {
		if (selected && unlocked) {
			g.drawImage(imagenes[1], posX, posY, altura, anchura, null);
		}else if(selected && !unlocked){
			g.drawImage(imagenes[3], posX, posY, altura, anchura, null);
		}
		
		if (unlocked && !selected) {
			g.drawImage(imagenes[0], posX, posY, altura, anchura, null);
		}else if(!selected && !unlocked) {
			g.drawImage(imagenes[2], posX, posY, altura, anchura, null);

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

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}

	public boolean isUnlocked() {
		return unlocked;
	}

	public void setUnlocked(boolean unlocked) {
		this.unlocked = unlocked;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}
	
	
}
