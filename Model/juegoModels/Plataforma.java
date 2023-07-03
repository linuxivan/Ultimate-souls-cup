package juegoModels;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public class Plataforma {
	private int altura, anchura;
	private int posX, posY;
	private Image imagen;
	
	public Plataforma(Image imagen, int altura, int anchura) {
		this.imagen = imagen;
		
		this.anchura = anchura;
		this.altura = altura;
		
		posX = 0;
		posY = 0;
		
		
	}
	
	
	public void dibujar(Graphics g) {
		g.drawImage(imagen, posX, posY,anchura,altura , null);
	}
	
	
	public Rectangle getRect() {
		return (new Rectangle(posX, posY, anchura, altura));
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
}
