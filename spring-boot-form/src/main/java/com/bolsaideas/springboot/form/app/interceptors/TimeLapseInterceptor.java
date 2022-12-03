package com.bolsaideas.springboot.form.app.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Random;

@Component("timeLapse")
public class TimeLapseInterceptor implements HandlerInterceptor {

    private static final Logger LOGGER = LoggerFactory.getLogger(TimeLapseInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        LOGGER.info("TimeLapseInterceptor: preHandle() in ...");
        long initTime = System.currentTimeMillis();
        request.setAttribute("initTime", initTime);
        Random random = new Random();
        int stop = random.nextInt(500);
        Thread.sleep(stop);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.info("TimeLapseInterceptor: postHandle() out ...");
        long finishTime = System.currentTimeMillis();
        long initTime = (Long) request.getAttribute("initTime");

        long timeLapse = finishTime - initTime;

        if(Objects.nonNull(modelAndView)){
            modelAndView.addObject("timeLapse", timeLapse);
        }
        LOGGER.info("TimeLapseInterceptor: postHandle() timeLapse: {}ms", timeLapse);

    }
}
