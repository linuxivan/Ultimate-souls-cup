package juegoModels;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Jugador extends Thread{
	public static final int PARADO = 0;
	public static final int ANDANDO = 1;
	public static final int SUBIENDO = 2;



	public static final int DERECHA = 1;
	public static final int IZQUIERDA = 0;

	private boolean cayendo;
	private boolean saltando;

	private Image [] spriteDerecha;
	private Image [] spriteParado;
	private Image [] spriteIzquierda;
	private Image [] spriteSaltando;



	private int cantSalto;
	private int velocidadSpriteParado;

	private int ancho, alto;
	private int posX, posY, posInicY;
	private int velocidad;
	private int numVidas;

	private int dirH, dirV;

	private int estado;

	private int imgActual;

	public Jugador() {
		cayendo = false;
		saltando = false;

		cantSalto = 0;

		velocidadSpriteParado = 0;

		alto = 77;
		ancho = 49;
		posX = 0;
		posY = 0;
		posInicY = posY;

		dirH = DERECHA;
		estado = PARADO;

		numVidas = 5;

		velocidad = 10;

		imgActual = 0;

		spriteParado = new Image [5];
		for (int i = 0; i < spriteParado.length; i++) {
			spriteParado[i] = new ImageIcon("images/spritesPersonaje/Idle/cuphead_idle_000"+(i+1)+".png").getImage();
		}	


		spriteSaltando = new Image [8];
		for (int i = 0; i < spriteSaltando.length; i++) {
			spriteSaltando[i] = new ImageIcon("images/spritesPersonaje/Jump/cuphead_jump_000"+(i+1)+".png").getImage();
		}	

		spriteDerecha = new Image [16];
		for (int i = 0; i < spriteDerecha.length; i++) {
			if(i+1 <= 9) {
				spriteDerecha[i] = new ImageIcon("images/spritesPersonaje/Run/cuphead_run_shoot_000"+(i+1)+".png").getImage();

			}else {
				spriteDerecha[i] = new ImageIcon("images/spritesPersonaje/Run/cuphead_run_shoot_00"+(i+1)+".png").getImage();
			}
		}	

		spriteIzquierda = new Image [16];
		for (int i = 0; i < spriteIzquierda.length; i++) {
			if(i+1 <= 9) {
				spriteIzquierda[i] = new ImageIcon("images/spritesPersonaje/Run-left/cuphead_run_shoot_000"+(i+1)+".png").getImage();

			}else {
				spriteIzquierda[i] = new ImageIcon("images/spritesPersonaje/Run-left/cuphead_run_shoot_00"+(i+1)+".png").getImage();
			}
		}
	}

	@Override
	public synchronized void start() {
		// TODO Auto-generated method stub
		super.start();
	}


	@Override
	public void run() {
		super.run();


		while(true) {
			movimiento();
			try {
				sleep(30);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}




	public void movimiento() {
		if(cayendo) {
			posY+= velocidad/2;
			if (imgActual >= 7) {
				imgActual = 0;
			}else {
				imgActual++;
			}
		}

		if (saltando) {
			if (imgActual >= 7) {
				imgActual = 0;
			}else {
				imgActual++;
			}
			if (cantSalto <= 15) {
				cantSalto++;
				posY-= velocidad;
				posInicY = posY;
			}else
				if (cantSalto > 15 && cantSalto < 25) {
					cantSalto++;
					posY = posInicY;
				}else {
					saltando = false;

				}
		}else {
			cantSalto = 0;
		}


		if (estado == PARADO && !cayendo && !saltando) {
			velocidadSpriteParado++;
			if (velocidadSpriteParado == 3) {
				velocidadSpriteParado = 0;
				if(imgActual >=4) {
					imgActual = 0;
				}else {
					imgActual++;
				}
			}

		}
		if (estado == ANDANDO && !cayendo && !saltando) {
			if(imgActual >= 15 ) {
				imgActual = 0;
			}else {
				imgActual++;
			}

		}
		if (estado == ANDANDO) {


			if(dirH == DERECHA) {
				posX += velocidad;
			}
			if(dirH == IZQUIERDA) {
				posX -= velocidad;
			}

		}
	}


	public void dibujar(Graphics g) {
		if (estado == PARADO && !cayendo && imgActual < 5) {
			g.drawImage(spriteParado[imgActual], posX, posY, ancho, alto, null);
		}
		if (estado == ANDANDO && dirH == DERECHA && !cayendo) {
			g.drawImage(spriteDerecha[imgActual], posX, posY, ancho, alto, null);
		}
		if (estado == ANDANDO && dirH == IZQUIERDA && !cayendo) {
			g.drawImage(spriteIzquierda[imgActual], posX, posY, ancho, alto, null);
		}
		if (cayendo) {
			g.drawImage(spriteSaltando[imgActual], posX, posY, ancho, alto/2+alto/3, null);
		}
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
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

	public int getPosInicY() {
		return posInicY;
	}

	public void setPosInicY(int posInicY) {
		this.posInicY = posInicY;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getNumVidas() {
		return numVidas;
	}

	public void setNumVidas(int numVidas) {
		this.numVidas = numVidas;
	}

	public int getDirH() {
		return dirH;
	}

	public void setDirH(int dirH) {
		this.dirH = dirH;
	}

	public int getDirV() {
		return dirV;
	}

	public void setDirV(int dirV) {
		this.dirV = dirV;
	}

	public int getEstado() {
		return estado;
	}

	public void setEstado(int estado) {
		this.estado = estado;
	}

	public int getImgActual() {
		return imgActual;
	}

	public void setImgActual(int imgActual) {
		this.imgActual = imgActual;
	}

	public Rectangle getRect() {
		return (new Rectangle(posX, posY, ancho, alto));
	}

	public boolean isCayendo() {
		return cayendo;
	}

	public void setCayendo(boolean cayendo) {
		this.cayendo = cayendo;
	}

	public boolean isSaltando() {
		return saltando;
	}

	public void setSaltando(boolean saltando) {
		this.saltando = saltando;
	}


}
