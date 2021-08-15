package com.wr.servlet;

import com.wr.dao.PetDao;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet("/updatePetServlet")
public class UpdatePetServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        //获取添加宠物的基本信息
        String id="" ,owner="",name="",birthdate="",photo="";

        // 获取到当前服务器所在的路径 保存文件的路径
        String serverPath = request.getSession().getServletContext().getRealPath("/");
//        String serverPath=request.getContextPath();
        // 设置保存上传文件的路径
        String saveDirPath = serverPath + "img";
        File saveDirPathFileObj = new File(saveDirPath);
        // 如果当用来存放文件的目录不存在时，要创建该目录
        if (!saveDirPathFileObj.exists()) {
            saveDirPathFileObj.mkdirs();
        }
        // 1、创建一个解析器工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // 设置工厂的缓存区大小
        factory.setSizeThreshold(5 * 1024);
        // 文件上传的解析器(文件上传对象)
        ServletFileUpload upload = new ServletFileUpload(factory);
        // 设置上传文件的最大值
        upload.setSizeMax(3 * 1024 * 1024);
        // 设置编码格式
        upload.setHeaderEncoding("UTF-8");
        // 上传以后的文件名
        List uploadFileNames = new ArrayList();
        List<FileItem> fileItems;
        try {
//解析Request请求
            fileItems = upload.parseRequest(request);
            for (FileItem file : fileItems) {
                if (file.isFormField()) {
//像普通表单一样处理 获取data 数据
                    String fieldName = file.getFieldName();
                    if(fieldName.equals("id")){
                        id = file.getString("utf-8");
                    }else if(fieldName.equals("ownerId")){
                        owner = file.getString("utf-8");
                    }else if(fieldName.equals("name")){
                        name = file.getString("utf-8");
                    }else if(fieldName.equals("birthdate")){
                        birthdate = file.getString("utf-8");
                    }
                } else {
//上传文件处理
// 新的文件名
                    String saveFileName = UUID.randomUUID().toString().replace("-", "");
// 文件的后缀
                    String oldFileName = new String(file.getName().getBytes(),//获取文件地址
                            "UTF-8");//防止乱码
                    //如果没有修改文件，则filename为空
                    if (StringUtils.isEmpty(oldFileName)){
                        continue;
                    }
                    String fileType = oldFileName.substring(oldFileName.lastIndexOf("."));
// 新的文件路径
                    String saveFilePath = saveDirPath + File.separator
                            + saveFileName + fileType;
                    photo="img/"+saveFileName + fileType;
                    uploadFileNames.add(saveFileName + fileType);
                    System.out.println("saveFilePath" + saveFilePath);
                    // 保存上传的文件
                    file.write(new File(saveFilePath));
                }
            }
        }catch (Exception e){
            e.printStackTrace();

        }
        PetDao petDao = new PetDao();
        if (StringUtils.isEmpty(id)) {
            boolean result = petDao.savePet(owner, name, birthdate,photo);
        } else {
            boolean result = petDao.updatePet(id, owner, name, birthdate,photo);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
