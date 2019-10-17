package SortOS;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
public class MovieFx extends Application {
	private TextField txtMatricula, txtName, txtCalif, txtYear, txtClassification;
	private ObservableList<Alumno> data;
	private ListView<Alumno> lvAlumno;

	public void start(Stage stage) throws Exception {
		//1. Create the main node
		BorderPane mainPane = new BorderPane();
		FlowPane contentPane = new FlowPane();
		FlowPane controlsPane = new FlowPane();
		mainPane.setCenter(contentPane);
		mainPane.setBottom(controlsPane);
		//Content
		GridPane infoPane = new GridPane();
		Label lblName = new Label("Nombre");
		txtName = new TextField();
		infoPane.add(lblName, 0,0);
		infoPane.add(txtName, 1,0);
		
		Label lblMatricula = new Label("Matrícula");
		txtMatricula = new TextField();
		infoPane.add(lblMatricula, 0,1);
		infoPane.add(txtMatricula, 1,1);
		
		Label lblCalif = new Label("Calificación");
		txtCalif = new TextField();
		infoPane.add(lblCalif, 0,2);
		infoPane.add(txtCalif, 1,2);

		contentPane.getChildren().add(infoPane);
		
		//List
		data = FXCollections.observableArrayList();
		lvAlumno = new ListView<>(data);
		contentPane.getChildren().add(lvAlumno);
		
		//Controls
		Button bttnAdd = new Button("Agregar");
		controlsPane.getChildren().add(bttnAdd);
		
		Button bttnDelete = new Button("Borrar");
		controlsPane.getChildren().add(bttnDelete);
		
		Button bttnSave = new Button("Actualizar");
		controlsPane.getChildren().add(bttnSave);
		
        bttnAdd.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                addStudent();
            }
        });

        bttnDelete.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                deleteStudent();
            }
        });

        lvAlumno.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
            public void handle(MouseEvent e){
                getData();
            }
        });
		//2. Create the main scene and link it with the stage
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setWidth(500);
		stage.setHeight(500);
		//3. Call the show method for the stage
		stage.show();
	}
	
	public static void main(String[] args) {
		launch();
	}
    private void addStudent(){
        //Read the info and create an object
        Alumno a = new Alumno();
        a.setNombre(txtName.getText());
        a.setMatricula(txtMatricula.getText());
        a.setCalif(Integer.parseInt(txtCalif.getText()));
        //Add the object to my list
        data.add(a);
        //Clear the form
        txtName.setText("");
        txtCalif.setText("");
        txtMatricula.setText("");
    }
    private void deleteStudent(){
        //Remove movie
        //Alumno a = lvAlumno.getSelectionModel().getSelectedItems().get(0);
        ObservableList<Integer> todelete= lvAlumno.getSelectionModel().getSelectedIndices();
        for (int i=0; i<todelete.size(); i++) {
            data.remove(todelete.get(i));
        }
    }
    private void getData(){
        Alumno a = lvAlumno.getSelectionModel().getSelectedItems().get(0);
        txtName.setText(a.getNombre());
        txtCalif.setText(Integer.toString(a.getCalif()));
        txtMatricula.setText(a.getMatricula());

    }
}
