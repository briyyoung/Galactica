package com.example.brianyoung.galactica;

public class Quiz {

    public String Questions[][] = {
            //Mercury's questions
            {"What is the orbit time for Mercury?", "What is the diameter of Mercury?", "What is the highest temperature on Mercury surface?"},
            //Venus's questions
            { "What is the orbit time for Venus?", "What is Venus’s atmosphere made of?", "What is the rotation direction of Venus?"},
            //Earth
            {"What is Earth’s atmosphere made of?","What is the orbit time for Earth?","What is the diameter of Earth?"},
            //Mars
            {"What is the nickname of Mars?","What is the orbit time for Mars?","Why does Mars have a red hue?"},
            //Jupiter
            {"How many moons are orbiting Jupiter?","What are the swirling and colorful clouds over Jupiter famously known as?","What is the orbit time of Jupiter?"},
            //Saturn
            {"What makes Saturn easily recognized?","What is the orbit time of Saturn?","What is Saturn's atmosphere mainly made of?"},
            //Uranus
            {"What is Uranus’ atmosphere mainly made of?","What chemicals made up Uranus’ clouds?","Which planet has the same rotation direction as Uranus?"},
            //Neptune
            {"How far is the approximate distance of Neptune to the Sun?","What feature that Neptune has?","How large is Neptune?"},
            //Pluto
            {"What distinguishes Pluto with other Planets?","What is Pluto known as?","What is mainly on Pluto's surface?"}
    };

    public String correctAnswers[][] = {
            //Mercury's correct answers
            {"88 earth days","4878 km","450 Celsius"},
            //Venus's correct answers
            {"225 earth days","Sulfuric acids","East to West"},
            //Earth
            {"Oxygen and Nitrogen","365.24 earth days","12,760 km"},
            //Mars
            {"Red Planet","687 earth days","Because it is covered with iron oxides"},
            //Jupiter
            {"Approximately 75 moons","The Great Red Spot","11.9 earth years"},
            //Saturn
            {"Visible Ring","29.5 earth years","Hydrogen and Helium"},
            //Uranus
            {"Methane","Hydrogen sulphide","Venus"},
            //Neptune
            {"30 times than the distance of Earth to the Sun","Supersonic strong wind","Approximately 17 times larger than Earth"},
            //Pluto
            {"It has a highly elliptical orbit","Dwarf planet","Ice"}
    };

    public String[][] choiceOne = {
            //Mercury's choice 1 for all questions
            {"88 earth days", "4878 km", "450 Celsius"},
            //Venus's choice 1 for all questions
            {"225 earth days","Sulfuric acids","East to West"},
            //Earth
            {"Sulfuric acids","365.24 earth days","12,760 km"},
            //Mars
            {"Blue Planet","687 earth years","Because it has glowing rays"},
            //Jupiter
            {"Approximately 75 moons","The Red Planet","11.9 earth days"},
            //Saturn
            {"Visible Ring","29.5 earth hours","Hydrogen and Helium"},
            //Uranus
            {"Oxygen","Hydrogen sulphide","Mercury"},
            //Neptune
            {"Same as the distance of Uranus to the Sun","Supersonic strong wind","Approximately 17 times larger than Earth"},
            //Pluto
            {"It has red rings","Dwarf planet","Fire"}
    };

    public String[][] choiceTwo = {
            //Mercury's choice 2 for all questions
            {"88 earth years", "4878 meters", "450 Fahrenheit"},
            //Venus's choice 2 for all questions
            {"225 earth years","Oxygen","West to East"},
            //Earth
            {"Oxygen and Nitrogen","24 earth hours","12,760 meters"},
            //Mars
            {"Red World","687 earth days","Because it is covered with iron oxides"},
            //Jupiter
            {"Approximately 7 moons","The Great Red Spot","365 earth days"},
            //Saturn
            {"Visible Craters","29.5 earth days","Hydrogen and Oxygen"},
            //Uranus
            {"Methane","Rotten eggs","Earth"},
            //Neptune
            {"30 times than the distance of Earth to the Sun","Visible ring","Same as Earth"},
            //Pluto
            {"It has red craters","Huge planet","Ice"}
    };

    public String[][] choiceThree = {
            //Mercury's choice 3 for all questions
            {"88 earth hours", "4878 cm", "45 Celsius"},
            //Venus's choice 3 for all questions
            {"225 earth hours","Nitrogen","North to South"},
            //Earth
            {"Nitrogen and Carbon Dioxide", "60 minutes","12,760 cm"},
            //Mars
            {"Red Planet","687 earth hours","Because it is covered with oxygen"},
            //Jupiter
            {"None","The Rainbow","11.9 earth years"},
            //Saturn
            {"Visible Mountains","29.5 earth years","Oxygen and Nitrogen"},
            //Uranus
            {"Hydrogen","Hydrogen","Venus"},
            //Neptune
            {"10 times than the distance of Earth to the Sun","Visible rays","Smaller than Earth"},
            //Pluto
            {"It has a highly elliptical orbit","Close to the Sun","Hydrogen"}
    };


    public String[][] getQuestions() {
        return Questions;
    }

    public String[][] getCorrectAnswers() {
        return correctAnswers;
    }

    public String[][] getChoiceOne() {
        return choiceOne;
    }

    public String[][] getChoiceTwo(){
        return choiceTwo;
    }

    public String[][] getChoiceThree(){
        return choiceThree;
    }

}
