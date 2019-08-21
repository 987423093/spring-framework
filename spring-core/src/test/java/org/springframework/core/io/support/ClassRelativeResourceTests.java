package org.springframework.core.io.support;

import org.junit.Test;
import org.springframework.core.io.ClassRelativeResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.my.domain.ClassA;

import java.io.*;

/**
 * @author zhoutao
 * @date 2019/8/21
 */
public class ClassRelativeResourceTests {

    @Test
    public void testClassRelativeResource() throws IOException {

        //可能是单元测试的原因，无法使用相对路径访问文件，只能以file:全路径来访问文件
        //ClassRelativeResourceLoader可以把传入的类的当前路径保留，对于同一个文件夹下的其他文件可以只传递文件名称
        ResourceLoader resourceLoader = new ClassRelativeResourceLoader(ClassA.class);
//        ResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("file:G:/repository/spring-framework/spring-core/src/main/java/org/springframework/my/domain/a.xml");
//        Resource resource = resourceLoader.getResource("a.xml");
        File file = resource.getFile();
        //打印文件内容
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file));
        BufferedReader bfReader= new BufferedReader(inputStreamReader);
        String line;
        while((line = bfReader.readLine()) != null){
            System.out.println(line);
        }

        System.out.println(resource.getFile().getAbsolutePath());
    }

}
