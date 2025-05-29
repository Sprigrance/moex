package ru.sprigrance.moex.service;

import ru.sprigrance.moex.domain.user.User;

public interface UserService {

    User getById(Long id);
    User getByUsername(String username);
    User update(User user);
    User create(User user);
    boolean isAssetOwner(Long userId, Long assetId);
    void delete(Long id);

}