import javax.swing.*;

public class Janela extends JFrame {

    public Janela() {
        //Janela visivel e config basica
        setTitle("Pong-java");
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);

        //Jpanel
        Jogo TamanhoJogo = new Jogo();
        add(TamanhoJogo);

        //pro Jframe usar o tamanho do Jpanel
        pack();
        setVisible(true);
    }
}
