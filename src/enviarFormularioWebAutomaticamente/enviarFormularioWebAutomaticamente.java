package enviarFormularioWebAutomaticamente;

public class enviarFormularioWebAutomaticamente {

    public static void main(String[] args) {

        ModeloExcel modelo1 = new ModeloExcel();
        DatosWeb datosWeb1 = new DatosWeb("https://interiorismonallin.000webhostapp.com/contacto.html", modelo1);

        modelo1.leerExcel("DatosUsuarios2.xlsx");
        modelo1.mostrarDatosConsola();
        datosWeb1.llenarFormulario();

    }
}
