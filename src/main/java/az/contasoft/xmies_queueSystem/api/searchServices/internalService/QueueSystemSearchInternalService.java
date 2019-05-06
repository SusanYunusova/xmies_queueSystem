package az.contasoft.xmies_queueSystem.api.searchServices.internalService;


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

            if (queueSystemList == null ) {
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
    public ResponseSearchQueueSystem getByIdProtocol(long idProtocol) {
        QueueSystem findByIdProtocol = repoQueueSystem.findByIdProtocol(idProtocol);

        ResponseSearchQueueSystem responseSearchQueueSystem1 = new ResponseSearchQueueSystem();

        if (findByIdProtocol == null) {
            responseSearchQueueSystem1.setQueueSystem(null);
            responseSearchQueueSystem1.setServerCode(100);
            responseSearchQueueSystem1.setServerMessage("getByByIdProtocol  search");

            logger.info("getByIdProtocol responseSearchQueueSystem1 : {}", responseSearchQueueSystem1.toString());

        } else {
            responseSearchQueueSystem1.setQueueSystem(findByIdProtocol);
            responseSearchQueueSystem1.setServerCode(200);
            responseSearchQueueSystem1.setServerMessage(" getByByIdProtocol found");
            logger.info("Error getByByIdProtocol responseSearchQueueSystem1 : {}", responseSearchQueueSystem1.toString());
        }
        return responseSearchQueueSystem1;
    }

        /**
         *  QueueSystem findByIdPersonal(long idPersonal);
         * @param idPersonal
         * @return
         */
        public ResponseSearchQueueSystem getByIdPersonal(long idPersonal){
            QueueSystem findByIdPersonal = repoQueueSystem.findByIdPersonal(idPersonal);

            ResponseSearchQueueSystem responseSearchQueueSystem = new ResponseSearchQueueSystem();

            if (findByIdPersonal == null) {
                responseSearchQueueSystem.setQueueSystem(null);
                responseSearchQueueSystem.setServerCode(100);
                responseSearchQueueSystem.setServerMessage("getByIdPersonal  search");

                logger.info("getByIdPersonal responseSearchQueueSystem1 : {}", responseSearchQueueSystem.toString());

            } else {
                responseSearchQueueSystem.setQueueSystem(findByIdPersonal);
                responseSearchQueueSystem.setServerCode(200);
                responseSearchQueueSystem.setServerMessage(" getByIdPersonal found");
                logger.info("Error getByIdPersonal responseSearchQueueSystem : {}", responseSearchQueueSystem.toString());
            }
            return responseSearchQueueSystem;
        }


    }



