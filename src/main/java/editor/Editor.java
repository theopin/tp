package editor;

import exception.EditorException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Editor extends JFrame implements ActionListener {
    private JTextArea textArea;


    public Editor() {
        generateEditorUI();
    }

    private void generateEditorUI() {
        textArea = new JTextArea();
        final JMenuBar menuBar = new JMenuBar();

        // generates the menu bar for the actions and editing commands
        generateActionsBar(menuBar);
        generateEditingBar(menuBar);

        setJMenuBar(menuBar);
        add(textArea);
        setLocationByPlatform(true);
        setSize(600, 800);
        setVisible(false);
    }

    /**
     * generates the editing bar for editing commands of the UI.
     * @param menuBar takes in the menuBar and appends an editingMenu object into the menuBar.
     */
    private void generateEditingBar(JMenuBar menuBar) {
        final JMenu editingMenu = new JMenu("Edit");
        final JMenuItem editItem1 = new JMenuItem("Copy");
        final JMenuItem editItem2 = new JMenuItem("Cut");
        final JMenuItem editItem3 = new JMenuItem("Paste");

        editItem1.addActionListener(this);
        editItem2.addActionListener(this);
        editItem3.addActionListener(this);

        editingMenu.add(editItem1);
        editingMenu.add(editItem2);
        editingMenu.add(editItem3);

        menuBar.add(editingMenu);
    }

    /**
     * generates the actions command options for the UI.
     * @param menuBar takes in the menuBar and appends it with the actionsMenu object.
     */
    private void generateActionsBar(JMenuBar menuBar) {
        final JMenu actionsMenu = new JMenu("Actions");
        final JMenuItem menuItem1 = new JMenuItem("Save");
        final JMenuItem menuItem2 = new JMenuItem("Clear All");
        final JMenuItem menuItem3 = new JMenuItem("Cancel");

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);

        actionsMenu.add(menuItem1);
        actionsMenu.add(menuItem2);
        actionsMenu.add(menuItem3);

        menuBar.add(actionsMenu);
    }

    public void actionPerformed(ActionEvent a) {
        String action = a.getActionCommand();
        switch (action) {
        case "Save":
            close();
            break;
        case "Clear All":
            textArea.setText("");
            break;
        case "Cancel":
            textArea.setText("");
            close();
            break;
        case "Copy":
            textArea.copy();
            break;
        case "Cut":
            textArea.cut();
            break;
        case "Paste":
            textArea.paste();
            break;
        default:
            break;
        }
    }

    public void setContent(String content) {
        textArea.setText(content);
    }

    public String getContent() throws EditorException {
        if (textArea.getText().equals("")) {
            throw new EditorException();
        } else {
            return textArea.getText();
        }
    }

    public void open() {
        textArea.setText("");
        setVisible(true);
        setAlwaysOnTop(true);
    }

    public void waitForClose() {
        while (isVisible()) {
            try {
                TimeUnit.MICROSECONDS.sleep(1000);
            } catch (Exception e) {
                assert false;
            }
        }
    }
    
    public void close() {
        setVisible(false);
    }
}
