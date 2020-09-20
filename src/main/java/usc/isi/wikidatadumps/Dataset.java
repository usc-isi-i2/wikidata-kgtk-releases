package usc.isi.wikidatadumps;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Class that defines the attributes of a vocabulary
 * @author dgarijo
 */
public class Dataset {
    private String name;
    private String description;
    private String firstPartDesc;
    private String secondPartDesc;
    float size; //size in MB
    private String version;
    private String format;
    private String license;
    private String licenseTitle;
    private ArrayList<String> languages;
    private ArrayList<String> properties;
    private String creationDate;
    private String lastModifiedDate;
    private String downloadLink;
    private String scriptLink;
    private String previewLink;
    private String statistics;

    public Dataset(){
        
    }
    public Dataset(String name) {
        this.name = name;
    }

    public Dataset(String name, String description, float size, String version, String format, 
            String license, String licenseTitle, ArrayList<String> languages, 
            ArrayList<String> props, String creationDate, String download, 
            String script, String preview, String stats) {
        this.name = name;
        this.description = description;
    	if (description.length() > TextConstants.SHORT_DESC_LENGTH){
    		int nextSpace = description.indexOf(" ", TextConstants.SHORT_DESC_LENGTH);
    		this.firstPartDesc = this.description.substring(0, nextSpace);
    		this.secondPartDesc = this.description.substring(nextSpace);
    	}
        else{
            firstPartDesc = description;
            secondPartDesc = "";
        }
        this.version = version;
        this.size = size;
        this.format = format;
        this.license = license;
        this.licenseTitle = licenseTitle;
        this.languages = languages;
        this.properties = props;
        this.creationDate = creationDate;
        this.downloadLink = download;
        this.scriptLink = script;
        this.statistics = stats;
        this.previewLink = preview;
    }

    
    /*
     * Getters 
     */

    public String getDescription() {
        return description;
    }

