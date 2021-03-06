package az.contasoft.xmies_queueSystem.api.crudServices;

import az.contasoft.xmies_queueSystem.api.crudServices.internal.QueueSystemResponse;
import az.contasoft.xmies_queueSystem.api.crudServices.internal.SaveQueueSystemRequest;
import az.contasoft.xmies_queueSystem.api.crudServices.internal.UpdateQueueSystemRequest;
import az.contasoft.xmies_queueSystem.api.crudServices.internalService.QueueSystemCrudInternalService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crudServices")
public class QueueSystemCrudServiceController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    QueueSystemCrudInternalService queueSystemCrudInternalService;

    @PostMapping("/add")
    public QueueSystemResponse saveQueueSystem(@RequestBody SaveQueueSystemRequest saveQueueSystemRequest) {
        logger.info("xmies_queueSystem->add->request : {}" + saveQueueSystemRequest.toString());
        return queueSystemCrudInternalService.saveQueueSystem(saveQueueSystemRequest);

    }

    @PostMapping("/update")
    public QueueSystemResponse updateQueueSystem(@RequestBody UpdateQueueSystemRequest updateQueueSystemRequest) {

        logger.info("xmies_queueSystem->update->request : {}" + updateQueueSystemRequest.toString());

        return queueSystemCrudInternalService.updateQueueSystem(updateQueueSystemRequest);

    }

//    @GetMapping("/delete/{deleteDocumentRequest}")
//    public DocumentResponse deleteDocument(@PathVariable DeleteDocumentRequest deleteDocumentRequest){
//        logger.info("esd_jobs->delete->request : {}"+deleteDocumentRequest.toString());
//
//        return queueSystemCrudInternalService.deleteIdDocument(deleteDocumentRequest);
//    }

    @GetMapping("/delete/{idQueueSystem}/{idPersonal}")
    public QueueSystemResponse deleteQueueSystem(@PathVariable("idQueueSystem") long idQueueSystem,
                                                 @PathVariable("idPersonal") long idPersonal) {
        return queueSystemCrudInternalService.deleteIdQueueSystem(idQueueSystem, idPersonal);
    }
}
