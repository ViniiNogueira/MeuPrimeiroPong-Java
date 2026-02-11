import javax.swing.*;
import java.awt.*;

public class Barras{
    int X;
    int Y;
    int Largura;
    int Altura;
    int velocidadeY;

    public Barras(int posicaoX){
        this.X= posicaoX;
        this.Y = 300;
        this.Largura = 20;
        this.Altura = 100;
    }

    public void Desenhar(Graphics g){
        g.setColor(Color.white);
        g.fillRect(X,Y,Largura,Altura);

    }
}
