package nu.educom.MI6;

import javax.swing.*;

public class JFrameView implements IView{
    private JFrame frame = new JFrame("LoginFrame");

    @Override
    public void askFormLogin() {
        JPanel panel = new JPanel();

    }

    @Override
    public void askFormPassword() {

    }

    @Override
    public void showLoggedIn() {

    }

    @Override
    public void show() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setSize(350, 250);
        this.frame.setVisible(true);

        JButton loginBtn = new JButton("Login");

    }

    @Override
    public void installPresentor( IPresentor presentor) {

    }
}
