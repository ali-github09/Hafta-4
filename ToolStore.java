public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the Tool Store !");
        boolean showMenu = true;
        while(showMenu){
            System.out.println("Lütfen bir seçim yapın");
            System.out.println("1- Silahlar");
            System.out.println("2- Zırhlar");
            System.out.println("3 Çıkış yap");


            int selectCase = input.nextInt();
            while(selectCase < 1 || selectCase > 3) {
                System.out.println("Geçersiz değer girdiniz. Lütfen tekrar deneyiniz");
                selectCase = input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("Tekrar bekleriz. ");
                    showMenu = false;
                    break;

            }
        }
        return true;
    }


    public void printWeapon(){
        System.out.println("Silahlar");
        for(Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() + " para : " + w.getPrice() + " Hasar : " + w.getDamage() + " Para : " + w.getPrice());
        }
        System.out.println("0 : çıkış yap");
        }

      public void buyWeapon(){
          System.out.print("Bir silah seçiniz : ");
          int selectWeaponId = input.nextInt();
          while(selectWeaponId < 0 || selectWeaponId > Weapon.weapons().length) {
              System.out.println("Geçersiz değer girdiniz. Lütfen tekrar deneyiniz");
              selectWeaponId = input.nextInt();
          }
          if (selectWeaponId != 0){
              Weapon selectedWeapon = Weapon.getWeaponObjById(selectWeaponId);

              if(selectedWeapon != null){
                  if(selectedWeapon.getPrice() > this.getPlayer().getMoney()){
                      System.out.println("Yeterli paranız bulunmamaktadır");
                  } else {
                      System.out.println(selectedWeapon.getName() + " silahını satın aldınız");
                      int balance = this.getPlayer().getMoney() - selectedWeapon.getPrice();
                      this.getPlayer().setMoney(balance);
                      System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                      this.getPlayer().getInventory().setWeapon(selectedWeapon);
                      System.out.println("Yeni silahınız : " + this.getPlayer().getInventory().getWeapon().getName());
                  }
              }
          }

      }
    public void printArmor(){
        System.out.println("Zırhlar");
        for(Armor a : Armor.armors()) {
            System.out.println(a.getId() + "-" + a.getName() + " para : " + a.getPrice() + " Blok : " + a.getBlock());
        }
        System.out.println("0 - Çıkış yap");
    }

    public void buyArmor(){
        System.out.print("Bir armor seçiniz : ");
        int selectArmorId = input.nextInt();
        while(selectArmorId < 0 || selectArmorId > Armor.armors().length) {
            System.out.println("Geçersiz değer girdiniz. Lütfen tekrar deneyiniz");
            selectArmorId = input.nextInt();
        }
        if (selectArmorId != 0){
            Armor selectedArmor = Armor.getArmorObjById(selectArmorId);
            if(selectedArmor != null){
                if(selectedArmor.getPrice() > this.getPlayer().getMoney()){
                    System.out.println("Yeterli paranız bulunmamaktadır");
                } else {
                    System.out.println(selectedArmor.getName() + " Zırhını satın aldınız");
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                    this.getPlayer().getInventory().setArmor(selectedArmor);
                    System.out.println("Yeni Zırhınız : " + this.getPlayer().getInventory().getArmor().getName());
                }
            }
        }

    }



    }




