import java.awt.*;

public class Bolinha {

    // pisocao , tamanho e velocidade
    //posicoes
    int X;
    int Y;
    int tamanho;
    int velocidadeX;
    int velocidadeY;

    public  Bolinha() {
        this.X = 300;
        this.Y = 300;
        this.tamanho = 20;
        this.velocidadeX = 10 ; //pixels por segundo
        this.velocidadeY = 10;}

    public void paintComponent(Graphics g){
        g.setColor(Color.white);
        g.fillOval(X,Y,tamanho,tamanho);
    }

    // metodo pra se mover
    public void mover( int LarguraTela , int AlturaTela) {
        X += velocidadeX;
        Y += velocidadeY;

        if (Y + tamanho >= AlturaTela){
            velocidadeY *=-1;
        }
        // teto é no 0 prestar atencao nesses detalhes
        if (Y <= 0){
            velocidadeY *= -1;
        }
    }
}
