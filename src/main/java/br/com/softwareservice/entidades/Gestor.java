package br.com.softwareservice.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value = "Gestor")
@Table(name = "Gestor")
public class Gestor extends Funcionario{

}
