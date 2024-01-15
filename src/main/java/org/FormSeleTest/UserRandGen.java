package org.FormSeleTest;
import java.util.Random;

public class UserRandGen {

    public static String FnameGen(int gender){
    // Arrays of random A to Z feminine and masculine names
        String[] maleNames = {
                "Alexander", "Benjamin", "Charles", "David", "Ethan",
                "Felix", "George", "Henry", "Isaac", "James",
                "Kevin", "Liam", "Michael", "Nathan", "Oliver",
                "Patrick", "Quentin", "Ryan", "Samuel", "Thomas",
                "Ulysses", "Vincent", "William", "Xavier", "Yusuf", "Zachary"
        };

        String[] femaleNames = {
                "Amelia", "Bella", "Charlotte", "Diana", "Emily",
                "Fiona", "Grace", "Hannah", "Isabella", "Julia",
                "Katherine", "Lily", "Mia", "Nora", "Olivia",
                "Penelope", "Quinn", "Rachel", "Sophia", "Tara",
                "Uma", "Victoria", "Wendy", "Xena", "Yasmin", "Zoe"
        };

        Random rand = new Random();
        // Expect an int from genderCalc, based on this pick random index from either array and return
        if (gender == 0) {
            return maleNames[rand.nextInt(27)];
        } else if (gender == 1) {
            return femaleNames[rand.nextInt(27)];
        } else {
            // If they choose not to say then flip a coin and pick feminine or masculine at random
            if (rand.nextInt(2) == 0){
                return maleNames[rand.nextInt(27)];
            } else {
                return femaleNames[rand.nextInt(27)];
            }
        }
    }

    public static String LnameGen(){
        // Same as above just far less involved
        String[] surnames = {
                "Anderson", "Brown", "Clark", "Davis", "Evans",
                "Fisher", "Garcia", "Harris", "Ivanov", "Johnson",
                "King", "Lee", "Miller", "Nelson", "O'Connor",
                "Parker", "Quinn", "Robinson", "Smith", "Taylor",
                "Underwood", "Vasquez", "Williams", "Xu", "Young", "Zimmerman"
        };

        Random rand = new Random();
        //Pick a random index, return it.
        return surnames[rand.nextInt(27)];
    }

    public static String jobGen(){
        String[] jobs = {
                "Accountant", "Biologist", "Chef", "Dentist", "Engineer",
                "Farmer", "Graphic Designer", "Historian", "Interior Designer", "Journalist",
                "Kindergarten Teacher", "Lawyer", "Musician", "Nurse", "Optometrist",
                "Photographer", "Quantity Surveyor", "Researcher", "Software Developer", "Teacher",
                "Urban Planner", "Veterinarian", "Web Developer", "X-Ray Technician", "Yoga Instructor",
                "Zoologist", "Architect", "Banker", "Consultant", "Doctor"
        };

        Random rand = new Random();
        //Pick a random index, return it.
        return jobs[rand.nextInt(31)];
    }

    public static int genderAssigner(){
        Random rand = new Random();

        return rand.nextInt(3);

    }

    public static int educationCalc(){
        Random rand = new Random();

        return rand.nextInt(3);
    }

    public static int dayAssigner(){
        Random rand = new Random();

        return rand.nextInt(1, 28);
    }

    public static int monthAssigner(){
        Random rand = new Random();

        return rand.nextInt(1, 13);
    }

    public static int yearAssigner(){
        Random rand = new Random();

        return rand.nextInt(1980, 2005);
    }

    public static int expAssigner(){
        Random rand = new Random();

        return rand.nextInt(11);
    }

}
