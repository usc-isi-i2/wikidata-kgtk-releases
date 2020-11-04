package usc.isi.wikidatadumps;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Class for defining the constants
 * @author mpoveda, dgarijo
 */
public class TextConstants {
	
    public static final String outPath = "";
    //public static final String reportFolder = "report"; //since the report has the same css etc, it will be exported on the same folder
    public static final String reportName = "report";
    public static final String siteName = "index.html";
    public static final String getsiteFolderName(){
        return "site_"+new Date().getTime();
    }
    public static final String vocabResources = "/vocab.zip"; 
    public static final int SHORT_DESC_LENGTH = 60;//140;
    public static final int shortLicense = 30;   
    
    
    public static String getheader (String repoName){
            return "<!DOCTYPE html>\n" + 
			"<html lang=\"en\">\n" + 
			"  <head>\n" + 
			"    <meta charset=\"UTF-8\">\n" + 
			"    <title>"+repoName+"</title>\n" + 
			"    <link rel=\"stylesheet\" href=\"vocab/themes/blue/style.css\" type=\"text/css\" media=\"print, projection, screen\" />\n" +
                        "    <script src=\"vocab/js/jquery.min.js\"></script>\n" +
                        "    <script type=\"text/javascript\" src=\"vocab/js/bootstrap.min.js\"></script>"+
                        "  <script>\n" +
                        "   $(document).ready(function(){ \n" +
                        "         $(\"table\").css(\"visibility\", \"hidden\");\n" +
                        "	    	selectVersion()\n" +
                        "	    	$('[data-toggle=\"tooltip\"]').tooltip(); \n" +
                        "	    } \n" +
                        "   );\n" +
                        "   $(function () {\n" +
                        "  $('[data-toggle=\"tooltip\"]').tooltip()\n" +
                        "})\n" +
                        "    </script>\n" +
                        "    <script>\n" +
                        "    function selectVersion() {\n" +
                        "      //make all invisible\n" +
                        "      $(\"table\").css(\"visibility\", \"hidden\");\n" +
                        "      \n" +
                        "      var id_option =  $(\"#result\").val();\n" +
                        "      $(\"#result_label\").load(\"table-\"+id_option+\".html\"); \n" +
                        "    }\n" +
                        "</script>" +
			"    <link href=\"vocab/css/bootstrap.css\" rel=\"stylesheet\">\n" + 
			"    <style type=\"text/css\">\n" + 
			"      body {\n" + 
			"        padding-top: 60px;\n" + 
			"        padding-bottom: 40px;\n" + 
			"      }\n" + 
			"    </style>\n" + 
			
			"  </head>\n" + 
			"\n" + 
			"  <body>\n" + 
			"\n"; 
    }
			
    public static String getNavBarVocab(String repoName){
        return ""+
                
		    
			"    <div class=\"container\">\n" + 
			"\n" + 
			"      <!-- Jumbotron -->\n" + 
			"      <div class=\"jumbotron\">\n" + 
			"        <h1>Wikidata dumps</h1>\n" + 
			"        <p class=\"lead\">A page for sharing the Wikidata artifacts that are frequently used by the Center on Knowledge Graphs at USC.</p>\n" +
			"      </div>\n" + 
			"      <hr>\n";
    }

    public static final String end = "<hr>\n" +
                    "  <p>\n" +
                    "<span id=\"result_label\"></id>\n" +
                    "</p>" +
                    "      " +
                    "     <footer class=\"footer\">\n" +
                    "	        Latest revision "+(new SimpleDateFormat("MMM d, yyyy", Locale.UK).format(new Date(Calendar.getInstance().getTimeInMillis())))+"\n" +
                    "      </footer>"+
                    "      </div>\n" +
                    "</div> <!-- /container -->\n"+ 
                    "</body>"+
                    "</html>";
                    
    
    public static final String tableHeadVocab= 
                    
                    "<div class=\"row\"> \n"+    
                    "</div>\n"+
                    "<br>\n"+
                    "<table id=\"tablesorter-demo\" class=\"tablesorter table table-hover table-responsive\">\n"+
                    "<thead>\n"+
                    "<tr>\n" +
                    "<th class=\"col-md-2\">Name</th>\n" +
                    "<th class=\"col-md-5\">Description</th>\n" +
                    "<th class=\"col-md-1\">Size</th>\n" +
                    //"<!--<th class=\"col-md-1\">Version </th>\n" +
                    //"<th class=\"col-md-1\">Properties</th>-->\n" +
                    "<th class=\"col-md-1\">Language</th>\n" +
                    "<th class=\"col-md-1\">Format</th>\n" +
                    "<th class=\"col-md-1\">Date</th>\n" +
                    //"<!--<th class=\"col-md-1\">License</th>-->\n" +
                    "<th class=\"col-md-1\">Links</th>"+
                    "</tr>\n"+
                    "</thead>\n"+
                    "<tbody>\n";
    
    
    
    public static final String tableEnd = "</tbody></table><script>\n" +
"$(document).ready(function(){\n" +
"  $('[data-toggle=\"tooltip\"]').tooltip();  \n" +
"});\n" +
"</script>\n";
    
    public static String optionsStart = "<form><div class=\"form-group\">\n" +
"      <label for=\"result\">Select the version of Wikidata your are interested in from the list below:</label>\n" +
"      <select class=\"form-control\" id=\"result\" onchange=\"selectVersion()\">";
    
    public static String addOption(String optionVersion){//, String date){
        return "<option value=\""+optionVersion+"\">Version "+optionVersion+"</option>";
    }
    
    public static String optionsEnd = "</select>\n" +
"      \n" +
"    </div>\n" +
"  </form>";
    //reporting classes, properties, errors
    public enum Warning{LICENCE_NOT_FOUND, LANG_NOT_FOUND, MISSING_TITLE_OR_DESC_FOR_VOCAB,}
    public enum Error{ PARSING_ERR, EXCEPTION_ERROR}
    
    
}
