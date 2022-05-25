package anotaciones;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Editor {
	String autor() default "PEPE SANCHEZ";
	int edicion() default 1;
	int anio() default 2005;
}

