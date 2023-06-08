package parser.controller;

import parser.model.SelectClause;

public class SelectImplementation implements Parse{
    private SelectClause select;

    public SelectImplementation() {
        this.select = new SelectClause();
    }

    @Override
    public void parse(String query) {
        String[] words = query.split("from")[0].replaceAll("select", "").split(",");
        for(String word : words) {
            select.getParameters().add(word.trim());
        }
    }

    public SelectClause getSelect() {
        return select;
    }
}
