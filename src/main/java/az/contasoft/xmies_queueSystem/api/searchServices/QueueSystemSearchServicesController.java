package az.contasoft.xmies_queueSystem.api.searchServices;


import az.contasoft.xmies_queueSystem.api.searchServices.internal.ResponseSearchListQueueSystem;
import az.contasoft.xmies_queueSystem.api.searchServices.internalService.QueueSystemSearchInternalService;
import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/searchServices")
public class QueueSystemSearchServicesController {


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    QueueSystemSearchInternalService queueSystemSearchInternalService;


    @GetMapping("/getAll")
    public ResponseSearchListQueueSystem getAll() {
        logger.info("search -> controller -> All request : {}");

        return queueSystemSearchInternalService.getAll();

    }

    @GetMapping("/getIdQueueSystem/{idQueueSystem}")
    public ResponseEntity<QueueSystem> getByIdQueueSystem(@PathVariable("idQueueSystem") long idQueueSystem) {
        logger.info("search -> controller -> request : {}", idQueueSystem);


        return queueSystemSearchInternalService.getByIdQueueSystem(idQueueSystem);

    }

//    @GetMapping("/getIdProtocol/{idProtocol}")
//    public ResponseSearchListQueueSystem getAllByIdProtocol(@PathVariable("idProtocol") long idProtocol) {
//
//        return queueSystemSearchInternalService.getAllByIdProtocol(idProtocol);
//    }

    @GetMapping("/getIdPersonal/{idPersonal}")
    public ResponseEntity<List<QueueSystem>> getAllByIdPersonal(@PathVariable("idPersonal") long idPersonal,@PathVariable("idProtocol") long idProtocol) {

        return queueSystemSearchInternalService.getAllByIdPersonalAndIdProtocol(idPersonal,idProtocol);
    }


    @GetMapping("/getQueueCount/{idPersonal}")
    public ResponseEntity<Integer> getCount(@PathVariable("idPersonal") long idPersonal){
        return queueSystemSearchInternalService.getCount(idPersonal);
    }
}
