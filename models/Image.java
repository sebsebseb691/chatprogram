package models;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


public class Image implements MessageInterface {
    private static final long serialVersionUID = 2L; // Unique serialVersionUID for Image class
    private transient BufferedImage image;
    private String chatRoomName;
    private String sender;
    private byte[] imageBytes; // Use byte array for serialization

    public Image(File imageFile, String chatRoomName, String sender) throws IOException {
        if (imageFile == null) throw new RuntimeException("Image file cannot be null");
        else {
            this.chatRoomName = chatRoomName;
            this.sender = sender;
            this.image = ImageIO.read(imageFile);
            this.imageBytes = bufferedImageToByteArray(this.image);
        }
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

    @Override
    public BufferedImage getImage() {return this.image;}
    @Override
    public String getMsg() {return "image message";}
    @Override
    public String getUser() {return this.sender;}
    @Override
    public String getChatRoomName() {return this.chatRoomName;}
}