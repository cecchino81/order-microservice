package it.order.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;    
    private String username;    
    private String nome;    
    private String cognome;    
    private String email;
}