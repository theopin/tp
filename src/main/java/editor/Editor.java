package editor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor extends JFrame implements ActionListener {
    JTextArea textArea;
    JFrame editorFrame;
    static String typedText;
    static boolean isEditDone;

    public Editor(){
        isEditDone = false;
        editorFrame = new JFrame("editor");
        textArea = new JTextArea();

        JMenuBar menuBar = new JMenuBar();

        JMenu menu1 = new JMenu("Actions");

        JMenuItem menuItem1 = new JMenuItem("Save");
        JMenuItem menuItem2 = new JMenuItem( "Clear All");
        JMenuItem menuItem3 = new JMenuItem("Cancel");

        menuItem1.addActionListener(this);
        menuItem2.addActionListener(this);
        menuItem3.addActionListener(this);

        menu1.add(menuItem1);
        menu1.add(menuItem2);
        menu1.add(menuItem3);

        menuBar.add(menu1);

        editorFrame.setJMenuBar(menuBar);
        editorFrame.add(textArea);
        editorFrame.setSize(600,800);
        editorFrame.show();
    }

    public void actionPerformed(ActionEvent a){
        String action = a.getActionCommand();
        switch (action) {
        case "Save":
            toggleEdit();
            typedText = textArea.getText();
            editorFrame.dispose();
            break;
        case "Clear All":
            textArea.setText(" ");
            break;
        case "Cancel":
            textArea.setText(" ");
            editorFrame.setVisible(false);
            break;
        }
    }

    private void toggleEdit(){
        isEditDone = true;
    }

    public boolean isEditDone() {
        return isEditDone;
    }

    public String getContent(){
        return typedText;
    }
}
