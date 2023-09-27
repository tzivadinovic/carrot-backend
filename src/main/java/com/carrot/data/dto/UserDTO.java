package com.carrot.data.dto;

import com.carrot.entity.User;
import lombok.Data;

@Data
public class UserDTO {
    User user;
    Boolean isAdmin;
}
