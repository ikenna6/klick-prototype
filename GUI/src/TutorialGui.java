import javax.swing.*;
import java.awt.*;

public class TutorialGui extends JFrame {

    public TutorialGui() {
        super("TutorialGUI");
        init();
        this.pack();
        this.setVisible(true);
    }

    private void init() {
        //textArea
        JTextArea textArea = new JTextArea("Tutorial");
        textArea.setRows(20); //Anzahl Zeilen
        textArea.setColumns(50); //Anzahl Zeichen auf der Zeile

        setLayout(new BorderLayout());
        this.add(textArea, BorderLayout.CENTER);
    }
}
