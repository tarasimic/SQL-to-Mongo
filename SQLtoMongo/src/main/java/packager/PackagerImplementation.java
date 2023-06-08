package packager;

import org.bson.Document;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class PackagerImplementation implements Packager{

    private List<Document> documents;

    public PackagerImplementation(List<Document> documents) {
        this.documents = documents;
    }


    @Override
    public DefaultTableModel pack() {
        DefaultTableModel tableModel = new DefaultTableModel();

        // Process the first document to extract the keys and add them as columns to the table model
        if (!documents.isEmpty()) {
            Document firstDocument = documents.get(0);
            for (String key : firstDocument.keySet()) {
                tableModel.addColumn(key);
            }
        }

        // Iterate over each document in the list and extract the values as rows
        for (Document doc : documents) {
            Object[] rowValues = new Object[doc.keySet().size()];
            int i = 0;

            for (String key : doc.keySet()) {
                rowValues[i] = doc.get(key);
                i++;
            }

            tableModel.addRow(rowValues);
        }

        return tableModel;
    }

}




