import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class MainGui extends JFrame {

    public static void main(String[] args) {
        new MainGui();
    }

    public MainGui() {
        super("Hauptfenster");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        init();
        this.pack();
        this.setVisible(true);
    }

    private void init() {
        //grösse
        this.setSize(500, 300);
        this.setResizable(true);
        //Layout
        this.setLayout(new BorderLayout());
        //panel
        JPanel leftPanel = new JPanel(new BorderLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(3,1));
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel searchPanel = new JPanel();
        //button
        JButton buttonArbeit = new JButton("Arbeit");
        JButton buttonDaten = new JButton("Daten");
        JButton buttonZuordnen = new JButton("Zuordnen");
        JButton buttonTutorial = new JButton("?");
        JButton buttonSearch = new JButton("Suchen");
        JButton link = new JButton("link");
        //tetfield
        JTextField search = new JTextField("Suchen");
        search.setColumns(20); //Anzahl zeichen auf der Zeile
        search.setEditable(true);
        //textArea
        JTextArea textArea = new JTextArea("Arbeit");
        textArea.setRows(20); //Anzahl Zeilen
        textArea.setColumns(50); //Anzahl Zeichen auf der Zeile
        //img
        ImageIcon image = new ImageIcon("Media\\Link.png");
        //label4img
        JLabel imageLabel = new JLabel(image);

        this.add(searchPanel, BorderLayout.NORTH);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(mainPanel, BorderLayout.CENTER);

        searchPanel.add(search);
        searchPanel.add(buttonSearch);

        leftPanel.add(buttonPanel, BorderLayout.NORTH);
        leftPanel.add(imageLabel, BorderLayout.CENTER);
        leftPanel.add(buttonTutorial, BorderLayout.SOUTH);

        buttonPanel.add(buttonArbeit);
        buttonPanel.add(buttonDaten);
        buttonPanel.add(buttonZuordnen);

        mainPanel.add(textArea);

        buttonArbeit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(textArea);
                textArea.setText("Arbeit");
            }
        });
        buttonDaten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(textArea);
                textArea.setText("Daten");
            }
        });
        buttonZuordnen.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainPanel.add(textArea);
                textArea.setText("zuordnen");
            }
        });
        buttonTutorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TutorialGui();
            }
        });
        imageLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Desktop desktop = java.awt.Desktop.getDesktop();
                try {
                    //specify the protocol along with the URL
                    URI oURL = new URI(
                            "https://www.youtube.com/watch?v=iik25wqIuFo");
                    desktop.browse(oURL);
                } catch (URISyntaxException | IOException en) {
                    en.printStackTrace();
                }
            }
        });
    }
}
