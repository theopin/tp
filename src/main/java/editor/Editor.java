package editor;

import exception.EditorException;

import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JTextArea;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JMenuItem;


import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

public class Editor extends JFrame implements ActionListener {
    private JTextArea textArea;
    private JLabel footerLabel;
    private String cheatSheetName;
    private String cheatSheetSubject;

    public Editor() {
        generateEditorUI();
    }

    /**
     * Initializes the editor with the necessary elements.
     */
    private void generateEditorUI() {
        textArea = new JTextArea();
        footerLabel = new JLabel();
        final JMenuBar menuBar = new JMenuBar();

        setEditorLayout();
        generateTextArea();
        generateEditorFooter();
        generateEditorHeader(menuBar);
    }

    /**
     * generates the menu bar for the editor, which contains the editor and actions tab.
     * @param menuBar to be added into the frame on the header of the page.
     */
    private void generateEditorHeader(JMenuBar menuBar) {
        generateActionsBar(menuBar);
        generateEditingBar(menuBar);
        add(menuBar,BorderLayout.PAGE_START);
    }

    private void setEditorLayout() {
        setSize(800,600); // sets the editor window size
        setTitle("CheatLogs Editor"); // sets the editor name
        setLayout(new BorderLayout()); // determines the layout of the editor
    }

    /**
     * Generates the editor's text are where the user can input the details of the cheatsheet.
     */
    private void generateTextArea() {
        textArea.setSelectionColor(Color.GRAY); // sets the color of the text Area
        textArea.setSize(800,600); // sets the size of the text Area
        add(textArea, BorderLayout.CENTER); // adds the text area into the center of the frame
    }

    /**
     * Generates the editor footer to tell the cheatsheet name and subject that is being edited.
     */
    private void generateEditorFooter() {
        JPanel editorFooter = new JPanel();
        editorFooter.setBounds(0,500,800,50);
        editorFooter.add(footerLabel);
        editorFooter.setBackground(Color.CYAN);
        add(editorFooter,BorderLayout.PAGE_END);
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

    /**
     * Sets the cheatsheet attributes for the editor footer.
     * @param name takes in the name to be placed in the footer
     * @param subject takes in the cheatsheet subject to be placed in the footer.
     */
    public void setEditingContentAttributes(String name, String subject) {
        cheatSheetName = name;
        cheatSheetSubject = subject;
    }

    public void open() {
        textArea.setText("");
        footerLabel.setText("You are editing the " + cheatSheetName + " Subject: " + cheatSheetSubject);
        setVisible(true);
        setAlwaysOnTop(true);
    }

    /**
     * Waits for the editor to close to terminate the program and return the controls to the editor.
     */
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
