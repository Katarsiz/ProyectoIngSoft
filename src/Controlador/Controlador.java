package Contralador;

import Mapeo.*;
import Modelo.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Emilio
 */
@Controller 
public class Controlador{
	
	@Autowired
	UsuarioDAO usuario_db;

	@RequestMapping(value="/")
	public String inicio(){
		return "inicio";
	}
	
	@RequestMapping(value="/iniciarSesion", method = RequestMethod.GET)
        public ModelAndView iniciarSesion(ModelMap model,HttpServletRequest request){
		String u = request.getParameter("correo");
		String c = request.getParameter("psswd");
		
		//incompleto
		
        	Usuario user = usuario_db.getUsuario(u, c);
            
        	String info = "";
         	if (prof == null){
                	model.addAttribute("info", info+"No se encontro nungun profesor con ese nombre");
            	}else{
                	model.addAttribute("info", info+"El profesor es");
                	model.addAttribute("profesor", prof);
            	}
            	return new ModelAndView("profesor",model);
        
        }
}
