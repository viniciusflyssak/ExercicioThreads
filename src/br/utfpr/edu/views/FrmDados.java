package br.utfpr.edu.views;

import br.utfpr.edu.mensagem.Mensagem;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrmDados extends JFrame{
    private JTextField tfMensagem1;
    private JTextField tfMensagem2;
    private JTextField tfMensagem3;
    private Mensagem[] mensagem;
    private JButton btEnviar;
    
    public FrmDados(){
        super.setTitle("Envio de mensagens");
        super.setLayout(new GridBagLayout());

        JLabel lbMensagem1 = new JLabel("Mensagem 1: ");
        JLabel lbMensagem2 = new JLabel("Mensagem 2: ");
        JLabel lbMensagem3 = new JLabel("Mensagem 3: ");
        JPanel pnBotoes = new JPanel();
        JPanel painel = new JPanel(new GridLayout(7, 1));
        btEnviar = new JButton("Enviar");
        
        tfMensagem1 = new JTextField();       
        tfMensagem2 = new JTextField();
        tfMensagem3 = new JTextField();
        
        painel.add(lbMensagem1);
        painel.add(tfMensagem1);        
        painel.add(lbMensagem2);
        painel.add(tfMensagem2);
        painel.add(lbMensagem3);      
        painel.add(tfMensagem3);
        pnBotoes.add(btEnviar); 
        
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.BOTH;
        cons.ipadx = 80;
        cons.gridy = 1;
        super.add(painel, cons);
        cons.gridy = 2;
        super.add(pnBotoes, cons);
        
        btEnviar.addActionListener((e) -> {
           mensagem = new Mensagem[3];
           mensagem[0] = new Mensagem(tfMensagem1.getText());
           mensagem[1] = new Mensagem(tfMensagem2.getText());
           mensagem[2] = new Mensagem(tfMensagem3.getText());
           DlgDados dlDados = new DlgDados(this, true, mensagem);
           dlDados.setVisible(true);
        });
        
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setSize(300, 250);
        super.setLocationRelativeTo(null);
        super.setVisible(true);        
    }
    
    public static void main(String[] args) {
        new FrmDados();
        
    }
}
