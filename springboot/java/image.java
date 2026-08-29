import javax.swing.*;
public class image {

     public static void main(String[] args) {

        JFrame frame = new JFrame("Menampilkan Gambar");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon icon = new ImageIcon("images.jpg");
        JLabel label = new JLabel(icon);

        frame.add(label);
        frame.setVisible(true);
    }

}
