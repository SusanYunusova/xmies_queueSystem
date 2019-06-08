package az.contasoft.xmies_queueSystem.util;

import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HazelCastUtility {
    private static HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance();
    private static Logger logger = LoggerFactory.getLogger("HazelCastUtility");

    public static HazelcastInstance getHazelcastInstance(){
        if(hazelcastInstance == null){
            hazelcastInstance = Hazelcast.newHazelcastInstance();
        }
        return hazelcastInstance;
    }

    public static void addOrUpdatePersonalToHazelCast(QueueSystem queueSystem) {
        logger.info("{}", "Trying to add or update queueSystem to hazelcast.. " + queueSystem.toString());
        IMap<Long, QueueSystem> mapOfQueueSystem = getHazelcastInstance().getMap("queueSystem");
        mapOfQueueSystem.put(queueSystem.getIdPersonal(), queueSystem);
    }

    public static void deletePersonalFromHazelCast(Long id) {
        logger.info("{}", "Trying to remove queueSystem from hazelCast");
        IMap<Long, QueueSystem> mapOfQueueSystem = getHazelcastInstance().getMap("queueSystem");
        mapOfQueueSystem.remove(id);
    }

    public static IMap<Long, QueueSystem> getMapOfPersonal(){
        IMap<Long, QueueSystem> mapOfQueueSystem = getHazelcastInstance().getMap("queueSystem");
        return mapOfQueueSystem;
    }

    public static QueueSystem getQueueSystemFromHazelCast(int idQueueSystem){
        IMap<Long, QueueSystem> mapOfQueueSystem = getHazelcastInstance().getMap("queueSystem");
        return mapOfQueueSystem.get(idQueueSystem);
    }
}
