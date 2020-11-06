package sys.app.pms.service;

import java.util.List;

import sys.app.pms.entity.User;

public interface UserService {

	boolean saveUser(User user);

	List<User> fetchAllUser();

	Object fetchUserById(String id);

}
