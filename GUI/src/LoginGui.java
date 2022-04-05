import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGui extends JFrame {

    //Gui elemente erzeugen

    private String username = "ikenna";
    private String passwort = "leo";

    private static int anzVersuche = 3;
    JButton btnLogin = new JButton("login");

    JLabel labelUsername = new JLabel("Benutzername                       ");
    JLabel labelPwd = new JLabel("Passwort");
    JLabel labelHinweis = new JLabel("Sie haben noch " + anzVersuche + " Versuche!");

    JTextField eingabeUser = new JTextField();
    JTextField eingabePwd = new JTextField();

    JPanel panelUsername = new JPanel();
    JPanel panelPwd = new JPanel();
    JPanel panelTest = new JPanel();
    JPanel panelTest2 = new JPanel();

    //JPanel panelLoginButton = new JPanel();


    //panels erzeugen
    public LoginGui() {
        //Frame gestalten
        super("Login");
        setResizable(false);
        setSize(150,400);
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(15,15));
        panelUsername.setLayout(new GridLayout(2, 1));
        panelPwd.setLayout(new GridLayout(3, 1));
        panelTest.setLayout(new BorderLayout(15,15));
        panelTest2.setLayout(new BorderLayout(15,15));

        //Panel zusammensetzten
        panelUsername.add(labelUsername);
        panelUsername.add(eingabeUser);

        panelTest2.add(panelUsername, BorderLayout.WEST);

        panelPwd.add(labelPwd);
        panelPwd.add(eingabePwd);
        panelPwd.add(labelHinweis);

        panelTest.add(panelPwd, BorderLayout.WEST);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (eingabeUser.getText().equals(username) && eingabePwd.getText().equals(passwort)){
                    LoginGui.super.dispose();
                    new MainGui();
                }else {
                    if (anzVersuche <=1){
                        LoginGui.super.dispose();
                    }
                    anzVersuche--;
                    eingabePwd.setText("");
                    System.out.println(" Versuche sind jetzt runter" + anzVersuche);
                    labelHinweis.setText("Sie haben noch " + anzVersuche + " Versuche!");
                }
            }
        });
        //Gui zusammensetzten
        getContentPane().add(panelTest2, BorderLayout.NORTH);
        getContentPane().add(panelTest, BorderLayout.CENTER);
        getContentPane().add(btnLogin, BorderLayout.SOUTH);


        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginGui();
    }
}

