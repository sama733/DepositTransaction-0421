package ir.dotin.school.core.server;


import java.io.Serializable;
import java.math.BigDecimal;

public class Transaction implements Serializable {

    private static final long serialVersionUID = 123894712L;

    private String id;
    private String type;
    private BigDecimal amount;
    private String depositNumber;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDepositNumber() {
        return depositNumber;
    }

    public void setDepositNumber(String depositNumber) {
        this.depositNumber = depositNumber;
    }

    public String toString() {
        return "{\n\tid: " + getId() + "\n\ttype: " + getType() + "\n\tamount: " + getAmount() + "\n\tdeposit: " + getDepositNumber() + "\n},\n";
    }

}