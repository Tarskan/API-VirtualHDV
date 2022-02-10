package com.example.demo.tchat;

import com.example.demo.advert.Advert;
import com.example.demo.user.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TchatDTO {
    private Tchat tchat;
    private User vendor;
    private Advert advert;
}
