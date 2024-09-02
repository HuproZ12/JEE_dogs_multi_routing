package Temp;

import lombok.*;
import javax.persistence.*;

@Builder @Data @NoArgsConstructor @AllArgsConstructor
@Entity @Table(name = "chien")

public class Chien {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "id_chien") private int id;
    private String nom;
    private String race;
    private String naissance;
}