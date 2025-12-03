package toDoList;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ToDoListGui().setVisible(true));
    }
}