package functions;

import javax.swing.JOptionPane;

public class ErrorHandler {
    public static void handle(String message, Throwable throwable) {
        JOptionPane.showMessageDialog(
                null,
                message,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
        System.exit(1);
    }
}
