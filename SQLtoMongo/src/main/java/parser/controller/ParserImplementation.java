package parser.controller;

import parser.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserImplementation implements Parse {

    private Clause clause = null;
    private WhereClause whereClause = null;
    private String keyword = null;
    private boolean start = false;
    private boolean whereStart = false;
    private SQLQuery clauseList = new SQLQuery();

    public ParserImplementation(String text) {
        try {
            parse(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public boolean isKeyword(String word) {
        return word.equalsIgnoreCase("select") || word.equalsIgnoreCase("from") || word.equalsIgnoreCase("where") || word.equalsIgnoreCase("order_by") || word.equalsIgnoreCase("group_by") || word.equalsIgnoreCase("join");
    }

    @Override
    public void parse(String query) {
        query = query.toLowerCase();
        query = query.replaceAll("order by", "order_by");
        query = query.replaceAll("group by", "group_by");


        String[] words = query.replaceAll(",", " ").trim().split("\\s+");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            switch (word.toLowerCase()) {
                case "select":
                    SelectImplementation select = new SelectImplementation();
                    select.parse(query);
                    clauseList.addClause(select.getSelect());
                    break;
                case "from":
                    if (i+1 < words.length) {
                        String nextWord = words[i+1];
                        FromClause from = new FromClause(nextWord);
                        clauseList.addClause(from);
                    }
                    break;
                case "where":
                    WhereImplementation where = new WhereImplementation();
                    where.parse(query);
                    clauseList.addClause(where.getWhereClause());
                    break;
                case "order_by":
                    OrderByImplementation order = new OrderByImplementation();
                    order.parse(query);
                    clauseList.addClause(order.getOrderByClause());
                break;
            }
        }

    }

    public SQLQuery getClauseList() {
        return this.clauseList;
    }
//            if(isKeyword(word) && keyword == null) {
//                keyword = word.toLowerCase();
//                clause = new Clause(keyword);
//        } else if(isKeyword(word) && keyword != null) {
//                clauseList.getClauses().add(clause);
//                keyword = word.toLowerCase();
//                if(keyword.equalsIgnoreCase("order_by") || keyword.equalsIgnoreCase("group_by")) {
//                    keyword = keyword.replaceAll("_", " ");
//                }
//                clause = new Clause(keyword);
//            } else if(!isKeyword(word)){
//                clause.getParameters().add(word.toLowerCase().trim());
//            }
//        }
//        clauseList.getClauses().add(clause);

}
