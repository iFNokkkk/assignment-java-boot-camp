package com.work1.JavaBoot_WorkI;

import com.work1.JavaBoot_WorkI.entity.Product;
import com.work1.JavaBoot_WorkI.entity.User;
import com.work1.JavaBoot_WorkI.repository.ProductRepository;
import com.work1.JavaBoot_WorkI.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class JavaBootWorkIApplication {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	public void initialData(){
		loadDataUser();
		loadProduct();
	}

    public static void main(String[] args) {
        SpringApplication.run(JavaBootWorkIApplication.class, args);
    }

	private void loadDataUser(){
		User user = new User();
		user.setId(0001);
		user.setUserName("aabbccss");
		user.setName("ธนลภย์");
		user.setLastName("ได้ทรัพย์");
		userRepository.save(user);
	}

	private void loadProduct(){
		productRepository.save(new Product(1,100001,"FILA Graffik",1790.99,
				0,"รองเท้าวิ่งสำหรับผู้ชาย","FILA","43","สีเทา/เขียว"));
		productRepository.save(new Product(2,100002,"Bata POWER-MENS RUNNING",799.00,
				0,"รองเท้ากีฬาชาย สำหรับวิ่ง สีเทา รหัส 8152504 / สีดำ รหัส 8156504","Bata","43","สีเทา"));
		productRepository.save(new Product(3,100003,"adidas RUNNING Galaxy",2000.00,
				0,"รองเท้า Galaxy 5 ผู้ชาย สีขาว FY6033","adidas","43","สีขาว"));
		productRepository.save(new Product(5,100005,"adidas RUNNING Coreracer",1500.00,
				0,"รองเท้า Coreracer ผู้ชาย สีดำ FX3581","adidas","43","สีดำ"));
		productRepository.save(new Product(7,100007,"adidas RUNNING Puremotion Adapt Shoes",2500.00,
				0,"รองเท้า Puremotion Adapt Shoes ผู้หญิง สีขาว FX7322","adidas","39","สีขาว"));
	}
}
