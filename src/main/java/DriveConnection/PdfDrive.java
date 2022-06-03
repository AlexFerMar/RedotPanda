package DriveConnection;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.util.List;

public class PdfDrive {

    public final static String FOLDER_NAME = "pdfBot";
    public final static String FILE_NAME = "pdfAux.pdf";
    private final static String PATH = "src" + java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator+ "PDF" + java.io.File.separator;

    /**
     * Buscaa todos los archivos de una carpeta dada
     * @return Devuelve un string con la lista de imagenes
     */
    public static String fileSearcher() {

        Drive service;
        try {
            service = new DriveService().getService();
        } catch (IOException e) {
            e.printStackTrace();
            return "Conexión fallida. Permiso denegado por el usuario";
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return "Conexión fallida.";
        }

        FileList result;
        try {

            String folderID = service.files().list()
                    .setPageSize(1)
                    .setQ("name = '" + FOLDER_NAME + "' and mimeType = 'application/vnd.google-apps.folder'")
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id, name)")
                    .execute().getFiles().get(0).getId();

            if (folderID != Integer.toString(0))
                result = service.files().list()
                        .setPageSize(1000)
                        .setQ("'" + folderID + "' in parents")
                        .setSpaces("drive")
                        .setFields("nextPageToken, files(id, name)")
                        .execute();
            else
                return "Carpeta " + FOLDER_NAME + " no encontrada. Por favor, cree la carpeta en su Google drive y añada sus fotos ahí si desea que su bot utilice las fotos almacenadas.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Conexión fallida.";
        }

        List<File> files = result.getFiles();

        if (files == null || files.isEmpty()) {
            return "No se han encontrado imágenes dentro de la carpeta " + FOLDER_NAME + " .";
        } else {
            String fileList = "";

            for (File file : files) {
                fileList += file.getName() + " ,";
            }
            fileList = fileList.substring(0, fileList.length() - 2) + ".";
            return fileList;
        }

    }


    /**
     *Descarga un PDF del drive asociado al progrma
     * @param filename
     * @return
     */
    public static String downloadPDF(String filename) {

        Drive service;
        try {
            service = new DriveService().getService();
        } catch (IOException e) {
            e.printStackTrace();
            return "Conexión fallida. Permiso denegado por el usuario";
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return "Conexión fallida.";
        }

        FileList result;
        try {

            String folderID = service.files().list()
                    .setPageSize(1)
                    .setQ("name = '" + FOLDER_NAME + "' and mimeType = 'application/vnd.google-apps.folder'")
                    .setSpaces("drive")
                    .setFields("nextPageToken, files(id, name)")
                    .execute().getFiles().get(0).getId();

            if (folderID != Integer.toString(0))
                result = service.files().list()
                        .setPageSize(1)
                        .setQ("'" + folderID + "' in parents and name='" + filename + "'")
                        .setSpaces("drive")
                        .setFields("nextPageToken, files(id, name)")
                        .execute();
            else
                return "Carpeta " + FOLDER_NAME + " no encontrada. Por favor, cree la carpeta en su Google drive y añada sus fotos ahí si desea que su bot utilice las fotos almacenadas.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Conexión fallida";
        }

        String fileID = result.getFiles().get(0).getId();
        if (fileID != Integer.toString(0)) {

            try {

                OutputStream outputStream = new FileOutputStream(new java.io.File(PATH+FILE_NAME),true);

                service.files().export(fileID, "application/pdf")
                        .executeMediaAndDownloadTo(outputStream);

                outputStream.flush();
                outputStream.close();

                return "Archivo descargado correctamente.";

            } catch (IOException e) {
                e.printStackTrace();
                return "Conexión fallida";
            }
        } else {
            //The file doesn't have any content stored on Drive.
            return "Archivo vacío o corrupto";
        }

    }

}
