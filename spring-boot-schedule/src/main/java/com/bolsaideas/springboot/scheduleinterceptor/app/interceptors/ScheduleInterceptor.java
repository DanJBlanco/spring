package com.bolsaideas.springboot.scheduleinterceptor.app.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Calendar;
import java.util.Objects;

@Component("schedule")
public class ScheduleInterceptor implements HandlerInterceptor {

    @Value("${config.schedule.open}")
    private int OPEN;

    @Value("${config.schedule.close}")
    private int CLOSE;

    private  static final String MSJ_ATTRIBUTE = "messageInterceptor";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        if (hour >= OPEN && hour < CLOSE){
            StringBuilder msj = new StringBuilder("Welcome to customer service hours");
            msj.append(", We are open from ");
            msj.append(OPEN);
            msj.append("hs to ");
            msj.append(CLOSE);
            msj.append("hs. Thank you for your visit.");

            request.setAttribute(MSJ_ATTRIBUTE, msj.toString());
            return true;
        }

        response.sendRedirect(request.getContextPath().concat("/close"));
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        String msj = (String) request.getAttribute(MSJ_ATTRIBUTE);
        if(Objects.nonNull(modelAndView)){
            modelAndView.addObject("schedule", msj);
        }
    }
}
