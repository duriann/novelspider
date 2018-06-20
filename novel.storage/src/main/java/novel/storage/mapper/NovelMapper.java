package novel.storage.mapper;

import novel.spider.entitys.Novel;

import java.util.List;
import java.util.Map;

public interface NovelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Novel record);

    int insertSelective(Novel record);

    Novel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Novel record);

    int updateByPrimaryKey(Novel record);
    
    void batchInsert(List<Novel> novels);

    void batchUpdate(List<Novel> novels);

    List<String> selectUrl();
    List<String> selectByPlatformAndStatus(Map<String,String> map);
}