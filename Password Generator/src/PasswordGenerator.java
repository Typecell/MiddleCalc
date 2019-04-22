import java.awt.*;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.StringSelection;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

public class PasswordGenerator {

    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        StringSelection ss = new StringSelection(password.toString());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, (ClipboardOwner)null);
    }

    public static ByteArrayOutputStream getPassword() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(8);
        byte[] arr = new byte[8];

        arr[0] = createSmallLetter();
        arr[1] = createNumber();
        arr[2] = createBigLetter();

        Random random = new Random();

        for (int i = 3; i < 8; i++) {
            byte symbol = 0;
            int command = random.nextInt(3) + 1;

            switch (command) {
                case 1: symbol = createNumber(); break;
                case 2: symbol = createSmallLetter(); break;
                case 3: symbol = createBigLetter(); break;
            }

            arr[i] = symbol;
        }

        try {
            byteArrayOutputStream.write(arr);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return byteArrayOutputStream;
    }

    public static byte createNumber() {
        Random random = new Random();
        int diff = 57 - 48;
        int i = random.nextInt(diff + 1);
        i += 48;
        return (byte) i;
    }

    public static byte createSmallLetter() {
        Random random = new Random();
        int diff = 122 - 97;
        int i = random.nextInt(diff + 1);
        i += 97;
        return (byte) i;
    }

    public static byte createBigLetter() {
        Random random = new Random();
        int diff = 90 - 65;
        int i = random.nextInt(diff + 1);
        i += 65;
        return (byte) i;
    }
}
