import java.util.InputMismatchException;
import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);

        while (true) {
            try {
                // Receber os dois parâmetros via terminal
                System.out.println("Digite o primeiro parâmetro:");
                int parametroUm = terminal.nextInt();

                System.out.println("Digite o segundo parâmetro:");
                int parametroDois = terminal.nextInt();

                // Chamar o método para contar e imprimir os números
                contar(parametroUm, parametroDois);

                // Se o código chegar aqui, a entrada foi válida, então saia do loop
                break;

            } catch (InputMismatchException e) {
                //InputMismatchException is already a built-in Java class
                // Capturar e lidar com entrada inválida
                System.out.println("Entrada inválida. Por favor, digite números inteiros.");
                terminal.next(); // Limpar a entrada inválida
            }catch (ParametrosInvalidosException e) {
                // Capturar e imprimir a mensagem da exceção personalizada
                System.out.println(e.getMessage());
                // Solicitar 5a entrada novamente
            }
        }

        terminal.close(); // Fechar o scanner após a conclusão
    }

    public static void contar(int inicio, int fim) throws ParametrosInvalidosException {
        // Verificar se o segundo parâmetro é maior que o primeiro
        if (inicio >= fim) {
            // Lançar a exceção com a mensagem apropriada
            throw new ParametrosInvalidosException("O segundo parâmetro deve ser maior que o primeiro");
        }

        // Calcular a quantidade de interações
        int quantidade = fim - inicio;

        // Realizar as impressões
        for (int i = 1; i <= quantidade; i++) {
            System.out.println("Imprimindo o número " + i);
        }
    }
}
