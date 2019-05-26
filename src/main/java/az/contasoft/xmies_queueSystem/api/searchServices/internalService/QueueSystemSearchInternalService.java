package az.contasoft.xmies_queueSystem.api.searchServices.internalService;


import az.contasoft.xmies_queueSystem.api.searchServices.internal.ResponseSearchListQueueSystem;
import az.contasoft.xmies_queueSystem.api.searchServices.internal.ResponseSearchQueueSystem;
import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;
import az.contasoft.xmies_queueSystem.db.repo.RepoQueueSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class QueueSystemSearchInternalService {

    @Autowired
    RepoQueueSystem repoQueueSystem;

    private Logger logger = LoggerFactory.getLogger(this.getClass());
/*

    List<QueueSystem> findAll();


    QueueSystem findByIdQueueSystem(long idQueueSystem);
    QueueSystem findByIdProtocol(long idProtocol);
    QueueSystem findByIdPersonal(long idPersonal);
 */

    /**
     * List<QueueSystem> findAll();
     *
     * @return ResponseSearchListQueueSystem
     */
    public ResponseSearchListQueueSystem getAll() {
        ResponseSearchListQueueSystem responseSearchListQueueSystem = new ResponseSearchListQueueSystem();
        logger.info("search ALL ResponseSearchListQueueSystem : {}", responseSearchListQueueSystem.toString());
        try {
            List<QueueSystem> queueSystemList = repoQueueSystem.findAll();

            if (queueSystemList == null || queueSystemList.isEmpty()) {
                responseSearchListQueueSystem.setQueueSystemList(null);
                responseSearchListQueueSystem.setServerCode(210);
                responseSearchListQueueSystem.setServerMessage("responseSearchListQueueSystem not found");

                logger.info("search responseSearchListQueueSystem : {}", responseSearchListQueueSystem.toString());
            } else {
                responseSearchListQueueSystem.setQueueSystemList(queueSystemList);
                responseSearchListQueueSystem.setServerCode(200);
                responseSearchListQueueSystem.setServerMessage("responseSearchListQueueSystem found");

                logger.info("search responseSearchListQueueSystem : {}", responseSearchListQueueSystem.toString());
            }
            return responseSearchListQueueSystem;


        } catch (Exception e) {
            logger.info("error getting ALL responseSearchListQueueSystem : {}", e);
            responseSearchListQueueSystem.setServerCode(100);
            responseSearchListQueueSystem.setServerMessage(e + " ");

            return responseSearchListQueueSystem;
        }


    }

    /**
     * QueueSystem findByIdQueueSystem(long idQueueSystem);
     *
     * @param idQueueSystem
     * @return ResponseSearchQueueSystem
     */

    public ResponseSearchQueueSystem getByIdQueueSystem(long idQueueSystem) {
        QueueSystem findByIdQueueSystem = repoQueueSystem.findByIdQueueSystem(idQueueSystem);

        ResponseSearchQueueSystem response = new ResponseSearchQueueSystem();

        if (findByIdQueueSystem == null) {
            response.setQueueSystem(null);
            response.setServerCode(100);
            response.setServerMessage("getByIdQueueSystem  search");

            logger.info("getByIdQueueSystem response : {}", response.toString());

        } else {
            response.setQueueSystem(findByIdQueueSystem);
            response.setServerCode(200);
            response.setServerMessage(" getByIdQueueSystem found");
            logger.info("Error getByIdQueueSystem response : {}", response.toString());
        }
        return response;
    }

    /**
     *  QueueSystem findByIdProtocol(long idProtocol);
     * @param idProtocol
     * @return
     */
//    public ResponseEntity<List<QueueSystem>> getAllByIdProtocol(long idProtocol) {
//        List<QueueSystem> findByIdProtocol = repoQueueSystem.findAllByIdProtocol(idProtocol);
//
//        ResponseSearchListQueueSystem responseSearchQueueSystem = new ResponseSearchListQueueSystem();
//
//        if (findByIdProtocol == null||findByIdProtocol.isEmpty()) {
//            responseSearchQueueSystem.setQueueSystemList(null);
//            responseSearchQueueSystem.setServerCode(100);
//            responseSearchQueueSystem.setServerMessage("getByByIdProtocol  search");
//
//            logger.info("getByIdProtocol responseSearchQueueSystem1 : {}", responseSearchQueueSystem.toString());
//
//        } else {
//            responseSearchQueueSystem.setQueueSystemList(findByIdProtocol);
//            responseSearchQueueSystem.setServerCode(200);
//            responseSearchQueueSystem.setServerMessage(" getByByIdProtocol found");
//            logger.info("Error getByByIdProtocol responseSearchQueueSystem1 : {}", responseSearchQueueSystem.toString());
//        }
//        return responseSearchQueueSystem;
//    }

    /**
     * QueueSystem findByIdPersonal(long idPersonal);
     *
     * @param idPersonal
     * @return
     */
    public ResponseEntity<List<QueueSystem>> getAllByIdPersonalAndIdProtocol(long idPersonal, long idProtocol) {
        List<QueueSystem> queueSystemList = repoQueueSystem.findByIdPersonalAndIdProtocol(idPersonal,idProtocol);
        //todo try
         if (queueSystemList == null || queueSystemList.isEmpty()) {
            logger.info("{} not found for {} : {}", "Queue", "idPersonal", idPersonal);
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        } else {
            logger.info("{}", "queue system result sending");
            return new ResponseEntity<>(queueSystemList, HttpStatus.OK);
        }
    }


    public ResponseEntity<Integer> getCount(long idPersonal) {

        int count = repoQueueSystem.countByStatusAndIdPersonal(1, idPersonal);
        if (count == 0) {
            logger.info("returning queue count : {} ", 0);
            return new ResponseEntity<>(0, HttpStatus.OK);
        } else {
            logger.info("returning queue count : {} ", count);
            return new ResponseEntity<>(count, HttpStatus.OK);
        }
    }
}



