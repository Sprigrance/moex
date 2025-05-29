package ru.sprigrance.moex.domain.securities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class SecuritiesTable {

    private MultipartFile file;

}
