package az.contasoft.xmies_queueSystem.api.crudServices.internalService;


import az.contasoft.xmies_queueSystem.api.crudServices.internal.QueueSystemResponse;
import az.contasoft.xmies_queueSystem.api.crudServices.internal.SaveQueueSystemRequest;
import az.contasoft.xmies_queueSystem.api.crudServices.internal.UpdateQueueSystemRequest;
import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;
import az.contasoft.xmies_queueSystem.db.repo.RepoQueueSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class QueueSystemCrudInternalService {

    @Autowired
    RepoQueueSystem repoQueueSystem;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //save
    public QueueSystemResponse saveQueueSystem(SaveQueueSystemRequest saveQueueSystemRequest) {
        QueueSystemResponse queueSystemResponse = new QueueSystemResponse();
        try {
            QueueSystem queueSystem = new QueueSystem();


            queueSystem.setEnteredDate(saveQueueSystemRequest.getEnteredDate());
            queueSystem.setIdDeparment(saveQueueSystemRequest.getIdDeparment());
            queueSystem.setIdPersonal(saveQueueSystemRequest.getIdPersonal());
            queueSystem.setIdProtocol(saveQueueSystemRequest.getIdProtocol());
            queueSystem.setQueueNo(saveQueueSystemRequest.getQueueNo());


            queueSystem = repoQueueSystem.save(queueSystem);


            queueSystemResponse.setServerCode(200);
            queueSystemResponse.setServerMessage("OK");
            queueSystemResponse.setQueueSystem(queueSystem);
            logger.info("saveQueueSystem response : {}", saveQueueSystemRequest.toString());
        } catch (Exception e) {
            queueSystemResponse.setServerCode(100);
            queueSystemResponse.setServerMessage("error");
            logger.error("Error save file text : {}", e);
        }
        return queueSystemResponse;
    }

    public QueueSystemResponse updateQueueSystem(UpdateQueueSystemRequest updateQueueSystemRequest) {
        QueueSystemResponse queueSystemResponse = new QueueSystemResponse();
        QueueSystem queue = repoQueueSystem.findByIdQueueSystem(updateQueueSystemRequest.getIdQueueSystem());

        try {
            if (queue != null) {


                //todo burda set get idqueueSystem olmalidirm?idni ozumuz update etmememliyik deye elave etmedim
                queue.setQueueNo(updateQueueSystemRequest.getQueueNo());
                queue.setIdProtocol(updateQueueSystemRequest.getIdProtocol());
                queue.setIdPersonal(updateQueueSystemRequest.getIdPersonal());
                queue.setIdDeparment(updateQueueSystemRequest.getIdDeparment());
                queue.setEnteredDate(updateQueueSystemRequest.getEnteredDate());

                queue = repoQueueSystem.save(queue);
                queueSystemResponse.setServerCode(200);
                queueSystemResponse.setServerMessage("OK");
                queueSystemResponse.setQueueSystem(queue);
                logger.info("updateQueue response : {}", updateQueueSystemRequest.toString());
            } else {
                queueSystemResponse.setServerCode(200);
                queueSystemResponse.setServerMessage("OK");
                logger.info("updateQueueSystem response : {}", queueSystemResponse.toString());
            }
        } catch (Exception e) {
            queueSystemResponse.setServerCode(100);
            queueSystemResponse.setServerMessage("error");
            logger.error("Error save file text : {}", e);
        }
        return queueSystemResponse;
    }


    public QueueSystemResponse deleteIdQueueSystem(long idQueueSystem, long idPersonal) {
        QueueSystemResponse queueSystemResponse = new QueueSystemResponse();
        try {
            QueueSystem queue = repoQueueSystem.findByIdQueueSystem(idQueueSystem);

            if (queue == null) {
                queueSystemResponse.setServerMessage("Queue not found");
                queueSystemResponse.setServerCode(230);
            } else {
                queueSystemResponse.setServerCode(200);
                queueSystemResponse.setServerMessage("OK queue is deleted");
                queue.setIsDelete(1);
               queue= repoQueueSystem.save(queue);
               queueSystemResponse.setQueueSystem(queue);


            }
        } catch (Exception e) {
            queueSystemResponse.setServerCode(100);
            queueSystemResponse.setServerMessage("Error patient deleting : " + e);
            logger.error("Error delete : {}", e);
        }
        return queueSystemResponse;
    }
}
