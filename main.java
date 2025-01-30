import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ImageToText {
    public static void main(String[] args) {
        // Path to your image file
        String imagePath = "image.png"; // Change this to your image path
        String outputTextFile = "output.txt"; // Output text file

        // Initialize Tesseract instance
        Tesseract tesseract = new Tesseract();
        
        // Set the path to the Tesseract installation folder (update as needed)
        tesseract.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");

        try {
            // Extract text from image
            String extractedText = tesseract.doOCR(new File(imagePath));

            // Save the extracted text to a file
            saveTextToFile(outputTextFile, extractedText);
            System.out.println("Text extraction complete. Check " + outputTextFile);

        } catch (TesseractException e) {
            System.err.println("Error during OCR: " + e.getMessage());
        }
    }

    // Function to save extracted text to a file
    private static void saveTextToFile(String filePath, String text) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(text);
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
