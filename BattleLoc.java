import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private String award;
    private int maxObstacle;


    public BattleLoc(Player player, String name, Obstacle obstacle, String award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli olmalısın. Çünkü burada "+ obsNumber + " tane " + this.obstacle.getName() + " yaşıyor.");
        System.out.println("Nasıl ilerlemek istiyorsun ?");
        System.out.println("Savaşmak için -S-");
        System.out.println("Kaçmak için -K-");
        String move = input.nextLine();
        // küçük harf girilme ihtimali için toUppercase metodu kullanıp girilen String değeri büyüttük.
        move = move.toUpperCase();
        if(move.equals("S")){
            // savaş işlemleri burda yer alacak.
            System.out.println("gazanız mübarek olsun");
        }

        return true;
    }

    public boolean combat(int obsNumber){
        for(int i = 1; i <= obsNumber; i++){
        playerStats();
        obstacleStats();

        }
        return false;
    }

    public void playerStats() {
        System.out.println("oyuncu değerleri");
        System.out.println("-------------");
        System.out.println("Sağlık : " + this.getPlayer().getHealth());
        System.out.println("Silah : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Zırh : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Bloklama : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Hasar : " + this.getPlayer().getTotalDamage());
        System.out.println("Para : " + this.getPlayer().getMoney());
    }

    public void obstacleStats(){
        System.out.println(this.getObstacle().getName() + " Değerleri");
        System.out.println("-------------");
        System.out.println("Sağlık : " + this.getObstacle().getHealth());
        System.out.println("Hasar : " + this.getObstacle().getDamage());
        System.out.println("Ödül : " + this.getObstacle().getAward());
    }

    public int randomObstacleNumber(){
        Random r = new Random();
        // r.nextint ifadesi 0'dan bound'a kadar sayı üretir. bound dahil olmaz. o yüzden 1'den 3'e kadar üretmek için 1 ekledik.
        return r.nextInt(this.maxObstacle) +1;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }



    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}
