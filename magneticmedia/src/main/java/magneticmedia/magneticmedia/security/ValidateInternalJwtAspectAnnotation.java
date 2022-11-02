package magneticmedia.magneticmedia.security;

import magneticmedia.magneticmedia.exceptions.InvalidJwtException;
import magneticmedia.magneticmedia.helpers.InternalJwtHelper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
@Order(0)
public class ValidateInternalJwtAspectAnnotation {

    @Autowired
    InternalJwtHelper internalJwtHelper;

    @Around("@annotation(magneticmedia.magneticmedia.security.ValidateInternalJwt)")
    public Object logExecutionTimeAnnotation(ProceedingJoinPoint joinPoint) throws Throwable {

        try{
            String authorizationHeader = Arrays.stream(joinPoint.getArgs()).findFirst().get().toString();

            String userNumber = null;
            String jwt = null;

            if (authorizationHeader.startsWith("Bearer ")) {
                jwt = authorizationHeader.substring(7);
                userNumber = internalJwtHelper.getUserNumberFromToken(jwt);
            } else {
                throw new InvalidJwtException();
            }

            if (userNumber != null) {
                internalJwtHelper.validateToken(jwt, userNumber);
            } else {
                throw new InvalidJwtException();
            }
        }catch(Exception ex){
            throw new InvalidJwtException();
        }
        return joinPoint.proceed();
    }
}
