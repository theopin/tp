package editor;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor extends JFrame implements ActionListener {
    JTextArea textArea;
    JFrame editorFrame;
    static String typedText;
    static boolean isEditDone;

    public Editor() {
        generateEditorUI();
    }

    public Editor(String content) {
        generateEditorUI();
        textArea.setText(content);
    }

    private void generateEditorUI() {
        isEditDone = false;
        editorFrame = new JFrame("editor");
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

        editorFrame.setJMenuBar(menuBar);
        editorFrame.add(textArea);
        editorFrame.setSize(600, 800);
        editorFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        String action = a.getActionCommand();
        switch (action) {
        case "Save":
            toggleEdit();
            typedText = textArea.getText();
            // textArea.setText("");
            editorFrame.dispose();
            break;
        case "Clear All":
            textArea.setText("");
            break;
        case "Cancel":
            toggleEdit();
            textArea.setText("");
            editorFrame.dispose();
            break;
        default:
            break;
        }
    }

    public void toggleEdit() {
        isEditDone = !isEditDone;
    }

    public boolean isEditDone() {
        return isEditDone;
    }

    public String getContent() {
        return typedText;
    }
}
