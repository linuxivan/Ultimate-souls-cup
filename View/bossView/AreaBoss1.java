package bossView;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import bossController.EventosAreaBoss1;
import juegoModels.*;

public class AreaBoss1 extends Canvas{
	public static final int INICIAL = 0;
	public static final int FINAL = 1;


	private Image [] fondo;
	private int numFondo;
	private EventosAreaBoss1 eventosAreaBoss1;
	private Image buffer;
	private Image nube;
	private Graphics paintVirtual;
	private Jugador jugador;
	private Boss boss;



	private MiniDemon [] miniDemons;
	private int actualMiniDemon;
	private Plataforma suelo;


	private int fase;

	private Bala [] balas;
	private int balaAct;


	public AreaBoss1() {
		numFondo = 0;
		fondo = new Image[8];
		for (int i = 0; i < fondo.length; i++) {
			fondo[i] = new ImageIcon("images/fondoBoss1/fondoBoss"+(i+1)+".png").getImage();
		}
		
		nube = new ImageIcon("images/cloud.png").getImage();
		fase = INICIAL;


		jugador = new Jugador();
		jugador.start();


		boss = new Boss();
		boss.start();
		
		suelo = new Plataforma(new ImageIcon("images/sueloHierbaJuego.png").getImage(), 240, 890);
		suelo.setPosY(getHeight()+480);
		suelo.setPosX(-30);


		balas = new Bala[30];
		for (int i = 0; i < balas.length; i++) {
			balas[i] = new Bala();
		}
		balaAct = 0;

		miniDemons = new MiniDemon[20];
		for (int i = 0; i < miniDemons.length ; i++) {
			miniDemons[i] = new MiniDemon();
		}
		actualMiniDemon = 0;
		eventosAreaBoss1 = new EventosAreaBoss1(this);

	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(fondo[numFondo], 0, 0, getWidth(), getHeight(), null);

		suelo.dibujar(g);

		if (fase == INICIAL){
			g.drawImage(nube, 275, 140,200 , 75, null);

			for (int i = 0; i < miniDemons.length; i++) {
				miniDemons[i].dibujar(g);
			}
		}

		jugador.dibujar(g);

		boss.dibujar(g);

		for (int i = 0; i < balaAct; i++) {
			balas[i].dibujar(g);
		}


	}
	
	
	@Override
	public void update(Graphics g) {
		buffer= createImage(this.getWidth(), this.getHeight());
		paintVirtual= buffer.getGraphics();
		paint(paintVirtual);
		g.drawImage(buffer, 0, 0, this.getWidth(), this.getHeight(),this);
	}


	public void disparar(){

			balas[balaAct].setPosX(jugador.getPosX());
			balas[balaAct].setPosY(jugador.getPosY()+(jugador.getAlto()/2));
			balas[balaAct].setDirH(jugador.getDirH());
			balas[balaAct].setEnabled(true);

			if (!balas[balaAct].isAlive()){
				balas[balaAct].start();
			}

		if (balaAct < 29){
			balaAct++;
		}else {
			balaAct = 0;
		}


	}
	public void crearDemonio(){
		balas[balaAct].setPosX(700);
		balas[balaAct].setPosY(410);
		miniDemons[actualMiniDemon].setEnabled(true);

		if (!miniDemons[actualMiniDemon].isAlive()){
			miniDemons[actualMiniDemon].start();
		}

		if (actualMiniDemon < 19){
			actualMiniDemon++;
		}else {
			actualMiniDemon = 0;
		}

	}

	public int getNumFondo() {
		return numFondo;
	}

	public void setNumFondo(int numFondo) {
		this.numFondo = numFondo;
	}

	public Jugador getJugador() {
		return jugador;
	}

	public void setJugador(Jugador jugador) {
		this.jugador = jugador;
	}

	public Plataforma getSuelo() {
		return suelo;
	}

	public void setSuelo(Plataforma suelo) {
		this.suelo = suelo;
	}

	public Bala[] getBalas() {
		return balas;
	}

	public int getFase() {
		return fase;
	}

	public void setFase(int fase) {
		this.fase = fase;
	}

	public MiniDemon[] getMiniDemons() {
		return miniDemons;
	}

	public void setMiniDemons(MiniDemon[] miniDemons) {
		this.miniDemons = miniDemons;
	}


}
