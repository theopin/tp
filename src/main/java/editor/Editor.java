package editor;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JFrame editorFrame;
    private String typedText;

    public Editor() {
        generateEditorUI();
    }

    private void generateEditorUI() {
//        editorFrame = new JFrame("editor");
        textArea = new JTextArea();

        final JMenuBar menuBar = new JMenuBar();

        final JMenu menu1 = new JMenu("Actions");

        final JMenuItem menuItem1 = new JMenuItem("Save");
        final JMenuItem menuItem2 = new JMenuItem("Clear All");
        final JMenuItem menuItem3 = new JMenuItem("Cancel");

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);

        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);

        menuBar.add(menu1);

        setJMenuBar(menuBar);
        add(textArea);
        setSize(600, 800);
        setVisible(false);
    }

    public void actionPerformed(ActionEvent a) {
        String action = a.getActionCommand();
        switch (action) {
        case "Save":
            typedText = textArea.getText();
            close();
            break;
        case "Clear All":
            textArea.setText("");
            break;
        case "Cancel":
            close();
            break;
        default:
            break;
        }
    }

    public String getContent() {
        return typedText;
    }

    public void open(){
        textArea.setText("");
        typedText = "";
        setVisible(true);
    }

    public void close(){
        setVisible(false);
    }
}
