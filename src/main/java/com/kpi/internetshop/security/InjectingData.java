package com.kpi.internetshop.security;

import com.kpi.internetshop.entity.*;
import com.kpi.internetshop.repository.OrderRepository;
import com.kpi.internetshop.service.*;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Component
public class InjectingData {
    private RoleService roleService;
    private UserService userService;
    private ProductService productService;
    private OrderRepository orderRepository;
    private AuthenticationService authenticationService;
    private ShoppingCartService shoppingCartService;

    public InjectingData(RoleService roleService, UserService userService, ProductService productService, OrderRepository orderRepository, AuthenticationService authenticationService, ShoppingCartService shoppingCartService) {
        this.roleService = roleService;
        this.userService = userService;
        this.productService = productService;
        this.orderRepository = orderRepository;
        this.authenticationService = authenticationService;
        this.shoppingCartService = shoppingCartService;
    }

    @PostConstruct
    public void init() {
        Role userRole = Role.of("USER");
        roleService.add(userRole);
        Role adminRole = Role.of("ADMIN");
        roleService.add(adminRole);
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("1");
        admin.setRoles(Set.of(adminRole));
        userService.create(admin);
        User user = new User();
        user.setFirstName("Ann");
        user.setLastName("Cry");
        user.setEmail("ann@gmail.com");
        user.setPassword("1");
        authenticationService.register(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        Product product = new Product();
        product.setName("Smartphone Samsung Galaxy M12");
        product.setDescription("4/64Gb Android-11 GPU: Exynos-850");
        product.setAmount(5);
        product.setPrice(90);
        product.setImageFileName("samsungM.jpg");
        Product product1 = new Product();
        product1.setName("Smartphone Xiaomi Mi9");
        product1.setDescription("6/64Gb Android-11 GPU: Snapdragon-855");
        product1.setAmount(3);
        product1.setPrice(350);
        product1.setImageFileName("mi9.jpg");
        Product product2 = new Product();
        product2.setName("Smartphone Poco X3 Pro");
        product2.setDescription("6/128Gb Android-11 GPU: Snapdragon-860");
        product2.setAmount(7);
        product2.setPrice(250);
        product2.setImageFileName("poco3.jpg");
        Product product3 = new Product();
        product3.setName("Smartphone Xiaomi Redmi 9A");
        product3.setDescription("4/64Gb Android-11 GPU: Helio-G25");
        product3.setAmount(10);
        product3.setPrice(199);
        product3.setImageFileName("redmi9a.jpg");
        Product product4 = new Product();
        product4.setName("Smartphone Samsung Galaxy A32");
        product4.setDescription("4/64Gb Android-11 GPU: Helio-G80");
        product4.setAmount(3);
        product4.setPrice(300);
        product4.setImageFileName("samsungA32.jpg");
        Product product5 = new Product();
        product5.setName("Smartphone Apple Iphone 11");
        product5.setDescription("4/64Gb iOS GPU: Bionic-A13");
        product5.setAmount(12);
        product5.setPrice(670);
        product5.setImageFileName("iphone11.jpg");
        Product product6 = new Product();
        product6.setName("Smartphone Samsung Galaxy M14");
        product6.setDescription("4/64Gb Android-11 GPU: Exynos-850");
        product6.setAmount(2);
        product6.setPrice(280);
        product6.setImageFileName("samsungM.jpg");
        productService.create(product);
        productService.create(product1);
        productService.create(product2);
        productService.create(product3);
        productService.create(product4);
        productService.create(product5);
        productService.create(product6);
    }
}
