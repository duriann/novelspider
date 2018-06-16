package novel.web.dao;

import novel.spider.entitys.Novel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
public interface NovelDao {
	public int deleteByPrimaryKey(Long id);

	int insert(Novel record);

    public int insertSelective(Novel record);

    public Novel selectByPrimaryKey(Long id);

    public int updateByPrimaryKeySelective(Novel record);

    public int updateByPrimaryKey(Novel record);
    
    public void batchInsert(List<Novel> novels);
    public List<Novel> getsNovelByKeyword(String keyword);
    public List<Novel> getsNovelByKeyword2(Map<String, String> map);
    //根据对应关键词分页
    public List<Novel> getNovelByPage(Map<String,Object> map);
    //获取所有小说
    public List<Novel> getAllNovelByPage(Map<String,Object> map);

    //获取对应关键字总记录数
    public int getNovelTotalCount(String keyword);

    //获取所有小说数量
    public int getAllNovelTotalCount();

    public List<String> searchLikeByKey(String key);
}