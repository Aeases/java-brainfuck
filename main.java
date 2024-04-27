import java.util.Scanner;

class BrainFuckInterpretor {
	public static void main(String[] args) {
		int[] brain = new int[30000];
		int pointer = 0;
		int bracketLoopStart = -1;
		Scanner scan = new Scanner(System.in);
		// String codeInterp = scan.nextLine();
		// String codeInterp = "+++++[>++++++++++<-]>.";
		// String codeInterp = "+[----->+++<]>+.+.";
		
		for (int i = 0;i < codeInterp.length(); i++) {
			char currentChar = codeInterp.charAt(i);
			switch (currentChar) {
				case '>':
					pointer++;
					break;
				case '<':
					pointer--;
					break;
				case '+':
					brain[pointer]++;

					if (brain[pointer] > 255) {
						brain[pointer] = 0; // wrapping, java has no unsigned bytes :<
					}	
				break;
				case '-':
					brain[pointer]--;

					if (brain[pointer] < 0) {
						brain[pointer] = 255; // wrapping, java has no unsigned bytes :<
					}
					break;
				case '[':
					if (brain[pointer] == 0) 
					{
						while (codeInterp.charAt(i) != ']') { i++; }
					} 
					else {bracketLoopStart = i;}

					break;
				case ']':
					if (brain[pointer] != 0) {
						i = bracketLoopStart;
					}
					break;
				case '.':
					System.out.print( (char)brain[pointer] );
					break;
				default:
					break;
			}
		}
	}
}

