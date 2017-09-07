package interceptors;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor {

	public void destroy() {
	}

	public void init() {
		
		}

	public String intercept(ActionInvocation ai) throws Exception {
		// TODO Auto-generated method stub
		
		ActionContext ac = ai.getInvocationContext();
		Map<String, Object> session = ac.getSession();
		
		Object e = session.get("userid");
		if(e==null){
			return "agin";
		}else{
			return ai.invoke();
		}
		
	}

}
