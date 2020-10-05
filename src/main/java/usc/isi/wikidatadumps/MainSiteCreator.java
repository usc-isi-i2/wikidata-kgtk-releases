package usc.isi.wikidatadumps;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Class for processing vocabularies and converting them to HTML.
 * Input: csv with metadata properties of the files to annotate
 * @author dgarijo 
 */
public class MainSiteCreator {
    public static void createFolderStructure(String savePath){
        Utils.unZipIt(TextConstants.vocabResources, savePath);
    }
    public static void main(String[] args) throws IOException{
        String pathToCSV = "";
        int argNumber = 0;
        String outputFile = null;
        String repoName = "Repository";
        try{
            while(argNumber< args.length){
                String s = args[argNumber];
                if(s.equals("-i")){
                    argNumber++;
                    pathToCSV = args[argNumber];
                }else if(s.equals("-o")){
                    argNumber++;
                    outputFile = args[argNumber];
                }
                argNumber++;
            }
        }catch(Exception e){
            System.out.println("Wrong input usage. Usage: java-jar vocab.jar -i input repository folder [-o outputDirectoryPath]");
        }
        if("".equals(pathToCSV)){
            System.out.println("Usage: java-jar vocab.jar -i input repository folder [-o outputDirectoryPath]");//oops will activate/deactivate oops eval
            return;
        }    
        String urlOut = "";
        File outputFolder;
        if(outputFile==null){
            outputFolder = new File(urlOut);
            outputFolder = new File (outputFolder.getAbsolutePath()+File.separator+TextConstants.getsiteFolderName());
            outputFolder.mkdirs();
        }else{
            outputFolder = new File(outputFile);
            outputFolder.mkdirs();
        }
        MainSiteCreator.createFolderStructure(outputFolder.getAbsolutePath());
        String catalogOutPath = outputFolder.getAbsolutePath()+File.separator+TextConstants.siteName;
        String html = TextConstants.getheader(repoName)+TextConstants.getNavBarVocab(repoName);
        html+= TextConstants.optionsStart;
        try{
            DatasetCollection datasetsByVersion = getCSVRows(pathToCSV);
            HashMap<String,ArrayList<Dataset>> collection = datasetsByVersion.getCollection();
            for(String version:collection.keySet()){
                try{
                    ArrayList<Dataset> datasetsForVersion = collection.get(version);
                    html+=TextConstants.addOption(version);
                    //for each of the tables, save them in an HTML file
                    //get first dataset to extract common metadata
                    Dataset sample = datasetsForVersion.get(0);
                    String htmlVersion = "<p>Dataset version <span class=\"label label-primary\">"+sample.getVersion()
                            + "</span>. " //(created on "+sample.getCreationDate()+")
                            + "License: <a href=\""+sample.getLicense()
                            + "\"><span class=\"label label-primary\">"
                            + sample.getLicenseTitle()+"</a></span></p>";
                    htmlVersion += TextConstants.tableHeadVocab;
                    int i = 0;
                    for(Dataset d:datasetsForVersion){
                        htmlVersion+= d.getHTMLSerializationAsRow(""+i);
                        i++;
                    }
                    htmlVersion += TextConstants.tableEnd;
                    Utils.saveDocument(outputFolder.getAbsolutePath()+File.separator+"table-"+version+".html", htmlVersion);
                }catch(Exception e){
                    System.err.println("Could not process version: "+e.getMessage());
                }
            }
            html+=TextConstants.optionsEnd + TextConstants.end;
            Utils.saveDocument(catalogOutPath, html);
        }catch(Exception e){
            System.err.println("Could not create the site: "+e.getMessage());
//            e.printStackTrace();
        }
    }

    private static DatasetCollection getCSVRows(String pathToCSV) {
        String[] colHeaders = null;
        String[] values;
        System.out.println("\nProcessing: "+pathToCSV);
        DatasetCollection collection = new DatasetCollection();
        try{
             CSVReader reader = new CSVReader(new FileReader(pathToCSV));
             while ((values = reader.readNext()) != null){
                if (colHeaders == null){
                    colHeaders = values;//first line
                }else{
                    //field order
                    //name(0),version(1),description(2),properties(3),format(4),size (MB)(5),date(6),
                    //language(7),license(8),license_uri(9),download(10),link_to_script(11),
                    //preview_link(12),source_link(13),statistics(14)
                    float size = -1;
                    try{
                        size = Float.parseFloat(values[5]);
                    }catch(NumberFormatException e){
                        System.err.println("Error when reading size from entry");
                    }
                    System.out.println("Values: "+Arrays.toString(values));
                    ArrayList<String> languages = new ArrayList<>(Arrays.asList(values[7].split(";")));
                    ArrayList<String> properties = new ArrayList<>(Arrays.asList(values[3].split(";")));;
                    Dataset d = new Dataset(values[0], values[2], size, values[1], values[4], 
                            values[9], values[8], languages, properties, values[6], values[10], 
                            values[11], values[12], values[14]);
                    collection.addDataset(d);
                }
             }
        }catch(IOException e){
            System.err.println("Error: "+e.getMessage());
        }            
        //Dataset d = new Dataset("name", "long description goes here",16000, "01012020", "kgt", "CC-0", "CC-0", null, null, "01-10-2000","download","script","preview","source" );
        return collection;
    }
    
}
