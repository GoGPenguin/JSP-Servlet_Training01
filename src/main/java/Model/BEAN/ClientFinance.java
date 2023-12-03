package Model.BEAN;

public class ClientFinance {
    private String idClient;
    private String nameClient;
    private String addressClient;
    private int summaryMoney;

    public ClientFinance() {
        super();
    }

    public String getIdClient() {
        return idClient;
    }

    public void setIdClient(String idClient) {
        this.idClient = idClient;
    }

    public String getNameClient() {
        return nameClient;
    }

    public void setNameClient(String nameClient) {
        this.nameClient = nameClient;
    }

    public String getAddressClient() {
        return addressClient;
    }

    public void setAddressClient(String addressClient) {
        this.addressClient = addressClient;
    }

    public int getSummaryMoney() {
        return summaryMoney;
    }

    public void setSummaryMoney(int summaryMoney) {
        this.summaryMoney = summaryMoney;
    }
}
