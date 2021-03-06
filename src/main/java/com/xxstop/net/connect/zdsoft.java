package com.xxstop.net.connect;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.xxstop.exception.AppException;
import com.xxstop.net.connect.data.User;
import com.xxstop.util.XHttp;
import com.xxstop.util.XZdsoftConf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * Created by xxstop on 2014/11/13.
 */
public class zdsoft {
    private JPanel container;
    private JTextField username;
    private JButton login;
    private JCheckBox remember;
    private JPasswordField password;
    private JFrame jFrame;

    private XZdsoftConf xZdsoftConf = new XZdsoftConf();
    private String confUsername = "";
    private String confPassword = "";

    public zdsoft() {
        xZdsoftConf.load(System.getProperty("user.home"));

        username.setText(XZdsoftConf.get("username"));
        password.setText(URLDecoder.decode(XZdsoftConf.get("password")));
        login.addMouseListener(new LoginMonitor());
    }

    public static void main(String[] args) {
        new zdsoft().launchFrame();
    }

    public void launchFrame() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        jFrame = new JFrame("Network Connect");
        jFrame.setContentPane(this.container);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        container = new JPanel();
        container.setLayout(new GridLayoutManager(3, 3, new Insets(15, 15, 15, 15), -1, -1));
        final Spacer spacer1 = new Spacer();
        container.add(spacer1, new GridConstraints(0, 2, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        container.add(panel1, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel2, new GridConstraints(0, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        username = new JTextField();
        panel2.add(username, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Password:");
        panel2.add(label1, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label2 = new JLabel();
        label2.setText("Username:");
        panel2.add(label2, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(68, 17), null, 0, false));
        password = new JPasswordField();
        panel2.add(password, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panel1.add(panel3, new GridConstraints(2, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        login = new JButton();
        login.setText("Connect network");
        panel3.add(login, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 5), -1, -1));
        panel1.add(panel4, new GridConstraints(1, 0, 1, 2, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        remember = new JCheckBox();
        remember.setText("Remember me And Keep network");
        panel4.add(remember, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        container.add(spacer2, new GridConstraints(0, 0, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        container.add(spacer3, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        container.add(spacer4, new GridConstraints(2, 1, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return container;
    }


    private class LoginMonitor extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (!login.isEnabled()) {
                return;
            }

            if (username.getText().equals("")
                    || new String(password.getPassword()).equals("")) {
                return;
            }

            if (remember.isSelected()) {
                confUsername = username.getText();
                confPassword = new String(password.getPassword());

                XZdsoftConf.set("username", confUsername);
                XZdsoftConf.set("password", URLEncoder.encode(confPassword));
            }

            login.setEnabled(false);

            new ConnectThread().start();
        }
    }

    private class ConnectThread extends Thread {
        @Override
        public void run() {
            User user = new User();
            boolean first = true;
            do {

                try {
                    // - 查询网络连接是否已断开
                    login.setText("Test connect");
                    if (!first && XHttp.isConnected()) {
                        User.setLogined(true);
                    } else {
                        User.setLogined(false);
                        first = false;
                    }

                    // - 用户登录
                    if (!User.isLogined()) {
                        login.setText("Connect...");
                        user.login(username.getText(), new String(password.getPassword()));
                        login.setText("Connected");
                        if (!remember.isSelected()) {
                            User.setLogined(true);
                        }
                    }

                    if (remember.isSelected()) {
                        // - 休眠
                        try {
                            login.setText("Sleeping...");
                            sleep(1000 * 60 * 5);
                        } catch (InterruptedException e1) {
                            e1.printStackTrace();
                        }
                    }

                    if (!remember.isSelected()) {
                        // - 还原结果
                        login.setText("Connect network");
                        login.setEnabled(true);
                    }

                } catch (AppException e) {
                    e.printStackTrace();

                    // - 还原结果
                    login.setText("Connect network");
                    login.setEnabled(true);
                    break;
                }

            } while (remember.isSelected());
        }
    }
}
