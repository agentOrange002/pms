package sys.app.pms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sys.app.pms.entity.User;
import sys.app.pms.repository.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao userDao;

	@Override
	public boolean saveUser(User user) {				
		return userDao.saveUser(user);
	}

	@Override
	public List<User> fetchAllUser() {		
		return userDao.fetchAllUser();
	}

	@Override
	public Object fetchUserById(String id) {		 
		return userDao.fetchUserById(id);
	}

}
