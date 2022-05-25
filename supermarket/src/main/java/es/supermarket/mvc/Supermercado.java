package es.supermarket.mvc;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class Supermercado {
	@RequestMapping("supermercado.html")
	public ModelAndView redireccion()  {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("superm");
		return mv;
	}
}
