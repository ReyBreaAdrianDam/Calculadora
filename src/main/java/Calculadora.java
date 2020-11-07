
import java.awt.*;
public class Calculadora extends Frame{
    private String numCalc = "0";
    private double numGuardado = 0;
    private final static String[] TECLAS = {
            "Del","CE","C","/",
            "7","8","9","*",
            "4","5","6","-",
            "1","2","3","+",
            ".","0","%","="
    };
    private Operacion estado;
    private final static Panel PANEL_PRINCIPAL = new Panel(new BorderLayout());
    private final static Panel PANEL_TEXTO = new Panel(new BorderLayout());
    private final static Panel PANEL_BOTON = new Panel(new GridLayout(TECLAS.length / 4,4));
    private final Label TEXTO;
    public Calculadora() {
        this.add(PANEL_PRINCIPAL);
        PANEL_PRINCIPAL.add(PANEL_TEXTO, BorderLayout.NORTH);
        PANEL_PRINCIPAL.add(PANEL_BOTON, BorderLayout.CENTER);
        TEXTO = new Label(numCalc);
        TEXTO.setFont(new Font(null,Font.BOLD,40));
        PANEL_TEXTO.add(TEXTO);
        generarBotones(TECLAS);
    }
    /**
     * Este metodo genera los botones de la calculadora
     */
    public void generarBotones(String... tecla){
        for(String x : tecla) {
            Button boton = new Button(x);
            PANEL_BOTON.add(boton);
            boton.addActionListener(e -> {
                try{
                    switch (boton.getLabel()) {
                        case "+":
                            if(!numCalc.equals("-0")) {
                                estado = Operacion.SUMA;
                                numGuardado = Double.parseDouble(numCalc);
                            }
                            numCalc = "0";
                            break;
                        case "-":
                            if(!numCalc.equals("0")) {
                                estado = Operacion.RESTA;
                                numGuardado = Double.parseDouble(numCalc);
                                numCalc = "0";
                            }
                            else
                                numCalc = "-0";
                            break;
                        case "*":
                            estado = Operacion.MULTIPLICACION;
                            numGuardado = Double.parseDouble(numCalc);
                            numCalc = "0";
                            break;
                        case "/":
                            estado = Operacion.DIVISION;
                            numGuardado = Double.parseDouble(numCalc);
                            numCalc = "0";
                            break;
                        case "=":
                            //Estado de la operación
                            switch (estado) {
                                case SUMA:
                                    numCalc = String.valueOf(numGuardado + Double.parseDouble(numCalc));
                                    estado = null;
                                    break;
                                case RESTA:
                                    numCalc = String.valueOf(numGuardado - Double.parseDouble(numCalc));
                                    estado = null;
                                    break;
                                case MULTIPLICACION:
                                    numCalc = String.valueOf(numGuardado * Double.parseDouble(numCalc));
                                    estado = null;
                                    break;
                                case DIVISION:
                                    numCalc = String.valueOf(numGuardado / Double.parseDouble(numCalc));
                                    estado = null;
                                    break;
                            }
                            break;
                        case "%":
                            switch (estado) {
                                case SUMA:
                                    numCalc = String.valueOf((numGuardado + Double.parseDouble(numCalc))/100);
                                    estado = null;
                                    break;
                                case RESTA:
                                    numCalc = String.valueOf((numGuardado - Double.parseDouble(numCalc))/100);
                                    estado = null;
                                    break;
                                case MULTIPLICACION:
                                    numCalc = String.valueOf((numGuardado * Double.parseDouble(numCalc))/100);
                                    estado = null;
                                    break;
                                case DIVISION:
                                    numCalc = String.valueOf((numGuardado / Double.parseDouble(numCalc))/100);
                                    estado = null;
                                    break;
                            }
                            break;
                        case "C":
                            estado = null;
                            numCalc = "0";
                            numGuardado = 0;
                            break;
                        case "CE":
                            numCalc = "0";
                            break;
                        case "Del":
                            if (!numCalc.equals(""))
                                numCalc = numCalc.substring(0, numCalc.length() - 1);
                            if(numCalc.equals(""))
                                numCalc = "0";
                            break;
                        case ".":
                            numCalc += boton.getLabel();
                            break;
                        default:
                            if(numCalc.equals("0"))
                                numCalc = boton.getLabel();
                            else if(numCalc.equals("-0"))
                                numCalc = "-" + boton.getLabel();
                            else
                                numCalc += boton.getLabel();
                            break;
                    }
                    TEXTO.setText(numCalc);
                }
                catch (Exception ex){
                    TEXTO.setText("ERROR");
                }
            });
        }
    }

}
