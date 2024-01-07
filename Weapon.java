public class Weapon {
    private String name;
    private int Id;
    private int damage;
    private int price;

    public Weapon(String name,int id, int hasar, int price) {
        this.name = name;
        this.Id = id;
        this.damage = hasar;
        this.price = price;
    }

    public static Weapon[] weapons() {
        Weapon[] weaponList = new Weapon[3];
        weaponList[0] = new Weapon("tabanca",1,2,15);
        weaponList[1] = new Weapon("kılıç",2,7,35);
        weaponList[2] = new Weapon("tüfek", 3,7,45);
        return weaponList;
    }

    public static Weapon getWeaponObjById(int id){
        for(Weapon w : Weapon.weapons()){
            if(w.getId() == id){
                return w;
            }
        }
        return null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
