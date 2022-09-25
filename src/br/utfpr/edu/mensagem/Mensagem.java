package br.utfpr.edu.mensagem;

import java.awt.Color;
import javax.swing.JProgressBar;

public class Mensagem {
    private String msg;
    private JProgressBar pbMsg;

    public Mensagem(String msg) {
        this.msg = msg;
        pbMsg = new JProgressBar(JProgressBar.HORIZONTAL, 1, this.msg.length());
        pbMsg.setStringPainted(true);
        pbMsg.setForeground(new Color(50, 200, 20));
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public JProgressBar getPbMsg() {
        return pbMsg;
    }

    public void setPbMsg(JProgressBar pbMsg) {
        this.pbMsg = pbMsg;
    }
    
}
