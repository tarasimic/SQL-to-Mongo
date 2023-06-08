package parser.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public abstract class Clause {

    private String keyword;

    public Clause(String keyword){
        this.keyword = keyword;
    }


    public String getKeyword() {
        return keyword;
    }

    @Override
    public String toString() {
        return "Clause{" +
                "keyword='" + keyword + '\'' +
                '}';
    }
}
