package novel.storage;

import novel.storage.impl.BxwxNovelStorageImpl;
import novel.storage.impl.KanShuZhongNovelStorageImpl;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Testcase {
    public String insert = "batchInsert";
    public String update = "batchUpdate";

    /**
     * 测试mybatis连接是否正常
     * @throws Exception
     */
    @Test
	public void testMybatisConnection () throws Exception {
		SqlSession session = new SqlSessionFactoryBuilder().build(new FileInputStream("conf/SqlMapConfig.xml")).openSession();
		System.out.println(session);
	}

    /**
     * 抓取看书中小说
     * @throws Exception
     */
	@Test
	public void testKanShuZhongProcess() throws Exception {
		Processor processor = new KanShuZhongNovelStorageImpl();
		processor.process(insert);
	}

    /**
     * 抓取笔下文学小说
     * @throws FileNotFoundException
     */
	@Test
	public void testBxwxProcess() throws FileNotFoundException {
		Processor processor = new BxwxNovelStorageImpl();
		processor.process(insert,5);
	}

    /**
     * 更新笔下文学小说 20180428 15:30 好像网站挂了 更新失败
     * @throws FileNotFoundException
     */
    @Test
	public void updateBxwxProcess() throws FileNotFoundException {
	    Processor processor = new BxwxNovelStorageImpl();
	    processor.process(update);
    }

    /**
     * 更新看书中小说
     * @throws FileNotFoundException
     */
    @Test
    public void updateKanShuZhongProcess() throws FileNotFoundException {
        Processor processor = new KanShuZhongNovelStorageImpl();
        processor.process(update);
    }

}
