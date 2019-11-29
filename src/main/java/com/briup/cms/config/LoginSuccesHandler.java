package com.briup.cms.config;

import com.briup.cms.util.JwtTokenUtils;
import com.briup.cms.util.Message;
import com.briup.cms.util.MessageUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *  登陆成功处理器
 */
public class LoginSuccesHandler implements AuthenticationSuccessHandler {
    @Autowired
    @Qualifier("userDetailServiceImpl")
    private UserDetailsService userDetailsService;
    /**
     *  将对象转JSON数据
     *  springMVC自动加载
     */
    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        response.setContentType("application/json;charset=utf-8");
        try {
            //得到用户名（角色也可得）
            UserDetails userDetails = userDetailsService.loadUserByUsername(authentication.getName());
            //创建token
            String token = JwtTokenUtils.createToken(userDetails, false);
            //拼接前缀
            token = JwtTokenUtils.TOKEN_PREFIX + token;
            //返回请求头中
            response.setHeader(JwtTokenUtils.TOKEN_HEADER,token);
            //转化JSON数据
            Message<String> message = MessageUtil.success(token);
            response.getWriter().println(objectMapper.writeValueAsString(message));
        } catch (Exception e) {
            Message<Object> message = MessageUtil.error(403, "登陆失败");
            response.getWriter().println(objectMapper.writeValueAsString(message));
        }


    }
}
