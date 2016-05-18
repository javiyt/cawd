package com.victormartin.projectcawd.domain.model;

import lombok.Data;

/**
 * Created by victo on 18/05/2016.
 *
 * It combines the functionality of @ToString, @EqualsAndHashCode, @Getter and @Setter.
 *
 */
@Data(staticConstructor="of")
public class User {
    private String name;
    private String email;
    private String token;
    private String id;
}