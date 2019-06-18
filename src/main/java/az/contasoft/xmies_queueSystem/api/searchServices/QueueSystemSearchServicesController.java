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

    /**
     *  .----------------.  .----------------.  .----------------.  .----------------.
     * | .--------------. || .--------------. || .--------------. || .--------------. |
     * | |    _______   | || | _____  _____ | || |   ________   | || |  ____  ____  | |
     * | |   /  ___  |  | || ||_   _||_   _|| || |  |  __   _|  | || | |_  _||_  _| | |
     * | |  |  (__ \_|  | || |  | |    | |  | || |  |_/  / /    | || |   \ \  / /   | |
     * | |   '.___`-.   | || |  | '    ' |  | || |     .'.' _   | || |    \ \/ /    | |
     * | |  |`\____) |  | || |   \ `--' /   | || |   _/ /__/ |  | || |    _|  |_    | |
     * | |  |_______.'  | || |    `.__.'    | || |  |________|  | || |   |______|   | |
     * | |              | || |              | || |              | || |              | |
     * | '--------------' || '--------------' || '--------------' || '--------------' |
     *  '----------------'  '----------------'  '----------------'  '----------------'
     * @return
     */
    /**
     * .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .-----------------.
     * | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |
     * | |  ____  ____  | || |  _________   | || |  _______     | || |   ________   | || |      __      | || | ____    ____ | || |      __      | || | ____  _____  | |
     * | | |_   ||   _| | || | |_   ___  |  | || | |_   __ \    | || |  |  __   _|  | || |     /  \     | || ||_   \  /   _|| || |     /  \     | || ||_   \|_   _| | |
     * | |   | |__| |   | || |   | |_  \_|  | || |   | |__) |   | || |  |_/  / /    | || |    / /\ \    | || |  |   \/   |  | || |    / /\ \    | || |  |   \ | |   | |
     * | |   |  __  |   | || |   |  _|  _   | || |   |  __ /    | || |     .'.' _   | || |   / ____ \   | || |  | |\  /| |  | || |   / ____ \   | || |  | |\ \| |   | |
     * | |  _| |  | |_  | || |  _| |___/ |  | || |  _| |  \ \_  | || |   _/ /__/ |  | || | _/ /    \ \_ | || | _| |_\/_| |_ | || | _/ /    \ \_ | || | _| |_\   |_  | |
     * | | |____||____| | || | |_________|  | || | |____| |___| | || |  |________|  | || ||____|  |____|| || ||_____||_____|| || ||____|  |____|| || ||_____|\____| | |
     * | |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | |
     * | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |
     *  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'
     * @return
     */
    /**
     * .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.  .----------------.
     * | .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. || .--------------. |
     * | |  ____  ____  | || |      __      | || |  ___  ____   | || |   _____      | || |     _____    | || |  ________    | || |     _____    | || |  _______     | || |              | |
     * | | |_   ||   _| | || |     /  \     | || | |_  ||_  _|  | || |  |_   _|     | || |    |_   _|   | || | |_   ___ `.  | || |    |_   _|   | || | |_   __ \    | || |      _       | |
     * | |   | |__| |   | || |    / /\ \    | || |   | |_/ /    | || |    | |       | || |      | |     | || |   | |   `. \ | || |      | |     | || |   | |__) |   | || |     | |      | |
     * | |   |  __  |   | || |   / ____ \   | || |   |  __'.    | || |    | |   _   | || |      | |     | || |   | |    | | | || |      | |     | || |   |  __ /    | || |     | |      | |
     * | |  _| |  | |_  | || | _/ /    \ \_ | || |  _| |  \ \_  | || |   _| |__/ |  | || |     _| |_    | || |  _| |___.' / | || |     _| |_    | || |  _| |  \ \_  | || |     | |      | |
     * | | |____||____| | || ||____|  |____|| || | |____||____| | || |  |________|  | || |    |_____|   | || | |________.'  | || |    |_____|   | || | |____| |___| | || |     |_|      | |
     * | |              | || |              | || |              | || |              | || |              | || |              | || |              | || |              | || |     (_)      | |
     * | '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' || '--------------' |
     *  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'  '----------------'
     *  .----------------.  .----------------.
     * | .--------------. || .--------------. |
     * | |              | || |              | |
     * | |      _       | || |      _       | |
     * | |     | |      | || |     | |      | |
     * | |     | |      | || |     | |      | |
     * | |     | |      | || |     | |      | |
     * | |     |_|      | || |     |_|      | |
     * | |     (_)      | || |     (_)      | |
     * | '--------------' || '--------------' |
     *  '----------------'  '----------------'
     * @return
     */
    @GetMapping("/getAll")
    public ResponseEntity<List<QueueSystem>> getAll() {
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
