package gui.controller;

import adapter.AdapterImplementation;
import adapter.conventor.ParametarConventor;
import adapter.mapper.Mapper;
import adapter.mapper.MongoMap;
import com.mongodb.MongoClient;
import database.controller.mongo.MongoConnection;
import executor.ExecutorImplementation;
import gui.view.MainFrame2;
import org.bson.Document;
import packager.PackagerImplementation;
import parser.controller.ParserImplementation;
import parser.model.Clause;
import parser.model.SQLQuery;

import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class SubmitAction implements ActionListener {

    private String text;
    private ParserImplementation parserImplementation;
    private SQLQuery sqlQuery;
    private List<Clause> clauses;
    private ParametarConventor parametarConventor;
    private LinkedHashMap<String, String> paramMap;
    private Mapper mapper;
    private MongoMap mongoMap;
    private LinkedHashMap<String, String> mongoQuery;
    private AdapterImplementation adapterImplementation;

    private MongoClient mongoClient;
    private String query;
    private DefaultTableModel tableModel ;


    private ExecutorImplementation executorImplementation;

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        text = MainFrame2.getInstance().getTextArea().getText();
        parserImplementation = new ParserImplementation(text);
        sqlQuery = parserImplementation.getClauseList();
        clauses = sqlQuery.getClauses();
        for(Clause clause: clauses){
            System.out.println(clause);
        }
        parametarConventor = new ParametarConventor(sqlQuery);
        paramMap = parametarConventor.getParametermap();
        mapper = new Mapper(paramMap);
        mongoMap = mapper.getMongoMap();
        adapterImplementation = new AdapterImplementation(mongoMap.getMongoMap());

        query = adapterImplementation.getMongoQuery();
        mongoClient = new MongoConnection().getConnection();
        executorImplementation = new ExecutorImplementation(query, mongoClient);

        PackagerImplementation packager = new PackagerImplementation(executorImplementation.getDocuments());
        tableModel = packager.pack();
        MainFrame2.getInstance().updateTable(tableModel);
        int rowCount = tableModel.getRowCount();

        System.out.println("Number of rows: " + rowCount);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> { //
            mongoClient.close();
        }));

    }
}