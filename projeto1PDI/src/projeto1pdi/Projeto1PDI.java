package projeto1pdi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author felipe
 */
public class Projeto1PDI extends JFrame {
            
    private static final long serialVersionUID = 1L;
    private BufferedImage imgBuff, img2;
    private JFileChooser fc;
    private Image img;
    private String path;
    private static File f = new File(""), f2 = new File("");

    private JPanel pane;
    private JLabel dim;
    private VisualizaImg paneImg;
    private JButton btnAbrir, btnOrigin, btnGray, btnR, btnG, btnB, btnN, convertRGB, bAdd, bMult, media, mediana, blend;
    private JTextField brilhoA, brilhoM, mask, mask2, threshold;
    
    public Projeto1PDI() {

        pane = new JPanel();

        btnAbrir = new JButton("Abrir");
        btnOrigin = new JButton("Original");
        btnGray = new JButton("GrayScale");
        btnR = new JButton("Red");
        btnG = new JButton("Green");
        btnB = new JButton("Blue");
        btnN = new JButton("Negativo");
        convertRGB = new JButton("RGB");
        bAdd = new JButton("Add Brilho");
        bMult = new JButton("Mult Brilho");
        media = new JButton("Media");
        mediana = new JButton("Mediana");
        blend = new JButton("Blend");
        brilhoA = new JTextField();
        brilhoM = new JTextField();
        mask = new JTextField();
        mask2 = new JTextField();
        threshold = new JTextField();
        dim = new JLabel("Dimensões da imagem: ");

        setBounds(400, 100, 800, 640);
        setLocationRelativeTo(null);
        setTitle("Processamento de Imagens");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        pane.setSize(800, 540);
        pane.setLayout(null);

        dim.setBounds(50, 510, 400, 20);
        dim.setFont(new Font("Sans Serif", Font.ITALIC, 11));
        pane.add(dim);

        btnAbrir.setBounds(10, 10, 100, 25);
        pane.add(btnAbrir);

        btnOrigin.setBounds(685, 10, 100, 25);
        pane.add(btnOrigin);
        btnGray.setBounds(685, 40, 100, 25);
        pane.add(btnGray);
        btnR.setBounds(685, 70, 100, 25);
        pane.add(btnR);
        btnG.setBounds(685, 100, 100, 25);
        pane.add(btnG);
        btnB.setBounds(685, 130, 100, 25);
        pane.add(btnB);
        btnN.setBounds(685, 160, 100, 25);
        pane.add(btnN);

        convertRGB.setBounds(685, 190, 100, 25);
        pane.add(convertRGB);

        bAdd.setBounds(685, 220, 100, 25);
        pane.add(bAdd);
        brilhoA.setBounds(660, 220, 25, 26);
        pane.add(brilhoA);

        bMult.setBounds(685, 250, 100, 25);
        pane.add(bMult);
        brilhoM.setBounds(660, 250, 25, 26);
        pane.add(brilhoM);

        mask.setBounds(660, 280, 25, 26);
        pane.add(mask);
        media.setBounds(685, 280, 100, 25);
        pane.add(media);

        mask2.setBounds(660, 310, 25, 26);
        pane.add(mask2);
        mediana.setBounds(685, 310, 100, 25);
        pane.add(mediana);

        blend.setBounds(685, 340, 100, 25);
        pane.add(blend);

        add(pane);

        paneImg = new VisualizaImg();
        paneImg.setBounds(50, 100, 600, 400);
        pane.add(paneImg);

        btnAbrir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f = abrirArquivo();
                setImagens(caminhoArquivo(f));
            }
        }
        );


        btnOrigin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                toImage(bufferImagem(f));
            }
        }
        );

        btnGray.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //grayScale
                img2 = Efeitos.toGray(bufferImagem(f));
                paneImg.setImg(img2);
            }
        }
        );

        btnR.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //banda red
                img2 = Efeitos.red(bufferImagem(f));
                paneImg.setImg(img2);
            }
        }
        );

        btnG.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //banda green
                img2 = Efeitos.green(bufferImagem(f));
                paneImg.setImg(img2);
            }
        }
        );

        btnB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //banda blue
                img2 = Efeitos.blue(bufferImagem(f));
                paneImg.setImg(img2);
            }
        }
        );

        btnN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] choices = {"RGB", "R", "G", "B", "Quit"};
                //negativo
                int op = JOptionPane.showOptionDialog(Projeto1PDI.getFrames()[0],
                        "Opções Negativo:",
                        "Negativo",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        choices,
                        "Quit");
                switch (op) {
                    case 0:
                        img2 = Efeitos.negativoRGB(bufferImagem(f));
                        break;                
                    case 1:
                        img2 = Efeitos.negativoR(bufferImagem(f));
                        break;
                    case 2:
                        img2 = Efeitos.negativoG(bufferImagem(f));
                        break;
                    case 3:
                        img2 = Efeitos.negativoB(bufferImagem(f));
                        break;
                }
                paneImg.setImg(img2);
            }
        }
        );
        
        convertRGB.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img2 = bufferImagem(f);
                Efeitos.rgbToyiq(img2);
                paneImg.setImg(img2);                
            }
        }
        );

        bAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //aditivo brilho
                if (brilhoA.getText() != "") {
                    img2 = Efeitos.brilhoAdd(bufferImagem(f), Integer.parseInt(brilhoA.getText()));
                    paneImg.setImg(img2);
                } else {
                    img2 = Efeitos.brilhoAdd(bufferImagem(f), 0);
                    paneImg.setImg(img2);
                }
            }
        }
        );

        bMult.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //multiplicativo brilho
                if (brilhoM.getText() != "") {
                    img2 = Efeitos.brilhoMult(bufferImagem(f), Integer.parseInt(brilhoM.getText()));
                    paneImg.setImg(img2);
                } else {
                    img2 = Efeitos.brilhoMult(bufferImagem(f), 0);
                    paneImg.setImg(img2);
                }
            }
        }
        );
        media.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //if (Integer.parseInt(mask.getText()) == 3 || Integer.parseInt(mask.getText()) == 5 || Integer.parseInt(mask.getText()) == 7) {
                img2 = bufferImagem(f);
                Efeitos.media(img2, Integer.parseInt(mask.getText()));
                paneImg.setImg(img2);
                //} else {
                //JOptionPane.showMessageDialog(null, "Digite um tamanho válido da mascara [3,5,7]");
                //}
            }
        }
        );

        mediana.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                img2 = bufferImagem(f);
                Efeitos.mediana(img2, Integer.parseInt(mask2.getText()));
                paneImg.setImg(img2);

            }
        }
        );


        blend.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                f2 = abrirArquivo();
                BufferedImage imgBlend = bufferImagem(f2);
                img2 = Efeitos.blend(bufferImagem(f), imgBlend);
                paneImg.setImg(img2);
            }
        }
        );

    }

    public File abrirArquivo() {
        File fLocal = new File("");
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int i = fc.showOpenDialog(pane);
        if (i == 0) {
            fLocal = fc.getSelectedFile();
            BufferedImage im = bufferImagem(fLocal);
            int w = im.getWidth();
            int h = im.getHeight();
            dim.setText(" Dimensões da imagem: " + w + " x " + h);
        } else {
            System.out.println("Operação cancelada");
        }
        return fLocal;
    }


    public String caminhoArquivo(File f) {
        return f.getAbsolutePath();
    }

    public BufferedImage bufferImagem(File f) {
        try {
            imgBuff = ImageIO.read(f);
        } catch (IOException ex) {
            Logger.getLogger(Projeto1PDI.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imgBuff;
    }

    public void toImage(BufferedImage imgBuff) {
        paneImg.setImg(Toolkit.getDefaultToolkit().createImage(imgBuff.getSource()));
    }

    public void setImagens(String path) {
        paneImg.setImg(path);
        this.path = path;
    }
    
    public class VisualizaImg extends JPanel {

        private static final long serialVersionUID = 1L;
        private Image img;

        public VisualizaImg() {
        }

        public VisualizaImg(Image img) {
            setImg(img);
        }

        public VisualizaImg(String url) {
            setImg(url);
        }

        protected void paintComponent(final Graphics g) {
            super.paintComponent(g);
            g.drawImage(img, 0, 0, paneImg.getSize().width, paneImg.getSize().height, this);
        }

        public void setImg(Image img) {
            this.img = img;
            this.repaint();
        }

        public void setImg(String url) {
            setImg(Toolkit.getDefaultToolkit().createImage(url));
        }
    }

    public static void main(String[] args) {
        new Projeto1PDI();
    }
}
