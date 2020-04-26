package ui;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.*;

public class DepartmentGUI {

	private Department dept;

	@FXML
	private Pane mainPane;

	private String name;
	private int credits;
	private String newCurriculum;
	private String[] evaluation;
	private String startDate;

	@FXML
	private GridPane formPane;

	@FXML
	private TextField couseNameTextField;

	@FXML
	private DatePicker startDateDatePicker;

	@FXML
	private ToggleGroup curriculum;

	@FXML
	private CheckBox writeExamCB;

	@FXML
	private CheckBox practicalTestCB;

	@FXML
	private CheckBox labCB;

	@FXML
	private CheckBox courseProjectCB;

	@FXML
	private TextField creditsNumber;

	@FXML
	private RadioButton coreRB;

	@FXML
	private RadioButton specificRB;

	@FXML
	private TableView<Course> tvCoursesList;

	@FXML
	private TableColumn<Course, String> tcName;

	@FXML
	private TableColumn<Course, String> tcCredits;

	@FXML
	private TableColumn<Course, String> tcCurriculum;

	@FXML
	private TableColumn<Course, String> tcEvaluation;

	@FXML
	private TableColumn<Course, String> tcStartDate;

	@FXML
	void coreCurriculum(ActionEvent event) {

		newCurriculum = "Core";

	}

	@FXML
	void numbersCredit1(ActionEvent event) {

		creditsNumber.setText("1");

	}

	@FXML
	void numbersCredit2(ActionEvent event) {

		creditsNumber.setText("2");

	}

	@FXML
	void numbersCredit3(ActionEvent event) {
		creditsNumber.setText("3");

	}

	@FXML
	void saveCourseButton(ActionEvent event) {

		try {

			name = couseNameTextField.getText();
			credits = Integer.parseInt(creditsNumber.getText());

			ArrayList<String> evaluations = new ArrayList<String>();
			if (writeExamCB.isSelected()) {
				evaluations.add("Write Exam");
			}
			if (practicalTestCB.isSelected()) {
				evaluations.add("Practical Test");
			}
			if (labCB.isSelected()) {
				evaluations.add("Labs");
			}
			if (courseProjectCB.isSelected()) {
				evaluations.add("Course Project");
			}

			evaluation = new String[evaluations.size()];

			for (int i = 0; i < evaluation.length; i++) {
				evaluation[i] = evaluations.get(i);
			}

			startDate = startDateDatePicker.getEditor().getText();

			if ((couseNameTextField.getText() != "" && couseNameTextField.getText() != null) && credits != 0
					&& (newCurriculum != null && newCurriculum != "") && evaluation != null && startDate != null) {
				dept.getCourses().add(new Course(name, credits, newCurriculum, evaluation, startDate));
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Course Registration");
				alert.setHeaderText("Successful");
				alert.setContentText("Course saved");

				alert.showAndWait();
				couseNameTextField.clear();
				creditsNumber.clear();
				newCurriculum = "";
				writeExamCB.setSelected(false);
				practicalTestCB.setSelected(false);
				labCB.setSelected(false);
				courseProjectCB.setSelected(false);
				startDateDatePicker.getEditor().clear();
				coreRB.setSelected(false);
				specificRB.setSelected(false);

			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Course Registration");
				alert.setHeaderText("Error");
				alert.setContentText("Some fileds are empty.\nPlease answer all of fields");

				alert.showAndWait();
			}

		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Course Registration");
			alert.setHeaderText("Error");
			alert.setContentText("Credits numbers's format is wrong");
			alert.showAndWait();
		}

	}

	@FXML
	void specificCurriculum(ActionEvent event) {

		newCurriculum = "Specific";

	}

	public DepartmentGUI(Department dept) {

		this.dept = dept;

	}

	@FXML
	void goToForm(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CourseForm.fxml"));

		fxmlLoader.setController(this);
		Parent addCourse = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(addCourse);

	}

	private void initializeTableView() {

		ObservableList<Course> observableList;
		observableList = FXCollections.observableArrayList(dept.getCourses());

		tvCoursesList.setItems(observableList);
		tcName.setCellValueFactory(new PropertyValueFactory<Course, String>("name"));

		tcCredits.setCellValueFactory(new PropertyValueFactory<Course, String>("credits"));

		tcCurriculum.setCellValueFactory(new PropertyValueFactory<Course, String>("curriculum"));

		tcEvaluation.setCellValueFactory(new PropertyValueFactory<Course, String>("evaluation"));

		tcStartDate.setCellValueFactory(new PropertyValueFactory<Course, String>("startDate"));

	}

	@FXML
	void goToCourses(ActionEvent event) throws IOException {

		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("CoursesList.fxml"));

		fxmlLoader.setController(this);
		Parent coursesList = fxmlLoader.load();

		mainPane.getChildren().clear();
		mainPane.getChildren().add(coursesList);
		initializeTableView();
	}

}