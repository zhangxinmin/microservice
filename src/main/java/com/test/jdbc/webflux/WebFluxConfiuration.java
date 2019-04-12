package com.test.jdbc.webflux;

import com.test.jdbc.repository.TeacherRepositroy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class WebFluxConfiuration {
    @Bean
    public RouterFunction<ServerResponse> saveTeacher(TeacherHandler teacherHandler){
        return route(POST("/flux/teacher/save"),teacherHandler::save);
    }
}
