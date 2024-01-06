public class ToolStore extends NormalLoc{
    public ToolStore(Player player) {
        super(player, "Tool Store");
    }

    @Override
    public boolean onLocation() {
        System.out.println("Welcome to the Tool Store !");
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
                break;
            case 3:
                System.out.println("Tekrar bekleriz. ");
                return true;
        }
        return true;
    }


    public void printWeapon(){
        System.out.println("Silahlar");
        for(Weapon w : Weapon.weapons()) {
            System.out.println(w.getId() + "-" + w.getName() + " para : " + w.getPrice() + " Hasar : " + w.getHasar() + " Para : " + w.getPrice());
        }

        }

      public void buyWeapon(){
          System.out.print("Bir silah seçiniz : ");
          int selectWeaponId = input.nextInt();
          while(selectWeaponId < 1 || selectWeaponId > Weapon.weapons().length) {
              System.out.println("Geçersiz değer girdiniz. Lütfen tekrar deneyiniz");
              selectWeaponId = input.nextInt();
          }
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
    public void printArmor(){
        System.out.println("Zırhlar");
    }

    }




