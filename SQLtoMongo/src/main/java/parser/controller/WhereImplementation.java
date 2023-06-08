package parser.controller;

import parser.model.Condition;
import parser.model.WhereClause;

public class WhereImplementation implements Parse {
    private WhereClause whereClause;

    public WhereImplementation() {
        this.whereClause = new WhereClause();
    }

    public boolean isOperand(String word) {
        return word.equals("=") || word.equals(">") || word.equals("<") || word.equals(">=") || word.equals("<=") || word.equalsIgnoreCase("LIKE") || word.equalsIgnoreCase("IN") || word.equalsIgnoreCase("BETWEEN") || word.equalsIgnoreCase("IS NULL") || word.equalsIgnoreCase("IS NOT NULL");
    }
    @Override
    public void parse(String query) {
        String[] words = query.trim().split("where")[1].trim().split("\\s+");
        Condition condition1 = null;
        Condition condition2 = null;
        boolean isCondition1 = false;
        boolean isCondition2 = false;

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (isOperand(word)) {
                if (!isCondition1) {
                    condition1 = new Condition();
                    condition1.setField(words[i - 1]);
                    condition1.setOperator(word);
                    isCondition1 = true;
                } else {
                    condition2 = new Condition();
                    condition2.setField(words[i - 1]);
                    condition2.setOperator(word);
                    isCondition2 = true;
                }
            } else if (isCondition1 && !isCondition2) {
                condition1.setValue(word);
                whereClause.getConditions().add(condition1);
                isCondition1 = false;
            } else if (isCondition2) {
                condition2.setValue(word);
                whereClause.getConditions().add(condition2);
                isCondition2 = false;
            }
        }
    }



    public WhereClause getWhereClause() {
        return whereClause;
    }
}
