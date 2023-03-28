import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;
import java.net.URL;

import javax.imageio.ImageIO;

public class GeraFigurinha {
  public void cria() throws Exception {
    InputStream inputStream = new URL(
        "https://m.media-amazon.com/images/M/MV5BMDFkYTc0MGEtZmNhMC00ZDIzLWFmNTEtODM1ZmRlYWMwMWFmXkEyXkFqcGdeQXVyMTMxODk2OTU@.jpg")
        .openStream();
    BufferedImage Original = ImageIO.read(inputStream);
    int width = Original.getWidth();
    int height = Original.getHeight();
    int newHeight = height + 200;
    BufferedImage newImage = new BufferedImage(width, newHeight, BufferedImage.TRANSLUCENT);

    Graphics2D graphics = (Graphics2D) newImage.getGraphics();
    graphics.drawImage(Original, 0, 0, null);
    
    var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(fonte);

    // escrever uma frase na nova imagem
    graphics.drawString("TOPZERA", 100, newHeight - 100);

    // escrever a nova imagem em um arquivo
    ImageIO.write(newImage, "png", new File("saida/figurinha.png"));
  }

  public static void main(String[] args) throws Exception {
    var fig = new GeraFigurinha();
    fig.cria();
  }
}
