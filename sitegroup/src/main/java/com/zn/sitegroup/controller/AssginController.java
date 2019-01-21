package com.zn.sitegroup.controller;


import com.zn.sitegroup.service.AssignService;
import com.zn.sitegroup.utils.CommandUtil;
import com.zn.sitegroup.utils.StringUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by zn on 2018/12/19.
 */
//@Controller
@Slf4j
public class AssginController {
//    @Autowired
//    AssignService createAssignDataSqlFileService;
//
//    //@RequestMapping("value=/assgin.do")
//    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
//        ModelAndView modelAndView = new ModelAndView();
//        log.info("收到请求，开始导出数据....");
//        String categoryId = httpServletRequest.getParameter("category_id");
//        String command = httpServletRequest.getParameter("command");
//        if(StringUtil.isBlank(categoryId)) {
//            categoryId = "0";
//        }
//        long start = System.currentTimeMillis();
//        createAssignDataSqlFileService.createSqlFileByCategoryID(Integer.parseInt(categoryId));
//        long end = System.currentTimeMillis();
//        String message =  "数据导出完毕，耗时" + ((end - start)/1000)+"秒</br>";
//        log.info("数据导出完毕，耗时:{}秒,开始执行入库操作",(end - start));
//        CommandUtil.execute(command);
//        start = System.currentTimeMillis();
//        log.info("入库完毕，耗时:{}秒",(start - end));
//        message += "入库完毕，耗时"+ (start - end)/1000 +"秒";
//        modelAndView.addObject("message",message);
//        modelAndView.setViewName("index");
//        return modelAndView;
//    }
}
