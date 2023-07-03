package menuControllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import bossView.AreaBoss1;
import menuView.AreaMenu;

public class EventosAreaMenu {
	private AreaMenu areaMenu;
	private Timer timer;

	public EventosAreaMenu(AreaMenu areaMenu) {
		this.areaMenu = areaMenu;




		timer = new Timer(80, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (areaMenu.getNumFondo() < 7) {
					areaMenu.setNumFondo(areaMenu.getNumFondo()+1);
				}else {
					areaMenu.setNumFondo(0);
				}

				areaMenu.repaint();

			}
		});
		timer.start();


		areaMenu.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyPressed(KeyEvent e) {

				if (areaMenu.getFase() == AreaMenu.INICIAL) {
					if (e.getKeyCode() == KeyEvent.VK_UP) {
						areaMenu.getBtnJugar().setSelected(true);
						areaMenu.getBtnSalir().setSelected(false);
					}

					if (e.getKeyCode() == KeyEvent.VK_DOWN) {
						areaMenu.getBtnJugar().setSelected(false);
						areaMenu.getBtnSalir().setSelected(true);
					}

					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						if (areaMenu.getBtnJugar().isSelected()) {
							areaMenu.setFase(AreaMenu.BOSSES);
						}
						if (areaMenu.getBtnSalir().isSelected()) {
							System.exit(0);
						}
					}

				}

				if (areaMenu.getFase() == AreaMenu.BOSSES) {
					if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
						areaMenu.getCartaBoss2().setSelected(true);
						areaMenu.getCartaBoss1().setSelected(false);
					}

					if (e.getKeyCode() == KeyEvent.VK_LEFT) {
						areaMenu.getCartaBoss1().setSelected(true);
						areaMenu.getCartaBoss2().setSelected(false);
					}

					if (e.getKeyCode() == KeyEvent.VK_SPACE) {
						if (areaMenu.getCartaBoss1().isSelected()) {
							areaMenu.getUltimateCupSouls().cargarBoss1();

						}else
						if (areaMenu.getCartaBoss2().isSelected()) {


						}
					}

				}

				if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
					areaMenu.setFase(AreaMenu.INICIAL);
				}




			}
		});

	}




}
