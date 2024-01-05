import java.util.Scanner;

public class Game {
    public Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println();
        System.out.println("Macera oyununa hoşgeldiniz ! ");
        System.out.println();
        System.out.print("Lütfen bir isim giriniz : ");
        String playerName = input.nextLine();
        Player player = new Player(playerName);
        System.out.println(" Hoşgeldin  " + player.getName());
        player.selectChar();

    }

}
