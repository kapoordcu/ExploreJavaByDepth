package explore.topics.design.adaptor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class CustomerHLP {
    private static final String CASH_LEDGER_ID = "LEDGER000001";

    private final String customerId;
    
    private String uuid;

    private String emToken;

    private LocalDateTime deactivatedUntilCasino;

    private LocalDateTime deactivatedUntil;

    public CustomerHLP(String customerId) {
        this.customerId = customerId;
        this.deactivatedUntilCasino = null;
    }

    public CustomerHLP(String customerId, Date deactivatedUntilCasino) {
        this.customerId = customerId;
        if (deactivatedUntilCasino == null) {
            this.deactivatedUntilCasino = null;
        } else {
            this.deactivatedUntilCasino = LocalDateTime.ofInstant(deactivatedUntilCasino.toInstant(),
                    ZoneId.of("UTC"));
        }
    }

    public CustomerHLP(String customerId, String uuid, LocalDateTime deactivatedUntilCasino,
                       LocalDateTime deactivatedUntil) {
        this.customerId = customerId;
        this.uuid = uuid;
        this.deactivatedUntilCasino = deactivatedUntilCasino;
        this.deactivatedUntil = deactivatedUntil;
    }

    public CustomerHLP(String customerId, Date deactivatedUntilCasino, Date deactivatedUntil) {
        this(customerId, deactivatedUntilCasino);
        if (deactivatedUntil == null) {
            this.deactivatedUntil = null;
        } else {
            this.deactivatedUntil = LocalDateTime.ofInstant(deactivatedUntil.toInstant(), ZoneId.of("UTC"));
        }
    }


    public String getUuid() {
        return uuid;
    }

    public CustomerHLP setUuid(String uuid) {
        this.uuid = uuid;
        return this;
    }

    public CustomerHLP setDeactivatedUntilCasino(LocalDateTime deactivatedUntilCasino) {
        this.deactivatedUntilCasino = deactivatedUntilCasino;
        return this;
    }

    public CustomerHLP setDeactivatedUntil(LocalDateTime deactivatedUntil) {
        this.deactivatedUntil = deactivatedUntil;
        return this;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getCashLedgerId() {
        return CASH_LEDGER_ID;
    }

    public LocalDateTime getDeactivatedUntilCasino() {
        return deactivatedUntilCasino;
    }

    public LocalDateTime getDeactivatedUntil() {
        return deactivatedUntil;
    }

    public String getEmToken() {
        return emToken;
    }

    public void setEmToken(String emToken) {
        this.emToken = emToken;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomerHLP customerHLP = (CustomerHLP) o;
        return
                Objects.equals(customerId, customerHLP.customerId) &&
                Objects.equals(uuid, customerHLP.uuid) &&
                Objects.equals(emToken, customerHLP.emToken) &&
                Objects.equals(deactivatedUntilCasino, customerHLP.deactivatedUntilCasino) &&
                Objects.equals(deactivatedUntil, customerHLP.deactivatedUntil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, uuid, emToken, deactivatedUntilCasino, deactivatedUntil);
    }
}
