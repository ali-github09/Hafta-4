import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String name;
    private String charName;
    private Scanner input = new Scanner(System.in);
    private Inventory inventory;



    public Player(String name){
        this.name = name;
        this.inventory = new Inventory();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(),new Knight()};
        System.out.println("-----------------");
        System.out.println("   KARAKTERLER");
        System.out.println("----------------------------------------------------------");
        for(GameChar gameChar : charList) {
            System.out.println("ID: "+ gameChar.getId() +" karakter: "+ gameChar.getName()  +
                    "\t Damage: "+ gameChar.getDamage() +
                    "\t Health: "+ gameChar.getHealth() +
                    "\t Money: "+ gameChar.getMoney());
        }
        System.out.println("----------------------------------------------------------");
        System.out.println();
        System.out.print("Lütfen oynamak istediğiniz karakteri seçiniz : ");
        int selectChar = input.nextInt();
        System.out.println();
        switch (selectChar){
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());
        }
        System.out.println("Seçilen Karakter : ___" + this.getCharName() +
                "___ Damage: "+ this.getDamage() +
                " Health: " + this.getHealth() +
                " Money: " + this.getMoney());
    }



    public void initPlayer(GameChar gameChar){
        this.setDamage(gameChar.getDamage());
        this.setHealth(gameChar.getHealth());
        this.setMoney(gameChar.getMoney());
        this.setCharName(gameChar.getName());
    }

    public void printInfo(){
        System.out.println(
                "Silahınız : " + this.getInventory().getWeapon().getName() +
                " Zırhınız : " + this.getInventory().getArmor().getName() +
                " Blok : " + this.getInventory().getArmor().getBlock() +
                " Damage: "+ this.getTotalDamage() +
                " Health: " + this.getHealth() +
                " Money: " + this.getMoney());
    }

    public int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }

    public int getDamage(){
        return damage;
    }

    public void setDamage(int damage){
        this.damage = damage;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public int getMoney(){
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public Weapon getWeapon(){
        return this.getInventory().getWeapon();
    }
}
