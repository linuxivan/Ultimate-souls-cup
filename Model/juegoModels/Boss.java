package juegoModels;

import javax.swing.*;
import java.awt.*;

public class Boss extends Thread{
    private final static int INICIAL = 0;
    private final static int CAMBIO = 1;
    private final static int FINAL = 2;

    private int ancho, alto;
    private int posX, posY;
    private int fase;

    private int vida;

    private Image[] spriteMuerte;
    private Image [] spriteParado;
    private Image [] spritePulpo;
    private Image [] spriteCambio;


    private int imagenActualParado, imagenActualPulpo, imagenActualCambio, imagenActualMuerte;

    private boolean enabled;


    public Boss(){
        ancho = 150;
        alto = 180;

        posX = 310;
        posY = 10;

        fase = INICIAL;

        vida = 3000;

        imagenActualCambio = 0;
        imagenActualMuerte = 0;
        imagenActualParado = 0;
        imagenActualPulpo = 0;


        spriteParado = new Image[36];
        for (int i = 1; i < spriteParado.length; i++) {
            if (i<10){
                spriteParado[i-1] = new ImageIcon("images/boss/fase1/Idle/devil_idle_000"+(i)+".png").getImage();
            }else if (i < 20){
                spriteParado[i-1] = new ImageIcon("images/boss/fase1/Idle/devil_idle_00"+(i)+".png").getImage();
            } else if (i < 30) {
                spriteParado[i-1] = new ImageIcon("images/boss/fase1/Idle/devil_idle_00"+(i)+".png").getImage();
            } else if (i < 40) {
                spriteParado[i-1] = new ImageIcon("images/boss/fase1/Idle/devil_idle_00"+(i)+".png").getImage();
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
                sleep(70);

            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }


    private void movimiento(){
        if (fase == INICIAL){
            if (imagenActualParado == 34){
                imagenActualParado = 0;
            }else{
                imagenActualParado++;
            }
        }
    }

    public void dibujar(Graphics g){
        if (fase == INICIAL){
            g.drawImage(spriteParado[imagenActualParado], posX, posY, ancho, alto, null);
        }
    }





}
