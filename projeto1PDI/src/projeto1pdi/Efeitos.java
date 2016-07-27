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
        int width = image.getWidth();
        int height = image.getHeight();
        int r, g, b, i2=0, j2=0;
        Color rgb;

        for (int i = 0; i < width-n; i++) {
            for (int j = 0; j < height-n; j++) {
                r = g = b = 0;
                //Bloco com dimensão nxn, em que o pixel do meio será alterado de acordo com a média
                for(i2=i; i2 < i+n; i2++){
                    for(j2=j; j2 < j+n; j2++){
                        r += new Color(image.getRGB(i2, j2)).getRed();
                        g += new Color(image.getRGB(i2, j2)).getGreen();
                        b += new Color(image.getRGB(i2, j2)).getBlue();
                    }
                }           
                r /= (n*n); g /= (n*n); b /= (n*n); //Após a soma, calcula-se a média
                rgb = new Color(r, g, b);
                image.setRGB(i2-(n/2)-1, j2-(n/2)-1, rgb.getRGB()); //Insere a cor no pixel do meio
            }
        }
        return image;
    }

    public static BufferedImage mediana(BufferedImage image, int n) {
        int width = image.getWidth();
        int height = image.getHeight();
        int r[] = new int[n*n], g[] = new int[n*n], b[] = new int[n*n], i2=0, j2=0, cont;
        Color rgb;

        for (int i = 0; i < width-n; i++) {
            for (int j = 0; j < height-n; j++) {
                //Bloco com dimensão nxn, em que o pixel do meio será alterado de acordo com a média
                cont = 0;
                for(i2=i; i2 < i+n; i2++){
                    for(j2=j; j2 < j+n; j2++){
                        r[cont] = new Color(image.getRGB(i2, j2)).getRed();
                        g[cont] = new Color(image.getRGB(i2, j2)).getGreen();
                        b[cont] = new Color(image.getRGB(i2, j2)).getBlue();
                        cont++;
                    }
                }           
                Arrays.sort(r); Arrays.sort(g); Arrays.sort(b);
                rgb = new Color(r[r.length/2], g[g.length/2], b[b.length/2]);
                image.setRGB(i2-(n/2)-1, j2-(n/2)-1, rgb.getRGB()); //Insere a cor no pixel do meio
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