    public String getFormat() {
        return format;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public ArrayList<String> getNodes() {
        return properties;
    }

    public String getVersion() {
        return version;
    }

    

    public ArrayList<String> getLanguage() {
        return languages;
    }

    public String getLicense() {
        return license;
    }    
    
    public String getLicenseTitle() {
        return licenseTitle;
    }

    

    public String getCreationDate() {
        return creationDate;
    }

    public String getLastModifiedDate() {
        return lastModifiedDate;
    }
    
    public String getShortDescrition (){
    	return firstPartDesc;
    }
    
    
    /**
     * Setters
     * @param description
     */ 

    public void setDescription(String description) {
        this.description = description;
        this.firstPartDesc = description;
        
        String desc = this.description;
    	if (desc.length() > TextConstants.SHORT_DESC_LENGTH){
    		
    		int nextSpace = desc.indexOf(" ", TextConstants.SHORT_DESC_LENGTH);
    		if (nextSpace != -1){
    			this.firstPartDesc = this.description.substring(0, nextSpace);
    			this.secondPartDesc = this.description.substring(nextSpace);
    		}
    		
    	}
    	
    }

    
    public void setLicense(String license) {
      this.license = license;
    }
    
    public void setLicenseTitle(String licenseT) {
      this.licenseTitle = licenseT;
    }
    

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastModifiedDate(String lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
    /**
     * Method that returns an html serialization of the dataset.
     * Assuming that there is a table 
     * @param id id for the dataset in the table
     * @return 
     */
    public String getHTMLSerializationAsRow(String id){
        String html = ("<tr id=\"tr"+id+"\">\n");
        //name
        String name = this.getName();
        if(name == null || name.equals("")){
            name = "Undefined";
        }
        
        html +=("<td> "+ name );
        if(previewLink!=null && !previewLink.equals("")){
            html+="&nbsp;<a href=\""+previewLink+"\"><span class=\"glyphicon glyphicon-search\" aria-hidden=\"true\" ></span></a>";
        }
        html+="</td>\n";
        //description
        html+="<td>\n";    
        if(description!=null){
            if (firstPartDesc.length() < description.length()){        	
                html+= "<p id=\"collapse"+id+"\" data-toggle=\"collapse\" >\n";
                html+= firstPartDesc + " ... ";
                html+= "<a class=\"more"+id+"\">See more</a>\n";
                html+= "</p>\n";
                html+= "<script>\n";
                html+= "$('#collapse"+id+"').click(function () {\n";
                html+= "if($('a').hasClass('more"+id+"'))\n";
                html+= "{\n";
                html+= "$('#collapse"+id+"').html('"+ description.replace("\n", "<br>") +"  <a class=\"less"+id+"\">See less<a>'); \n";
                        html+= "}\n";
                        html+= "else\n";
                        html+= "{      \n";
                        html+= "$('#collapse"+id+"').html('"+ firstPartDesc.replace("\n", "<br>") + " ... "+" <a  class=\"more"+id+"\">See more</a>'); \n";
                        html+= "}\n";
                        html+= "}); \n";
                html+= "</script>\n";
            }
            else{
                    html+=description.replace("\n", "<br>");
            }
        }

        html+= "</td>\n";
        //size 
        html+=("<td>");
        if (size<1000){
            if(size>0){ //if it's <0, then size undefined
                html+=size+" MB";
            }
        }
        else{
            html+=(size/1000)+" GB";
        }
        html+=("</td>");
        
        //version
        if(version!=null && !version.equals("")){
            html+="<td><span class=\"label label-primary\">"+version+"</td>";
        }else{
            html+="<td><span class=\"label label-default\">undefined</td>";
        }
        //properties
        html+="<td>";
        if (properties!=null){
            for(String p:properties){
                html+="<span class=\"label label-default\">"+p+"</td>";
            }
        }else{
            html+="<span class=\"label label-default\">undefined</td>";
        }
        html+="</td>";
        //Natural Language
        html+=("<td>");
        if(languages!=null){
            for(String lang: languages){
                html+="<span class=\"label label-primary\">" + lang + "</span>";
            }
        }else{
            html+="<span class=\"label label-default\">Undefined</span>";
        }
        html+="</td>\n"; 
        //format
        if(format!=null && !format.equals("")){
            html+="<td>"+format+"</td>";
        }
        //date
        if(creationDate!=null && !creationDate.equals("")){
            html+="<td>"+creationDate+"</td>";
        }
        //License
        html+=("<td>");
        if (this.licenseTitle == null || this.licenseTitle.toLowerCase().equals("unknown")){      
            html+= "<span class=\"label label-default\">Undefined</span>";        
        }
        else{
           String licenseTitleReduced = licenseTitle.replace("Creative Commons ", "");
           if(licenseTitleReduced.length()>TextConstants.shortLicense){
               licenseTitleReduced = licenseTitleReduced.substring(0, TextConstants.shortLicense-1);
               licenseTitleReduced += "...";
           }
           html+= "<a href=\"" + this.license + "\" target=\"_blank\"> <span class=\"label label-success\">" + licenseTitleReduced + "</span> </a>";        
        }

        html+=("</td>\n");
        html+=("<td>\n");
        //links: download, script, source   
        if(downloadLink!=null && !downloadLink.equals("")){
            html+="<a href=\""+downloadLink+"\"><span class=\"glyphicon glyphicon-download\" aria-hidden=\"true\"></span></a>&nbsp;";
        }
        if(statistics!=null && !statistics.equals("")){
            html+="<a href=\""+statistics+"\"><span class=\"glyphicon glyphicon-stats\" aria-hidden=\"true\"></span></a>&nbsp;";
        }
        if(scriptLink!=null && !scriptLink.equals("")){
            html+="<a href=\""+scriptLink+"\"><span class=\"glyphicon glyphicon-wrench\" aria-hidden=\"true\"></span></a>";
        }
        html+=("</td>\n");
   
        //finish row
        html+=("</tr>");        
        return html;
    }
    
}
