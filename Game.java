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

        Location location = null;

        while(true){
            player.printInfo();
            System.out.println();
            System.out.println("-----Bölgeler-----\n\n1 - Safe House ==> There is no enemy here. You are safe !!\n2 - Tool Store ==> You can buy armor and weapons here");
            System.out.println();
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            System.out.println();
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                default:
                    location = new SafeHouse(player);
            }
            if(!location.onLocation()){
                System.out.println("Game Over");
                break;
            }
        }

    }

}
