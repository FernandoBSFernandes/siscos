package br.com.softwareservice.entidades;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue(value="Tecnico")
@Table(name = "Tecnico")
public class Tecnico extends Funcionario{

}
