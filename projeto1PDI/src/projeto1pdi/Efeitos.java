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
                Color c = new Color(image.getRGB(i, j));
                int tomCinza = (c.getRed()+c.getGreen()+c.getBlue())/3;
                c = new Color(tomCinza, tomCinza, tomCinza);
                image.setRGB(i, j, c.getRGB());
            }
        }
        return image;
    }

    public static BufferedImage red(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(image.getRGB(i, j));
                int r = c.getRed();
                c = new Color(r, 0, 0);
                image.setRGB(i, j, c.getRGB());
            }
        }
        return image;
    }

    public static BufferedImage green(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(image.getRGB(i, j));
                int g = c.getGreen();
                c= new Color(0, g, 0);
                image.setRGB(i, j, c.getRGB());
            }
        }
        return image;
    }

    public static BufferedImage blue(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(image.getRGB(i, j));
                int b = c.getBlue();
                c= new Color(0, 0, b);
                image.setRGB(i, j, c.getRGB());
            }
        }
        return image;
    }

    public static BufferedImage negativoRGB(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(image.getRGB(i, j));
                int r = 255 - c.getRed();
                int g = 255 - c.getGreen();
                int b = 255 - c.getBlue();
                Color color = new Color(r, g, b);
                image.setRGB(i, j, color.getRGB());
            }
        }
        return image;
    }
    
    static void rgbToyiq(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        float yiq[] = new float[3];
        int rgb[] = new int[3];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(image.getRGB(i, j));
                rgb[0] = c.getRed();
                rgb[1] = c.getGreen();
                rgb[2] = c.getBlue();
                //RGB para YIQ
                yiq = rgbTOyiq(rgb);
                //YIQ para RGB
                rgb = yiqTOrgb(yiq);             
                Color color = new Color(rgb[0], rgb[1], rgb[2]);
                image.setRGB(i, j, color.getRGB());
            }
        }        
    }    
    
    public static float[] rgbTOyiq(int rgb[]){
        float yiq[] = new float[3];
        yiq[0] = 0.299f*rgb[0] + 0.587f*rgb[1] + 0.114f*rgb[2];
        yiq[1] = 0.596f*rgb[0] - 0.274f*rgb[1] - 0.322f*rgb[2];
        yiq[2] = 0.211f*rgb[0] - 0.523f*rgb[1] + 0.312f*rgb[2];        
        return yiq;
    }
    
    public static int[] yiqTOrgb(float[] yiq){
        int rgb[] = new int[3];
        rgb[0] = Math.round(yiq[0] + 0.956f*yiq[1] + 0.621f*yiq[2]) > 255 ? 255 : Math.round(yiq[0] + 0.956f*yiq[1] + 0.621f*yiq[2]) < 0 ? 0 : Math.round(yiq[0] + 0.956f*yiq[1] + 0.621f*yiq[2]);
        rgb[1] = Math.round(yiq[0] - 0.272f*yiq[1] - 0.647f*yiq[2]) > 255 ? 255 : Math.round(yiq[0] - 0.272f*yiq[1] - 0.647f*yiq[2]) < 0 ? 0 : Math.round(yiq[0] - 0.272f*yiq[1] - 0.647f*yiq[2]);
        rgb[2] = Math.round(yiq[0] - 1.106f*yiq[1] + 1.703f*yiq[2]) > 255 ? 255 : Math.round(yiq[0] - 1.106f*yiq[1] + 1.703f*yiq[2]) < 0 ? 0 : Math.round(yiq[0] - 1.106f*yiq[1] + 1.703f*yiq[2]);
        return rgb;
    }

    public static BufferedImage negativoR(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color c = new Color(image.getRGB(i, j));
                int r = 255 - c.getRed();
                Color color = new Color(r, 0, 0);
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
                Color c = new Color(image.getRGB(i, j));
                int g = 255 - c.getGreen();
                Color color = new Color(0, g, 0);
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
                Color c = new Color(image.getRGB(i, j));
                int b = 255 - c.getBlue();
                Color color = new Color(0, 0, b);
                image.setRGB(i, j, color.getRGB());
            }
        }
        return image;
    }

    public static void brilhoAdd(BufferedImage image, int c) {
        int width = image.getWidth();
        int height = image.getHeight();
        float yiq[] = new float[3];
        int rgb[] = new int[3];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color cor = new Color(image.getRGB(i, j));
                rgb[0] = cor.getRed();
                rgb[1] = cor.getGreen();
                rgb[2] = cor.getBlue();                
                yiq = rgbTOyiq(rgb); //converte para o sistema yiq, para manipular apenas o brilho
                yiq[0] += c; //Altera o brilho no sistema yiq                
                rgb = yiqTOrgb(yiq); //converte para o sistema rgb               
                cor = new Color(rgb[0], rgb[1], rgb[2]);
                image.setRGB(i, j, cor.getRGB());
            }
        }
    }

    public static void brilhoMult(BufferedImage image, int c) {
        int width = image.getWidth();
        int height = image.getHeight();
        float yiq[] = new float[3];
        int rgb[] = new int[3];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                Color cor = new Color(image.getRGB(i, j));
                rgb[0] = cor.getRed();
                rgb[1] = cor.getGreen();
                rgb[2] = cor.getBlue();                
                yiq = rgbTOyiq(rgb); //converte para o sistema yiq, para manipular apenas o brilho
                yiq[0] *= c; //Altera o brilho no sistema yiq                
                rgb = yiqTOrgb(yiq); //converte para o sistema rgb               
                cor = new Color(rgb[0], rgb[1], rgb[2]);
                image.setRGB(i, j, cor.getRGB());
            }
        }
    }

    public static void media(BufferedImage image, int n) {
        int width = image.getWidth(); //Largura da imagem
        int height = image.getHeight(); //Altura da imagem
        int r, g, b, //Componentes de cor
            i2=0, j2=0; //Variáveis auxiliares, servem para varrer o pixel central e seus vizinhos
        Color rgb; //Cor a ser setada na imagem

        //Varre a imagem inteira
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //A cada pixel visitado, zera os elementos de cor para não usar lixo da iteração anterior
                r = g = b = 0;
                //Varre o elemento do meio e seus vizinhos
                for(i2=i-(n/2); i2 <= i+(n/2); i2++){
                    for(j2=j-(n/2); j2 <= j+(n/2); j2++){
                        //Se algum dos vizinhos estiver fora dos limites da imagem, suas componentes adicionarão 0, ou simplemente não haverá processamento
                        try{
                            r += new Color(image.getRGB(i2, j2)).getRed();
                            g += new Color(image.getRGB(i2, j2)).getGreen();
                            b += new Color(image.getRGB(i2, j2)).getBlue();
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            //r += 0; g += 0; b += 0; // Processamento desnecessário
                        }
                    }
                }           
                r /= (n*n); g /= (n*n); b /= (n*n); //Após a soma, calcula-se a média
                rgb = new Color(r, g, b);
                image.setRGB(i, j, rgb.getRGB()); //Insere a cor no pixel do meio
            }
        }
    }

    public static void mediana(BufferedImage image, int n) {
        int width = image.getWidth(); //Largura da imagem
        int height = image.getHeight(); //Altura da imagem
        int r[] = new int[n*n], g[] = new int[n*n], b[] = new int[n*n], //Vetores com tamanho nxn que guardarão as componentes r, g e b a cada iteração
            i2=0, j2=0, cont; //Variáveis auxiliares, servem para varrer o pixel central e seus vizinhos
        Color rgb; //Cor a ser setada na imagem

        //Varre a imagem inteira
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                //A cada pixel visitado, zera o contador para poder visitá-lo, visitar seus vizinhos e em seguida calcular a mediana
                cont = 0;                 
                //Varre o elemento do meio e seus vizinhos
                for(i2=i-(n/2); i2 <= i+(n/2); i2++){
                    for(j2=j-(n/2); j2 <= j+(n/2); j2++){
                        //Se algum dos vizinhos estiver fora dos limites da imagem, seu pixel receberá 0 para r, g e b
                        try{
                            r[cont] = new Color(image.getRGB(i2, j2)).getRed();
                            g[cont] = new Color(image.getRGB(i2, j2)).getGreen();
                            b[cont] = new Color(image.getRGB(i2, j2)).getBlue();
                            cont++;
                        }
                        catch(ArrayIndexOutOfBoundsException e){
                            r[cont] = g[cont] = b[cont] = 0;
                        }
                    }
                }           
                Arrays.sort(r); Arrays.sort(g); Arrays.sort(b); //Ordena o vetor com o pixel e seus vizinhos
                rgb = new Color(r[r.length/2], g[g.length/2], b[b.length/2]); //Calcula a mediana para cada componente e atribui a cor
                image.setRGB(i, j, rgb.getRGB()); //Insere a cor no pixel do meio
            }
        }
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
