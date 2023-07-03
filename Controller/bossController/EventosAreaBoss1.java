package bossController;

import java.awt.event.*;

import javax.swing.Timer;

import bossView.AreaBoss1;
import controller.JugadorController;
import juegoModels.Bala;
import juegoModels.Jugador;

public class EventosAreaBoss1 {


	private Timer timer, timerMiniDemons;
	private AreaBoss1 areaBoss1;
	private JugadorController jugadorController;



	public EventosAreaBoss1(AreaBoss1 areaBoss1) {
		this.areaBoss1 = areaBoss1;

		jugadorController = new JugadorController(areaBoss1.getJugador(), areaBoss1);


		timer = new Timer(14, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (areaBoss1.getNumFondo() < 7) {
					areaBoss1.setNumFondo(areaBoss1.getNumFondo()+1);
				}else {
					areaBoss1.setNumFondo(0);
				}

				areaBoss1.repaint();

				colisiones();
			}
		});
		timer.start();

		timerMiniDemons = new Timer(2000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				areaBoss1.crearDemonio();
			}
		});
		timerMiniDemons.start();


		areaBoss1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE){
					areaBoss1.disparar();
				}
			}
		});

	}

	public void colisiones() {
		if (areaBoss1.getJugador().getRect().intersects(areaBoss1.getSuelo().getRect())) {
			areaBoss1.getJugador().setCayendo(false);
		}else {
			areaBoss1.getJugador().setCayendo(true);
		}

		if (areaBoss1.getJugador().getPosX() >= 725){
			areaBoss1.getJugador().setPosX(725);
		}
		if (areaBoss1.getJugador().getPosX() <= 0){
			areaBoss1.getJugador().setPosX(0);
		}

		for (int i = 0; i < areaBoss1.getBalas().length ; i++) {
			if (areaBoss1.getBalas()[i].getPosX()> areaBoss1.getWidth()){
				areaBoss1.getBalas()[i].setEnabled(false);
			}
			if (areaBoss1.getBalas()[i].getPosX()< 0){
				areaBoss1.getBalas()[i].setEnabled(false);
			}
		}

		for (int i = 0; i < areaBoss1.getMiniDemons().length ; i++) {
			if (areaBoss1.getMiniDemons()[i].getPosX()< 0){
				areaBoss1.getMiniDemons()[i].setEnabled(false);
			}
		}


	}

}
