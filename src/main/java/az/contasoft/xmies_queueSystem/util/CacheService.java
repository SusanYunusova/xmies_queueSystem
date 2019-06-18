package az.contasoft.xmies_queueSystem.util;

import az.contasoft.xmies_queueSystem.db.repo.RepoQueueSystem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

@Component
public class CacheService {

    @Autowired
    RepoQueueSystem repoQueueSystem;

    @PostConstruct
    public void init(){
        //starting caching queue system
    }

}
