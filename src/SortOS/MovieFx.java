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

import java.util.*;

public class MovieFx extends Application {
	private TextField txtMatricula, txtName, txtCalif, txtYear, txtClassification;
	private ObservableList data;
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
		lvAlumno.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				display();
			}
		});
		contentPane.getChildren().add(lvAlumno);
		
		//Controls
		Button bttnAdd = new Button("Add");
		controlsPane.getChildren().add(bttnAdd);
		
		Button bttnDelete = new Button("Delete");
		controlsPane.getChildren().add(bttnDelete);

		Button bttnSort= new Button("Sort");
		controlsPane.getChildren().add(bttnSort);

		ComboBox<String> myComboBox = new ComboBox<String>();
		myComboBox.getItems().addAll("Bogosort","QuickSort","MergeSort");
		myComboBox.setValue("QuickSort");
		controlsPane.getChildren().add(myComboBox);

		bttnSort.addEventFilter(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				String sortType= myComboBox.getValue();
				sort(sortType);
			}
		});

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
		//2. Create the main scene and link it with the stage
		Scene scene = new Scene(mainPane);
		stage.setScene(scene);
		stage.setWidth(700);
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
    }
    private void deleteStudent(){
        // Obtain selected item
        Alumno a= lvAlumno.getSelectionModel().getSelectedItem();
        // Remove it from the data
        data.remove(a);
        clearFields();
    }
    private <T extends Comparable<T>> void sort(String sortType) {
		System.out.println(Arrays.deepToString(data.toArray()));
		ListaLigada<Alumno> ll= new ListaLigada<>();

		Nodo<Alumno> primero= new Nodo<>((Alumno)data.get(0));
		ll.setInicial(primero);
		for (int i=1; i<=data.size()-1; i++){
			ll.insertarAlUltimo((Alumno) data.get(i));
		}
		ll.imprimeLista();

		switch (sortType){
			case "Bogosort":
				System.out.println("NA");
				Alert alert = new Alert(Alert.AlertType.INFORMATION);
				alert.setTitle("Tercer Parcial");
				alert.setHeaderText("Operación no disponible");
				alert.setContentText("Función disponible en la versión de paga");
				alert.showAndWait();
				break;
			case "QuickSort":
				//sorting.quickSort(ll,0,ll.contarElementos()-1);
				ll.quickSort();
				ll.imprimeLista();
				break;
			case "MergeSort":
			    Alert alertM = new Alert(Alert.AlertType.INFORMATION);
			    alertM.setTitle("Tercer Parcial");
			    alertM.setHeaderText("Operación no disponible");
			    alertM.setContentText("Función disponible en la versión de paga");
			    alertM.showAndWait();
				break;
		}
		System.out.println("MOVE IT");
		ll.imprimeLista();
		data.clear();
		data.setAll(FXCollections.observableArrayList(ll.toArrayList()));


	}

	private void display(){
		Alumno a= lvAlumno.getSelectionModel().getSelectedItem();
		txtName.setText(a.getNombre());
		txtMatricula.setText(a.getMatricula());
		txtCalif.setText(Integer.toString(a.getCalif()));
	}
    private void clearFields(){
        //Clear the form
        txtName.setText("");
        txtCalif.setText("");
        txtMatricula.setText("");

    }
}

/*
*
* public void mergeSort(){
		inicial=mergeSortInterno(inicial);
	}

	private Nodo<T> mergeSortInterno(Nodo<T> inicial) {
		Nodo<T> inicioAnterior= inicial;
		int mid= contarElementos(inicial)/2;
		System.out.println("Contar elementos: "+mid+" "+inicial.getElemento());
		if(inicial.getSiguiente()==null) {
			return inicial;
		}

		while(mid-1>0) {
			inicioAnterior=inicioAnterior.getSiguiente();
			mid--;
		}
		Nodo<T> nuevoInicio=inicioAnterior.getSiguiente();
		inicioAnterior.setSiguiente(null);
		inicioAnterior=inicial;
		Nodo<T> temp1= mergeSortInterno(inicioAnterior);
		Nodo<T> temp2= mergeSortInterno(nuevoInicio);
		return merge(temp1,temp2);
	}

	public Nodo<T> merge(Nodo<T> a, Nodo<T> b){
		Nodo<T> resultado;
		if (a==null)
			return b;
		if(b==null)
			return a;
		if(a.getElemento().compareTo(b.getElemento())>0) {
			resultado=b;
			resultado.setSiguiente(merge(a,b.getSiguiente()));
		}else {
			resultado=a;
			resultado.setSiguiente(merge(a.getSiguiente(),b));
		}
		return resultado;
	}
* */