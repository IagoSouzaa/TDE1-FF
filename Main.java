import java.awt.Color;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o caminho da imagem (ex: 'imagem'.png):");
        String caminhoImagem = scanner.nextLine();

        System.out.println("Digite a nova cor em formato HEX (ex: #FF0000 para vermelho):");
        String corHex = scanner.nextLine();
        Color novaCor = Color.decode(corHex);

        FloodFill floodFill = new FloodFill(caminhoImagem, novaCor);

        System.out.println("Digite as coordenadas x e y para o preenchimento:");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        floodFill.preencher(x, y);

        floodFill.salvar("imagem_preenchida.png");

        scanner.close();
    }
}
