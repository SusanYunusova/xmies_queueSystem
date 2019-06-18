package az.contasoft.xmies_queueSystem.util;

import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;
import az.contasoft.xmies_queueSystem.db.repo.RepoQueueSystem;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class HazelCastUtility {

    private static Logger logger = LoggerFactory.getLogger("HazelCastUtility");

    @Autowired
    IMap<Long, QueueSystem> mapOfQueueSystem;

    @Autowired
    IMap<Long, Map<Long,QueueSystem>> mapOfQueueForPersonal;

    @Autowired
    RepoQueueSystem repoQueueSystem;

    public void addOrUpdateQueueSystemToHazelCast(QueueSystem queueSystem) {
        logger.info("{}", "Trying to add or update QueueSystem to hazelcast.. " + queueSystem.toString());
        Map<Long,QueueSystem> mapForPersonal = mapOfQueueForPersonal.get(queueSystem.getIdPersonal());
        if(mapForPersonal==null){
            mapForPersonal = new HashMap<>();
            mapForPersonal.put(queueSystem.getIdQueueSystem(),queueSystem);

        }else{
            mapForPersonal.put(queueSystem.getIdQueueSystem(),queueSystem);
        }
        mapOfQueueForPersonal.put(queueSystem.getIdPersonal(),mapForPersonal);
        mapOfQueueSystem.put(queueSystem.getIdQueueSystem(), queueSystem);
    }

    public void deleteQueueSystemFromHazelCast(Long id) {
        logger.info("{}", "Trying to remove queueSystem from hazelCast");
        mapOfQueueSystem.remove(id);
    }

    public IMap<Long, QueueSystem> getMapOfQueueSystem() {
        return mapOfQueueSystem;
    }

    public void startCaching() {
        try {
            logger.info("{}", "Trying to get queue list for current date");
            List<QueueSystem> listOfQueueSystem = repoQueueSystem.findAllByEnteredDate(new SimpleDateFormat().parse("yyyy-MM-dd"));
            logger.info("{}", "Trying to start caching for map QueueSystem");
            for (QueueSystem queueSystem : listOfQueueSystem) {
                Map<Long,QueueSystem> mapOfQueueSystemForPersonal = mapOfQueueForPersonal.get(queueSystem.getIdPersonal());
                if (mapOfQueueSystemForPersonal == null) {
                    logger.info("{}","mapOfQueueSystemForPersonal=null nad creating new hashMap");
                    Map<Long,QueueSystem> map = new HashMap<>();
                    map.put(queueSystem.getIdQueueSystem(),queueSystem);
                    mapOfQueueForPersonal.put(queueSystem.getIdPersonal(),map);
                }else{
                    logger.info("{}","caching map for quququ system");
                    mapOfQueueSystemForPersonal.put(queueSystem.getIdQueueSystem(),queueSystem);
                    mapOfQueueForPersonal.put(queueSystem.getIdPersonal(),mapOfQueueSystemForPersonal);
                }

                mapOfQueueSystem.put(queueSystem.getIdQueueSystem(), queueSystem);
            }
        } catch (Exception e) {
          logger.error("Error {} : {}","to get list for current date",e,e);

        }
    }


}
