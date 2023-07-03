package menuView;


import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

import menuControllers.EventosAreaMenu;
import menuModels.BotonMdl;
import menuModels.MenuBossModel;
import view.UltimateCupSouls;

public class AreaMenu extends Canvas{
	public static int INICIAL = 1;
	public static int BOSSES = 2;
	private int fase;
	private Image [] fondo;
	private int numFondo;
	private EventosAreaMenu eventosAreaMenu;
	private Image buffer;
	private Image logoJuego;
	private BotonMdl btnJugar, btnSalir;
	private MenuBossModel cartaBoss1, cartaBoss2;
	private UltimateCupSouls ultimateCupSouls;


	private Graphics paintVirtual;
	
	
	public AreaMenu(UltimateCupSouls ultimateCupSouls) {
		this.ultimateCupSouls = ultimateCupSouls;
		
		numFondo = 0;
		fondo = new Image[8];
		fase = INICIAL;
		
		cartaBoss1 =new MenuBossModel(new ImageIcon("images/cartaBoss1/unloSinSelec.png").getImage(), new ImageIcon("images/cartaBoss1/unloSelec.png").getImage(), new ImageIcon("images/cartaBoss1/lockSinSelec.png").getImage(), new ImageIcon("images/cartaBoss1/lockSelec.png").getImage(), 200, 300);
		cartaBoss1.setPosY(120);
		cartaBoss1.setPosX(150);
		cartaBoss1.setUnlocked(true);
		cartaBoss1.setSelected(true);
		
		cartaBoss2 =new MenuBossModel(new ImageIcon("images/cartaBoss2/unloSinSelec.png").getImage(), new ImageIcon("images/cartaBoss2/unloSelec.png").getImage(), new ImageIcon("images/cartaBoss2/lockSinSelec.png").getImage(), new ImageIcon("images/cartaBoss2/lockSelec.png").getImage(), 200, 300);
		cartaBoss2.setPosY(120);
		cartaBoss2.setPosX(450);
		cartaBoss2.setUnlocked(false);
	
		
		
		btnJugar = new BotonMdl(new ImageIcon("images/jugarSinSeleccionar.png").getImage(), new ImageIcon("images/jugarSeleccionado.png").getImage(), 350, 100);
		btnJugar.setPosX(225);
		btnJugar.setPosY(300);	
		btnJugar.setSelected(true);
		
		btnSalir = new BotonMdl(new ImageIcon("images/SalirSinSeleccionar.png").getImage(), new ImageIcon("images/SalirSeleccionado.png").getImage(), 350, 100);
		btnSalir.setPosX(225);
		btnSalir.setPosY(375);	
		
		

		logoJuego = new ImageIcon("images/logoJuego.png").getImage();
		for (int i = 0; i < fondo.length; i++) {
			fondo[i] = new ImageIcon("images/fondomenu"+(i+1)+".png").getImage();
		}
		
		eventosAreaMenu = new EventosAreaMenu(this);
	}
	
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(fondo[numFondo], 0, 0, getWidth(), getHeight(), null);
		if (fase == INICIAL) {
			g.drawImage(logoJuego, getWidth()/2-212, 55, 425, 225, null);
			btnJugar.dibujar(g);
			btnSalir.dibujar(g);
		}else if(fase == BOSSES) {
			cartaBoss1.dibujar(g);
			cartaBoss2.dibujar(g);
		}

		
	}
	
	@Override
	public void update(Graphics g) {
		buffer= createImage(this.getWidth(), this.getHeight());
		paintVirtual= buffer.getGraphics();
		paint(paintVirtual);
		g.drawImage(buffer, 0, 0, this.getWidth(), this.getHeight(),this);
	}


	public int getNumFondo() {
		return numFondo;
	}


	public void setNumFondo(int numFondo) {
		this.numFondo = numFondo;
	}


	public int getFase() {
		return fase;
	}


	public void setFase(int fase) {
		this.fase = fase;
	}


	public BotonMdl getBtnJugar() {
		return btnJugar;
	}


	public void setBtnJugar(BotonMdl btnJugar) {
		this.btnJugar = btnJugar;
	}


	public BotonMdl getBtnSalir() {
		return btnSalir;
	}


	public void setBtnSalir(BotonMdl btnSalir) {
		this.btnSalir = btnSalir;
	}


	public MenuBossModel getCartaBoss1() {
		return cartaBoss1;
	}


	public void setCartaBoss1(MenuBossModel cartaBoss1) {
		this.cartaBoss1 = cartaBoss1;
	}


	public MenuBossModel getCartaBoss2() {
		return cartaBoss2;
	}


	public void setCartaBoss2(MenuBossModel cartaBoss2) {
		this.cartaBoss2 = cartaBoss2;
	}


	public UltimateCupSouls getUltimateCupSouls() {
		return ultimateCupSouls;
	}
	
}
