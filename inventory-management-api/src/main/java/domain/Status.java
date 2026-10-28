package domain;

import domain.enums.UserEnum;

public class Status {

    private final Integer id;
    private final String name;

    public Status(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
