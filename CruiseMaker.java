//this is a program to create a GUI with which to to reserve a cruise ship room
//Christopher Marcano
//AdvJava
//*******************************************************************************************************************
//adding all javafx imports the program needs (this was extremely complicated with intellij)
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
//********************************************************************************************************************************
//main class
//setting variables and throwing exceptions
public class CruiseMaker extends Application {
    public static double costShip;
    public static double costAct = 0;
    public static double costTotal = 0;
    public static double numberOfDays;
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
//******************************************************************************************************************************
//this section allows you to select one of the ships
        ToggleGroup tg = new ToggleGroup();
        Label radioLabel = new Label("Please select a ship");
        // button labels
        RadioButton r1 = new RadioButton("S.S Abstraction");
        RadioButton r2 = new RadioButton("S.S Encapsulation");
        RadioButton r3 = new RadioButton("S.S Polymorphism");
        RadioButton r4 = new RadioButton("S.S Inheritance");
        // allows selection to change with button presses (starts at r1)
        r1.setSelected(true);
        r1.setToggleGroup(tg);
        r2.setToggleGroup(tg);
        r3.setToggleGroup(tg);
        r4.setToggleGroup(tg);
        //box dimensions
        HBox hbox1 = new HBox(radioLabel, r1, r2, r3, r4);
        hbox1.setPadding(new Insets(20));
        hbox1.setSpacing(20);
//*******************************************************************************************************************************
        //allows you to import and view image on window
        FileInputStream input = new FileInputStream("abstraction.png");
        FileInputStream inputLayout = new FileInputStream("abstraction rooms.jpg");
        // image objects
        Image image = new Image(input);
        Image imageLayout = new Image(inputLayout);
        ImageView ShipImage = new ImageView(image);
        ImageView ShipLayout = new ImageView(imageLayout);
        // set dimensions
        ShipImage.setFitHeight(250);
        ShipImage.setFitWidth(300);
        ShipLayout.setFitHeight(250);
        ShipLayout.setFitWidth(300);
//*******************************************************************************************************************************
        //first selection
        r1.setOnAction(e -> {
            try {
                FileInputStream input1 = new FileInputStream("abstraction.png");
                FileInputStream inputLayout1 = new FileInputStream("abstraction rooms.jpg");
                Image image1 = new Image(input1);
                Image imageLayout1 = new Image(inputLayout1);
                ShipLayout.setImage(imageLayout1);
                ShipImage.setImage(image1);
                costShip = 2000;}
            catch (FileNotFoundException e1){
                e1.printStackTrace();}});
//*********************************************************************************************************************************
         //selection 2
        r2.setOnAction(e -> {
            try{
                FileInputStream input1 = new FileInputStream("encapsulation.jpg");
                FileInputStream inputLayout1 = new FileInputStream("encapsulation rooms.png");
                Image image1 = new Image(input1);
                Image imageLayout1 = new Image(inputLayout1);
                ShipImage.setImage(image1);
                ShipLayout.setImage(imageLayout1);
                costShip = 2000;}
            catch (FileNotFoundException e1){
                e1.printStackTrace();}});
//********************************************************************************************************************************
        //selection 3
        r3.setOnAction(e -> {
            try{
                FileInputStream input1 = new FileInputStream("polymorphism.jpg");
                FileInputStream inputLayout1 = new FileInputStream("polymorphism rooms.jpg");
                Image image1 = new Image(input1);
                Image imageLayout1 = new Image(inputLayout1);
                ShipImage.setImage(image1);
                ShipLayout.setImage(imageLayout1);
                costShip = 4000;}
            catch (FileNotFoundException e1) {
                e1.printStackTrace();}});
//******************************************************************************************************************************
        //selection 4
        r4.setOnAction(e -> {
            try{
                FileInputStream input1 = new FileInputStream("inheritance.jpg");
                FileInputStream inputLayout1 = new FileInputStream("inheritance rooms.jpg");
                Image image1 = new Image(input1);
                Image imageLayout1 = new Image(inputLayout1);
                ShipImage.setImage(image1);
                ShipLayout.setImage(imageLayout1);
                costShip = 4000;}
            catch (FileNotFoundException e1) {
                e1.printStackTrace();}});
//************************************************************************************************************************
        //set dimensions
        HBox hbox2 = new HBox(ShipImage, ShipLayout);
        hbox2.setPadding(new Insets(20));
        hbox2.setSpacing(20);
//******************************************************************************************************************************
// allows one to set departure and arrival dates
        //labels
        Label departure = new Label("Departure");
        Label arrival = new Label("Arrival");
        // implements date selectors
        DatePicker Departure = new DatePicker();
        DatePicker Arrival = new DatePicker();
        // create error message
        Label warning = new Label();
        Arrival.setOnAction(e -> {
            if (Arrival.getValue().isBefore(Departure.getValue())){
                warning.setText("Error, impossible date.");
                warning.setTextFill(Color.RED);}
            else
                numberOfDays = Arrival.getValue().getDayOfYear() - Departure.getValue().getDayOfYear();
            warning.setText("");});
//*******************************************************************************************************************************
        // add dimensions
        HBox hbox3 = new HBox(departure, Departure, arrival, Arrival, warning);
        hbox3.setPadding(new Insets(20));
        hbox3.setSpacing(20);
        // make labels
        Label activityLabel = new Label("Activities");
        // create the check boxes
        CheckBox c1 = new CheckBox("Rock limbing");
        CheckBox c2 = new CheckBox("Jet ski");
        CheckBox c3 = new CheckBox("Snorkeling");
        CheckBox c4 = new CheckBox("Diving");
        CheckBox c5 = new CheckBox("Boating");
//***********************************************************************************************************************
        // create dimensions
        HBox hbox4 = new HBox(activityLabel, c1, c2, c3, c4, c5);
        hbox4.setPadding(new Insets(20));
        hbox4.setSpacing(20);
//********************************************************************************************************************************
        // create labels for text fields
        Label name = new Label("Name: ");
        TextField nameEntry = new TextField();
        Label address = new Label("Address: ");
        TextField addressEntry = new TextField();
        Label phone = new Label("Phone-number: ");
        TextField phoneEntry = new TextField();
        Label email = new Label("Email-address: ");
        TextField emailEntry = new TextField();
        // create grid
        GridPane grid = new GridPane();
        grid.add(name, 0, 0);
        grid.add(nameEntry, 1, 0);
        grid.add(address, 0, 1);
        grid.add(addressEntry, 1, 1);
        grid.add(phone, 0, 2);
        grid.add(phoneEntry, 1, 2);
        grid.add(email, 0, 3);
        grid.add(emailEntry, 1, 3);
        // rows and columns
        grid.setVgap(10);
        grid.setHgap(20);
        grid.setPadding(new Insets(20));
//******************************************************************************************************************************
    //calculate cost
        costTotal = numberOfDays * costShip + costAct;
        Label totalVal = new Label("Total: $" + String.valueOf(costTotal));
        Button order = new Button("Reserve");
        Label reserved = new Label();
        order.setOnAction(e -> {
            // gives cost for extra activities
            if (c1.isSelected())
                costAct += 100;
            if (c2.isSelected())
                costAct += 100;
            if (c3.isSelected())
                costAct += 100;
            if (c4.isSelected())
                costAct += 100;
            if (c5.isSelected())
                costAct += 100;
            costTotal = numberOfDays * costShip + costAct;
            totalVal.setText("Total: $" + String.valueOf(costTotal));
            reserved.setText("Cruise has been reserved");
            reserved.setTextFill(Color.GREEN);});
        // create dimensions
        HBox hbox6 = new HBox(totalVal, order, reserved);
        hbox6.setPadding(new Insets(20));
        hbox6.setSpacing(20);
        VBox vfoxFinale = new VBox(hbox1, hbox2, hbox3, hbox4, grid, hbox6);
        //set title
        StackPane root = new StackPane();
        root.getChildren().add(vfoxFinale);
        Scene scene = new Scene(root, 700, 680);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Cruise Reservation");
        primaryStage.show();}}