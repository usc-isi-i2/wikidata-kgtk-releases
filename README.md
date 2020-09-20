# wikidata-kgtk-releases
Repository to describe the different Wikidata releases in KGTK format that may be reused among projects

We will be updating the KGTK releases for Wikidata files here soon.

## Adding a new file
Simply fill in a new row in the `dumps.csv` file of the repository. Then regenerate the html of the script:

`java -jar WikidataDumps-1.0-SNAPSHOT-jar-with-dependencies.jar -i pathToCSV -o website`

## Website

https://usc-isi-i2.github.io/wikidata-kgtk-releases/website/index.html



