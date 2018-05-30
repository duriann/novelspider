package novel.web.utils;

import novel.web.constants.Constants;
import novel.web.entitys.Token;

import java.util.UUID;

public class RedisTokenManager {

    private RedisUtil redisUtil;

    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    public Token createToken(long userId) {
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        Token model = new Token(userId, userId+"_"+token);
        //存储到redis并设置过期时间
        redisUtil.set(""+userId,model.getToken(),Constants.TOKEN_EXPIRES_HOUR);
        return model;
    }

    public Token getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        long userId = Long.parseLong(param[0]);
        //String token = param[1];
        return new Token(userId, authentication);
    }

    public boolean checkToken(Token model) {
        if (model == null) {
            return false;
        }
        String token = (String)redisUtil.get(model.getUser_id()+"");
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redisUtil.expire(model.getUser_id()+"",Constants.TOKEN_EXPIRES_HOUR);
        return true;
    }

    public void deleteToken(long userId) {
        redisUtil.del(userId+"");
    }
}
