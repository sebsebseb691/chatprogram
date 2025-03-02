package models;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Image implements MessageInterface {
    private static final long serialVersionUID = 2L; // Unique serialVersionUID for Image class

    private String chatRoomName;
    private String user;
    private transient BufferedImage image;
    private byte[] imageBytes; // Use byte array for serialization

    public Image(File imageFile, String chatRoomName, String user) throws IOException {
        if (imageFile == null) throw new RuntimeException("Image file cannot be null");
        else {
            this.chatRoomName = chatRoomName;
            this.user = user;
            this.image = ImageIO.read(imageFile);
            this.imageBytes = bufferedImageToByteArray(this.image);
        }

      
    }

    @Override
    public String getMsg() {
        return "image message";
    }

    @Override
    public String getUser() {
        return this.user;
    }

    
    public BufferedImage getImage() {
        return this.image;
    }

    public String getChatRoomName() {
        return this.chatRoomName;
    }

    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeInt(imageBytes.length);
        oos.write(imageBytes);
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        ois.defaultReadObject();
        int length = ois.readInt();
        imageBytes = new byte[length];
        ois.readFully(imageBytes, 0, length);
        image = byteArrayToBufferedImage(imageBytes); // Convert byte array back to BufferedImage
    }

    private byte[] bufferedImageToByteArray(BufferedImage image) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            ImageIO.write(image, "png", baos);
            return baos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private BufferedImage byteArrayToBufferedImage(byte[] bytes) {
        try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes)) {
            return ImageIO.read(bais);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}