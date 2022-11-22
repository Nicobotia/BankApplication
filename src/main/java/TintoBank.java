public class TintoBank extends Account {
    public TintoBank(String cname, String cid) {
        super(cname, cid);
    }

    public static void main(String[] args) {

        Account SeanisRich = new Account("Sean Oberc", "Q1246");
        SeanisRich.showMenu();
    }
}
