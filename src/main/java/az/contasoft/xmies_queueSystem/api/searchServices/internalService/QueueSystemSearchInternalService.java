package az.contasoft.xmies_queueSystem.api.searchServices.internalService;


import az.contasoft.xmies_queueSystem.api.searchServices.internal.ResponseQueueCount;
import az.contasoft.xmies_queueSystem.api.searchServices.internal.ResponseSearchListQueueSystem;
import az.contasoft.xmies_queueSystem.api.searchServices.internal.ResponseSearchQueueSystem;
import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;
import az.contasoft.xmies_queueSystem.db.repo.RepoQueueSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
     *     List<QueueSystem> findAll();
     * @return ResponseSearchListQueueSystem
     */
    public ResponseSearchListQueueSystem getAll() {
        ResponseSearchListQueueSystem responseSearchListQueueSystem = new ResponseSearchListQueueSystem();
        logger.info("search ALL ResponseSearchListQueueSystem : {}", responseSearchListQueueSystem.toString());
        try {
            List<QueueSystem> queueSystemList = repoQueueSystem.findAll();

            if (queueSystemList == null||queueSystemList.isEmpty() ) {
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


        }catch (Exception e){
            logger.info("error getting ALL responseSearchListQueueSystem : {}", e);
            responseSearchListQueueSystem.setServerCode(100);
            responseSearchListQueueSystem.setServerMessage(e+" ");

            return responseSearchListQueueSystem;
        }


}

    /**
     *  QueueSystem findByIdQueueSystem(long idQueueSystem);
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
    public ResponseSearchListQueueSystem getAllByIdProtocol(long idProtocol) {
        List<QueueSystem> findByIdProtocol = repoQueueSystem.findAllByIdProtocol(idProtocol);

        ResponseSearchListQueueSystem responseSearchQueueSystem = new ResponseSearchListQueueSystem();

        if (findByIdProtocol == null||findByIdProtocol.isEmpty()) {
            responseSearchQueueSystem.setQueueSystemList(null);
            responseSearchQueueSystem.setServerCode(100);
            responseSearchQueueSystem.setServerMessage("getByByIdProtocol  search");

            logger.info("getByIdProtocol responseSearchQueueSystem1 : {}", responseSearchQueueSystem.toString());

        } else {
            responseSearchQueueSystem.setQueueSystemList(findByIdProtocol);
            responseSearchQueueSystem.setServerCode(200);
            responseSearchQueueSystem.setServerMessage(" getByByIdProtocol found");
            logger.info("Error getByByIdProtocol responseSearchQueueSystem1 : {}", responseSearchQueueSystem.toString());
        }
        return responseSearchQueueSystem;
    }

        /**
         *  QueueSystem findByIdPersonal(long idPersonal);
         * @param idPersonal
         * @return
         */
        public ResponseSearchListQueueSystem getAllByIdPersonal(long idPersonal){
            List<QueueSystem> findByIdPersonal = repoQueueSystem.findAllByIdPersonal(idPersonal);

            ResponseSearchListQueueSystem responseSearchQueueSystem = new ResponseSearchListQueueSystem();

            if (findByIdPersonal == null||findByIdPersonal.isEmpty()) {
                responseSearchQueueSystem.setQueueSystemList(null);
                responseSearchQueueSystem.setServerCode(100);
                responseSearchQueueSystem.setServerMessage("getIdPersonal not found");

                logger.info("getByIdPersonal responseSearchQueueSystem1 : {}", responseSearchQueueSystem.toString());

            } else {
                responseSearchQueueSystem.setQueueSystemList(findByIdPersonal);
                responseSearchQueueSystem.setServerCode(200);
                responseSearchQueueSystem.setServerMessage(" getByIdPersonal found");
                logger.info("Error getByIdPersonal responseSearchQueueSystem : {}", responseSearchQueueSystem.toString());
            }
            return responseSearchQueueSystem;
        }


    public ResponseQueueCount getCount(long idPersonal) {
        ResponseQueueCount response = new ResponseQueueCount();
        response.setServerCode(200);
        response.setServerMessage("ok");
        int count = repoQueueSystem.countByStatusAndIdPersonal(1, idPersonal);
        if(count==0){
            response.setCount(0);
        }else{
            response.setCount(count);
        }
            return response;
    }
}



