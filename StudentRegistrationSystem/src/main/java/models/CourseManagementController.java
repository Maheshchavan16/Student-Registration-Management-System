import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CourseManagementController {

    @FXML
    private TableView<Course> courseTable;

    @FXML
    private TableColumn<Course, String> courseIdColumn;

    @FXML
    private TableColumn<Course, String> courseNameColumn;

    @FXML
    private TableColumn<Course, String> instructorColumn;

    @FXML
    private TableColumn<Course, Integer> capacityColumn;

    @FXML
    private TextField courseIdField;

    @FXML
    private TextField courseNameField;

    @FXML
    private TextField instructorField;

    @FXML
    private TextField capacityField;

    private StudentRegistrationSystem registrationSystem;

    @FXML
    private void initialize() {
        registrationSystem = new StudentRegistrationSystem();
        // Initialize table columns
        courseIdColumn.setCellValueFactory(cellData -> cellData.getValue().courseIdProperty());
        courseNameColumn.setCellValueFactory(cellData -> cellData.getValue().courseNameProperty());
        instructorColumn.setCellValueFactory(cellData -> cellData.getValue().instructorProperty());
        capacityColumn.setCellValueFactory(cellData -> cellData.getValue().maxCapacityProperty().asObject());
        // Load courses
        loadCourses();
    }

    @FXML
    private void addCourse() {
        String courseId = courseIdField.getText();
        String courseName = courseNameField.getText();
        String instructor = instructorField.getText();
        int capacity = Integer.parseInt(capacityField.getText());
        Course course = new Course(courseId, courseName, instructor, capacity);
        registrationSystem.addCourse(course);
        clearFields();
        loadCourses();
    }

    @FXML
    private void deleteCourse() {
        Course selectedCourse = courseTable.getSelectionModel().getSelectedItem();
        if (selectedCourse != null) {
            registrationSystem.deleteCourse(selectedCourse);
            loadCourses();
        } else {
            // Show error message
        }
    }

    private void loadCourses() {
        courseTable.setItems(registrationSystem.getAllCourses());
    }

    private void clearFields() {
        courseIdField.clear();
        courseNameField.clear();
        instructorField.clear();
        capacityField.clear();
    }
}
