package sys.app.pms.repository;

import java.util.List;

import sys.app.pms.entity.User;

public interface UserDao {

	boolean saveUser(User user);

	List<User> fetchAllUser();

	Object fetchUserById(String id);

}
