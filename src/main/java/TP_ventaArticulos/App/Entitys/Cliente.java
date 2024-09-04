package TP_ventaArticulos.App.Entitys;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int dni;
    private String apellido;
    private String name;
    @OneToMany(mappedBy = "cliente")
    @JsonIgnore
    private List<Factura> facturas = new ArrayList<>();
    @OneToOne
    @JoinColumn(name = "domicilio_id")
    @JsonIgnore
    private Domicilio domicilio;

    public Cliente(String name, String apellido, int dni) {
        this.name=name;
        this.apellido=apellido;
        this.dni=dni;
        this.facturas= new ArrayList<>();
    }
}
