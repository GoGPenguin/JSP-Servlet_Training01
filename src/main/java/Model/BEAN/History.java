package Model.BEAN;

public class History {
    private String idClient;
    private String nameClient;
    private String nameDisease;
    private String idVacxin;
    private String nameVacxin;
    private int summaryDose;

    public History() {
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

    public String getNameDisease() {
        return nameDisease;
    }

    public void setNameDisease(String nameDisease) {
        this.nameDisease = nameDisease;
    }

    public String getIdVacxin() {
        return idVacxin;
    }

    public void setIdVacxin(String idVacxin) {
        this.idVacxin = idVacxin;
    }

    public String getNameVacxin() {
        return nameVacxin;
    }

    public void setNameVacxin(String nameVacxin) {
        this.nameVacxin = nameVacxin;
    }

    public int getSummaryDose() {
        return summaryDose;
    }

    public void setSummaryDose(int summaryDose) {
        this.summaryDose = summaryDose;
    }
}
