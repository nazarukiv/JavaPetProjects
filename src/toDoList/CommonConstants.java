package toDoList;

import java.awt.*;

public class CommonConstants {
    public static final Dimension GUI_SIZE = new Dimension(540, 760);
    public static final Dimension BANNER_SIZE = new Dimension(GUI_SIZE.width, 50);
    public static final Dimension TASKPANEL_SIZE = new Dimension(GUI_SIZE.width - 30, GUI_SIZE.height - 175);
    public static final Dimension ADDTASK_BUTTON_SIZE = new Dimension(GUI_SIZE.width, 50);
    public static final Dimension TASKFIELD_SIZE = new Dimension((int) (TASKPANEL_SIZE.width * 0.80), 30);
    public static final Dimension CHECKBOX_SIZE = new Dimension((int) (TASKPANEL_SIZE.width * 0.05), 30);
    public static final Dimension DELETE_BUTTON_SIZE = new Dimension((int) (TASKPANEL_SIZE.width * 0.10), 30);
}