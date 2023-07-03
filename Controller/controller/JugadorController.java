package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import bossView.AreaBoss1;
import juegoModels.Jugador;

public class JugadorController {

	public static final int PRESSED= 1;
	public static final int UNPRESSED= 0;

	public static final int IZQUIERDA= 0;
	public static final int ARRIBA= 1;
	public static final int ESPACIO= 3;
	public static final int DERECHA= 2;

	private int [] keys;
	int notPressed;


	public JugadorController(Jugador jugador, AreaBoss1 areaBoss1) {
		keys = new int[3];
		notPressed = 0;

		keys[DERECHA] = UNPRESSED;
		keys[IZQUIERDA]= UNPRESSED;
		keys[ARRIBA]= UNPRESSED;



		areaBoss1.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					keys[DERECHA] = UNPRESSED;

				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					keys[IZQUIERDA] = UNPRESSED;

				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					keys[ARRIBA] = UNPRESSED;

				}

				for (int i = 0; i < keys.length; i++) {
					if (keys[i] == UNPRESSED) {
						notPressed++;
					}else {
						notPressed = 0;
						break;
					}
				}
				
			if (notPressed == 3) {
					notPressed = 0;
					jugador.setImgActual(0);
					jugador.setEstado(Jugador.PARADO);

				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
					keys[DERECHA] = PRESSED;
					keys[IZQUIERDA] = UNPRESSED;

					jugador.setEstado(Jugador.ANDANDO);
					jugador.setDirH(Jugador.DERECHA);

				}
				if (e.getKeyCode() == KeyEvent.VK_LEFT) {
					keys[IZQUIERDA] = PRESSED;
					keys[DERECHA] = UNPRESSED;

					jugador.setEstado(Jugador.ANDANDO);
					jugador.setDirH(Jugador.IZQUIERDA);

				}
				if (e.getKeyCode() == KeyEvent.VK_UP) {
					keys[ARRIBA] = PRESSED;
					jugador.setSaltando(true);

				}
				

			}
		});



	}
}
