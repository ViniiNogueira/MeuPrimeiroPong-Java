import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Jogo extends JPanel implements KeyListener {

    // vriavel pra pontos
    int PontosJ1;
    int PontosJ2;

    Bolinha bolinha = new Bolinha();
    Barras barras = new Barras(20);
    Barras barras2 = new Barras(560);

    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        bolinha.paintComponent(g);
        barras.Desenhar(g);
        barras2.Desenhar(g);

        //placar
        g.drawString("Pontos: " + PontosJ1, 100, 50);
        g.drawString("Pontos: " + PontosJ2, 400, 50);
    }

    public Jogo(){
        // cor e tamanho da tela "usavel"
        setBackground(Color.black);
        setPreferredSize(new Dimension(600,600));

        Timer timer = new Timer(10 , new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bolinha.mover(getWidth() , getHeight());
                repaint();

                // colisao bola Barra (esquerda)

                if (bolinha.X <= barras.X + barras.Largura && bolinha.Y + bolinha.tamanho >=  barras.Y && bolinha.Y <= barras.Y + barras.Altura) {
                    bolinha.velocidadeX *= -1; // muda a velocidade
                    bolinha.X = barras.X + barras.Largura + 1; // "joga" a bolinha pra frente da barra
                }
                //colisao barra2 (direita)
                if (bolinha.X + bolinha.tamanho >= barras2.X && bolinha.Y + bolinha.tamanho >=  barras2.Y && bolinha.Y <= barras2.Y + barras2.Altura) {
                    bolinha.velocidadeX *= -1; // muda velocidade
                    bolinha.X = barras2.X - bolinha.tamanho - 1; // coloca a bolinha na frente a barra (evita bugs da bola atras da barra infinitamente)
                }
                // logicaa de pontos
                if (bolinha.X < 0 ){
                    PontosJ2++;
                    System.out.println("Placar: " + PontosJ1 + " x " + PontosJ2);
                    ResetarBolinha(); // volta pra posicao inicial
                }
                if (bolinha.X > getWidth() ){
                    PontosJ1++;
                    System.out.println("Placar: " + PontosJ1 + " x " + PontosJ2);
                    ResetarBolinha(); // volta pra posicao inicial
                }

            }
        });
        timer.start();

        setFocusable(true);
        addKeyListener(this);
    }

    // movimento da barra
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        //barra1
        if (e.getKeyCode() == KeyEvent.VK_W){
            barras.Y -= 30;
        }
        if ( e.getKeyCode() == KeyEvent.VK_S){
            barras.Y += 30;
        }
        repaint();

        // para a barra2
        if (e.getKeyCode() == KeyEvent.VK_UP){
            barras2.Y -= 30;
        }
        if ( e.getKeyCode() == KeyEvent.VK_DOWN){
            barras2.Y += 30;
        }
        repaint();
    }
    @Override
    public void keyReleased(KeyEvent e) {}
    //resetar a bola e votlar ao inicio

    public void ResetarBolinha() {
        bolinha.X = 300;
        bolinha.Y = 300;

        bolinha.velocidadeX *= -1; // inverte a direcao
    }
}