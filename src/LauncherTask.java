import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

public class LauncherTask extends Thread {

    private String email, password;

    public LauncherTask(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public void run() {
        try {
            JFrame cover = new JFrame();
            cover.setAlwaysOnTop(true);
            JLabel t = new JLabel("<html><font color='white'>Prijungiama...</font></html>", SwingConstants.CENTER );
            t.setFont (t.getFont().deriveFont (64.0f));
            cover.add(t, BorderLayout.CENTER );
            JLabel t2 = new JLabel("<html><font color='white'>Prašome palaukti...</font></html>", SwingConstants.CENTER );
            t2.setFont (t2.getFont().deriveFont (24.0f));
            cover.add(t2, BorderLayout.BEFORE_FIRST_LINE );
            cover.setExtendedState(JFrame.MAXIMIZED_BOTH);
            cover.setUndecorated(true);
            cover.setBackground(new Color(0f,0f,0f,0.5f));
            cover.setVisible(true);
            Runtime.getRuntime().exec("C:\\Program Files (x86)\\Microsoft Studios\\Minecraft Education Edition\\Minecraft.Windows.exe", null, new File("C:\\Program Files (x86)\\Microsoft Studios\\Minecraft Education Edition\\"));

            Thread.sleep(35 * 1000);

            StringSelection stringSelection = new StringSelection(email);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, stringSelection);

            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

            Thread.sleep(5 * 1000);

            stringSelection = new StringSelection(password);
            clipboard.setContents(stringSelection, stringSelection);

            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);

            Thread.sleep(1000);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);

        } catch (IOException | InterruptedException | AWTException e1) {
            e1.printStackTrace();
        }
    }
}
