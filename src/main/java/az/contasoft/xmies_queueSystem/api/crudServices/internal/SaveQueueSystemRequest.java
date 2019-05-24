package az.contasoft.xmies_queueSystem.api.crudServices.internal;

import java.util.Date;

public class SaveQueueSystemRequest {
    private  long idQueueSystem;//idnovbe sistemi
    private Date enteredDate;
    private long idProtocol;
    private long idDepartment;
    private long idPersonal;
    private long queueNo;//sira nomresi

    public SaveQueueSystemRequest() {
    }

    @Override
    public String toString() {
        return "SaveQueueSystemRequest{" +
                "idQueueSystem=" + idQueueSystem +
                ", enteredDate=" + enteredDate +
                ", idProtocol=" + idProtocol +
                ", idDepartment=" + idDepartment +
                ", idPersonal=" + idPersonal +
                ", queueNo=" + queueNo +
                '}';
    }

    public long getIdQueueSystem() {
        return idQueueSystem;
    }

    public void setIdQueueSystem(long idQueueSystem) {
        this.idQueueSystem = idQueueSystem;
    }

    public Date getEnteredDate() {
        return enteredDate;
    }

    public void setEnteredDate(Date enteredDate) {
        this.enteredDate = enteredDate;
    }

    public long getIdProtocol() {
        return idProtocol;
    }

    public void setIdProtocol(long idProtocol) {
        this.idProtocol = idProtocol;
    }

    public long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public long getQueueNo() {
        return queueNo;
    }

    public void setQueueNo(long queueNo) {
        this.queueNo = queueNo;
    }

    public SaveQueueSystemRequest(long idQueueSystem, Date enteredDate, long idProtocol, long idDepartment, long idPersonal, long queueNo) {
        this.idQueueSystem = idQueueSystem;
        this.enteredDate = enteredDate;
        this.idProtocol = idProtocol;
        this.idDepartment = idDepartment;
        this.idPersonal = idPersonal;
        this.queueNo = queueNo;
    }
}
