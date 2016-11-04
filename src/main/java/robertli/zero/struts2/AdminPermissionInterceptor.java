/*
 * Copyright 2016 Robert Li.
 * Released under the MIT license
 * https://opensource.org/licenses/MIT
 */
package robertli.zero.struts2;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import robertli.zero.action.admin.AdminLoginAction;
import robertli.zero.entity.Admin;
import robertli.zero.service.AdminService;

/**
 * This is a struts2 interceptor. This one will be use for the package
 * robertli.zero.action.admin.* <br>
 *
 * This interceptor will be used before defaultStack, and we will use it for
 * redirect to login page
 *
 * @version 1.0 2016-09-25
 * @author Robert Li
 */
public class AdminPermissionInterceptor implements Interceptor {

    @Resource
    private AdminService adminService;

    @Override
    public void destroy() {
    }

    @Override
    public void init() {
    }

    private boolean isRootAdmin(Admin admin) {
        if (admin == null) {
            return false;
        }
        String username = admin.getUsername();
        return !(username == null || username.equals("root") == false);
    }

    @Override
    public String intercept(ActionInvocation ai) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String sessionId = request.getSession().getId();
        Admin admin = adminService.getCurrentAdmin(sessionId);
        if (admin == null && ai.getAction() instanceof AdminLoginAction == false) {
            return "login";
        } else if (isRootAdmin(admin) == false && ai.getAction() instanceof AdminRootPermission) {
            return "login";
        }
        return ai.invoke();
    }

}
