package com.zn.sitegroup.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zn.sitegroup.ApplicationConfig;
import com.zn.sitegroup.dto.CategoryDto;
import com.zn.sitegroup.jsonbean.CategoryJsonBean;
import com.zn.sitegroup.service.AssignService;
import com.zn.sitegroup.service.CategoryService;
import com.zn.sitegroup.utils.StringUtil;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 * Created by zn on 2019/1/22.
 */
@WebServlet(name = "category_json",urlPatterns = "/category.json")
public class CategoryJsonServlet extends HttpServlet {
    private CategoryService categoryService;
    @Override
    public void init() throws ServletException {
        super.init();
        ServletContext application = this.getServletContext();
        String configFolder = application.getAttribute("configFolder").toString();
        String applicationPath = application.getAttribute("applicationPath").toString();
        ApplicationContext context = new FileSystemXmlApplicationContext(applicationPath);
        categoryService = (CategoryService)context.getBean("categoryService");
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(configFolder+"site_group.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long categoryId = 0;
        if(!StringUtil.isBlank(request.getParameter("category_id"))) {
            categoryId = Long.parseLong(request.getParameter("category_id").toString());
        }
//        List<CategoryDto> list = categoryService.findCategory(categoryId);
        List<CategoryDto> list = new ArrayList<>();
        // 拿到当前所有的父类。
    // 逻辑，如果categoryId < 1, 表示是拿到所有的分类。如果不是，则表示是拿到当前分类的数据
        if(categoryId > 0 ) {// 拿到当前的分类信息
//            list.addAll(categoryService.findCategory(categoryId));
            list.addAll(categoryService.findChildParents(categoryId));
        }
        list.addAll(categoryService.findParentAllChildern(categoryId));
        List<CategoryJsonBean> jsonBeans = new ArrayList<>();
        CategoryJsonBean categoryJsonBean = null;
        for(CategoryDto dto : list) {
            categoryJsonBean = new CategoryJsonBean();
            categoryJsonBean.setId(dto.getCategoryId());
            categoryJsonBean.setText(dto.getName());
            categoryJsonBean.setParentId(dto.getParentId());
            jsonBeans.add(categoryJsonBean);
        }
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(jsonBeans);
        response.setHeader("content-type","application/x-json");
        PrintWriter writer = response.getWriter();
        writer.write(json);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
