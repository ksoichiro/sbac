package admin.console.aspect;

import admin.console.constant.RoleEnum;
import admin.console.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Controller method aspect example.
 * This aspect checks if the user has the required role (should be equal or stronger).
 */
@Aspect
@Component
@Slf4j
public class ControllerMethodRoleCheckAdvice {
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void controller() {}

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping() {}

    @Pointcut("@annotation(admin.console.aspect.RoleRequired)")
    public void roleRequired() {}

    @Around("controller() && requestMapping() && roleRequired() && execution(* *(..))")
    public Object roleRequiredRequest(ProceedingJoinPoint pjp) throws Throwable {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        RoleRequired annotation = signature.getMethod().getAnnotation(RoleRequired.class);
        RoleEnum role = annotation.role();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        RoleEnum userRole = RoleEnum.valueOf(user.getRole().getName());
        log.debug("roleRequiredRequest: user: {} required: {}", userRole, role);
        if (userRole.isWeakerThan(role)) {
            throw new AccessDeniedException("You don't have permission to execute this");
        }
        return pjp.proceed();
    }
}
