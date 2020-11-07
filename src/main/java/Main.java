
import java.awt.event.*;

public class Main{
    private static Calculadora ventanaPrincipal;
    public static void main(String[] args) {
        ventanaPrincipal = new Calculadora();
        ventanaPrincipal.setTitle("Calculadora AWT");
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setSize(300, 400);
        ventanaPrincipal.setResizable(false);
        ventanaPrincipal.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
