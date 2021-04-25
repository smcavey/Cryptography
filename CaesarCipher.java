import java.util.Scanner;
public class CaesarCipher {
    
    public static void main (String [] args){
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a message to encrypt: ");
        String messageToEncrypt = input.nextLine();
        System.out.println("Enter a shift value: ");
        int shift = input.nextInt();
		
		System.out.print("message before encryption: ");
		System.out.println(messageToEncrypt);
        
		System.out.print("message after encryption: ");
        StringBuilder messageAfterEncryption = encrypt(messageToEncrypt, shift); // encrypt message using input string and shift value
        System.out.println(messageAfterEncryption.toString());
		
		System.out.print("message after decryption: ");
		StringBuilder messageAfterDecryption = decrypt(messageAfterEncryption, shift); // decrypt message using encrypted message and shift value
		System.out.println(messageAfterDecryption.toString());
    }
    
    public static StringBuilder encrypt(String messageToEncrypt, int shift){
        StringBuilder encryptedMessage = new StringBuilder();
        for(int i = 0; i < messageToEncrypt.length(); i++){
            char character = messageToEncrypt.charAt(i);
            if(character != ' '){ // if character is not a space
				if((int)character >= 65 && (int)character <= 90){ // if character falls within uppercase letter unicodes
					character = (char)(((int)character + shift - 65) % 26 + 65);
				}
				if((int)character >= 97 && (int)character <= 122){ // if character falls within lowercase letter unicodes
					character = (char)(((int)character + shift - 97) % 26 + 97);
				}
            }
			encryptedMessage.append(character); // add spaces and newly encrypted characters to the encrypted message
        }
        return encryptedMessage;
    }
	
	public static StringBuilder decrypt(StringBuilder messageAfterEncryption, int shift){
		StringBuilder decryptedMessage = new StringBuilder();
		for(int i = 0; i < messageAfterEncryption.length(); i++){
			char character = messageAfterEncryption.charAt(i);
			if(character != ' '){
				if((int)character >= 65 && (int)character <= 90){
					character = (char)(((int)character - shift - 65) % 26 + 65);
				}
				if((int)character >= 97 && (int)character <= 122){
					character = (char)(((int)character - shift - 97) % 26 + 97);
				}
			}
			decryptedMessage.append(character); // add spaces and newly decrypted characters to the decrypted message
		}
		return decryptedMessage;
	}
    
}