package com.leecx.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class LeeExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";
	
//    @ExceptionHandler(value = Exception.class)
//    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
//    	
//    	e.printStackTrace();
//    	
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("exception", e);
//        mav.addObject("url", req.getRequestURL());
//        mav.setViewName(DEFAULT_ERROR_VIEW);
//        
//        return mav;
//    }
    
    @ExceptionHandler(value = Exception.class)
    public Object errorHandler(HttpServletRequest reqest, HttpServletResponse response, Exception e) throws Exception {
    	
    	e.printStackTrace();
    	
    	if (isAjax(reqest)) {
    		return response;
    	} else {
    		ModelAndView mav = new ModelAndView();
            mav.addObject("exception", e);
            mav.addObject("url", reqest.getRequestURL());
            mav.setViewName(DEFAULT_ERROR_VIEW);
            return mav;
    	}
    }
	
	/**
	 * 
	 * @Description: 判断是否Ajax请求
	 * @param request
	 * @return
	 * 
	 * @author leechenxiang
	 * @date 2016年11月23日 下午8:51:04
	 */
	public static boolean isAjax(HttpServletRequest httpRequest){
		return  (httpRequest.getHeader("X-Requested-With") != null  && "XMLHttpRequest".equals( httpRequest.getHeader("X-Requested-With").toString()) ) ;
	}
}
