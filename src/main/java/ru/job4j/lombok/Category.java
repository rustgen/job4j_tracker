package ru.job4j.lombok;

import lombok.*;

/**-  id field has getter method.
      name field, has both a getter and a setter.
      hashCode and equals method was calculated from the id field
      class has a constructor with an id field. */

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@RequiredArgsConstructor
public class Category {

    @Getter
    @EqualsAndHashCode.Include
    private int id;

    @NonNull
    @Getter
    @Setter
    private String name;
}
