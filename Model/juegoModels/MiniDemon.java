package juegoModels;

import javax.swing.*;
import java.awt.*;

public class MiniDemon extends Thread{
    private int ancho, alto;
    private int posX, posY;

    private int vida;

    private Image[] sprite;

    private boolean enabled;

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

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public int getImagenActual() {
        return imagenActual;
    }

    public void setImagenActual(int imagenActual) {
        this.imagenActual = imagenActual;
    }

    private int imagenActual;

    private Image imgTest;

    public MiniDemon(){
        ancho = 100;
        alto = 80;
        posX = 700;
        posY = 410;
        vida = 30;

        imagenActual = 0;

        enabled = false;

        sprite = new Image[15];
        for (int i = 1; i < sprite.length+1; i++) {
            if (i<10){
                sprite[i-1] = new ImageIcon("images/boss/fase1/Attacks/miniDemon/Attack/devil_ph1_imp_run_000"+(i)+".png").getImage();
            }else if (i < 20){
                sprite[i-1] = new ImageIcon("images/boss/fase1/Attacks/miniDemon/Attack/devil_ph1_imp_run_00"+(i)+".png").getImage();

            }
        }

        imgTest = new ImageIcon("images/bala.png").getImage();


    }


    @Override
    public synchronized void start() {
        // TODO Auto-generated method stub
        super.start();
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        super.run();

        while(true) {
            movimiento();
            try {
                sleep(40);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private void movimiento() {
        if (enabled){
            posX -= 10;

            if (imagenActual == 14){
                imagenActual = 0;
            }else{
                imagenActual++;
            }
        }
    }

    public void dibujar(Graphics g){
        if (enabled){
            g.drawImage(sprite[imagenActual], posX, posY, ancho, alto, null);

        }
    }
}
