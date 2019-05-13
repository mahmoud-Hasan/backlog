package com.swf.cairo.backlog.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "task")
public class TaskModel {
	@Id
	private String _id;
	private String name;
	private String owner;
	private String status;
	private Date createdDate;
	private Date updatedDate;
}
