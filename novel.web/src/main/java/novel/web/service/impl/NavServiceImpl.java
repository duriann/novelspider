package novel.web.service.impl;

import novel.web.dao.NavDao;
import novel.web.entitys.index.Nav;
import novel.web.service.NavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class NavServiceImpl implements NavService {

    @Autowired
    private NavDao navDao;
    @Override
    public List<Nav> getAllNav() {
        return navDao.list();
    }
}
