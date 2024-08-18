import javafx.fxml.FXML;
import javafx.scene.control.*;

public class StudentManagementController {

    @FXML
    private TableView<Student> studentTable;

    @FXML
    private TableColumn<Student, String> idColumn;

    @FXML
    private TableColumn<Student, String> firstNameColumn;

    @FXML
    private TableColumn<Student, String> lastNameColumn;

    @FXML
    private TableColumn<Student, String> emailColumn;

    @FXML
    private TableColumn<Student, String> phoneColumn;

    @FXML
    private TextField idField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField phoneField;

    private StudentRegistrationSystem registrationSystem;

    @FXML
    private void initialize() {
        registrationSystem = new StudentRegistrationSystem();
        // Initialize table columns
        idColumn.setCellValueFactory(cellData -> cellData.getValue().studentIdProperty());
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        // Load students
        loadStudents();
    }

    @FXML
    private void addStudent() {
        String studentId = idField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        Student student = new Student(studentId, firstName, lastName, email, phone);
        registrationSystem.addStudent(student);
        clearFields();
        loadStudents();
    }

    @FXML
    private void deleteStudent() {
        Student selectedStudent = studentTable.getSelectionModel().getSelectedItem();
        if (selectedStudent != null) {
            registrationSystem.deleteStudent(selectedStudent);
            loadStudents();
        } else {
            // Show error message
        }
    }

    private void loadStudents() {
        studentTable.setItems(registrationSystem.getAllStudents());
    }

    private void clearFields() {
        idField.clear();
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        phoneField.clear();
    }
}
