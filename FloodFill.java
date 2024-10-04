import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class FloodFill {
    private BufferedImage imagem;
    private Color corAlvo;
    private Color novaCor;

    public FloodFill(String caminhoImagem, Color novaCor) {
        try {
            imagem = ImageIO.read(new File(caminhoImagem));
            this.novaCor = novaCor;
        } catch (Exception e) {
            System.out.println("Erro ao carregar a imagem: " + e.getMessage());
        }
    }

    public void preencher(int x, int y) {
        corAlvo = new Color(imagem.getRGB(x, y));
        if (!corAlvo.equals(novaCor)) {

            Fila<Ponto> fila = new Fila<>();
            fila.enqueue(new Ponto(x, y));

            while (!fila.isEmpty()) {
                Ponto p = fila.dequeue();
                int px = p.x;
                int py = p.y;

                if (px < 0 || py < 0 || px >= imagem.getWidth() || py >= imagem.getHeight())
                    continue;
                if (corAlvo.equals(new Color(imagem.getRGB(px, py)))) {
                    imagem.setRGB(px, py, novaCor.getRGB());

                    fila.enqueue(new Ponto(px + 1, py));
                    fila.enqueue(new Ponto(px - 1, py));
                    fila.enqueue(new Ponto(px, py + 1));
                    fila.enqueue(new Ponto(px, py - 1));
                }
            }
        }
    }

    public void salvar(String caminhoSaida) {
        try {
            ImageIO.write(imagem, "png", new File(caminhoSaida));
            System.out.println("Imagem salva em: " + caminhoSaida);
        } catch (Exception e) {
            System.out.println("Erro ao salvar a imagem: " + e.getMessage());
        }
    }
}
