package sys.app.pms.repository;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import sys.app.pms.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
	Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);
	
	 @SuppressWarnings("rawtypes")
	private HashOperations hashOperations;
	    public UserDaoImpl(@SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {
	        this.hashOperations = redisTemplate.opsForHash();
	    }
	
	private static final String KEY = "USERS";

	@SuppressWarnings("unchecked")
	@Override
	public boolean saveUser(User user) {
		boolean result = false;
		try {
			hashOperations.put(KEY,user.getUserId().toString(),user);
			result = true;
		}
		catch(Exception e) {
			e.printStackTrace();
			result = false;
		}
		
		return result;
	}

	@Override
	public List<User> fetchAllUser() {	
		@SuppressWarnings("unchecked")
		List<User>users=hashOperations.values(KEY);
		return users;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Object fetchUserById(String id) {	
	
		
		return hashOperations.get(KEY, id);
	} 

}
