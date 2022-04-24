package br.com.revisa.teste.util;

import java.io.IOException;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

/**
 * Contém algumas funções relacionadas ao JSF
 *
 * @author Renan
 */
public class FacesUtil {

//metodo que redireciona as paginas
    public static void redirecionar(String url) {
        try {
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext contextEx = facesContext.getExternalContext();
            contextEx.redirect(url);
        } catch (IOException e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro ao redirecionar para a pagina " + url + ", " + e, ""));
        }

    }

    //abre ou fecha o dialog
    public static void mostraDialog(String dialog, boolean mostrar) {
        try {

            dialog = "PF('" + dialog + "').";
            PrimeFaces current = PrimeFaces.current();
            if (mostrar) {

                current.executeScript(dialog + "show();");

            } else {
                current.executeScript(dialog + "hide();");
            }
        } catch (Exception e) {

        }
    }

}
