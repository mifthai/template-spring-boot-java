package io.recruitment.assessment.api.config;

import io.recruitment.assessment.api.model.UserType;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.*;

/**
 * <p>Title       :   AuthInterceptor
 * <p>Description :
 */
public class AuthInterceptor implements HandlerInterceptor {
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    if ("/excercise/product/save".equals(request.getRequestURI()) &&
        !UserType.ADMIN.equals(UserType.getUserType(Integer.parseInt(request.getParameter("userType"))))){
      response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
      return false;
    }

    return true;
  }
}

