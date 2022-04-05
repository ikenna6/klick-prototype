import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TutorialGui extends JFrame {
    private int  page = 0;
    ArrayList<JTextArea> seiten = new ArrayList<>();
    JTextArea text0 = new JTextArea("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
    JTextArea text1 = new JTextArea("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. " +
            "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Lorem ipsum dolor sit amet,");


    JTextArea text2 = new JTextArea("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores ");
    JTextArea text3 = new JTextArea("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut l");
    JTextArea text4 = new JTextArea("Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.");
    JTextArea text5 = new JTextArea("ENde des Tutorials");


    JButton arrowRight = new JButton("right");
    JButton arrowLeft = new JButton("left");

    JPanel btnPanel = new JPanel();
    JPanel lowerPanel = new JPanel();


    JCheckBox checkBox = new JCheckBox("Tutorial nicht mehr anzeigen");

    public TutorialGui() {
        super("TutorialGUI");
        seiten.add(text0);
        seiten.add(text1);
        seiten.add(text2);
        seiten.add(text3);
        seiten.add(text4);
        seiten.add(text5);
        init();
        this.pack();
        this.setVisible(true);
    }

    private void init() {

        btnPanel.setLayout(new GridLayout(1, 2));
        lowerPanel.setLayout(new BorderLayout(15,15));

        text0.setLineWrap(true);
        text1.setLineWrap(true);
        text2.setLineWrap(true);

        btnPanel.add(arrowLeft);
        btnPanel.add(arrowRight);
        arrowLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (page == 0){
                    setEnabled(false);
                }else {
                    page--;
                }
            }
        });

        arrowRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (page == 5){
                    setEnabled(false);
                }else {
                    page++;
                }
            }
        });


        lowerPanel.add(btnPanel, BorderLayout.EAST);
        lowerPanel.add(checkBox, BorderLayout.WEST);

        getContentPane().add(text1);
        getContentPane().add(lowerPanel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new TutorialGui();
    }
}