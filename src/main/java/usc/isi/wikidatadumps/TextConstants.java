package usc.isi.wikidatadumps;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
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
    public static final int SHORT_DESC_LENGTH = 90;//140;
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
			"\n" + 
			"    <!-- Le styles -->\n" + 
			"    <link href=\"vocab/css/bootstrap.css\" rel=\"stylesheet\">\n" + 
			"    <style type=\"text/css\">\n" + 
			"      body {\n" + 
			"        padding-top: 60px;\n" + 
			"        padding-bottom: 40px;\n" + 
			"      }\n" + 
			"    </style>\n" + 
			//"    <link href=\"vocab/css/bootstrap-responsive.css\" rel=\"stylesheet\">\n" + 
			"    \n" + 
			"    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->\n" + 
			"    <!--[if lt IE 9]>\n" + 
			"      <script src=\"vocab/js/html5shiv.js\"></script>\n" + 
			"    <![endif]-->\n" + 
			"\n" + 
			"    <!-- Fav and touch icons -->\n" + 
			"  </head>\n" + 
			"\n" + 
			"  <body>\n" + 
			"\n"; 
    }
			
    public static String getNavBarVocab(String repoName){
        return ""+
                /*"<div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n" + 
		    "  <div class=\"container\">\n" + 
		    "    <div class=\"navbar-header\">\n" + 
		    "      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n" + 
		    "        <span class=\"sr-only\">Toggle navigation</span>\n" + 
		    "        <span class=\"icon-bar\"></span>\n" + 
		    "        <span class=\"icon-bar\"></span>\n" + 
		    "        <span class=\"icon-bar\"></span>\n" + 
		    "      </button>\n" + 
		    "    </div>\n" + 
		    "    <div class=\"collapse navbar-collapse\">\n" + 
		    "      <ul class=\"nav navbar-nav\">\n" + 
		    "        <li class=\"active\"><a href=\"#\">Vocabularies</a></li>\n" + 
		    "        <li><a href=\"report.html\">Vocabulary report</a></li>\n" + 
		    "      </ul>\n" + 
		    "    </div><!--/.nav-collapse -->\n" + 
		    "  </div>\n" + 
		   " </div>\n" + */
		    
			"    <div class=\"container\">\n" + 
			"\n" + 
			"      <!-- Jumbotron -->\n" + 
			"      <div class=\"jumbotron\">\n" + 
			"        <h1>Wikidata dumps</h1>\n" + 
			"        <p class=\"lead\">A page for sharing the Wikidata artifacts that are frequently used by the Center on Knowledge Graphs at USC.</p>\n" +
			"      </div>\n" + 
			"      <hr>\n";
    }
    
    public static final String navBarReport = "<div class=\"navbar navbar-inverse navbar-fixed-top\" role=\"navigation\">\n" +
            /*"  <div class=\"container\">\n" +
            "    <div class=\"navbar-header\">\n" +
            "      <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\".navbar-collapse\">\n" +
            "        <span class=\"sr-only\">Toggle navigation</span>\n" +
            "        <span class=\"icon-bar\"></span>\n" +
            "        <span class=\"icon-bar\"></span>\n" +
            "        <span class=\"icon-bar\"></span>\n" +
            "      </button>\n" +
            "    </div>\n" +
            "    <div class=\"collapse navbar-collapse\">\n" +
            "      <ul class=\"nav navbar-nav\">\n" +
            "        <li ><a href=\"./index.html\">Vocabularies</a></li>\n" +
            "        <li class=\"active\"><a href=\"#\">Vocabulary report</a></li>\n" +
            "      </ul>\n" +
            "    </div><!--/.nav-collapse -->\n" +
            "  </div>\n" +
            " </div>\n" +*/
            "    <div class=\"container\">\n" +
            "\n" +
            "      <!-- Jumbotron -->\n" +
            "      <div class=\"jumbotron\">\n" +
            "         <h1>Wikidata dumps</h1>\n" + 
            "        <p class=\"lead\">A page for sharing the Wikidata artifacts that are frequently used by the Center on Knowledge Graphs at USC.</p>\n" +
            "      </div>";

    public static final String end = "<hr>\n" +
                    "" +
                    //"      <footer class=\"footer\">\n" +
                    "      " +
                    "     <footer class=\"footer\">\n" +
                   /* "            <div class=\"row\">\n" +
                    "    	<div class=\"col-md-10\">\n" +
                    "    		Page created with  <a href = \"https://github.com/dgarijo/vocabLite\" target=\"_blank\">VocabLite</a> (<a href=\"http://oeg-upm.net/\">Ontology Engineering Group</a>)\n" +
                    "	        <br>\n" +
                    "    	Built with <a target=\"_blank\" href=\"http://getbootstrap.com/\">Bootstrap</a>\n" +
                    " 	        <br>\n" +*/
                   // "	        Latest revision August, 2016\n" +
            "	        Latest revision "+(new SimpleDateFormat("MMM d, yyyy", Locale.UK).format(new Date(Calendar.getInstance().getTimeInMillis())))+"\n" +
                   /* "        </div>\n" +
                    "		<div class=\"col-md-2\">\n" +
                    "			<a href=\"https://github.com/dgarijo/vocabLite\"><img width=\"140px\"src=\"vocab/logoLite.png\"></img></a>\n" +
                    "		</div>\n" +*/
                    "      </footer>"+
                    "      </div>\n" +
                    "" +
                    //"      </footer>\n" +
                    "" +
                    "</div> <!-- /container -->\n"+ 
                    " <script>\n" +
                    "$(document).ready(function(){\n" +
                    "  $('[data-toggle=\"tooltip\"]').tooltip();   \n" +
                    "});\n" +
                    "</script>"+
                    "</body>"+
                    "</html>";
                    
    
    public static final String tableHeadVocab= 
                    
                    "<div class=\"row\"> \n"+    
                    "</div>\n"+
                    "<br>\n"+
                    "<table id=\"tablesorter-demo\" class=\"tablesorter table table-hover table-responsive\">\n"+
                    "<thead>\n"+
                    "<tr>\n" +
                    "<th class=\"col-md-1\">Name</th>\n" +
                    "<th class=\"col-md-3\">Description</th>\n" +
                    "<th class=\"col-md-1\">Size</th>\n" +
                    "<th class=\"col-md-1\">Version </th>\n" +
                    "<th class=\"col-md-1\">Properties</th>\n" +
                    "<th class=\"col-md-1\">Language</th>\n" +
                    "<th class=\"col-md-1\">Format</th>\n" +
                    "<th class=\"col-md-1\">Date</th>\n" +
                    "<th class=\"col-md-1\">License</th>\n" +
                    "<th class=\"col-md-1\">Links</th>" +
                    "</tr>\n"+
                    "</thead>\n"+
                    "<tbody>\n";
    
    
    
    public static final String tableEnd = "</tbody></table>\n";
    

