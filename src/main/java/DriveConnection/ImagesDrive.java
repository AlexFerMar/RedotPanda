package DriveConnection;

import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpResponse;

import java.io.*;


import java.security.GeneralSecurityException;
import java.util.List;

public class ImagesDrive {

    private final static String GET_URL = "https://www.googleapis.com/drive/v3/files/";
    public final static String FOLDER_NAME = "fotosBot";
    public final static String FILE_NAME = "imageAux.jpeg";
    private final static String PATH = "src" + java.io.File.separator + "main" + java.io.File.separator + "resources" + java.io.File.separator+ "images" + java.io.File.separator;


    public static String imageSearcher() {

        Drive service;
        try {
            service = new DriveService().getService();
        } catch (IOException e) {
            e.printStackTrace();
            return "Conexion fallida. Permiso denegado por el usuario";
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return "Conexion fallida.";
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
                        .setQ("mimeType = 'image/jpeg' and '" + folderID + "' in parents")
                        .setSpaces("drive")
                        .setFields("nextPageToken, files(id, name)")
                        .execute();
            else
                return "Carpeta " + FOLDER_NAME + " no encontrada. Por favor, cree la carpeta en su google drive y añada sus fotos ahi si desea que su bot utilice las fotos almacenadas.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Conexion fallida";
        }

        List<File> files = result.getFiles();

        if (files == null || files.isEmpty()) {
            return "No se han encontrado imagenes dentro de la carpeta " + FOLDER_NAME + " .";
        } else {
            String fileList = "";

            for (File file : files) {
                fileList += file.getName() + " ,";
            }
            fileList = fileList.substring(0, fileList.length() - 2) + ".";
            return fileList;
        }

    }

    public static String downloadFile(String filename) {

        Drive service;
        try {
            service = new DriveService().getService();
        } catch (IOException e) {
            e.printStackTrace();
            return "Conexion fallida. Permiso denegado por el usuario";
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
            return "Conexion fallida.";
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
                        .setQ("mimeType = 'image/jpeg' and '" + folderID + "' in parents and name='" + filename + "'")
                        .setSpaces("drive")
                        .setFields("nextPageToken, files(id, name)")
                        .execute();
            else
                return "Carpeta " + FOLDER_NAME + " no encontrada. Por favor, cree la carpeta en su google drive y añada sus fotos ahi si desea que su bot utilice las fotos almacenadas.";
        } catch (IOException e) {
            e.printStackTrace();
            return "Conexion fallida";
        }

        String imageID=result.getFiles().get(0).getId();
        if ( imageID!= Integer.toString(0)) {
            /*String downloadURL = GET_URL + result.getFiles().get(0).getId();
            */try {
                /*HttpResponse resp =
                        service.getRequestFactory().buildGetRequest(new GenericUrl(downloadURL))
                                .execute();*/

                OutputStream outputStream = new FileOutputStream(PATH + FILE_NAME);
                service.files().get(imageID).executeMediaAndDownloadTo(outputStream);

                outputStream.flush();
                outputStream.close();

                return null;

            } catch (IOException e) {
                e.printStackTrace();
                return "Conexion fallida";
            }
         } else {
             //The file doesn't have any content stored on Drive.
            return "Archivo vacio o corrupto";
        }

    }

}

