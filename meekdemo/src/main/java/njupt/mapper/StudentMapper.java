package njupt.mapper;

import java.util.List;
import njupt.domain.Student;
import njupt.domain.StudentExample;
import org.apache.ibatis.annotations.Param;

public interface StudentMapper {

    int countByExample(StudentExample example);

    int deleteByExample(StudentExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteBystuId(String stuId);

    int deleteByPrimaryKeys(Integer[] ids);

    int insert(Student record);

    int insertSelective(Student record);

    List<Student> selectByExample(StudentExample example);

    List<Student> findAll();

    Student selectByPrimaryKey(Integer id);

    Student selectBystuId(String stuId);

    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}