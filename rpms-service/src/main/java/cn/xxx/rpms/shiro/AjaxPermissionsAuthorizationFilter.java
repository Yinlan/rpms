package cn.xxx.rpms.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.StringUtils;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * PermissionsAuthorizationFilter:
 * 解决shiro对权限的拦截，发送ajax请求出现undefined问题
 */
public class AjaxPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter {
    /**
     *
     *
     * @param request
     * @param response
     * @return
     * @throws IOException
     *思路：
     * 覆写onAccessDenied方法，通过判断请求头来确定是否是ajax请求
     * 在通过返回resp输出流输出输出json字符串（转移字符）
     * 配置
     *
     */

    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
        Subject subject = this.getSubject(request, response);
        if (subject.getPrincipal() == null) {
            this.saveRequestAndRedirectToLogin(request, response);
        } else {
            //没有权限进入
            HttpServletRequest req= (HttpServletRequest) request;
            HttpServletResponse resp= (HttpServletResponse) response;
            String xRequestedWith = req.getHeader("X-Requested-With");
            //判断是否ajax请求LHttpRequest
            if("XMLHttpRequest".equals(xRequestedWith)){
                resp.setContentType("javaScript/json; charset=UTF-8");
                resp.getWriter().print("{\"success\":false,\"msg\":\"没有权限做这个操作\"}");
                System.out.println(11111);
                return false;
            }
            String unauthorizedUrl = this.getUnauthorizedUrl();
            if (StringUtils.hasText(unauthorizedUrl)) {
                WebUtils.issueRedirect(request, response, unauthorizedUrl);
            } else {
                WebUtils.toHttp(response).sendError(401);
            }
        }

        return false;
    }
}
