import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label statusLabel;

    private AuthService authService;

    public LoginController() {
        this.authService = new AuthService();
    }

    @FXML
    private void login() {
        String username = usernameField.getText();
        String password = passwordField.getText();
        boolean authenticated = authService.authenticate(username, password);
        if (authenticated) {
            // Redirect to main application
            System.out.println("Login successful!");
        } else {
            statusLabel.setText("Invalid credentials. Please try again.");
        }
    }
}
