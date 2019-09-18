package cn.je.test;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EndPoints {

    @GetMapping("/product/{id}")
    public String getProduct(@PathVariable String id) { //占位符，替换上面的{id}
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        //在SecurityContextHolder中保存的是当前访问者的信息。
        // Spring Security使用一个Authentication对象来表示这个信息。
        // 一般情况下，我们都不需要创建这个对象，在登录过程中，
        // Spring Security已经创建了该对象并帮我们放到了SecurityContextHolder中。

        // .getContext()获取安全上下文对象，就是那个保存在 ThreadLocal 里面的安全上下文对象
        // 总是不为null(如果不存在，则创建一个authentication属性为null的empty安全上下文对象)

        // .getAuthentication()获取当前认证了的 principal(当事人),或者 request token (令牌)
        // 如果没有认证，会是 null,该例子是认证之后的情况
        System.out.println(authentication);  //这里返回的是principal
        return "product id : " + id;
    }

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable String id) {
        //for debug
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "order id : " + id;
    }

}

