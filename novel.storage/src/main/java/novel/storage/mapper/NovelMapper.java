package novel.storage.mapper;

import java.util.List;

import novel.spider.entitys.Novel;

public interface NovelMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Novel record);

    int insertSelective(Novel record);

    Novel selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Novel record);

    int updateByPrimaryKey(Novel record);
    
    public void batchInsert(List<Novel> novels);
}