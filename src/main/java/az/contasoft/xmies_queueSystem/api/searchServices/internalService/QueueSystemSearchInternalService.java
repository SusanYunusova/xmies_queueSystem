package az.contasoft.xmies_queueSystem.api.searchServices.internalService;


import az.contasoft.xmies_queueSystem.api.searchServices.internal.ResponseSearchListQueueSystem;
import az.contasoft.xmies_queueSystem.api.searchServices.internal.ResponseSearchQueueSystem;
import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;
import az.contasoft.xmies_queueSystem.db.repo.RepoQueueSystem;
import az.contasoft.xmies_queueSystem.util.HazelCastUtility;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class QueueSystemSearchInternalService {

    @Autowired
    RepoQueueSystem repoQueueSystem;

    @Autowired
    HazelCastUtility hazelCastUtility;

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    /**
     * List<QueueSystem> findAll();
     *
     * @return ResponseSearchListQueueSystem
     */
    public ResponseEntity<List<QueueSystem>> getAll(Date date) {
        try {
            List<QueueSystem> queueSystemList = repoQueueSystem.findAllByEnteredDate(date);

            if (queueSystemList == null || queueSystemList.isEmpty()) {
                logger.info("{} not found for {} : {}","Get All By Date","date",date);
                return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);
            } else {

                return new ResponseEntity<>(queueSystemList,HttpStatus.OK);
            }
        } catch (Exception e) {
            logger.info("error getting ALL responseSearchListQueueSystem : {}", e);
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    /**
     * QueueSystem findByIdQueueSystem(long idQueueSystem);
     *
     * @param idQueueSystem
     * @return ResponseSearchQueueSystem
     */

    public ResponseEntity<QueueSystem> getByIdQueueSystem(long idQueueSystem) {
        QueueSystem queueSystem = repoQueueSystem.findByIdQueueSystem(idQueueSystem);


        if (queueSystem == null) {


            logger.info("getByIdQueueSystem response : {}","no content");
            return new ResponseEntity<>(null,HttpStatus.NO_CONTENT);

        } else {

            logger.info("Error getByIdQueueSystem response : {}", "tapildiiii");
            return new ResponseEntity<>(queueSystem,HttpStatus.OK);
        }
//5itykjhtgfds
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



