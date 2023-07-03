package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bossView.AreaBoss1;
import menuView.AreaMenu;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;

public class UltimateCupSouls extends JFrame {

	private JPanel contentPane;
	private AreaMenu areaMenu;
	private AreaBoss1 areaBoss1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UltimateCupSouls frame = new UltimateCupSouls();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UltimateCupSouls() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("images\\logoTab.png"));
		setTitle("Ultimate Cup Souls");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		areaMenu = new AreaMenu(this);
		areaMenu.setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight());	
		contentPane.add(areaMenu);
		areaMenu.setFocusable(true);
		areaMenu.requestFocus();
		
		
		
		contentPane.setCursor(contentPane.getToolkit().createCustomCursor( new BufferedImage( 1, 1, BufferedImage.TYPE_INT_ARGB ),
                   new Point(),
                   null ) );
		
		
	}
	
	public void cargarBoss1() {
		contentPane.removeAll();
		areaBoss1 = new AreaBoss1();
		areaBoss1.setBounds(0, 0, contentPane.getWidth(), contentPane.getHeight());	
		contentPane.add(areaBoss1);
		areaBoss1.setFocusable(true);
		areaBoss1.requestFocus();
		contentPane.revalidate();
	}

}
