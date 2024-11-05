import java.util.Scanner;

public class JogoDaForca {
    public static void main(String[] args) {
        // Palavra a ser adivinhada
        String[] palavras = {"banana", "computador", "java", "abacaxi", "programacao"};
        String palavra = palavras[(int) (Math.random() * palavras.length)];
        StringBuilder palavraOculta = new StringBuilder("_".repeat(palavra.length()));
        int tentativasRestantes = 6;
        boolean jogoTerminado = false;

        // Scanner para leitura da entrada do usuário
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo ao Jogo da Forca!");
        System.out.println("Adivinhe a palavra:");

        // Loop principal do jogo
        while (!jogoTerminado) {
            System.out.println("Palavra: " + palavraOculta);
            System.out.println("Tentativas restantes: " + tentativasRestantes);
            System.out.print("Digite uma letra: ");
            char letra = scanner.nextLine().toLowerCase().charAt(0);

            if (palavra.indexOf(letra) >= 0) {
                // Atualizar palavra oculta com a letra correta
                for (int i = 0; i < palavra.length(); i++) {
                    if (palavra.charAt(i) == letra) {
                        palavraOculta.setCharAt(i, letra);
                    }
                }
                System.out.println("Boa! A letra está na palavra.");
            } else {
                tentativasRestantes--;
                System.out.println("Letra incorreta! Você perdeu uma tentativa.");
            }

            // Verificar se o jogador ganhou ou perdeu
            if (palavraOculta.toString().equals(palavra)) {
                System.out.println("Parabéns! Você adivinhou a palavra: " + palavra);
                jogoTerminado = true;
            } else if (tentativasRestantes == 0) {
                System.out.println("Você perdeu! A palavra era: " + palavra);
                jogoTerminado = true;
            }
        }

        scanner.close();
    }
}
