package enviarFormularioWebAutomaticamente;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlEmailInput;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTelInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextArea;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import java.io.IOException;
import javax.swing.JOptionPane;

public class DatosWeb {

    String url;
    private ModeloExcel puntero;

    public DatosWeb() {
    }

    public DatosWeb(String url, ModeloExcel puntero) {
        this.url = url;
        this.puntero = puntero;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ModeloExcel getPuntero() {
        return puntero;
    }

    public void setPuntero(ModeloExcel puntero) {
        this.puntero = puntero;
    }

    public void llenarFormulario() {
        int auxContadorArray = 0;
        int auxContadorRegistros = 0;

        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        try {
            while (auxContadorRegistros < 10) {

                webClient.getOptions().setCssEnabled(false);
                webClient.getOptions().setJavaScriptEnabled(false);
                HtmlPage pagina1 = webClient.getPage(url);

                //Nombre del formulario
                HtmlForm form = pagina1.getFormByName("formularioContacto");

                //Nombre de los inputs dentro del formulario web
                HtmlTextInput nombre = form.getInputByName("nombr");
                HtmlTextInput apellido = form.getInputByName("apellid");
                HtmlEmailInput email = form.getInputByName("emai");
                HtmlTelInput telefono = form.getInputByName("telefon");
                HtmlTextArea mensaje = form.getTextAreaByName("mensaj");

                //Llenamos el formulario
                nombre.setValueAttribute(puntero.getDocumentosArray()[auxContadorArray]);
                apellido.setValueAttribute(puntero.getDocumentosArray()[auxContadorArray + 1]);
                email.setValueAttribute(puntero.getDocumentosArray()[auxContadorArray + 2]);
                telefono.setValueAttribute(puntero.getDocumentosArray()[auxContadorArray + 3]);
                mensaje.setText(puntero.getDocumentosArray()[auxContadorArray + 4]);

                auxContadorArray = auxContadorArray + 5;

                //Nombre del boton del formulario
                HtmlSubmitInput botonEnviar = form.getInputByValue("Enviar");
                botonEnviar.click();

                auxContadorRegistros++;
            }

            //Cerramos el webClient o browser
            webClient.close();
           
            JOptionPane.showMessageDialog(null, "El programa a llenado y enviado los formularios exitosamente");
            JOptionPane.showMessageDialog(null, "El programa a finalizado");
       
        } catch (ElementNotFoundException | FailingHttpStatusCodeException | IOException e) {

            System.out.println(e.getMessage());
        }

    }

}
