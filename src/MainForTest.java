import model.Class;
import model.Course;
import model.Data;
import model.Generator;
import model.Lecturer;
import model.Room;
import model.StudentsGroup;
import model.Utilities;

public class MainForTest {

    public static void main(String[] args) {

        int populationSize = 10;
        int maxGenerations = 10000;
        double mutationRate = 0.5;

        Course course0 = new Course("DATABASE DESIGN AND MANAGEMENT","4201");
        Course course1 = new Course("COMPUTER GRAPHICS","4203");
        Course course2 = new Course("DISTRIBUTED COMPUTING","4208");

        Lecturer lecturer0 = new Lecturer("MRS S DUBE");
        Lecturer lecturer1 = new Lecturer("MR K CHILUMANI");
        Lecturer lecturer2 = new Lecturer("MR T NYATHI");

        Room room0 = new Room("FD55");
        Room room1 = new Room("HALL1");
       /* Room room2 = new Room("PART2LAB");
        Room room3 = new Room("FD99 LAB");
        Room room4 = new Room("GD85");
        Room room5 = new Room("FD56 LAB");
        Room room6 = new Room("FD65 LAB");
        Room room7 = new Room("202");
        Room room8 = new Room("203");
        Room room9 = new Room("202");
        Room room10 = new Room("203");
        Room room11 = new Room("203");*/


        StudentsGroup studentsGroup0 = new StudentsGroup("SCS");
        StudentsGroup studentsGroup1 = new StudentsGroup("SCS");
        StudentsGroup studentsGroup2 = new StudentsGroup("SCI");

        Class c0 = new Class(course0,"Lec",lecturer0,studentsGroup0,room0);
        Class c1 = new Class(course1,"Lec",lecturer0,studentsGroup0,room0);
        Class c2 = new Class(course2,"Lec",lecturer0,studentsGroup0,room0);
        Class c3 = new Class(course0,"Lec",lecturer0,studentsGroup0,room0);
        Class c4 = new Class(course2,"Lec",lecturer0,studentsGroup0,room0);
        Class c5 = new Class(course2,"Lec",lecturer0,studentsGroup0,room0);
        Class c6 = new Class(course0,"Lec",lecturer1,studentsGroup1,room1);
        Class c7 = new Class(course1,"Lec",lecturer1,studentsGroup1,room1);
        Class c8 = new Class(course2,"Lec",lecturer1,studentsGroup1,room1);
        Class c9 = new Class(course0,"Lec",lecturer1,studentsGroup1,room1);
        Class c10 = new Class(course2,"Lec",lecturer1,studentsGroup1,room1);
        //Class c11 = new Class(course2,"Lec",lecturer1,studentsGroup1,room1);

        Data.setCourses(new Course[]{course0,course1,course2});
        Data.setDaysPerWeek(6);
        Data.setPeriodsPerDay(6);
        Data.setLecturers(new Lecturer[]{lecturer0,lecturer1,lecturer2});
        Data.setRooms(new Room[]{room0,room1/*,room2,room3,room4,room5,room6,room7,room8,room9,room10,room11*/});
        Data.setStudentsGroups(new StudentsGroup[]{studentsGroup0,studentsGroup1,studentsGroup2});
        Data.setClasses(new Class[]{c0,c1,c2,c3,c4,c5,c6,c7,c8,c9,c10/*,c11*/});

        Generator gen = Generator.getInstance();
        gen.initializePopulation(populationSize);

        gen.getPopulation().calculateAllFitness();

        Utilities.printPopulation(gen.getPopulation());
        int generationCount = 0;
        System.out.println("Generation: " + generationCount + " averageFitness: "
                + gen.getPopulation().getAverageFitness()+" Fittest: " + gen.getPopulation().getFittestScore()+ "\n");

        while (gen.getPopulation().getFittestScore() < 1 && generationCount < maxGenerations) {
            generationCount++;
            //Do selection
            gen.selection();
            //Do crossover
            gen.crossover();
            //Do mutation under a random probability
            gen.mutation(mutationRate);
            //Add fittest offspring to population
            gen.addOffSpring();
            //Calculate new fitness value
            gen.getPopulation().calculateAllFitness();
            //Utilities.printPopulation(gen.getPopulation());
            System.out.println("Generation: " + generationCount + " averageFitness: "
                    + gen.getPopulation().getAverageFitness()+" Fittest: " + gen.getPopulation().getFittestScore());
        }



    }
}
