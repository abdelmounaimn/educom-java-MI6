package nu.educom.MI6;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameView implements IView, ActionListener {
    private IPresenter presenter;
    private JFrame frame ;
    JButton loginBt ;
    JTextField loginTf ;
    JTextField pswTf ;
    JLabel errLb;
    JTextArea area;
    @Override
    public void show() {

        this.frame= new JFrame("login");
        JLabel logLb = new JLabel("gebruikersNaam");
        JLabel pswLb = new JLabel("wachtwoord")  ;
        this.loginBt = new JButton("login");
        this.loginTf = new JTextField(20);
        this.pswTf = new JTextField(20);
        logLb.setBounds(50,50, 100,30);
        pswLb.setBounds(50,100, 100,30);
        this.loginTf.setBounds(180,50, 150,20);
        this.pswTf.setBounds(180,100, 150,20);
        this.loginBt.setBounds(130,150,95,30);

        this.loginBt.addActionListener(this);
        this.area=new JTextArea("");
        this.area.setBounds(350,20, 150,220);
        this.area.setEditable(false);

        this.area.setFont(new Font("Serif", Font.ITALIC, 16));
        this.area.setLineWrap(true);
        this.area.setWrapStyleWord(true);

        this.frame.add(logLb);
        this.frame.add(pswLb);
        this.frame.add( this.loginBt);
        this.frame.add( this.loginTf);
        this.frame.add( this.pswTf);
        this.frame.add(this.area);

        this.frame.setSize(600,300);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
    }

    @Override
    public void installPresentor(IPresenter presenter) {
        this.presenter=presenter;
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JButton getLoginBt() {
        return loginBt;
    }

    public void setLoginBt(JButton loginBt) {
        this.loginBt = loginBt;
    }

    public JTextField getLoginTf() {
        return loginTf;
    }

    public void setLoginTf(JTextField loginTf) {
        this.loginTf = loginTf;
    }

    public JTextField getPswTf() {
        return pswTf;
    }

    public void setPswTf(JTextField pswTf) {
        this.pswTf = pswTf;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        boolean isOk=this.presenter.authenticateAgent(this.loginTf.getText(),this.pswTf.getText());
        this.area.setText(this.presenter.showMsg());
        if(isOk){
            this.loginTf.setText("");
            this.pswTf.setText("");
            this.area.setText("");
            JOptionPane.showMessageDialog(frame, "jij bent ingelogd, " + this.presenter.showMsg());
        }
    }
}
