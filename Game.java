import javax.swing.text.html.HTMLDocument;
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
            System.out.println("-----Bölgeler-----");
            System.out.println();
            System.out.println("0 - Çıkış yap");
            System.out.println("1 - Safe House ==> There is no enemy here. You are safe !!");
            System.out.println("2 - Tool Store ==> You can buy armor and weapons here");
            System.out.println("3 - Mağaraya gir. Ödül = yemek. Dikkatli ol zombi çıkabilir.");
            System.out.println("4 - Ormana gir. Ödül = odun. Dikkatli ol vampir çıkabilir.");
            System.out.println("5 - Nehire gir. Ödeül = su. Dikkatli ol ayı çıkabilir.");
            System.out.print("Lütfen gitmek istediğiniz bölgeyi seçiniz : ");
            System.out.println();
            int selectLoc = input.nextInt();
            switch (selectLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    location = new Cave(player);
                    break;
                case 4:
                    location = new Forest(player);
                    break;
                case 5:
                    location = new River(player);
                    break;
                default:
                    System.out.println("Lütfen geçerli bir sayı giriniz.");
            }
            if(location == null){
                System.out.println("Oyundan çıktınız. Tekrar görüşmek üzere.");
                break;
            }

            if(!location.onLocation()){
                System.out.println("Game Over");
                break;
            }
        }
    }

}
