import javafx.fxml.FXML;
import javafx.scene.control.*;

public class TeacherManagementController {

    @FXML
    private TableView<Teacher> teacherTable;

    @FXML
    private TableColumn<Teacher, String> idColumn;

    @FXML
    private TableColumn<Teacher, String> firstNameColumn;

    @FXML
    private TableColumn<Teacher, String> lastNameColumn;

    @FXML
    private TableColumn<Teacher, String> emailColumn;

    @FXML
    private TableColumn<Teacher, String> phoneColumn;

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
        idColumn.setCellValueFactory(cellData -> cellData.getValue().teacherIdProperty());
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
        emailColumn.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
        phoneColumn.setCellValueFactory(cellData -> cellData.getValue().phoneProperty());
        // Load teachers
        loadTeachers();
    }

    @FXML
    private void addTeacher() {
        String teacherId = idField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String email = emailField.getText();
        String phone = phoneField.getText();
        Teacher teacher = new Teacher(teacherId, firstName, lastName, email, phone);
        registrationSystem.addTeacher(teacher);
        clearFields();
        loadTeachers();
    }

    @FXML
    private void deleteTeacher() {
        Teacher selectedTeacher = teacherTable.getSelectionModel().getSelectedItem();
        if (selectedTeacher != null) {
            registrationSystem.deleteTeacher(selectedTeacher);
            loadTeachers();
        } else {
            // Show error message
        }
    }

    private void loadTeachers() {
        teacherTable.setItems(registrationSystem.getAllTeachers());
    }

    private void clearFields() {
        idField.clear();
        firstNameField.clear();
        lastNameField.clear();
        emailField.clear();
        phoneField.clear();
    }
}
