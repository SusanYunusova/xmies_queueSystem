package az.contasoft.xmies_queueSystem.db.entity;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "queueSystem")
public class QueueSystem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idQueueSystem", nullable = false, unique = true)
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
    private long idDepartment;
    private long idPersonal;
    private long queueNo;//sira nomresi//todo sil
    private int status;//todo status

    public QueueSystem() {
    }

    @Override
    public String toString() {
        return "QueueSystem{" +
                "idQueueSystem=" + idQueueSystem +
                ", enteredDate=" + enteredDate +
                ", idProtocol=" + idProtocol +
                ", idDepartment=" + idDepartment +
                ", idPersonal=" + idPersonal +
                ", queueNo=" + queueNo +
                ", status=" + status +
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

    public long getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public QueueSystem(long idQueueSystem, Date enteredDate, long idProtocol, long idDepartment, long idPersonal, long queueNo, long status) {
        this.idQueueSystem = idQueueSystem;
        this.enteredDate = enteredDate;
        this.idProtocol = idProtocol;
        this.idDepartment = idDepartment;
        this.idPersonal = idPersonal;
        this.queueNo = queueNo;
        this.status = (int) status;
    }
}






