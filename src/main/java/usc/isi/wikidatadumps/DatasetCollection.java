package usc.isi.wikidatadumps;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * This class maintains a collection of datasets, grouped by their version.
 * Each dataset collection will be saved in a separate HTML document
 * @author dgarijo
 */
public class DatasetCollection {
    
    HashMap<String,ArrayList<Dataset>> collection; //a collection has a series of versions identified by their version id.

    public DatasetCollection() {
        collection = new HashMap<>();
    }

    public HashMap<String, ArrayList<Dataset>> getCollection() {
        return collection;
    }
    
    
    
    public void addDataset(Dataset d){
        String version = d.getVersion();
        ArrayList<Dataset> datasetsForVersion;
        if(collection.containsKey(version)){
             datasetsForVersion =  collection.get(version);
             datasetsForVersion.add(d);
        }else{
            datasetsForVersion = new ArrayList<>();
            datasetsForVersion.add(d);
            collection.put(version, datasetsForVersion);
        }
    }
    
    
    
}
