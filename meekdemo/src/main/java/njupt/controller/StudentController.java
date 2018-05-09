package njupt.controller;

import njupt.domain.Student;
import njupt.service.StudentService;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping(value = "/njupt")
public class StudentController {
    @Autowired
    StudentService studentService;


    @RequestMapping(value = "/index")
    public String index() {
        return "index.jsp";
    }

    @RequestMapping(value = "/regist")
    public String regist() {
        return "jStudentRegist.jsp";
    }

    /**
     * 处理/login请求
     */
    @RequestMapping(value = "/login")
    public String login(Model model, Student student) {
        /** 通过stuId查询学生信息 */
        String stuId = student.getstuId();
        String password = student.getPassword();
        List<Student> studentList = new ArrayList<>();
        model.addAttribute("hasAccess", false);

        System.out.println("---导弹/login");
//        if ((stuId == null) || (stuId.trim() == "") || (password == null) || (password.trim() == "")) {
        if ((stuId == null) || (stuId.trim() == "")) {
            System.out.println("--->" + stuId + "----->" + password);
            return "jStudentLogin.jsp";
        }
        student = studentService.getBystuId(stuId);
        if (student == null) {
            model.addAttribute("hasAccount", "N");
            return "jStudentRegist.jsp";
        } else if (!student.getPassword().equals(password.trim())) {
            model.addAttribute("passwordError", "密码错误");
            return "jStudentLogin.jsp";
        } else if (student.getAccess().equals("admin")) {
            model.addAttribute("hasAccess", true);
            studentList = studentService.findAll();
        } else {
            studentList.add(student);
        }
        model.addAttribute("stuId", student.getstuId());
        model.addAttribute("studentList", studentList);
        return "jStudent.jsp";
    }

    //新增和修改保存，@Valid Person p对新增的数据进行校验
    @RequestMapping(value = "/saveOrUpdate")
    public String saveOrUpdate(
            HttpServletRequest request,
            @Valid Student student,
            BindingResult br,
            Model model,
            @RequestParam(value = "photo", required = false) MultipartFile photoFile
    ) throws IOException {        //可以传递字段，也可以传递实体对象
        if (student.getstuId() == null && student.getstuId().trim() == "") {
            model.addAttribute("stuId", "学号不可为空");
            return "jStudentRegist.jsp";
        }
        if (student.getName() == null && student.getName().trim() == "") {
            model.addAttribute("name", "姓名不可为空");
            return "jStudentRegist.jsp";
        }
        if (student.getPassword() == null && student.getPassword().trim() == "") {
            model.addAttribute("password", "密码不可为空");
            return "jStudentRegist.jsp";
        }
        if (student.getId() == null) {
            studentService.insert(student);                        //调用servcie.insert方法插入记录
        } else {
            if (br.hasErrors()) {                    //代表校验发生错误
                model.addAttribute("br", br);
                model.addAttribute("student", student);
                return "jStudentUpdate.jsp";    //返回错误页面，修改页面进行错误提示
            }

            // 保存图片文件，同时记录图片路径
            String dir = request.getSession().getServletContext().getRealPath("/") + "/upload/";            //tomcat8 下realpath跟前面的版本不一样
            //请求为绝对路径时
            //C:\MyJavaWorkSpace\IDEA_Project\meekdemo\out\artifacts\meekdemo_war_exploded\/upload/
            // 请求为相对路径时
            //C:\apache-tomcat\apache-tomcat-8.5.30\webapps\ROOT\/upload/

            System.out.println(dir);
            String fileName = photoFile.getOriginalFilename();                    //原始的文件名
            String extName = fileName.substring(fileName.lastIndexOf("."));            //扩展名
            fileName = fileName.substring(0, fileName.lastIndexOf(".")) + student.getstuId() + extName;        //防止文件名冲突
            FileUtils.writeByteArrayToFile(new File(dir + fileName), photoFile.getBytes());                    //写文件到upload目录

            student.setPhotopath("/upload/" + fileName);
            studentService.update(student);                        //修改方法
        }
        return "redirect:/njupt/login.action?stuId=" + student.getstuId() + "&password=" + student.getPassword();    //转向列表action
    }

    // 更新
    @RequestMapping(value = "/update")
    public String update(String stuId, Model model) {
        System.out.println("---/update.action---");
        model.addAttribute("student", studentService.getBystuId(stuId));
        return "jStudentUpdate.jsp";
    }

    // 查询
    @RequestMapping("/deleteMuch")
    public String list(String stuId, Model model, String[] stuIds) {
        System.out.println("-->deleteMuch");
//        防止什么都不选
        Student student = studentService.getBystuId(stuId);
        if (stuIds != null) {
            for (String str : stuIds) {
                if (!str.equals(stuId)) {
                    studentService.deleteBystuId(str);
                }
            }
        }
        return "redirect:/njupt/login.action?stuId=" + student.getstuId() + "&password=" + student.getPassword();    //转向列表action
    }
}
