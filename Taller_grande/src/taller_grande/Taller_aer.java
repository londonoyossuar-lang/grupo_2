package taller_grande;

import java.util.Random;
import javax.swing.JOptionPane;

public class Taller_aer {

    private int saldo = 10000000, saldoC = 20000000, retiroD = 2100000;
    private boolean continuar = true;

    public Taller_aer() {
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public int getSaldoC() {
        return saldoC;
    }

    public void setSaldoC(int saldoC) {
        this.saldoC = saldoC;
    }

    public int getRetiroD() {
        return retiroD;
    }

    public void setRetiroD(int retiroD) {
        this.retiroD = retiroD;
    }

    public void cajeroAutomatico() {
        while (continuar) {
            try {
                StringBuilder menu = new StringBuilder("MENU CAJERO AUTOMATICO \n\n");
                menu.append("selecione una opcion del 1 al 4  asi: \n").append("1.consulta saldo \n")
                        .append("2. consignar dinero \n")
                        .append("3. retirar dinero \n")
                        .append("4. salir  ");
                String opcion = JOptionPane.showInputDialog(null, menu,
                        "cajero automatico", JOptionPane.QUESTION_MESSAGE);
                if (opcion == null) {
                    if (confirmarsalidad()) {
                        continuar = false;
                    }
                    continue;
                }
                int opc = Integer.parseInt(opcion);
                switch (opc) {
                    case 1:
                        validacionsaldo();
                        break;
                    case 2:
                        consignar();
                        break;
                    case 3:
                        retirar();
                        break;
                    case 4:
                        salida();
                        break;
                    default:
                        throw new AssertionError();
                }

            } catch (Exception e) {
                JOptionPane.showConfirmDialog(null, "¡¡debe ingresar un  número del 1 al 4!!\n", "VALOR INVALIDO\n", JOptionPane.ERROR_MESSAGE);

            }

        }

    }

    public boolean confirmarsalidad() {
        int confimar = JOptionPane.showConfirmDialog(null, "¿esta seguro que desea salir ?",
                "confimar salida", JOptionPane.YES_NO_OPTION);
        return confimar == JOptionPane.YES_OPTION;
    }

    public String idvalidar() {
        Random random = new Random();
        int numero = random.nextInt(9000) + 1000;
        return "ID#" + numero;
    }

    public void validacionsaldo() {
        String validacion = idvalidar();
        StringBuilder mensaje = new StringBuilder("iD del saldo total\n");
        mensaje.append(validacion)
                .append("\nsaldo actual \n")
                .append(String.format("%,d ", saldo));
        JOptionPane.showConfirmDialog(null, mensaje, "saldo \n", JOptionPane.INFORMATION_MESSAGE);
    }

    public void consignar() {
        try {
            StringBuilder consi = new StringBuilder();
            JOptionPane.showInternalMessageDialog(null, "NO CONSIGNAR MONEDA PORFAVOR", "ADVERTENCIA", JOptionPane.WARNING_MESSAGE);
            consi.append("consignar saldo ");
            String con = JOptionPane.showInputDialog(null, consi, "consignar saldo", JOptionPane.DEFAULT_OPTION);
            if (con == null) {
                return;
            }
            int valor = Integer.parseInt(con);
            if (valor < 10000) {
                JOptionPane.showInternalMessageDialog(null, "Error no se puede consginar menos de 10000", "Eror", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (valor % 10000 == 0) {
                JOptionPane.showMessageDialog(null, "consignacion exitoso", "consignar", JOptionPane.INFORMATION_MESSAGE);
                saldo += valor;

            } else {
                JOptionPane.showMessageDialog(null, "valor incorrecto ", "Error", JOptionPane.ERROR_MESSAGE);
            }
                        JOptionPane.showMessageDialog(null, "consignacion exitosa\n" + idvalidar() + "\n\n" + "nuevo saldo" + String.format("%,d,", saldo), "consignacion realizado", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showInternalMessageDialog(null, "solo puede ingresar valores numericos\n", "VALOR INVALIDO\n", JOptionPane.WARNING_MESSAGE);

        }
    }

    public void retirar() {
        try {

            String inici = JOptionPane.showInputDialog(null, "¿¿cuanto desea retirar el dia de hoy??", "retirar", JOptionPane.INFORMATION_MESSAGE);
            if (inici == null) {
                return;
            }
            int valorO = Integer.parseInt(inici);
            if (valorO < 10000) {
                JOptionPane.showMessageDialog(null, "no se puede retirar menos de 10.000", "valor invalido", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (valorO > saldo) {
                JOptionPane.showMessageDialog(null, "fondos insuficiente.\n saldo actual" + String.format("%,d", saldo),
                        "erorr", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (valorO % 10000 == 0) {
                JOptionPane.showMessageDialog(null, "retiro exitoso", "retiro", JOptionPane.INFORMATION_MESSAGE);

            } else {
                JOptionPane.showMessageDialog(null, "valor incorrecto ", "Error", JOptionPane.ERROR_MESSAGE);
            }
            int retiroTotal = 0;
            if (retiroTotal - valorO >retiroD) {
                JOptionPane.showMessageDialog(null,
                        "Excedio el limite diario de " + retiroD
                        + "\n Su retiro acomulado es: " + retiroTotal);
                return;
            }
  
            saldo -= valorO;
            retiroTotal += valorO;
            JOptionPane.showMessageDialog(null,
                    "Retiro exitoso \n Nuevo saldo: " + saldo
                    + "\n Retiro acumulado hoy: " + retiroTotal);
          

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, "porfavor ingresar solo numero ", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void salida() {
        if (confirmarsalidad());
        continuar = false;
    }
}
