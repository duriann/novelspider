package novel.web.dao;


import novel.web.entitys.SearchHistory;

public interface SearchHistoryDao {
	public int insert(SearchHistory searchHistory);
	public SearchHistory getByKeyword(String keyword);
	public void updateByKeyword(String keyword);
}
