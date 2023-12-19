import UI.MainTableForm;
import Utils.BaseForm;
import Utils.FontUtil;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.IOException;

public class Application {

    private static Application instance;

    public static void main(String[] args) {
        new Application();
    }

    public Application() {
        instance = this;

        this.initUI();

        new MainTableForm();
    }

    private void initUI() {

        BaseForm.setBaseApplicationTitle("Application");
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }

        FontUtil.ChangeAllFonts(new FontUIResource("Comic Sans MS", Font.TRUETYPE_FONT,12));
    }

    public static Application getInstance() {
        return instance;
    }
}
