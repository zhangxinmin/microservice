package com.test.jdbc.repository;

import com.test.jdbc.bean.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

//仓储和 dao 的区别   dao 是访问数据库  而仓储 可能访问 db  nosql 或者内存等
@Repository
public class TeacherRepositroy {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private DataSource masterDataSource;
    @Autowired
    private DataSource slaveDataSource;
//    @Autowired
//    public TeacherRepositroy(DataSource dataSource){
//        this.dataSource=dataSource;
//    }



public boolean save(Teacher teacher){
    System.out.println("保存 teacher["+teacher+"]");
    return true;
}

}
