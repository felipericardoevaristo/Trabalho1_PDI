/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        
        int x;
	private static final long serialVersionUID = 1L;
	private BufferedImage imgBuff, img2;
	private JFileChooser fc;
	private Image img;
	private String path;
	private static File f = new File(""), f2 = new File("");

	private JPanel pane;
	private JLabel dim;
	private VisualizaImg paneImg;
	private JButton btnAbrir, btnSalvar, btnOrigin, btnGray, btnR, btnG, btnB, btnN, convertRGB, bAdd, bMult, media, mediana, limiar, blend;
	private JTextField brilhoA, brilhoM, mask, mask2, threshold;

	public Projeto1PDI() {

		pane = new JPanel();

		btnAbrir = new JButton("Abrir");
		btnSalvar = new JButton("Salvar");
		btnOrigin = new JButton("Original");
		btnGray = new JButton("GrayScale");
		btnR = new JButton("Red");
		btnG = new JButton("Green");
		btnB = new JButton("Blue");
		btnN = new JButton("Negativo");
		convertRGB = new JButton("RGB");
		bAdd = new JButton("Add Brilho");
		bMult = new JButton("Mult Brilho");
		mask = new JTextField();
		media = new JButton("Media");
		mediana = new JButton("Mediana");
		limiar = new JButton("Limiar");
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
		btnSalvar.setBounds(120, 10, 100, 25);
		pane.add(btnSalvar);

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

		limiar.setBounds(685, 340, 100, 25);
		pane.add(limiar);
		threshold.setBounds(660, 340, 25, 26);
		pane.add(threshold);

		blend.setBounds(685, 370, 100, 25);
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

		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarArquivo(img2);
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
				img2 = toGray(bufferImagem(f));
				paneImg.setImg(img2);
			}
		}
				);

		btnR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//banda red
				img2 = red(bufferImagem(f));
				paneImg.setImg(img2);
			}
		}
				);

		btnG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//banda green
				img2 = green(bufferImagem(f));
				paneImg.setImg(img2);
			}
		}
				);

		btnB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//banda blue
				img2 = blue(bufferImagem(f));
				paneImg.setImg(img2);
			}
		}
				);

		btnN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] choices = {"RGB", "Y", "R", "G", "B", "Quit"};
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
					img2 = negativoRGB(bufferImagem(f));
					break;
				case 1:
					
					break;
				case 2:
					img2 = negativoR(bufferImagem(f));
					break;
				case 3:
					img2 = negativoG(bufferImagem(f));
					break;
				case 4:
					img2 = negativoB(bufferImagem(f));
					break;
				}
				paneImg.setImg(img2);
			}
		}
				);


		bAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//aditivo brilho
				if (brilhoA.getText() != "") {
					img2 = brilhoAdd(bufferImagem(f), Integer.parseInt(brilhoA.getText()));
					paneImg.setImg(img2);
				} else {
					img2 = brilhoAdd(bufferImagem(f), 0);
					paneImg.setImg(img2);
				}
			}
		}
				);

		bMult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//multiplicativo brilho
				if (brilhoM.getText() != "") {
					img2 = brilhoMult(bufferImagem(f), Integer.parseInt(brilhoM.getText()));
					paneImg.setImg(img2);
				} else {
					img2 = brilhoMult(bufferImagem(f), 0);
					paneImg.setImg(img2);
				}
			}
		}
				);
		media.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//if (Integer.parseInt(mask.getText()) == 3 || Integer.parseInt(mask.getText()) == 5 || Integer.parseInt(mask.getText()) == 7) {
					img2 = media(bufferImagem(f), Integer.parseInt(mask.getText()));
					paneImg.setImg(img2);
				//} else {
					//JOptionPane.showMessageDialog(null, "Digite um tamanho válido da mascara [3,5,7]");
				//}
			}
		}
				);

		mediana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (Integer.parseInt(mask2.getText()) == 3 || Integer.parseInt(mask2.getText()) == 5){
					img2 = mediana(bufferImagem(f),Integer.parseInt(mask2.getText()));
					paneImg.setImg(img2);
				}else {
					JOptionPane.showMessageDialog(null, "Digite um tamanho válido da mascara [3,5]");
				}
			}
		}
				);

		limiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (threshold.getText() != "") {
					img2 = limiar(bufferImagem(f), Integer.parseInt(threshold.getText()));
					paneImg.setImg(img2);
				} else {
					img2 = limiar(bufferImagem(f), 0);
					paneImg.setImg(img2);
				}
			}
		}
				);

		blend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				img2 = blend(bufferImagem(f));
				paneImg.setImg(img2);
			}
		}
				);

	}

	public  File abrirArquivo() {
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

	public void salvarArquivo(BufferedImage im) {
		fc.setFileHidingEnabled(false);
		fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int i = fc.showSaveDialog(null);

		if (i == JFileChooser.APPROVE_OPTION) {
			String caminho = String.valueOf(fc.getSelectedFile().getAbsolutePath());
			try {
				File novoF = new File(caminho + ".jpg");
				ImageIO.write(im, "JPG", novoF);
				JOptionPane.showMessageDialog(null, "Arquivo salvo");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			JOptionPane.showMessageDialog(null, "Operação cancelada");
		}

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

	public static BufferedImage toGray(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				int r = (int) ((rgb & 0x00FF0000) >>> 16);
				int g = (int) ((rgb & 0x0000FF00) >>> 8);
				int b = (int) (rgb & 0x000000FF);
				int gs = (r + g + b) / 3;
				Color color = new Color(gs, gs, gs);
				image.setRGB(i, j, color.getRGB());
			}
		}
		return image;
	}

	public static BufferedImage red(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				int r = (int) ((rgb & 0x00FF0000) >>> 16);
				int g = 0;
				int b = 0;
				Color color = new Color(r, g, b);
				image.setRGB(i, j, color.getRGB());
			}
		}
		return image;
	}

	public static BufferedImage green(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				int r = 0;
				int g = (int) ((rgb & 0x0000FF00) >>> 8);
				int b = 0;
				Color color = new Color(r, g, b);
				image.setRGB(i, j, color.getRGB());
			}
		}
		return image;
	}

	public static BufferedImage blue(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				int r = 0;
				int g = 0;
				int b = (int) (rgb & 0x000000FF);
				Color color = new Color(r, g, b);
				image.setRGB(i, j, color.getRGB());
			}
		}
		return image;
	}

	public static BufferedImage negativoRGB(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				int r = 255 - (int) ((rgb & 0x00FF0000) >>> 16);
				int g = 255 - (int) ((rgb & 0x0000FF00) >>> 8);
				int b = 255 - (int) (rgb & 0x000000FF);
				Color color = new Color(r, g, b);
				image.setRGB(i, j, color.getRGB());
			}
		}
		return image;
	}

	
	public static BufferedImage negativoR(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				int r = 255 - (int) ((rgb & 0x00FF0000) >>> 16);
				int g = 0;//(int) ((rgb & 0x0000FF00) >>> 8);
				int b = 0;//(int) (rgb & 0x000000FF);
				Color color = new Color(r, g, b);
				image.setRGB(i, j, color.getRGB());
			}
		}
		return image;
	}

	public static BufferedImage negativoG(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				int r = 0;//(int) ((rgb & 0x00FF0000) >>> 16);
				int g = 255 - (int) ((rgb & 0x0000FF00) >>> 8);
				int b = 0;//(int) (rgb & 0x000000FF);
				Color color = new Color(r, g, b);
				image.setRGB(i, j, color.getRGB());
			}
		}
		return image;
	}

	public static BufferedImage negativoB(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				int r = 0;//(int) ((rgb & 0x00FF0000) >>> 16);
				int g = 0;//(int) ((rgb & 0x0000FF00) >>> 8);
				int b = 255 - (int) (rgb & 0x000000FF);
				Color color = new Color(r, g, b);
				image.setRGB(i, j, color.getRGB());
			}
		}
		return image;
	}

	
	public static BufferedImage brilhoAdd(BufferedImage image, int c) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				int r = (int) ((rgb & 0x00FF0000) >>> 16) + c;
				int g = (int) ((rgb & 0x0000FF00) >>> 8) + c;
				int b = (int) (rgb & 0x000000FF) + c;
				if (r > 255) {
					r = 255;
				}
				if (r < 0) {
					r = 0;
				}
				if (g < 0) {
					g = 0;
				}
				if (g > 255) {
					g = 255;
				}
				if (b < 0) {
					b = 0;
				}
				if (b > 255) {
					b = 255;
				}
				Color color = new Color(r, g, b);
				image.setRGB(i, j, color.getRGB());
			}
		}
		return image;
	}

	public static BufferedImage brilhoMult(BufferedImage image, int c) {
		int width = image.getWidth();
		int height = image.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				int rgb = image.getRGB(i, j);
				int r = (int) ((rgb & 0x00FF0000) >>> 16) * c;
				int g = (int) ((rgb & 0x0000FF00) >>> 8) * c;
				int b = (int) (rgb & 0x000000FF) * c;
				if (r > 255) {
					r = 255;
				}
				if (r < 0) {
					r = 0;
				}
				if (g < 0) {
					g = 0;
				}
				if (g > 255) {
					g = 255;
				}
				if (b < 0) {
					b = 0;
				}
				if (b > 255) {
					b = 255;
				}
				Color color = new Color(r, g, b);
				image.setRGB(i, j, color.getRGB());
			}
		}
		return image;
	}

	public static BufferedImage media(BufferedImage image, int n) {
		int r, g, b;
		int width = image.getWidth();
		int height = image.getHeight();
		Color rgb;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				
                            if (!(i == 0 || j == 0 || i == height - 1 || j == width - 1)) {
						r = (new Color(image.getRGB(i - 1, j - 1)).getRed() + new Color(image.getRGB(i - 1, j)).getRed() + new Color(image.getRGB(i - 1, j + 1)).getRed()
								+ new Color(image.getRGB(i, j - 1)).getRed() + new Color(image.getRGB(i, j)).getRed() + new Color(image.getRGB(i, j + 1)).getRed()
								+ new Color(image.getRGB(i + 1, j - 1)).getRed() + new Color(image.getRGB(i + 1, j)).getRed() + new Color(image.getRGB(i + 1, j + 1)).getRed()) / (n*n);

						g = (new Color(image.getRGB(i - 1, j - 1)).getGreen() + new Color(image.getRGB(i - 1, j)).getGreen() + new Color(image.getRGB(i - 1, j + 1)).getGreen()
								+ new Color(image.getRGB(i, j - 1)).getGreen() + new Color(image.getRGB(i, j)).getGreen() + new Color(image.getRGB(i, j + 1)).getGreen()
								+ new Color(image.getRGB(i + 1, j - 1)).getGreen() + new Color(image.getRGB(i + 1, j)).getGreen() + new Color(image.getRGB(i + 1, j + 1)).getGreen()) / (n*n);

						b = (new Color(image.getRGB(i - 1, j - 1)).getBlue() + new Color(image.getRGB(i - 1, j)).getBlue() + new Color(image.getRGB(i - 1, j + 1)).getBlue()
								+ new Color(image.getRGB(i, j - 1)).getBlue() + new Color(image.getRGB(i, j)).getBlue() + new Color(image.getRGB(i, j + 1)).getBlue()
								+ new Color(image.getRGB(i + 1, j - 1)).getBlue() + new Color(image.getRGB(i + 1, j)).getBlue() + new Color(image.getRGB(i + 1, j + 1)).getBlue()) / (n*n);
						rgb = new Color(r, g, b);
						image.setRGB(i, j, rgb.getRGB());

			    }
                            /*switch (n) {
				case 3:
					if (!(i == 0 || j == 0 || i == height - 1 || j == width - 1)) {
						r = (new Color(image.getRGB(i - 1, j - 1)).getRed() + new Color(image.getRGB(i - 1, j)).getRed() + new Color(image.getRGB(i - 1, j + 1)).getRed()
								+ new Color(image.getRGB(i, j - 1)).getRed() + new Color(image.getRGB(i, j)).getRed() + new Color(image.getRGB(i, j + 1)).getRed()
								+ new Color(image.getRGB(i + 1, j - 1)).getRed() + new Color(image.getRGB(i + 1, j)).getRed() + new Color(image.getRGB(i + 1, j + 1)).getRed()) / 9;

						g = (new Color(image.getRGB(i - 1, j - 1)).getGreen() + new Color(image.getRGB(i - 1, j)).getGreen() + new Color(image.getRGB(i - 1, j + 1)).getGreen()
								+ new Color(image.getRGB(i, j - 1)).getGreen() + new Color(image.getRGB(i, j)).getGreen() + new Color(image.getRGB(i, j + 1)).getGreen()
								+ new Color(image.getRGB(i + 1, j - 1)).getGreen() + new Color(image.getRGB(i + 1, j)).getGreen() + new Color(image.getRGB(i + 1, j + 1)).getGreen()) / 9;

						b = (new Color(image.getRGB(i - 1, j - 1)).getBlue() + new Color(image.getRGB(i - 1, j)).getBlue() + new Color(image.getRGB(i - 1, j + 1)).getBlue()
								+ new Color(image.getRGB(i, j - 1)).getBlue() + new Color(image.getRGB(i, j)).getBlue() + new Color(image.getRGB(i, j + 1)).getBlue()
								+ new Color(image.getRGB(i + 1, j - 1)).getBlue() + new Color(image.getRGB(i + 1, j)).getBlue() + new Color(image.getRGB(i + 1, j + 1)).getBlue()) / 9;
						rgb = new Color(r, g, b);
						image.setRGB(i, j, rgb.getRGB());

					}
					break;
				case 5:
					if (!(i <= 1 || j <= 1 || i >= height - 2 || j >= width - 2)) {
						r = (new Color(image.getRGB(i - 2, j - 2)).getRed() + new Color(image.getRGB(i - 2, j - 1)).getRed() + new Color(image.getRGB(i - 2, j)).getRed() + new Color(image.getRGB(i - 2, j + 1)).getRed() + new Color(image.getRGB(i - 2, j + 2)).getRed()
								+ new Color(image.getRGB(i - 1, j - 2)).getRed() + new Color(image.getRGB(i - 1, j - 1)).getRed() + new Color(image.getRGB(i - 1, j)).getRed() + new Color(image.getRGB(i - 1, j + 1)).getRed() + new Color(image.getRGB(i - 1, j + 2)).getRed()
								+ new Color(image.getRGB(i, j - 2)).getRed() + new Color(image.getRGB(i, j - 1)).getRed() + new Color(image.getRGB(i, j)).getRed() + new Color(image.getRGB(i, j + 1)).getRed() + new Color(image.getRGB(i, j + 2)).getRed()
								+ new Color(image.getRGB(i + 1, j - 2)).getRed() + new Color(image.getRGB(i + 1, j - 1)).getRed() + new Color(image.getRGB(i + 1, j)).getRed() + new Color(image.getRGB(i + 1, j + 1)).getRed() + new Color(image.getRGB(i + 1, j + 2)).getRed()
								+ new Color(image.getRGB(i + 2, j - 2)).getRed() + new Color(image.getRGB(i + 2, j - 1)).getRed() + new Color(image.getRGB(i + 2, j)).getRed() + new Color(image.getRGB(i + 2, j + 1)).getRed() + new Color(image.getRGB(i + 2, j + 2)).getRed()) / 25;

						g = (new Color(image.getRGB(i - 2, j - 2)).getGreen() + new Color(image.getRGB(i - 2, j - 1)).getGreen() + new Color(image.getRGB(i - 2, j)).getGreen() + new Color(image.getRGB(i - 2, j + 1)).getGreen() + new Color(image.getRGB(i - 2, j + 2)).getGreen()
								+ new Color(image.getRGB(i - 1, j - 2)).getGreen() + new Color(image.getRGB(i - 1, j - 1)).getGreen() + new Color(image.getRGB(i - 1, j)).getGreen() + new Color(image.getRGB(i - 1, j + 1)).getGreen() + new Color(image.getRGB(i - 1, j + 2)).getGreen()
								+ new Color(image.getRGB(i, j - 2)).getGreen() + new Color(image.getRGB(i, j - 1)).getGreen() + new Color(image.getRGB(i, j)).getGreen() + new Color(image.getRGB(i, j + 1)).getGreen() + new Color(image.getRGB(i, j + 2)).getGreen()
								+ new Color(image.getRGB(i + 1, j - 2)).getGreen() + new Color(image.getRGB(i + 1, j - 1)).getGreen() + new Color(image.getRGB(i + 1, j)).getGreen() + new Color(image.getRGB(i + 1, j + 1)).getGreen() + new Color(image.getRGB(i + 1, j + 2)).getGreen()
								+ new Color(image.getRGB(i + 2, j - 2)).getGreen() + new Color(image.getRGB(i + 2, j - 1)).getGreen() + new Color(image.getRGB(i + 2, j)).getGreen() + new Color(image.getRGB(i + 2, j + 1)).getGreen() + new Color(image.getRGB(i + 2, j + 2)).getGreen()) / 25;

						b = (new Color(image.getRGB(i - 2, j - 2)).getBlue() + new Color(image.getRGB(i - 2, j - 1)).getBlue() + new Color(image.getRGB(i - 2, j)).getBlue() + new Color(image.getRGB(i - 2, j + 1)).getBlue() + new Color(image.getRGB(i - 2, j + 2)).getBlue()
								+ new Color(image.getRGB(i - 1, j - 2)).getBlue() + new Color(image.getRGB(i - 1, j - 1)).getBlue() + new Color(image.getRGB(i - 1, j)).getBlue() + new Color(image.getRGB(i - 1, j + 1)).getBlue() + new Color(image.getRGB(i - 1, j + 2)).getBlue()
								+ new Color(image.getRGB(i, j - 2)).getBlue() + new Color(image.getRGB(i, j - 1)).getBlue() + new Color(image.getRGB(i, j)).getBlue() + new Color(image.getRGB(i, j + 1)).getBlue() + new Color(image.getRGB(i, j + 2)).getBlue()
								+ new Color(image.getRGB(i + 1, j - 2)).getBlue() + new Color(image.getRGB(i + 1, j - 1)).getBlue() + new Color(image.getRGB(i + 1, j)).getBlue() + new Color(image.getRGB(i + 1, j + 1)).getBlue() + new Color(image.getRGB(i + 1, j + 2)).getBlue()
								+ new Color(image.getRGB(i + 2, j - 2)).getBlue() + new Color(image.getRGB(i + 2, j - 1)).getBlue() + new Color(image.getRGB(i + 2, j)).getBlue() + new Color(image.getRGB(i + 2, j + 1)).getBlue() + new Color(image.getRGB(i + 2, j + 2)).getBlue()) / 25;
						rgb = new Color(r, g, b);
						image.setRGB(i, j, rgb.getRGB());
					}
					break;
				case 7:
					if (!(i <= 2 || j <= 2 || i >= height - 3 || j >= width - 3)) {
						r = (new Color(image.getRGB(i - 3, j - 3)).getRed() + new Color(image.getRGB(i - 3, j - 2)).getRed() + new Color(image.getRGB(i - 3, j - 1)).getRed() + new Color(image.getRGB(i - 3, j)).getRed() + new Color(image.getRGB(i - 3, j + 1)).getRed() + new Color(image.getRGB(i - 3, j + 2)).getRed() + new Color(image.getRGB(i - 3, j + 3)).getRed()
								+ new Color(image.getRGB(i - 2, j - 3)).getRed() + new Color(image.getRGB(i - 2, j - 2)).getRed() + new Color(image.getRGB(i - 2, j - 1)).getRed() + new Color(image.getRGB(i - 2, j)).getRed() + new Color(image.getRGB(i - 2, j + 1)).getRed() + new Color(image.getRGB(i - 2, j + 2)).getRed() + new Color(image.getRGB(i - 2, j + 3)).getRed()
								+ new Color(image.getRGB(i - 1, j - 3)).getRed() + new Color(image.getRGB(i - 1, j - 2)).getRed() + new Color(image.getRGB(i - 1, j - 1)).getRed() + new Color(image.getRGB(i - 1, j)).getRed() + new Color(image.getRGB(i - 1, j + 1)).getRed() + new Color(image.getRGB(i - 1, j + 2)).getRed() + new Color(image.getRGB(i - 1, j + 3)).getRed()
								+ new Color(image.getRGB(i, j - 3)).getRed() + new Color(image.getRGB(i - 1, j - 2)).getRed() + new Color(image.getRGB(i, j - 1)).getRed() + new Color(image.getRGB(i, j)).getRed() + new Color(image.getRGB(i, j + 1)).getRed() + new Color(image.getRGB(i, j + 2)).getRed() + new Color(image.getRGB(i, j + 3)).getRed()
								+ new Color(image.getRGB(i + 1, j - 3)).getRed() + new Color(image.getRGB(i + 1, j - 2)).getRed() + new Color(image.getRGB(i + 1, j - 1)).getRed() + new Color(image.getRGB(i + 1, j)).getRed() + new Color(image.getRGB(i + 1, j + 1)).getRed() + new Color(image.getRGB(i + 1, j + 2)).getRed() + new Color(image.getRGB(i + 1, j + 3)).getRed()
								+ new Color(image.getRGB(i + 2, j - 3)).getRed() + new Color(image.getRGB(i + 2, j - 2)).getRed() + new Color(image.getRGB(i + 2, j - 1)).getRed() + new Color(image.getRGB(i + 2, j)).getRed() + new Color(image.getRGB(i + 2, j + 1)).getRed() + new Color(image.getRGB(i + 2, j + 2)).getRed() + new Color(image.getRGB(i + 2, j + 3)).getRed()
								+ new Color(image.getRGB(i + 3, j - 3)).getRed() + new Color(image.getRGB(i + 3, j - 2)).getRed() + new Color(image.getRGB(i + 3, j - 1)).getRed() + new Color(image.getRGB(i + 3, j)).getRed() + new Color(image.getRGB(i + 3, j + 1)).getRed() + new Color(image.getRGB(i + 3, j + 2)).getRed() + new Color(image.getRGB(i + 3, j + 3)).getRed()) / 49;

						g = (new Color(image.getRGB(i - 3, j - 3)).getGreen() + new Color(image.getRGB(i - 3, j - 2)).getGreen() + new Color(image.getRGB(i - 3, j - 1)).getGreen() + new Color(image.getRGB(i - 3, j)).getGreen() + new Color(image.getRGB(i - 3, j + 1)).getGreen() + new Color(image.getRGB(i - 3, j + 2)).getGreen() + new Color(image.getRGB(i - 3, j + 3)).getGreen()
								+ new Color(image.getRGB(i - 2, j - 3)).getGreen() + new Color(image.getRGB(i - 2, j - 2)).getGreen() + new Color(image.getRGB(i - 2, j - 1)).getGreen() + new Color(image.getRGB(i - 2, j)).getGreen() + new Color(image.getRGB(i - 2, j + 1)).getGreen() + new Color(image.getRGB(i - 2, j + 2)).getGreen() + new Color(image.getRGB(i - 2, j + 3)).getGreen()
								+ new Color(image.getRGB(i - 1, j - 3)).getGreen() + new Color(image.getRGB(i - 1, j - 2)).getGreen() + new Color(image.getRGB(i - 1, j - 1)).getGreen() + new Color(image.getRGB(i - 1, j)).getGreen() + new Color(image.getRGB(i - 1, j + 1)).getGreen() + new Color(image.getRGB(i - 1, j + 2)).getGreen() + new Color(image.getRGB(i - 1, j + 3)).getGreen()
								+ new Color(image.getRGB(i, j - 3)).getGreen() + new Color(image.getRGB(i - 1, j - 2)).getGreen() + new Color(image.getRGB(i, j - 1)).getGreen() + new Color(image.getRGB(i, j)).getGreen() + new Color(image.getRGB(i, j + 1)).getGreen() + new Color(image.getRGB(i, j + 2)).getGreen() + new Color(image.getRGB(i, j + 3)).getGreen()
								+ new Color(image.getRGB(i + 1, j - 3)).getGreen() + new Color(image.getRGB(i + 1, j - 2)).getGreen() + new Color(image.getRGB(i + 1, j - 1)).getGreen() + new Color(image.getRGB(i + 1, j)).getGreen() + new Color(image.getRGB(i + 1, j + 1)).getGreen() + new Color(image.getRGB(i + 1, j + 2)).getGreen() + new Color(image.getRGB(i + 1, j + 3)).getGreen()
								+ new Color(image.getRGB(i + 2, j - 3)).getGreen() + new Color(image.getRGB(i + 2, j - 2)).getGreen() + new Color(image.getRGB(i + 2, j - 1)).getGreen() + new Color(image.getRGB(i + 2, j)).getGreen() + new Color(image.getRGB(i + 2, j + 1)).getGreen() + new Color(image.getRGB(i + 2, j + 2)).getGreen() + new Color(image.getRGB(i + 2, j + 3)).getGreen()
								+ new Color(image.getRGB(i + 3, j - 3)).getGreen() + new Color(image.getRGB(i + 3, j - 2)).getGreen() + new Color(image.getRGB(i + 3, j - 1)).getGreen() + new Color(image.getRGB(i + 3, j)).getGreen() + new Color(image.getRGB(i + 3, j + 1)).getGreen() + new Color(image.getRGB(i + 3, j + 2)).getGreen() + new Color(image.getRGB(i + 3, j + 3)).getGreen()) / 49;

						b = (new Color(image.getRGB(i - 3, j - 3)).getBlue() + new Color(image.getRGB(i - 3, j - 2)).getBlue() + new Color(image.getRGB(i - 3, j - 1)).getBlue() + new Color(image.getRGB(i - 3, j)).getBlue() + new Color(image.getRGB(i - 3, j + 1)).getBlue() + new Color(image.getRGB(i - 3, j + 2)).getBlue() + new Color(image.getRGB(i - 3, j + 3)).getBlue()
								+ new Color(image.getRGB(i - 2, j - 3)).getBlue() + new Color(image.getRGB(i - 2, j - 2)).getBlue() + new Color(image.getRGB(i - 2, j - 1)).getBlue() + new Color(image.getRGB(i - 2, j)).getBlue() + new Color(image.getRGB(i - 2, j + 1)).getBlue() + new Color(image.getRGB(i - 2, j + 2)).getBlue() + new Color(image.getRGB(i - 2, j + 3)).getBlue()
								+ new Color(image.getRGB(i - 1, j - 3)).getBlue() + new Color(image.getRGB(i - 1, j - 2)).getBlue() + new Color(image.getRGB(i - 1, j - 1)).getBlue() + new Color(image.getRGB(i - 1, j)).getBlue() + new Color(image.getRGB(i - 1, j + 1)).getBlue() + new Color(image.getRGB(i - 1, j + 2)).getBlue() + new Color(image.getRGB(i - 1, j + 3)).getBlue()
								+ new Color(image.getRGB(i, j - 3)).getBlue() + new Color(image.getRGB(i - 1, j - 2)).getBlue() + new Color(image.getRGB(i, j - 1)).getBlue() + new Color(image.getRGB(i, j)).getBlue() + new Color(image.getRGB(i, j + 1)).getBlue() + new Color(image.getRGB(i, j + 2)).getBlue() + new Color(image.getRGB(i, j + 3)).getBlue()
								+ new Color(image.getRGB(i + 1, j - 3)).getBlue() + new Color(image.getRGB(i + 1, j - 2)).getBlue() + new Color(image.getRGB(i + 1, j - 1)).getBlue() + new Color(image.getRGB(i + 1, j)).getBlue() + new Color(image.getRGB(i + 1, j + 1)).getBlue() + new Color(image.getRGB(i + 1, j + 2)).getBlue() + new Color(image.getRGB(i + 1, j + 3)).getBlue()
								+ new Color(image.getRGB(i + 2, j - 3)).getBlue() + new Color(image.getRGB(i + 2, j - 2)).getBlue() + new Color(image.getRGB(i + 2, j - 1)).getBlue() + new Color(image.getRGB(i + 2, j)).getBlue() + new Color(image.getRGB(i + 2, j + 1)).getBlue() + new Color(image.getRGB(i + 2, j + 2)).getBlue() + new Color(image.getRGB(i + 2, j + 3)).getBlue()
								+ new Color(image.getRGB(i + 3, j - 3)).getBlue() + new Color(image.getRGB(i + 3, j - 2)).getBlue() + new Color(image.getRGB(i + 3, j - 1)).getBlue() + new Color(image.getRGB(i + 3, j)).getBlue() + new Color(image.getRGB(i + 3, j + 1)).getBlue() + new Color(image.getRGB(i + 3, j + 2)).getBlue() + new Color(image.getRGB(i + 3, j + 3)).getBlue()) / 49;

						rgb = new Color(r, g, b);
						image.setRGB(i, j, rgb.getRGB());
					}
					break;
				}*/
			}
		}
		return image;
	}

	public static BufferedImage mediana(BufferedImage image, int n) {
		int width = image.getWidth();
		int height = image.getHeight();
		Color rgb;
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				switch (n) { 
				case 3:
					if (!(i == 0 || j == 0 || i == height - 1 || j == width - 1)) {
						int[] rHue = {new Color(image.getRGB(i - 1, j - 1)).getRed(), new Color(image.getRGB(i - 1, j)).getRed(), new Color(image.getRGB(i - 1, j + 1)).getRed(),
								new Color(image.getRGB(i, j - 1)).getRed(), new Color(image.getRGB(i, j)).getRed(), new Color(image.getRGB(i, j + 1)).getRed(),
								new Color(image.getRGB(i + 1, j - 1)).getRed(), new Color(image.getRGB(i + 1, j)).getRed(), new Color(image.getRGB(i + 1, j + 1)).getRed()};
						int[] gHue = {new Color(image.getRGB(i - 1, j - 1)).getGreen(), new Color(image.getRGB(i - 1, j)).getGreen(), new Color(image.getRGB(i - 1, j + 1)).getGreen(),
								new Color(image.getRGB(i, j - 1)).getGreen(), new Color(image.getRGB(i, j)).getGreen(), new Color(image.getRGB(i, j + 1)).getGreen(),
								new Color(image.getRGB(i + 1, j - 1)).getGreen(), new Color(image.getRGB(i + 1, j)).getGreen(), new Color(image.getRGB(i + 1, j + 1)).getGreen()};
						int[] bHue = {new Color(image.getRGB(i - 1, j - 1)).getBlue(), new Color(image.getRGB(i - 1, j)).getBlue(), new Color(image.getRGB(i - 1, j + 1)).getBlue(),
								new Color(image.getRGB(i, j - 1)).getBlue(), new Color(image.getRGB(i, j)).getBlue(), new Color(image.getRGB(i, j + 1)).getBlue(),
								new Color(image.getRGB(i + 1, j - 1)).getBlue(), new Color(image.getRGB(i + 1, j)).getBlue(), new Color(image.getRGB(i + 1, j + 1)).getBlue()};

						Arrays.sort(rHue);
						Arrays.sort(gHue);
						Arrays.sort(bHue);

						rgb = new Color(rHue[4], gHue[4], bHue[4]);
						image.setRGB(i, j, rgb.getRGB());
					}
					break;
				case 5:
					if (!(i <= 1 || j <= 1 || i >= height - 2 || j >= width - 2)) {
						int[] rHue = {new Color(image.getRGB(i - 2, j - 2)).getRed(), new Color(image.getRGB(i - 2, j-1)).getRed(), new Color(image.getRGB(i - 2, j)).getRed(), new Color(image.getRGB(i - 2, j+1)).getRed(), new Color(image.getRGB(i - 2, j + 2)).getRed(),
								new Color(image.getRGB(i-1, j - 2)).getRed(), new Color(image.getRGB(i-1, j-1)).getRed(), new Color(image.getRGB(i-1, j)).getRed(), new Color(image.getRGB(i - 1, j+1)).getRed(), new Color(image.getRGB(i - 1, j + 2)).getRed(),
								new Color(image.getRGB(i, j - 2)).getRed(), new Color(image.getRGB(i, j-1)).getRed(), new Color(image.getRGB(i, j)).getRed(), new Color(image.getRGB(i, j+1)).getRed(), new Color(image.getRGB(i, j + 2)).getRed(), 
								new Color(image.getRGB(i+1, j - 2)).getRed(), new Color(image.getRGB(i+1, j-1)).getRed(), new Color(image.getRGB(i+1, j)).getRed(),new Color(image.getRGB(i + 1, j+1)).getRed(), new Color(image.getRGB(i + 1, j + 2)).getRed(),
								new Color(image.getRGB(i + 2, j - 2)).getRed(), new Color(image.getRGB(i + 2, j-1)).getRed(), new Color(image.getRGB(i + 2, j)).getRed(), new Color(image.getRGB(i +2, j+1)).getRed(), new Color(image.getRGB(i +2, j + 2)).getRed()
						};
						int[] gHue = {new Color(image.getRGB(i - 2, j - 2)).getGreen(), new Color(image.getRGB(i - 2, j-1)).getGreen(), new Color(image.getRGB(i - 2, j)).getGreen(), new Color(image.getRGB(i - 2, j+1)).getGreen(), new Color(image.getRGB(i - 2, j + 2)).getGreen(),
								new Color(image.getRGB(i-1, j - 2)).getGreen(), new Color(image.getRGB(i-1, j-1)).getGreen(), new Color(image.getRGB(i-1, j)).getGreen(), new Color(image.getRGB(i - 1, j+1)).getGreen(), new Color(image.getRGB(i - 1, j + 2)).getGreen(),
								new Color(image.getRGB(i, j - 2)).getGreen(), new Color(image.getRGB(i, j-1)).getGreen(), new Color(image.getRGB(i, j)).getGreen(), new Color(image.getRGB(i, j+1)).getGreen(), new Color(image.getRGB(i, j + 2)).getGreen(), 
								new Color(image.getRGB(i+1, j - 2)).getGreen(), new Color(image.getRGB(i+1, j-1)).getGreen(), new Color(image.getRGB(i+1, j)).getGreen(),new Color(image.getRGB(i + 1, j+1)).getGreen(), new Color(image.getRGB(i + 1, j + 2)).getGreen(),
								new Color(image.getRGB(i + 2, j - 2)).getGreen(), new Color(image.getRGB(i + 2, j-1)).getGreen(), new Color(image.getRGB(i + 2, j)).getGreen(), new Color(image.getRGB(i +2, j+1)).getGreen(), new Color(image.getRGB(i +2, j + 2)).getGreen()
						};
						int[] bHue = {new Color(image.getRGB(i - 2, j - 2)).getBlue(), new Color(image.getRGB(i - 2, j-1)).getBlue(), new Color(image.getRGB(i - 2, j)).getBlue(), new Color(image.getRGB(i - 2, j+1)).getBlue(), new Color(image.getRGB(i - 2, j + 2)).getBlue(),
								new Color(image.getRGB(i-1, j - 2)).getBlue(), new Color(image.getRGB(i-1, j-1)).getBlue(), new Color(image.getRGB(i-1, j)).getBlue(), new Color(image.getRGB(i - 1, j+1)).getBlue(), new Color(image.getRGB(i - 1, j + 2)).getBlue(),
								new Color(image.getRGB(i, j - 2)).getBlue(), new Color(image.getRGB(i, j-1)).getBlue(), new Color(image.getRGB(i, j)).getBlue(), new Color(image.getRGB(i, j+1)).getBlue(), new Color(image.getRGB(i, j + 2)).getBlue(), 
								new Color(image.getRGB(i+1, j - 2)).getBlue(), new Color(image.getRGB(i+1, j-1)).getBlue(), new Color(image.getRGB(i+1, j)).getBlue(),new Color(image.getRGB(i + 1, j+1)).getBlue(), new Color(image.getRGB(i + 1, j + 2)).getBlue(),
								new Color(image.getRGB(i + 2, j - 2)).getBlue(), new Color(image.getRGB(i + 2, j-1)).getBlue(), new Color(image.getRGB(i + 2, j)).getBlue(), new Color(image.getRGB(i +2, j+1)).getBlue(), new Color(image.getRGB(i +2, j + 2)).getBlue()
						};

						Arrays.sort(rHue);
						Arrays.sort(gHue);
						Arrays.sort(bHue);
						//						for(int t = 0; t < 25; t++){
						//							System.out.print(rHue[t]+", "); if (t==24) System.out.println("\n");}

						rgb = new Color(rHue[12], gHue[12], bHue[12]);
						image.setRGB(i, j, rgb.getRGB());
					}
					break;
				}
			}
		}
		return image;
	}

	public static BufferedImage limiar(BufferedImage image, int t) {
		int width = image.getWidth();
		int height = image.getHeight();
		Color rgb;
		int l;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				rgb = new Color(image.getRGB(i, j));
				l = (rgb.getRed() + rgb.getGreen() + rgb.getBlue()) / 3;
				if (l > t) {
					image.setRGB(i, j, 0xffffff);
				} else {
					image.setRGB(i, j, 0x000000);
				}
			}
		}
		return image;
	}

	public BufferedImage blend(BufferedImage img) {
		f2 = abrirArquivo();
		BufferedImage imgBlend = bufferImagem(f2);
		if (img.getWidth() != imgBlend.getWidth() || img.getHeight() != imgBlend.getHeight()) {
			JOptionPane.showMessageDialog(Projeto1PDI.getFrames()[0], "Selecione imagens de mesmas dimensões. Abra novamente a imagem", "ERROR", JOptionPane.ERROR_MESSAGE, null);
			return null;
		}
		Color rgb, rgb2, rgbBlend;
		int width = img.getWidth();
		int height = img.getHeight();
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				rgb = new Color(img.getRGB(i, j));
				rgb2 = new Color(imgBlend.getRGB(i, j));

				int r = (rgb.getRed() + rgb2.getRed()) / 2;
				int g = (rgb.getGreen() + rgb2.getGreen()) / 2;
				int b = (rgb.getBlue() + rgb2.getBlue()) / 2;

				rgbBlend = new Color(r, g, b);
				img.setRGB(i, j, rgbBlend.getRGB());
			}
		}
		return img;
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