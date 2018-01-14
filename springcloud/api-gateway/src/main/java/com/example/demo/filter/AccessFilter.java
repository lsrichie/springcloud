/**
 * sinafenqi.com
 * Copyright (c) 2017 All Rights Reserved.
 */
package com.example.demo.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * @author lisong
 * @version $Id: AccessFilter.java, v 0.1 2017-12-12 14:30 lisong Exp $$
 */
public class AccessFilter extends ZuulFilter {
    private static final Logger logger = LoggerFactory.getLogger(AccessFilter.class);

    /**
     * 过滤器类型，决定过滤器在哪个生命周期执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器执行顺序，当有多个过滤器时，此处设置有效果
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return ctx.sendZuulResponse();
    }

    @Override
    public Object run() {
        /*RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        logger.info("send {} request to {}", request.getMethod(),
            request.getRequestURL().toString());
        Object accessToken = request.getParameter("accessToken");
        
        if (accessToken == null) {
            logger.warn("access token is empty!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        logger.info("ok");*/
        return null;
    }
}
