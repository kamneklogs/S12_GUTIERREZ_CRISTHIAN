package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Department;

public class Main extends Application {
	private DepartmentGUI dgui1;
	private Department dept;

	public Main() {
		dept = new Department();
		dgui1 = new DepartmentGUI(dept);
	}

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));

		fxmlLoader.setController(dgui1);

		Parent root = fxmlLoader.load();

		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Course Registration");
		primaryStage.show();
	}

}
