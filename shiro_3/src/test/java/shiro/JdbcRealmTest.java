package shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class JdbcRealmTest {

	public static void main(String[] args) {
		Factory<SecurityManager> factory=new IniSecurityManagerFactory("classpath:jdbc_realm.ini");
		SecurityManager securityManager=factory.getInstance();
		SecurityUtils.setSecurityManager(securityManager);
		Subject currentUser=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken("acey", "123456");
		try{
			currentUser.login(token);
			System.out.println("登录成功");
		}catch(AuthenticationException e){
			e.printStackTrace();
			System.out.println("登录失败");
		}
		currentUser.logout();
	}
}
