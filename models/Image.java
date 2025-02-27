package models;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.io.Serializable;

public class Image implements Message_Interface, Serializable {
    private ModelsFacade mf = ModelsFacade.getInstance();
    private String msg;
    private String user;
    private BufferedImage image;

    public Image(File imageFile) throws IOException {
        if (imageFile == null) throw new RuntimeException("Image file cannot be null");
        else {
            this.msg = "Image: " + imageFile.getName();
            this.user = mf.getUser().getUsername();
            this.image = ImageIO.read(imageFile);
        }

        try {
            mf.getChatRoom().addMessage(this);
        } catch (Exception e) {
            throw new RuntimeException("You need to join a chatroom to send messages");
        }
    }

    @Override
    public String getMsg() {
        return this.msg;
    }

    @Override
    public String getUser() {
        return this.user;
    }

    @Override
    public BufferedImage getImage() {
        return this.image;
    }
}