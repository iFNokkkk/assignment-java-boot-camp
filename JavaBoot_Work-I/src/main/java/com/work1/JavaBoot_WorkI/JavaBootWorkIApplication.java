package com.work1.JavaBoot_WorkI;

import com.work1.JavaBoot_WorkI.entity.User;
import com.work1.JavaBoot_WorkI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JavaBootWorkIApplication {

	@Autowired
	private UserRepository userRepository;

	@PostConstruct
	public void initialData(){
		User user = new User();
		user.setId(0001);
		user.setUserName("aabbccss");
		user.setName("ธนลภย์");
		user.setLastName("ได้ทรัพย์");
		userRepository.save(user);
	}

    public static void main(String[] args) {
        SpringApplication.run(JavaBootWorkIApplication.class, args);
    }

}
