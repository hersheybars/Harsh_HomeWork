
public class Player {

    public static enum Type {

        DEALER, PLAYER
    }
    @SuppressWarnings("unused")
    private Type type;
    private String name;
    private float wallet = 0;

    public Player(String name) {
        if (name == "") {
            this.type = Type.DEALER;
            this.name = "The Dealer";
        } else {
            this.type = Type.PLAYER;
            this.name = name;
        }
        setWallet(200);
    }

    public String getName() {
        return this.name;
    }

    public float getWallet() {
        return wallet;
    }

    public void setWallet(float wallet) {
        this.wallet = wallet;
    }

    public void addFunds(float amt) {
        this.wallet += amt;
    }

    public boolean removeFunds(float amt) {
        if (amt < this.wallet) {
            this.wallet -= amt;
            return true;
        }
        return false;
    }
}

enum Action {
    NOTHING, HIT, STAND, DOUBLE, SPLIT, SURRENDER, INSURANCE
}
