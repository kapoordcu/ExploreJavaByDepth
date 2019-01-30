package explore.topics.design.adaptor;

import java.util.Objects;

public class WalletType {

    private String gameName;

    public static final WalletType WALLET_EM = new WalletType("WALLET_EM");
    public static final WalletType WALLET_TPI = new WalletType("WALLET_TPI");

    public WalletType(String gameName) {
        this.gameName = gameName;
    }

    public final String name() {
        return gameName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WalletType that = (WalletType) o;
        return Objects.equals(gameName, that.gameName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameName);
    }
}
