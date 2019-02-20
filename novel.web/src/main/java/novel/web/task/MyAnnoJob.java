package novel.web.task;

import novel.storage.Processor;
import novel.storage.impl.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author
 * @create 2018-06-30 17:44
 **/
@Component
public class MyAnnoJob {
    @Scheduled(cron = "0 0 5 1/1 * ?")
    // 每天凌晨五点执行一次
    public void test() throws Exception {
//        Processor ts = new TunShiNovelStorageImpl();
//        ts.process("batchUpdate",5);
//        Processor xs58 = new XiaoShuo58NovelStorageImpl();
//        xs58.process("batchUpdate",5);
//        Processor ddxs = new DdxsNovelStorageImpl();
//        ddxs.process("batchUpdate",5);
//        Processor ksz = new KanShuZhongNovelStorageImpl();
//        ksz.process("batchUpdate",5);
//        Processor bxwx = new BxwxNovelStorageImpl();
//        bxwx.process("batchUpdate",5);
    }
    public static void main(String[] args) throws Exception {
        new MyAnnoJob().test();
    }
}
