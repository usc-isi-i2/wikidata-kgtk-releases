/*
 * Copyright 2012-2013 Ontology Engineering Group, Universidad Politecnica de Madrid, Spain
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package usc.isi.wikidatadumps;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * Class for defining common operations for vocabularies: if the vocab is in LOV, 
 * retrieve its serializations, etc.
 * @author dgarijo, mpoveda
 */
public class Utils {
    /**
     * serializations we are asking for.
     */
    private static final String[] serializations = {"application/rdf+xml","text/html",
        "text/turtle","text/n3", "application/n-quads"};
    
   
    
    
    
    
    public static void copyLocalResource(String resourceName, File dest)  {
        try{
            copy(Utils.class.getResourceAsStream(resourceName), dest);
        }catch(Exception e){
            System.out.println("Exception while copying "+resourceName+" - "+e.getMessage());
        }
    }
    
    public static void copyExternalResource(String path, File dest) {
        try{
            InputStream is = new FileInputStream(path);
            copy(is, dest);
        }catch(Exception e){
            System.err.println("Exception while copying "+path+e.getMessage());
        }
    }
    
    public static void copy(InputStream is, File dest)throws Exception{
        OutputStream os = null;
        try {
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        }
        catch(Exception e){
            System.err.println("Exception while copying resource. "+e.getMessage());
            throw e;
        }
        finally {
            if(is!=null)is.close();
            if(os!=null)os.close();
        }
    }
    
    
    /**
     * Method to save a document on a path
     * @param path
     * @param textToWrite
     */
    public static void saveDocument(String path, String textToWrite){
        File f = new File(path);
        Writer out = null;
        try{
            f.createNewFile();
            out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), "UTF-8"));
            out.write(textToWrite);
            out.close();
        }catch(IOException e){
            System.err.println("Error while creating the file "+e.getMessage()+"\n"+f.getAbsolutePath());
        }        
        
    }
    
    /**
     * Code to unzip a file. Inspired from
     * http://www.mkyong.com/java/how-to-decompress-files-from-a-zip-file/
     * Taken from 
     * @param resourceName
     * @param outputFolder 
     */
    public static void unZipIt(String resourceName, String outputFolder){
 
     byte[] buffer = new byte[1024];
 
     try{
    	ZipInputStream zis = 
    		new ZipInputStream(Utils.class.getResourceAsStream(resourceName));
    	ZipEntry ze = zis.getNextEntry();
 
    	while(ze!=null){
 
    	   String fileName = ze.getName();
           File newFile = new File(outputFolder + File.separator + fileName);
           System.out.println("file unzip : "+ newFile.getAbsoluteFile());
           if (ze.isDirectory()){
                String temp = newFile.getAbsolutePath();
                new File(temp).mkdirs();
           }
           else{
                FileOutputStream fos = new FileOutputStream(newFile);
                int len; while ((len = zis.read(buffer)) > 0) {
                fos.write(buffer, 0, len); }
                fos.close();
           }  
            ze = zis.getNextEntry();
    	}
 
        zis.closeEntry();
    	zis.close();
 
    }catch(IOException ex){
        System.err.println("Error while extracting the reosurces: "+ex.getMessage());
    }
   } 
    
}