//    public static String getScriptForFilteringAndEndDocument(ArrayList<String> domains){
//        String s = "<script>\n"+
//		"$(function() {\n"+
//		"var availableTags = [\n";
//                if(!domains.isEmpty()){
//                    s+="\""+domains.get(0)+"\"\n";
//                    for (int i=1; i<domains.size();i++ ){
//			s+=", \""+domains.get(i)+"\"";
//                    }
//                }
//		s+="];\n"+"$( \"#tags\" ).autocomplete({\n"+
//		"source: availableTags,\n"+
//		"select: function(event, ui) {\n"+		
//		"hideRows(ui.item.value);\n"+
//		"}\n"+
//		"});\n"+
//		"});\n"+
//		"</script>\n"+
//		"<script>\n"+
//		"function hideRows(text) {\n"+
//		"index = 1;\n"+
//		"tr = document.getElementById('tr'+index);\n"+
//		"while (tr!=null){\n"+
//		"valores = document.getElementById('inp'+index).value;\n"+
//		"if (valores.indexOf(text+'--')==-1){\n"+
//		"tr.style.display='none';\n"+
//		"}\n"+
//		"index++;\n"+
//		"tr = document.getElementById('tr'+index);\n"+
//		"}\n"+
//		"document.getElementById('remButt').style.display='';\n"+
//		"}\n"+
//		"\n"+
//		"function showRows() {	\n"+
//		"index = 1;\n"+
//		"tr = document.getElementById('tr'+index);\n"+
//		"while (tr!=null){\n"+
//		"tr.style.display='';\n"+		
//		"index++;\n"+
//		"tr = document.getElementById('tr'+index);\n"+
//		"}\n"+
//		"butt = document.getElementById('remButt').style.display='none';\n"+
//		"}\n"+
//		"</script>"+
//               //to add Google analytics here.
//               // "<script>\n" +
//               // "(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){ (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" +
//               // "m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" +
//               // "})(window,document,'script','//www.google-analytics.com/analytics.js','ga');\n" +
//               // "ga('create', 'UA-48904250-1', 'linkeddata.es');\n" +
//               // "ga('send', 'pageview');\n" +
//               // "</script>\n" +
//                "" +
//                "  </body>\n" +
//                "</html>\n";
//        return s;
//    }
    
    
    //reporting classes, properties, errors
    public enum Warning{LICENCE_NOT_FOUND, LANG_NOT_FOUND, MISSING_TITLE_OR_DESC_FOR_VOCAB,}
    public enum Error{ PARSING_ERR, EXCEPTION_ERROR}
    
    
}
