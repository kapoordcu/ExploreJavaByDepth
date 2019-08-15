package explore.topics.design.aAdaptor;

public class BankAccountExample {
    public static void main(String[] args) {
        BankAccount account = new DomesticAccount();
        account.transact(20l);

        BankAccount accointEuro = new AccounAdaptor(new EU3rdPartyAccount());
        accointEuro.transact(20l);
    }
}


interface BankAccount {
    void transact(Long amount);
}


class DomesticAccount implements BankAccount {
    @Override
    public void transact(Long amount) {
        System.out.println("Currency is spent locally.");
    }
}

class EU3rdPartyAccount {
    public void transact(Double amount, String currency) {
        System.out.println("Currency is supplied to third party class via client interface.");
    }
}

class AccounAdaptor implements BankAccount {
    EU3rdPartyAccount thirdParty;

    public AccounAdaptor(EU3rdPartyAccount thirdParty) {
        this.thirdParty = thirdParty;
    }

    @Override
    public void transact(Long amount) {
        thirdParty.transact(Double.valueOf(amount), "EURO");
    }
}