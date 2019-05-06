package az.contasoft.xmies_queueSystem.db.entity;

import java.util.Date;

public class QueueSystem {
    /*novbe systemi
    idNovbesystemi
    girish tarixi
    idprotocol
    idshobe
    idpersonal
    sirano

     */
    private long idQueueSystem;//idnovbe sistemi
    private Date enteredDate;
    private long idProtocol;
    private long idDeparment;
    private long idPersonal;
    private long QueueNo;//sira nomresi
    private  long isDelete;

    public QueueSystem() {
    }

    @Override
    public String toString() {
        return "QueueSystem{" +
                "idQueueSystem=" + idQueueSystem +
                ", enteredDate=" + enteredDate +
                ", idProtocol=" + idProtocol +
                ", idDeparment=" + idDeparment +
                ", idPersonal=" + idPersonal +
                ", QueueNo=" + QueueNo +
                ", isDelete=" + isDelete +
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

    public long getIdDeparment() {
        return idDeparment;
    }

    public void setIdDeparment(long idDeparment) {
        this.idDeparment = idDeparment;
    }

    public long getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(long idPersonal) {
        this.idPersonal = idPersonal;
    }

    public long getQueueNo() {
        return QueueNo;
    }

    public void setQueueNo(long queueNo) {
        QueueNo = queueNo;
    }

    public long getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(long isDelete) {
        this.isDelete = isDelete;
    }

    public QueueSystem(long idQueueSystem, Date enteredDate, long idProtocol, long idDeparment, long idPersonal, long queueNo, long isDelete) {
        this.idQueueSystem = idQueueSystem;
        this.enteredDate = enteredDate;
        this.idProtocol = idProtocol;
        this.idDeparment = idDeparment;
        this.idPersonal = idPersonal;
        QueueNo = queueNo;
        this.isDelete = isDelete;
    }
}






