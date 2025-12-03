package toDoList;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TaskComponent extends JPanel implements ActionListener {

    private JCheckBox checkBox;
    private JTextPane taskField;
    private JButton deleteButton;
    private JPanel parentPanel;

    public JTextPane getTaskField() {
        return taskField;
    }

    public TaskComponent(JPanel parentPanel) {
        this.parentPanel = parentPanel;

        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        checkBox = new JCheckBox();
        checkBox.setPreferredSize(CommonConstants.CHECKBOX_SIZE);
        checkBox.addActionListener(this);

        taskField = new JTextPane();
        taskField.setContentType("text/html");
        taskField.setPreferredSize(CommonConstants.TASKFIELD_SIZE);
        taskField.setMaximumSize(CommonConstants.TASKFIELD_SIZE);

        deleteButton = new JButton("X");
        deleteButton.setPreferredSize(CommonConstants.DELETE_BUTTON_SIZE);
        deleteButton.addActionListener(e -> {
            parentPanel.remove(this);
            parentPanel.revalidate();
            parentPanel.repaint();
        });

        add(checkBox);
        add(taskField);
        add(deleteButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String text = taskField.getText().replaceAll("<[^>]*>", "");
        if (checkBox.isSelected()) {
            taskField.setText("<html><s>" + text + "</s></html>");
        } else {
            taskField.setText(text);
        }
    }
}