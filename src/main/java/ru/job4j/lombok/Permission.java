package ru.job4j.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.Singular;
import lombok.ToString;

import java.util.List;

/** The builderMethodName key specifies the name of the container object creation method.
 *  By default, it is called builder(). */
@Builder(builderMethodName = "of")
@ToString
@Getter
public class Permission {

    private int id;
    private String name;

    /**
     * The @Singular annotation allows you to accumulate individual elements of a collection.
     * If it is removed, then the rules method should accept a list.
     *
     * EXAMPLE
     *
     * var permission = Permission.of()
     *                 .id(1)
     *                 .name("ADMIN")
     *                 .rules("create")
     *                 .rules("update")
     *                 .rules("read")
     *                 .rules("delete")
     *                 .build();
     */
    @Singular("rules")
    private List<String> rules;
}
