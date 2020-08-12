package enviarFormularioWebAutomaticamente;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ModeloExcel {

    private String rutaArchivo;
    private String documentosArray[];

    public ModeloExcel() {

    }

    public ModeloExcel(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String[] getDocumentosArray() {
        return documentosArray;
    }

    public void setDocumentosArray(String[] documentosArray) {
        this.documentosArray = documentosArray;
    }

    public void leerExcel(String rutaArchivo) {

        int auxContador = 0;
        int auxCeldas = 0;

        try {

            FileInputStream file = new FileInputStream(new File(rutaArchivo));

            //Leemos archivo excel
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Obtenemos el numero de la hoja que vamos a leer
            XSSFSheet sheet = workbook.getSheetAt(0);

            int numeroFilas = sheet.getPhysicalNumberOfRows();

            //Tomo el numero de filas y lo multiplico por el numero de celdas, en este caso 5 para dar con la longitud del array
            this.documentosArray = new String[numeroFilas * 5];

            //Leemos todos las filas a traves de un bucle hasta que que se acabe en la hoja o sheet 0
            for (Row i : sheet) {

                //Celdas de la fila auxCeldas esta en 0
                Cell cell = i.getCell(auxCeldas);

                //Evito que lea la primera fila que tiene los metadatos(Nombre,apellido,mail,telefono,mensaje)
                switch (i.getRowNum()) {
                    case 0:
                        break;
                    default:
                        this.documentosArray[auxContador] = cell.getStringCellValue();
                        cell = i.getCell(auxCeldas + 1);
                        this.documentosArray[auxContador + 1] = cell.getStringCellValue();
                        cell = i.getCell(auxCeldas + 2);
                        this.documentosArray[auxContador + 2] = cell.getStringCellValue();
                        cell = i.getCell(auxCeldas + 3);
                        this.documentosArray[auxContador + 3] = String.valueOf((int) cell.getNumericCellValue());
                        cell = i.getCell(auxCeldas + 4);
                        this.documentosArray[auxContador + 4] = cell.getStringCellValue();
                        auxContador = auxContador + 5;
                        break;

                }
            }

        } catch (IOException e) {

            System.out.println(e.getMessage());
        }

    }

    public void mostrarDatosConsola() {

        for (int i = 0; i < 50; i++) {
            if (i == 0) {
                System.out.println("-- ESTOS SON LOS DATOS SACADOS DESDE EL ARCHIVO EXCEL DEL PROYECTO, LOS CUALES VAMOS A ENVIAR AL FORMULARIO WEB -- \n");

            }
            switch (i) {
                case 5:
                    System.out.println("");
                    break;
                case 10:
                    System.out.println("");
                    break;
                case 15:
                    System.out.println("");
                    break;
                case 20:
                    System.out.println("");
                    break;
                case 25:
                    System.out.println("");
                    break;
                case 30:
                    System.out.println("");
                    break;
                case 35:
                    System.out.println("");
                    break;
                case 40:
                    System.out.println("");
                    break;
                case 45:
                    System.out.println("");
                    break;

            }
            
            System.out.println(this.documentosArray[i]);

        }

    }

}
