package az.contasoft.xmies_queueSystem.api.searchServices;


import az.contasoft.xmies_queueSystem.api.searchServices.internal.ResponseSearchListQueueSystem;
import az.contasoft.xmies_queueSystem.api.searchServices.internal.ResponseSearchQueueSystem;
import az.contasoft.xmies_queueSystem.api.searchServices.internalService.QueueSystemSearchInternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/searchServices")
public  class  QueueSystemSearchServicesController{


    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    QueueSystemSearchInternalService queueSystemSearchInternalService;
@GetMapping
    public ResponseSearchListQueueSystem getAll() {
    logger.info("search -> controller -> All request : {}");

    return  queueSystemSearchInternalService.getAll();



    }

    @GetMapping("/getByIdQueueSystem/{idQueueSystem}")
    public ResponseSearchQueueSystem getByIdQueueSystem(long idQueueSystem) {
        logger.info("search -> controller -> request : {}", idQueueSystem);


        return  queueSystemSearchInternalService.getByIdQueueSystem(idQueueSystem);


    }
@GetMapping("/getByByIdProtocol/{idProtocol}")
    public ResponseSearchQueueSystem getByByIdProtocol(long idProtocol) {

    return  queueSystemSearchInternalService.getByIdProtocol(idProtocol);

}@GetMapping("/getByIdPersonal/{idPersonal}")
    public ResponseSearchQueueSystem getByIdPersonal(long idPersonal) {

    return  queueSystemSearchInternalService.getByIdPersonal(idPersonal);

}

}
