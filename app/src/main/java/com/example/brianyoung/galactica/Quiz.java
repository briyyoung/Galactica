package com.example.brianyoung.galactica;

import java.util.List;

public class Quiz {

    public String Questions[][] = {
            //Mercury's questions
            {"What is the orbit time for Mercury?", "What is the diameter of Mercury?", "What is the highest temperature on Mercury surface?"},
            //Venus's questions
            { "What is the orbit time for Venus?", "What is Venus’s atmosphere made of?", "What is the rotation direction of Venus?"}
    };

    public String correctAnswers[][] = {
            //Mercury's correct answers
            {"88 earth days","4878 km","450 Celsius"},
            //Venus's correct answers
            {"225 earth days","Sulfuric acids","East to West"}

    };

    public String[][] choiceOne = {
            //Mercury's choice 1 for all questions
            {"88 earth days", "4878 km", "450 Celsius"},
            //Venus's choice 1 for all questions
            {"225 earth days","Sulfuric acids","East to West"}
    };

    public String[][] choiceTwo = {
            //Mercury's choice 2 for all questions
            {"88 earth years", "4878 meters", "450 Fahrenheit"},
            //Venus's choice 2 for all questions
            {"225 earth years","Oxygen","West to East"}
    };

    public String[][] choiceThree = {
            //Mercury's choice 3 for all questions
            {"88 earth hours", "4878 cm", "45 Celsius"},
            //Venus's choice 3 for all questions
            {"225 earth hours","Nitrogen","North to South"}
    };

//        public String mercuryQuestions[] = {
//            "What is the orbit time for Mercury?",
//            "What is the diameter of Mercury?",
//            "What is the highest temperature on Mercury surface?"
//    };
//
//    public String venusQuestions[] = {
//            "What is the orbit time for Venus?",
//            "What is Venus’s atmosphere made of?",
//            "What is the rotation direction of Venus?"
//    };
//
//    public String mercuryChoices[][] = {
//            {"88 earth days","88 earth years","88 earth hours"},
//            {"4878 km","4878 meters","4878 cm"},
//            {"450 Celsius","450 Fahrenheit", "45 Celsius"}
//    };
//
//    public String venusChoices[][]={
//            {"225 earth days","225 earth years","225 earth hours"},
//            {"Sulfuric acids","Oxygen","Nitrogen"},
//            {"East to West","West to East","North to South"}
//    };

//    public String choices[][][] = {
//            //Mercury's choices
//            {
//                    //Mercury's Q1's choices
//                    {"88 earth days","88 earth years","88 earth hours"},
//                    //Mercury's Q2's choices
//                    {"4878 km","4878 meters","4878 cm"},
//                    //Mercury's Q3's choices
//                    {"450 Celsius","450 Fahrenheit", "45 Celsius"}
//            },
//            //Venus's choices
//            {
//                    //Venus's Q1's choices
//                    {"225 earth days","225 earth years","225 earth hours"},
//                    //Venus's Q2's choices
//                    {"Sulfuric acids","Oxygen","Nitrogen"},
//                    //Venus's Q3's choices
//                    {"East to West","West to East","North to South"}
//            }
//
//    };



//    public String mercuryAnswer[] = {
//            "88 earth days","4878 km","450 Celsius"
//    };
//
//    public String venusAnswer[] = {
//        "225 earth days","Sulfuric acids","East to West"
//    };
//


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

//    //can we make one method to get each question depends on the List name = planet name?
//    public String getMercuryQuestion(int a){
//        String question = mercuryQuestions[a];
//        return question;
//    }
//
//
//
//    //can we make one method to get each question depends on the List name = planet name?
//    public String getVenusQuestion(int a){
//        String question = venusQuestions[a];
//        return question;
//    }
//
//    public String[][] getMercuryChoices() {
//        return mercuryChoices;
//    }
//
//    public String[][] getVenusChoices() {
//        return venusChoices;
//    }
//
//    public String getMercuryAnswer(int a){
//        String answer = mercuryAnswer[a];
//        return answer;
//    }
//
//    public String getVenusAnswer(int a){
//        String answer = venusAnswer[a];
//        return answer;
//    }
}
