package novel.storage.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.SQLException;

public class MybatisUtil {
    private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sqlSessionFactory;
    static{
        try {
            Reader reader = Resources.getResourceAsReader("conf/SqlMapConfig.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    /**
     * 禁止外界通过new方法创建
     */
    private MybatisUtil(){}

    /**
     * 获取SqlSession
     */
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession==null){
            sqlSession = sqlSessionFactory.openSession(true);
            threadLocal.set(sqlSession);
        }
        return sqlSession;
    }
    //关闭SqlSession
    public static void closeSqlSession(){
        SqlSession sqlSession = threadLocal.get();
        if(sqlSession!=null){
            sqlSession.close();
            threadLocal.remove();
        }
    }

    public static void main(String[] args) throws SQLException {
        Connection conn = MybatisUtil.getSqlSession().getConnection();
        System.out.println(conn!=null?"连接成功":"连接失败");
        conn.close();
    }
}
