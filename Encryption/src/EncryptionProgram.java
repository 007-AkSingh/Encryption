import java.util.*;

public class EncryptionProgram {
	
	
	// declare all the global variables we'll require further
	private Scanner scanner;
	private Random  random;
	private ArrayList<Character> list;
	private ArrayList<Character> shuffledlist;
	private char character;
	private String line;
	private char[] letters;
	private char[] secretLetters;
	
	EncryptionProgram(){  // create the constructor for encryption class
		scanner = new Scanner(System.in);  // initialize scanner variables
		random = new Random();
		list = new ArrayList();
		shuffledlist = new ArrayList();
		character = ' ';
		
		newKey();  // call the new key method
		askQuestion();
	
		
	}
	
	private void askQuestion(){  // initialize ask question method 
		while(true) {  // to continue forever while true is used
			System.out.println("***********************************************");  // print all requirements 
			System.out.println("What do you want to do ?");
			System.out.println("(N)ewKey, (G)etKey,(E)ncrypt,(D)ecrypt,(Q)uit");
			char response = Character.toUpperCase(scanner.nextLine().charAt(0));  // to change the input character if lower case then to upper case , charAt is used to take as an input the 1st input character 
			
			switch(response) { //  to read the response character and match with below conditions
			case 'N':
				newKey();  // if n is the input it will go to new key method 
				break;
			case 'G':
				getKey();
				break;
			case 'E':
				encrypt();
				break;
			case 'D':
				decrypt();
				break;
			case 'Q':
				quit();
				break;
			default:
				System.out.println("Not a Valid answer:(");
			
			
			}
		}
	}
	
	private void newKey() {  // initialize new key method also use private for security reasons
		character = ' ';  // to start the character with space
		list.clear();  // to clear the list and start fresh 
		shuffledlist.clear();  // also shuffled list must be cleared 
		
		for(int i=32; i<127; i++) {  // initialize i with 32 list character
			list.add(Character.valueOf(character));  // add the character value of our character in the list
			character++;  // increment the character
		}
		 shuffledlist = new ArrayList(list);  // initialize shuffled list
		 Collections.shuffle(shuffledlist);  // to shuffle the shuffled list used a collection method
		System.out.println("*A new key has been generated*");  
	}
	
	private void getKey() {  // initialize get key method to retrieve what the current key is
		System.out.println("Key: ");
		for(Character x : list) {  // for each loop is used to store the of list in x 
			System.out.print(x);
		}
		System.out.println();
		for(Character x : shuffledlist) {
			System.out.print(x);
		}
		System.out.println();
		
	}
	
	private void encrypt() {  // initialize encrypt method it will encrypt plain text as cypher text
		System.out.println("Enter a message to be encrypted: ");
		String message = scanner.nextLine();  // create local variable 
		
		letters = message.toCharArray();  // toCharArray is a method used to break the string into an array of characters 
		
		for(int i=0;i<letters.length;i++) {  // using nested for loop to iterate letters length and list size also check the match from list array
			
			for(int j=0;j<list.size();j++) {
				if(letters[i]==list.get(j)) {
					letters[i]=shuffledlist.get(j);
					break;
				}
			}
		}
		System.out.println("Encrypted: ");
		for(char x : letters) { // for loop to encrypt the message with x - stored list
			System.out.println(x);
		}
		System.out.println();
	}
	private void decrypt() {  // initialize decrypt method it will take cypher text and convert it to plain text
		System.out.println("Enter a message to be decrypted: ");
		String message = scanner.nextLine();
		
		letters = message.toCharArray();
		
		for(int i=0;i<letters.length;i++) { // using nested for loop to iterate letters length and  Shuffed list size also check the match from shuffled list array
						
			for(int j=0;j<shuffledlist.size();j++) {
				if(letters[i]==shuffledlist.get(j)) {
					letters[i]=list.get(j);
					break;
				}
			}
		}
		System.out.println("Decrypted: ");
		for(char x : letters) {  // for loop to decrypt the message with x-stored shuffled list
			System.out.println(x);
		}
		System.out.println();
	}
			
	private void quit() {  // initialize quit method to exit 
		System.out.println("Thank You, have a nice day buddy!!");
		System.exit(0);  // to exit the program
		
	}

}
