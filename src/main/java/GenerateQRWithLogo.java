/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
/**
 *
 * @author Abdul Waris Sherzad
 */
public class GenerateQRWithLogo {
    public static void main(String[] args) throws Exception {
         
        String content = "https://www.qr-code-generator.com/";
        String pathToStore = "C:\\Users\\Abdul Waris Sherzad\\OneDrive\\Documents\\Scanme.jpg";
         
        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, 400, 400);
         MatrixToImageConfig imageConfig = new MatrixToImageConfig(MatrixToImageConfig.BLACK, MatrixToImageConfig.WHITE);
          
           BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(bitMatrix, imageConfig);
            // Getting logo image
            BufferedImage logoImage = ImageIO.read( new File("C:\\Users\\Abdul Waris Sherzad\\OneDrive\\Documents\\images.jpg"));
            int finalImageHeight = qrImage.getHeight() - logoImage.getHeight();
            int finalImageWidth = qrImage.getWidth() - logoImage.getWidth();
            //Merging both images 
            BufferedImage finalImage = new BufferedImage(qrImage.getHeight(), qrImage.getWidth(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = (Graphics2D) finalImage.getGraphics();
            graphics.drawImage(qrImage, 0, 0, null);
            graphics.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
            graphics.drawImage(logoImage, (int) Math.round(finalImageWidth / 2), (int) Math.round(finalImageHeight / 2), null);
             
            ImageIO.write(finalImage, "png", new File(pathToStore));
         
        System.out.println("QR Code with Logo Generated Successfully");
 
    }
    
}
