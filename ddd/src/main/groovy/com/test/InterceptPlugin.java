package com.test;

import org.gradle.api.NonNullApi;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.Task;

/**
 * 选中。run configurations run InterceptClick task
 */
@NonNullApi
class InterceptPlugin implements Plugin<Project> {

    @Override
    public void apply(Project project) {
        //传入的参数就是创建的Task名称
        System.out.println("hello InterceptPlugin !");
        Task intercept_click = project.task("InterceptClick");
        intercept_click.doFirst(task -> {
            System.out.println("From Intercept Plugin !");
        });
    }
}