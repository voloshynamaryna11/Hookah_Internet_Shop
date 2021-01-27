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
        product.setName("Clock");
        product.setDescription("Cool");
        product.setAmount(1);
        product.setPrice(700);
        product.setImageFileName("foto1.jpg");
        Product product1 = new Product();
        product1.setName("Calm");
        product1.setDescription("Soft");
        product1.setPrice(670);
        product1.setAmount(10);
        product1.setImageFileName("foto1.jpg");
        productService.create(product);
        productService.create(product1);
    }
}
