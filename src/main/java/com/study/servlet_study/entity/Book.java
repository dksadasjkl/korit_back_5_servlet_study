package com.study.servlet_study.entity;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Book {
	private String bookName;
	private String authorName;
	private String publisherName;
}
