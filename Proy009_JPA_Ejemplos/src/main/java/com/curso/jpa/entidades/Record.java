package com.curso.jpa.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity

public class Record implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CURSO_SEQ")
	@SequenceGenerator(sequenceName = "CURSO_SEQ", name = "CURSO_SEQ", allocationSize=1)	
	@Column(name="RECID")
	private Integer myId;
	@Column(name="RECORD_NAME")
	private String myName;

	public Record()
	{
		
	}
	
	public Record (Integer tmpId, String tmpName)
	{
		super();
		this.myId = tmpId;
		this.myName = tmpName;
	}
}
