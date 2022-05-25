package es.animales.mvc;
 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
 
@Controller
public class Controlador {
        @RequestMapping("index.zoo")
        public ModelAndView redireccion()  {
                ModelAndView mv = new ModelAndView();
                mv.setViewName("principal");
                return mv;
        }
        @RequestMapping("mamiferos.zoo")
        public ModelAndView redireccion1()  {
                ModelAndView mv = new ModelAndView();
                mv.setViewName("mamiferos");
                return mv;
        }

        @RequestMapping("aves.zoo")
        public ModelAndView redireccion2()  {
                ModelAndView mv = new ModelAndView();
                mv.setViewName("aves");
                return mv;
        }

        @RequestMapping("reptiles.zoo")
        public ModelAndView redireccion3()  {
                ModelAndView mv = new ModelAndView();
                mv.setViewName("reptiles");
                return mv;
        }
  
            
}