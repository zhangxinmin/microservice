package com.test.jdbc.webflux;

import com.test.jdbc.bean.Teacher;
import com.test.jdbc.repository.TeacherRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class TeacherHandler {
    @Autowired
    private TeacherRepositroy teacherRepositroy;

    public Mono<ServerResponse> save(ServerRequest request){
        Mono<Teacher> tMono =request.bodyToMono(Teacher.class);
        Mono<Boolean> res =  tMono.map(teacherRepositroy::save);
        return ServerResponse.ok().body(res,Boolean.class);
    }

}
