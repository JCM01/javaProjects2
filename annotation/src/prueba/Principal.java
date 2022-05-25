package prueba;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import anotaciones.Editor;

public class Principal {
	public static void main(String[] args) {
		Coche co = new Coche("Ford", "Fiesta");
		try {
			Class cl = co.getClass();
			Method m = cl.getMethod("acelerar");
			Annotation a = m.getAnnotation(Editor.class);
			Editor e = (Editor) a;
			System.out.println(a);
			System.out.println(e.autor());
			
			if (e.edicion() == 3) {
				co.acelerar();
				co.acelerar();
			}
			else {
				co.acelerar();
			}
			
			System.out.println(co.toString());
		} catch (NoSuchMethodException | SecurityException e) {
			System.out.println(e.getMessage());
		}
	}
}

