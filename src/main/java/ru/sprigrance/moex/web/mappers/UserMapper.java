package ru.sprigrance.moex.web.mappers;

import ru.sprigrance.moex.domain.user.User;
import ru.sprigrance.moex.web.dto.user.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto> {
}
