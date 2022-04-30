package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import controller.MainController;
import controller.PaneNavigator;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Class;
import model.Course;
import model.Lecturer;
import model.Room;
import model.StudentsGroup;

public class App extends Application {

    private Stage primaryStage;
    private ObservableList<Room> RoomData = FXCollections.observableArrayList();
    private ObservableList<StudentsGroup> GroupData = FXCollections.observableArrayList();
    private ObservableList<Course> CourseData = FXCollections.observableArrayList();
    private ObservableList<Lecturer> LecturersData = FXCollections.observableArrayList();
    private ObservableList<Class> ClassData = FXCollections.observableArrayList();
    private HashMap<String,Boolean> workingDays = new HashMap<>();
    private ObservableList<Class> generatedTableData = FXCollections.observableArrayList();
    private int periodsCount = 5;

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        initialize();
        primaryStage.setTitle("Time Table Generator");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("file:resources/images/logo.png"));
        primaryStage.setScene(createScene(loadMainPane()));
        primaryStage.show();
    }

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void initialize(){
        System.out.println("init");
        Room PART2LAB = new Room("PART2LAB");
        Room FD56 = new Room("FD56");
        Room FD99 = new Room("FD99");
        Room FD60 = new Room("FD60");
        Room SLT01 = new Room("SLT01");
        Room GD40 = new Room("GD40");
        Room GD90 = new Room("GD90");
        Room FD100 = new Room("FD100");
        RoomData.addAll(PART2LAB,FD56,FD99,FD60,GD90,FD100);

        StudentsGroup firstYear = new StudentsGroup("First Year");
        StudentsGroup secondYear = new StudentsGroup("Second Year");
        StudentsGroup fourthYear = new StudentsGroup("Fourth Year");
        GroupData.addAll(firstYear,secondYear,fourthYear);
        //Compscience part1
        Course firstSCS1202 = new Course("Database Concepts ","SCS1202");
        Course firstSCS1204 = new Course("Design and Switching Circuits","SCS1204");
        Course firstSCS1205 = new Course("Software Engineeering Concepts ","SCS1205");
        Course firstSCS1206 = new Course("Visual Programming Concepts and Development ","SCS1206");
        Course firstSCS1207 = new Course("Structured Program Design ","SCS1207");
        Course firstPLC1201 = new Course("Peace, Leadership and Transformation","PLC1201");
        //Informatics part1
        Course firstSCI1201 = new Course("Business Information Systems and Applications","SCI1201");
        Course firstSCI1202 = new Course("Data Mining and Warehousing","SCI1202");
        Course firstSCI1203 = new Course("Data Visualisation and Reporting","SCI1203");
        Course firstSCI1206 = new Course("Visual Programming Concepts and Development","SCI1206");
        Course firstSORS1201 = new Course("Applied Statistics and Numerical Methods","SORS1201");
        Course firstCTL1101 = new Course("Conflict, Transformation and Leadership","CTL1101");
        //Compscience part2
        Course secondSCS2201 = new Course("Software Design Methodologies","SCS2201");
        Course secondSCS2203 = new Course("Advanced Mathematical Structures for Computing","SCS2203");
        Course secondSCS2204 = new Course("Internet and Web Design","SCS2204");
        Course secondSCS2206 = new Course("Computing in Society","SCS2206");
        Course secondSCS2207 = new Course("Computer Networks and Applications","SCS2207");
        Course secondSCS2209 = new Course("Computer Modelling","SCS2209");
        //Informatics part2
        Course secondSCI2202 = new Course("Parallel and Distributed Processing","SCI2202");
        Course secondSCI2201 = new Course("Decision Support Systems","SCI2201");
        Course secondSCI2203 = new Course("Expert Systems","SCI2203");
        Course secondSCI2204 = new Course("Information Security and Auditing","SCI2204");
        Course secondSBB2215 = new Course("BioInformatics","SBB2215");
        //Compscience part4
        Course fourthSCS4207 = new Course("Expert and Decision Support System ","SCS4207");
        Course fourthSCS4203 = new Course("Computer Graphics","SCS4203");
        Course fourthSCS4201 = new Course("Database Design & Management","SCS4201");
        Course fourthSCS4208 = new Course("Distributed Computing","SCS4208");
        Course fourthSCS4200 = new Course("Project","SCS4200");
        //Informatics Part4
        Course fourthSCI4202 = new Course("Health Informatics II","SCI4202");
        Course fourthSCI4203 = new Course("Policy Informatics II","SCI4203");
        Course fourthSCI4201 = new Course("Digital Forencics","SCI4201");
        Course fourthSCI4204 = new Course("Geo-Informatics II","SCI4204");
        Course fourthSCI4205 = new Course("Mobile and Pervasive Computing II","SCI4205");
        Course fourthSCI4200 = new Course("Project","SCI4200");

        CourseData.addAll( firstSCS1202, firstSCS1205, firstSCS1204, firstSCS1206, firstSCS1207, firstPLC1201,firstSCI1201,firstSCI1202,firstSCI1203,firstSCI1206,firstSORS1201,firstCTL1101,secondSCS2201,secondSCS2203,secondSCS2204,secondSCS2206,secondSCS2207,secondSCS2209,secondSCI2201,secondSCI2202,secondSCI2203,secondSCI2204,secondSBB2215,fourthSCS4207,fourthSCS4201,fourthSCS4208,fourthSCS4200,fourthSCS4203,fourthSCI4201,fourthSCI4202,fourthSCI4203,fourthSCI4204,fourthSCI4205,fourthSCI4200);

        Lecturer MrKMzelikahle = new Lecturer("Mr K Mzelikahle");
        Lecturer MrKChilumani = new Lecturer("Mr K Chilumani");
        Lecturer MrsSDube = new Lecturer("Mrs S Dube");
        Lecturer MrsSSDube = new Lecturer("Mrs SS Dube");
        Lecturer MrsSMoyo = new Lecturer("Mrs S Moyo");
        Lecturer MrTNyathi = new Lecturer("Mr T Nyathi");
        Lecturer MrKSibanda = new Lecturer("Mrs K Sibanda");
        Lecturer MrDMusundire = new Lecturer("Mr D Musundire");
        Lecturer MrSNgwenya = new Lecturer("Mr S Ngwenya");
        Lecturer DrSNleya = new Lecturer("Dr S Nleya");
        Lecturer MrMakwanise = new Lecturer("Mr Makwanise");
        Lecturer Supervisor = new Lecturer("Supervisor");
        Lecturer MrJMbanga = new Lecturer("Mr J Mbanga");
        LecturersData.addAll(MrKMzelikahle,DrSNleya,MrKChilumani,MrsSDube,MrTNyathi,MrDMusundire,MrSNgwenya,MrsSSDube,MrsSMoyo,MrKSibanda,Supervisor);
        
        //Compscience part1
        Class database1 = new Class(firstSCS1202,"Lec",MrsSDube,firstYear,FD99);
        Class circuits = new Class(firstSCS1204,"Lec",MrKMzelikahle,firstYear,GD40);
        Class softEngines = new Class(firstSCS1205,"Lec",MrKSibanda,firstYear,GD40);
        Class vb = new Class(firstSCS1206,"Lec",MrKChilumani,firstYear,SLT01);
        Class structured = new Class(firstSCS1207,"Lec",MrSNgwenya,firstYear,GD90);
        Class plc = new Class(firstPLC1201,"Lec",MrMakwanise,firstYear,GD90);
        //Infomatics part1
        Class businessInfo = new Class(firstSCI1201,"Lec",MrsSSDube,firstYear,FD100);
        Class DataMining = new Class(firstSCI1203,"Lec",MrDMusundire,firstYear,FD100);
        Class DataVis = new Class(firstSCI1206,"Lec",DrSNleya,firstYear,FD100);
        Class Stats = new Class(firstSORS1201,"Lec",MrSNgwenya,firstYear,FD100);
        Class Conflict = new Class(firstCTL1101,"Lec",MrMakwanise,firstYear,FD100);
        //Compscience part2
        Class DesignMeth = new Class(secondSCS2201,"Lec",MrsSSDube,secondYear,PART2LAB);
        Class Maths = new Class(secondSCS2203,"Lec",MrSNgwenya,secondYear,PART2LAB);
        Class CompSociety = new Class(secondSCS2206,"Lec",MrsSMoyo,secondYear,PART2LAB);
        Class Networks = new Class(secondSCS2207,"Lec",MrKSibanda,secondYear,PART2LAB);
        Class Modelling = new Class(secondSCS2209,"Lec",DrSNleya,secondYear,PART2LAB);
        Class InternetWeb = new Class(secondSCS2204,"Lec",MrsSDube,secondYear,PART2LAB);
        //Informatics part 2
        Class parallel = new Class(secondSCI2202,"Lec",MrTNyathi,secondYear,FD60);
        Class decision = new Class(secondSCS2201,"Lec",DrSNleya,secondYear,FD99);
        Class expert1 = new Class(secondSCS2203,"Lec",MrKMzelikahle,secondYear,FD60);
        Class InfoSec = new Class(secondSCS2204,"Lec",MrDMusundire,secondYear,FD99);
        Class BioInfo = new Class(secondSBB2215,"Lec",MrJMbanga,secondYear,FD60);
        //compscience part4
        Class CompGraphics = new Class(fourthSCS4203,"Lec",MrKChilumani,fourthYear,FD99);
        Class Database2 = new Class(fourthSCS4201,"Lec",MrsSDube,fourthYear,FD99);
        Class Distributed = new Class(fourthSCS4208,"Lec",MrTNyathi,fourthYear,FD99);
        Class projectComp = new Class(fourthSCS4200,"Lec",Supervisor,fourthYear,FD99);
        Class Expert2 = new Class(fourthSCS4203,"Lec",MrKMzelikahle,fourthYear,FD99);

        //Informatics part4
        Class forencics = new Class(fourthSCI4201,"Lec",MrDMusundire,fourthYear,FD99);
        Class policy = new Class(fourthSCI4203,"Lec",MrDMusundire,fourthYear,FD56);
        Class healthyInfo = new Class(fourthSCI4202,"Lec",MrKSibanda,fourthYear,FD56);
        Class GeoInfo = new Class(fourthSCI4204,"Lec",MrSNgwenya,fourthYear,FD56);
        Class Mobile = new Class(fourthSCI4205,"Lec",MrKChilumani,fourthYear,FD56);
        Class projectInfo = new Class(fourthSCS4200,"Lec",Supervisor,fourthYear,FD56);


        ClassData.addAll(database1,DataMining,DataVis,DesignMeth,Maths,parallel,decision,expert1,InfoSec,BioInfo,CompSociety,Networks,InternetWeb,Modelling,Stats,Conflict,businessInfo,circuits,softEngines,vb,structured,plc,CompGraphics,Database2,Distributed,projectComp,projectInfo,Expert2,forencics,policy,healthyInfo,Mobile,GeoInfo);

        
        workingDays.put("monday",true);
        workingDays.put("tuesday",true);
        workingDays.put("wednesday",true);
        workingDays.put("thursday",false);
        workingDays.put("friday",true);
        workingDays.put("saturday",true);
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader(new URL("file:resources/fxml/" + PaneNavigator.MAIN_PANE));
        //loader.setLocation(new URL("file:resources/fxml/" + PaneNavigator.MAIN_PANE));
        //Pane mainPane = loader.load();
        Pane mainPane = loader.load();
        MainController mainController = loader.getController();
        PaneNavigator.setMainApp(this);
        PaneNavigator.setMainController(mainController);
        PaneNavigator.loadPane(PaneNavigator.START_PANE);

        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);
        //new URL("file:resources/style/tab.css")
        File f = new File("resources/style/tab.css");
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        //scene.getStylesheets().add(this.getClass().getResource("/resources/style/tab.css").toExternalForm());
        f = new File("resources/style/style.css");
        scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));
        return scene;
    }


    public static void main(String[] args) {
        launch();
    }

    public ObservableList<Room> getRoomData() {
        return RoomData;
    }

    public ObservableList<StudentsGroup> getGroupData() {
        return GroupData;
    }

    public ObservableList<Course> getCourseData() {
        return CourseData;
    }

    public ObservableList<Lecturer> getLecturersData() {
        return LecturersData;
    }

    public ObservableList<Class> getClassData() {
        return ClassData;
    }

    public HashMap<String,Boolean> getWorkingDays() {
        return workingDays;
    }

    public int getPeriodsCount() {
        return periodsCount;
    }

    public void setPeriodsCount(int periodsCount) {
        this.periodsCount = periodsCount;
    }

    public ObservableList<Class> getGeneratedTableData() {
        return generatedTableData;
    }

    public void setGeneratedTableData(ArrayList<Class> generatedtable){
        generatedTableData.clear();
        generatedTableData.addAll(generatedtable);
    }
}
