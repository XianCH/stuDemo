package com.x14n.stuCase;


import com.x14n.stuCase.bo.Person;
import com.x14n.stuCase.bo.Student;
import ma.glasnost.orika.MapperFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class MapperFactoryTest {

    @Autowired
    private MapperFactory mapperFactory;


    /**
     * 将一个已经存在的类的属性映射到另外一个类上(可以不存在)，直接返回该类，注意必须要有默认构造方法，不然报错
     */
    @Test
    public void copyBeanToBean() {
        Person person = new Person("king", 123, new Date());
        mapperFactory.classMap(Person.class, Student.class)
                .field("dateTime", "birth")
                .byDefault()//剩余的字段映射
                .register();
        Student student = mapperFactory.getMapperFacade().map(person, Student.class);
        System.out.println(student);
        //Student{name='king', grade='null', age=123, birth=Thu Apr 13 19:04:43 CST 2017}
    }

    @Test
    public void copyListToList() {
        List<Person> personList = getPersonList();
        //手动配置不一样的属性转换
        mapperFactory.classMap(Person.class, Student.class)
                .field("dateTime", "birth")//不一样的字段映射
                .byDefault()//剩余的字段映射
                .register();
        //转换List
        List<Student> students = mapperFactory.getMapperFacade().mapAsList(personList, Student.class);
        students.forEach(student -> {
            System.out.println(student);
        });
        /**
         * Student{name='king1', grade='null', age=1, birth=Thu Apr 13 19:10:39 CST 2017}
         *Student{name='king2', grade='null', age=2, birth=Thu Apr 13 19:10:39 CST 2017}
         *Student{name='king3', grade='null', age=3, birth=Thu Apr 13 19:10:39 CST 2017}
         *Student{name='king4', grade='null', age=4, birth=Thu Apr 13 19:10:39 CST 2017}
         *Student{name='king5', grade='null', age=5, birth=Thu Apr 13 19:10:39 CST 2017}
         */
    }

    public List<Person> getPersonList() {
        List<Person> list = new ArrayList<>(5);
        Person person1 = new Person("king1", 1, new Date());
        Person person2 = new Person("king2", 2, new Date());
        Person person3 = new Person("king3", 3, new Date());
        Person person4 = new Person("king4", 4, new Date());
        Person person5 = new Person("king5", 5, new Date());
        list.add(person1);
        list.add(person2);
        list.add(person3);
        list.add(person4);
        list.add(person5);
        return list;
    }
}
