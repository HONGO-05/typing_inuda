package typing_inuda.front;

import typing_inuda.front.screen_mode.ScreenMode;
import typing_inuda.front.window.MainWindow;

public class Main {
    public static void main(String args[]) {
        MainWindow.getInstance(ScreenMode.TITLE);
    }
}

