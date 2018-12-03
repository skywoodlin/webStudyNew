import com.xjlin.dao.XmlUserDao;
import com.xjlin.domain.User;
import org.junit.Test;

public class XmlUserDaoTest{
	@Test
	public void testFindUserByUserName(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUserName("admin");
		System.out.println(user);
	}
	
	@Test
	public void testFindUserByNMandPSW(){
		XmlUserDao dao = new XmlUserDao();
		User user = dao.findUserByUNandPSW("admin", "admin");
		System.out.println(user);
	}
	
	@Test
	public void testAddUser(){
		XmlUserDao dao = new XmlUserDao();
		User user = new User();
		user.setUsername("朴乾");
		user.setPassword("123");
		user.setNickname("小朴朴");
		user.setEmail("piaoqian@itcast.cn");
		dao.addUser(user);
	}
}
