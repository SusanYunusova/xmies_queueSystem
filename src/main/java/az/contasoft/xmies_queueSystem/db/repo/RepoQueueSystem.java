package az.contasoft.xmies_queueSystem.db.repo;

import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RepoQueueSystem extends CrudRepository<QueueSystem,Long> {

    /*
    private long idQueueSystem;//idnovbe sistemi
    private Date enteredDate;
    private long idProtocol;
    private long idDeparment;
    private long idPersonal;
    private long QueueNo;//sira nomresi
    private  long isDelete;

     */



    List<QueueSystem> findAll();


    QueueSystem findByIdQueueSystem(long idQueueSystem);
    QueueSystem findByIdProtocol(long idProtocol);
    QueueSystem findByIdPersonal(long idPersonal);
}
