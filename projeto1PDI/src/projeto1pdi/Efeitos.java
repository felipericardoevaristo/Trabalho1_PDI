package projeto1pdi;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class Efeitos {

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
                            + new Color(image.getRGB(i + 1, j - 1)).getRed() + new Color(image.getRGB(i + 1, j)).getRed() + new Color(image.getRGB(i + 1, j + 1)).getRed()) / (n * n);

                    g = (new Color(image.getRGB(i - 1, j - 1)).getGreen() + new Color(image.getRGB(i - 1, j)).getGreen() + new Color(image.getRGB(i - 1, j + 1)).getGreen()
                            + new Color(image.getRGB(i, j - 1)).getGreen() + new Color(image.getRGB(i, j)).getGreen() + new Color(image.getRGB(i, j + 1)).getGreen()
                            + new Color(image.getRGB(i + 1, j - 1)).getGreen() + new Color(image.getRGB(i + 1, j)).getGreen() + new Color(image.getRGB(i + 1, j + 1)).getGreen()) / (n * n);

                    b = (new Color(image.getRGB(i - 1, j - 1)).getBlue() + new Color(image.getRGB(i - 1, j)).getBlue() + new Color(image.getRGB(i - 1, j + 1)).getBlue()
                            + new Color(image.getRGB(i, j - 1)).getBlue() + new Color(image.getRGB(i, j)).getBlue() + new Color(image.getRGB(i, j + 1)).getBlue()
                            + new Color(image.getRGB(i + 1, j - 1)).getBlue() + new Color(image.getRGB(i + 1, j)).getBlue() + new Color(image.getRGB(i + 1, j + 1)).getBlue()) / (n * n);
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
                            int[] rHue = {new Color(image.getRGB(i - 2, j - 2)).getRed(), new Color(image.getRGB(i - 2, j - 1)).getRed(), new Color(image.getRGB(i - 2, j)).getRed(), new Color(image.getRGB(i - 2, j + 1)).getRed(), new Color(image.getRGB(i - 2, j + 2)).getRed(),
                                new Color(image.getRGB(i - 1, j - 2)).getRed(), new Color(image.getRGB(i - 1, j - 1)).getRed(), new Color(image.getRGB(i - 1, j)).getRed(), new Color(image.getRGB(i - 1, j + 1)).getRed(), new Color(image.getRGB(i - 1, j + 2)).getRed(),
                                new Color(image.getRGB(i, j - 2)).getRed(), new Color(image.getRGB(i, j - 1)).getRed(), new Color(image.getRGB(i, j)).getRed(), new Color(image.getRGB(i, j + 1)).getRed(), new Color(image.getRGB(i, j + 2)).getRed(),
                                new Color(image.getRGB(i + 1, j - 2)).getRed(), new Color(image.getRGB(i + 1, j - 1)).getRed(), new Color(image.getRGB(i + 1, j)).getRed(), new Color(image.getRGB(i + 1, j + 1)).getRed(), new Color(image.getRGB(i + 1, j + 2)).getRed(),
                                new Color(image.getRGB(i + 2, j - 2)).getRed(), new Color(image.getRGB(i + 2, j - 1)).getRed(), new Color(image.getRGB(i + 2, j)).getRed(), new Color(image.getRGB(i + 2, j + 1)).getRed(), new Color(image.getRGB(i + 2, j + 2)).getRed()
                            };
                            int[] gHue = {new Color(image.getRGB(i - 2, j - 2)).getGreen(), new Color(image.getRGB(i - 2, j - 1)).getGreen(), new Color(image.getRGB(i - 2, j)).getGreen(), new Color(image.getRGB(i - 2, j + 1)).getGreen(), new Color(image.getRGB(i - 2, j + 2)).getGreen(),
                                new Color(image.getRGB(i - 1, j - 2)).getGreen(), new Color(image.getRGB(i - 1, j - 1)).getGreen(), new Color(image.getRGB(i - 1, j)).getGreen(), new Color(image.getRGB(i - 1, j + 1)).getGreen(), new Color(image.getRGB(i - 1, j + 2)).getGreen(),
                                new Color(image.getRGB(i, j - 2)).getGreen(), new Color(image.getRGB(i, j - 1)).getGreen(), new Color(image.getRGB(i, j)).getGreen(), new Color(image.getRGB(i, j + 1)).getGreen(), new Color(image.getRGB(i, j + 2)).getGreen(),
                                new Color(image.getRGB(i + 1, j - 2)).getGreen(), new Color(image.getRGB(i + 1, j - 1)).getGreen(), new Color(image.getRGB(i + 1, j)).getGreen(), new Color(image.getRGB(i + 1, j + 1)).getGreen(), new Color(image.getRGB(i + 1, j + 2)).getGreen(),
                                new Color(image.getRGB(i + 2, j - 2)).getGreen(), new Color(image.getRGB(i + 2, j - 1)).getGreen(), new Color(image.getRGB(i + 2, j)).getGreen(), new Color(image.getRGB(i + 2, j + 1)).getGreen(), new Color(image.getRGB(i + 2, j + 2)).getGreen()
                            };
                            int[] bHue = {new Color(image.getRGB(i - 2, j - 2)).getBlue(), new Color(image.getRGB(i - 2, j - 1)).getBlue(), new Color(image.getRGB(i - 2, j)).getBlue(), new Color(image.getRGB(i - 2, j + 1)).getBlue(), new Color(image.getRGB(i - 2, j + 2)).getBlue(),
                                new Color(image.getRGB(i - 1, j - 2)).getBlue(), new Color(image.getRGB(i - 1, j - 1)).getBlue(), new Color(image.getRGB(i - 1, j)).getBlue(), new Color(image.getRGB(i - 1, j + 1)).getBlue(), new Color(image.getRGB(i - 1, j + 2)).getBlue(),
                                new Color(image.getRGB(i, j - 2)).getBlue(), new Color(image.getRGB(i, j - 1)).getBlue(), new Color(image.getRGB(i, j)).getBlue(), new Color(image.getRGB(i, j + 1)).getBlue(), new Color(image.getRGB(i, j + 2)).getBlue(),
                                new Color(image.getRGB(i + 1, j - 2)).getBlue(), new Color(image.getRGB(i + 1, j - 1)).getBlue(), new Color(image.getRGB(i + 1, j)).getBlue(), new Color(image.getRGB(i + 1, j + 1)).getBlue(), new Color(image.getRGB(i + 1, j + 2)).getBlue(),
                                new Color(image.getRGB(i + 2, j - 2)).getBlue(), new Color(image.getRGB(i + 2, j - 1)).getBlue(), new Color(image.getRGB(i + 2, j)).getBlue(), new Color(image.getRGB(i + 2, j + 1)).getBlue(), new Color(image.getRGB(i + 2, j + 2)).getBlue()
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

    public static BufferedImage blend(BufferedImage img, BufferedImage img2) {
        
        if (img.getWidth() != img2.getWidth() || img.getHeight() != img2.getHeight()) {
            JOptionPane.showMessageDialog(Projeto1PDI.getFrames()[0], "Selecione imagens de mesmas dimensões. Abra novamente a imagem", "ERROR", JOptionPane.ERROR_MESSAGE, null);
            return null;
        }
        Color rgb, rgb2, rgbBlend;
        int width = img.getWidth();
        int height = img.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                rgb = new Color(img.getRGB(i, j));
                rgb2 = new Color(img2.getRGB(i, j));

                int r = (rgb.getRed() + rgb2.getRed()) / 2;
                int g = (rgb.getGreen() + rgb2.getGreen()) / 2;
                int b = (rgb.getBlue() + rgb2.getBlue()) / 2;

                rgbBlend = new Color(r, g, b);
                img.setRGB(i, j, rgbBlend.getRGB());
            }
        }
        return img;
    }

}
