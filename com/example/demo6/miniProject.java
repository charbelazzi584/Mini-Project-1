package com.example.demo6;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import java.time.LocalDate;


public class miniProject extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public static class Employee {
        private final StringProperty name;
        private final StringProperty dob;
        private final StringProperty gender;
        private final StringProperty position;
        private final StringProperty address;
        private final StringProperty salary;
        private final StringProperty maritalStatus;

        public Employee(String name, String dob, String gender, String position,
                        String address, String salary, String maritalStatus) {
            this.name = new SimpleStringProperty(name);
            this.dob = new SimpleStringProperty(dob);
            this.gender = new SimpleStringProperty(gender);
            this.position = new SimpleStringProperty(position);
            this.address = new SimpleStringProperty(address);
            this.salary = new SimpleStringProperty(salary);
            this.maritalStatus = new SimpleStringProperty(maritalStatus);

        }


        public String getName() { return name.get(); }
        public String getDob() { return dob.get(); }
        public String getGender() { return gender.get(); }
        public String getPosition() { return position.get(); }
        public String getAddress() { return address.get(); }
        public String getSalary() { return salary.get(); }
        public String getMaritalStatus() { return maritalStatus.get(); }

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Employee Management System");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);
        Label employeeName = new Label("Employee Name:");
        grid.add(employeeName, 0, 1);
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);
        TextField userText = new TextField();
        grid.add(userText, 1, 1);
        PasswordField pF = new PasswordField();
        grid.add(pF, 1, 2);
        Button LogIn = new Button("Log In");
        grid.add(LogIn, 1, 4);
        Text remark = new Text("You must know the password if you're one of us");
        grid.add(remark, 1, 5, 2, 1);
        Text errorMessage = new Text();
        errorMessage.setFill(Color.RED);
        grid.add(errorMessage, 1, 7, 2, 1);

        Button newSceneButton = new Button("VERIFIED");
        StackPane newScenePane = new StackPane();
        newScenePane.getChildren().add(newSceneButton);
        Scene newScene = new Scene(newScenePane, 400, 300);

        LogIn.setOnAction(evt -> {
            String key = pF.getText();
            if (key.isEmpty()) {
                errorMessage.setText("you must enter the Password");
            } else if (!key.equals("bargainer")) {
                errorMessage.setText("this isn't our company's code");
            } else {
                primaryStage.setScene(newScene);
            }

        });

        primaryStage.setScene(new Scene(grid, 400, 300));
        primaryStage.show();




        newSceneButton.setOnAction(evt -> {

            GridPane grid2= new GridPane();
            grid2.setHgap(10);
            grid2.setVgap(10);

            


            Text employeeInfo = new Text("Welcome to the Employee Management Information");
            employeeInfo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 15));
            grid2.add(employeeInfo, 0, 0, 2, 1);

            Label userNameLbl = new Label("Employee Name:");
            grid2.add(userNameLbl, 0, 1);
            TextField userFld = new TextField();
            userFld.setPromptText("Enter your name");
            grid2.add(userFld, 1, 1);

            Label dobLbl = new Label("Date of Birth:");
            grid2.add(dobLbl, 0, 2);

            DatePicker dobPck = new DatePicker();
            dobPck.setValue(LocalDate.now());
            grid2.add(dobPck, 1, 2);

            Label genderLbl = new Label("Gender:");
            grid2.add(genderLbl, 0, 3);

            RadioButton radioButton1 = new RadioButton("Male");
            radioButton1.setSelected(true);
            RadioButton radioButton2 = new RadioButton("Female");
            ToggleGroup radioGroup = new ToggleGroup();
            radioButton1.setToggleGroup(radioGroup);
            radioButton2.setToggleGroup(radioGroup);
            HBox radioBox = new HBox(radioButton1, radioButton2);
            radioBox.setSpacing(25);
            grid2.add(radioBox, 1, 3);

            Label degreeLbl = new Label("Position:");
            grid2.add(degreeLbl, 0, 4);

            ChoiceBox<String> choiceBox = new ChoiceBox<>();
            choiceBox.getItems().add("Human Resources Manager ");
            choiceBox.getItems().add("Marketing Manager");
            choiceBox.getItems().add("Chief Executive Officer");
            choiceBox.getItems().add("Product Manager");
            choiceBox.getItems().add("Accountant");
            choiceBox.getItems().add("Sales Manager");
            choiceBox.getSelectionModel().selectFirst();
            grid2.add(choiceBox, 1, 4);

            Label salaryLbl = new Label("Salary:");
            grid2.add(salaryLbl, 0, 5);
            TextField salFld = new TextField();
            salFld.setPromptText("Enter your salary");
            grid2.add(salFld, 1, 5);

            Label StatusLbl = new Label("Marital Status: ");
            grid2.add(StatusLbl, 0, 6);

            RadioButton Button1 = new RadioButton("Single");
            radioButton1.setSelected(true);
            RadioButton Button2 = new RadioButton("Married");
            RadioButton Button3 = new RadioButton("Widow");
            RadioButton Button4 = new RadioButton("Widower");
            ToggleGroup radioGroup1 = new ToggleGroup();
            Button1.setToggleGroup(radioGroup1);
            Button2.setToggleGroup(radioGroup1);
            Button3.setToggleGroup(radioGroup1);
            Button4.setToggleGroup(radioGroup1);
            HBox radioBox1 = new HBox(25);
            radioBox1.getChildren().addAll(Button1, Button2, Button3, Button4);
            grid2.add(radioBox1, 1, 6);





            Label addLbl = new Label("Address:");
            grid2.add(addLbl, 0, 7);

            TextField addrFld = new TextField();
            addrFld.setPromptText("Enter your current address");
            grid2.add(addrFld, 1, 7);



            Button submitBtn = new Button("Submit");
            Text errorMsg = new Text();
            errorMsg.setFill(Color.RED);
            VBox vbox1 = new VBox(submitBtn, errorMsg);
            vbox1.setAlignment(Pos.CENTER);
            grid2.add(vbox1, 1, 8);

            grid2.setPadding(new Insets(10, 0, 10, 20));




            Scene employeeScene = new Scene(grid2, 500, 450);
            Stage employeeStage = new Stage();
            employeeStage.setScene(employeeScene);
            employeeStage.setResizable(false);
            employeeStage.show();

            TableView<Employee> table = new TableView<>();


            TableColumn<Employee, String> nameCol = new TableColumn<>("Name");
            nameCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getName()));

            TableColumn<Employee, String> dobCol = new TableColumn<>("Date of Birth");
            dobCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getDob()));

            TableColumn<Employee, String> genderCol = new TableColumn<>("Gender");
            genderCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGender()));

            TableColumn<Employee, String> positionCol = new TableColumn<>("Position");
            positionCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getPosition()));

            TableColumn<Employee, String> addressCol = new TableColumn<>("Address");
            addressCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAddress()));

            TableColumn<Employee, String> salaryCol = new TableColumn<>("Salary");
            salaryCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getSalary()));

            TableColumn<Employee, String> maritalStatusCol = new TableColumn<>("Marital Status");
            maritalStatusCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getMaritalStatus()));


            table.getColumns().addAll(nameCol, dobCol, genderCol, positionCol, addressCol, salaryCol, maritalStatusCol);


            ObservableList<Employee> data = FXCollections.observableArrayList();
            table.setItems(data);



            submitBtn.setOnAction(innerEvent  ->{

                String name = userFld.getText();
                String dob = dobPck.getValue().toString();
                String gender = ((RadioButton) radioGroup.getSelectedToggle()).getText();
                String position = choiceBox.getValue();
                String address = addrFld.getText();
                String salary = salFld.getText();
                String maritalStatus = ((RadioButton) radioGroup1.getSelectedToggle()).getText();

                if (!name.isEmpty() && !dob.isEmpty() && !gender.isEmpty() &&
                        !position.isEmpty() && !address.isEmpty() &&
                        !salary.isEmpty() && !maritalStatus.isEmpty()) {

                    data.add(new Employee(name, dob, gender, position, address, salary, maritalStatus));


                    userFld.setText("");
                    dobPck.setValue(LocalDate.now());
                    radioButton1.setSelected(true);
                    choiceBox.getSelectionModel().selectFirst();
                    addrFld.setText("");
                    salFld.setText("");
                    Button1.setSelected(true);

                    VBox vbox = new VBox(25);
                    vbox.setPadding(new Insets(25));
                    vbox.getChildren().addAll(table);
                    Scene scene = new Scene(vbox, 600, 600);

                    primaryStage.setScene(scene);
                    primaryStage.show();

                } else {
                    errorMsg.setText("Please fill in all the required fields.");
                }

            });
        })
        ;}}
