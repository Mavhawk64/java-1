// COURSE: CSCI1620
// TERM: Fall 2020
//
// NAME: Maverick Berkland
// RESOURCES: I didn't use any external sources for this code lab.

package morsecode;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/////////////////////////////////////////////////////////////
// To-do: Complete the method stubs for MorseEncoder to 
//       implement the functionality of each as designed.
//       Don't forget to add necessary instance data!
/////////////////////////////////////////////////////////////

/**
 * This class provides the ability to encode character data and files
 * into their equivalent representation in Morse Code. The International
 * Morse Code alphabet is used, and only the letters A-Z are supported. 
 *  
 * For more: https://en.wikipedia.org/wiki/Morse_code
 * 
 * @author mberkland
 *
 */
public class MorseEncoder 
{
	/**
	 * The imported translation file.
	 */
	private String morseFile;
	
	/**
	 * Initializes a MorseEncoder object based on a character map file.
	 * The character map file is a CSV where each row represents the mapping
	 * between a single English alphabet character and the Morse Code equivalent.
	 * 
	 * For example, rows in the should look like this:
	 * A,.-
	 * B,-...
	 * C,-.-.
	 * 
	 * Further, MorseEncoder class assumes that rows in this file are in order
	 * from A-Z and that no additional data is present in the file.
	 * 
	 * All exceptions arising during attempts to read character map file will be
	 * passed back to the client code.
	 * 
	 * @param characterMapFile The name of the file containing Morse code character mappings.
	 * @throws FileNotFoundException when the characterMapFile path is invalid 
	 */
	public MorseEncoder(String characterMapFile) throws FileNotFoundException
	{
		if (new File(characterMapFile).exists())
		{
			morseFile = characterMapFile;
		}
		else
		{
			throw new FileNotFoundException();
		}
    
	}
	
	/**
	 * Encodes a single English alphabet character into Morse code based on
	 * the character map file specified at the time this MorseCode object was
	 * created.  Lowercase and uppercase characters are treated equivalent
	 * in the conversion to Morse code.
	 * 
	 * @param plainChar The alphabetic character to convert into Morse code.
	 * @return A string containing the corresponding Morse code character.
	 * @throws FileNotFoundException  To cash file with invalid name
	 * @throws InvalidCharacterException when a character other than A-Z or a-z is passed as plainChar.
	 */
	public String encodeChar(char plainChar) throws InvalidCharacterException, FileNotFoundException 
	{

		Scanner scan;
		try
		{
			//This opens the file.
			scan = new Scanner(new File(morseFile));
			boolean flag = false;
                
                //Loops as long as there is a new line and not a flag.
			while (scan.hasNextLine() && !flag)
			{
				String record = scan.nextLine();
				@SuppressWarnings("resource") //Eclipse Auto-correct.
				Scanner lineParser = new Scanner(record);
				lineParser.useDelimiter(",");
				char key = lineParser.next().charAt(0);
				String morseCode = lineParser.next();
                        
				if (key == Character.toUpperCase(plainChar))
				{
					lineParser.close();
					charToInt(key);
					return morseCode;
				}
				else if (!scan.hasNextLine())
				{
					flag = true;
					lineParser.close();
					throw new InvalidCharacterException("<<ERROR>> The input file contains a "
							+ "character that could not be encoded.\r\n", plainChar);
				}
			}
			scan.close();
		}
		catch (FileNotFoundException e)
		{
			throw new FileNotFoundException();
		}
		return "";
	}
	
	/**
	 * Encodes a whole English word into Morse code based on the character map
	 * file specified at the time this MorseCode object was created.  Lowercase and 
	 * uppercase characters are treated equivalent in the conversion to Morse code.
	 * 
	 * Consecutive characters in the Morse code equivalent string will be separated
	 * by a single space character.  For example: "DOG" ==> "-.. --- --."
	 * 
	 * @param plainWord The word to convert into Morse code.
	 * @return A string containing the corresponding Morse code characters.
	 * @throws InvalidCharacterException when plainWord contains one or more non-alphabetic characters.
	 * @throws FileNotFoundException To cash file with invalid name
	 */
	public String encodeWord(String plainWord) throws InvalidCharacterException, FileNotFoundException 
	{
		String morseWord = "";
		for (int i = 0; i < plainWord.length(); i++)
		{
			if (i == plainWord.length() - 1)
			{
				morseWord = morseWord + encodeChar(plainWord.toUpperCase().charAt(i));
			}
			else
			{
				morseWord = morseWord
						+ encodeChar(plainWord.toUpperCase().charAt(i)) + " ";                	
			}
		}
		return morseWord;
	}
	
	/**
	 * Processes a text input file and outputs its Morse code equivalent
	 * in a separate file.  Line breaks are preserved between the input
	 * and output files in identical locations.  Consecutive words on a 
	 * single line will be rendered in the output file with the sequence 
	 * " | " so that they can be easily distinguished in Morse code.  
	 * 
	 * Thus, if the input file contains the phrase:
	 *  GO SPOT GO
	 *  
	 * The output file will contain:
	 *  --. --- | ... .--. --- - | --. ---
	 * 
	 * Any exceptions that occur during file read/write will be passed back
	 * to the calling code.
	 * 
	 * @param inputFile The filename of the English based file to be processed.
	 * @param outputFile The filename where the output will be written.  Output files are
	 * always written in "write" mode and any existing contents will be
	 * deleted.
	 * @throws FileNotFoundException when the inputFile does not exist.
	 * @throws InvalidCharacterException when one or more invalid characters are detected 
	 * while processing the input file.
	 */
	public void encodeFile(String inputFile, String outputFile) 
			throws FileNotFoundException, InvalidCharacterException
	{
		try
		{
			Scanner input = new Scanner(new File(inputFile));
			FileOutputStream fileOut = new FileOutputStream(outputFile);
			PrintWriter writer = new PrintWriter(fileOut);
			while (input.hasNextLine())
			{
				String record = input.nextLine();
				@SuppressWarnings("resource") //Eclipse Auto-correct.
				Scanner lineParser = new Scanner(record);
				lineParser.useDelimiter(" ");
				while (lineParser.hasNext())
				{
					String word = lineParser.next();        
					if (lineParser.hasNext())
					{
						writer.print(encodeWord(word) + " | ");
					}         
					else
					{             
						writer.print(encodeWord(word));
					}
				}
				if (input.hasNextLine())
				{
					writer.print("\n");
				}
			}
			input.close();
			writer.close();
		}
		catch (FileNotFoundException e)
		{
			throw new FileNotFoundException();
		}
	}
	
	/**
	 * Helper method that converts a capital letter (A-Z) (65-90) to an
	 * index number: (A-Z) (0-25).
	 * @param n - The inputted capital letter (char).
	 * @return - An integer that is within 0 and 26 (non-inclusive).
	 */
	private int charToInt(char n)
	{
		return n - 'A';
	}
	
}
