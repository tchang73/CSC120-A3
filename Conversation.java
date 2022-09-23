import java.util.*;

/*
 * Conversation class contains all methods for chatbot to operate, including:
 * looping through code for however many times the user desires,
 * detect and replace mirror words such as from "I" to "You",
 * record the chatbot-user interaction and print out transcript at the end.
 */
class Conversation {
  public static void main(String[] arguments) 
  {
    System.out.print("Enter # of rounds: "); //print prompt for number of rounds

    Scanner input = new Scanner(System.in); //scan input for number of rounds
    int numRounds = input.nextInt();

    Scanner user_input = new Scanner(System.in); //scan user input
    String answer = input.nextLine();

    List <String> transcript = new ArrayList<>(); //create array list for transcript

    System.out.println("How's your day been?"); //print prompt for user's answer
    transcript.add("How's your day been? \n"); //add 1st prompt to array list for transcript

    String[] responses = new String[]{"Uh huh.", "Interesting.", "That's good to hear.", "Ok.", "Cool beans.", "That is amusing."}; //create string of canned responses
    
    for (int i = 0; i < numRounds; i++){ //loop for however many rounds the user inputted
      String new_user_input = input.nextLine(); //take in user input
      transcript.add(new_user_input + "\n"); //add user input to array list for transcript
        if (new_user_input.contains(" you ") || new_user_input.contains("You") || new_user_input.contains("I ") || new_user_input.contains(" I ")|| 
        new_user_input.contains(" me ") || new_user_input.contains("Me ") || new_user_input.contains(" my ") || new_user_input.contains("My ") || 
        new_user_input.contains(" am ") || new_user_input.contains(" are ") || new_user_input.contains(" your ") || new_user_input.contains("Your ") || 
        new_user_input.contains("You're ") || new_user_input.contains(" you're ") || new_user_input.contains("I'm ") || new_user_input.contains(" I'm ")
          ){ //detect if user input conains mirror words
              String [] words = new_user_input.split(" "); //split input into individual words
              for (int j =0; j < words.length; j++) { //reassign mirror words
                if (words[j].equals("I"))
                {
                  words[j]= "you";
                } else if (words[j].equals("you")){
                  words[j]= "I";
                } else if (words[j].equals("You")){
                  words[j]= "I";
                } else if (words[j].equals("me")){
                  words[j]= "you";
                } else if (words[j].equals("Me")){
                  words[j]= "You";
                } else if (words[j].equals("am")){
                  words[j]= "are";
                } else if (words[j].equals("are")){
                  words[j]= "am";
                } else if (words[j].equals("my")){
                  words[j]= "your";
                } else if (words[j].equals("My")){
                  words[j]= "Your";
                }else if (words[j].equals("your")){
                  words[j]= "my";
                } else if (words[j].equals("Your")){
                  words[j]= "My";
                } else if (words[j].equals("You're")){
                  words[j]= "I'm";
                } else if (words[j].equals("I'm")){
                  words[j]= "You're";
                } else if (words[j].equals("you're")){
                  words[j]= "I'm";
                } 
              }
          System.out.println(String.join(" ", words)); //join mirrored words together to create output
          transcript.add(String.join(" ", words) + "\n"); //add output to transcript
          } else { //if no mirror words detected
          Random rand = new Random();
          int upperbound = 6;
          int random_response = rand.nextInt(upperbound); //output a random canned response
          System.out.println(responses[random_response]); //print canned response
          transcript.add(responses[random_response] + "\n");
                 } //add canned response to transcript
        }
      System.out.println("Bye"); //print "Bye" after all rounds are done
      transcript.toString(); //convert array list transcript to string
      System.out.println("\n" + "TRANSCRIPT:" + "\n" + String.join("", transcript) + "Bye"); //print transcript
  }
} 
