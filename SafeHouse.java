public class SafeHouse extends NormalLoc{
    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean onLocation() {
        System.out.println("You are in Safe House");
        System.out.println("Your Health is refulled");
        return true;
    }
}
