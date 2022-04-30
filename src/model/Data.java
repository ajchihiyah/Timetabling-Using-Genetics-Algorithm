package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    public static StudentsGroup[] studentsGroups;
    public static Lecturer[] lecturers;
    public static Room[] rooms;
    public static Course[] courses;
    public static int periodsPerDay;
    public static int daysPerWeek;
    public static ArrayList<String> workingDays = new ArrayList<>();
    public static Class[] classes;

    public static void setWorkingDays(HashMap<String,Boolean> daysMap){
        workingDays.clear();
        if(daysMap.get("monday")){
            workingDays.add("Monday");
        }
        if(daysMap.get("tuesday")){
            workingDays.add("Tuesday");
        }
        if(daysMap.get("wednesday")){
            workingDays.add("Wednesday");
        }
        if(daysMap.get("thursday")){
            workingDays.add("Thursday");
        }
        if(daysMap.get("friday")){
            workingDays.add("Friday");
        }
        if(daysMap.get("saturday")){
            workingDays.add("Saturday");
        }
    }

    public static void setClasses(Class[] classes) {
        Data.classes = classes;
    }

    public static void setCourses(Course[] courses) {
        Data.courses = courses;
    }

    public static void setDaysPerWeek(int daysPerWeek) {
        Data.daysPerWeek = daysPerWeek;
    }

    public static void setLecturers(Lecturer[] lecturers) {
        Data.lecturers = lecturers;
    }

    public static void setPeriodsPerDay(int periodsPerDay) {
        Data.periodsPerDay = periodsPerDay;
    }

    public static void setRooms(Room[] rooms) {
        Data.rooms = rooms;
    }

    public static void setStudentsGroups(StudentsGroup[] studentsGroups) {
        Data.studentsGroups = studentsGroups;
    }

    public static Class getClassByID(int id){
        for (Class cls : classes){
            if(cls.getID() == id){
                return cls;
            }
        }
        return new Class(-1);
    }

    public static Room getRoomByID(int id){
        for (Room room : rooms){
            if(room.getID() == id){
                return room;
            }
        }
        return null;
    }	
}
