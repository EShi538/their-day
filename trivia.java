import java.util.*;
import java.io.*;
public class trivia{
    static String[][] questions = new String[3][4]; //cat. 1: Chem, cat. 2: Earth, cat 3: Bio;
    static boolean[][] answered = new boolean[3][4]; //true = answered, false = not answered
    static String player1 = "", player2 = "";
    static int player1Score = 0, player2Score = 0;
    public static void main(String[] args) throws Exception{
        //setup
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Budget Jeopardy™!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Contestant 1, enter your name");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(">>");
        player1 = in.readLine();
        System.out.println("Nice to meet you " + player1);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Contestant 2, enter your name");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(">>");
        player2 = in.readLine();
        System.out.println("Nice to meet you " + player2);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //loading
        System.out.println();
        System.out.println("----------");
        System.out.println();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Configurating the triangulation of the configuration...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Calibrating the calibration...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print("almost done");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(".");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("----------");
        System.out.println();

        //game
        fillQuestions();
        boolean isPlayer1 = true;
        boolean isSecondQuestion = false;
        System.out.println("type 'q' when prompted for an answer to end the game");
        System.out.println("Category 1: Chem");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Category 2: Earth");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Category 3: Bio");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("When prompted to choose a question, respond in the form: category # (1-3) question # (1-4 <higher number = more difficult>) (Example: 3 1)");
        System.out.println();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while(true){
            if(isPlayer1){
                System.out.println("It is " + player1 + "'s turn");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("It is " + player2 + "'s turn");
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            int cat = 0, question = 0;
            boolean wantsToEnd = false;
            while(true){
                System.out.println("Pick a question");
                System.out.print(">>");
                String choice = in.readLine();
                if(choice.equalsIgnoreCase("q")){
                    wantsToEnd = true;
                    break;
                }
                StringTokenizer st = new StringTokenizer(choice);
                cat = Integer.parseInt(st.nextToken()); question = Integer.parseInt(st.nextToken());
                if(!inBound(cat, question)){
                    System.out.println("Not in bounds, choose another question");
                    continue;
                }
                if(answered[cat - 1][question - 1]){
                    System.out.println("You already answered this question, choose another question");
                }
                else{
                    break;
                }
            }
            if(wantsToEnd){
                System.out.println();
                System.out.println("---------");
                System.out.println();
                break;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(questions[cat - 1][question - 1]);
            System.out.print(">>");
            String answer = in.readLine();
            System.out.println("Checking...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println();
            if(isCorrect(cat, question, answer)){
                System.out.println("Correct!");
                if(isPlayer1){
                    player1Score += question * 100;
                }
                else{
                    player2Score += question * 100;
                }
                if(isSecondQuestion){
                    isPlayer1 = !isPlayer1;
                    isSecondQuestion = false;
                }
                else{
                    isSecondQuestion = true;
                }
                answered[cat - 1][question - 1] = true;
            }
            else{
                System.out.println("Incorrect");
                if(isPlayer1){
                    player1Score -= question * 100;
                }
                else{
                    player2Score -= question * 100;
                }
                isPlayer1 = !isPlayer1;
            }
            if(allDone()){
                System.out.println();
                System.out.println("---------");
                System.out.println();
                break;
            }
            System.out.println();
            System.out.println(player1 + "'s score: " + player1Score);
            System.out.println(player2 + "'s score: " + player2Score);
            if(player1Score > player2Score){
                System.out.println(player1 + "  is winning!");
            }
            else if(player1Score < player2Score){
                System.out.println(player2 + " is winning!");
            }
            else{
                System.out.println("Currently a tie");
            }
            System.out.println();
            System.out.println("---------");
            System.out.println();
        }
        System.out.println(player1 + "'s score: " + player1Score);
        System.out.println(player2 + "'s score: " + player2Score);
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.print("Tapping into the cosmic force and seeing who won");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(".");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(".");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(player1Score > player2Score){
            System.out.println(player1 + " WINS!");
        }
        else if(player1Score < player2Score){
            System.out.println(player2 + " WINS!");
        }
        else{
            System.out.println("TIE!");
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println("gg gamers");
    }   
    static boolean isCorrect(int cat, int question, String answer){
        if(cat == 1){
            switch(question){
                case 1: return answer.equalsIgnoreCase("positive") || answer.equals("+");
                case 2: return answer.equalsIgnoreCase("three") || answer.equals("3");
                case 3: return answer.equalsIgnoreCase("phosphite") || answer.equalsIgnoreCase("phosphite ion");
                case 4: return answer.equalsIgnoreCase("hydrochloric acid");
            }
        }
        else if(cat == 2){
            switch(question){
                case 1: return answer.equalsIgnoreCase("crust") || answer.equalsIgnoreCase("the crust");
                case 2: return answer.equalsIgnoreCase("a typhoon") || answer.equalsIgnoreCase("typhoon");
                case 3: return answer.equalsIgnoreCase("seven") || answer.equals("7");
                case 4: return answer.equalsIgnoreCase("rodinia");
            }
        }
        else if(cat == 3){
            switch(question){
                case 1: return answer.equalsIgnoreCase("an organism") || answer.equalsIgnoreCase("organism") || answer.equalsIgnoreCase("organisms");
                case 2: return answer.equalsIgnoreCase("skeleton") || answer.equalsIgnoreCase("a skeleton") || answer.equalsIgnoreCase("skeletons"); 
                case 3: return answer.equalsIgnoreCase("blue whale") || answer.equalsIgnoreCase("a blue whale") || answer.equalsIgnoreCase("the blue whale");
                case 4: return answer.equalsIgnoreCase("inu");
            }
        }
        return false;
    }
    static void fillQuestions(){
        questions[0][0] = "What is the charge of a cation?"; //+, or "positive" (case insensitive)
        questions[0][1] = "How many sig figs does 0.00710 contain?"; //3, or "three" (case insensitive)
        questions[0][2] = "What is the full name of PO3 -3?"; //Phosphite (case insensitive), or phosphite ion (case insensitive);
        questions[0][3] = "What is HCl?"; //hydrochloric acid (case insensitive)

        questions[1][0] = "What is the outermost layer of the earth?"; //crust, the crust
        questions[1][1] = "Hurricanes have many names depending on the location in which they form. When they form over the pacific northwest, what are they called?"; //a typhoon, typhoon
        questions[1][2] = "How many major tectonic plates is the earth divided into?"; //seven, 7
        questions[1][3] = "What is the oldest known supercontinent?"; //rodinia

        questions[2][0] = "In biology, what are living things called?"; //an organism, organism, organisms
        questions[2][1] = "What is a full set of bones called?"; //skeleton, a skeleton
        questions[2][2] = "What was the largest living creature of the twentieth century?"; //blue whale, the blue whale, a blue whale
        questions[2][3] = "What is the Japanese word for 'dog'? :)"; //inu (DOUBLE)
    }
    static boolean allDone(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 4; j++){
                if(answered[i][j] == false){
                    return false;
                }
            }
        }
        return true;
    }
    static boolean inBound(int cat, int question){
        return cat >= 1 && cat <= 3 && question >= 1 && question <= 4;
    }
}