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
        Processor processor = new TunShiNovelStorageImpl();
        processor.process("batchUpdate",5);
        processor = new XiaoShuo58NovelStorageImpl();
        processor.process("batchUpdate",5);
        processor = new DdxsNovelStorageImpl();
        processor.process("batchUpdate",5);
        processor = new KanShuZhongNovelStorageImpl();
        processor.process("batchUpdate",5);
        processor = new BxwxNovelStorageImpl();
        processor.process("batchUpdate",5);
    }
    public static void main(String[] args) throws Exception {
        new MyAnnoJob().test();
    }
}
