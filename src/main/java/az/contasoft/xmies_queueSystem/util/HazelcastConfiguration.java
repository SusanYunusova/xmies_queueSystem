package az.contasoft.xmies_queueSystem.util;

import az.contasoft.xmies_queueSystem.db.entity.QueueSystem;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class HazelcastConfiguration {

    @Bean
    public Config config(){
        return new Config();
    }

    @Bean
    public HazelcastInstance instance(Config config){
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public IMap<Long, QueueSystem> mapOfQueueSystem(HazelcastInstance instance){
        return instance.getMap("mapOfQueueSystem");
    }

    @Bean
    public IMap<Long, Map<Long,QueueSystem>> mapOfQueueForPersonal(HazelcastInstance instance){
        return  instance.getMap("mapOfQueueForPersonal");
    }
}
