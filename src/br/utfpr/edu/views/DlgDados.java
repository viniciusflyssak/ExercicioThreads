package br.utfpr.edu.views;

import br.utfpr.edu.mensagem.Mensagem;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class DlgDados extends JDialog {

    private JButton btFechar;
    private Mensagem[] mensagem;
    private Thread thread;

    public DlgDados(JFrame parent, boolean modal, Mensagem mensagem[]) {
        super.setTitle("Enviar dados");
        super.setLayout(new BorderLayout());
        this.mensagem = mensagem;       
        
        JLabel lbMensagem1 = new JLabel("Enviando Mensagem 1");
        JLabel lbMensagem2 = new JLabel("Enviando Mensagem 2");
        JLabel lbMensagem3 = new JLabel("Enviando Mensagem 3");

        JPanel pnDados = new JPanel(new GridLayout(7, 1));
        btFechar = new JButton("Fechar");
        
        pnDados.add(lbMensagem1);
        pnDados.add(mensagem[0].getPbMsg());        
        pnDados.add(lbMensagem2);
        pnDados.add(mensagem[1].getPbMsg());        
        pnDados.add(lbMensagem3);
        pnDados.add(mensagem[2].getPbMsg());        

        JPanel pnBotoes = new JPanel(new GridLayout(1, 1));
        pnBotoes.add(btFechar);

        super.add(pnDados, BorderLayout.CENTER);
        super.add(pnBotoes, BorderLayout.SOUTH);
        
        btFechar.addActionListener((e) -> {
           System.exit(0);
        });       

        super.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        super.setSize(300, 200);
        super.setVisible(true);
        
        atualizaBarra(mensagem[0].getPbMsg());       
        atualizaBarra(mensagem[1].getPbMsg());   
        atualizaBarra(mensagem[2].getPbMsg()); 
    }    
    
    public void atualizaBarra(JProgressBar pb){  
        if (pb.getValue() == 1){
            thread = new Thread(() -> {
                for (int i = 0; i <= pb.getMaximum(); i++) {            
                    try {
                        pb.setValue(i);
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        System.out.println("Erro: ' + ex.getMessage()");
                    }   
                }
            });        
            thread.start();
        }
    }    
}   
