package mapperscan.annotation;

import mapperscan.controller.MyScannerTest.MyTestScannerRegistrar;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
@Import(MyTestScannerRegistrar.class)
@EnableAspectJAutoProxy
public @interface MyScanAnnotation {
    String[] basePackages() default {};

    Class<? extends Annotation> annotationClass() default Annotation.class;

    Class<?> markerInterface() default Class.class;
}
