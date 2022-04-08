package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ControladorLogin {

    @RequestMapping(method = RequestMethod.GET, path = "/home")
    public ModelAndView irALaHomePage() {
        var viewName = "home";
        var modelMap = getModelMap();
        modelMap.put("datosLogin", new DatosLogin());
        return getModelAndView(viewName, modelMap);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/validar-formulario-login")
    public ModelAndView validarFormularioDeLoginEnviado(DatosLogin datosLogin) {
        var modelMap = getModelMap();
        var viewName = "home";
        if (datosLogin.getValidadorDeClave() && datosLogin.getValidadorDeCorreo()) {
            modelMap.put("registro_exitoso", "true");
            viewName = "redirect:/principal";
        } else {
            modelMap.put("correo_invalido", "Ingresaste un correo invalido, por favor verifica que lo hayas ingresado correctamente");
        }
        return getModelAndView(viewName, modelMap);
    }

    private ModelMap getModelMap() {
        return new ModelMap();
    }

    private ModelAndView getModelAndView(String viewName, ModelMap modelMap) {
        return new ModelAndView(viewName, modelMap);
    }
}
