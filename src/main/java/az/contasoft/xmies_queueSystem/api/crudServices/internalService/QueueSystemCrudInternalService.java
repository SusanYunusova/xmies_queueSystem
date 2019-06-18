package az.contasoft.xmies_queueSystem.api.crudServices.internalService;


import az.contasoft.xmies_queueSystem.api.crudServices.internal.SaveQueueSystemRequest;
import az.contasoft.xmies_queueSystem.api.crudServices.internal.UpdateQueueSystemRequest;
import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;
import az.contasoft.xmies_queueSystem.db.repo.RepoQueueSystem;
import az.contasoft.xmies_queueSystem.util.HazelCastUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class QueueSystemCrudInternalService {

    @Autowired
    RepoQueueSystem repoQueueSystem;

    @Autowired
    HazelCastUtility hazelCastUtility;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    //save
    public ResponseEntity<QueueSystem> saveQueueSystem(SaveQueueSystemRequest saveQueueSystemRequest) {
        try {
            QueueSystem queueSystem = new QueueSystem();
            queueSystem.setEnteredDate(saveQueueSystemRequest.getEnteredDate());
            queueSystem.setIdDepartment(saveQueueSystemRequest.getIdDepartment());
            queueSystem.setIdPersonal(saveQueueSystemRequest.getIdPersonal());
            queueSystem.setIdProtocol(saveQueueSystemRequest.getIdProtocol());
            queueSystem.setStatus(1);
            QueueSystem queueSystemLast = repoQueueSystem.findTopByStatusAndIdPersonalOrderByIdQueueSystemDesc(1, saveQueueSystemRequest.getIdPersonal());
            if (queueSystemLast != null) {
                queueSystem.setQueueNo(queueSystemLast.getQueueNo() + 1);
            } else {
                queueSystem.setQueueNo(1);
            }
            queueSystem = repoQueueSystem.save(queueSystem);
            hazelCastUtility.addOrUpdateQueueSystemToHazelCast(queueSystem);

            logger.info("{} response data : {}", "Queue system save ", queueSystem.toString());
            return new ResponseEntity<>(queueSystem, HttpStatus.OK);


        } catch (Exception e) {
            logger.error("Error {} : {}", "saving queue system", e, e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<QueueSystem> updateQueueSystem(UpdateQueueSystemRequest updateQueueSystemRequest) {
        QueueSystem queue = repoQueueSystem.findByIdQueueSystem(updateQueueSystemRequest.getIdQueueSystem());

        try {
            if (queue != null) {
                //todo burda set get idqueueSystem olmalidirm?idni ozumuz update etmememliyik deye elave etmedim
                queue.setQueueNo(updateQueueSystemRequest.getQueueNo());
                queue.setIdProtocol(updateQueueSystemRequest.getIdProtocol());
                queue.setIdPersonal(updateQueueSystemRequest.getIdPersonal());
                queue.setIdDepartment(updateQueueSystemRequest.getIdDeparment());
                queue.setEnteredDate(updateQueueSystemRequest.getEnteredDate());

                queue = repoQueueSystem.save(queue);
                hazelCastUtility.addOrUpdateQueueSystemToHazelCast(queue);
                logger.info("updateQueue response : {}", updateQueueSystemRequest.toString());
                return new ResponseEntity<>(queue, HttpStatus.OK);
            } else {
                logger.info("{} not found for {} : {}", "queue not found", "for queue id", updateQueueSystemRequest.getIdQueueSystem());
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            logger.error("Error {} : {}", "updating queue system", e, e);
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    public ResponseEntity<String> deleteIdQueueSystem(long idQueueSystem) {
        try {
            QueueSystem queue = repoQueueSystem.findByIdQueueSystemAndStatus(idQueueSystem, 0);

            if (queue == null) {

               return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);

            } else {
                queue.setStatus(1);
                repoQueueSystem.save(queue);
                hazelCastUtility.deleteQueueSystemFromHazelCast(idQueueSystem);
               return new ResponseEntity<>("deleted",HttpStatus.OK);


            }
        } catch (Exception e) {

            logger.error("Error delete : {}", e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
