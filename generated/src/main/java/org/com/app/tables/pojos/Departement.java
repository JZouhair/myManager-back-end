/*
 * This file is generated by jOOQ.
*/
package org.com.app.tables.pojos;


import java.io.Serializable;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.8"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Departement implements Serializable {

    private static final long serialVersionUID = 569283323;

    private final Integer id;
    private final String  name;

    public Departement(Departement value) {
        this.id = value.id;
        this.name = value.name;
    }

    public Departement(
        Integer id,
        String  name
    ) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Departement (");

        sb.append(id);
        sb.append(", ").append(name);

        sb.append(")");
        return sb.toString();
    }
}
