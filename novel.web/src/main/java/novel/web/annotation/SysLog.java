package novel.web.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface SysLog {

	String module() default "";  
    String methods() default "";  
    String description() default "";  
	
}
