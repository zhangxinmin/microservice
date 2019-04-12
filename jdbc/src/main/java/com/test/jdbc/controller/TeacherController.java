package com.test.jdbc.controller;

import com.test.jdbc.bean.Teacher;
import com.test.jdbc.repository.TeacherRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 老师 controller
 */
@RestController
public class TeacherController {
  @Autowired
  private TeacherRepositroy teacherRepositroy;

  @RequestMapping("/teacher/save")
  public boolean save(@RequestBody Teacher teacher){
    return teacherRepositroy.save(teacher);
  }

}
