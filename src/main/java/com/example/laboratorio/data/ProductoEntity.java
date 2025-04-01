package com.example.laboratorio.data;


import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "producto")
@Data
public class ProductoEntity {

@Id
@Column(name = "id_producto")
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long idProducto;

@Column(name = "descripcion")
private String descripcion;

@Column(name = "observacion")
private String observacion;

@Column(name = "estado")
private String estado;

@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
private List<InventarioEntity> inventarioProduccion;

@OneToMany(mappedBy = "producto", cascade = CascadeType.ALL, orphanRemoval = true)
private List<DetalleSolicitudEntity> detalleSolicitud;

@Column(name = "tipo")
private String tipo;

}
