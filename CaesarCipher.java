import java.util.Scanner;
public class CaesarCipher 
{
    public static void main (String[] args)
    {
        Scanner in = new Scanner(System.in);
        System.out.println("What's the message?");
        String msg = in.nextLine();
        System.out.println("What's the shift?");
        int shift = in.nextInt();

        String newMsg = "";
        char c;
        int j = 0;

        if (shift > 0) {
            for (int i = 0; i < msg.length(); i++)
            {
                c = msg.charAt(i);
                
                if (c == ' ') {
                    newMsg = newMsg + c;
                    continue;
                }

                if (!Character.isLetter(c)) {
                    newMsg = newMsg + c;
                    continue;
                }

                if (Character.isUpperCase(c)) {
                    for (char ch = c; j <= shift; ch++, j++) {
                        if (ch == 'Z' && j < shift) {
                            ch = 'A';
                            j++;
                        }
                        c = ch;
                    }
                }
                else {
                    for (char ch = c; j <= shift; ch++, j++) {
                        if (ch == 'z' && j < shift) {
                            ch = 'a';
                            j++;
                        }
                        c = ch;
                    } 
                }
                newMsg = newMsg + c;
                j = 0;
            }
        }
        else {
            for (int i = 0; i < msg.length(); i++)
            {
                c = msg.charAt(i);
                
                if (c == ' ') {
                    newMsg = newMsg + c;
                    continue;
                }

                if (!Character.isLetter(c)) {
                    newMsg = newMsg + c;
                    continue;
                }

                if (Character.isUpperCase(c)) {
                    for (char ch = c; j >= shift; ch--, j--) {
                        if (ch == 'A' && j > shift) {
                            ch = 'Z';
                            j--;
                        }
                        c = ch;
                    }
                }
                else {
                    for (char ch = c; j >= shift; ch--, j--) {
                        if (ch == 'a' && j > shift) {
                            ch = 'z';
                            j--;
                        }
                        c = ch;
                    } 
                }
                newMsg = newMsg + c;
                j = 0;
            }
        }
        System.out.println(newMsg);
    }
}